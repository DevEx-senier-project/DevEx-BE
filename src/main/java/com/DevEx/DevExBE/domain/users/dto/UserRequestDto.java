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

    public Users toEntity(){
        return Users.builder()
                .name(name)
                .email(email)
                .build();
    }
}
