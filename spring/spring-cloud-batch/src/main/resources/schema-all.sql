DROP TABLE furniture IF EXISTS;

CREATE TABLE furniture  (
    furniture_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    name VARCHAR(20),
    price VARCHAR(20)
);