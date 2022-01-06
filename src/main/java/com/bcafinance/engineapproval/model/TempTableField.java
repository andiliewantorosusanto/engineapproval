package com.bcafinance.engineapproval.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data @Entity
public class TempTableField {
    private @Id @GeneratedValue String id;
    private String val;
}
