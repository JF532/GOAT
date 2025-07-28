CREATE TABLE players (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL, 
    social_name VARCHAR(255),    
    date_birth DATE,            
    age INT,                     
    preferred_foot VARCHAR(50),  
    height VARCHAR(10),          
    market_value DECIMAL(18,2) NOT NULL CHECK(market_value >= 0), 
    photo_url VARCHAR(255), 
    nationality_id BIGINT,     
    primary_position_id BIGINT,  
    club_id BIGINT,            
    CONSTRAINT fk_player_country FOREIGN KEY(nationality_id) REFERENCES countries(id),
    CONSTRAINT fk_player_position FOREIGN KEY(primary_position_id) REFERENCES positions(id),
    CONSTRAINT fk_player_club FOREIGN KEY(club_id) REFERENCES clubs(id)
);