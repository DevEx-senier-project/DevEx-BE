package com.DevEx.DevExBE.global.S3;

import lombok.Getter;

@Getter
public enum BucketDir {
    Image("image");

    private String dirName;

    BucketDir(String dirName){
        this.dirName = dirName;
    }
}
