CREATE TABLE IF NOT EXISTS students (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    middle_name VARCHAR(255),
    university_id integer NOT NULL
);

CREATE TABLE IF NOT EXISTS universities (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    creation_date DATE
);

CREATE TABLE IF NOT EXISTS users2
(
    id SERIAL PRIMARY KEY,
    login VARCHAR (32) UNIQUE NOT NULL,
    pass VARCHAR (128) NOT NULL
);