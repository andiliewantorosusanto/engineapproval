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
@Table(name = "SP_ME_Approval_Param_Field")
public class ParamField {
    private @Id @GeneratedValue(strategy=GenerationType.IDENTITY) int id;
    private String fieldText;
    private String fieldVal;
    private String fieldSourceTable;
}
