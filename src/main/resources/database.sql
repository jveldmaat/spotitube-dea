CREATE TABLE users (
	username	varchar(32)						PRIMARY KEY,
	password	varchar(max)						not null,
	token		NUMERIC(8,0)							null,

);
go

CREATE TABLE playlists (
	id			int				identity(1,1)		not null,
	name		varchar(max)						not null,
	owner		varchar(32)									not null,

	CONSTRAINT PK_ID PRIMARY KEY(id),
	CONSTRAINT FK_PLAYLISTS_REF_USERS FOREIGN KEY (owner)
	REFERENCES users(username)
);
go


CREATE OR ALTER TRIGGER Random_Eight_Digit ON dbo.users
AFTER INSERT
AS
BEGIN
DECLARE @inserted_id varchar(max)
select @inserted_id = username from inserted

UPDATE users
SET token = LEFT(FLOOR(RAND()*1000000),8)
WHERE users.username = @inserted_id

END
go