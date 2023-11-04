package com.DevEx.DevExBE.domain.users;


import com.DevEx.DevExBE.domain.users.dto.AddUserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Users> addUser(@RequestBody AddUserRequestDto request){
        Users savedUser = userService.signUp(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedUser);
    }


    @GetMapping
    public List<Users> getUser(){
        return userService.getUserList();
    }

    @GetMapping("/{userId}")
    public Optional<Users> getUserId(@PathVariable("userId") Long userId){
        return userService.getUserId(userId);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
