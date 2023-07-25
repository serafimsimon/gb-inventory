CREATE TABLE if not exists jobs
(
    id          bigserial,
    dep_id      bigint not null,
    title       VARCHAR(255) NOT NULL,
    description VARCHAR(512),
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp,
    PRIMARY KEY (id)
);