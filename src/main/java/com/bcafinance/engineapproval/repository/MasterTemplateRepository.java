package com.bcafinance.engineapproval.repository;

import com.bcafinance.engineapproval.model.MasterTemplate;
import com.bcafinance.engineapproval.view.CheckApprovalView;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterTemplateRepository extends JpaRepository<MasterTemplate,Long>{
    @Procedure("SP_Get_Result_Template")
    CheckApprovalView checkApprovalLevelTemplate(String token);
}
