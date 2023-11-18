package com.DevEx.DevExBE.global.exception.handcarry;

import com.DevEx.DevExBE.global.exception.BaseException;
import com.DevEx.DevExBE.global.exception.ErrorCode;

public class HandcarryNotFoundException extends BaseException {
    public HandcarryNotFoundException(){
        super(ErrorCode.HANDCARRY_NOT_FOUND);
    }
}
