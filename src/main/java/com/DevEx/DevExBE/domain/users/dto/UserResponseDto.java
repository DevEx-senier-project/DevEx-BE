package com.DevEx.DevExBE.domain.users.dto;

import com.DevEx.DevExBE.domain.users.Users;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDto {

    private String username;
    private String email;
    // TODO: 2023-11-22 [공준우] 반환 시 회사 정보도 같이 반환해야함

    public static UserResponseDto toDto(Users user){
        return UserResponseDto.builder()
                .username(user.getName())
                .email(user.getEmail())
                .build();
    }
}