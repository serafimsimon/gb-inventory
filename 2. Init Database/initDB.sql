CREATE TABLE IF NOT EXISTS users
(
    id            bigserial PRIMARY KEY,
    firstname     VARCHAR(255) NOT NULL,
    lastname      VARCHAR(255) NOT NULL,
    middlename    VARCHAR(255) NOT NULL,
    grade         INT NOT NULL,
    job_id        bigint NOT NULL,
    department_id bigint NOT NULL,
    email         VARCHAR(255) UNIQUE
);


CREATE TABLE IF NOT EXISTS departments
(
    id         bigserial PRIMARY KEY,
    title      VARCHAR(200) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS producers
(
    id    bigserial PRIMARY KEY,
    title VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS conditions
(
    id    bigserial PRIMARY KEY,
    title VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS kinds
(
    id    bigserial PRIMARY KEY,
    title VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS actives
(
    id              bigserial PRIMARY KEY,
    owner_Id        bigint,
    kind_id         INT NOT NULL REFERENCES kinds (id),
    producer_id     INT NOT NULL REFERENCES producers (id),
    model           VARCHAR(50) NOT NULL,
    serial_number   VARCHAR(50) NOT NULL UNIQUE,
    inventory_number bigserial   NOT NULL UNIQUE,
    condition_id    INT NOT NULL REFERENCES conditions (id),
    description     VARCHAR(255) DEFAULT 'null',
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS jobs
(
    id          bigserial,
    dep_id      bigint NOT NULL,
    title       VARCHAR(255) NOT NULL,
    description VARCHAR(512),
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS orders
(
    id         bigserial PRIMARY KEY,
    user_id    bigint NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS orders_items
(
    id               bigserial PRIMARY KEY,
    order_id         bigint REFERENCES orders (id),
    active_id        bigint NOT NULL UNIQUE REFERENCES actives (id),
    created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

