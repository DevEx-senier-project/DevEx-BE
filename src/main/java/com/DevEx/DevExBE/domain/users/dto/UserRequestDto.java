package com.DevEx.DevExBE.domain.users.dto;

import com.DevEx.DevExBE.domain.corporation.Corporation;
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
    private Corporation corporation;

    public Users toEntity(){
        return Users.builder()
                .name(name)
                .email(email)
                .corporation(corporation)
                .build();
    }
}
