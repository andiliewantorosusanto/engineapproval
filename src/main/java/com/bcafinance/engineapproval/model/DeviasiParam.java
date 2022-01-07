package com.bcafinance.engineapproval.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.bcafinance.engineapproval.compositekey.DeviasiParamCompositeKey;

@Data @Entity  @NoArgsConstructor @AllArgsConstructor
@IdClass(DeviasiParamCompositeKey.class)
@Table(name = "ME_Approval_Deviasi_Param")
public class DeviasiParam {
    private @Id String token;
    private @Id String kodeDeviasi;
}
