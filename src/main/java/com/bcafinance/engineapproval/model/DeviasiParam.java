package com.bcafinance.engineapproval.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data @Entity  @NoArgsConstructor @AllArgsConstructor
@Table(name = "ME_Approval_Deviasi_Param")
public class DeviasiParam {
    private @Id String token;
    private String kodeDeviasi;
}
