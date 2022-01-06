package com.bcafinance.engineapproval.model;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data @Entity
public class TempPh {
    private @Id @GeneratedValue Long id;
    private int app_level;
    private BigDecimal ph_from;
    private BigDecimal ph_to;
    private int sts;
    private int master_id;
    private Date start_berlaku;
    private Date end_berlaku;
    private int createdby;
    private Date createddate;
    private int updatedby;
    private Date updateddate;
}
