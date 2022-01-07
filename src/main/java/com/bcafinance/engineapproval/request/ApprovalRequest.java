package com.bcafinance.engineapproval.request;

import java.math.BigDecimal;
import java.util.List;

import com.bcafinance.engineapproval.model.DeviasiParam;
import com.bcafinance.engineapproval.model.TemplateParam;

import lombok.Data;

@Data  
public class ApprovalRequest {
    private BigDecimal ph;
    private List<DeviasiParam> deviasi;
    private String kode;
    private List<TemplateParam> template;
    private String merkID;
    private String modelID;
    private String dealerID;
    private String packetID;
    private String branchID;

    public boolean bodyIsValid() {
        return !(this.ph == null || this.deviasi == null);
    }
}
