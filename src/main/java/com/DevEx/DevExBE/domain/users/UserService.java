package com.DevEx.DevExBE.domain.users;

import com.DevEx.DevExBE.domain.users.dto.UserRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;


    public Users addUser(UserRequestDto requestDto){
        return userRepository.save(requestDto.toEntity());
    }


    public Users getUser(UserRequestDto requestDto){
        return userRepository.findById(requestDto.toEntity().getId()).orElseThrow();
    }


    public ResponseEntity<Void> deleteUser(Long id){
        userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}