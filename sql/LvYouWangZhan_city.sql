create table city
(
    id   int auto_increment
        primary key,
    name varchar(64) not null
)
    charset = utf8mb4;

INSERT INTO LvYouWangZhan.city (id, name) VALUES (1, '呼和浩特');
INSERT INTO LvYouWangZhan.city (id, name) VALUES (2, '包头');
INSERT INTO LvYouWangZhan.city (id, name) VALUES (3, '呼伦贝尔');
INSERT INTO LvYouWangZhan.city (id, name) VALUES (4, '兴安盟');
INSERT INTO LvYouWangZhan.city (id, name) VALUES (5, '通辽');
INSERT INTO LvYouWangZhan.city (id, name) VALUES (6, '赤峰');
INSERT INTO LvYouWangZhan.city (id, name) VALUES (7, '鄂尔多斯');
INSERT INTO LvYouWangZhan.city (id, name) VALUES (8, '阿拉善');