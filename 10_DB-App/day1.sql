USE nhn_academy_53;

-- -----------------------------------------------------
-- Table `JdbcCourses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `JdbcCourses` ;

CREATE TABLE IF NOT EXISTS `JdbcCourses` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` INT(11) NOT NULL,
  `subject_id` INT(11) NOT NULL,
  `created_at` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Courses_Teachers1_idx` (`teacher_id` ASC),
  INDEX `fk_Courses_Subjects1_idx` (`subject_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `JdbcRegistrations`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `JdbcRegistrations` ;

CREATE TABLE IF NOT EXISTS `JdbcRegistrations` (
  `id` INT(11) NOT NULL auto_increment,
  `course_id` INT(11) NOT NULL,
  `student_id` INT(11) NOT NULL,
  `score` INT NULL,
  `created_at` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Registrations_Courses_idx` (`course_id` ASC),
  INDEX `fk_Registrations_Students1_idx` (`student_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `JdbcStudents`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `JdbcStudents` ;

CREATE TABLE IF NOT EXISTS `JdbcStudents` (
  `id` INT(11) NOT NULL auto_increment,
  `name` VARCHAR(20) NOT NULL,
  `created_at` DATETIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `JdbcSubjects`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `JdbcSubjects` ;

CREATE TABLE IF NOT EXISTS `JdbcSubjects` (
  `id` INT(11) NOT NULL auto_increment,
  `name` VARCHAR(200) NOT NULL,
  `created_at` DATETIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `JdbcTeachers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `JdbcTeachers` ;

CREATE TABLE IF NOT EXISTS `JdbcTeachers` (
  `id` INT(11) NOT NULL auto_increment,
  `name` VARCHAR(20) NOT NULL,
  `created_at` DATETIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `JdbcUsers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `JdbcUsers` ;

CREATE TABLE IF NOT EXISTS `JdbcUsers` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `created_at` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Data for table `JdbcCourses`
-- -----------------------------------------------------
START TRANSACTION;
INSERT INTO `JdbcCourses` (`id`, `teacher_id`, `subject_id`, `created_at`) VALUES (1, 1, 1, '2022-05-14 00:00:00');

COMMIT;


-- -----------------------------------------------------
-- Data for table `JdbcStudents`
-- -----------------------------------------------------
START TRANSACTION;
INSERT INTO `JdbcStudents` (`id`, `name`, `created_at`) VALUES (1, '학생1', '2022-05-14 00:00:00');

COMMIT;


-- -----------------------------------------------------
-- Data for table `JdbcSubjects`
-- -----------------------------------------------------
START TRANSACTION;
INSERT INTO `JdbcSubjects` (`id`, `name`, `created_at`) VALUES (1, 'JDBC를 이용한 애플리케이션개발', '2022-05-14 00:00:00');
INSERT INTO `JdbcSubjects` (`id`, `name`, `created_at`) VALUES (2, 'Spring Framework Core', '2022-05-14 00:00:00');
INSERT INTO `JdbcSubjects` (`id`, `name`, `created_at`) VALUES (3, 'Spring MVC', '2022-05-14 00:00:00');
INSERT INTO `JdbcSubjects` (`id`, `name`, `created_at`) VALUES (4, 'Java Programming', '2022-05-14 00:00:00');

COMMIT;


-- -----------------------------------------------------
-- Data for table `JdbcTeachers`
-- -----------------------------------------------------
START TRANSACTION;
INSERT INTO `JdbcTeachers` (`id`, `name`, `created_at`) VALUES (1, '만티', '2022-05-14 00:00:00');
INSERT INTO `JdbcTeachers` (`id`, `name`, `created_at`) VALUES (2, '동묘', '2022-05-14 00:00:00');
INSERT INTO `JdbcTeachers` (`id`, `name`, `created_at`) VALUES (3, '조던', '2022-05-14 00:00:00');

COMMIT;


-- -----------------------------------------------------
-- Data for table `JdbcUsers`
-- -----------------------------------------------------
START TRANSACTION;
INSERT INTO `JdbcUsers` (`id`, `username`, `password`, `created_at`) VALUES (1, 'admin', 'adminadmin', '2022-05-14 00:00:00');
INSERT INTO `JdbcUsers` (`id`, `username`, `password`, `created_at`) VALUES (2, 'user', 'useruser', '2022-05-14 00:00:00');

COMMIT;

select * from JdbcTeachers;
select * from JdbcSubjects;
select * from JdbcCourses;
SELECT C.id, S.name, T.name, C.created_at FROM JdbcCourses as C
INNER JOIN JdbcTeachers as T ON C.teacher_id = T.id
INNER JOIN JdbcSubjects as S On C.subject_id = S.id;
