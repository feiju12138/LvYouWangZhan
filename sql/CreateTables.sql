
-- 创建库
CREATE DATABASE LvYouWangZhan CHARSET utf8mb4;
USE LvYouWangZhan;

-- 用户
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

-- 城市
create table city
(
    id   int auto_increment
        primary key,
    name varchar(64) not null
)
    charset = utf8mb4;

-- 景点
create table attractions
(
    id        int auto_increment
        primary key,
    city_id   int                        not null comment '所属城市的编号',
    name      varchar(64)                not null comment '景点名称',
    img       varchar(2048) default '[]' not null comment '景点图片',
    money     double                     not null comment '景点价格',
    introduce varchar(128)               null comment '景点介绍',
    score     double        default 5    not null comment '景点评分'
)
    charset = utf8mb4;

-- 酒店
create table hotel
(
    id        int auto_increment
        primary key,
    city_id   int                        not null comment '所属城市的编号',
    name      varchar(64)                not null comment '酒店名称',
    img       varchar(2048) default '[]' not null comment '酒店图片',
    address   varchar(64)                not null comment '酒店地址',
    introduce varchar(128)               null comment '酒店介绍',
    score     double        default 5    not null comment '酒店评分'
)
    charset = utf8mb4;

-- 房间
create table room
(
    id           int auto_increment
        primary key,
    hotel_id     int                        not null comment '所属酒店的编号',
    name         varchar(64)                not null comment '房间名称',
    img          varchar(2048) default '[]' not null comment '房间图片',
    money        double                     not null comment '房间价格',
    tag          varchar(64)                null comment '酒店标签',
    information  varchar(256)               null comment '基本信息',
    toiletries   varchar(256)               null comment '洗浴用品',
    conveniences varchar(256)               null comment '便利设施',
    technology   varchar(256)               null comment '媒体科技',
    bathroom     varchar(256)               null comment '浴室',
    food         varchar(256)               null comment '食品饮品',
    other        varchar(256)               null comment '其他设施'
)
    charset = utf8mb4;

-- 订单
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
