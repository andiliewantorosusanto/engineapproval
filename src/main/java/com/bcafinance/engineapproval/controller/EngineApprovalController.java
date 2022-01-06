package com.bcafinance.engineapproval.controller;

import com.bcafinance.engineapproval.request.ApprovalRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping
public class EngineApprovalController {
    
    @PostMapping("/approval")
    String approval(ApprovalRequest request) {
        return "helloworld";
    }
    
}
