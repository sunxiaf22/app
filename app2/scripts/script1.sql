drop table tbl_shopping_mgr;
create table tbl_shopping_mgr (
id INTEGER PRIMARY KEY autoincrement,
shoppingItem	TEXT,
shoppingCount	REAL,
shoppingComments	TEXT,
type	TEXT,
createdby	TEXT,
createddt	TEXT,
updatedby	TEXT,
updateddt	TEXT,
status	TEXT
);


drop table tbl_user_mgr;
create table tbl_user_mgr (
id INTEGER PRIMARY KEY autoincrement,
username TEXT,
password TEXT,
gender TEXT,
mail	TEXT,
phone	TEXT,
address TEXT,
headcount	TEXT,
column1	TEXT,
column2	TEXT,
comments	TEXT,
createdby	TEXT,
createddt	TEXT,
updatedby	TEXT,
updateddt	TEXT,
status	TEXT
);

drop table tbl_mail_notification;
create table tbl_mail_notification (
id INTEGER PRIMARY KEY autoincrement,
subject   TEXT,
receiver  TEXT,
content   TEXT,
createdby	TEXT,
createddt	TEXT,
updatedby	TEXT,
updateddt	TEXT,
status	TEXT
);


drop table tbl_configurations;
create table tbl_configurations (
id INTEGER PRIMARY KEY autoincrement,
name   TEXT,
value  TEXT,
createdby	TEXT,
createddt	TEXT,
updatedby	TEXT,
updateddt	TEXT,
status	TEXT
);
