create table user
(
    id       int auto_increment
        primary key,
    username varchar(64)       not null,
    nickname varchar(64)       not null,
    password varchar(64)       not null,
    type     tinyint default 1 not null,
    money    double  default 0 not null,
    sex      tinyint default 1 not null,
    email    varchar(64)       null,
    avatar   varchar(128)      not null
)
    charset = utf8mb4;

INSERT INTO LvYouWangZhan.user (id, username, nickname, password, type, money, sex, email, avatar) VALUES (1, 'admin', '管理员', 'e10adc3949ba59abbe56e057f20f883e', 0, 0, 1, null, '//pic.imgdb.cn/item/61a59d382ab3f51d91a72a49.png');
INSERT INTO LvYouWangZhan.user (id, username, nickname, password, type, money, sex, email, avatar) VALUES (5, '15024820696', 'SevenOne1', '96e79218965eb72c92a549dd5a330112', 1, 0, 0, 'admin@qq.com', '//pic.imgdb.cn/item/61a59d382ab3f51d91a72a49.png');