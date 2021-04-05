DROP database IF EXISTS pilipihu_user_service;
CREATE database pilipihu_user_service;
USE pilipihu_user_service;

CREATE table user(
    id bigint unsigned primary key auto_increment,
    user_name varchar(255) not null,-- 用户名
    user_password varchar(255) not null,-- 用户密码
    phone char(11),-- 电话号码
    email varchar(255)-- 电子邮件
);

CREATE table user_detail(
    uid bigint unsigned primary key,
    sex char(1),
    id_card char(18),-- 用户身份证号
    real_name varchar(255),-- 用户真实姓名
    sign_up date-- 注册时间
    -- foreign key(uid) references user(id) //外键约束，废弃，出于性能考虑
);

CREATE table user_login(
    uid bigint unsigned,-- 对应user表中的id
    login_time datetime,
    login_ip int default 0,-- ip地址，使用inet_aton()和inet_ntoa()函数进行换算// int(10)显示宽度不建议使用
    login_device varchar(255),
    primary key(uid,login_time)
);