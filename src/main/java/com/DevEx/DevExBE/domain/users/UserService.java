package com.DevEx.DevExBE.domain.users;

import com.DevEx.DevExBE.domain.corporation.Corporation;
import com.DevEx.DevExBE.domain.corporation.CorporationRepository;
import com.DevEx.DevExBE.domain.users.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final CorporationRepository corporationRepository;


    // TODO: 2023/10/22 User -> Corporation 간 양방향 매핑
    public Users addUser(UserRequestDto requestDto){
        return userRepository.save(requestDto.toEntity());
    }

    public List<Users> getUserList(){
        return userRepository.findAll();
    }

    public Optional<Users> getUserId(Long id){
        return userRepository.findById(id);
    }

    public ResponseEntity<Void> deleteUser(Long id){
        userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}