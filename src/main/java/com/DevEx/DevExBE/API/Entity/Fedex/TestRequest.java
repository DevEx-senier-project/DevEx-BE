package com.DevEx.DevExBE.API.Entity.Fedex;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TestRequest {

    private String result = "{\n" +
            "  \"accountNumber\": {\n" +
            "    \"value\": \"201179818\"\n" +
            "  },\n" +
            "  \"requestedShipment\": {\n" +
            "    \"shipper\": {\n" +
            "      \"address\": {\n" +
            "        \"postalCode\": 13564,\n" +
            "        \"countryCode\": \"KR\"\n" +
            "      }\n" +
            "    },\n" +
            "    \"recipient\": {\n" +
            "      \"address\": {\n" +
            "        \"postalCode\": 8099,\n" +
            "        \"countryCode\": \"CH\"\n" +
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
            "            \"units\": \"KG\",\n" +
            "            \"value\": 11\n" +
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
