-- создаём базу данных
DROP DATABASE IF EXISTS human_friends;
CREATE DATABASE human_friends;
USE human_friends;

-- создаем таблицу с cat
CREATE TABLE cat (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name_animal CHAR(30),
    birthdate DATE
);

-- создаем таблицу команд животных
CREATE TABLE commands (
	id INT PRIMARY KEY AUTO_INCREMENT,
    type_animal TEXT,
	id_animal INT,
    commands TEXT
);

-- напоняем таблицу cat данными
INSERT INTO cat (name_animal, birthdate) VALUES 
	('Whiskers', '2019-05-15'),
	('Smudge', '2020-02-20'),
    ('Oliver', '2020-06-30');

-- напоняем таблицу команд данными по cat
INSERT INTO commands (type_animal, id_animal, commands) VALUES
	('cat', (SELECT id FROM cat WHERE name_animal = 'Whiskers' AND birthdate = '2019-05-15'), 'Sit'),
	('cat', (SELECT id FROM cat WHERE name_animal = 'Whiskers' AND birthdate = '2019-05-15'), 'Pounce'),
	('cat', (SELECT id FROM cat WHERE name_animal = 'Smudge' AND birthdate = '2020-02-20'), 'Sit'),
	('cat', (SELECT id FROM cat WHERE name_animal = 'Smudge' AND birthdate = '2020-02-20'), 'Pounce'),
	('cat', (SELECT id FROM cat WHERE name_animal = 'Smudge' AND birthdate = '2020-02-20'), 'Scratch'),
	('cat', (SELECT id FROM cat WHERE name_animal = 'Oliver' AND birthdate = '2020-06-30'), 'Meow'),
	('cat', (SELECT id FROM cat WHERE name_animal = 'Oliver' AND birthdate = '2020-06-30'), 'Scratch'),
	('cat', (SELECT id FROM cat WHERE name_animal = 'Oliver' AND birthdate = '2020-06-30'), 'Jump');

-- создаем таблицу с dog
CREATE TABLE dog (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name_animal CHAR(30),
    birthdate DATE
);

-- напоняем таблицу dog данными
INSERT INTO dog (name_animal, birthdate) VALUES 
	('Fido', '2020-01-01'),
	('Buddy', '2018-12-10'),
    ('Bella', '2019-11-11');

-- напоняем таблицу команд данными по dog
INSERT INTO commands (type_animal, id_animal, commands) VALUES
	('dog', (SELECT id FROM dog WHERE name_animal = 'Fido' AND birthdate = '2020-01-01'), 'Sit'),
	('dog', (SELECT id FROM dog WHERE name_animal = 'Fido' AND birthdate = '2020-01-01'), 'Stay'),
	('dog', (SELECT id FROM dog WHERE name_animal = 'Fido' AND birthdate = '2020-01-01'), 'Fetch'),
	('dog', (SELECT id FROM dog WHERE name_animal = 'Buddy' AND birthdate = '2018-12-10'), 'Sit'),
	('dog', (SELECT id FROM dog WHERE name_animal = 'Buddy' AND birthdate = '2018-12-10'), 'Paw'),
	('dog', (SELECT id FROM dog WHERE name_animal = 'Buddy' AND birthdate = '2018-12-10'), 'Bark'),
	('dog', (SELECT id FROM dog WHERE name_animal = 'Bella' AND birthdate = '2019-11-11'), 'Sit'),
	('dog', (SELECT id FROM dog WHERE name_animal = 'Bella' AND birthdate = '2019-11-11'), 'Stay'),
	('dog', (SELECT id FROM dog WHERE name_animal = 'Bella' AND birthdate = '2019-11-11'), 'Roll');
    
-- создаем таблицу с hamster
CREATE TABLE hamster (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name_animal CHAR(30),
    birthdate DATE
);

-- напоняем таблицу hamster данными
INSERT INTO hamster (name_animal, birthdate) VALUES 
	('Hammy', '2021-03-10'),
	('Peanut', '2021-08-01');
    
-- напоняем таблицу команд данными по hamster
INSERT INTO commands (type_animal, id_animal, commands) VALUES
	('hamster', (SELECT id FROM hamster WHERE name_animal = 'Hammy' AND birthdate = '2021-03-10'), 'Roll'),
	('hamster', (SELECT id FROM hamster WHERE name_animal = 'Hammy' AND birthdate = '2021-03-10'), 'Hide'),
	('hamster', (SELECT id FROM hamster WHERE name_animal = 'Peanut' AND birthdate = '2021-08-01'), 'Roll'),
	('hamster', (SELECT id FROM hamster WHERE name_animal = 'Peanut' AND birthdate = '2021-08-01'), 'Spin');

-- объединяем домашних животных в таблицу pets согласно диаграмме
CREATE TABLE pets (
	id INT PRIMARY KEY AUTO_INCREMENT,
	id_animal INT,
    type_animal TEXT,
	name_animal CHAR(30),
    birthdate DATE
);
INSERT INTO pets (id_animal, type_animal, name_animal, birthdate)
SELECT id, 'cat', name_animal, birthdate FROM cat
UNION
SELECT id, 'dog', name_animal, birthdate FROM dog
UNION
SELECT id, 'hamster', name_animal, birthdate FROM hamster;

-- создаем таблицу с horse
CREATE TABLE horse (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name_animal CHAR(30),
    birthdate DATE
);

-- напоняем таблицу horse данными
INSERT INTO horse (name_animal, birthdate) VALUES 
	('Thunder', '2015-07-21'),
	('Storm', '2014-05-05'),
    ('Blaze', '2016-02-29');

-- напоняем таблицу команд данными по horse
INSERT INTO commands (type_animal, id_animal, commands) VALUES
	('horse', (SELECT id FROM horse WHERE name_animal = 'Thunder' AND birthdate = '2015-07-21'), 'Trot'),
	('horse', (SELECT id FROM horse WHERE name_animal = 'Thunder' AND birthdate = '2015-07-21'), 'Canter'),
	('horse', (SELECT id FROM horse WHERE name_animal = 'Thunder' AND birthdate = '2015-07-21'), 'Gallop'),
	('horse', (SELECT id FROM horse WHERE name_animal = 'Storm' AND birthdate = '2014-05-05'), 'Trot'),
	('horse', (SELECT id FROM horse WHERE name_animal = 'Storm' AND birthdate = '2014-05-05'), 'Canter'),
	('horse', (SELECT id FROM horse WHERE name_animal = 'Blaze' AND birthdate = '2016-02-29'), 'Trot'),
	('horse', (SELECT id FROM horse WHERE name_animal = 'Blaze' AND birthdate = '2016-02-29'), 'Jump'),
	('horse', (SELECT id FROM horse WHERE name_animal = 'Blaze' AND birthdate = '2016-02-29'), 'Gallop');

-- создаем таблицу с camel
CREATE TABLE camel (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name_animal CHAR(30),
    birthdate DATE
);

-- напоняем таблицу camel данными
INSERT INTO camel (name_animal, birthdate) VALUES 
	('Sandy', '2016-11-03'),
	('Dune', '2018-12-12'),
    ('Sahara', '2015-08-14');
    
-- напоняем таблицу команд данными по camel
INSERT INTO commands (type_animal, id_animal, commands) VALUES
	('camel', (SELECT id FROM camel WHERE name_animal = 'Sandy' AND birthdate = '2016-11-03'), 'Walk'),    
	('camel', (SELECT id FROM camel WHERE name_animal = 'Sandy' AND birthdate = '2016-11-03'), 'Carry Load'),    
	('camel', (SELECT id FROM camel WHERE name_animal = 'Dune' AND birthdate = '2018-12-12'), 'Walk'),    
	('camel', (SELECT id FROM camel WHERE name_animal = 'Dune' AND birthdate = '2018-12-12'), 'Sit'),    
	('camel', (SELECT id FROM camel WHERE name_animal = 'Sahara' AND birthdate = '2015-08-14'), 'Walk'),    
	('camel', (SELECT id FROM camel WHERE name_animal = 'Sahara' AND birthdate = '2015-08-14'), 'Run');
    
-- создаем таблицу с donkey
CREATE TABLE donkey (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name_animal CHAR(30),
    birthdate DATE
);

-- напоняем таблицу donkey данными
INSERT INTO donkey (name_animal, birthdate) VALUES 
	('Eeyore', '2017-09-18'),
	('Burro', '2019-01-23'),
	('Young Bruno', '2021-01-01');

-- напоняем таблицу команд данными по donkey
INSERT INTO commands (type_animal, id_animal, commands) VALUES
	('donkey', (SELECT id FROM donkey WHERE name_animal = 'Eeyore' AND birthdate = '2017-09-18'), 'Walk'),    
	('donkey', (SELECT id FROM donkey WHERE name_animal = 'Eeyore' AND birthdate = '2017-09-18'), 'Carry Load'),    
	('donkey', (SELECT id FROM donkey WHERE name_animal = 'Eeyore' AND birthdate = '2017-09-18'), 'Bray'),    
	('donkey', (SELECT id FROM donkey WHERE name_animal = 'Burro' AND birthdate = '2019-01-23'), 'Walk'),
	('donkey', (SELECT id FROM donkey WHERE name_animal = 'Burro' AND birthdate = '2019-01-23'), 'Bray'),
	('donkey', (SELECT id FROM donkey WHERE name_animal = 'Burro' AND birthdate = '2019-01-23'), 'Kick'),
	('donkey', (SELECT id FROM donkey WHERE name_animal = 'Young Bruno' AND birthdate = '2021-01-01'), 'Walk');

-- объединяем вьючных животных в таблицу pack_animals согласно диаграмме
CREATE TABLE pack_animals (
	id INT PRIMARY KEY AUTO_INCREMENT,
	id_animal INT,
    type_animal TEXT,
	name_animal CHAR(30),
    birthdate DATE
);
INSERT INTO pack_animals (id_animal, type_animal, name_animal, birthdate)
SELECT id, 'horse', name_animal, birthdate FROM horse
UNION
SELECT id, 'camel', name_animal, birthdate FROM camel
UNION
SELECT id, 'donkey', name_animal, birthdate FROM donkey;

-- удалить записи о верблюдах
TRUNCATE camel;
DELETE FROM pack_animals WHERE type_animal = 'camel' AND id;

-- объединить таблицы лошадей и ослов
INSERT INTO horse (name_animal, birthdate) SELECT name_animal, birthdate FROM donkey;
DROP TABLE donkey;
RENAME TABLE horse TO horse_donkey; 
DROP TABLE horse_donkey; -- таблица horse_donkey идентична таблице pack_animals, дубликат удаляется.

-- создать новую таблицу для животных в возрасте от 1 до 3 лет и вычислить их возраст с точностью до месяца.
CREATE TABLE animals_from_1_3_years (
	id INT PRIMARY KEY AUTO_INCREMENT,
    type_animal TEXT,
	name_animal CHAR(30),
    birthdate DATE,
    animal_age TEXT
);
DELIMITER //
CREATE FUNCTION animal_age (birthdate DATE)
RETURNS TEXT 
DETERMINISTIC
BEGIN
	RETURN CONCAT(TIMESTAMPDIFF(YEAR, birthdate, NOW()), ' years ', TIMESTAMPDIFF(MONTH, birthdate, NOW())%12,' month');
END //
DELIMITER ;
INSERT INTO animals_from_1_3_years (type_animal, name_animal, birthdate, animal_age)
SELECT type_animal, name_animal, birthdate, animal_age(birthdate)
FROM pets WHERE TIMESTAMPDIFF(YEAR, birthdate, NOW()) BETWEEN 1 AND 3
UNION
SELECT type_animal, name_animal, birthdate, animal_age(birthdate)
FROM pack_animals
WHERE TIMESTAMPDIFF(YEAR, birthdate, NOW()) BETWEEN 1 AND 3;

-- объединить все созданные таблицы в одну, сохраняя информацию о принадлежности к исходным таблицам
CREATE TABLE animals (
	id INT PRIMARY KEY AUTO_INCREMENT,
    name_table TEXT,
    type_animal TEXT,
	name_animal CHAR(30),
    birthdate DATE,
    animal_age TEXT,
    commands TEXT
);
INSERT INTO animals (name_table, type_animal, name_animal, birthdate, animal_age, commands)
SELECT "pets", type_animal, name_animal, birthdate, animal_age(birthdate), 
	(SELECT GROUP_CONCAT(commands) FROM commands CM WHERE CM.type_animal = PT.type_animal AND CM.id_animal = PT.id_animal GROUP BY id_animal)
FROM pets PT
UNION
SELECT "pack_animals", type_animal, name_animal, birthdate, animal_age(birthdate), 
	(SELECT GROUP_CONCAT(commands) FROM commands CM WHERE CM.type_animal = PA.type_animal AND CM.id_animal = PA.id_animal GROUP BY id_animal)
FROM pack_animals PA;
