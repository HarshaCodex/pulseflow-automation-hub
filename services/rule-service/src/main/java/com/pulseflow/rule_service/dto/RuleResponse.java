package com.pulseflow.rule_service.dto;

import lombok.*;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RuleResponse {
    private UUID id;
    private String name;
    private String status;
    private String scheduleCron;
    private String triggerType;
    private Map<String, Object> triggerConfig;
    private String actionType;
    private Map<String, Object> actionConfig;
    private Instant createdAt;
    private Instant updatedAt;
}
