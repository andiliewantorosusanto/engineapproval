package com.bcafinance.engineapproval.repository;

import java.math.BigDecimal;

import com.bcafinance.engineapproval.model.Ph;
import com.bcafinance.engineapproval.view.CheckApprovalView;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface PhRepository extends JpaRepository<Ph,Integer>{
    @Procedure("SP_Check_Approval_Level_PH")
    CheckApprovalView checkApprovalLevelPH(BigDecimal PH);
}
