CREATE SCHEMA IF NOT EXISTS lms;

CREATE TABLE lms.category
(
    category_id BIGSERIAL PRIMARY KEY,
    name        TEXT NOT NULL,
    created     TIMESTAMP,
    updated     TIMESTAMP
);

--
-- CREATE TABLE dormentor.dorm
-- (
--     dorm_id      BIGSERIAL PRIMARY KEY,
--     address      TEXT NOT NULL,
--     institute_id BIGINT REFERENCES dormentor.institute (institute_id)
-- );
--
-- CREATE TABLE dormentor.role
-- (
--     role_id BIGSERIAL PRIMARY KEY,
--     name    VARCHAR NOT NULL
-- );
--
-- CREATE TABLE IF NOT EXISTS dormentor.user
-- (
--     user_id    BIGSERIAL PRIMARY KEY,
--     username   VARCHAR,
--     email      VARCHAR,
--     password   VARCHAR,
--     course     BIGINT,
--     grade      VARCHAR,
--     ed_program VARCHAR,
--     role_id    BIGINT REFERENCES dormentor.role (role_id),
--     dorm_id    BIGINT REFERENCES dormentor.dorm (dorm_id),
--     created    TIMESTAMP,
--     updated    TIMESTAMP
-- );
--
-- CREATE TABLE dormentor.institute_to_user
-- (
--     institute_id BIGINT NOT NULL REFERENCES dormentor.institute (institute_id),
--     user_id      BIGINT NOT NULL REFERENCES dormentor.user (user_id),
--     PRIMARY KEY (institute_id, user_id)
-- );
--
-- CREATE TABLE dormentor.section
-- (
--     section_id BIGSERIAL PRIMARY KEY,
--     header     VARCHAR NOT NULL,
--     text       VARCHAR NOT NULL,
--     dorm_id    BIGINT  NOT NULL REFERENCES dormentor.dorm (dorm_id),
--     created    TIMESTAMP,
--     updated    TIMESTAMP
-- );

-- TODO: check, may be update this ddls and create ddl for facility)