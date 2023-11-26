package com.DevEx.DevExBE.global.exception.S3;

import com.DevEx.DevExBE.global.exception.BaseException;
import com.DevEx.DevExBE.global.exception.ErrorCode;

public class FileNotFoundException extends BaseException{
    public FileNotFoundException(){
        super(ErrorCode.FILE_NOT_FOUND);
    }
}