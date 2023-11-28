package com.DevEx.DevExBE.domain.users;


import com.DevEx.DevExBE.domain.users.dto.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
@Slf4j
@Tag(name = "[2] User", description = "User API")
public class UserController {

    private final UserService userService;

    @Operation(summary = "전체 유저 조회", description = "전체 유저 조회")
    @GetMapping
    public List<UserResponseDto> getUser() {
        return userService.getUserList();
    }

    @Operation(summary = "Id로 유저 조회", description = "Id로 유저 조회")
    @GetMapping("/{userId}")
    public UserResponseDto getUserId(@PathVariable("userId") Long userId) {
        return userService.getUserId(userId);
    }


    @Operation(summary = "이메일로 유저 조회", description = "이메일로 유저 조회")
    @GetMapping("/email/{email}")
    public UserResponseDto getUserEmail(@PathVariable("email") String email) {
        return userService.getUserByEmail(email);
    }

    @Operation(summary = "유저 삭제", description = "유저 삭제")
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "로그인 유저 정보", description = "현재 로그인 한 유저 정보 받아옴")
    @GetMapping("/detail")
    public UserResponseDto getUserDetail(@AuthenticationPrincipal UserDetails user) {
        return userService.getUserByEmail(user.getUsername());
    }
}
