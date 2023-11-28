package com.DevEx.DevExBE.domain.corporation;

import com.DevEx.DevExBE.domain.corporation.dto.CorporationRequestDto;
import com.DevEx.DevExBE.global.S3.BucketDir;
import com.DevEx.DevExBE.global.S3.S3Service;
import com.DevEx.DevExBE.global.exception.corporation.CorporationAlreadyExistsException;
import com.DevEx.DevExBE.global.exception.corporation.CorporationNotFoundException;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CorporationService {

    private final CorporationRepository corporationRepository;
    private final S3Service s3Service;

    // TODO: 2023/10/22 Corporation -> Handcarry 간 양방향 매핑
    public void addCorporation(CorporationRequestDto requestDto, String profileImageUrl){
        if(corporationRepository.existsByCorpName(requestDto.getCorpName())){
            throw new CorporationAlreadyExistsException();
        }
        corporationRepository.save(Corporation.toEntity(requestDto, profileImageUrl));
    }


    public List<Corporation> getCorporationList(){
        return corporationRepository.findAll();
    }

    public Corporation getCorporation(Long id){
        return corporationRepository.findById(id).orElseThrow(CorporationNotFoundException::new);
    }

    public String uploadFile(MultipartFile multipartFile) throws IOException {
        return s3Service.uploadFile(BucketDir.Corporation, multipartFile);
    }
}
