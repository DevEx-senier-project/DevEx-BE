package com.DevEx.DevExBE.domain.users;


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
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<Users> getUser(){
        return userService.getUserList();
    }

    @GetMapping("/{userId}")
    public Users getUserId(@PathVariable("userId") Long userId){
        return userService.getUserId(userId);
    }


    @GetMapping("/email/{email}")
    public Users getUserEmail(@PathVariable("email") String email){
        return userService.getUserByEmail(email);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //현재 로그인 한 유저 정보 받아옴
    @GetMapping("/detail")
    public Users getUserDetail(@AuthenticationPrincipal UserDetails user){
        return userService.getUserByEmail(user.getUsername());
    }
}
