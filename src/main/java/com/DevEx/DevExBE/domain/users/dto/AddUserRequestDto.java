package com.DevEx.DevExBE.domain.users.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class AddUserRequestDto {
    private String email;
    private String password;
    private String token;
}
