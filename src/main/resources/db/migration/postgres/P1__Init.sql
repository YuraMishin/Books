CREATE TABLE IF NOT EXISTS books
(
    id         BIGSERIAL PRIMARY KEY,
    title      VARCHAR(50) NOT NULL,
    created_at TIMESTAMP   NOT NULL DEFAULT now(),
    updated_at TIMESTAMP   NOT NULL DEFAULT now(),
    version    BIGINT      NOT NULL DEFAULT 1
);
