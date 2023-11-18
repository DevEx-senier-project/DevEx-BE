package com.DevEx.DevExBE.global.exception.corporation;

import com.DevEx.DevExBE.global.exception.BaseException;
import com.DevEx.DevExBE.global.exception.ErrorCode;

public class CorporationAlreadyExistsException extends BaseException {
    public CorporationAlreadyExistsException(){
        super(ErrorCode.CORPORATION_ALREADY_EXISTS);
    }
}
