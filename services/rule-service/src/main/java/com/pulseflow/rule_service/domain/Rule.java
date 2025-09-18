package com.pulseflow.rule_service.domain;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "rules")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rule {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "status", nullable = false, length = 20)
    private String status = "ACTIVE";

    @Column(name = "schedule_cron", nullable = false, length = 100)
    private String scheduleCron;

    @Column(name = "trigger_type", nullable = false, length = 50)
    private String triggerType;

    @Type(JsonType.class)
    @Column(name = "trigger_config", columnDefinition = "jsonb", nullable = false)
    private Map<String, Object> triggerConfig;

    @Column(name = "action_type", nullable = false, length = 50)
    private String actionType;

    @Type(JsonType.class)
    @Column(name = "action_config", columnDefinition = "jsonb", nullable = false)
    private Map<String, Object> actionConfig;

    @CreatedDate
    @Column(name = "created_at", columnDefinition = "TIMESTAMPTZ", updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", columnDefinition = "TIMESTAMPTZ")
    private Instant updatedAt;

}
