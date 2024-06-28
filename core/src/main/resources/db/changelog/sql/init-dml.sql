INSERT INTO lms.category (category_id, name)
VALUES (1, 'Java'),
       (2, 'Math'),
       (3, 'Physics'),
       (4, 'Test Category'),
       (5, 'Category 5');

INSERT INTO lms."user" (user_id, name, email, password, role)
VALUES (1, 'Alex', 's.bosov2012@yandex.ru', '$2a$10$1D7QTBMr1lrXheLN8HV9iuhl7L.Zu5GBMn.y0guNazBGiPrIIfuhK', 'ADMINISTRATOR'),
       (2, 'Kirill', 'kirill@gmail.com', '$2a$10$1D7QTBMr1lrXheLN8HV9iuhl7L.Zu5GBMn.y0guNazBGiPrIIfuhK', 'STUDENT'),
       (3, 'Rostislav', 'rostislav@example.com', '$2a$10$1D7QTBMr1lrXheLN8HV9iuhl7L.Zu5GBMn.y0guNazBGiPrIIfuhK', 'TEACHER'),
       (4, 'Nikita', 'mikita@yandex.ru', '$2a$10$1D7QTBMr1lrXheLN8HV9iuhl7L.Zu5GBMn.y0guNazBGiPrIIfuhK', 'TEACHER'),
       (5, 'Admin', 'admin@admin.com', '$2a$10$1D7QTBMr1lrXheLN8HV9iuhl7L.Zu5GBMn.y0guNazBGiPrIIfuhK', 'STUDENT');

INSERT INTO lms.course (course_id, category_id, creator_id, title, description, image_url, price, is_published)
VALUES (1, 1, 3, 'Spring', 'Context', 'https://utfs.io/f/9acf5df1-f7a0-4297-ba88-c2222c062933-c8axe2.png', 1000, true),
       (2, 1, 3, 'Hibernate', 'Data base course', 'https://utfs.io/f/9acf5df1-f7a0-4297-ba88-c2222c062933-c8axe2.png', 5000, true),
       (3, 2, 4, 'Minio', 'Description for Course 3', 'https://utfs.io/f/9acf5df1-f7a0-4297-ba88-c2222c062933-c8axe2.png', 1324123, true),
       (4, 2, 4, 'Test course', 'Description for Course 4', 'https://utfs.io/f/9acf5df1-f7a0-4297-ba88-c2222c062933-c8axe2.png', 11, true),
       (5, 3, 3, 'Course 5', 'Description for Course 5', 'https://utfs.io/f/9acf5df1-f7a0-4297-ba88-c2222c062933-c8axe2.png', 234, true),
       (6, 3, 3, 'Course 6', 'Description for Course 6', 'https://utfs.io/f/9acf5df1-f7a0-4297-ba88-c2222c062933-c8axe2.png', 432, true),
       (7, 4, 4, 'Course 7', 'Description for Course 7', 'https://utfs.io/f/9acf5df1-f7a0-4297-ba88-c2222c062933-c8axe2.png', 4321341, true),
       (8, 4, 4, 'Course 8', 'Description for Course 8', 'https://utfs.io/f/9acf5df1-f7a0-4297-ba88-c2222c062933-c8axe2.png', 22, true),
       (9, 5, 3, 'Course 9', 'Description for Course 9', 'https://utfs.io/f/9acf5df1-f7a0-4297-ba88-c2222c062933-c8axe2.png', 1000, true),
       (10, 5, 3, 'Course 10', 'Description for Course 10', 'https://utfs.io/f/9acf5df1-f7a0-4297-ba88-c2222c062933-c8axe2.png', 1000, true);

INSERT INTO lms.chapter (course_id, title, description, position, is_published)
VALUES (1, 'Chapter 1.1', 'Description for Chapter 1.1', 1, TRUE),
       (1, 'Chapter 1.2', 'Description for Chapter 1.2', 2, TRUE),
       (1, 'Chapter 1.3', 'Description for Chapter 1.3', 3, TRUE),
       (2, 'Chapter 2.1', 'Description for Chapter 2.1', 1, TRUE),
       (2, 'Chapter 2.2', 'Description for Chapter 2.2', 2, TRUE),
       (2, 'Chapter 2.3', 'Description for Chapter 2.3', 3, TRUE),
       (3, 'Chapter 3.1', 'Description for Chapter 3.1', 1, TRUE),
       (3, 'Chapter 3.2', 'Description for Chapter 3.2', 2, TRUE),
       (3, 'Chapter 3.3', 'Description for Chapter 3.3', 3, TRUE),
       (4, 'Chapter 4.1', 'Description for Chapter 4.1', 1, TRUE),
       (4, 'Chapter 4.2', 'Description for Chapter 4.2', 2, TRUE),
       (4, 'Chapter 4.3', 'Description for Chapter 4.3', 3, TRUE),
       (5, 'Chapter 5.1', 'Description for Chapter 5.1', 1, TRUE),
       (5, 'Chapter 5.2', 'Description for Chapter 5.2', 2, TRUE),
       (5, 'Chapter 5.3', 'Description for Chapter 5.3', 3, TRUE),
       (6, 'Chapter 6.1', 'Description for Chapter 6.1', 1, TRUE),
       (6, 'Chapter 6.2', 'Description for Chapter 6.2', 2, TRUE),
       (6, 'Chapter 6.3', 'Description for Chapter 6.3', 3, TRUE),
       (7, 'Chapter 7.1', 'Description for Chapter 7.1', 1, TRUE),
       (7, 'Chapter 7.2', 'Description for Chapter 7.2', 2, TRUE),
       (7, 'Chapter 7.3', 'Description for Chapter 7.3', 3, TRUE),
       (8, 'Chapter 8.1', 'Description for Chapter 8.1', 1, TRUE),
       (8, 'Chapter 8.2', 'Description for Chapter 8.2', 2, TRUE),
       (8, 'Chapter 8.3', 'Description for Chapter 8.3', 3, TRUE),
       (9, 'Chapter 9.1', 'Description for Chapter 9.1', 1, TRUE),
       (9, 'Chapter 9.2', 'Description for Chapter 9.2', 2, TRUE),
       (9, 'Chapter 9.3', 'Description for Chapter 9.3', 3, TRUE),
       (10, 'Chapter 10.1', 'Description for Chapter 10.1', 1, TRUE),
       (10, 'Chapter 10.2', 'Description for Chapter 10.2', 2, TRUE),
       (10, 'Chapter 10.3', 'Description for Chapter 10.3', 3, TRUE);