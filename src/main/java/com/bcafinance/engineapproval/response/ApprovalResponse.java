package com.bcafinance.engineapproval.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor 
public class ApprovalResponse {
    private String errorCode;
    private String errorMessage;
    private String appLevel;
}
