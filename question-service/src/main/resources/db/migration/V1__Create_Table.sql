create table if not exists question (
    id serial primary key,
    category varchar(255),
    difficulty_level varchar(255),
    option1 varchar(255),
    option2 varchar(255),
    option3 varchar(255),
    option4 varchar(255),
    question_title varchar(255),
    right_answer varchar(255)
);

