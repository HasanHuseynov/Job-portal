package com.example.jobportal.mapper;

import com.example.jobportal.dto.request.EducationDetailRequest;
import com.example.jobportal.dto.response.EducationDetailResponse;
import com.example.jobportal.entity.EducationDetail;
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
public class EducationDetailMapperImpl implements EducationDetailMapper {

    @Override
    public EducationDetail fromDTO(EducationDetailRequest educationDetailRequest) {
        if ( educationDetailRequest == null ) {
            return null;
        }

        EducationDetail educationDetail = new EducationDetail();

        educationDetail.setEducationDetailId( educationDetailRequest.getEducationDetailId() );
        educationDetail.setMajor( educationDetailRequest.getMajor() );
        educationDetail.setCertificateDegreeName( educationDetailRequest.getCertificateDegreeName() );
        educationDetail.setUniversityName( educationDetailRequest.getUniversityName() );
        educationDetail.setStartingDate( educationDetailRequest.getStartingDate() );
        educationDetail.setCompletionDate( educationDetailRequest.getCompletionDate() );
        educationDetail.setDegree( educationDetailRequest.getDegree() );
        educationDetail.setGpa( educationDetailRequest.getGpa() );

        return educationDetail;
    }

    @Override
    public EducationDetailResponse toDTO(EducationDetail educationDetail) {
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

    @Override
    public List<EducationDetailResponse> toDTOs(List<EducationDetail> educationDetails) {
        if ( educationDetails == null ) {
            return null;
        }

        List<EducationDetailResponse> list = new ArrayList<EducationDetailResponse>( educationDetails.size() );
        for ( EducationDetail educationDetail : educationDetails ) {
            list.add( toDTO( educationDetail ) );
        }

        return list;
    }

    @Override
    public void mapUpdateRequestToEntity(EducationDetail educationDetail, EducationDetailRequest educationDetailRequest) {
        if ( educationDetailRequest == null ) {
            return;
        }

        educationDetail.setEducationDetailId( educationDetailRequest.getEducationDetailId() );
        educationDetail.setMajor( educationDetailRequest.getMajor() );
        educationDetail.setCertificateDegreeName( educationDetailRequest.getCertificateDegreeName() );
        educationDetail.setUniversityName( educationDetailRequest.getUniversityName() );
        educationDetail.setStartingDate( educationDetailRequest.getStartingDate() );
        educationDetail.setCompletionDate( educationDetailRequest.getCompletionDate() );
        educationDetail.setDegree( educationDetailRequest.getDegree() );
        educationDetail.setGpa( educationDetailRequest.getGpa() );
    }
}
