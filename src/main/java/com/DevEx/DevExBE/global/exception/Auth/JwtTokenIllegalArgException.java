package com.DevEx.DevExBE.global.exception.Auth;

import com.DevEx.DevExBE.global.exception.BaseException;
import com.DevEx.DevExBE.global.exception.ErrorCode;

public class JwtTokenIllegalArgException extends BaseException {
    public JwtTokenIllegalArgException(){
        super(ErrorCode.ILLEGALARGUMENT_TOKEN);
    }
}
