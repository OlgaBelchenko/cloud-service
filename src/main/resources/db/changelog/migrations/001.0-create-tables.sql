--changeset 1
CREATE SCHEMA IF NOT EXISTS cloud_service;

--changeset 2
CREATE TABLE cloud_service.users
(
    id       SERIAL PRIMARY KEY NOT NULL,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(256)       NOT NULL
);

--changeset 3
CREATE TABLE cloud_service.files
(
    id        SERIAL PRIMARY KEY NOT NULL,
    file_name VARCHAR            NOT NULL,
    size      BIGINT             NOT NULL,
    content   BYTEA              NOT NULL,
    user_id   SERIAL REFERENCES cloud_service.users (id) ON DELETE CASCADE,
    CONSTRAINT uq_files UNIQUE (file_name, user_id)
);
