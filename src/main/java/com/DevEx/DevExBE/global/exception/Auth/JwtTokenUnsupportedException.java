package com.DevEx.DevExBE.global.exception.Auth;

import com.DevEx.DevExBE.global.exception.BaseException;
import com.DevEx.DevExBE.global.exception.ErrorCode;

public class JwtTokenUnsupportedException extends BaseException {
    public JwtTokenUnsupportedException(){
        super(ErrorCode.UNSUPPORTED_TOKEN);
    }
}
