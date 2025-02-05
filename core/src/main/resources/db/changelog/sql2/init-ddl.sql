-- Создание схемы lms, если она еще не существует
CREATE SCHEMA IF NOT EXISTS lms;

-- Создаем таблицу `problem`
CREATE TABLE IF NOT EXISTS lms.problem
(
    problem_id        BIGSERIAL PRIMARY KEY,
    title             VARCHAR(255) NOT NULL,
    problem_statement TEXT         NOT NULL,
    constraints       TEXT         NOT NULL,
    created_at        TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at        TIMESTAMP
);

-- Создаем таблицу `test_case`
CREATE TABLE IF NOT EXISTS lms.test_case
(
    test_case_id BIGSERIAL PRIMARY KEY,
    problem_id   BIGINT NOT NULL,
    input_text   TEXT   NOT NULL,
    output_text  TEXT   NOT NULL,
    explanation  TEXT,
    img          TEXT,
    CONSTRAINT fk_test_case_problem FOREIGN KEY (problem_id) REFERENCES lms.problem (problem_id) ON DELETE CASCADE
);

-- Создаем таблицу example
CREATE TABLE IF NOT EXISTS lms.example
(
    example_id  BIGSERIAL PRIMARY KEY,
    problem_id  BIGINT NOT NULL,
    input_text  TEXT   NOT NULL,
    output_text TEXT   NOT NULL,
    explanation TEXT,
    img         TEXT,
    CONSTRAINT fk_example_problem FOREIGN KEY (problem_id) REFERENCES lms.problem (problem_id) ON DELETE CASCADE
);


-- Таблица для хранения языков программирования
CREATE TABLE IF NOT EXISTS lms.language
(
    language_id BIGSERIAL PRIMARY KEY,
    name        VARCHAR(50) NOT NULL,
    extension   VARCHAR(10) NOT NULL,
    created_at  TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP
);

-- Таблица для хранения решений
CREATE TABLE IF NOT EXISTS lms.submissionEntity
(
    submission_id BIGSERIAL PRIMARY KEY,
    user_id       BIGINT REFERENCES lms."user" (user_id) ON DELETE CASCADE,
    problem_id    BIGINT REFERENCES lms.problem (problem_id) ON DELETE CASCADE,
    language_id   BIGINT REFERENCES lms.language (language_id) ON DELETE CASCADE,
    code          TEXT      NOT NULL,
    status        VARCHAR(20) CHECK (status IN ('pending', 'testing', 'completed', 'failed')) DEFAULT 'pending',
    created_at    TIMESTAMP NOT NULL                                                          DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMP
);

-- Таблица для хранения результатов тестов
CREATE TABLE IF NOT EXISTS lms.test_result
(
    test_result_id BIGSERIAL PRIMARY KEY,
    submission_id  BIGINT REFERENCES lms.submissionEntity (submission_id) ON DELETE CASCADE,
    test_case_id   BIGINT REFERENCES lms.test_case (test_case_id) ON DELETE CASCADE,
    result         VARCHAR(20) CHECK (result IN ('pass', 'fail')),
    error_message  TEXT,
    time           TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Таблица для хранения событий Kafka (например, для мониторинга статуса решения)
CREATE TABLE IF NOT EXISTS lms.kafka_event
(
    event_id   BIGSERIAL PRIMARY KEY,
    event_type VARCHAR(50) CHECK (event_type IN ('SUBMISSION_RECEIVED', 'TESTING_COMPLETED', 'ERROR')),
    event_data JSONB,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE lms.problem
    ADD COLUMN category VARCHAR(255) NOT NULL DEFAULT 'General',
    ADD COLUMN difficulty VARCHAR(20) NOT NULL DEFAULT 'easy',
    ADD COLUMN likes INT NOT NULL DEFAULT 0,
    ADD COLUMN dislikes INT NOT NULL DEFAULT 0,
    ADD COLUMN video_id VARCHAR(255) NULL;
