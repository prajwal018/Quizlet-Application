create table if not exists quiz (
    id serial primary key,
    title varchar(255)
);


create table if not exists quiz_question_ids (
    question_ids int,
    quiz_id int not null
);


