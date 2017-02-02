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
