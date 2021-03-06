CREATE TABLE users (
    id serial,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    enabled boolean default true,
    PRIMARY KEY (username)
);

CREATE TABLE authorities (
    id serial,
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES users(username)
);