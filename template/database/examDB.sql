create database examDB;

-- ne conectam la DB
\c examDB;

CREATE TABLE items
(
    id   serial primary key ,
    name VARCHAR(255) not null
);

select * from items;
