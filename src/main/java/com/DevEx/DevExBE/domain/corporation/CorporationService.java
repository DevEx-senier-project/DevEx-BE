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
    private final String defaultImage = "https://devex-profile.s3.ap-northeast-2.amazonaws.com/default.png";

    // TODO: 2023/10/22 Corporation -> Handcarry 간 양방향 매핑
    public void addCorporation(CorporationRequestDto requestDto, MultipartFile multipartFile) throws IOException {
        if(multipartFile == null){
            System.out.println(" 사진 왜없노.. ");
        }
        if(corporationRepository.existsByCorpName(requestDto.getCorpName())){
            throw new CorporationAlreadyExistsException();
        }
        String imageUrl = defaultImage;
        if(multipartFile != null) {
            imageUrl = s3Service.uploadFile(BucketDir.Corporation, multipartFile);
        }
        corporationRepository.save(Corporation.toEntity(requestDto, imageUrl));
    }


    public List<Corporation> getCorporationList(){
        return corporationRepository.findAll();
    }

    public Corporation getCorporation(Long id){
        return corporationRepository.findById(id).orElseThrow(CorporationNotFoundException::new);
    }

    public String uploadFile(String corpName, MultipartFile multipartFile) throws IOException {
        Optional<Corporation> corporation = corporationRepository.findByCorpName(corpName);
        String newProfileUrl = s3Service.uploadFile(BucketDir.Corporation, multipartFile);
        corporation.get().changeProfileImageUrl(newProfileUrl);
        corporationRepository.save(corporation.get());
        return newProfileUrl;
    }
}
