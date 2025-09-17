package com.pulseflow.rule_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RuleRequest {

    @NotBlank(message = "Rule name is required")
    private String name;

    private String status = "ACTIVE";

    @NotBlank(message = "Schedule cron is required")
    private String scheduleCron;

    @NotBlank(message = "Trigger type is required")
    private String triggerType;

    @NotNull(message = "Trigger config is required")
    private Map<String, Object> triggerConfig;

    @NotBlank(message = "Action type is required")
    private String actionType;

    @NotNull(message = "Action config is required")
    private Map<String, Object> actionConfig;
}
