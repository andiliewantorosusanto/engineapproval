package com.bcafinance.engineapproval.repository;

import com.bcafinance.engineapproval.model.TemplateParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateParamRepository extends JpaRepository<TemplateParam,String>{
    
}
