package com.bcafinance.engineapproval.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data @Entity @NoArgsConstructor @AllArgsConstructor
@Table(name = "SP_ME_Approval_Approver")
public class Approver {
    private @Id @GeneratedValue(strategy=GenerationType.IDENTITY) int id;
    private Integer app_level;
    private String role;
    private String branch_id;
    private Integer sts;
    private int createdby;
    private Date createddate;
    private int updatedby;
    private Date updateddate;
}
