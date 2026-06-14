# EMS 项目

本仓库为一个简单的员工管理系统（后端 Spring Boot + MyBatis，前端 Vue + Vite）。

下面是项目启动与数据库准备的说明。

## 1. 概要

- 后端：Spring Boot（端口默认 8080），代码位于 `src/main/java`。
- 前端：Vue + Vite（开发模式端口默认 5173），代码位于 `frontend/`。
- 数据库：MySQL，需提前创建数据库和表（见下面 SQL）。
- 接口详情见`api接口文档.md`

## 2. 启动前的 MySQL 配置

- **<u>本项目已经配置了MySQL，不需要手动建表，直接运行后端即可自动建表并插入初始数据。</u>**
- 建议 MySQL 版本：8.0（也兼容 5.7），字符集建议使用 `utf8mb4`。
- 可以直接执行`db/`内的sql文件
- 在 MySQL 中执行下面 SQL：

```sql
-- 创建数据库（如果不存在）
CREATE DATABASE IF NOT EXISTS ems CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE ems;

-- 部门表
CREATE TABLE dept (
  id int unsigned PRIMARY KEY AUTO_INCREMENT COMMENT 'ID, 主键',
  name varchar(10) NOT NULL UNIQUE COMMENT '部门名称',
  create_time datetime DEFAULT NULL COMMENT '创建时间',
  update_time datetime DEFAULT NULL COMMENT '修改时间'
) COMMENT '部门表';

-- 部门初始数据
INSERT INTO dept VALUES (1,'学工部','2024-09-25 09:47:40','2024-09-25 09:47:40'),
                      (2,'教研部','2024-09-25 09:47:40','2024-09-09 15:17:04'),
                      (3,'咨询部','2024-09-25 09:47:40','2024-09-30 21:26:24'),
                      (4,'就业部','2024-09-25 09:47:40','2024-09-25 09:47:40'),
                      (5,'人事部','2024-09-25 09:47:40','2024-09-25 09:47:40'),
                      (6,'行政部','2024-11-30 20:56:37','2024-09-30 20:56:37');


-- 员工表
create table emp(
    id int unsigned primary key auto_increment comment 'ID,主键',
    username varchar(20) not null unique comment '用户名',
    password varchar(32) default '123456' comment '密码',
    name varchar(10) not null comment '姓名',
    gender tinyint unsigned not null comment '性别, 1:男, 2:女',
    phone char(11) not null unique comment '手机号',
    job tinyint unsigned comment '职位, 1 班主任, 2 讲师 , 3 学工主管, 4 教研主管, 5 咨询师',
    salary int unsigned comment '薪资',
    image varchar(255) comment '头像',
    entry_date date comment '入职日期',
    dept_id int unsigned comment '部门ID',
    create_time datetime comment '创建时间',
    update_time datetime comment '修改时间'
) comment '员工表';

-- 员工初始数据
INSERT INTO emp VALUES 
(1,'shinaian','123456','施耐庵',1,'13309090001',4,15000,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2000-01-01',2,'2023-10-20 16:35:33','2023-11-16 16:11:26'),
(2,'songjiang','123456','宋江',1,'13309090002',2,8600,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2015-01-01',2,'2023-10-20 16:35:33','2023-10-20 16:35:37'),
(3,'lujunyi','123456','卢俊义',1,'13309090003',2,8900,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2008-05-01',2,'2023-10-20 16:35:33','2023-10-20 16:35:39'),
(4,'wuyong','123456','吴用',1,'13309090004',2,9200,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2007-01-01',2,'2023-10-20 16:35:33','2023-10-20 16:35:41'),
(5,'gongsunsheng','123456','公孙胜',1,'13309090005',2,9500,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2012-12-05',2,'2023-10-20 16:35:33','2023-10-20 16:35:43'),
(6,'huosanniang','123456','扈三娘',2,'13309090006',3,6500,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2013-09-05',1,'2023-10-20 16:35:33','2023-10-20 16:35:45'),
(7,'chaijin','123456','柴进',1,'13309090007',1,4700,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2005-08-01',1,'2023-10-20 16:35:33','2023-10-20 16:35:47'),
(8,'likui','123456','李逵',1,'13309090008',1,4800,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2014-11-09',1,'2023-10-20 16:35:33','2023-10-20 16:35:49'),
(9,'wusong','123456','武松',1,'13309090009',1,4900,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2011-03-11',1,'2023-10-20 16:35:33','2023-10-20 16:35:51'),
(10,'linchong','123456','林冲',1,'13309090010',1,5000,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2013-09-05',1,'2023-10-20 16:35:33','2023-10-20 16:35:53'),
(11,'huyanzhuo','123456','呼延灼',1,'13309090011',2,9700,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2007-02-01',2,'2023-10-20 16:35:33','2023-10-20 16:35:55'),
(12,'xiaoliguang','123456','小李广',1,'13309090012',2,10000,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2008-08-18',2,'2023-10-20 16:35:33','2023-10-20 16:35:57'),
(13,'yangzhi','123456','杨志',1,'13309090013',1,5300,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2012-11-01',1,'2023-10-20 16:35:33','2023-10-20 16:35:59'),
(14,'shijin','123456','史进',1,'13309090014',2,10600,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2002-08-01',2,'2023-10-20 16:35:33','2023-10-20 16:36:01'),
(15,'sunerniang','123456','孙二娘',2,'13309090015',2,10900,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2011-05-01',2,'2023-10-20 16:35:33','2023-10-20 16:36:03'),
(16,'luzhishen','123456','鲁智深',1,'13309090016',2,9600,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2010-01-01',2,'2023-10-20 16:35:33','2023-10-20 16:36:05'),
(17,'liying','12345678','李应',1,'13309090017',1,5800,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2015-03-21',1,'2023-10-20 16:35:33','2023-10-20 16:36:07'),
(18,'shiqian','123456','时迁',1,'13309090018',2,10200,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2015-01-01',2,'2023-10-20 16:35:33','2023-10-20 16:36:09'),
(19,'gudasao','123456','顾大嫂',2,'13309090019',2,10500,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2008-01-01',2,'2023-10-20 16:35:33','2023-10-20 16:36:11'),
(20,'ruanxiaoer','123456','阮小二',1,'13309090020',2,10800,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2018-01-01',2,'2023-10-20 16:35:33','2023-10-20 16:36:13'),
(21,'ruanxiaowu','123456','阮小五',1,'13309090021',5,5200,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2015-01-01',3,'2023-10-20 16:35:33','2023-10-20 16:36:15'),
(22,'ruanxiaoqi','123456','阮小七',1,'13309090022',5,5500,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2016-01-01',3,'2023-10-20 16:35:33','2023-10-20 16:36:17'),
(23,'ruanji','123456','阮籍',1,'13309090023',5,5800,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2012-01-01',3,'2023-10-20 16:35:33','2023-10-20 16:36:19'),
(24,'tongwei','123456','童威',1,'13309090024',5,5000,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2006-01-01',3,'2023-10-20 16:35:33','2023-10-20 16:36:21'),
(25,'tongmeng','123456','童猛',1,'13309090025',5,4800,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2002-01-01',3,'2023-10-20 16:35:33','2023-10-20 16:36:23'),
(26,'yanshun','123456','燕顺',1,'13309090026',5,5400,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2011-01-01',3,'2023-10-20 16:35:33','2023-11-08 22:12:46'),
(27,'lijun','123456','李俊',1,'13309090027',2,6600,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2004-01-01',2,'2023-10-20 16:35:33','2023-11-16 17:56:59'),
(28,'lizhong','123456','李忠',1,'13309090028',5,5000,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2007-01-01',3,'2023-10-20 16:35:33','2023-11-17 16:34:22'),
(30,'liyun','123456','李云',1,'13309090030',NULL,NULL,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2020-03-01',NULL,'2023-10-20 16:35:33','2023-10-20 16:36:31'),
(36,'linghuchong','123456','令狐冲',1,'18809091212',2,6800,'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg','2023-10-19',2,'2023-10-20 20:44:54','2023-11-09 09:41:04');


-- 员工工作经历信息表
create table emp_expr(
    id int unsigned primary key auto_increment comment 'ID, 主键',
    emp_id int unsigned comment '员工ID',
    begin date comment '开始时间',
    end  date comment '结束时间',
    company varchar(50) comment '公司名称',
    job varchar(50) comment '职位'
)comment '工作经历';


-- 操作日志表
create table operate_log(
    id int unsigned primary key auto_increment comment 'ID',
    operate_emp_id int unsigned comment '操作人ID',
    operate_time datetime comment '操作时间',
    class_name varchar(100) comment '操作的类名',
    method_name varchar(100) comment '操作的方法名',
    method_params varchar(2000) comment '方法参数',
    return_value varchar(2000) comment '返回值',
    cost_time bigint unsigned comment '方法执行耗时, 单位:ms'
) comment '操作日志表';


```

- 如果 MySQL 需要其它用户和权限，可以执行（可选）：

```sql
CREATE USER 'ems'@'localhost' IDENTIFIED BY 'your_password';
GRANT ALL PRIVILEGES ON ems.* TO 'ems'@'localhost';
FLUSH PRIVILEGES;
```

- 在后端配置中（`src/main/resources/application.yml`）填写数据库连接：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/ems?createDatabaseIfNotExist=true
    username: root
    password: 123456
```

## 3. 后端启动（单体部署）

- 打包并运行：

```bash
# 使用 maven 打包（跳过测试）
cd ems
mvn -DskipTests package

# 运行 jar
java -jar target/ems-0.0.1-SNAPSHOT.jar
```

- 或使用 Spring Boot 的运行命令：

```bash
mvn spring-boot:run
```

- 后端服务默认监听端口：8080（`application.yml` 中 `server.port` 可修改）。

- 将前端打包产物放到后端静态资源目录（可选）：
  
  - 前端打包后将生成静态资源到 `frontend/dist`（Vite），把这些文件复制到 `src/main/resources/static/` 下，后端 8080 将直接提供静态页面。

## 4. 前后端分离启动（开发模式）

- 前端开发（Vite）：

```bash
cd frontend
npm install
npm run dev
```

- 前端开发服务器默认端口：5173（可在 `frontend/vite.config.js` 中配置）。
- Vite 已配置了代理：以 `/api` 开头的请求会代理到 `http://localhost:8080`（去掉 `/api` 前缀），因此开发时前端与后端启动需分别运行。
- 重要：前端 `axios` 的 `baseURL` 为 `/api`（请勿在生产模式中仍然依赖此代理；生产请用后端静态资源或设置正确的 API 域名）。

## 5. 启动时常见注意事项

- 确认 `application.yml` 中数据库 URL、用户名、密码正确，尤其是 MySQL 的时区和字符集参数（serverTimezone 和 useUnicode 等）。
- 如果出现 MyBatis 找不到 mapper 的问题，请确认 `src/main/resources/com/yeyu/mapper/*.xml` 文件存在且 namespace 与 Mapper 接口的全限定名一致。
- 登录接口：`POST /login`，请求体为 JSON：{ "username": "xxx", "password": "xxx" }，后端会在 `emp` 表中查找 `username` 与 `password`（请在数据库中保证存在该记录）。
- 密码字段：当前实现为明文比对（`select ... where username = #{username} and password = #{password}`），上线请务必改为安全的哈希（如 bcrypt）并在登录逻辑中校验哈希。
- 操作日志：项目使用 AOP 自动记录带 `@Log` 注解的方法，会往 `operate_log` 表写数据，请确保表存在并有足够的字段长度（method_params/return_value 使用 TEXT）。
- 若部署为单体 jar 并提供前端静态页面，确保将前端构建产物复制到后端 `src/main/resources/static` 或 `target/classes/static` 下。
