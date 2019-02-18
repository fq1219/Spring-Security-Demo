create table SYS_AUTHORITIES
(
  AUTHORITY_ID   VARCHAR2(32) not null,
  AUTHORITY_NAME VARCHAR2(40),
  AUTHORITY_DESC VARCHAR2(100),
  ENABLED        NUMBER(1),
  ISSYS          NUMBER(1),
  MODULE         VARCHAR2(4)
)

create table SYS_AUTHORITIES_RESOURCES
(
  ID           NUMBER(13) not null,
  AUTHORITY_ID VARCHAR2(32),
  RESOURCE_ID  VARCHAR2(32),
  ENABLED      NUMBER(1)
)

create table SYS_RESOURCES
(
  RESOURCE_ID     VARCHAR2(32) not null,
  RESOURCE_NAME   VARCHAR2(100),
  RESOURCE_DESC   VARCHAR2(100),
  RESOURCE_TYPE   VARCHAR2(40),
  RESOURCE_STRING VARCHAR2(200),
  PRIORITY        NUMBER(1),
  ENABLED         NUMBER(1),
  ISSYS           NUMBER(1),
  MODULE          VARCHAR2(4)
)

create table SYS_ROLES
(
  ROLE_ID   VARCHAR2(32) not null,
  ROLE_NAME VARCHAR2(40),
  ROLE_DESC VARCHAR2(100),
  ENABLED   NUMBER(1),
  ISSYS     NUMBER(1),
  MODULE    VARCHAR2(4)
)

create table SYS_ROLES_AUTHORITIES
(
  ID           NUMBER(13) not null,
  ROLE_ID      VARCHAR2(32),
  AUTHORITY_ID VARCHAR2(32),
  ENABLED      NUMBER(1)
)

create table SYS_USERS
(
  USER_ID       VARCHAR2(32) not null,
  USER_ACCOUNT  VARCHAR2(30),
  USER_NAME     VARCHAR2(40),
  USER_PASSWORD VARCHAR2(100),
  USER_DESC     VARCHAR2(100),
  ENABLED       NUMBER(1),
  ISSYS         NUMBER(1),
  USER_DEPT     VARCHAR2(20),
  USER_DUTY     VARCHAR2(10),
  SUB_SYSTEM    VARCHAR2(30)
)

create table SYS_USERS_ROLES
(
  ID      NUMBER(13) not null,
  USER_ID VARCHAR2(32),
  ROLE_ID VARCHAR2(32),
  ENABLED NUMBER(1)
)

insert into SYS_AUTHORITIES (AUTHORITY_ID, AUTHORITY_NAME, AUTHORITY_DESC, ENABLED, ISSYS, MODULE)
values ('auth_admin', 'auth_admin', null, null, null, null);
insert into SYS_AUTHORITIES (AUTHORITY_ID, AUTHORITY_NAME, AUTHORITY_DESC, ENABLED, ISSYS, MODULE)
values ('auth_lxb', 'auth_lxb', null, null, null, null);
insert into SYS_AUTHORITIES (AUTHORITY_ID, AUTHORITY_NAME, AUTHORITY_DESC, ENABLED, ISSYS, MODULE)
values ('auth_user', 'auth_user', null, null, null, null);

insert into SYS_AUTHORITIES_RESOURCES (ID, AUTHORITY_ID, RESOURCE_ID, ENABLED)
values (1, 'auth_admin', 'admin', 1);
insert into SYS_AUTHORITIES_RESOURCES (ID, AUTHORITY_ID, RESOURCE_ID, ENABLED)
values (2, 'auth_lxb', 'lxb', null);
insert into SYS_AUTHORITIES_RESOURCES (ID, AUTHORITY_ID, RESOURCE_ID, ENABLED)
values (3, 'auth_user', 'user', null);

insert into SYS_RESOURCES (RESOURCE_ID, RESOURCE_NAME, RESOURCE_DESC, RESOURCE_TYPE, RESOURCE_STRING, PRIORITY, ENABLED, ISSYS, MODULE)
values ('admin', 'admin', null, null, '/admin/admin.jsp', null, null, null, null);
insert into SYS_RESOURCES (RESOURCE_ID, RESOURCE_NAME, RESOURCE_DESC, RESOURCE_TYPE, RESOURCE_STRING, PRIORITY, ENABLED, ISSYS, MODULE)
values ('lxb', 'lxb', null, null, '/lxb.lxb.jsp', null, null, null, null);
insert into SYS_RESOURCES (RESOURCE_ID, RESOURCE_NAME, RESOURCE_DESC, RESOURCE_TYPE, RESOURCE_STRING, PRIORITY, ENABLED, ISSYS, MODULE)
values ('user', 'user', null, null, '/user/user.jsp', null, null, null, null);

insert into SYS_ROLES (ROLE_ID, ROLE_NAME, ROLE_DESC, ENABLED, ISSYS, MODULE)
values ('role_admin', 'role_admin', null, null, null, null);
insert into SYS_ROLES (ROLE_ID, ROLE_NAME, ROLE_DESC, ENABLED, ISSYS, MODULE)
values ('role_lxb', 'role_lxb', null, null, null, null);
insert into SYS_ROLES (ROLE_ID, ROLE_NAME, ROLE_DESC, ENABLED, ISSYS, MODULE)
values ('role_user', 'role_user', null, null, null, null);

insert into SYS_ROLES_AUTHORITIES (ID, ROLE_ID, AUTHORITY_ID, ENABLED)
values (1, 'role_admin', 'auth_admin', 1);
insert into SYS_ROLES_AUTHORITIES (ID, ROLE_ID, AUTHORITY_ID, ENABLED)
values (2, 'role_lxb', 'auth_lxb', 1);
insert into SYS_ROLES_AUTHORITIES (ID, ROLE_ID, AUTHORITY_ID, ENABLED)
values (3, 'role_user', 'auth_user', 1);

insert into SYS_USERS (USER_ID, USER_ACCOUNT, USER_NAME, USER_PASSWORD, USER_DESC, ENABLED, ISSYS, USER_DEPT, USER_DUTY, SUB_SYSTEM)
values ('admin', 'admin', 'admin', 'admin', null, null, null, null, null, null);
insert into SYS_USERS (USER_ID, USER_ACCOUNT, USER_NAME, USER_PASSWORD, USER_DESC, ENABLED, ISSYS, USER_DEPT, USER_DUTY, SUB_SYSTEM)
values ('lxb', 'lxb', 'lxb', 'lxb', null, null, null, null, null, null);
insert into SYS_USERS (USER_ID, USER_ACCOUNT, USER_NAME, USER_PASSWORD, USER_DESC, ENABLED, ISSYS, USER_DEPT, USER_DUTY, SUB_SYSTEM)
values ('user', 'user', 'user', 'user', null, null, null, null, null, null);

insert into SYS_USERS_ROLES (ID, USER_ID, ROLE_ID, ENABLED)
values (1, 'admin', 'role_admin', 1);
insert into SYS_USERS_ROLES (ID, USER_ID, ROLE_ID, ENABLED)
values (2, 'lxb', 'role_lxb', 1);
insert into SYS_USERS_ROLES (ID, USER_ID, ROLE_ID, ENABLED)
values (3, 'user', 'role_user', 1);