package com.bcafinance.engineapproval.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data @Entity
public class TempDetailTemplate {
    private @Id @GeneratedValue Long id;
    private Long master_id;
    private String idx;
    private String operator;
    private String val;
    private String valText;
}
