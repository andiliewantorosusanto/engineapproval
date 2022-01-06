package com.bcafinance.engineapproval.response;

import lombok.Data;

@Data
public class ApprovalReponse {
    private String errorCode;
    private String errorMessage;
    private String appLevel;
}
