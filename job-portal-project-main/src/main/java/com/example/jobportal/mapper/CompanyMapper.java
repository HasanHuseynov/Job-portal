package com.example.jobportal.mapper;

import com.example.jobportal.dto.request.CompanyRequest;
import com.example.jobportal.dto.response.CompanyResponse;
import com.example.jobportal.entity.Company;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true)
)
public interface CompanyMapper {
    Company fromDTO(CompanyRequest companyRequest);

    CompanyResponse toDTO(Company company);

    List<CompanyResponse> toDTOs(List<Company> companies);

    Company mapUpdateRequestToEntity(@MappingTarget Company company, CompanyRequest companyRequest);


}
