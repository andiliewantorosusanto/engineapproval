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
@Table(name = "SP_ME_Approval_Log_Api")
public class LogApi {
    private @Id @GeneratedValue(strategy=GenerationType.IDENTITY) int id;
    private String reqJSON;
    private String resJSON;
    private int sts = 1;
    private int createdby;
    private Date createddate;
    private Date updateddate;

    public void trace(int id) {
        if(this.createddate == null) {
            this.createdby = id;
            this.createddate = new Date();
        } else {
            this.updateddate = new Date();
        }
    }

    public void setReqJSON(String reqJSON,int id) {
        this.reqJSON = reqJSON;
        this.trace(id);
    }

    public void setResJSON(String resJSON) {
        this.resJSON = resJSON;
        this.trace(0);
    }
}
