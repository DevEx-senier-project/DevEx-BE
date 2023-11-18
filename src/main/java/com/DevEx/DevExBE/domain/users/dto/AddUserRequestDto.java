package com.DevEx.DevExBE.domain.users.dto;


import com.DevEx.DevExBE.domain.users.UserAuthority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class AddUserRequestDto {

    private String name;
    private String email;
    private String password;
    private UserAuthority userAuthority;

}
