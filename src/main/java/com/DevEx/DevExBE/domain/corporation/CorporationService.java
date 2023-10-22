package com.DevEx.DevExBE.domain.corporation;

import com.DevEx.DevExBE.domain.corporation.dto.CorporationRequestDto;
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

    public void addCorporation(CorporationRequestDto requestDto){
        if(corporationRepository.existsByCorpName(requestDto.getName())){
            throw new EntityExistsException("Already exist corp");
        }
        corporationRepository.save(requestDto.toEntity());
    }


    public List<Corporation> getCorporationList(){
        return corporationRepository.findAll();
    }

    public Optional<Corporation> getCorporation(Long id){
        return corporationRepository.findById(id);
    }
}
