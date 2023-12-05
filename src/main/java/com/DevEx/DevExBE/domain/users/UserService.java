package com.DevEx.DevExBE.domain.users;

import com.DevEx.DevExBE.domain.corporation.CorporationRepository;
import com.DevEx.DevExBE.domain.users.dto.UserResponseDto;
import com.DevEx.DevExBE.global.exception.user.UserNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final CorporationRepository corporationRepository;

    @Transactional
    public List<UserResponseDto> getUserList() {
        return userRepository.findAll().stream().map(UserResponseDto::toDto).toList();
    }

    // TODO: 2023-11-22 [공준우] 추후 삭제 예정
    @Transactional
    public UserResponseDto getUserId(Long id) {
        return UserResponseDto.toDto(userRepository.findById(id).orElseThrow(UserNotFoundException::new));
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // email을 통해 유저 정보를 가져온다.
    @Transactional
    public UserResponseDto getUserByEmail(String email) {
        return UserResponseDto.toDto(userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new));
    }

    @Transactional
    public Users getUserEntityByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
    }

}