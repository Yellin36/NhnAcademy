DROP TABLE IF EXISTS `BoardAuthority`;
CREATE TABLE IF NOT EXISTS `BoardAuthority` (
	`id` INT(3) NOT NULL AUTO_INCREMENT,
    `authority` VARCHAR(10) NOT NULL,
    PRIMARY KEY(`id`)
)ENGINE = InnoDB;

INSERT INTO `BoardAuthority` (`authority`) VALUES ('user');
INSERT INTO `BoardAuthority` (`authority`) VALUES ('admin');

SELECT * FROM `BoardAuthority`;

drop table if exists BoardUsers;
CREATE TABLE IF NOT EXISTS `BoardUsers` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(20) NOT NULL,
    `user_id` VARCHAR(20) NOT NULL,
    `password` VARCHAR(30) NOT NULL,
    `authority_id` INT(3) NOT NULL,
    PRIMARY KEY(`id`),
    UNIQUE INDEX `user_idx` (`user_id`),
    INDEX `fk_Users_Authority_id` (`authority_id`)
)ENGINE = InnoDB;
INSERT INTO `BoardUsers` (`name`, `user_id`, `password`, `authority_id`) VALUES ('김하나', 'user', '1234', 1);
INSERT INTO `BoardUsers` (`name`, `user_id`, `password`, `authority_id`) VALUES ('관리자', 'admin', '1234', 2);

DROP TABLE IF EXISTS `BoardPosts`;
CREATE TABLE IF NOT EXISTS `BoardPosts` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(200) NOT NULL,
    `content` VARCHAR(10000) NOT NULL,
    `user_id` INT(11) NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `deleted` BOOLEAN DEFAULT FALSE,
    PRIMARY KEY(`id`),
    UNIQUE INDEX `post_idx` (`title`),
    INDEX `fk_Posts_User_id` (`user_id`)
)ENGINE = InnoDB;

DROP TABLE IF EXISTS `BoardModifiers`;
CREATE TABLE IF NOT EXISTS `BoardModifiers` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `user_id` INT(11) NOT NULL,
    `post_id` INT(11) NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    PRIMARY KEY(`id`),
    INDEX `fk_Modifiers_Post_id` (`post_id`),
    INDEX `fk_Modifiers_User_id` (`user_id`)
)ENGINE = InnoDB;

DROP TABLE IF EXISTS `BoardComments`;
CREATE TABLE IF NOT EXISTS `BoardComments` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `post_id` INT(11) NOT NULL,
    `content` VARCHAR(100) NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_Comments_Post_id` (`post_id`)
)ENGINE = InnoDB;

DROP TABLE IF EXISTS `BoardFies`;
CREATE TABLE IF NOT EXISTS `BoardFiles` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `post_id` INT(11) NOT NULL,
    `file_name` VARCHAR(1000) NOT NULL,
    PRIMARY KEY(`id`),
    INDEX `fk_Files_Post_id` (`post_id`)
)ENGINE = InnoDB;

DROP TABLE IF EXISTS `BoardLikes`;
CREATE TABLE IF NOT EXISTS `BoardLikes` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `post_id` INT(11) NOT NULL,
    `user_id` INT(11) NOT NULL,
    PRIMARY KEY(`id`),
	INDEX `fk_Likes_Post_id` (`post_id`),
    INDEX `fk_Likes_User_id` (`user_id`)
)ENGINE = InnoDB;

