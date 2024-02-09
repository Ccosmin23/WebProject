create database examDB;

-- ne conectam la DB
\c examDB;

CREATE TABLE items
(
    id   serial primary key,
    name VARCHAR(255) not null
);

insert into items (id, name)
values (999, 'cosmin test');

delete from items where id =3;
select * from items;