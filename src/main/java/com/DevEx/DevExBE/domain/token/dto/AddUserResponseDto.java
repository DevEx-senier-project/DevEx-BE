package com.DevEx.DevExBE.domain.token.dto;

import com.DevEx.DevExBE.domain.users.UserAuthority;
import com.DevEx.DevExBE.domain.users.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddUserResponseDto {

    private String name;
    private UserAuthority userAuthority;

    public static AddUserResponseDto toDto(Users user) {
        return AddUserResponseDto.builder()
                .name(user.getName())
                .userAuthority(user.getUserAuthority())
                .build();
    }

}
