-- Вставляем задачи (problems)
INSERT INTO lms.problem (problem_id, title, problem_statement, constraints, category, difficulty, likes, dislikes,
                         video_id, created_at, "order", link)
VALUES (1, 'Two Sum',
        '<p>Дан массив целых чисел <code>nums</code> и целое число <code>target</code>,
        верните индексы двух чисел таких, что их сумма равна <code>target</code>.</p>',
        '<ul><li>2 ≤ nums.length ≤ 10</li><li>-10 ≤ nums[i] ≤ 10</li><li>-10 ≤ target ≤ 10</li></ul>',
        'Math', 'easy', 120, 8, 'dQw4w9WgXcQ', CURRENT_TIMESTAMP, 1, 'two-sum'),

       (2, 'Palindrome Number',
        '<p>Определите, является ли заданное целое число палиндромом.</p>',
        '<ul><li>-2³¹ ≤ x ≤ 2³¹ - 1</li></ul>',
        'Algorithms', 'medium', 95, 12, NULL, CURRENT_TIMESTAMP, 2, 'palindrome-number'),

       (3, 'Longest Substring Without Repeating Characters',
        '<p>Найти длину самой длинной подстроки без повторяющихся символов.</p>',
        '<ul><li>0 ≤ s.length ≤ 5 * 10⁴</li></ul>',
        'Strings', 'hard', 80, 15, 'tgbNymZ7vqY', CURRENT_TIMESTAMP, 3, 'jump-game'),

       (4, 'Valid Parentheses',
        '<p>Определите, является ли входная строка допустимой (правильно сбалансированной последовательностью скобок).</p>',
        '<ul><li>1 ≤ s.length ≤ 10⁴</li></ul>',
        'Stack', 'easy', 150, 5, 'KsW6owIUwEU', CURRENT_TIMESTAMP, 4, 'valid-parentheses')
ON CONFLICT (problem_id) DO NOTHING;

-- Вставляем примеры (examples)
INSERT INTO lms.example (example_id, problem_id, input_text, output_text, explanation, img)
VALUES
    -- Two Sum
    (1, 1, 'nums = [2,7,11,15], target = 9', '[0,1]', 'Потому что nums[0] + nums[1] == 9.', NULL),
    (2, 1, 'nums = [3,2,4], target = 6', '[1,2]', 'Потому что nums[1] + nums[2] == 6.', NULL),
    (3, 1, 'nums = [3,3], target = 6', '[0,1]', '', NULL),

    -- Palindrome Number
    (4, 2, 'x = 121', 'true', '121 читается одинаково справа налево и слева направо.', NULL),
    (5, 2, 'x = -121', 'false', '-121 читается как 121- в обратном порядке.', NULL),
    (6, 2, 'x = 10', 'false', '10 не является палиндромом.', NULL),

    -- Longest Substring Without Repeating Characters
    (7, 3, 's = "abcabcbb"', '3', 'Наибольшая подстрока без повторов - "abc".', NULL),
    (8, 3, 's = "bbbbb"', '1', 'Наибольшая подстрока без повторов - "b".', NULL),
    (9, 3, 's = "pwwkew"', '3', 'Наибольшая подстрока без повторов - "wke".', NULL),

    -- Valid Parentheses
    (10, 4, 's = "()"', 'true', 'Скобки правильно сбалансированы.', NULL),
    (11, 4, 's = "()[]{}"', 'true', 'Скобки правильно сбалансированы.', NULL),
    (12, 4, 's = "(]"', 'false', 'Открывающая "(" не соответствует закрывающей "]".', NULL)
ON CONFLICT (example_id) DO NOTHING;

INSERT INTO lms.test_case (test_case_id, problem_id, input_text, output_text, explanation, img)
VALUES (1, 1, 'test', 'test', null, null);

INSERT INTO lms.language (language_id, name, extension, judge_code, created_at, updated_at)
VALUES (1, 'Java', '8', 55, '2025-02-07 15:27:59.183527', null);

