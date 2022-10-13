CREATE TABLE users (
	username				varchar(32)						PRIMARY KEY,
	password				varchar(max)						not null,
	token					NUMERIC(8,0)							null,

);
go

CREATE TABLE playlists (
	id						int				identity(1,1)		not null,
	name					varchar(max)						not null,
	owner					varchar(32)							not null,

	CONSTRAINT PK_ID PRIMARY KEY(id),
	CONSTRAINT FK_PLAYLISTS_REF_USERS FOREIGN KEY (owner)
	REFERENCES users(username)
);
go

CREATE TABLE tracks (
	id						int				identity(1,1)		not null,
	performer				varchar(50)							not null,
	titel					varchar(50)							not null,
	url						varchar(200)						not null,
	afspeelduur				int									not null,
	album					varchar(50)								null,
	publicatiedatum			date									null,
	beschrijving			varchar(50)								null,

	CONSTRAINT PK_TRACKSID PRIMARY KEY(id),
)


CREATE TABLE track_in_playlists (
	playlistsid				int									not null,
	trackid					int									not null,
	offlineavailable		bit									not null,

	CONSTRAINT PK_TRACKID_AND_PLAYLISTSID primary key(playlistsid,trackid),
	CONSTRAINT FK_TIP_REF_PLAYLISTS FOREIGN KEY (playlistsid)
	REFERENCES playlists (id),
	CONSTRAINT FK_TIP_REF_TRACKS FOREIGN KEY (trackid)
	REFERENCES tracks (id)
)
GO

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