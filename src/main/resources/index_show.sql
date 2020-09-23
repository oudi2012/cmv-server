drop table if exists v_menu_info;
#id, name, title, type, isShow, url, iconSrc, orderNo, creator, createTime,
CREATE TABLE v_menu_info (
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  title varchar(100) NOT NULL,
  type int(2) DEFAULT 1 comment '类型：默认1,2',
  isShow tinyint(1) DEFAULT 1 comment '是否显示 0否 1是',
  url varchar(200) DEFAULT NULL comment '连接地址',
  iconSrc varchar(200) DEFAULT NULL comment '图标',
  orderNo int(10) DEFAULT 0,
  creator bigint(20) NOT NULL,
  createTime int(10) DEFAULT 0,
  PRIMARY KEY (id)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '菜单';


DROP TABLE IF EXISTS info_articleInfo;
#id, author, userId, grade, dynasty, cateId, styleId, tags, title, content, createDate, href
CREATE TABLE info_articleInfo  (
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  author varchar(50) DEFAULT NULL COMMENT '作者',
  userId bigint(20) DEFAULT NULL COMMENT 'userId',
  grade int(2) NOT NULL DEFAULT 0 COMMENT '年级',
  dynasty int(2) NOT NULL DEFAULT 0 COMMENT '朝代',
  cateId int(8) NOT NULL DEFAULT 0 COMMENT '分类编号',
  styleId int(8) NOT NULL DEFAULT 0 COMMENT '形式编号',
  tags varchar(100) DEFAULT NULL COMMENT '标签',
  title varchar(100) DEFAULT NULL,
  content mediumtext DEFAULT NULL,
  createDate datetime(0) NULL DEFAULT NULL,
  href varchar(100) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (id)
) ENGINE = InnoDB AUTO_INCREMENT = 11868 DEFAULT CHARSET=utf8 COMMENT = '古文内容';
