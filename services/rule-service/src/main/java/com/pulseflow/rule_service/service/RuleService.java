package com.pulseflow.rule_service.service;

import com.pulseflow.rule_service.domain.Rule;
import com.pulseflow.rule_service.dto.RuleRequest;
import com.pulseflow.rule_service.dto.RuleResponse;
import com.pulseflow.rule_service.mapper.RuleMapper;
import com.pulseflow.rule_service.repository.RuleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class RuleService {

    private final RuleRepository ruleRepository;

    private final RuleMapper ruleMapper;

    public RuleResponse createRule(RuleRequest ruleRequest) {
        try {
            Rule rule = ruleMapper.ruleRequestToRule(ruleRequest);
            ruleRepository.save(rule);
            return ruleMapper.ruleToRuleResponse(rule);
        } catch (Exception e) {
            log.error("Exception occurred while saving rule:{} to database:", ruleRequest, e);
            throw e;
        }
    }
}
