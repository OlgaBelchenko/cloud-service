CREATE SCHEMA IF NOT EXISTS cloud_service;
CREATE TABLE IF NOT EXISTS cloud_service.users
(
    id       SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(256)       NOT NULL
);
CREATE TABLE IF NOT EXISTS cloud_service.files
(
    id        SERIAL PRIMARY KEY,
    file_name VARCHAR NOT NULL,
    size      BIGINT  NOT NULL,
    content   BYTEA   NOT NULL,
    user_id   SERIAL  REFERENCES cloud_service.users (id) ON DELETE SET NULL,
    CONSTRAINT uq_files UNIQUE (file_name, user_id)
);

DELETE FROM cloud_service.users;

INSERT INTO cloud_service.users (username, password)
VALUES ('test', '$2y$10$wjxYiNRHkXwz8VI/sU30d.svpB73ct3dmqKyuYlLAksVaTXfMzJTy'), -- password = test
       ('user', '$2a$12$vNiU/keMwu0NzZ97qho0VOGMWukcqZL1PioUi8uGyNR1vxqSLUVxC'); -- password = user