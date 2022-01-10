package com.bcafinance.engineapproval.compositekey;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class CheckApprovalViewCompositeKey implements Serializable {
    private Integer appLevel;
    private String jenisCheck;
}
