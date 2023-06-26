create table orders
(
    id          int auto_increment
        primary key,
    user_id     int      not null comment '关联的用户',
    room_id     int      not null comment '关联的酒店房间',
    create_time datetime not null comment '创建订单时间',
    money       double   not null,
    start_time  datetime null comment '开始时间',
    end_time    datetime null comment '结束时间'
);

INSERT INTO LvYouWangZhan.orders (id, user_id, room_id, create_time, money, start_time, end_time) VALUES (1, 5, 3, '2021-12-03 06:03:10', 999, '2021-12-06 12:58:25', '2021-12-06 12:58:25');
INSERT INTO LvYouWangZhan.orders (id, user_id, room_id, create_time, money, start_time, end_time) VALUES (2, 5, 3, '2021-12-03 06:03:10', 999, '2021-12-06 12:58:25', '2021-12-06 12:58:25');
INSERT INTO LvYouWangZhan.orders (id, user_id, room_id, create_time, money, start_time, end_time) VALUES (3, 5, 4, '2021-12-03 06:03:10', 999, '2021-12-06 12:58:25', '2021-12-06 12:58:25');
INSERT INTO LvYouWangZhan.orders (id, user_id, room_id, create_time, money, start_time, end_time) VALUES (4, 5, 4, '2021-12-03 06:03:10', 999, '2021-12-06 12:58:25', '2021-12-06 12:58:25');
INSERT INTO LvYouWangZhan.orders (id, user_id, room_id, create_time, money, start_time, end_time) VALUES (5, 5, 5, '2021-12-03 06:03:10', 999, '2021-12-06 12:58:25', '2021-12-06 12:58:25');
INSERT INTO LvYouWangZhan.orders (id, user_id, room_id, create_time, money, start_time, end_time) VALUES (6, 5, 5, '2021-12-03 06:03:10', 999, '2021-12-06 12:58:25', '2021-12-06 12:58:25');
INSERT INTO LvYouWangZhan.orders (id, user_id, room_id, create_time, money, start_time, end_time) VALUES (7, 5, 6, '2021-12-03 06:03:10', 999, '2021-12-06 12:58:25', '2021-12-06 12:58:25');
INSERT INTO LvYouWangZhan.orders (id, user_id, room_id, create_time, money, start_time, end_time) VALUES (8, 5, 6, '2021-12-03 06:03:10', 999, '2021-12-06 12:58:25', '2021-12-06 12:58:25');
INSERT INTO LvYouWangZhan.orders (id, user_id, room_id, create_time, money, start_time, end_time) VALUES (9, 5, 7, '2021-12-03 06:03:10', 999, '2021-12-06 12:58:25', '2021-12-06 12:58:25');
INSERT INTO LvYouWangZhan.orders (id, user_id, room_id, create_time, money, start_time, end_time) VALUES (10, 5, 8, '2021-12-03 16:17:08', 888.8, '2021-12-06 12:58:25', '2021-12-06 12:58:25');