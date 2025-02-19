CREATE SCHEMA IF NOT EXISTS lms;

CREATE TABLE IF NOT EXISTS lms.facility
(
    facility_id BIGSERIAL PRIMARY KEY,
    name        VARCHAR   NOT NULL,
    created_at  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP
);

CREATE TABLE IF NOT EXISTS lms.category
(
    category_id BIGSERIAL PRIMARY KEY,
    name        TEXT      NOT NULL,
    created_at  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP
);

CREATE TABLE IF NOT EXISTS lms."user"
(
    user_id    BIGSERIAL PRIMARY KEY,
    name       VARCHAR   NOT NULL,
    email      VARCHAR   NOT NULL,
    password   VARCHAR   NOT NULL,
    role       VARCHAR   NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS lms.course
(
    course_id    BIGSERIAL PRIMARY KEY,
    creator_id   BIGINT REFERENCES lms."user" (user_id) ON DELETE CASCADE,
    title        VARCHAR   NOT NULL,
    description  TEXT,
    image_url    VARCHAR,
    price        DOUBLE PRECISION,
    is_published BOOLEAN,
    category_id  BIGINT REFERENCES lms.category (category_id) ON DELETE CASCADE,
    facility_id  BIGINT REFERENCES lms.facility (facility_id) ON DELETE CASCADE,
    created_at   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP
);

CREATE TABLE IF NOT EXISTS lms.purchase
(
    purchase_id BIGSERIAL PRIMARY KEY,
    user_id     BIGINT REFERENCES lms."user" (user_id) ON DELETE CASCADE,
    course_id   BIGINT REFERENCES lms.course (course_id) ON DELETE CASCADE,
    created_at  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP
);

CREATE TABLE IF NOT EXISTS lms.enrollment
(
    enrollment_id BIGSERIAL PRIMARY KEY,
    user_id       BIGINT    NOT NULL REFERENCES lms.user (user_id) ON DELETE CASCADE,
    course_id     BIGINT    NOT NULL REFERENCES lms.course (course_id) ON DELETE CASCADE,
    created_at    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS lms.chapter
(
    chapter_id   BIGSERIAL PRIMARY KEY,
    course_id    BIGINT    NOT NULL REFERENCES lms.course (course_id) ON DELETE CASCADE,
    title        VARCHAR   NOT NULL,
    description  VARCHAR,
    position     INTEGER,
    is_published BOOLEAN,
    created_at   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP
);

CREATE TABLE IF NOT EXISTS lms.attachment
(
    attachment_id BIGSERIAL PRIMARY KEY,
    course_id     BIGINT    NOT NULL REFERENCES lms.course (course_id) ON DELETE CASCADE,
    name          VARCHAR   NOT NULL,
    type          VARCHAR,
    url           VARCHAR,
    file_id       BIGINT,
    created_at    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMP,
    position      INTEGER
);

CREATE TABLE IF NOT EXISTS lms.file
(
    file_id   BIGSERIAL PRIMARY KEY,
    orig_name VARCHAR NOT NULL,
    file_name VARCHAR NOT NULL,
    bucket    VARCHAR NOT NULL
);