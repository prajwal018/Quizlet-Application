create table if not exists users (
    id serial primary key,
    firstname varchar(255),
    lastname varchar(255),
    password varchar(255),
    role varchar(255),
    username varchar(255)
);

