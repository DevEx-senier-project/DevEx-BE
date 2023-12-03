package com.DevEx.DevExBE.domain.token.dto;


import com.DevEx.DevExBE.domain.corporation.Corporation;
import com.DevEx.DevExBE.domain.users.UserAuthority;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class AddUserRequestDto {

    @Schema(example = "홍길동")
    private String name;

    @Schema(example = "example@email")
    private String email;

    @Schema(example = "password")
    private String password;

    @Schema(example = "ROLE_ADMIN")
    private UserAuthority userAuthority;

    @Schema(example = "삼성")
    private String corporation;
}
