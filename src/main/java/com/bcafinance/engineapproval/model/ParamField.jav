package com.bcafinance.engineapproval.model;

import lombok.Data;
import javax.persistence.Entity;

@Data @Entity
public class ParamField {
    private @Id @GeneratedValue Long id;
    private String fieldText;
    private String fieldVal;
    private String fieldSourceTable;
}
