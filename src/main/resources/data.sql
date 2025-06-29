CREATE TABLE users (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `nickname` VARCHAR(50) NOT NULL COMMENT '昵称',
    `avatar` VARCHAR(200) COMMENT '头像URL',
    `created_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `updated_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deleted_time` DATETIME COMMENT '软删除时间',
    `create_user` BIGINT COMMENT '创建人ID',
    `update_user` BIGINT COMMENT '更新人ID',
    `delete_user` BIGINT COMMENT '删除人ID'
);

CREATE TABLE user_auths (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `user_id` BIGINT NOT NULL COMMENT '关联用户ID',
    `identity_type` VARCHAR(20) NOT NULL COMMENT '登录类型（email/phone/weixin）',
    `identifier` VARCHAR(100) NOT NULL COMMENT '标识（邮箱/手机号/第三方ID）',
    `credential` VARCHAR(200) NOT NULL COMMENT '凭证（哈希密码/Token）',
    `verified` TINYINT DEFAULT 0 COMMENT '是否验证：0-否，1-是',
    UNIQUE KEY `uk_user_auths` (`user_id`, `identifier`)
);

CREATE TABLE todo_lists (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL COMMENT '列表名称',
    status TINYINT DEFAULT 0 COMMENT '状态：0-进行中，1-已完成，2-已归档',
    created_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted_time DATETIME COMMENT '软删除时间',
    create_user BIGINT COMMENT '创建人ID',
    update_user BIGINT COMMENT '更新人ID',
    delete_user BIGINT COMMENT '删除人ID'
);

CREATE TABLE todo_items (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    list_id BIGINT NOT NULL COMMENT '所属列表ID',
    content TEXT NOT NULL COMMENT '事项内容',
    created_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_time DATETIME COMMENT '软删除时间',
    create_user BIGINT COMMENT '创建人ID',
    update_user BIGINT COMMENT '更新人ID',
    delete_user BIGINT COMMENT '删除人ID'
);