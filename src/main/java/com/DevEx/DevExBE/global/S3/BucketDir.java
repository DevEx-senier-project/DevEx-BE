package com.DevEx.DevExBE.global.S3;

import lombok.Getter;

@Getter
public enum BucketDir {
    HandCarry("handcarry"),
    Corporation("corporation");

    private String dirName;

    BucketDir(String dirName){
        this.dirName = dirName;
    }
}
