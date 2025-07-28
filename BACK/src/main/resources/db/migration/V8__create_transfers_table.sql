CREATE TABLE transfers (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    player_id BIGINT NOT NULL,          
    origin_club_id BIGINT,             
    destiny_club_id BIGINT,            
    transfer_date DATE NOT NULL,       
    transfer_type VARCHAR(255) NOT NULL,
    transfer_amount DOUBLE PRECISION NOT NULL CHECK(transfer_amount >= 0), 
    CONSTRAINT fk_transfer_player FOREIGN KEY(player_id) REFERENCES players(id),
    CONSTRAINT fk_transfer_origin_club FOREIGN KEY(origin_club_id) REFERENCES clubs(id),
    CONSTRAINT fk_transfer_destiny_club FOREIGN KEY(destiny_club_id) REFERENCES clubs(id)
);