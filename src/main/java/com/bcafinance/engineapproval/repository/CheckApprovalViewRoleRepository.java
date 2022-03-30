package com.bcafinance.engineapproval.repository;

import java.math.BigDecimal;

import com.bcafinance.engineapproval.view.CheckApprovalRoleView;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckApprovalViewRoleRepository extends CrudRepository<CheckApprovalRoleView,String>{
    @Query(value = "EXEC SP_Get_Result_Deviasi_Role :kodeDeviasi", nativeQuery = true)
    CheckApprovalRoleView checkApprovalLevelDeviasiRole(@Param("kodeDeviasi") String kodeDeviasi);
}
