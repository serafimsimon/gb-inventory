insert into brands (title)
values ('Huawei'),
       ('LG'),
       ('DELL'),
       ('HP'),
       ('Samsung'),
       ('Compit'),
       ('Apple');

insert into conditions (title)
values ('New'),
       ('Used'),
       ('Defective');

insert into types (title)
values ('Системный блок'),
       ('Ноутбук'),
       ('Планшет'),
       ('Монитор'),
       ('Телефон'),
       ('Клавиатура'),
       ('Мышь'),
       ('Аудиогарнитура');

insert into devices (owner_Id, kind_id, producer_id, model, serial_number, condition_id)
values (1, 1, 1, 'AAA', '001', 1),
       (2, 2, 2, 'BBB', '002', 2),
       (3, 2, 2, 'CCC', '003', 2),
       (4, 2, 2, 'DDD', '004', 2),
       (5, 2, 2, 'EEE', '005', 2);