package com.bcafinance.engineapproval.repository;

import java.math.BigDecimal;

import com.bcafinance.engineapproval.view.CheckApprovalView;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckApprovalViewRepository extends CrudRepository<CheckApprovalView,String>{
    @Query(value = "EXEC SP_Check_Approval_Level_PH :PH", nativeQuery = true)
    CheckApprovalView checkApprovalLevelPH(@Param("PH") BigDecimal PH);

    @Query(value = "EXEC SP_Get_Result_Deviasi :kodeDeviasi", nativeQuery = true)
    CheckApprovalView checkApprovalLevelDeviasi(@Param("kodeDeviasi") String kodeDeviasi);

    @Query(value = "EXEC SP_Get_Result_Template :token", nativeQuery = true)
    CheckApprovalView checkApprovalLevelTemplate(@Param("token") String token);
}
