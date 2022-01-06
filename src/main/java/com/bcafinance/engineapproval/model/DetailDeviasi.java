package com.bcafinance.engineapproval.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data @Entity
public class DetailDeviasi {
    private @Id @GeneratedValue Long id;
    private Long master_id;
    private String kode_deviasi;
    private String nama_deviasi;
}
