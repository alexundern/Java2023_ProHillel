select * from Homework; 

select Lesson.*, homework.name as homework_name, Homework.description AS homework_description
from Lesson
left join homework on Lesson.homework_id = homework.id;

select Lesson.*, Homework.name AS homework_name, Homework.description AS homework_description
from Lesson 
left join Homework ON Lesson.homework_id = Homework.id
order by lesson.updatedAt;

select Schedule.*, Lesson.name AS lesson_name, Lesson.updatedAt AS lesson_updatedAt, Homework.name AS homework_name, Homework.description AS homework_description
from Schedule
left join Schedule_Lesson ON Schedule.id = Schedule_Lesson.schedule_id
left join Lesson ON Schedule_Lesson.lesson_id = Lesson.id
left join Homework ON Lesson.homework_id = Homework.id;

select Schedule.id, Schedule.name, COUNT(Schedule_Lesson.lesson_id) AS lesson_count
from Schedule
left join Schedule_Lesson ON Schedule.id = Schedule_Lesson.schedule_id
group by Schedule.id, Schedule.name;