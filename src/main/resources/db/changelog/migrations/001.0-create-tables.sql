--changeset 1
CREATE TABLE cloud_service.users
(
    id       SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(256)       NOT NULL
);

--changeset 2
CREATE TABLE cloud_service.files
(
    id        SERIAL PRIMARY KEY,
    file_name VARCHAR UNIQUE NOT NULL,
    size      BIGINT         NOT NULL,
    content   BYTEA          NOT NULL,
    user_id   SERIAL REFERENCES cloud_service.users (id) ON DELETE SET NULL
);
