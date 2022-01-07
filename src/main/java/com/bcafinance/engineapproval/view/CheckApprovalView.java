package com.bcafinance.engineapproval.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class CheckApprovalView {
    private String errorCode;
    private String errorMessage;
    private Integer appLevel;
}
