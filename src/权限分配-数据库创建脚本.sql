DROP DATABASE mldn3 ;
CREATE DATABASE mldn3 CHARACTER SET UTF8 ;
USE mldn3 ;
-- 4、创建数据表
CREATE TABLE member  (
   mid                varchar(50)         not null,
   name               varchar(30),
   password           varchar(32),
   lastdate           datetime,
   locked             int,
   trycount			  int, 
   locktime			  datetime ,
   constraint pk_mid primary key (mid)
) engine=innodb ;
CREATE TABLE role (
   rid                varchar(50)              not null,
   title               varchar(50),
   constraint pk_rid primary key (rid)
) engine=innodb ;
CREATE TABLE action (
   actid              varchar(50),
   title              varchar(50),
   rid                varchar(50) ,
   constraint pk_actid primary key (actid) ,
   CONSTRAINT fk_rid FOREIGN KEY(rid) REFERENCES role(rid)
) engine=innodb ;
CREATE TABLE member_role (
   mid                varchar(50),
   rid                varchar(50) ,
   CONSTRAINT fk_mid FOREIGN KEY(mid) REFERENCES member(mid) ,
   CONSTRAINT fk_rid2 FOREIGN KEY(rid) REFERENCES role(rid) 
) engine=innodb ;
CREATE TABLE member_logs (
   mlid               bigint AUTO_INCREMENT ,
   mid                varchar(50),
   logintime          datetime,
   constraint PK_mlid primary key (mlid) ,
   CONSTRAINT fk_mid3 FOREIGN KEY(mid) REFERENCES member(mid)
) engine=innodb ;

-- 5、创建测试数据
-- 增加用户：admin/hello
INSERT INTO member(mid,name,password,lastdate,locked) VALUES ('admin','管理员','EAB62A7769F0313F8D69CEBA32F4347E','2019-10-01',0) ;
-- 增加用户：mldn/java
INSERT INTO member(mid,name,password,lastdate,locked) VALUES ('mldn','用户','D6DBB9093F83091B1EB3109197659FDE','2019-10-01',0) ;
-- 增加角色信息
INSERT INTO role(rid,title) VALUES ('member','用户管理') ;
INSERT INTO role(rid,title) VALUES ('dept','部门管理') ;
INSERT INTO role(rid,title) VALUES ('goods','办公用品管理') ;

INSERT INTO action(actid,title,rid) VALUES ('member:add','创建用户','member') ;
INSERT INTO action(actid,title,rid) VALUES ('member:edit','编辑用户','member') ;
INSERT INTO action(actid,title,rid) VALUES ('member:delete','删除用户','member') ;
INSERT INTO action(actid,title,rid) VALUES ('member:list','查看用户','member') ;
INSERT INTO action(actid,title,rid) VALUES ('dept:add','创建部门','dept') ;
INSERT INTO action(actid,title,rid) VALUES ('dept:edit','编辑部门','dept') ;
INSERT INTO action(actid,title,rid) VALUES ('dept:delete','删除部门','dept') ;
INSERT INTO action(actid,title,rid) VALUES ('dept:list','查看部门','dept') ;
INSERT INTO action(actid,title,rid) VALUES ('goods:item','商品分类','goods') ;
INSERT INTO action(actid,title,rid) VALUES ('goods:list','商品列表','goods') ;
INSERT INTO action(actid,title,rid) VALUES ('goods:add','商品添加','goods') ;
INSERT INTO action(actid,title,rid) VALUES ('goods:edit','商品修改','goods') ;
INSERT INTO action(actid,title,rid) VALUES ('goods:delete','商品删除','goods') ;

-- 设置用户与角色的对应关系
INSERT INTO member_role(mid,rid) VALUES ('admin','member') ;
INSERT INTO member_role(mid,rid) VALUES ('admin','dept') ;
INSERT INTO member_role(mid,rid) VALUES ('admin','goods') ;
INSERT INTO member_role(mid,rid) VALUES ('mldn','dept') ;
INSERT INTO member_role(mid,rid) VALUES ('mldn','goods') ;
COMMIT ;