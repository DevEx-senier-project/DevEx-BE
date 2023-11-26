package com.DevEx.DevExBE.domain.token;

import com.DevEx.DevExBE.domain.token.dto.AddUserRequestDto;
import com.DevEx.DevExBE.domain.token.dto.AddUserResponseDto;
import com.DevEx.DevExBE.domain.token.dto.LoginRequestDto;
import com.DevEx.DevExBE.domain.token.dto.TokenDto;
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
public class AuthController {
    private final AuthService authService;

    // TODO: 2023-11-19 [공준우]  AddUserRequestDto에 불필요한 멤버변수 제거
    @PostMapping("/signup")
    public ResponseEntity<AddUserResponseDto> signup(@RequestBody AddUserRequestDto userRequestDto) {
        AddUserResponseDto savedUserDto = authService.signup(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedUserDto);
    }

    // TODO: 2023-11-19 [공준우] RequestBody 회원가입시와 구분
    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginRequestDto addUserRequestDto) {
        return ResponseEntity.ok(authService.login(addUserRequestDto));
    }

//    @PostMapping("/reissue")
//    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
//        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
//    }
}