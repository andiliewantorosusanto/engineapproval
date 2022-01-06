package com.bcafinance.engineapproval.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping
public class EngineApprovalController {
    
    @PostMapping("/approvalLevel")
    void approvalLevel(@RequestBody Model model) {
        
    }
    
}
