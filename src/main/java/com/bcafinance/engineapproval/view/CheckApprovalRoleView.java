package com.bcafinance.engineapproval.view;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.bcafinance.engineapproval.compositekey.CheckApprovalViewRoleCompositeKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@IdClass(CheckApprovalViewRoleCompositeKey.class)
public class CheckApprovalRoleView {
    private @Id String errorCode;
    private String errorMessage;
    private @Id String role;
}
