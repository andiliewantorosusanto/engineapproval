package com.bcafinance.engineapproval.response;

import lombok.Data;

@Data
public class approvalLevelReponse {
    private String errorCode;
    private String errorMessage;
    private String appLevel;
    private String tambah;
}
