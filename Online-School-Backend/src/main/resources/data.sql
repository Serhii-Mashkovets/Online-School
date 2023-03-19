CREATE TABLE courses
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    description TEXT,
    start_date  DATE,
    end_date    DATE
);

CREATE TABLE lectures
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    id_course   INT          NOT NULL,
    name        VARCHAR(255) NOT NULL,
    description TEXT,
    start_time  TIME,
    end_time    TIME,
    FOREIGN KEY (id_course) REFERENCES courses (id) ON DELETE CASCADE
);

CREATE TABLE lecture_materials
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    id_lecture  INT          NOT NULL,
    name        VARCHAR(255) NOT NULL,
    description TEXT,
    url         VARCHAR(255),
    FOREIGN KEY (id_lecture) REFERENCES lectures (id) ON DELETE CASCADE
);

CREATE TABLE homework
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    id_lecture  INT          NOT NULL,
    name        VARCHAR(255) NOT NULL,
    description TEXT,
    deadline    DATE,
    FOREIGN KEY (id_lecture) REFERENCES lectures (id) ON DELETE CASCADE
);

CREATE TABLE course_students
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    id_student INT NOT NULL,
    id_course  INT NOT NULL,
    FOREIGN KEY (id_student) REFERENCES students (id) ON DELETE CASCADE,
    FOREIGN KEY (id_course) REFERENCES courses (id) ON DELETE CASCADE
);

CREATE TABLE course_teachers
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    id_teacher INT NOT NULL,
    id_course  INT NOT NULL,
    FOREIGN KEY (id_teacher) REFERENCES teachers (id) ON DELETE CASCADE,
    FOREIGN KEY (id_course) REFERENCES courses (id) ON DELETE CASCADE
);


INSERT INTO `onlineschool`.`courses` (`course_id`, `course_name`)
VALUES ('1', 'Java Basic');
INSERT INTO `onlineschool`.`courses` (`course_id`, `course_name`)
VALUES ('2', 'SQL Basic');
INSERT INTO `onlineschool`.`courses` (`course_id`, `course_name`)
VALUES ('3', 'Mobile App Developing');

INSERT INTO `onlineschool`.`lectures` (`lecture_id`, `lecture_topic`, `description`, `course_id`)
VALUES ('1', 'Java Lecture 1', 'Very interesting Java', '1');
INSERT INTO `onlineschool`.`lectures` (`lecture_id`, `lecture_topic`, `description`, `course_id`)
VALUES ('2', 'Java Lecture 2', 'Very bad lecture', '1');
INSERT INTO `onlineschool`.`lectures` (`lecture_id`, `lecture_topic`, `description`, `course_id`)
VALUES ('3', 'SQL Lecture 1', 'SQL is very important', '2');
INSERT INTO `onlineschool`.`lectures` (`lecture_id`, `lecture_topic`, `description`, `course_id`)
VALUES ('4', 'SQL Lecture 2', 'SQL is very important 2', '2');
INSERT INTO `onlineschool`.`lectures` (`lecture_id`, `lecture_topic`, `description`, `course_id`)
VALUES ('5', 'Mob App Lecture 1', 'Mob app for Android', '3');
INSERT INTO `onlineschool`.`lectures` (`lecture_id`, `lecture_topic`, `description`, `course_id`)
VALUES ('6', 'Mob App Lecture 2', 'Mob App for Apple', '3');

INSERT INTO `onlineschool`.`additional_materials` (`add_materials_id`, `name`, `lecture_id`, `resource_type`)
VALUES ('1', 'Java add mat', '1', 'BOOK');
INSERT INTO `onlineschool`.`additional_materials` (`add_materials_id`, `name`, `lecture_id`, `resource_type`)
VALUES ('2', 'Java add mat 2', '2', 'VIDEO');
INSERT INTO `onlineschool`.`additional_materials` (`add_materials_id`, `name`, `lecture_id`, `resource_type`)
VALUES ('3', 'SQL add mat', '3', 'BOOK');
INSERT INTO `onlineschool`.`additional_materials` (`add_materials_id`, `name`, `lecture_id`, `resource_type`)
VALUES ('4', 'SQL Add mat 2', '4', 'BOOK');
INSERT INTO `onlineschool`.`additional_materials` (`add_materials_id`, `name`, `lecture_id`, `resource_type`)
VALUES ('5', 'Mob App add mat 1', '5', 'BOOK');
INSERT INTO `onlineschool`.`additional_materials` (`add_materials_id`, `name`, `lecture_id`, `resource_type`)
VALUES ('6', 'Mob App add mat 2', '6', 'BOOK');

INSERT INTO `onlineschool`.`homeworks` (`homework_id`, `name`, `lecture_id`)
VALUES ('1', 'Make Java great again', '1');
INSERT INTO `onlineschool`.`homeworks` (`homework_id`, `name`, `lecture_id`)
VALUES ('2', 'Creat a ropot on Java', '2');
INSERT INTO `onlineschool`.`homeworks` (`homework_id`, `name`, `lecture_id`)
VALUES ('3', 'Make SQL funnier', '3');
INSERT INTO `onlineschool`.`homeworks` (`homework_id`, `name`, `lecture_id`)
VALUES ('4', 'Creat new SQL language', '4');
INSERT INTO `onlineschool`.`homeworks` (`homework_id`, `name`, `lecture_id`)
VALUES ('5', 'Creat new Android app', '5');
INSERT INTO `onlineschool`.`homeworks` (`homework_id`, `name`, `lecture_id`)
VALUES ('6', 'Create new Apple app', '6');

// тут я видаляю з таблиці students колонку курс_ід, і створю нову таблицю з відношеннями студентів і курсів

ALTER TABLE `onlineschool`.`students`
    DROP FOREIGN KEY `students_ibfk_1`;
ALTER TABLE `onlineschool`.`students`
    DROP COLUMN `course_id`,
    DROP INDEX `course_id`;
;

INSERT INTO `onlineschool`.`students` (`student_id`, `student_name`, `student_surname`, `student_email`)
VALUES ('1', 'Bob', 'Dilan', 'bd@gmail.com');
INSERT INTO `onlineschool`.`students` (`student_id`, `student_name`, `student_surname`, `student_email`)
VALUES ('2', 'Bob', 'Marley', 'bm@ukr.net');
INSERT INTO `onlineschool`.`students` (`student_id`, `student_name`, `student_surname`, `student_email`)
VALUES ('3', 'Sponge', 'Bob', 'sb@yahoo.com');
INSERT INTO `onlineschool`.`students` (`student_id`, `student_name`, `student_surname`, `student_email`)
VALUES ('4', 'Bobby', 'Fisher', 'bf@chess.net');
INSERT INTO `onlineschool`.`students` (`student_id`, `student_name`, `student_surname`, `student_email`)
VALUES ('5', 'Bibbop', 'Cowboy', 'bc@gmail.com');
INSERT INTO `onlineschool`.`students` (`student_id`, `student_name`, `student_surname`, `student_email`)
VALUES ('6', 'Bob', 'Dob', 'bbdd@ukr.com');

// створюємо таблюцю де можна вказати номер студента і на який курс він записаний
    (номер студента є зовнш ключем до таблиці студентів, а колонка курс_ід до таблиці курси)

CREATE TABLE `student_courses`
(
    `student_id` int NOT NULL,
    `course_id`  int NOT NULL,
    PRIMARY KEY (`student_id`, `course_id`),
    KEY `course_id` (`course_id`),
    CONSTRAINT `student_courses_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`),
    CONSTRAINT `student_courses_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci


INSERT INTO `onlineschool`.`student_courses` (`student_id`, `course_id`)
VALUES ('2', '1');
INSERT INTO `onlineschool`.`student_courses` (`student_id`, `course_id`)
VALUES ('1', '2');
INSERT INTO `onlineschool`.`student_courses` (`student_id`, `course_id`)
VALUES ('2', '2');
INSERT INTO `onlineschool`.`student_courses` (`student_id`, `course_id`)
VALUES ('2', '3');
INSERT INTO `onlineschool`.`student_courses` (`student_id`, `course_id`)
VALUES ('3', '3');
INSERT INTO `onlineschool`.`student_courses` (`student_id`, `course_id`)
VALUES ('3', '1');
INSERT INTO `onlineschool`.`student_courses` (`student_id`, `course_id`)
VALUES ('4', '2');
INSERT INTO `onlineschool`.`student_courses` (`student_id`, `course_id`)
VALUES ('4', '1');
INSERT INTO `onlineschool`.`student_courses` (`student_id`, `course_id`)
VALUES ('5', '3');
INSERT INTO `onlineschool`.`student_courses` (`student_id`, `course_id`)
VALUES ('6', '1');
INSERT INTO `onlineschool`.`student_courses` (`student_id`, `course_id`)
VALUES ('6', '2');

INSERT INTO `onlineschool`.`teachers` (`teacher_id`, `teacher_name`, `teacher_surname`, `course_id`)
VALUES ('1', 'Oleg', 'Vinnik', '1');
INSERT INTO `onlineschool`.`teachers` (`teacher_id`, `teacher_name`, `teacher_surname`, `course_id`)
VALUES ('2', 'Oleg', 'Znik', '2');
INSERT INTO `onlineschool`.`teachers` (`teacher_id`, `teacher_name`, `teacher_surname`, `course_id`)
VALUES ('3', 'Oleg', 'Vidminnuk', '3');

// забув додати до лекцій дату створення
ALTER TABLE lectures
    ADD COLUMN date DATE;

UPDATE `onlineschool`.`lectures`
SET `date` = '2020-10-10'
WHERE (`lecture_id` = '1');
UPDATE `onlineschool`.`lectures`
SET `date` = '2021-11-28'
WHERE (`lecture_id` = '2');
UPDATE `onlineschool`.`lectures`
SET `date` = '2019-7-1'
WHERE (`lecture_id` = '3');
UPDATE `onlineschool`.`lectures`
SET `date` = '2016-8-19'
WHERE (`lecture_id` = '4');
UPDATE `onlineschool`.`lectures`
SET `date` = '2001-1-1'
WHERE (`lecture_id` = '5');
UPDATE `onlineschool`.`lectures`
SET `date` = '2023-2-3'
WHERE (`lecture_id` = '6');


// сортую студентів за прізвищем
SELECT *
FROM students
ORDER BY student_surname;

// виведемо лекцію, яка була раніше всіх, та має найбільше дз
SELECT l.lecture_topic, l.description, COUNT(h.homework_id) AS num_homeworks
FROM lectures AS l
         JOIN homeworks AS h ON l.lecture_id = h.lecture_id
WHERE l.date = (SELECT MIN(date) FROM lectures)
GROUP BY l.lecture_id
ORDER BY num_homeworks DESC
LIMIT 1;

// виведемо лекції та додаткові матеріали, які вона містить за датою , які раніше 2023 року
SELECT lectures.lecture_topic, COUNT(additional_materials.add_materials_id) AS num_additional_materials
FROM lectures
         LEFT JOIN additional_materials ON lectures.lecture_id = additional_materials.lecture_id
WHERE lectures.date < '2023-01-01'
GROUP BY lectures.lecture_id
ORDER BY lectures.date;

//згрупуємо додаткові матеріали по категорії
SELECT resource_type, COUNT(*) as count
FROM additional_materials
GROUP BY resource_type;

// виведемо прізвища викладачів, які стоять до н
SELECT teacher_name, teacher_surname
FROM teachers
WHERE teacher_surname REGEXP '^[a-m,A-M,Н-н]';

// виведемо прізвища та ім'я студентів , які записані тільки на один курс,
    на два курси одночасно та на три і більше, відсортовані за прізвищем

SELECT student_name, student_surname, COUNT(DISTINCT course_id) AS num_courses
FROM students
         JOIN student_courses ON students.student_id = student_courses.student_id
GROUP BY students.student_id
HAVING num_courses = 1 OR num_courses = 2 OR num_courses >= 3
ORDER BY student_surname;