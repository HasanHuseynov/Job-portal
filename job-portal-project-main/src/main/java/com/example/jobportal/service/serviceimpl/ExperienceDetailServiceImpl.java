package com.example.jobportal.service.serviceimpl;

import com.example.jobportal.dto.request.ExperienceDetailRequest;
import com.example.jobportal.dto.response.ExperienceDetailResponse;
import com.example.jobportal.entity.ExperienceDetail;
import com.example.jobportal.exception.NotDataFound;
import com.example.jobportal.mapper.ExperienceDetailMapper;
import com.example.jobportal.repository.ExperienceDetailRepository;
import com.example.jobportal.service.ExperienceDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExperienceDetailServiceImpl implements ExperienceDetailService {
    private final ExperienceDetailRepository experienceDetailRepository;
    private final ExperienceDetailMapper experienceDetailMapper;

    @Override
    public List<ExperienceDetailResponse> getAllExperienceDetails() {
        List<ExperienceDetail> experienceDetailEntities = experienceDetailRepository.findAll();
        return experienceDetailMapper.toDTOs(experienceDetailEntities);
    }

    @Override
    public ExperienceDetailResponse createNewExperienceDetail(ExperienceDetailRequest experienceDetailRequest) {
        ExperienceDetail experienceDetailEntity = experienceDetailMapper.fromDTO(experienceDetailRequest);
        experienceDetailEntity = experienceDetailRepository.save(experienceDetailEntity);
        return experienceDetailMapper.toDTO(experienceDetailEntity);
    }

    @Override
    public void deleteById(Integer id) {
        ExperienceDetail experienceDetailEntity = experienceDetailRepository.findById(id).orElseThrow(() -> {
            return new NotDataFound("Experience detail not found with id: " + id);
        });
        experienceDetailRepository.delete(experienceDetailEntity);
    }

    @Override
    public void updateExperienceDetail(Integer id, ExperienceDetailRequest experienceRequest) {
        var experienceEntity = experienceDetailRepository.findById(id)
                .orElseThrow(() -> new NotDataFound("Experience not found"));

        experienceDetailMapper.mapUpdateRequestToEntity(experienceEntity, experienceRequest);
        experienceDetailRepository.save(experienceEntity);
    }
}
