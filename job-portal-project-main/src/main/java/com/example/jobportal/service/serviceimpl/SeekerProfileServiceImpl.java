package com.example.jobportal.service.serviceimpl;

import com.example.jobportal.dto.request.SeekerProfileRequest;
import com.example.jobportal.dto.response.SeekerProfileResponse;
import com.example.jobportal.entity.SeekerProfile;
import com.example.jobportal.exception.NotDataFound;
import com.example.jobportal.mapper.SeekerProfileMapper;
import com.example.jobportal.repository.SeekerProfileRepository;
import com.example.jobportal.service.SeekerProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SeekerProfileServiceImpl implements SeekerProfileService {
    private final SeekerProfileRepository seekerProfileRepository;
    private final SeekerProfileMapper seekerProfileMapper;

    @Override
    public List<SeekerProfileResponse> getAllSeekerProfiles() {
        List<SeekerProfile> seekerProfileEntities = seekerProfileRepository.findAll();
        return seekerProfileMapper.toDTOs(seekerProfileEntities);
    }

    @Override
    public SeekerProfileResponse createNewSeekerProfile(SeekerProfileRequest seekerProfileRequest) {
        SeekerProfile seekerProfileEntity = seekerProfileMapper.fromDTO(seekerProfileRequest);
        seekerProfileEntity = seekerProfileRepository.save(seekerProfileEntity);
        return seekerProfileMapper.toDTO(seekerProfileEntity);
    }

    @Override
    public void deleteById(Integer id) {
        SeekerProfile seekerProfileEntity = seekerProfileRepository.findById(id).orElseThrow(() -> {
            return new NotDataFound("Seeker profile not found with id: " + id);
        });
        seekerProfileRepository.delete(seekerProfileEntity);
    }

    @Override
    public void updateSeekerProfile(Integer id, SeekerProfileRequest seekerProfileRequest) {
        var seekerProfileEntity = seekerProfileRepository.findById(id)
                .orElseThrow(() -> new NotDataFound("Seeker profile not found"));

        seekerProfileMapper.mapUpdateRequestToEntity(seekerProfileEntity, seekerProfileRequest);
        seekerProfileRepository.save(seekerProfileEntity);
    }

    @Override
    public void uploadCV(Integer id, MultipartFile cvFile) throws IOException {

        SeekerProfile seekerProfileEntity = seekerProfileRepository.findById(id)
                .orElseThrow(() -> new NotDataFound("Not profile found with this id"));

        seekerProfileEntity.setCv(cvFile.getBytes());
        seekerProfileRepository.save(seekerProfileEntity);
    }


}
