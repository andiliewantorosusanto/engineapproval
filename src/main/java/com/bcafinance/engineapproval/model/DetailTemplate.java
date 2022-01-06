package com.bcafinance.engineapproval.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data @Entity @NoArgsConstructor @AllArgsConstructor
@Table(name = "SP_ME_Approval_DetailTemplate")
public class DetailTemplate {
    private @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id;
    private Long master_id;
    private String idx;
    private String operator;
    private String val;
    private String valText;
}
