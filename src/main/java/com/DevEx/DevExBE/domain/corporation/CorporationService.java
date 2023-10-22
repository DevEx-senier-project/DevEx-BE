package com.DevEx.DevExBE.domain.corporation;

import com.DevEx.DevExBE.domain.corporation.dto.CorporationRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CorporationService {

    private final CorporationRepository corporationRepository;

    public Corporation addCorporation(CorporationRequestDto requestDto){
        return corporationRepository.save(requestDto.toEntity());
    }


    public List<Corporation> getCorporationList(){
        return corporationRepository.findAll();
    }

    public Optional<Corporation> getCorporation(Long id){
        return corporationRepository.findById(id);
    }
}
