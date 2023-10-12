package com.DevEx.DevExBE.users.dto;

import com.DevEx.DevExBE.users.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
