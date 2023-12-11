package com.DevEx.DevExBE.domain.corporation.dto;

import com.DevEx.DevExBE.domain.corporation.Corporation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CorpResponseDto {

    private String corpName;
    private String tell;
    private String email;
    private String profileImageUrl;

    public static CorpResponseDto toDto(Corporation corporation) {
        return CorpResponseDto.builder()
                .corpName(corporation.getCorpName())
                .tell(corporation.getTell())
                .email(corporation.getEmail())
                .profileImageUrl(corporation.getProfileImageUrl())
                .build();
    }

    public static CorpResponseDto toFedexDto() {
        return CorpResponseDto.builder()
                .corpName("Fedex")
                .tell("000-0000-0000")
                .email("Fedex@email.com")
                .build();
    }

}
