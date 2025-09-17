package com.pulseflow.rule_service.mapper;

import com.pulseflow.rule_service.domain.Rule;
import com.pulseflow.rule_service.dto.RuleRequest;
import com.pulseflow.rule_service.dto.RuleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RuleMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Rule ruleRequestToRule(RuleRequest ruleRequest);

    RuleResponse ruleToRuleResponse(Rule rule);

}
