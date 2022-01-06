package com.bcafinance.engineapproval.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data @Entity @NoArgsConstructor @AllArgsConstructor
@Table(name = "SP_ME_Approval_MasterDeviasi")
public class MasterDeviasi {
    private @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id;
    private int app_level;
    private String nama;
    private int sts;
    private Date start_berlaku;
    private Date end_berlaku;
    private int createdby;
    private Date createddate;
    private int updatedby;
    private Date updateddate;
}
