CREATE TABLE lms.user
(
    user_id BIGSERIAL PRIMARY KEY,
    name        TEXT      NOT NULL,
    created     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated     TIMESTAMP
);