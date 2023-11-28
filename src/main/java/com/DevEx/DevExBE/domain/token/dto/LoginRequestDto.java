package com.DevEx.DevExBE.domain.token.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {

    @Schema(example = "example@email")
    private String email;

    @Schema(example = "password")
    private String password;

}
