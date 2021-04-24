package dev.jerry.common;

public enum ResultCode implements IErrorCode{

    SUCCESS(200, "Operation Successful"),
    FAILED(500, "Operation Failure"),
    VALIDATE_FAILED(404, "Validation Failure");

    private long code;
    private String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message= message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
