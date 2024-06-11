CREATE SCHEMA IF NOT EXISTS cloud_service;
CREATE TABLE cloud_service.users
(
    id       SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(256)       NOT NULL
);
CREATE TABLE cloud_service.files
(
    id        SERIAL PRIMARY KEY,
    file_name VARCHAR NOT NULL,
    size      BIGINT  NOT NULL,
    content   BYTEA   NOT NULL,
    user_id   SERIAL  REFERENCES cloud_service.users (id) ON DELETE SET NULL,
    CONSTRAINT uq_files UNIQUE (file_name, user_id)
);

INSERT INTO cloud_service.users (username, password)
VALUES ('test', '$2a$12$5iVevulfa1NTeYoNhUXr5ufpT5asz1ZNARSFlNWnjtMZbkYj/EaSW'), -- password = test
       ('user', '$2a$12$vNiU/keMwu0NzZ97qho0VOGMWukcqZL1PioUi8uGyNR1vxqSLUVxC'); -- password = user