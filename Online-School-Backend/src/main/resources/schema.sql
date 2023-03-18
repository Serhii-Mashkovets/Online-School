CREATE DATABASE IF NOT EXISTS onlineSchool;
USE onlineSchool;


CREATE TABLE Courses (
                         course_id INT AUTO_INCREMENT PRIMARY KEY,
                         course_name VARCHAR(255) NOT NULL
);


CREATE TABLE Lectures (
                          lecture_id INT AUTO_INCREMENT PRIMARY KEY,
                          lecture_topic VARCHAR(255) NOT NULL,
                          description VARCHAR (255) NOT NULL,
                          course_id INT,
                          FOREIGN KEY (course_id) REFERENCES Courses(course_id)
);

CREATE TABLE Additional_Materials (
                                      add_materials_id INT AUTO_INCREMENT PRIMARY KEY,
                                      name VARCHAR(255) NOT NULL,
                                      lecture_id INT,
                                      resource_type ENUM('book', 'link', 'video'),
                                      FOREIGN KEY (lecture_id) REFERENCES Lectures(lecture_id)
);

CREATE TABLE HomeWorks (
                           homework_id INT AUTO_INCREMENT PRIMARY KEY,
                           lecture_id INT,
                           FOREIGN KEY (lecture_id) REFERENCES Lectures(lecture_id)
);

CREATE TABLE Students (
                          student_id INT AUTO_INCREMENT PRIMARY KEY,
                          student_name VARCHAR(255) NOT NULL,
                          student_surname VARCHAR(255) NOT NULL,
                          student_email VARCHAR(255) NOT NULL,
                          course_id INT,
                          FOREIGN KEY (course_id) REFERENCES Courses(course_id)
);

CREATE TABLE Teachers (
                          teacher_id INT AUTO_INCREMENT PRIMARY KEY,
                          teacher_name VARCHAR(255) NOT NULL,
                          teacher_surname VARCHAR(255) NOT NULL,
                          course_id INT,
                          FOREIGN KEY (course_id) REFERENCES Courses(course_id)
);
