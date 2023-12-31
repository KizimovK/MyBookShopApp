DROP TABLE IF EXISTS books;

CREATE TABLE  books(
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       author_id BIGINT NOT NULL,
                       title VARCHAR(250) NOT NULL,
                       price_old INTEGER DEFAULT NULL,
                       price INTEGER DEFAULT NULL
);

DROP TABLE IF EXISTS authors;

CREATE TABLE  authors(
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL
);