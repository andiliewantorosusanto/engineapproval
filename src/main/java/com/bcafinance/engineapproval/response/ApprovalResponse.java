package com.bcafinance.engineapproval.response;

import com.bcafinance.engineapproval.constant.ErrorCode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor 
public class ApprovalResponse {
    private String errorCode;
    private String errorMessage;
    private Integer appLevel;


    public ApprovalResponse setError(String errorMessage) {
        this.errorCode = ErrorCode.FAILED;
        this.errorMessage = errorMessage;
        return this;
    }

    public ApprovalResponse setSuccess(String errorMessage,Integer appLevel) {
        this.errorCode = ErrorCode.SUCCESS;
        this.errorMessage = errorMessage;
        this.appLevel = appLevel;
        return this;
    }
}

