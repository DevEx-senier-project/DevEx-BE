package com.DevEx.DevExBE.domain.search.converter;

import com.google.gson.JsonObject;
import lombok.Builder;

@Builder
public class FedexToResponse {

    public JsonObject fedexResult;

    public FedexToResponse(JsonObject fedexResult) {
        this.fedexResult = fedexResult;
    }

    // TODO: 2023-11-09 [공준우] 코드 로직 간소화 시키기 
    public String getCost(){
        return fedexResult.get("output").getAsJsonObject()
                .get("rateReplyDetails").getAsJsonArray().get(0).getAsJsonObject()
                .get("ratedShipmentDetails").getAsJsonArray()
                .get(0).getAsJsonObject()
                .get("shipmentRateDetail").getAsJsonObject()
                .get("totalSurcharges").getAsString();
    }

}
