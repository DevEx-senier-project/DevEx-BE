package com.DevEx.DevExBE.domain.token;

import com.DevEx.DevExBE.domain.users.Users;
import com.DevEx.DevExBE.domain.users.dto.AddUserRequestDto;

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
    public ResponseEntity<Users> signup(@RequestBody AddUserRequestDto userRequestDto) {

        try{
            Users savedUser = authService.signup(userRequestDto);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(savedUser);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(null);
        }

    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody AddUserRequestDto addUserRequestDto) {
        return ResponseEntity.ok(authService.login(addUserRequestDto));
    }

//    @PostMapping("/reissue")
//    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
//        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
//    }
}