package com.DevEx.DevExBE.users;


import com.DevEx.DevExBE.users.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Users> addUser(@RequestBody UserRequestDto userRequestDto){
        Users savedUser = userService.save(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedUser);
    }

    @GetMapping
    public ResponseEntity<Users> getUser(@RequestBody UserRequestDto userRequestDto){
        Users user = userService.getUser(userRequestDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(user);
    }

}
