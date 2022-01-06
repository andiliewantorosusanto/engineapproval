package com.bcafinance.engineapproval.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data @Entity
public class TemplateParam {
    private @Id String token;
    private String idx;
    private String val;
}
