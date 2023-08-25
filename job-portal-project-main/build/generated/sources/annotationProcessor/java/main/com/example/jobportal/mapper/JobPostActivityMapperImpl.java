package com.example.jobportal.mapper;

import com.example.jobportal.dto.request.JobPostActivityRequest;
import com.example.jobportal.dto.response.CompanyResponse;
import com.example.jobportal.dto.response.EducationDetailResponse;
import com.example.jobportal.dto.response.ExperienceDetailResponse;
import com.example.jobportal.dto.response.JobPostActivityResponse;
import com.example.jobportal.dto.response.JobPostResponse;
import com.example.jobportal.dto.response.UserLogResponse;
import com.example.jobportal.dto.response.UserResponse;
import com.example.jobportal.dto.response.bidirectional.JobLocationResp;
import com.example.jobportal.dto.response.bidirectional.JobPostActivityResp;
import com.example.jobportal.dto.response.bidirectional.JobPostResp;
import com.example.jobportal.dto.response.bidirectional.SeekerProfileResp;
import com.example.jobportal.entity.Company;
import com.example.jobportal.entity.EducationDetail;
import com.example.jobportal.entity.ExperienceDetail;
import com.example.jobportal.entity.JobLocation;
import com.example.jobportal.entity.JobPost;
import com.example.jobportal.entity.JobPostActivity;
import com.example.jobportal.entity.SeekerProfile;
import com.example.jobportal.entity.User;
import com.example.jobportal.entity.UserLog;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-25T02:24:51+0400",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class JobPostActivityMapperImpl implements JobPostActivityMapper {

    private final DatatypeFactory datatypeFactory;

    public JobPostActivityMapperImpl() {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch ( DatatypeConfigurationException ex ) {
            throw new RuntimeException( ex );
        }
    }

    @Override
    public JobPostActivity fromDTO(JobPostActivityRequest jobPostActivityRequest) {
        if ( jobPostActivityRequest == null ) {
            return null;
        }

        JobPostActivity jobPostActivity = new JobPostActivity();

        jobPostActivity.setJobPostActivityId( jobPostActivityRequest.getJobPostActivityId() );
        jobPostActivity.setApplyDate( jobPostActivityRequest.getApplyDate() );

        return jobPostActivity;
    }

    @Override
    public JobPostActivityResponse toDTO(JobPostActivity jobPostActivity) {
        if ( jobPostActivity == null ) {
            return null;
        }

        JobPostActivityResponse jobPostActivityResponse = new JobPostActivityResponse();

        jobPostActivityResponse.setJobPostActivityId( jobPostActivity.getJobPostActivityId() );
        jobPostActivityResponse.setApplyDate( jobPostActivity.getApplyDate() );
        jobPostActivityResponse.setUser( userToUserResponse( jobPostActivity.getUser() ) );
        jobPostActivityResponse.setJobPost( jobPostToJobPostResponse( jobPostActivity.getJobPost() ) );

        return jobPostActivityResponse;
    }

    @Override
    public List<JobPostActivityResponse> toDTOs(List<JobPostActivity> jobPostActivities) {
        if ( jobPostActivities == null ) {
            return null;
        }

        List<JobPostActivityResponse> list = new ArrayList<JobPostActivityResponse>( jobPostActivities.size() );
        for ( JobPostActivity jobPostActivity : jobPostActivities ) {
            list.add( toDTO( jobPostActivity ) );
        }

        return list;
    }

    @Override
    public void mapUpdateRequestToEntity(JobPostActivity jobPostActivity, JobPostActivityRequest jobPostActivityRequest) {
        if ( jobPostActivityRequest == null ) {
            return;
        }

        jobPostActivity.setJobPostActivityId( jobPostActivityRequest.getJobPostActivityId() );
        jobPostActivity.setApplyDate( jobPostActivityRequest.getApplyDate() );
    }

    private XMLGregorianCalendar localDateTimeToXmlGregorianCalendar( LocalDateTime localDateTime ) {
        if ( localDateTime == null ) {
            return null;
        }

        return datatypeFactory.newXMLGregorianCalendar(
            localDateTime.getYear(),
            localDateTime.getMonthValue(),
            localDateTime.getDayOfMonth(),
            localDateTime.getHour(),
            localDateTime.getMinute(),
            localDateTime.getSecond(),
            localDateTime.get( ChronoField.MILLI_OF_SECOND ),
            DatatypeConstants.FIELD_UNDEFINED );
    }

    private static LocalDate xmlGregorianCalendarToLocalDate( XMLGregorianCalendar xcal ) {
        if ( xcal == null ) {
            return null;
        }

        return LocalDate.of( xcal.getYear(), xcal.getMonth(), xcal.getDay() );
    }

    protected UserLogResponse userLogToUserLogResponse(UserLog userLog) {
        if ( userLog == null ) {
            return null;
        }

        UserLogResponse userLogResponse = new UserLogResponse();

        userLogResponse.setUserLogId( userLog.getUserLogId() );
        userLogResponse.setLastLoginDate( userLog.getLastLoginDate() );

        return userLogResponse;
    }

    protected List<UserLogResponse> userLogListToUserLogResponseList(List<UserLog> list) {
        if ( list == null ) {
            return null;
        }

        List<UserLogResponse> list1 = new ArrayList<UserLogResponse>( list.size() );
        for ( UserLog userLog : list ) {
            list1.add( userLogToUserLogResponse( userLog ) );
        }

        return list1;
    }

    protected EducationDetailResponse educationDetailToEducationDetailResponse(EducationDetail educationDetail) {
        if ( educationDetail == null ) {
            return null;
        }

        EducationDetailResponse educationDetailResponse = new EducationDetailResponse();

        educationDetailResponse.setEducationDetailId( educationDetail.getEducationDetailId() );
        educationDetailResponse.setMajor( educationDetail.getMajor() );
        educationDetailResponse.setCertificateDegreeName( educationDetail.getCertificateDegreeName() );
        educationDetailResponse.setUniversityName( educationDetail.getUniversityName() );
        educationDetailResponse.setStartingDate( educationDetail.getStartingDate() );
        educationDetailResponse.setCompletionDate( educationDetail.getCompletionDate() );
        educationDetailResponse.setDegree( educationDetail.getDegree() );
        educationDetailResponse.setGpa( educationDetail.getGpa() );

        return educationDetailResponse;
    }

    protected List<EducationDetailResponse> educationDetailListToEducationDetailResponseList(List<EducationDetail> list) {
        if ( list == null ) {
            return null;
        }

        List<EducationDetailResponse> list1 = new ArrayList<EducationDetailResponse>( list.size() );
        for ( EducationDetail educationDetail : list ) {
            list1.add( educationDetailToEducationDetailResponse( educationDetail ) );
        }

        return list1;
    }

    protected ExperienceDetailResponse experienceDetailToExperienceDetailResponse(ExperienceDetail experienceDetail) {
        if ( experienceDetail == null ) {
            return null;
        }

        ExperienceDetailResponse experienceDetailResponse = new ExperienceDetailResponse();

        experienceDetailResponse.setExperienceId( experienceDetail.getExperienceId() );
        experienceDetailResponse.setIsCurrentJob( experienceDetail.getIsCurrentJob() );
        experienceDetailResponse.setStartDate( experienceDetail.getStartDate() );
        experienceDetailResponse.setEndDate( experienceDetail.getEndDate() );
        experienceDetailResponse.setJobTitle( experienceDetail.getJobTitle() );
        experienceDetailResponse.setCompanyName( experienceDetail.getCompanyName() );
        experienceDetailResponse.setJobLocationCity( experienceDetail.getJobLocationCity() );
        experienceDetailResponse.setJobLocationState( experienceDetail.getJobLocationState() );
        experienceDetailResponse.setJobLocationCountry( experienceDetail.getJobLocationCountry() );
        experienceDetailResponse.setDescription( experienceDetail.getDescription() );

        return experienceDetailResponse;
    }

    protected List<ExperienceDetailResponse> experienceDetailListToExperienceDetailResponseList(List<ExperienceDetail> list) {
        if ( list == null ) {
            return null;
        }

        List<ExperienceDetailResponse> list1 = new ArrayList<ExperienceDetailResponse>( list.size() );
        for ( ExperienceDetail experienceDetail : list ) {
            list1.add( experienceDetailToExperienceDetailResponse( experienceDetail ) );
        }

        return list1;
    }

    protected SeekerProfileResp seekerProfileToSeekerProfileResp(SeekerProfile seekerProfile) {
        if ( seekerProfile == null ) {
            return null;
        }

        SeekerProfileResp seekerProfileResp = new SeekerProfileResp();

        seekerProfileResp.setSeekerId( seekerProfile.getSeekerId() );
        seekerProfileResp.setFirstName( seekerProfile.getFirstName() );
        seekerProfileResp.setLastName( seekerProfile.getLastName() );
        seekerProfileResp.setEducationDetails( educationDetailListToEducationDetailResponseList( seekerProfile.getEducationDetails() ) );
        seekerProfileResp.setExperienceDetails( experienceDetailListToExperienceDetailResponseList( seekerProfile.getExperienceDetails() ) );
        seekerProfileResp.setMajor( seekerProfile.getMajor() );

        return seekerProfileResp;
    }

    protected JobPostActivityResp jobPostActivityToJobPostActivityResp(JobPostActivity jobPostActivity) {
        if ( jobPostActivity == null ) {
            return null;
        }

        JobPostActivityResp jobPostActivityResp = new JobPostActivityResp();

        jobPostActivityResp.setJobPostActivityId( jobPostActivity.getJobPostActivityId() );
        jobPostActivityResp.setApplyDate( jobPostActivity.getApplyDate() );

        return jobPostActivityResp;
    }

    protected List<JobPostActivityResp> jobPostActivityListToJobPostActivityRespList(List<JobPostActivity> list) {
        if ( list == null ) {
            return null;
        }

        List<JobPostActivityResp> list1 = new ArrayList<JobPostActivityResp>( list.size() );
        for ( JobPostActivity jobPostActivity : list ) {
            list1.add( jobPostActivityToJobPostActivityResp( jobPostActivity ) );
        }

        return list1;
    }

    protected UserResponse userToUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        if ( user.getId() != null ) {
            userResponse.setId( user.getId() );
        }
        userResponse.setEmail( user.getEmail() );
        userResponse.setPassword( user.getPassword() );
        userResponse.setDateOfBirth( user.getDateOfBirth() );
        userResponse.setGender( user.getGender() );
        userResponse.setStatus( user.getStatus() );
        userResponse.setContactNumber( user.getContactNumber() );
        userResponse.setRegistrationDate( user.getRegistrationDate() );
        userResponse.setUserLogs( userLogListToUserLogResponseList( user.getUserLogs() ) );
        userResponse.setSeekerProfile( seekerProfileToSeekerProfileResp( user.getSeekerProfile() ) );
        userResponse.setJobPostActivities( jobPostActivityListToJobPostActivityRespList( user.getJobPostActivities() ) );

        return userResponse;
    }

    protected JobPostResp jobPostToJobPostResp(JobPost jobPost) {
        if ( jobPost == null ) {
            return null;
        }

        JobPostResp jobPostResp = new JobPostResp();

        jobPostResp.setJobPostId( jobPost.getJobPostId() );
        jobPostResp.setCreatedDate( jobPost.getCreatedDate() );
        jobPostResp.setPriority( jobPost.getPriority() );
        jobPostResp.setJobDescription( jobPost.getJobDescription() );
        jobPostResp.setStatus( jobPost.getStatus() );
        jobPostResp.setExpirationDate( jobPost.getExpirationDate() );
        jobPostResp.setSalary( jobPost.getSalary() );
        jobPostResp.setPromotionEndDate( xmlGregorianCalendarToLocalDate( localDateTimeToXmlGregorianCalendar( jobPost.getPromotionEndDate() ) ) );
        jobPostResp.setMajor( jobPost.getMajor() );

        return jobPostResp;
    }

    protected List<JobPostResp> jobPostListToJobPostRespList(List<JobPost> list) {
        if ( list == null ) {
            return null;
        }

        List<JobPostResp> list1 = new ArrayList<JobPostResp>( list.size() );
        for ( JobPost jobPost : list ) {
            list1.add( jobPostToJobPostResp( jobPost ) );
        }

        return list1;
    }

    protected CompanyResponse companyToCompanyResponse(Company company) {
        if ( company == null ) {
            return null;
        }

        CompanyResponse companyResponse = new CompanyResponse();

        companyResponse.setId( company.getId() );
        companyResponse.setCompanyName( company.getCompanyName() );
        companyResponse.setProfileDescription( company.getProfileDescription() );
        companyResponse.setCompanyEmail( company.getCompanyEmail() );
        companyResponse.setEstablishmentDate( company.getEstablishmentDate() );
        companyResponse.setBalance( company.getBalance() );
        companyResponse.setJobPosts( jobPostListToJobPostRespList( company.getJobPosts() ) );

        return companyResponse;
    }

    protected JobLocationResp jobLocationToJobLocationResp(JobLocation jobLocation) {
        if ( jobLocation == null ) {
            return null;
        }

        JobLocationResp jobLocationResp = new JobLocationResp();

        jobLocationResp.setJobLocationId( jobLocation.getJobLocationId() );
        jobLocationResp.setStreetAddress( jobLocation.getStreetAddress() );
        jobLocationResp.setCity( jobLocation.getCity() );
        jobLocationResp.setState( jobLocation.getState() );
        jobLocationResp.setCountry( jobLocation.getCountry() );
        jobLocationResp.setZip( jobLocation.getZip() );

        return jobLocationResp;
    }

    protected JobPostResponse jobPostToJobPostResponse(JobPost jobPost) {
        if ( jobPost == null ) {
            return null;
        }

        JobPostResponse jobPostResponse = new JobPostResponse();

        jobPostResponse.setJobPostId( jobPost.getJobPostId() );
        jobPostResponse.setCreatedDate( jobPost.getCreatedDate() );
        jobPostResponse.setPriority( jobPost.getPriority() );
        jobPostResponse.setJobDescription( jobPost.getJobDescription() );
        jobPostResponse.setStatus( jobPost.getStatus() );
        jobPostResponse.setExpirationDate( jobPost.getExpirationDate() );
        jobPostResponse.setSalary( jobPost.getSalary() );
        jobPostResponse.setMajor( jobPost.getMajor() );
        jobPostResponse.setCompany( companyToCompanyResponse( jobPost.getCompany() ) );
        jobPostResponse.setPromotionEndDate( xmlGregorianCalendarToLocalDate( localDateTimeToXmlGregorianCalendar( jobPost.getPromotionEndDate() ) ) );
        jobPostResponse.setJobLocation( jobLocationToJobLocationResp( jobPost.getJobLocation() ) );

        return jobPostResponse;
    }
}
