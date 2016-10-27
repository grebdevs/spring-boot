drop table if exists personal_info_favorite_teams;
drop table if exists personal_info;
drop table if exists team;

drop table if exists experience;
CREATE TABLE Experience(id SERIAL PRIMARY KEY, workplace VARCHAR(64) NOT NULL, title VARCHAR(64) NOT NULL, responsibilities VARCHAR(255), duration VARCHAR(255));

