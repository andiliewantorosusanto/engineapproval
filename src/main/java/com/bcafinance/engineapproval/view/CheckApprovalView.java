package com.bcafinance.engineapproval.view;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.bcafinance.engineapproval.compositekey.CheckApprovalViewCompositeKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@IdClass(CheckApprovalViewCompositeKey.class)
public class CheckApprovalView {
    private String errorCode;
    private String errorMessage;
    private @Id Integer appLevel;
    private @Id String jenisCheck;
}
