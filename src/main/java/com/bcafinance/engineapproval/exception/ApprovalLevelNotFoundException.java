package com.bcafinance.engineapproval.exception;

import com.bcafinance.engineapproval.view.CheckApprovalView;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ApprovalLevelNotFoundException extends Exception{
    private CheckApprovalView checkApprovalView;

}
