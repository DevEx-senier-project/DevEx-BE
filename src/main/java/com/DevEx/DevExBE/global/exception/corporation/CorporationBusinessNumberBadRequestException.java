package com.DevEx.DevExBE.global.exception.corporation;

import com.DevEx.DevExBE.global.exception.BaseException;
import com.DevEx.DevExBE.global.exception.ErrorCode;

public class CorporationBusinessNumberBadRequestException extends BaseException {
    public CorporationBusinessNumberBadRequestException(){
        super(ErrorCode.CORPORATION_NUMBER_BAD_REQUEST);
    }
}
