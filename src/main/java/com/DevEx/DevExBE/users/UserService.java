package com.DevEx.DevExBE.users;

import com.DevEx.DevExBE.users.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public Users save(UserRequestDto requestDto){
        return userRepository.save(requestDto.toEntity());
    }

    public Users getUser(UserRequestDto requestDto){
        return userRepository.findById(requestDto.toEntity().getId()).orElseThrow();
    }
}
