package com.bcafinance.engineapproval.repository;

import com.bcafinance.engineapproval.model.MasterDeviasi;
import com.bcafinance.engineapproval.view.CheckApprovalView;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterDeviasiRepository extends JpaRepository<MasterDeviasi,Long>{
    @Procedure("SP_Get_Result_Deviasi")
    CheckApprovalView checkApprovalLevelDeviasi(String token);
}
