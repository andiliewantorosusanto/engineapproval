package com.bcafinance.engineapproval.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.bcafinance.engineapproval.constant.ErrorCode;
import com.bcafinance.engineapproval.exception.ApprovalLevelNotFoundException;
import com.bcafinance.engineapproval.exception.InvalidBodyRequestException;
import com.bcafinance.engineapproval.model.DeviasiParam;
import com.bcafinance.engineapproval.model.LogApi;
import com.bcafinance.engineapproval.model.TemplateParam;
import com.bcafinance.engineapproval.repository.CheckApprovalViewRepository;
import com.bcafinance.engineapproval.repository.DeviasiParamRepository;
import com.bcafinance.engineapproval.repository.LogApiRepository;
import com.bcafinance.engineapproval.repository.TemplateParamRepository;
import com.bcafinance.engineapproval.request.ApprovalRequest;
import com.bcafinance.engineapproval.response.ApprovalResponse;
import com.bcafinance.engineapproval.view.CheckApprovalView;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Joiner;

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
    CheckApprovalViewRepository checkApprovalViewRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/approval")
    ApprovalResponse approval(@RequestBody ApprovalRequest request) {
        ApprovalResponse response = new ApprovalResponse();
        LogApi logApi = new LogApi();

        try {
            String token = UUID.randomUUID().toString();
            logger.info("Token Created : " + token);

            logApi = this.initLogApi(logApi, objectMapper.writeValueAsString(request), _TEMPORARY_USER_DELETE_THIS_LATER);
            
            if(!request.bodyIsValid()) { 
                throw new InvalidBodyRequestException();
            }
            
            //get maximum Application Level
            Integer maxAppLevel = 0;
            maxAppLevel = this.getApprovalLevelPh(request.getPh(), maxAppLevel);
            maxAppLevel = this.getApprovalLevelDeviasi(request.getDeviasi(), maxAppLevel);
            maxAppLevel = this.getApprovalLevelTemplate(request.getTemplate(), token, maxAppLevel);

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

    Integer getApprovalLevelPh(BigDecimal ph,Integer appLevel) 
        throws ApprovalLevelNotFoundException {
        try {
            CheckApprovalView phApprovalResult = checkApprovalViewRepository.checkApprovalLevelPH(ph);
            logger.info("Ph : " + phApprovalResult);
            if(phApprovalResult.getErrorCode().equals(ErrorCode.FAILED)) {
                throw new ApprovalLevelNotFoundException(phApprovalResult);
            }
            if(phApprovalResult.getAppLevel() > appLevel) appLevel = phApprovalResult.getAppLevel();
        } catch (ApprovalLevelNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

        return appLevel;
    }

    Integer getApprovalLevelTemplate(List<TemplateParam> templateParams, String token,Integer appLevel) 
        throws ApprovalLevelNotFoundException {
        try {
            if(!templateParams.isEmpty()) {
                this.saveTemplateRequest(templateParams, token);
                CheckApprovalView templateApprovalResult = checkApprovalViewRepository.checkApprovalLevelTemplate(token);
                logger.info("Template : " + templateApprovalResult);
                if(templateApprovalResult.getErrorCode().equals(ErrorCode.FAILED)) {
                    throw new ApprovalLevelNotFoundException(templateApprovalResult);
                }
                if(templateApprovalResult.getAppLevel() > appLevel) appLevel = templateApprovalResult.getAppLevel();
            }
        } catch (ApprovalLevelNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        
        return appLevel;
    }

    Integer getApprovalLevelDeviasi(List<DeviasiParam> deviasiParams,Integer appLevel) 
        throws ApprovalLevelNotFoundException {
        try {
            if(!deviasiParams.isEmpty()) {
                List<String> kodeDeviasi =deviasiParams.stream().map(param -> param.getKodeDeviasi()).collect(Collectors.toList());
                String stringKodeDeviasi = Joiner.on(',').join(kodeDeviasi);

                CheckApprovalView deviasiApprovalResult = checkApprovalViewRepository.checkApprovalLevelDeviasi(stringKodeDeviasi);
                logger.info("Deviasi : " + deviasiApprovalResult);
                if(deviasiApprovalResult.getErrorCode().equals(ErrorCode.FAILED)) {
                    throw new ApprovalLevelNotFoundException(deviasiApprovalResult);
                }
                if(deviasiApprovalResult.getAppLevel() > appLevel) appLevel = deviasiApprovalResult.getAppLevel();
            }
        } catch (ApprovalLevelNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

        return appLevel;
    }

    void saveTemplateRequest(List<TemplateParam> templateParams, String token) {
        templateParams.forEach((templateParam) -> {
            templateParam.setToken(token);
            templateParamRepository.save(templateParam);
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
