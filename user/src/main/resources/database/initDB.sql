create table if not exists users
(
    id            bigserial primary key,
    firstname     varchar(50) not null,
    lastname      varchar(50) not null,
    middlename    varchar(50) not null,
    grade         int         not null,
    job_id        bigint      not null,
    department_id bigint      not null,
    email         varchar(50) unique
);