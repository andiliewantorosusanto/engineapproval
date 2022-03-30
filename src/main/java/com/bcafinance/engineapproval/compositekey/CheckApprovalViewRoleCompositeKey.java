package com.bcafinance.engineapproval.compositekey;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class CheckApprovalViewRoleCompositeKey implements Serializable {
    private String role;
    private String errorCode;
}
