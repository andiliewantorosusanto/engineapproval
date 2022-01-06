package com.bcafinance.engineapproval.model;

import lombok.Data;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data @Entity
public class LogApi {
    private @Id @GeneratedValue Long id;
    private String reqJSON;
    private String resJSON;
    private int sts;
    private String createdBy;
    private Date createddate;
    private Date updatedate;
}
