package com.bcafinance.engineapproval.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data @Entity @NoArgsConstructor @AllArgsConstructor
@Table(name = "Log_API")
public class LogApi {
    private @Id @GeneratedValue Long id;
    private String reqJSON;
    private String resJSON;
    private int sts;
    private String createdBy;
    private Date createddate;
    private Date updatedate;
}
