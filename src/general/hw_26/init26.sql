create database Homework26;

use Homework26;

create table Homework (
	id int auto_increment primary key,
	name varchar(128),
    description varchar(1024)
);

insert into Homework (name, description) values
    ('Math Homework', 'Solve problems from chapter 5.'),
    ('History Homework', 'Write an essay about World War II.'),
    ('Science Homework', 'Conduct an experiment and record the results.');


create table Lesson (
    id int auto_increment primary key,
    name varchar(128),
    updatedAt timestamp,
    homework_id int
);

insert into Lesson (name, updatedAt, homework_id) values
    ('Algebra', '2023-07-28 12:30:00', 1),
    ('World History', '2023-07-29 10:15:00', 2),
    ('Chemistry Lab', '2023-07-30 14:00:00', 3);


create table Schedule (
    id int auto_increment primary key,
    name varchar(128),
    updatedAt timestamp,
    lesson_id int
);

insert into Schedule (name, updatedAt, lesson_id) values
	('Monday Schedule', '2023-07-28 08:00:00', 1),
    ('Tuesday Schedule', '2023-07-29 08:00:00', 2),
    ('Wednesday Schedule', '2023-07-30 08:00:00', 3);


create table Schedule_Lesson (
    schedule_id INT,
    lesson_id INT
);

insert into Schedule_Lesson (schedule_id, lesson_id) values
    (1, 1),
    (1, 2),
    (2, 2),
    (3, 3),
    (3, 1);


alter table lesson add
	constraint FK_lesson_schedule foreign key
    (
		id
	) references schedule (
		id
	);
    
alter table schedule add
    constraint FK_schedule_lesson foreign key
    (
        Id
    ) references lesson (
        id
    );