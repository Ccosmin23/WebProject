create database examDB;

-- ne conectam la DB
\c examDB;

CREATE TABLE items
(
    id   serial primary key,
    name VARCHAR(255) not null
);

insert into items (id, name)
values (1, 'Item A'),
       (2, 'Item B'),
       (3, 'Item C');


select * from items;