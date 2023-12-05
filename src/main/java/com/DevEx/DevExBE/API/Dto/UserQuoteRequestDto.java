package com.DevEx.DevExBE.API.Dto;

import com.DevEx.DevExBE.domain.bookmark.BookMark;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserQuoteRequestDto {

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

    public static UserQuoteRequestDto toDto(BookMark bookMark) {
        return UserQuoteRequestDto.builder()
                .name(bookMark.getName())
                .category(bookMark.getCategory())
                .shipperCountryCode(bookMark.getShipperCountryCode())
                .shipperPostalCode(bookMark.getShipperPostalCode())
                .recipientCountryCode(bookMark.getRecipientCountryCode())
                .recipientPostalCode(bookMark.getRecipientPostalCode())
                .weight(bookMark.getWeight())
                .weightUnit(bookMark.getWeightUnit())
                .lengthValue(bookMark.getLengthValue())
                .widthValue(bookMark.getWidthValue())
                .heightValue(bookMark.getHeightValue())
                .lengthUnit(bookMark.getLengthUnit())
                .danger(bookMark.isDanger())
                .boxCount(bookMark.getBoxCount())
                .build();
    }

}
