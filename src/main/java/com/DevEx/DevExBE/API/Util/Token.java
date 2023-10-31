package com.DevEx.DevExBE.API.Util;

import lombok.Getter;

/**
 * Fedex API를 통해 받아온 토큰을 담는 클래스
 */
@Getter
public class Token {

    private String access_token;
    private String token_type;

    // TODO: 2023-10-31 1. expires_in이 만료 시 토큰을 다시 받아와야 하는지 확인
    private String expires_in;
    private String scope;

}
