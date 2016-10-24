drop table if exists Experiences;
CREATE TABLE Experiences(Id SERIAL PRIMARY KEY, workplace VARCHAR(64) NOT NULL, title VARCHAR(64) NOT NULL, responsibilities VARCHAR(255), duration VARCHAR(255));
