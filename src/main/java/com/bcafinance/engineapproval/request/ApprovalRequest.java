package com.bcafinance.engineapproval.request;

import java.math.BigDecimal;

import lombok.Data;

@Data  
public class ApprovalRequest {
    private BigDecimal ph;
    private String deviasi;
    private String kode;
    private String template;
    private String merkID;
}
