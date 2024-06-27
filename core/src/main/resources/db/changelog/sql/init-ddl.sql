CREATE SCHEMA IF NOT EXISTS lms;

CREATE TABLE IF NOT EXISTS lms.category
(
    category_id BIGSERIAL PRIMARY KEY,
    name        TEXT      NOT NULL,
    created     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated     TIMESTAMP
);

CREATE TABLE IF NOT EXISTS lms."user"
(
    user_id  BIGSERIAL PRIMARY KEY,
    name     VARCHAR   NOT NULL,
    email    VARCHAR   NOT NULL,
    password VARCHAR   NOT NULL,
    role     VARCHAR   NOT NULL,
    created  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated  TIMESTAMP
);

CREATE TABLE IF NOT EXISTS lms.course
(
    course_id   SERIAL PRIMARY KEY,
    category_id BIGINT REFERENCES lms.category (category_id) ON DELETE CASCADE,
    creator_id  BIGINT REFERENCES lms."user" (user_id) ON DELETE CASCADE,
    name        VARCHAR   NOT NULL,
    description TEXT,
    created     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated     TIMESTAMP
);

CREATE TABLE IF NOT EXISTS lms.enrollment
(
    enrollment_id BIGSERIAL PRIMARY KEY,
    user_id       BIGINT    NOT NULL REFERENCES lms.user (user_id) ON DELETE CASCADE,
    course_id     BIGINT    NOT NULL REFERENCES lms.course (course_id) ON DELETE CASCADE,
    created       TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS lms.chapter
(
    chapter_id  BIGSERIAL PRIMARY KEY,
    course_id   BIGINT    NOT NULL REFERENCES lms.course (course_id) ON DELETE CASCADE,
    title       VARCHAR   NOT NULL,
    description VARCHAR,
    position    INTEGER,
    isPublished BOOLEAN,
    created     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated     TIMESTAMP
);

CREATE TABLE IF NOT EXISTS lms.attachment
(
    attachment_id BIGSERIAL PRIMARY KEY,
    chapter_id    BIGINT    NOT NULL REFERENCES lms.chapter (chapter_id) ON DELETE CASCADE,
    name          VARCHAR   NOT NULL,
    type          VARCHAR,
    file_id       BIGINT,
    created       TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated       TIMESTAMP,
    position      INTEGER
);

CREATE TABLE IF NOT EXISTS lms.file
(
    file_id        BIGSERIAL PRIMARY KEY,
    orig_name VARCHAR NOT NULL,
    file_name VARCHAR NOT NULL,
    bucket    VARCHAR NOT NULL
);