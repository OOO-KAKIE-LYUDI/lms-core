INSERT INTO lms.category (name)
VALUES ('Java'),
       ('Math'),
       ('Physics'),
       ('Test Category'),
       ('Category 5');

INSERT INTO lms."user" (name, email, password, role)
VALUES ('Alex', 's.bosov2012@yandex.ru', '$2a$10$1D7QTBMr1lrXheLN8HV9iuhl7L.Zu5GBMn.y0guNazBGiPrIIfuhK', 'STUDENT'),
       ('Kirill', 'kirill@gmail.com', '$2a$10$1D7QTBMr1lrXheLN8HV9iuhl7L.Zu5GBMn.y0guNazBGiPrIIfuhK', 'STUDENT'),
       ('Rostislav', 'rostislav@example.com', '$2a$10$1D7QTBMr1lrXheLN8HV9iuhl7L.Zu5GBMn.y0guNazBGiPrIIfuhK', 'TEACHER'),
       ('Nikita', 'mikita@yandex.ru', '$2a$10$1D7QTBMr1lrXheLN8HV9iuhl7L.Zu5GBMn.y0guNazBGiPrIIfuhK', 'TEACHER'),
       ('Admin', 'admin@admin.com', '$2a$10$1D7QTBMr1lrXheLN8HV9iuhl7L.Zu5GBMn.y0guNazBGiPrIIfuhK', 'ADMIN');

INSERT INTO lms.course (category_id, creator_id, name, description)
VALUES (1, 3, 'Spring', 'Context'),
       (1, 3, 'Hibernate', 'Data base course'),
       (2, 4, 'Minio', 'Description for Course 3'),
       (2, 4, 'Test course', 'Description for Course 4'),
       (3, 3, 'Course 5', 'Description for Course 5'),
       (3, 3, 'Course 6', 'Description for Course 6'),
       (4, 4, 'Course 7', 'Description for Course 7'),
       (4, 4, 'Course 8', 'Description for Course 8'),
       (5, 3, 'Course 9', 'Description for Course 9'),
       (5, 3, 'Course 10', 'Description for Course 10');

INSERT INTO lms.chapter (course_id, title, description, position, isPublished)
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