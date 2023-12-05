package com.DevEx.DevExBE.domain.bookmark;

import com.DevEx.DevExBE.API.Dto.UserQuoteRequestDto;
import com.DevEx.DevExBE.domain.users.Users;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class BookMark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @Schema(example = "KR" , description = "출발 국가 코드")
    private String shipperCountryCode;

    //출발 우편번호
    @Schema(example = "22212" , description = "출발 우편번호")
    private String shipperPostalCode;

    //도착 국가 코드
    @Schema(example = "CH" , description = "도착 국가 코드")
    private String recipientCountryCode;

    //도착 우편번호
    @Schema(example = "8099" , description = "도착 우편번호")
    private String recipientPostalCode;

    //무게
    @Schema(example = "11" , description = "무게")
    private int weight;

    //무게 단위
    @Schema(example = "KG" , description = "무게 단위")
    private String weightUnit;

    @Builder
    public static BookMark toEntity(Users users, UserQuoteRequestDto requestDto) {
        return BookMark.builder()
                .users(users)
                .shipperCountryCode(requestDto.getShipperCountryCode())
                .shipperPostalCode(requestDto.getShipperPostalCode())
                .recipientCountryCode(requestDto.getRecipientCountryCode())
                .recipientPostalCode(requestDto.getRecipientPostalCode())
                .weight(requestDto.getWeight())
                .weightUnit(requestDto.getWeightUnit())
                .build();
    }

}
