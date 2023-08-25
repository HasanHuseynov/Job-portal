package com.example.jobportal.mapper;

import com.example.jobportal.dto.request.UserRequest;
import com.example.jobportal.dto.response.EducationDetailResponse;
import com.example.jobportal.dto.response.ExperienceDetailResponse;
import com.example.jobportal.dto.response.UserLogResponse;
import com.example.jobportal.dto.response.UserResponse;
import com.example.jobportal.dto.response.bidirectional.JobPostActivityResp;
import com.example.jobportal.dto.response.bidirectional.SeekerProfileResp;
import com.example.jobportal.entity.EducationDetail;
import com.example.jobportal.entity.ExperienceDetail;
import com.example.jobportal.entity.JobPostActivity;
import com.example.jobportal.entity.SeekerProfile;
import com.example.jobportal.entity.User;
import com.example.jobportal.entity.UserLog;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-25T02:24:51+0400",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User fromDTO(UserRequest userRequest) {
        if ( userRequest == null ) {
            return null;
        }

        User user = new User();

        user.setId( userRequest.getId() );
        user.setEmail( userRequest.getEmail() );
        user.setPassword( userRequest.getPassword() );
        user.setDateOfBirth( userRequest.getDateOfBirth() );
        user.setGender( userRequest.getGender() );
        user.setStatus( userRequest.getStatus() );
        user.setContactNumber( userRequest.getContactNumber() );
        user.setRegistrationDate( userRequest.getRegistrationDate() );

        return user;
    }

    @Override
    public UserResponse toDTO(User user) {
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

    @Override
    public List<UserResponse> toDTOs(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserResponse> list = new ArrayList<UserResponse>( users.size() );
        for ( User user : users ) {
            list.add( toDTO( user ) );
        }

        return list;
    }

    @Override
    public void mapUpdateRequestToEntity(User user, UserRequest userRequest) {
        if ( userRequest == null ) {
            return;
        }

        user.setId( userRequest.getId() );
        user.setEmail( userRequest.getEmail() );
        user.setPassword( userRequest.getPassword() );
        user.setDateOfBirth( userRequest.getDateOfBirth() );
        user.setGender( userRequest.getGender() );
        user.setStatus( userRequest.getStatus() );
        user.setContactNumber( userRequest.getContactNumber() );
        user.setRegistrationDate( userRequest.getRegistrationDate() );
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
}
