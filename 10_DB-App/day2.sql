-- Registration data
insert into JdbcRegistrations (course_id, student_id, score, created_at) values (1, 1, null, now());

insert into JdbcTeachers (id, name, created_at) values(10, '선생1', now());
insert into JdbcTeachers (id, name, created_at) values(11, '선생2', now());
insert into JdbcTeachers (id, name, created_at) values(12, '선생3', now());
insert into JdbcTeachers (id, name, created_at) values(13, '선생4', now());
insert into JdbcTeachers (id, name, created_at) values(14, '선생5', now());
insert into JdbcTeachers (id, name, created_at) values(15, '선생6', now());
insert into JdbcTeachers (id, name, created_at) values(16, '선생7', now());
insert into JdbcTeachers (id, name, created_at) values(17, '선생8', now());
insert into JdbcTeachers (id, name, created_at) values(18, '선생9', now());
insert into JdbcTeachers (id, name, created_at) values(19, '선생10', now());
insert into JdbcTeachers (id, name, created_at) values(20, '선생11', now());

select * from JdbcTeachers;
select * from JdbcRegistrations;


insert into JdbcCourses (teacher_id, subject_id, created_at) values(1, 2, now());

select * from JdbcCourses;
delete From JdbcCourses where id > 2;