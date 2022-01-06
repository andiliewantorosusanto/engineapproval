package com.bcafinance.engineapproval.controller;

import java.util.Date;

import com.bcafinance.engineapproval.model.LogApi;
import com.bcafinance.engineapproval.repository.LogApiRepository;
import com.bcafinance.engineapproval.request.ApprovalRequest;
import com.bcafinance.engineapproval.response.ApprovalResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping
public class EngineApprovalController {
    
    @Autowired
    LogApiRepository logApiRepository;

    @PostMapping("/approval")
    ApprovalResponse approval(ApprovalRequest request) {
        ApprovalResponse a = new ApprovalResponse();
        LogApi logApi = new LogApi(null,"Tyes",null,1,"hm?",new Date(),null);
        logApi = logApiRepository.save(logApi);

        return new ApprovalResponse("test","tast","tust");
    }
    
}
