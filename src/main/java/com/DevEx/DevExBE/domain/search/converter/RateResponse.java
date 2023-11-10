package com.DevEx.DevExBE.domain.search.converter;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

// TODO: 2023-11-09 [공준우] 사용하지 않을 때 삭제 요망 
public class RateResponse {

    @JsonProperty("transactionId")
    private String transactionId;

    @JsonProperty("output")
    private Output output;

    public static class Output {
        @JsonProperty("alerts")
        private List<Alert> alerts;

        @JsonProperty("rateReplyDetails")
        private List<RateReplyDetail> rateReplyDetails;

        @JsonProperty("quoteDate")
        private String quoteDate;

        @JsonProperty("encoded")
        private boolean encoded;
    }

    public static class Alert {
        @JsonProperty("code")
        private String code;

        @JsonProperty("message")
        private String message;

        @JsonProperty("alertType")
        private String alertType;
    }

    public static class RateReplyDetail {
        @JsonProperty("serviceType")
        private String serviceType;

        @JsonProperty("serviceName")
        private String serviceName;

        @JsonProperty("packagingType")
        private String packagingType;

        @JsonProperty("customerMessages")
        private List<CustomerMessage> customerMessages;

        @JsonProperty("ratedShipmentDetails")
        private List<RatedShipmentDetail> ratedShipmentDetails;

        @JsonProperty("operationalDetail")
        private OperationalDetail operationalDetail;

        @JsonProperty("signatureOptionType")
        private String signatureOptionType;

        @JsonProperty("serviceDescription")
        private ServiceDescription serviceDescription;
    }

    public static class CustomerMessage {
        @JsonProperty("code")
        private String code;

        @JsonProperty("message")
        private String message;
    }

    public static class RatedShipmentDetail {
        @JsonProperty("rateType")
        private String rateType;

        @JsonProperty("ratedWeightMethod")
        private String ratedWeightMethod;

        @JsonProperty("totalDiscounts")
        private int totalDiscounts;

        @JsonProperty("totalBaseCharge")
        private int totalBaseCharge;

        @JsonProperty("totalNetCharge")
        private int totalNetCharge;

        @JsonProperty("totalVatCharge")
        private int totalVatCharge;

        @JsonProperty("totalNetFedExCharge")
        private int totalNetFedExCharge;

        @JsonProperty("totalDutiesAndTaxes")
        private int totalDutiesAndTaxes;

        @JsonProperty("totalNetChargeWithDutiesAndTaxes")
        private int totalNetChargeWithDutiesAndTaxes;

        @JsonProperty("totalDutiesTaxesAndFees")
        private int totalDutiesTaxesAndFees;

        @JsonProperty("totalAncillaryFeesAndTaxes")
        private int totalAncillaryFeesAndTaxes;

        @JsonProperty("shipmentRateDetail")
        private ShipmentRateDetail shipmentRateDetail;
    }

    public static class ShipmentRateDetail {
        @JsonProperty("rateZone")
        private String rateZone;

        @JsonProperty("dimDivisor")
        private int dimDivisor;

        @JsonProperty("fuelSurchargePercent")
        private int fuelSurchargePercent;

        @JsonProperty("totalSurcharges")
        private int totalSurcharges;

        @JsonProperty("totalFreightDiscount")
        private int totalFreightDiscount;

        @JsonProperty("freightDiscount")
        private List<FreightDiscount> freightDiscount;

        @JsonProperty("surCharges")
        private List<SurCharge> surCharges;

        @JsonProperty("pricingCode")
        private String pricingCode;

        @JsonProperty("currencyExchangeRate")
        private CurrencyExchangeRate currencyExchangeRate;

        @JsonProperty("totalBillingWeight")
        private BillingWeight totalBillingWeight;

        @JsonProperty("dimDivisorType")
        private String dimDivisorType;

        @JsonProperty("currency")
        private String currency;

        @JsonProperty("rateScale")
        private String rateScale;

        @JsonProperty("totalRateScaleWeight")
        private BillingWeight totalRateScaleWeight;
    }

    public static class FreightDiscount {
        @JsonProperty("type")
        private String type;

        @JsonProperty("description")
        private String description;

        @JsonProperty("amount")
        private int amount;

        @JsonProperty("percent")
        private int percent;
    }

    public static class SurCharge {
        @JsonProperty("type")
        private String type;

        @JsonProperty("description")
        private String description;

        @JsonProperty("level")
        private String level;

        @JsonProperty("amount")
        private int amount;
    }

    public static class CurrencyExchangeRate {
        @JsonProperty("fromCurrency")
        private String fromCurrency;

        @JsonProperty("intoCurrency")
        private String intoCurrency;

        @JsonProperty("rate")
        private double rate;
    }

    public static class BillingWeight {
        @JsonProperty("units")
        private String units;

        @JsonProperty("value")
        private int value;
    }

    public static class OperationalDetail {
        @JsonProperty("ineligibleForMoneyBackGuarantee")
        private boolean ineligibleForMoneyBackGuarantee;

        @JsonProperty("astraDescription")
        private String astraDescription;

        @JsonProperty("airportId")
        private String airportId;

        @JsonProperty("serviceCode")
        private String serviceCode;
    }

    public static class ServiceDescription {
        @JsonProperty("serviceId")
        private String serviceId;

        @JsonProperty("serviceType")
        private String serviceType;

        @JsonProperty("code")
        private String code;
    }
}


