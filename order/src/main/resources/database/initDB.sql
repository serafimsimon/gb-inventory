create table if not exists orders
(
    id         bigserial primary key,
    user_id    bigint not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

create table if  not exists orders_items
(
    id               bigserial primary key,
    order_id         bigint references orders (id),
    active_id        bigint not null unique references devices (id),
    created_at       timestamp default current_timestamp,
    updated_at       timestamp default current_timestamp
);


