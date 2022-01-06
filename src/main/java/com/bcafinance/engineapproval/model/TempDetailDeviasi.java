package com.bcafinance.engineapproval.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data @Entity @NoArgsConstructor @AllArgsConstructor
@Table(name = "temp_ME_Approval_DetailDeviasi")
public class TempDetailDeviasi {
    private @Id @GeneratedValue Long id;
    private Long master_id;
    private String kode_deviasi;
    private String nama_deviasi;
}
