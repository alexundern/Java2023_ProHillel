create database Homework25;

use Homework25;

create table Homework (
	id int auto_increment primary key,
	name varchar(128),
    description varchar(1024)
);


create table Lesson (
    id int auto_increment primary key,
    name varchar(128),
    updatedAt timestamp,
    homework_id int
);

create table Schedule (
    id int auto_increment primary key,
    name varchar(128),
    updatedAt timestamp,
    lesson_id int
);

create table Schedule_Lesson (
    schedule_id INT,
    lesson_id INT
);

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