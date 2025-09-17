package com.pulseflow.rule_service.controller;

import com.pulseflow.rule_service.dto.RuleRequest;
import com.pulseflow.rule_service.dto.RuleResponse;
import com.pulseflow.rule_service.service.RuleService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class RuleController {

    private final RuleService ruleService;

    @Operation(summary = "Create a new rule", description = "Create a new rule and will be saved to database")
    @PostMapping(path = "/rule", produces = "application/json")
    public ResponseEntity<RuleResponse> createRule(@RequestBody @Valid @NotNull RuleRequest ruleRequest) {
        RuleResponse ruleResponse = ruleService.createRule(ruleRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(ruleResponse);
    }
}
