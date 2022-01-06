package com.bcafinance.engineapproval.repository;

import com.bcafinance.engineapproval.model.LogApi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogApiRepository extends JpaRepository<LogApi,Long> {
    
}
