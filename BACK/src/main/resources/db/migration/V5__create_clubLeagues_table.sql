CREATE TABLE clubLeagues(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    season VARCHAR(255) NOT NULL,
    club_id BIGINT,
    league_id BIGINT,
    CONSTRAINT fk_clubLeagues_club FOREIGN KEY(club_id) REFERENCES clubs(id),
    CONSTRAINT fk_clubLeagues_league FOREIGN KEY(league_id) REFERENCES leagues(id),

);