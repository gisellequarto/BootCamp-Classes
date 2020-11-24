CREATE DATABASE boat_booking;

USE boat_booking;

CREATE TABLE sailors(
	id INTEGER AUTO_INCREMENT NOT NULL UNIQUE,
	name CHAR(15) NOT NULL,
       	age INTEGER NOT NULL
	);


INSERT INTO sailors(name, age) VALUES ("Edgar", 28);
INSERT INTO sailors(name, age) VALUES ("João", 30);
INSERT INTO sailors(name, age) VALUES ("Elói", 26);
INSERT INTO sailors(name, age) VALUES ("Hugo", 41);
INSERT INTO sailors(name, age) VALUES ("Castro", 45);
INSERT INTO sailors(name, age) VALUES ("Giselle", 37);
INSERT INTO sailors(name, age) VALUES ("Elodie", 32);
INSERT INTO sailors(name, age) VALUES ("Marco", 32);
INSERT INTO sailors(name, age) VALUES ("Erica", 29);
INSERT INTO sailors(name, age) VALUES ("Juliana", 25);
INSERT INTO sailors(name, age) VALUES ("Carlos", 43);
INSERT INTO sailors(name, age) VALUES ("Almeida", 30);
INSERT INTO sailors(name, age) VALUES ("Luis", 31);
INSERT INTO sailors(name, age) VALUES ("Cassio", 30);
INSERT INTO sailors(name, age) VALUES ("Andre", 26);
INSERT INTO sailors(name, age) VALUES ("Diogo", 28);
INSERT INTO sailors(name, age) VALUES ("Gaspar", 30);
INSERT INTO sailors(name, age) VALUES ("Bruno", 38);
INSERT INTO sailors(name, age) VALUES ("Tiago", 18);


CREATE TABLE boats(
	id INTEGER AUTO_INCREMENT NOT NULL UNIQUE,
	name CHAR(15) NOT NULL,
       	color CHAR(15)  NOT NULL
	);

INSERT INTO boats(name, color) VALUES ("Moliceiro", "blue");
INSERT INTO boats(name, color) VALUES ("Mermaid", "black");
INSERT INTO boats(name, color) VALUES ("Barracuda", "white");
INSERT INTO boats(name, color) VALUES ("Albatroz", "yellow");
INSERT INTO boats(name, color) VALUES ("Ocean", "dark blue");
INSERT INTO boats(name, color) VALUES ("Atlantis", "blue and white");
INSERT INTO boats(name, color) VALUES ("Good Weather", "gray");
INSERT INTO boats(name, color) VALUES ("Neptuno", "pink");
INSERT INTO boats(name, color) VALUES ("Crazy Crab", "red and blue");
INSERT INTO boats(name, color) VALUES ("Seal", "dark gray");
INSERT INTO boats(name, color) VALUES ("Sea Wolf", "black and white");
INSERT INTO boats(name, color) VALUES ("Good Wind", "yellow and blue");
INSERT INTO boats(name, color) VALUES ("Sea Spirit", "gray and blue");
INSERT INTO boats(name, color) VALUES ("Nina", "orange");
INSERT INTO boats(name, color) VALUES ("Pinta", "blue");
INSERT INTO boats(name, color) VALUES ("Santa Maria", "red");


