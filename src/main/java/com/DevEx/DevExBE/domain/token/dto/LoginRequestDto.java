package com.DevEx.DevExBE.domain.token.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {

    private String email;
    private String password;

}
