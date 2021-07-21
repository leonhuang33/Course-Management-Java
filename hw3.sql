drop table if exists courses;
drop table if exists assignments;
drop table if exists submissions;
drop table if exists users;

create table courses(
	id integer auto_increment primary key,
	name varchar(255)
);

create table assignments(
	id integer auto_increment primary key,
	name varchar(255),
	course_id integer references courses(id)
);

create table submissions(
	id integer auto_increment primary key,
	name varchar(255),
	answer varchar(255),
	post_date timestamp,
	assignment_id integer references assignments(id)
);

create table users(
	username varchar(255),
	password varchar(255),
	is_instructor boolean
);

insert into courses values (1, 'CS3035 Programming Language Paradigms');
insert into courses values (2, 'CS3220 Web and Internet Programming');

insert into assignments (name, course_id) values ('Lab1 Use of CS3 and CSNS', 2);
insert into assignments (name, course_id) values ('Lab2 HTML Basics', 2);

insert into submissions (name, answer, post_date, assignment_id) values ('John', 'This is my Lab1 submission.', CURRENT_TIMESTAMP, 1);
insert into submissions (name, answer, post_date, assignment_id) values ('Joe', 'I uploaded my Lab1 to CS3.', CURRENT_TIMESTAMP, 1);

insert into users values ('jdoe1', 'abcd', true);
insert into users values ('jdoe2', 'abcd', false);