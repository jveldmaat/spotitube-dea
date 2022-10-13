insert into users(username, [password]) values('jesse', '123')
go

insert into users(username,password) values('jordan','1234')
go

insert into playlists(name, owner) values('test1', 'jesse'), ('test2', 'jesse'),('dikke herrie', 'jordan')
go


/* song */
insert into tracks(performer, titel, url, afspeelduur, album) values('Vulfpeck','Cory Wong','https://open.spotify.com/track/1L9qsoNnyT3r8fgr2Pr7Ty?si=1c3ccde8721b4eae',246,'the beautiful game')
insert into tracks(performer, titel, url, afspeelduur, album) values('Vulfpeck','Dean Town','https://open.spotify.com/track/1oOD1pV43cV9sHg97aBdLs?si=46bc2d47e6074d78',213,'the beautiful game')
insert into tracks(performer, titel, url, afspeelduur, album) values('Noisia','Nova','https://open.spotify.com/track/68TL2jafwq6hwl6ExBY6JK?si=c13a40e45e3e4ce2',276,'closer')
go


/* video */
insert into tracks(performer, titel, url, afspeelduur, publicatiedatum, beschrijving) values('Marc Rebillet','Your New Morning Alarm','https://www.youtube.com/watch?v=enYdAxVcNZA',57,'2021-4-1','Je nieuwe ochtend alarm!')
go

/* track in playlist */
insert into track_in_playlists values (1,2,0)
insert into track_in_playlists values (2,2,1)
insert into track_in_playlists values (1,1,1)
insert into track_in_playlists values (1,3,1)
insert into track_in_playlists values (3,2,0)
insert into track_in_playlists values (3,1,0)
go

select * from playlists p inner join track_in_playlists tip on p.id = tip.playlistsid inner join tracks t on tip.trackid = t.id
go

select * from tracks
select * from playlists
select * from track_in_playlists
select * from users
where id not in (select id from tracks t inner join track_in_playlists tip on t.id = tip.trackid where playlistsid = 1)