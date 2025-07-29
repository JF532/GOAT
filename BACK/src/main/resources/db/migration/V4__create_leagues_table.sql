CREATE TABLE leagues(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(250)  NOT NULL,
    type VARCHAR(250)  NOT NULL,
    logo_url VARCHAR(250),
    division VARCHAR(250),
    club_id BIGINT,
    CONSTRAINT fk_league_club FOREIGN KEY(club_id) REFERENCES clubs(id)
);