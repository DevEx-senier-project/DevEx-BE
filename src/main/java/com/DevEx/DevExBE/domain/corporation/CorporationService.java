package com.DevEx.DevExBE.domain.corporation;

import com.DevEx.DevExBE.domain.corporation.dto.CorporationRequestDto;
import com.DevEx.DevExBE.domain.users.Users;
import com.DevEx.DevExBE.domain.users.dto.UserRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class CorporationService {

    private final CorporationRepository corporationRepository;

    public Corporation addCorporation(CorporationRequestDto requestDto){
        return corporationRepository.save(requestDto.toEntity());
    }


    public Corporation getCorporation(CorporationRequestDto requestDto){
        return corporationRepository.findById(requestDto.toEntity().getId()).orElseThrow();
    }

}
