package com.DevEx.DevExBE.API.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

// TODO: 2023-10-23 1. 추후 더 많은 변수 변경 기능 가능성 있음
@Getter
@NoArgsConstructor
public class FedexQuoteRequestDto {

    //출발 국가 코드
    private String shipperCountryCode;

    //출발 우편번호
    private String shipperPostalCode;

    //도착 국가 코드
    private String recipientCountryCode;

    //도착 우편번호
    private String recipientPostalCode;

    //무게
    private String weight;

    //무게 단위
    private String weightUnit;

    private String result;

    public FedexQuoteRequestDto(UserQuoteRequestDto userQuoteRequestDto){
        this.shipperCountryCode = userQuoteRequestDto.getShipperCountryCode();
        this.recipientCountryCode = userQuoteRequestDto.getRecipientCountryCode();
        this.shipperPostalCode = userQuoteRequestDto.getShipperPostalCode();
        this.recipientPostalCode = userQuoteRequestDto.getRecipientPostalCode();
        this.weight = userQuoteRequestDto.getWeight();
        this.weightUnit = userQuoteRequestDto.getWeightUnit();
        this.result = "{\n" +
                "  \"accountNumber\": {\n" +
                "    \"value\": \"201179818\"\n" +
                "  },\n" +
                "  \"requestedShipment\": {\n" +
                "    \"shipper\": {\n" +
                "      \"address\": {\n" +
                "        \"postalCode\": "+ shipperPostalCode +",\n" +
                "        \"countryCode\": \""+ shipperCountryCode +"\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"recipient\": {\n" +
                "      \"address\": {\n" +
                "        \"postalCode\": "+recipientPostalCode+",\n" +
                "        \"countryCode\": \""+recipientCountryCode+"\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"shipDateStamp\": \"2023-10-03\",\n" +
                "    \"pickupType\": \"DROPOFF_AT_FEDEX_LOCATION\",\n" +
                "    \"serviceType\": \"INTERNATIONAL_PRIORITY\",\n" +
                "    \"rateRequestType\": [\n" +
                "      \"LIST\",\n" +
                "      \"ACCOUNT\"\n" +
                "    ],\n" +
                "    \"customsClearanceDetail\": {\n" +
                "      \"dutiesPayment\": {\n" +
                "        \"paymentType\": \"SENDER\",\n" +
                "        \"payor\": {\n" +
                "          \"responsibleParty\": null\n" +
                "        }\n" +
                "      },\n" +
                "      \"commodities\": [\n" +
                "        {\n" +
                "          \"description\": \"Camera\",\n" +
                "          \"quantity\": 1,\n" +
                "          \"quantityUnits\": \"PCS\",\n" +
                "          \"weight\": {\n" +
                "            \"units\": \""+weightUnit+"\",\n" +
                "            \"value\": "+weight+"\n" +
                "          },\n" +
                "          \"customsValue\": {\n" +
                "            \"amount\": 100,\n" +
                "            \"currency\": \"SFR\"\n" +
                "          }\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    \"requestedPackageLineItems\": [\n" +
                "      {\n" +
                "        \"weight\": {\n" +
                "          \"units\": \"KG\",\n" +
                "          \"value\": 11\n" +
                "        },\n" +
                "        \"packageSpecialServices\": {\n" +
                "          \"specialServiceTypes\": [\n" +
                "            \"DRY_ICE\"\n" +
                "          ],\n" +
                "          \"dryIceWeight\": {\n" +
                "            \"units\": \"KG\",\n" +
                "            \"value\": 5\n" +
                "          }\n" +
                "        }\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";
    }

}
