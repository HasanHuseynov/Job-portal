package com.example.jobportal.mapper;

import com.example.jobportal.dto.request.ExperienceDetailRequest;
import com.example.jobportal.dto.response.ExperienceDetailResponse;
import com.example.jobportal.entity.ExperienceDetail;
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
public class ExperienceDetailMapperImpl implements ExperienceDetailMapper {

    @Override
    public ExperienceDetail fromDTO(ExperienceDetailRequest experienceDetailRequest) {
        if ( experienceDetailRequest == null ) {
            return null;
        }

        ExperienceDetail experienceDetail = new ExperienceDetail();

        experienceDetail.setExperienceId( experienceDetailRequest.getExperienceId() );
        experienceDetail.setIsCurrentJob( experienceDetailRequest.getIsCurrentJob() );
        experienceDetail.setStartDate( experienceDetailRequest.getStartDate() );
        experienceDetail.setEndDate( experienceDetailRequest.getEndDate() );
        experienceDetail.setJobTitle( experienceDetailRequest.getJobTitle() );
        experienceDetail.setCompanyName( experienceDetailRequest.getCompanyName() );
        experienceDetail.setJobLocationCity( experienceDetailRequest.getJobLocationCity() );
        experienceDetail.setJobLocationState( experienceDetailRequest.getJobLocationState() );
        experienceDetail.setJobLocationCountry( experienceDetailRequest.getJobLocationCountry() );
        experienceDetail.setDescription( experienceDetailRequest.getDescription() );

        return experienceDetail;
    }

    @Override
    public ExperienceDetailResponse toDTO(ExperienceDetail experienceDetail) {
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

    @Override
    public List<ExperienceDetailResponse> toDTOs(List<ExperienceDetail> experienceDetails) {
        if ( experienceDetails == null ) {
            return null;
        }

        List<ExperienceDetailResponse> list = new ArrayList<ExperienceDetailResponse>( experienceDetails.size() );
        for ( ExperienceDetail experienceDetail : experienceDetails ) {
            list.add( toDTO( experienceDetail ) );
        }

        return list;
    }

    @Override
    public void mapUpdateRequestToEntity(ExperienceDetail experienceDetail, ExperienceDetailRequest experienceDetailRequest) {
        if ( experienceDetailRequest == null ) {
            return;
        }

        experienceDetail.setExperienceId( experienceDetailRequest.getExperienceId() );
        experienceDetail.setIsCurrentJob( experienceDetailRequest.getIsCurrentJob() );
        experienceDetail.setStartDate( experienceDetailRequest.getStartDate() );
        experienceDetail.setEndDate( experienceDetailRequest.getEndDate() );
        experienceDetail.setJobTitle( experienceDetailRequest.getJobTitle() );
        experienceDetail.setCompanyName( experienceDetailRequest.getCompanyName() );
        experienceDetail.setJobLocationCity( experienceDetailRequest.getJobLocationCity() );
        experienceDetail.setJobLocationState( experienceDetailRequest.getJobLocationState() );
        experienceDetail.setJobLocationCountry( experienceDetailRequest.getJobLocationCountry() );
        experienceDetail.setDescription( experienceDetailRequest.getDescription() );
    }
}
