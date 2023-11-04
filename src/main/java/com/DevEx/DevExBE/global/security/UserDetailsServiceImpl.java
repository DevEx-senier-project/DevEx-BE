package com.DevEx.DevExBE.global.security;

import com.DevEx.DevExBE.domain.users.UserRepository;
import com.DevEx.DevExBE.domain.users.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    //주어진 email을 가진 사용자의 세부 정보를 얻는다.
    //이메일은 고유하다고 간주한다.
    //사용자 이름이 존재하지 않으면 메서드가 UserNameNotFoundException을 투척한다.
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("user not found"));
        return new UserDetailsImpl(user);
    }
}
