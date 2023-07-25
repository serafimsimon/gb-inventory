INSERT INTO users (firstName,lastName, middleName, grade, job_id, department_id, email)
VALUES ('Богданов', 'Леонтий', 'Евгеньевич', 1, 1, 1, 'BogdanovLE@gmail.com'),
       ('Фадеев', 'Анатолий', 'Донатович', 2, 2, 2, 'FadeevAD@gmail.com'),
       ('Устинов', 'Нинель', 'Романович', 3, 2, 1, 'UstinovYR@gmail.com'),
       ('Лихачев', 'Донат', 'Арьемович', 4, 2, 2, 'LixachevDA@gmail.com'),
       ('Комиссаров', 'Захар', 'Агафонович', 5, 2, 2, 'KomissarovZA@gmail.com'),
       ('Савина', 'Адельфина', 'Ивановна', 6, 2, 1, 'SavinaAI@gmail.com'),
       ('Максимова', 'Николь', 'Арсеньева', 7, 2, 1, 'MaximovaNA@gmail.com'),
       ('Громова', 'Нора', 'Еремеевна', 8, 2, 2, 'GromovaNE@gmail.com'),
       ('Ситникова', 'Злата', 'Валерьевна', 9, 2, 1, 'SitnikovaZV@gmail.com'),
       ('Третьякова', 'Земфира', 'Максовна', 10, 2, 2, 'TretyakovaZM@gmail.com');


INSERT INTO departments (title)
VALUES ('Administrative department'),
       ('Transportation department'),
       ('Finance department'),
       ('HR department');

INSERT INTO producers (title)
VALUES ('Huawei'),
       ('LG'),
       ('DELL'),
       ('HP'),
       ('Samsung'),
       ('Compit'),
       ('Apple');

INSERT INTO conditions (title)
VALUES ('New'),
       ('Used'),
       ('Defective');

INSERT INTO kinds (title)
VALUES ('Системный блок'),
       ('Ноутбук'),
       ('Планшет'),
       ('Монитор'),
       ('Телефон'),
       ('Клавиатура'),
       ('Мышь'),
       ('Аудиогарнитура');

INSERT INTO actives (owner_Id, kind_id, producer_id, model, serial_number, condition_id)
VALUES (1, 1, 1, 'AAA', '001', 1);

INSERT INTO jobs (dep_id, title, description)
VALUES
    (0, 'Администратор', 'Администратор системы'),
    (1, 'Распределитель', 'Работник склада ИТ'),
    (2, 'Директор', 'Директор предприятия'),
    (3, 'Нач. АСУ', 'Начальник отдела АСУ'),
    (4, 'Инж. АСУ', 'Инженер отдела АСУ'),
    (5, 'Техник', 'Техник отдела АСУ'),
    (6, 'Нач. ОК', 'Начальник отдела кадров');

INSERT INTO orders (user_id)
VALUES (1),
       (2),
       (3);

INSERT INTO orders_items (order_id, active_id, created_at, updated_at)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (2, 4),
       (3, 5);
