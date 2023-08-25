package com.example.jobportal.mapper;

import com.example.jobportal.dto.request.CompanyRequest;
import com.example.jobportal.dto.response.CompanyResponse;
import com.example.jobportal.dto.response.bidirectional.JobPostResp;
import com.example.jobportal.entity.Company;
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
public class CompanyMapperImpl implements CompanyMapper {

    private final DatatypeFactory datatypeFactory;

    public CompanyMapperImpl() {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch ( DatatypeConfigurationException ex ) {
            throw new RuntimeException( ex );
        }
    }

    @Override
    public Company fromDTO(CompanyRequest companyRequest) {
        if ( companyRequest == null ) {
            return null;
        }

        Company company = new Company();

        company.setId( companyRequest.getId() );
        company.setCompanyEmail( companyRequest.getCompanyEmail() );
        company.setCompanyName( companyRequest.getCompanyName() );
        company.setProfileDescription( companyRequest.getProfileDescription() );
        company.setEstablishmentDate( companyRequest.getEstablishmentDate() );
        company.setBalance( companyRequest.getBalance() );

        return company;
    }

    @Override
    public CompanyResponse toDTO(Company company) {
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

    @Override
    public List<CompanyResponse> toDTOs(List<Company> companies) {
        if ( companies == null ) {
            return null;
        }

        List<CompanyResponse> list = new ArrayList<CompanyResponse>( companies.size() );
        for ( Company company : companies ) {
            list.add( toDTO( company ) );
        }

        return list;
    }

    @Override
    public Company mapUpdateRequestToEntity(Company company, CompanyRequest companyRequest) {
        if ( companyRequest == null ) {
            return company;
        }

        company.setId( companyRequest.getId() );
        company.setCompanyEmail( companyRequest.getCompanyEmail() );
        company.setCompanyName( companyRequest.getCompanyName() );
        company.setProfileDescription( companyRequest.getProfileDescription() );
        company.setEstablishmentDate( companyRequest.getEstablishmentDate() );
        company.setBalance( companyRequest.getBalance() );

        return company;
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
}
