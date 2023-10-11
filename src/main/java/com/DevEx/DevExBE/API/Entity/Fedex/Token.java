package com.DevEx.DevExBE.API.Entity.Fedex;

import lombok.Getter;

/**
 * Fedex API를 통해 받아온 토큰을 담는 클래스
 */
@Getter
public class Token {

    private String access_token;
    private String token_type;
    private String expires_in;
    private String scope;

}
