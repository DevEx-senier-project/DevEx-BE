package com.DevEx.DevExBE.global.exception.corporation;

import com.DevEx.DevExBE.global.exception.BaseException;
import com.DevEx.DevExBE.global.exception.ErrorCode;

public class CorporationNotFoundException extends BaseException {
    public CorporationNotFoundException(){
        super(ErrorCode.CORPORATION_NOT_FOUND);
    }
}
