--liquibase formatted sql
--changeset manpreet:1

CREATE TABLE book_liquibase
(
    id                  SERIAL PRIMARY KEY,
    name              TEXT,
    status              INTEGER
);