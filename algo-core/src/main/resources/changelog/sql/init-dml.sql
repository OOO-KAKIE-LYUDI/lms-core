INSERT INTO lms.problem (title, description, difficulty)
VALUES ('Two Sum', 'Given an array of integers, return the indices of the two numbers that add up to a specific target.', 'easy');

INSERT INTO lms.language (name, extension)
VALUES ('Python', 'py');

INSERT INTO lms.submission (user_id, problem_id, language_id, code, status)
VALUES (1, 1, 1, 'def two_sum(nums, target): ...', 'pending');

INSERT INTO lms.test_case (problem_id, input, expected_output)
VALUES (1, '[2, 7, 11, 15]', '[0, 1]');

INSERT INTO lms.test_result (submission_id, test_case_id, result, error_message)
VALUES (1, 1, 'pass', NULL);

INSERT INTO lms.kafka_event (event_type, event_data)
VALUES ('SUBMISSION_RECEIVED', '{"submission_id": 1, "status": "pending"}');
