package com.DevEx.DevExBE.domain.corporation;

import com.DevEx.DevExBE.domain.corporation.dto.CorporationRequestDto;
import com.DevEx.DevExBE.global.exception.corporation.CorporationAlreadyExistsException;
import com.DevEx.DevExBE.global.exception.corporation.CorporationNotFoundException;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CorporationService {

    private final CorporationRepository corporationRepository;

    // TODO: 2023/10/22 Corporation -> Handcarry 간 양방향 매핑
    public void addCorporation(CorporationRequestDto requestDto){
        if(corporationRepository.existsByCorpName(requestDto.getCorpName())){
            throw new CorporationAlreadyExistsException();
        }
        corporationRepository.save(Corporation.toEntity(requestDto));
    }


    public List<Corporation> getCorporationList(){
        return corporationRepository.findAll();
    }

    public Corporation getCorporation(Long id){
        return corporationRepository.findById(id).orElseThrow(CorporationNotFoundException::new);
    }

}
