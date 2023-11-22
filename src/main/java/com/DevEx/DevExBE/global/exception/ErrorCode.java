package com.DevEx.DevExBE.global.exception;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    USER_NOT_FOUND(HttpStatus.UNAUTHORIZED, "USER_001", "해당 email(id)로 가입된 사용자가 없습니다."),

    USER_ALREADY_EXISTS(HttpStatus.CONFLICT, "USER_002", "이미 가입된 유저입니다."),

    CORPORATION_ALREADY_EXISTS(HttpStatus.CONFLICT, "COR_001", "이미 존재하는 회사입니다."),

    CORPORATION_NOT_FOUND(HttpStatus.CONFLICT, "COR_002", "존재하지 않는 회사입니다."),

    HANDCARRY_NOT_FOUND(HttpStatus.CONFLICT, "HAN_001", "존재하지 않는 핸드캐리 업체입니다."),

    ITEM_ALREADY_EXISTS(HttpStatus.CONFLICT, "ITEM_001", "이미 존재하는 Item입니다."),

    BANNEDITEM_RESISTER_FAIL(HttpStatus.CONFLICT, "BI_001", "등록에 실패했습니다."),

    INVALID_ACCESS_TOKEN(HttpStatus.UNAUTHORIZED, "AUTH_001", "유효하지 않은 ACCESS TOKEN입니다."),

    EXPIRED_MEMBER_TOKEN(HttpStatus.UNAUTHORIZED, "AUTH_002", "만료된 JWT 토큰입니다."),

    UNSUPPORTED_TOKEN(HttpStatus.UNAUTHORIZED, "AUTH_003", "지원되지 않는 JWT 토큰입니다."),

    ILLEGALARGUMENT_TOKEN(HttpStatus.BAD_REQUEST, "AUTH_004", "잘못된 JWT TOKEN입니다."),

    INVALID_REQUEST(HttpStatus.BAD_REQUEST, "glb_001", "잘못된 요청입니다.");


    private String code;
    private String message;
    private HttpStatus status;

    ErrorCode(HttpStatus status, String code, String message){
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
