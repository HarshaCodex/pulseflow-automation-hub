package com.pulseflow.rule_service.repository;

import com.pulseflow.rule_service.domain.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RuleRepository extends JpaRepository<Rule, UUID> {
}
