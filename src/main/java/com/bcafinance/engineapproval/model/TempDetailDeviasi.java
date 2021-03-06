package com.bcafinance.engineapproval.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data @Entity @NoArgsConstructor @AllArgsConstructor
@Table(name = "temp_ME_Approval_Detail_Deviasi")
public class TempDetailDeviasi {
    private @Id @GeneratedValue(strategy=GenerationType.IDENTITY) int id;
    private Long master_id;
    private String kode_deviasi;
    private String nama_deviasi;
}
