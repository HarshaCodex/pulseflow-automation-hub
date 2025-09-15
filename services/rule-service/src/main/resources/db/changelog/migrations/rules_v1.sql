CREATE TABLE IF NOT EXISTS rules (
id                  UUID PRIMARY KEY,
name                VARCHAR(100) NOT NULL,
status              VARCHAR(20)  NOT NULL DEFAULT 'ACTIVE',
schedule_cron       VARCHAR(100) NOT NULL,
trigger_type        VARCHAR(50)  NOT NULL,
trigger_config      JSONB        NOT NULL,
action_type         VARCHAR(50)  NOT NULL,
action_config       JSONB        NOT NULL,
created_at          TIMESTAMPTZ  NOT NULL DEFAULT NOW(),
updated_at          TIMESTAMPTZ  NOT NULL DEFAULT NOW()
);

CREATE INDEX IF NOT EXISTS idx_rules_trigger_type ON rules (trigger_type);
CREATE INDEX IF NOT EXISTS idx_rules_action_type  ON rules (action_type);