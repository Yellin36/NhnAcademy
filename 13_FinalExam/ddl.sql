create table `members` (
	`member_id` int(11) not null,
    `member_name` varchar(20) not null,
    primary key(`member_id`)
);

create table `departments` (
	`department_id` varchar(10) not null,
    `department_name` varchar(30) not null,
    primary key(`department_id`)
);

create table `department_members` (
	`member_id` int(11) not null,
    `department_id` varchar(10)  not null,
    primary key(`member_id`, `department_id`),
    foreign key(`member_id`) references `members`(`member_id`),
    foreign key(`department_id`) references `departments`(`department_id`)
);

