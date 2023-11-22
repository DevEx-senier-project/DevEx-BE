package com.DevEx.DevExBE.domain.token.dto;

import com.DevEx.DevExBE.domain.users.UserAuthority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddUserResponseDto {

    private String name;
    private UserAuthority userAuthority;

}
