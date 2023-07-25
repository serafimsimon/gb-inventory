create table if not exists brands
(
    id    bigserial primary key,
    title varchar(255) not null
);

create table if not exists conditions
(
    id    bigserial primary key,
    title varchar(255) not null
);

create table if not exists types
(
    id    bigserial primary key,
    title varchar(255) not null
);

create table if not exists devices
(
    id              bigserial primary key,
    owner_Id        bigint,
    kind_id         int         not null references types (id),
    producer_id     int         not null references brands (id),
    model           varchar(50) not null,
    serial_number    varchar(50) not null unique,
    inventory_number bigserial   not null unique,
    condition_id    int         not null references conditions (id),
    description     varchar(255) default 'null',
    created_at      timestamp    default current_timestamp,
    updated_at      timestamp    default current_timestamp
);