package com.DevEx.DevExBE.global.exception.item;

import com.DevEx.DevExBE.domain.item.Item;
import com.DevEx.DevExBE.global.exception.BaseException;
import com.DevEx.DevExBE.global.exception.ErrorCode;

public class ItemAlreadyExistsException extends BaseException {
    public ItemAlreadyExistsException(){
        super(ErrorCode.ITEM_ALREADY_EXISTS);
    }
}
