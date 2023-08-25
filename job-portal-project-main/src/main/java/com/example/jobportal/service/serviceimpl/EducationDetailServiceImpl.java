package com.example.jobportal.service.serviceimpl;

import com.example.jobportal.dto.request.EducationDetailRequest;
import com.example.jobportal.dto.response.EducationDetailResponse;
import com.example.jobportal.entity.EducationDetail;
import com.example.jobportal.exception.NotDataFound;
import com.example.jobportal.mapper.EducationDetailMapper;
import com.example.jobportal.repository.EducationDetailRepository;
import com.example.jobportal.service.EducationDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EducationDetailServiceImpl implements EducationDetailService {
    private final EducationDetailRepository educationDetailRepository;
    private final EducationDetailMapper educationDetailMapper;

    @Override
    public List<EducationDetailResponse> getAllEducationDetails() {
        List<EducationDetail> educationDetailEntities = educationDetailRepository.findAll();
        return educationDetailMapper.toDTOs(educationDetailEntities);
    }

    @Override
    public EducationDetailResponse createNewEducationDetail(EducationDetailRequest educationDetailRequest) {
        EducationDetail educationDetailEntity = educationDetailMapper.fromDTO(educationDetailRequest);
        educationDetailEntity = educationDetailRepository.save(educationDetailEntity);
        return educationDetailMapper.toDTO(educationDetailEntity);
    }

    @Override
    public void deleteById(Integer id) {
        EducationDetail educationDetailEntity = educationDetailRepository.findById(id).orElseThrow(() -> {
            return new NotDataFound("Education detail not found with id: " + id);
        });
        educationDetailRepository.delete(educationDetailEntity);
    }

    @Override
    public void updateEducationDetail(Integer id, EducationDetailRequest educationDetailRequest) {
        var educationDetailEntity = educationDetailRepository.findById(id)
                .orElseThrow(() -> new NotDataFound("Education detail not found"));

        educationDetailMapper.mapUpdateRequestToEntity(educationDetailEntity, educationDetailRequest);
        educationDetailRepository.save(educationDetailEntity);
    }

}
