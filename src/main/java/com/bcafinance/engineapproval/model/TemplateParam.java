package com.bcafinance.engineapproval.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.bcafinance.engineapproval.compositekey.TemplateParamCompositeKey;

@Data @Entity @NoArgsConstructor @AllArgsConstructor
@IdClass(TemplateParamCompositeKey.class)
@Table(name = "ME_Approval_Template_Param")
public class TemplateParam {
    private @Id String token;
    private @Id String idx;
    private String val;
}
