
create table IF NOT EXISTS user_t  (
	userid integer primary key auto_increment,
	username varchar(50),
	userrole varchar(50),
	pass varchar(50)
);

