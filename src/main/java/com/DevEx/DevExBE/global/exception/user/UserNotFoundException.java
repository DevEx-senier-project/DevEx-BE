package com.DevEx.DevExBE.global.exception.user;

import com.DevEx.DevExBE.global.exception.BaseException;
import com.DevEx.DevExBE.global.exception.ErrorCode;

public class UserNotFoundException extends BaseException {
    public UserNotFoundException(){
        super(ErrorCode.USER_NOT_FOUND);
    }
}
