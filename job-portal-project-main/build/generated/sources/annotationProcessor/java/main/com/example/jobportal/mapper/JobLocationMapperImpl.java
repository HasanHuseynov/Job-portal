package com.example.jobportal.mapper;

import com.example.jobportal.dto.request.JobLocationRequest;
import com.example.jobportal.dto.response.CompanyResponse;
import com.example.jobportal.dto.response.JobLocationResponse;
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
public class JobLocationMapperImpl implements JobLocationMapper {

    private final DatatypeFactory datatypeFactory;

    public JobLocationMapperImpl() {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch ( DatatypeConfigurationException ex ) {
            throw new RuntimeException( ex );
        }
    }

    @Override
    public JobLocation fromDTO(JobLocationRequest jobLocationRequest) {
        if ( jobLocationRequest == null ) {
            return null;
        }

        JobLocation jobLocation = new JobLocation();

        jobLocation.setJobLocationId( jobLocationRequest.getJobLocationId() );
        jobLocation.setStreetAddress( jobLocationRequest.getStreetAddress() );
        jobLocation.setCity( jobLocationRequest.getCity() );
        jobLocation.setState( jobLocationRequest.getState() );
        jobLocation.setCountry( jobLocationRequest.getCountry() );
        jobLocation.setZip( jobLocationRequest.getZip() );

        return jobLocation;
    }

    @Override
    public JobLocationResponse toDTO(JobLocation jobLocation) {
        if ( jobLocation == null ) {
            return null;
        }

        JobLocationResponse jobLocationResponse = new JobLocationResponse();

        jobLocationResponse.setJobLocationId( jobLocation.getJobLocationId() );
        jobLocationResponse.setStreetAddress( jobLocation.getStreetAddress() );
        jobLocationResponse.setCity( jobLocation.getCity() );
        jobLocationResponse.setState( jobLocation.getState() );
        jobLocationResponse.setCountry( jobLocation.getCountry() );
        jobLocationResponse.setZip( jobLocation.getZip() );
        jobLocationResponse.setJobPost( jobPostListToJobPostResponseList( jobLocation.getJobPost() ) );

        return jobLocationResponse;
    }

    @Override
    public List<JobLocationResponse> toDTOs(List<JobLocation> jobLocations) {
        if ( jobLocations == null ) {
            return null;
        }

        List<JobLocationResponse> list = new ArrayList<JobLocationResponse>( jobLocations.size() );
        for ( JobLocation jobLocation : jobLocations ) {
            list.add( toDTO( jobLocation ) );
        }

        return list;
    }

    @Override
    public void mapUpdateRequestToEntity(JobLocation jobLocation, JobLocationRequest jobLocationRequest) {
        if ( jobLocationRequest == null ) {
            return;
        }

        jobLocation.setJobLocationId( jobLocationRequest.getJobLocationId() );
        jobLocation.setStreetAddress( jobLocationRequest.getStreetAddress() );
        jobLocation.setCity( jobLocationRequest.getCity() );
        jobLocation.setState( jobLocationRequest.getState() );
        jobLocation.setCountry( jobLocationRequest.getCountry() );
        jobLocation.setZip( jobLocationRequest.getZip() );
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

    protected List<JobPostResponse> jobPostListToJobPostResponseList(List<JobPost> list) {
        if ( list == null ) {
            return null;
        }

        List<JobPostResponse> list1 = new ArrayList<JobPostResponse>( list.size() );
        for ( JobPost jobPost : list ) {
            list1.add( jobPostToJobPostResponse( jobPost ) );
        }

        return list1;
    }
}
