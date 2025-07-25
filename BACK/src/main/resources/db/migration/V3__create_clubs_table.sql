CREATE TABLE clubs(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	legal_name VARCHAR(250) NOT NULL UNIQUE,
	trade_name VARCHAR(250) NOT NULL UNIQUE,
	logo_image_url VARCHAR(250),
	market_value DECIMAL(12,2) NOT NULL CHECK(market_value >0),
	squad_size INT CHECK(squad_size >= 0),
	manager VARCHAR(250),
	stadium_id BIGINT,
	country_id BIGINT,
	foundation_date DATE,
	
	CONSTRAINT fk_club_stadium FOREIGN KEY(stadium_id) REFERENCES stadiums(id),
	CONSTRAINT fk_club_country FOREIGN KEY(country_id) REFERENCES countries(id)
);