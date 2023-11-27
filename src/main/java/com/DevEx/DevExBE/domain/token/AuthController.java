package com.DevEx.DevExBE.domain.token;

import com.DevEx.DevExBE.domain.token.dto.AddUserRequestDto;
import com.DevEx.DevExBE.domain.token.dto.AddUserResponseDto;
import com.DevEx.DevExBE.domain.token.dto.LoginRequestDto;
import com.DevEx.DevExBE.domain.token.dto.TokenDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "[1] Auth", description = "Auth API")
public class AuthController {
    private final AuthService authService;

    // TODO: 2023-11-19 [공준우]  AddUserRequestDto에 불필요한 멤버변수 제거
    @PostMapping("/signup")
    @Operation(summary = "회원가입", description = "회원가입")
    public ResponseEntity<AddUserResponseDto> signup(@RequestBody AddUserRequestDto userRequestDto) {
        AddUserResponseDto savedUserDto = authService.signup(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedUserDto);
    }

    @Operation(summary = "로그인", description = "로그인")
    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginRequestDto addUserRequestDto) {
        return ResponseEntity.ok(authService.login(addUserRequestDto));
    }

//    @PostMapping("/reissue")
//    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
//        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
//    }
}