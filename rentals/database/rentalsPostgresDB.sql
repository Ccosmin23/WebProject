-- Drop and create database
DROP DATABASE IF EXISTS houseRentalDB;
CREATE DATABASE houseRentalDB;

-- Connect to the created database
\c houseRentalDB;

-- Create table addresses
CREATE TABLE addresses
(
    id        SERIAL PRIMARY KEY,
    street    VARCHAR(250),
    number    VARCHAR(250),
    city      VARCHAR(250),
    country   VARCHAR(250),
    state     VARCHAR(250),
    zipCode   VARCHAR(250),
    latitude  DOUBLE PRECISION,
    longitude DOUBLE PRECISION
);

-- Create table users
CREATE TABLE users
(
    id        SERIAL PRIMARY KEY,
    username  varchar(250),
    email     varchar(250),
    firstname VARCHAR(250),
    lastname  VARCHAR(250),
    password  VARCHAR(250),
    rights    INTEGER,
    addressID INTEGER REFERENCES addresses (id)
);

create table sessions
(
    id        SERIAL PRIMARY KEY
);

-- Create table properties
CREATE TABLE properties
(
    id             SERIAL PRIMARY KEY,
    title          VARCHAR(250),
    price          INTEGER,
    housingType    VARCHAR(250),
    bedrooms       INTEGER,
    usableSurface  INTEGER,
    gardenSurface  INTEGER,
    terraceSurface INTEGER,
    floors         INTEGER,
    addressID      INTEGER REFERENCES addresses (id)
);

-- Create table owners
CREATE TABLE owners
(
    id             SERIAL PRIMARY KEY,
    noOfProperties INTEGER,
    userID         INTEGER REFERENCES users (id),
    addressID      INTEGER REFERENCES addresses (id)
);

-- Create table clients
CREATE TABLE clients
(
    id               SERIAL PRIMARY KEY,
    name             VARCHAR(250),
    budget           INTEGER,
    propertiesRented INTEGER,
    rentedPropertyID INTEGER REFERENCES properties (id)
);

-- Create table questions
CREATE TABLE questions
(
    id     SERIAL PRIMARY KEY,
    text   VARCHAR(250),
    rating INTEGER
);

-- Create table feedback
CREATE TABLE feedback
(
    id            SERIAL PRIMARY KEY,
    numericAnswer INTEGER,
    questionID    INTEGER REFERENCES questions (id)
);

-- Create table agents
CREATE TABLE agents
(
    id             SERIAL PRIMARY KEY,
    feedbackRating DOUBLE PRECISION,
    userID         INTEGER REFERENCES users (id),
    feedbackID     INTEGER REFERENCES feedback (id)
);

-- Create table contracts
CREATE TABLE contracts
(
    id          SERIAL PRIMARY KEY,
    startDate   DATE,
    endDate     DATE,
    rentalPrice INTEGER,
    clientID    INTEGER REFERENCES clients (id),
    propertyID  INTEGER REFERENCES properties (id)
);

-- Create table agentEfficiencyReport
CREATE TABLE agentEfficiencyReport
(
    id                    SERIAL PRIMARY KEY,
    noOfRentedProperties  INTEGER,
    noOfClientsApproached INTEGER,
    agentID               INTEGER REFERENCES agents (id)
);

-- Create table ownershipHistoryReport
CREATE TABLE ownershipHistoryReport
(
    id          SERIAL PRIMARY KEY,
    createdDate DATE,
    rentedTimes INTEGER,
    propertyID  INTEGER REFERENCES properties (id)
);

-- Create table clientReport
CREATE TABLE clientReport
(
    id                   SERIAL PRIMARY KEY,
    createdDate          DATE,
    noOfPropertiesRented INTEGER,
    clientID             INTEGER REFERENCES clients (id)
);

insert into addresses (street, number, city, country, state, zipCode, latitude, longitude)
values ('strada 2', 2, 'cluj', 'US', 'Ilinois', 'HA38QE', '10022', '2225512'),
       ('strada garii', 3333, 'cluj-napoca', 'cluj', 'romania', '400500', '111100122', '52225512'),
       ('Tdx-Glusehburg', 123, 'halzenbur-gen-stein', 'salzburg', 'austria', '20500', '111100122', '52225512'),
       ('Mont du blanc', 9, 'mount de belle', 'charleroi', 'belgium', '100500', '111100122', '52225512'),
       ('Strada uitarii', 83, 'cucu argesului', 'arges', 'romania', '3300500', '111100122', '52225512');

insert into properties (title, price, housingType, bedrooms, usableSurface, gardenSurface, terraceSurface, floors, addressID)
values ('propr1', 122, 'apartament', 3, 60, 100, 10, 2, 1),
       ('propr2', 552, 'casa', 5, 80, 200, 11, 1, 2);

insert into users (username, email, firstname, lastname, password, rights, addressID)
VALUES ('aa', 'aa@aa.aa', 'aa', 'a', '$2a$10$UxHN3.WgV2B8NeZi27iLMeHT2XzZJ4BxQkNEmEKRrK0I6FVwCz8fy', 1, 2);

delete from users
where id = 1;

select *
from users;

select *
from addresses;

SELECT * FROM users WHERE username = 'cc';
