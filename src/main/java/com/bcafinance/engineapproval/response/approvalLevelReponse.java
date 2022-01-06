package com.bcafinance.engineapproval.response;

import lombok.Data;

@Data
public class ApprovalLevelReponse {
    private String errorCode;
    private String errorMessage;
    private String appLevel;
}
