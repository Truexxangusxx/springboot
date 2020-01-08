DROP TABLE IF EXISTS coin;
/*CREATE TABLE IF NOT EXISTS coin(id SERIAL, name VARCHAR(255), value VARCHAR(255));*/
CREATE TABLE coin(id SERIAL, name VARCHAR(255), value VARCHAR(255));
INSERT INTO coin(name , value) VALUES('Dolar','3.45');
INSERT INTO coin(name , value) VALUES('Nuevo sol','1');
INSERT INTO coin(name , value) VALUES('Euro','4.2');
INSERT INTO coin(name , value) VALUES('Peso','0.65');
INSERT INTO coin(name , value) VALUES('Libra','2.4');