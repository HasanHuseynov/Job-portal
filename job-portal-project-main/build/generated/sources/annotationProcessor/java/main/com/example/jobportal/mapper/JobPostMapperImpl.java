package com.example.jobportal.mapper;

import com.example.jobportal.dto.request.JobPostRequest;
import com.example.jobportal.dto.response.CompanyResponse;
import com.example.jobportal.dto.response.JobPostResponse;
import com.example.jobportal.dto.response.bidirectional.JobLocationResp;
import com.example.jobportal.dto.response.bidirectional.JobPostResp;
import com.example.jobportal.entity.Company;
import com.example.jobportal.entity.JobLocation;
import com.example.jobportal.entity.JobPost;
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
public class JobPostMapperImpl implements JobPostMapper {

    private final DatatypeFactory datatypeFactory;

    public JobPostMapperImpl() {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch ( DatatypeConfigurationException ex ) {
            throw new RuntimeException( ex );
        }
    }

    @Override
    public JobPost fromDTO(JobPostRequest jobPostRequest) {
        if ( jobPostRequest == null ) {
            return null;
        }

        JobPost jobPost = new JobPost();

        jobPost.setJobPostId( jobPostRequest.getJobPostId() );
        jobPost.setCreatedDate( jobPostRequest.getCreatedDate() );
        jobPost.setJobDescription( jobPostRequest.getJobDescription() );
        jobPost.setSalary( jobPostRequest.getSalary() );
        jobPost.setPriority( jobPostRequest.getPriority() );
        jobPost.setStatus( jobPostRequest.getStatus() );
        jobPost.setExpirationDate( jobPostRequest.getExpirationDate() );
        jobPost.setMajor( jobPostRequest.getMajor() );
        jobPost.setPromotionEndDate( jobPostRequest.getPromotionEndDate() );

        return jobPost;
    }

    @Override
    public JobPostResponse toDTO(JobPost jobPost) {
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

    @Override
    public List<JobPostResponse> toDTOs(List<JobPost> jobPosts) {
        if ( jobPosts == null ) {
            return null;
        }

        List<JobPostResponse> list = new ArrayList<JobPostResponse>( jobPosts.size() );
        for ( JobPost jobPost : jobPosts ) {
            list.add( toDTO( jobPost ) );
        }

        return list;
    }

    @Override
    public void mapUpdateRequestToEntity(JobPost jobPost, JobPostRequest jobPostRequest) {
        if ( jobPostRequest == null ) {
            return;
        }

        jobPost.setJobPostId( jobPostRequest.getJobPostId() );
        jobPost.setCreatedDate( jobPostRequest.getCreatedDate() );
        jobPost.setJobDescription( jobPostRequest.getJobDescription() );
        jobPost.setSalary( jobPostRequest.getSalary() );
        jobPost.setPriority( jobPostRequest.getPriority() );
        jobPost.setStatus( jobPostRequest.getStatus() );
        jobPost.setExpirationDate( jobPostRequest.getExpirationDate() );
        jobPost.setMajor( jobPostRequest.getMajor() );
        jobPost.setPromotionEndDate( jobPostRequest.getPromotionEndDate() );
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
}
