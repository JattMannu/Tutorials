--liquibase formatted sql
--changeset manpreet:1

CREATE TABLE books
(
    id                SERIAL PRIMARY KEY,
    name              TEXT UNIQUE,
);