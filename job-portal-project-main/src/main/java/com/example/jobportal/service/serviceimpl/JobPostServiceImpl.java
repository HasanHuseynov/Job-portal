/**
 * In this class we will find the jobs which expire
 * within 3 days,
 */
package com.example.jobportal.service.serviceimpl;

import com.example.jobportal.dto.SearchCriteriaDTO;
import com.example.jobportal.dto.request.JobPostRequest;
import com.example.jobportal.dto.response.JobPostResponse;
import com.example.jobportal.entity.Company;
import com.example.jobportal.entity.JobPost;
import com.example.jobportal.entity.SeekerProfile;
import com.example.jobportal.enums.JobPostPriority;
import com.example.jobportal.enums.JobPostStatus;
import com.example.jobportal.exception.InsuffucientBalanceException;
import com.example.jobportal.exception.NotDataFound;
import com.example.jobportal.mapper.JobPostMapper;
import com.example.jobportal.repository.CompanyRepository;
import com.example.jobportal.repository.JobPostRepository;
import com.example.jobportal.repository.SeekerProfileRepository;
import com.example.jobportal.service.JobPostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class JobPostServiceImpl implements JobPostService {
    private final JobPostRepository jobPostRepository;
    private final JobPostMapper jobPostMapper;
    private final EmailServiceImpl emailService;

    private final CompanyRepository companyRepository;


    private final SeekerProfileRepository seekerProfileRepository;

    @Override
    public Page<JobPostResponse> getAllJobPosts(Pageable pageable) {
        var jobEntity = jobPostRepository.findAll(PageRequest.of(0, 4, Sort.by(Sort.Direction.ASC, "priority")));
        return jobPostMapper.toDTOp(jobEntity);
    }

    @Override
    public Page<JobPostResponse> getAllActiveJobs(Pageable pageable) {
        var jobEntity = jobPostRepository.findAll(PageRequest.of(0, 4, Sort.by(Sort.Direction.ASC, "priority")));
        return jobPostMapper.toDTOp(jobEntity);
    }

    @Override
    public Optional<JobPostResponse> getJobById(Integer id) {
        var jobPost = jobPostRepository.findJobPostsByJobPostId(id).orElseThrow(() -> new NotDataFound("Not user found"));
        var jobPostEntity = jobPostMapper.toDTO(jobPost);
        return Optional.ofNullable(jobPostEntity);
    }

    @Override
    public List<JobPost> findJobPostsExpiringWithinThreeDays() {
        LocalDate endDate = LocalDate.now().plusDays(3L);
        return jobPostRepository.findJobPostsByExpirationDateBetween(LocalDate.now(), endDate);
    }

    @Override
    public void findMatchingUsers(LocalDate startDate, LocalDate endDate) {
        List<JobPost> jobPosts = jobPostRepository.findJobPostsByExpirationDateBetween(startDate, endDate);
        List<SeekerProfile> seekerProfiles = seekerProfileRepository.findAll();

        for (JobPost jobPost : jobPosts) {
            for (SeekerProfile seekerProfile : seekerProfiles) {
                if (jobPost.getMajor().equalsIgnoreCase(seekerProfile.getMajor())) {
                    var userEntity = seekerProfile.getUser();
                    emailService.sendPromotionEmail(jobPost, userEntity.getEmail());
                }
            }
        }
    }

    @Override
    public JobPostResponse createNewJobPost(JobPostRequest jobPostRequest) {
        JobPost jobPostEntity = jobPostMapper.fromDTO(jobPostRequest);
        jobPostEntity.setStatus(String.valueOf(JobPostStatus.ACTIVE));
        jobPostEntity = jobPostRepository.save(jobPostEntity);
        return jobPostMapper.toDTO(jobPostEntity);
    }

    @Override
    public void deleteById(Integer id) {
        JobPost jobPostEntity = jobPostRepository.findById(id).orElseThrow(() -> new NotDataFound("Job post not found with id: " + id));
        jobPostRepository.delete(jobPostEntity);
    }

    @Override
    public void deactivateExpiredJobPosts() {
        List<JobPost> expiredJobPosts = jobPostRepository.findExpiredJobPosts(LocalDate.now());
        expiredJobPosts.forEach((jobPost) -> {
            jobPost.setStatus(String.valueOf(JobPostStatus.DEACTIVE));
        });
        jobPostRepository.saveAll(expiredJobPosts);
    }

    @Override
    public void updateJobPost(Integer id, JobPostRequest jobPostRequest) {
        var jobPostEntity = jobPostRepository.findById(id)
                .orElseThrow(() -> new NotDataFound("Job post not found"));

        jobPostMapper.mapUpdateRequestToEntity(jobPostEntity, jobPostRequest);
        jobPostRepository.save(jobPostEntity);
    }

    @Override
    public List<JobPost> searchJobPosts(SearchCriteriaDTO searchCriteria) {
        Specification<JobPost> specification = Specification.where(null);

        if (searchCriteria.getJobLocationId() != null) {
            specification = specification.and((root, query, builder) ->
                    builder.equal(root.get("jobLocation").get("id"), searchCriteria.getJobLocationId()));
        }

        if (searchCriteria.getJobTypeId() != null) {
            specification = specification.and((root, query, builder) ->
                    builder.equal(root.get("jobType").get("id"), searchCriteria.getJobTypeId()));
        }

        if (searchCriteria.getCompanyId() != null) {
            specification = specification.and((root, query, builder) ->
                    builder.equal(root.get("company").get("id"), searchCriteria.getCompanyId()));
        }

        if (searchCriteria.getMajor() != null) {
            specification = specification.and((root, query, builder) ->
                    builder.equal(root.get("major"), searchCriteria.getMajor()));
        }

        if (searchCriteria.getSalary() != null) {
            specification = specification.and((root, query, builder) ->
                    builder.equal(root.get("status"), searchCriteria.getSalary()));
        }

        if (searchCriteria.getCreatedDate() != null) {
            specification = specification.and((root, query, builder) ->
                    builder.equal(root.get("createdDate"), searchCriteria.getCreatedDate()));
        }

        if (searchCriteria.getJobDescription() != null) {
            specification = specification.and((root, query, builder) ->
                    builder.equal(root.get("jobDescription"), searchCriteria.getJobDescription()));
        }

        if (searchCriteria.getSalary() != null) {
            specification = specification.and((root, query, builder) ->
                    builder.equal(root.get("salary"), searchCriteria.getSalary()));
        }

        if (searchCriteria.getExpirationDate() != null) {
            specification = specification.and((root, query, builder) ->
                    builder.equal(root.get("expirationDate"), searchCriteria.getExpirationDate()));
        }

        return jobPostRepository.findAll(specification);
    }

    @Override
    public void promoteJobPost(Integer id) {
        JobPost jobPost = jobPostRepository.findById(id).orElseThrow(() -> new NotDataFound("No data found"));
        Company company = jobPost.getCompany();
        if (company.getBalance() < 10) {
            jobPost.setPriority(String.valueOf(JobPostPriority.STANDART));
            throw new InsuffucientBalanceException("Not enough balance");
        } else {
            LocalDateTime promotionEndDate = LocalDateTime.now().plusHours(24);

            jobPost.setPromotionEndDate(promotionEndDate);

            company.setBalance(company.getBalance() - 10);

            jobPost.setPriority(String.valueOf(JobPostPriority.HIGH));


        }
        companyRepository.save(company);
        jobPostRepository.save(jobPost);

    }


}
