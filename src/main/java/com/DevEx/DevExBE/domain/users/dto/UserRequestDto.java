package com.DevEx.DevExBE.domain.users.dto;

import com.DevEx.DevExBE.domain.users.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserRequestDto {
    private String name;
    private String email;

    // TODO: 2023-11-22 [공준우] 회원가입시 회사 정보도 받아야함

    public Users toEntity() {
        return Users.builder()
                .name(name)
                .email(email)
                .build();
    }

}
