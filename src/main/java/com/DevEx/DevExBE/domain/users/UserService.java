package com.DevEx.DevExBE.domain.users;

import com.DevEx.DevExBE.domain.corporation.CorporationRepository;
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

    public List<Users> getUserList() {
        return userRepository.findAll();
    }

    public Optional<Users> getUserId(Long id) {
        return userRepository.findById(id);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // email을 통해 유저 정보를 가져온다.
    public Users getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                () -> new IllegalArgumentException("해당 유저가 없습니다.")
        );
    }

}