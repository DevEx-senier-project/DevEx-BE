package com.DevEx.DevExBE.domain.corporation;

import com.DevEx.DevExBE.domain.corporation.dto.CorporationRequestDto;
import com.DevEx.DevExBE.domain.handcarry.Handcarry;
import com.DevEx.DevExBE.domain.users.Users;
import com.DevEx.DevExBE.global.BaseEntity;
import com.DevEx.DevExBE.global.S3.BucketDir;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Corporation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "corp_name")
    private String corpName;

    @Column(name = "tell")
    private String tell;

    @Column(name = "email")
    private String email;

    @Column(name = "profile_image_url")
    private String profileImageUrl;

    @Builder.Default
    @JsonManagedReference
    @OneToMany(mappedBy = "corporation")
    private List<Handcarry> handcarryList = new ArrayList<>();

    @Builder.Default
    @JsonManagedReference
    @OneToMany
    private List<Users> userList = new ArrayList<>();

    public void changeProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public static Corporation toEntity(CorporationRequestDto requestDto, String profileImageUrl){
        return Corporation.builder()
                .corpName(requestDto.getCorpName())
                .email(requestDto.getEmail())
                .tell(requestDto.getTell())
                .profileImageUrl(profileImageUrl)
                .build();
    }

}
