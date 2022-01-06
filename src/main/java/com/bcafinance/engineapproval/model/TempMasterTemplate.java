package com.bcafinance.engineapproval.model;

import lombok.Data;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data @Entity
public class TempMasterTemplate {
    private @Id @GeneratedValue Long id;
    private int app_level;
    private int sts;
    private Date start_berlaku;
    private Date end_berlaku;
    private int createdby;
    private Date createddate;
    private int updatedby;
    private Date updateddate;
    private int master_id;
    private int action;
}