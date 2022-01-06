package com.bcafinance.engineapproval.controller;

import java.util.Date;
import java.util.UUID;

import com.bcafinance.engineapproval.model.LogApi;
import com.bcafinance.engineapproval.repository.LogApiRepository;
import com.bcafinance.engineapproval.request.ApprovalRequest;
import com.bcafinance.engineapproval.response.ApprovalResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping
public class EngineApprovalController {
    
    Logger logger = LoggerFactory.getLogger(EngineApprovalController.class);

    @Autowired
    LogApiRepository logApiRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/approval")
    ApprovalResponse approval(@RequestBody ApprovalRequest request) {
        ApprovalResponse response = new ApprovalResponse("00","sukses","1");
        String token = UUID.randomUUID().toString();
        LogApi logApi = new LogApi(null,request,null,1,1,new Date(),null);
        logApi = logApiRepository.save(logApi);

        try {
            logApi.setResJSON(objectMapper.writeValueAsString(response));
            logApi.setUpdateddate(new Date());
            logApiRepository.save(logApi);
        } catch (Exception e) {
            logger.error(e.toString());
        }

        request.

        

        return response;
    }
    
}
