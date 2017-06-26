drop table if exists R_ACCESSSYSTEM;

/*==============================================================*/
/* Table: R_ACCESSSYSTEM                                        */
/*==============================================================*/
create table R_ACCESSSYSTEM
(
   ID                   bigint(20) not null auto_increment comment 'ID号',
   SYSCODE              varchar(32) not null comment '系统编码',
   SYSNAME              varchar(100) not null comment '系统名称',
   SYSADDR              varchar(512) comment '系统访问地址',
   REMARK               varchar(1024) comment '系统简介',
   STATUS               enum('N','F','D') not null comment '状态.N正常,F冻结,D无效',
   CREATETIME           datetime not null comment '创建时间',
   UPDATETIME           datetime comment '更新时间',
   CREATOR              bigint(20) comment '创建人',
   UPDATER              bigint(20) comment '更新人',
   primary key (ID)
) Engine=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 comment='接入系统表';

drop table if exists R_MENU;

/*==============================================================*/
/* Table: R_MENU                                                */
/*==============================================================*/
create table R_MENU
(
   ID                   bigint(20) not null auto_increment comment 'ID号',
   MENUCODE             varchar(32) not null comment '菜单编码',
   MENUNAME             varchar(100) not null comment '菜单名称',
   PARENTID             bigint(20) comment '上级菜单ID',
   SYSTEMID             bigint(20) comment '系统ID',
   MENUICON             varchar(255) comment '菜单图标',
   URLTYPE              enum('M','R','A') not null comment '地址类型.M菜单目录(无地址),R相对地址,A绝对地址',
   MENUURL              varchar(512) comment '菜单地址',
   SORT                 int(3) default 0 comment '排序',
   STATUS               enum('N','F','D') not null comment '状态.N正常,F冻结,D无效',
   CREATETIME           datetime not null comment '创建时间',
   UPDATETIME           datetime comment '更新时间',
   CREATOR              bigint(20) comment '创建人',
   UPDATER              bigint(20) comment '更新人',
   primary key (ID)
) Engine=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 comment='菜单定义表';

drop table if exists R_MENUITEM;

/*==============================================================*/
/* Table: R_MENUITEM                                            */
/*==============================================================*/
create table R_MENUITEM
(
   ID                   bigint(20) not null auto_increment comment 'ID号',
   ITEMCODE             varchar(32) not null comment '菜单项编码',
   ITEMNAME             varchar(100) not null comment '菜单项名称',
   MENUID               bigint(20) not null comment '菜单ID',
   ITEMICON             varchar(255) comment '菜单项图标',
   URLTYPE              enum('M','R','A') not null comment '地址类型.M菜单目录(无地址),R相对地址,A绝对地址',
   ITEMURL              varchar(512) comment 'URL地址',
   SORT                 int(3) default 0 comment '排序',
   STATUS               enum('N','F','D') not null comment '状态.N正常,F冻结,D无效',
   CREATETIME           datetime not null comment '创建时间',
   UPDATETIME           datetime comment '更新时间',
   CREATOR              bigint(20) comment '创建人',
   UPDATER              bigint(20) comment '更新人',
   primary key (ID)
) Engine=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 comment='菜单项定义表';

drop table if exists R_ROLE_GROUP;

/*==============================================================*/
/* Table: R_ROLE_GROUP                                          */
/*==============================================================*/
create table R_ROLE_GROUP
(
   ID                   bigint(20) not null auto_increment comment 'ID号',
   GROUPCODE            varchar(32) not null comment '分组编码',
   GROUPNAME            varchar(100) not null comment '分组名称',
   REMARK               varchar(1024) comment '类型描述',
   CREATETIME           datetime not null comment '创建时间',
   UPDATETIME           datetime comment '更新时间',
   CREATOR              bigint(20) comment '创建人',
   UPDATER              bigint(20) comment '更新人',
   primary key (ID)
) Engine=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 comment='角色类型';

drop table if exists R_ROLE;

/*==============================================================*/
/* Table: R_ROLE                                                */
/*==============================================================*/
create table R_ROLE
(
   ID                   bigint(20) not null comment 'ID号',
   ROLECODE             varchar(32) not null comment '角色编码',
   ROLENAME             varchar(100) not null comment '角色名称',
   GROUPID              bigint(20) not null comment '角色类型',
   STATUS               enum('N','F','D') not null comment '状态.N正常,F冻结,D注销',
   REMARK               varchar(1024) comment '描述',
   SYSTEMID             bigint(20) comment '接入系统',
   CREATETIME           datetime not null comment '创建时间',
   UPDATETIME           datetime comment '更新时间',
   CREATOR              bigint(20) comment '创建人',
   UPDATER              bigint(20) comment '更新人',
   primary key (ID)
) Engine=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 comment='角色定义表';

drop table if exists R_ROLE_MENU;

/*==============================================================*/
/* Table: R_ROLE_MENU                                           */
/*==============================================================*/
create table R_ROLE_MENU
(
   ROLEID               bigint(20) not null comment '角色ID',
   MENUID               bigint(20) not null comment '菜单ID',
   primary key (ROLEID, MENUID)
) Engine=InnoDB DEFAULT CHARSET=utf8 comment='角色菜单关联表';

drop table if exists R_ROLE_MENUITEM;

/*==============================================================*/
/* Table: R_ROLE_MENUITEM                                       */
/*==============================================================*/
create table R_ROLE_MENUITEM
(
   ROLEID               bigint(20) not null comment '角色ID',
   ITEMID               bigint(20) not null comment '菜单项ID',
   primary key (ROLEID, ITEMID)
) Engine=InnoDB DEFAULT CHARSET=utf8 comment='角色菜单项关联表';

drop table if exists S_DICTTYPE;

/*==============================================================*/
/* Table: S_DICTTYPE                                            */
/*==============================================================*/
create table S_DICTTYPE
(
   ID                   bigint(20) not null auto_increment comment 'ID号',
   TYPECODE             varchar(32) not null comment '类型编码',
   TYPENAME             varchar(100) not null comment '类型名称',
   VALUETYPE            varchar(32) not null comment '字典值类型,N:无数据;B:布尔数据;T:文本数据;I:整型数据;F浮点型数据',
   STATUS               enum('D','F','N') not null comment '状态',
   REMARK               varchar(512) comment '类型描述',
   CREATETIME           datetime not null comment '创建时间',
   UPDATETIME           datetime comment '更新时间',
   CREATOR              bigint(20) not null comment '创建人',
   UPDATER              bigint(20) comment '更新人',
   primary key (ID)
) Engine=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 comment='数据字典类型表';

drop table if exists S_DICTDATA;

/*==============================================================*/
/* Table: S_DICTDATA                                            */
/*==============================================================*/
create table S_DICTDATA
(
   ID                   bigint(20) not null auto_increment comment 'ID号',
   DATACODE             varchar(32) not null comment '字典编码',
   DATANAME             varchar(100) not null comment '字典名称',
   TYPEID               bigint(20) not null comment '字典类型',
   SORT                 smallint not null comment '排序',
   STATUS               enum('D','F','N') not null comment '状态',
   DATAVALUE            varchar(100) comment '字典值',
   CREATETIME           datetime not null comment '创建时间',
   UPDATETIME           datetime comment '更新时间',
   CREATOR              bigint(20) not null comment '创建人',
   UPDATER              bigint(20) comment '更新人',
   primary key (ID)
) Engine=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 comment='数据字典表';

drop table if exists U_USER_BASIC;

/*==============================================================*/
/* Table: U_USER_BASIC                                          */
/*==============================================================*/
create table U_USER_BASIC
(
   ID                   bigint(20) not null auto_increment comment 'ID号',
   ACCOUNT              varchar(32) not null comment '登录名',
   PASSWORD             varchar(64) not null comment '登录密码',
   SALT                 varchar(36) not null comment '密码盐值',
   NICKNAME             varchar(32) comment '显示名',
   FORMID               bigint(20) comment '属性表单ID',
   CURRLOGINTIME        datetime comment '本次登录时间',
   PRELOGINTIME         datetime comment '上次登录时间',
   CURRLOGINIP          varchar(32) comment '本次登录IP',
   PRELOGINIP           varchar(32) comment '上次登录IP',
   primary key (ID)
) Engine=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 comment='用户基础表';

drop table if exists R_USER_ROLE;

/*==============================================================*/
/* Table: R_USER_ROLE                                           */
/*==============================================================*/
create table R_USER_ROLE
(
   USERID               bigint(20) not null comment '用户ID',
   ROLEID               bigint(20) not null comment '角色ID',
   primary key (USERID, ROLEID)
) Engine=InnoDB DEFAULT CHARSET=utf8 comment='用户角色关联表';

drop table if exists U_USER_STATUS;

/*==============================================================*/
/* Table: U_USER_STATUS                                         */
/*==============================================================*/
create table U_USER_STATUS
(
   USERID               bigint(20) not null comment '用户ID',
   STATUS               enum('N','L','F','D') not null comment '状态.N正常,L锁定,F冻结,D已注销',
   CREATETIME           datetime not null comment '创建时间',
   FROZENTIME           datetime comment '冻结时间',
   LOCKEDTIME           datetime comment '锁定时间',
   DEMISETIME           datetime comment '注销时间',
   UPDATETIME           datetime comment '更新时间',
   CREATOR              bigint(20) comment '创建人',
   UPDATER              bigint(20) comment '更新人',
   primary key (USERID)
) Engine=InnoDB DEFAULT CHARSET=utf8 comment='用户状态表';

drop table if exists U_USER_INFO;

/*==============================================================*/
/* Table: U_USER_INFO                                           */
/*==============================================================*/
create table U_USER_INFO
(
   USERID               bigint(20) not null comment '用户ID',
   MOBILENO             varchar(32) comment '手机号码',
   EMAIL                varchar(64) comment '邮箱地址',
   CERTTYPE             char(1) comment '证件类型',
   CERTNO               varchar(32) comment '证件号码',
   OFFICEPHONE          varchar(32) comment '办公电话',
   FAXNO                varchar(32) comment '传真',
   primary key (USERID)
) Engine=InnoDB DEFAULT CHARSET=utf8 comment='用户基础属性表';

drop table if exists F_FORM_INFO;

/*==============================================================*/
/* Table: F_FORM_INFO                                           */
/*==============================================================*/
create table F_FORM_INFO
(
   ID                   bigint(20) not null auto_increment comment 'ID号',
   FORMCODE             varchar(32) not null comment '表单编码',
   FORMNAME             varchar(100) not null comment '表单名称',
   STATUS               enum('N','F','D') not null comment '状态.N正常,F冻结',
   REMARK               varchar(1024) comment '备注',
   CREATETIME           datetime not null comment '创建时间',
   UPDATETIME           datetime comment '更新时间',
   CREATOR              bigint(20) comment '创建人',
   UPDATER              bigint(20) comment '更新人',
   primary key (ID)
) Engine=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 comment='表单定义表';

drop table if exists F_FIELD_INFO;

/*==============================================================*/
/* Table: F_FIELD_INFO                                          */
/*==============================================================*/
create table F_FIELD_INFO
(
   ID                   bigint(20) not null auto_increment comment 'ID号',
   FIELDCODE            varchar(32) not null comment '字段编码',
   FIELDNAME            varchar(100) not null comment '字段名称',
   FIELDTYPE            varchar(32) not null comment '字段类型.input,checkbox,radio,select',
   MACROTYPE            varchar(32) comment '宏类型,即字段子类型,如文本框中可以分为普通文本,邮箱地址,数字型等',
   DEFAULTVALUE         varchar(32) comment '字段默认值',
   STATUS               enum('D','F','N') not null comment '状态.N正常(可正常使用),F冻结(不可新添加该字段,已添加字段不影响),D注销(所有表单不可用)',
   CREATETIME           datetime not null comment '创建时间',
   UPDATETIME           datetime comment '更新时间',
   CREATOR              bigint(20) comment '创建人',
   UPDATER              bigint(20) comment '更新人',
   primary key (ID)
) Engine=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 comment='表单属性定义表';

drop table if exists F_FIELD_ITEM;

/*==============================================================*/
/* Table: F_FIELD_ITEM                                          */
/*==============================================================*/
create table F_FIELD_ITEM
(
   ID                   bigint(20) not null auto_increment comment 'ID号',
   ITEMVALUE            varchar(32) not null comment '选项值',
   ITEMNAME             varchar(100) not null comment '选项名称',
   FIELDID              bigint(20) not null comment '表单属性ID',
   STATUS               enum('N','F','D') not null comment '状态.N正常,F冻结,D注销',
   SORT                 int(3) comment '排序',
   CREATETIME           datetime not null comment '创建时间',
   UPDATETIME           datetime comment '更新时间',
   CREATOR              bigint(20) comment '创建人',
   UPDATER              bigint(20) comment '更新人',
   primary key (ID)
) Engine=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 comment='表单属性选项表';

drop table if exists F_FORM_FIELD;

/*==============================================================*/
/* Table: F_FORM_FIELD                                          */
/*==============================================================*/
create table F_FORM_FIELD
(
   FORMID               bigint(20) not null comment '表单ID',
   FIELDID              bigint(20) not null comment '表单属性ID',
   SORT                 int(3) comment '排序',
   primary key (FORMID, FIELDID)
) Engine=InnoDB DEFAULT CHARSET=utf8 comment='表单字段关联表';

drop table if exists U_USER_PROPERTY;

/*==============================================================*/
/* Table: U_USER_PROPERTY                                       */
/*==============================================================*/
create table U_USER_PROPERTY
(
   USERID               bigint(20) not null comment '用户ID',
   FIELDCODE            varchar(32) not null comment '字段编码',
   FIELDNAME            varchar(100) not null comment '字段名称',
   VALUE                varchar(1024) comment '值',
   primary key (USERID, FIELDCODE)
) Engine=InnoDB DEFAULT CHARSET=utf8 comment='用户扩展属性表';