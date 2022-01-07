package com.bcafinance.engineapproval.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data @Entity @NoArgsConstructor @AllArgsConstructor
@Table(name = "temp_ME_Approval_PH")
public class TempPh {
    private @Id @GeneratedValue(strategy=GenerationType.IDENTITY) int id;
    private int app_level;
    private BigDecimal ph_from;
    private BigDecimal ph_to;
    private int sts = 1;
    private int master_id;
    private Date start_berlaku;
    private Date end_berlaku;
    private int createdby;
    private Date createddate;
    private int updatedby;
    private Date updateddate;
}
