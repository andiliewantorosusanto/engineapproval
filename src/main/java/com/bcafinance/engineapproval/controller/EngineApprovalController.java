package com.bcafinance.engineapproval.controller;

import java.util.List;
import java.util.UUID;

import com.bcafinance.engineapproval.constant.ErrorCode;
import com.bcafinance.engineapproval.exception.ApprovalLevelNotFoundException;
import com.bcafinance.engineapproval.exception.InvalidBodyRequestException;
import com.bcafinance.engineapproval.model.DeviasiParam;
import com.bcafinance.engineapproval.model.LogApi;
import com.bcafinance.engineapproval.model.TemplateParam;
import com.bcafinance.engineapproval.repository.DeviasiParamRepository;
import com.bcafinance.engineapproval.repository.LogApiRepository;
import com.bcafinance.engineapproval.repository.MasterDeviasiRepository;
import com.bcafinance.engineapproval.repository.MasterTemplateRepository;
import com.bcafinance.engineapproval.repository.PhRepository;
import com.bcafinance.engineapproval.repository.TemplateParamRepository;
import com.bcafinance.engineapproval.request.ApprovalRequest;
import com.bcafinance.engineapproval.response.ApprovalResponse;
import com.bcafinance.engineapproval.view.CheckApprovalView;
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
    
    private int _TEMPORARY_USER_DELETE_THIS_LATER = 1;
    
    Logger logger = LoggerFactory.getLogger(EngineApprovalController.class);

    @Autowired
    LogApiRepository logApiRepository;

    @Autowired
    DeviasiParamRepository deviasiParamRepository;
    @Autowired
    TemplateParamRepository templateParamRepository;
    @Autowired
    PhRepository phRepository;
    @Autowired
    MasterDeviasiRepository masterDeviasiRepository;
    @Autowired
    MasterTemplateRepository masterTemplateRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/approval")
    ApprovalResponse approval(@RequestBody ApprovalRequest request) {
        ApprovalResponse response = new ApprovalResponse();
        LogApi logApi = new LogApi();

        //LOGIC
        try {
            String token = UUID.randomUUID().toString();

            logApi = this.initLogApi(logApi, objectMapper.writeValueAsString(request), _TEMPORARY_USER_DELETE_THIS_LATER);
            this.saveDeviasiRequest(request.getDeviasi(),token);
            this.saveTemplateRequest(request.getTemplate(), token);

            if(!request.bodyIsValid()) { 
                throw new InvalidBodyRequestException();
            }

            Integer maxAppLevel = 0;

            CheckApprovalView phApprovalResult = phRepository.checkApprovalLevelPH(request.getPh());
            if(phApprovalResult.getErrorCode().equals(ErrorCode.FAILED)) {
                throw new ApprovalLevelNotFoundException(phApprovalResult);
            }
            if(phApprovalResult.getAppLevel() > maxAppLevel) maxAppLevel = phApprovalResult.getAppLevel();


            if(!request.getDeviasi().isEmpty()) {
                CheckApprovalView deviasiApprovalResult = masterDeviasiRepository.checkApprovalLevelDeviasi(token);
                if(deviasiApprovalResult.getErrorCode().equals(ErrorCode.FAILED)) {
                    throw new ApprovalLevelNotFoundException(deviasiApprovalResult);
                }
                if(deviasiApprovalResult.getAppLevel() > maxAppLevel) maxAppLevel = deviasiApprovalResult.getAppLevel();
            }

            if(!request.getTemplate().isEmpty()) {
                CheckApprovalView templateApprovalResult = masterTemplateRepository.checkApprovalLevelTemplate(token);
                if(templateApprovalResult.getErrorCode().equals(ErrorCode.FAILED)) {
                    throw new ApprovalLevelNotFoundException(templateApprovalResult);
                }
                if(templateApprovalResult.getAppLevel() > maxAppLevel) maxAppLevel = templateApprovalResult.getAppLevel();
            }

            response.setSuccess("Approval Level Check Succcess", maxAppLevel);

        } catch(InvalidBodyRequestException e) {
            logger.error(e.toString());
            response.setError("Invalid Body Request");
        } catch(ApprovalLevelNotFoundException e) {
            logger.error(e.getCheckApprovalView().getErrorMessage());
            response.setError(e.getCheckApprovalView().getErrorMessage());
        } catch (Exception e) {
            logger.error(e.toString());
            response.setError(e.toString());
        }

        try {
            logApi = this.updateLogApiResponse(logApi, objectMapper.writeValueAsString(response));
        } catch(Exception e) {
            logger.error(e.toString());
        }

        return response;
    }
    

    void saveTemplateRequest(List<TemplateParam> templateParams, String token) {
        templateParams.forEach((templateParam) -> {
            templateParam.setToken(token);
            templateParamRepository.save(templateParam);
        });
    }

    void saveDeviasiRequest(List<DeviasiParam> deviasiParams,String token) {
        deviasiParams.forEach((deviasiParam) -> {
            deviasiParam.setToken(token);
            deviasiParamRepository.save(deviasiParam);
        });
    }

    LogApi initLogApi(LogApi logApi,String reqJSON,int id) {
        logApi.setReqJSON(reqJSON,id);
        return logApiRepository.save(logApi);
    }

    LogApi updateLogApiResponse(LogApi logApi, String resJSON) {
        logApi.setResJSON(resJSON);
        return logApiRepository.save(logApi);
    }
}
