package com.DevEx.DevExBE.domain.token;

import com.DevEx.DevExBE.domain.corporation.Corporation;
import com.DevEx.DevExBE.domain.corporation.CorporationRepository;
import com.DevEx.DevExBE.domain.token.dto.AddUserResponseDto;
import com.DevEx.DevExBE.domain.token.dto.LoginRequestDto;
import com.DevEx.DevExBE.domain.token.dto.TokenDto;
import com.DevEx.DevExBE.domain.users.UserRepository;
import com.DevEx.DevExBE.domain.users.Users;
import com.DevEx.DevExBE.domain.token.dto.AddUserRequestDto;
import com.DevEx.DevExBE.global.exception.corporation.CorporationNotFoundException;
import com.DevEx.DevExBE.global.exception.user.UserAlreadyExistsException;
import com.DevEx.DevExBE.global.jwt.JwtProvider;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtProvider jwtProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final CorporationRepository corporationRepository;

    @Transactional
    public AddUserResponseDto signup(AddUserRequestDto userRequestDto) {

        if (userRepository.existsByEmail(userRequestDto.getEmail())) {
            throw new UserAlreadyExistsException();
        }

        userRequestDto.setPassword(encodePassword(userRequestDto.getPassword()));
        Corporation corporation = corporationRepository.findByCorpName(userRequestDto.getCorporation())
                .orElseThrow(CorporationNotFoundException::new);
        return AddUserResponseDto.toDto(userRepository.save(Users.toEntity(userRequestDto, corporation)));
    }

    public String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    @Transactional
    public TokenDto login(LoginRequestDto userRequestDto){
        // 1. Login ID/PW 를 기반으로 AuthenticationToken 생성
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userRequestDto.getEmail(), userRequestDto.getPassword());

        //    authenticate 메서드가 실행이 될 때 UserDetailsServiceImpl 에서 만들었던 loadUserByUsername 메서드가 실행됨
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        TokenDto tokenDto = jwtProvider.generateTokenDto(authentication);
        // 4. RefreshToken 저장
        RefreshToken refreshToken = RefreshToken.builder()
                .key(authentication.getName())
                .value(tokenDto.getRefreshToken())
                .build();

        refreshTokenRepository.save(refreshToken);
        return tokenDto;
    }

}
