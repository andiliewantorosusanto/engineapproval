package com.bcafinance.engineapproval.repository;

import com.bcafinance.engineapproval.model.DeviasiParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviasiParamRepository extends JpaRepository<DeviasiParam,String>{
    
}
