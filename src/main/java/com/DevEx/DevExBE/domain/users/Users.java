package com.DevEx.DevExBE.domain.users;

import com.DevEx.DevExBE.domain.corporation.Corporation;
import com.DevEx.DevExBE.domain.token.dto.AddUserRequestDto;
import com.DevEx.DevExBE.global.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@Builder
@NoArgsConstructor//기본 생성자 추가
@AllArgsConstructor//모든 피드 값을 파라미터로 받는 생성자 추가
public class Users extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    private UserAuthority userAuthority;

    @ManyToOne
    @JoinColumn(name = "corporation_id")
    @JsonBackReference
    private Corporation corporation;

    public static Users toEntity(AddUserRequestDto requestDto){
        return Users.builder()
                .name(requestDto.getName())
                .email(requestDto.getEmail())
                .password(requestDto.getPassword())
                .userAuthority(requestDto.getUserAuthority())
                .build();
    }

}
