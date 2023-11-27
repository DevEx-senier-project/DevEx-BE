package com.DevEx.DevExBE.domain.corporation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class CorporationRequestDto {

    @Schema(example = "삼성성", description = "회사 이름")
    private String corpName;

    @Schema(example = "exampleEmail@email.com", description = "회사 이메일")
    private String email;

    @Schema(example = "010-123-456", description = "회사 연락처")
    private String tell;

}
