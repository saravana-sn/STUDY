create database MY_DATABASE;
show databases;

USE MY_DATABASE;

CREATE TABLE Courses (
    CourseID INT PRIMARY KEY AUTO_INCREMENT,
    CourseName VARCHAR(100) NOT NULL,
    Department VARCHAR(50),
    Credits INT CHECK (Credits > 0) -- Ensuring credit hours are positive
);

INSERT INTO Courses (CourseName, Department, Credits) VALUES
('Introduction to Programming', 'Computer Science', 4),
('Calculus I', 'Mathematics', 3),
('Linear Algebra', 'Mathematics', 3),
('Probability and Statistics', 'Mathematics', 3),
('Differential Equations', 'Mathematics', 4),
('English Literature', 'Humanities', 3),
('Modern History', 'History', 3),
('Physics I', 'Physics', 4),
('Database Systems', 'Computer Science', 4),
('Artificial Intelligence', 'Computer Science', 3);


CREATE TABLE Students (
    StudentID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL,
    Age INT,
    Major VARCHAR(50),
    GPA DECIMAL(3,2)
);

INSERT INTO Students (Name, Age, Major, GPA) VALUES
('Alice Johnson', 20, 'Computer Science', 3.8),
('Bob Smith', 22, 'Mathematics', 3.5),
('Charlie Brown', 19, 'History', 3.2),
('David Lee', 21, 'Computer Science', 3.9),
('Eve Wilson', 23, 'English', 3.4),
('Frank Miller', 20, 'Mathematics', 3.6),
('Grace Davis', 22, 'History', 3.1),
('Henry Garcia', 19, 'Computer Science', 3.7),
('Ivy Rodriguez', 21, 'English', 3.3),
('Jack Martinez', 23, 'Mathematics', 3.6),
('Karen White', 20, 'Computer Science', 3.8),
('Liam Green', 22, 'Mathematics', 3.5),
('Mia Taylor', 19, 'History', 3.3),
('Noah Anderson', 21, 'English', 3.4),
('Olivia Thomas', 23, 'Computer Science', 3.9),
('Peter Jackson', 20, 'Mathematics', 3.6),
('Quinn Moore', 22, 'History', 3.2),
('Ryan Martin', 19, 'English', 3.1),
('Sophia Thompson', 21, 'Computer Science', 3.7),
('Tyler Garcia', 23, 'Mathematics', 3.4),
('Ursula Perez', 20, 'Computer Science', 3.5);


CREATE TABLE Enrollments (
    EnrollmentID INT PRIMARY KEY AUTO_INCREMENT,
    StudentID INT,
    CourseID INT,
    EnrollmentDate DATE NOT NULL,
    FOREIGN KEY (StudentID) REFERENCES Students(StudentID),
    FOREIGN KEY (CourseID) REFERENCES Courses(CourseID)
);

INSERT INTO Enrollments (StudentID, CourseID, EnrollmentDate) VALUES
(1, 1, '2024-09-05'),  -- Alice Johnson in Intro to Programming
(1, 2, '2024-09-05'),  -- Alice Johnson in Calculus I
(3, 3, '2024-09-05'),  -- Charlie Brown in Linear Algebra
(5, 1, '2024-09-05'),  -- Eve Wilson in Intro to Programming
(7, 2, '2024-09-05'),  -- Grace Davis in Calculus I
(9, 3, '2024-09-05'),  -- Henry Garcia in Linear Algebra
(11, 1, '2024-09-05'), -- Karen White in Intro to Programming
(13, 2, '2024-09-05'), -- Mia Taylor in Calculus I
(15, 3, '2024-09-05'), -- Noah Anderson in Linear Algebra
(17, 1, '2024-09-05'), -- Ryan Martin in Intro to Programming
(19, 2, '2024-09-05'), -- Sophia Thompson in Calculus I
(21, 3, '2024-09-05'); -- Tyler Garcia in Linear Algebra