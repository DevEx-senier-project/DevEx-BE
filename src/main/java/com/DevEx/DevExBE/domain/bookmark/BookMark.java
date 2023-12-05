package com.DevEx.DevExBE.domain.bookmark;

import com.DevEx.DevExBE.API.Dto.UserQuoteRequestDto;
import com.DevEx.DevExBE.domain.users.Users;
import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class BookMark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private Users users;

    @Schema(example = "내발송물품" , description = "품명")
    private String name;

    @Schema(example = "귀중품" , description = "카테고리")
    private String category;

    //출발 국가 코드
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

    @Schema(example = "10" , description = "가로")
    private int lengthValue;

    @Schema(example = "10" , description = "세로")
    private int widthValue;

    @Schema(example = "10" , description = "높이")
    private int heightValue;

    @Schema(example = "CM" , description = "측정 단위")
    private String lengthUnit;

    @Schema(example = "false" , description = "위험물 여부")
    private boolean danger;

    @Schema(example = "2" , description = "박스 수량")
    private int boxCount;

    @Builder
    public static BookMark toEntity(Users users, UserQuoteRequestDto requestDto) {
        return BookMark.builder()
                .users(users)
                .name(requestDto.getName())
                .category(requestDto.getCategory())
                .shipperCountryCode(requestDto.getShipperCountryCode())
                .shipperPostalCode(requestDto.getShipperPostalCode())
                .recipientCountryCode(requestDto.getRecipientCountryCode())
                .recipientPostalCode(requestDto.getRecipientPostalCode())
                .weight(requestDto.getWeight())
                .weightUnit(requestDto.getWeightUnit())
                .lengthValue(requestDto.getLengthValue())
                .widthValue(requestDto.getWidthValue())
                .heightValue(requestDto.getHeightValue())
                .lengthUnit(requestDto.getLengthUnit())
                .danger(requestDto.isDanger())
                .boxCount(requestDto.getBoxCount())
                .build();
    }

}
