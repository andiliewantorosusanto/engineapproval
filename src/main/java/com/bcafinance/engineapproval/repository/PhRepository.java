package com.bcafinance.engineapproval.repository;

import com.bcafinance.engineapproval.model.Ph;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhRepository extends JpaRepository<Ph,Integer>{

}
