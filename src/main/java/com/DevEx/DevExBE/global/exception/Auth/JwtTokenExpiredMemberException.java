package com.DevEx.DevExBE.global.exception.Auth;

import com.DevEx.DevExBE.global.exception.BaseException;
import com.DevEx.DevExBE.global.exception.ErrorCode;

public class JwtTokenExpiredMemberException extends BaseException {
    public JwtTokenExpiredMemberException(){
        super(ErrorCode.EXPIRED_MEMBER_TOKEN);
    }
}
