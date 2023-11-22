package com.DevEx.DevExBE.domain.users.dto;


import com.DevEx.DevExBE.domain.users.UserAuthority;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class AddUserRequestDto {

    private String name;
    private String email;
    private String password;
    private UserAuthority userAuthority;

}
