DROP TABLE IF EXISTS securities;

CREATE TABLE securities (
    id BIGINT AUTO_INCREMENT primary key,
    date DATE not null,
    name VARCHAR(100) not null,
    cost INT not null
);
