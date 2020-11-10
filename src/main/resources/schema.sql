DROP TABLE IF EXISTS securities;

CREATE TABLE securities (
    id BIGINT AUTO_INCREMENT primary key,
    date DATE not null,
    name VARCHAR(100) not null,
    cost INT not null
);

INSERT INTO securities (id, date, name, cost) VALUES ( 0, '2020-11-1', 'Gazprom', 10000 );
INSERT INTO securities (date, name, cost) VALUES ( '2020-11-2', 'Avtovaz', 7000 );
INSERT INTO securities (date, name, cost) VALUES ( '2020-11-3', 'Sberbank', 8000 );
INSERT INTO securities (date, name, cost) VALUES ( '2020-11-3', 'Gazprom', 11000 );
INSERT INTO securities (date, name, cost) VALUES ( '2020-11-4', 'Avtovaz', 6500 );
INSERT INTO securities (date, name, cost) VALUES ( '2020-11-5', 'Sberbank', 9000 );
INSERT INTO securities (date, name, cost) VALUES ( '2020-11-7', 'Gazprom', 8750 );
