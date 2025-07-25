CREATE TABLE stadiums(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(250) NOT NULL UNIQUE,
	capacity INT NOT NULL CHECK(capacity > 0),
	city VARCHAR(250) NOT NULL,
	country_id BIGINT NOT NULL,
	
	CONSTRAINT fk_stadium_country FOREIGN KEY(country_id) REFERENCES countries(id)
	
);