package com.DevEx.DevExBE.global.exception.Auth;

import com.DevEx.DevExBE.global.exception.BaseException;
import com.DevEx.DevExBE.global.exception.ErrorCode;

public class JwtTokenInvalidException extends BaseException {
    public JwtTokenInvalidException(){
        super(ErrorCode.INVALID_ACCESS_TOKEN);
    }
}
