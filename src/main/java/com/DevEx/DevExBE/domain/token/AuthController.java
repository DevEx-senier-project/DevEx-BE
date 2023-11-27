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

    @PostMapping("/signup")
    public ResponseEntity<AddUserResponseDto> signup(@RequestBody AddUserRequestDto userRequestDto) {
        AddUserResponseDto savedUserDto = authService.signup(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedUserDto);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginRequestDto addUserRequestDto) {
        return ResponseEntity.ok(authService.login(addUserRequestDto));
    }

//    @PostMapping("/reissue")
//    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
//        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
//    }
}