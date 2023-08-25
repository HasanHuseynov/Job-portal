package com.example.jobportal.service.serviceimpl;

import com.example.jobportal.dto.request.CompanyRequest;
import com.example.jobportal.dto.response.CompanyResponse;
import com.example.jobportal.entity.Company;
import com.example.jobportal.exception.NotDataFound;
import com.example.jobportal.mapper.CompanyMapper;
import com.example.jobportal.repository.CompanyRepository;
import com.example.jobportal.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Override
    public List<CompanyResponse> getALlCompanies() {
        List<Company> companyEntity = companyRepository.findAll();
        log.info("Inside of company getAll");
        return companyMapper.toDTOs(companyEntity);

    }

    @Override
    public CompanyResponse createNewCompany(CompanyRequest companyRequest) {
        Company companyEntity = companyMapper.fromDTO(companyRequest);
        companyEntity = companyRepository.save(companyEntity);
        return companyMapper.toDTO(companyEntity);
    }

    @Override
    public void deleteById(Integer id) {
        Company companyEntity = companyRepository.findById(id).orElseThrow(() -> {
            return new NotDataFound("Not data found");
        });
        companyRepository.delete(companyEntity);
    }

    @Override
    public void updateCompany(Integer id, CompanyRequest companyRequest) {
        var companyEntity = companyRepository.findById(id).orElseThrow(() -> new NotDataFound("Data not found"));
        companyMapper.mapUpdateRequestToEntity(companyEntity, companyRequest);
        companyRepository.save(companyEntity);

    }

    @Override
    public List<CompanyResponse> getCompanyByEmail(String email) {
        var companyEntity = companyRepository.findByCompanyEmail(email);
        return companyMapper.toDTOs(companyEntity);
    }


}
