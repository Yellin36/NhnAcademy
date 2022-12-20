-- BoardAuthority default value insert
INSERT INTO `BoardAuthority` (`authority`) VALUES ('ADMIN');
INSERT INTO `BoardAuthority` (`authority`) VALUES ('USER');

delete from `BoardAuthority` where id > 0;

-- BoardUsers default value insert	`id` VARCHAR(20) NOT NULL,

INSERT INTO `BoardUsers` (`id`, `password`, `name`, `authority_id`, `created_at`) VALUES ('user', '1234', '김하나', 1, now());
INSERT INTO `BoardUsers` (`id`, `password`, `name`, `authority_id`, `created_at`) VALUES ('admin', '1234', '관리자', 2, now());

delete from `BoardUsers` where id > 0;

insert into `BoardPosts` (`user_id`, `title`, `content`, `created_at`, `modifier`, `updated_at`, `deleted`) values('user', 'a1', 'something', now(), null, null, false);
insert into `BoardPosts` (`user_id`, `title`, `content`, `created_at`, `modifier`, `updated_at`, `deleted`) values('user', 'a2', 'something', now(), null, null, false);
insert into `BoardPosts` (`user_id`, `title`, `content`, `created_at`, `modifier`, `updated_at`, `deleted`) values('user', 'a3', 'something', now(), null, null, false);
insert into `BoardPosts` (`user_id`, `title`, `content`, `created_at`, `modifier`, `updated_at`, `deleted`) values('user', 'a4', 'something', now(), null, null, false);
insert into `BoardPosts` (`user_id`, `title`, `content`, `created_at`, `modifier`, `updated_at`, `deleted`) values('user', 'a5', 'something', now(), null, null, false);
insert into `BoardPosts` (`user_id`, `title`, `content`, `created_at`, `modifier`, `updated_at`, `deleted`) values('user', 'a6', 'something', now(), null, null, false);
insert into `BoardPosts` (`user_id`, `title`, `content`, `created_at`, `modifier`, `updated_at`, `deleted`) values('user', 'a7', 'something', now(), null, null, false);
insert into `BoardPosts` (`user_id`, `title`, `content`, `created_at`, `modifier`, `updated_at`, `deleted`) values('user', 'a8', 'something', now(), null, null, false);
insert into `BoardPosts` (`user_id`, `title`, `content`, `created_at`, `modifier`, `updated_at`, `deleted`) values('user', 'a9', 'something', now(), null, null, false);
insert into `BoardPosts` (`user_id`, `title`, `content`, `created_at`, `modifier`, `updated_at`, `deleted`) values('user', 'a10', 'something', now(), null, null, false);
insert into `BoardPosts` (`user_id`, `title`, `content`, `created_at`, `modifier`, `updated_at`, `deleted`) values('user', 'a11', 'something', now(), null, null, false);
insert into `BoardPosts` (`user_id`, `title`, `content`, `created_at`, `modifier`, `updated_at`, `deleted`) values('user', 'a12', 'something', now(), null, null, false);
insert into `BoardPosts` (`user_id`, `title`, `content`, `created_at`, `modifier`, `updated_at`, `deleted`) values('user', 'a13', 'something', now(), null, null, false);
insert into `BoardPosts` (`user_id`, `title`, `content`, `created_at`, `modifier`, `updated_at`, `deleted`) values('user', 'a14', 'something', now(), null, null, false);
insert into `BoardPosts` (`user_id`, `title`, `content`, `created_at`, `modifier`, `updated_at`, `deleted`) values('user', 'a15', 'something', now(), null, null, false);
insert into `BoardPosts` (`user_id`, `title`, `content`, `created_at`, `modifier`, `updated_at`, `deleted`) values('user', 'a16', 'something', now(), null, null, false);
insert into `BoardPosts` (`user_id`, `title`, `content`, `created_at`, `modifier`, `updated_at`, `deleted`) values('user', 'a17', 'something', now(), null, null, false);
insert into `BoardPosts` (`user_id`, `title`, `content`, `created_at`, `modifier`, `updated_at`, `deleted`) values('user', 'a18', 'something', now(), null, null, false);
insert into `BoardPosts` (`user_id`, `title`, `content`, `created_at`, `modifier`, `updated_at`, `deleted`) values('user', 'a19', 'something', now(), null, null, false);
insert into `BoardPosts` (`user_id`, `title`, `content`, `created_at`, `modifier`, `updated_at`, `deleted`) values('user', 'a20', 'something', now(), null, null, false);
insert into `BoardPosts` (`user_id`, `title`, `content`, `created_at`, `modifier`, `updated_at`, `deleted`) values('user', 'a21', 'something', now(), null, null, false);
insert into `BoardPosts` (`user_id`, `title`, `content`, `created_at`, `modifier`, `updated_at`, `deleted`) values('user', 'a22', 'something', now(), null, null, false);
insert into `BoardPosts` (`user_id`, `title`, `content`, `created_at`, `modifier`, `updated_at`, `deleted`) values('user', 'a23', 'something', now(), null, null, false);
insert into `BoardPosts` (`user_id`, `title`, `content`, `created_at`, `modifier`, `updated_at`, `deleted`) values('user', 'a24', 'something', now(), null, null, false);
insert into `BoardPosts` (`user_id`, `title`, `content`, `created_at`, `modifier`, `updated_at`, `deleted`) values('user', 'a25', 'something', now(), null, null, false);
insert into `BoardPosts` (`user_id`, `title`, `content`, `created_at`, `modifier`, `updated_at`, `deleted`) values('user', 'a26', 'something', now(), null, null, false);
insert into `BoardPosts` (`user_id`, `title`, `content`, `created_at`, `modifier`, `updated_at`, `deleted`) values('user', 'a27', 'something', now(), null, null, false);
insert into `BoardPosts` (`user_id`, `title`, `content`, `created_at`, `modifier`, `updated_at`, `deleted`) values('user', 'a28', 'something', now(), null, null, false);
insert into `BoardPosts` (`user_id`, `title`, `content`, `created_at`, `modifier`, `updated_at`, `deleted`) values('user', 'a29', 'something', now(), null, null, false);
insert into `BoardPosts` (`user_id`, `title`, `content`, `created_at`, `modifier`, `updated_at`, `deleted`) values('user', 'a30', 'something', now(), null, null, false);