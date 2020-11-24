DROP DATABASE library;

CREATE DATABASE library;

USE library;

CREATE TABLE books(
        book_code INTEGER(15) NOT NULL UNIQUE AUTO_INCREMENT,
        title CHAR(45) NOT NULL,
        author CHAR(45) NOT NULL,
        year INTEGER(4) NOT NULL,
        publisher CHAR(45) NOT NULL,
        PRIMARY KEY (book_code)
        );


INSERT INTO books(title, author, year, publisher)  VALUES ("Cem Anos de Solidão", "Gabriel Marquez", 1965, "Ática");
INSERT INTO books(title, author, year, publisher)  VALUES ("Amor nos Tempos do Cólera ", "Gabriel Marquez", 1983, "Moderna");
INSERT INTO books(title, author, year, publisher)  VALUES ("Memória das MInhas Putas Tristes", "Gabriel Marquez", 1990, "Ática");
INSERT INTO books(title, author, year, publisher)  VALUES ("Cem Anos de Solidão", "Gabriel Marquez", 1991, "Ática");
INSERT INTO books(title, author, year, publisher)  VALUES ("Primo Basilio", "Eça de Queiroz", 1965, "Grupo Porto");
INSERT INTO books(title, author, year, publisher)  VALUES ("Guerra e Paz ", "Tolstoi", 1948, "Editor SA");
INSERT INTO books(title, author, year, publisher)  VALUES ("Elogio da Madrasta", "Mario Vargas Llosa", 1970, "Moderna");
INSERT INTO books(title, author, year, publisher)  VALUES ("Cem Anos de Solidão", "Gabriel Marquez", 1973, "Grupo Porto");
INSERT INTO books(title, author, year, publisher)  VALUES ("Travessuras da Menina Má", "Mario Vargas Llosa", 1940, "Editor SA");
INSERT INTO books(title, author, year, publisher)  VALUES ("Pantaleão e as Visitadoras", "Mario Vargas Llosa", 1993, "Moderna");
INSERT INTO books(title, author, year, publisher)  VALUES ("Os Cadernos de Dom Rigoberto", "Mario Vargas Llosa", 1985, "Ática");


CREATE TABLE users(
        nif INTEGER(10) NOT NULL UNIQUE,
        name CHAR(45) NOT NULL,
        phone INTEGER(10) NOT NULL UNIQUE,
        PRIMARY KEY (nif)
        );



INSERT INTO users(nif, name, phone) VALUES (947382910, "Giselle", 936271840);
INSERT INTO users(nif, name, phone) VALUES (947382050, "Elodie", 936273230);
INSERT INTO users(nif, name, phone) VALUES (947392013, "Erica", 93839840);
INSERT INTO users(nif, name, phone) VALUES (947373829, "Juliana", 918471840);
INSERT INTO users(nif, name, phone) VALUES (947558392, "Almeida", 902671840);
INSERT INTO users(nif, name, phone) VALUES (947329291, "Carlos", 993628140);
INSERT INTO users(nif, name, phone) VALUES (947339839, "Cassio", 904643940);

CREATE TABLE library_software(
        nif INTEGER(10) NOT NULL,
        book_code INTEGER (15) NOT NULL,
        loan DATE NOT NULL,
        return_back DATE,
        FOREIGN KEY (nif) REFERENCES users(nif),
        FOREIGN KEY (book_code) REFERENCES books(book_code)
        );


INSERT INTO library_software(nif, book_code, loan,  return_back) VALUES (947382910, 5, "2020-10-05", "2020-10-15");
INSERT INTO library_software(nif, book_code, loan, return_back) VALUES (947382050, 2, "2020-10-15", "2020-10-30");
INSERT INTO library_software(nif, book_code, loan, return_back) VALUES (947382910, 7, "2020-08-05", "2020-08-15");
INSERT INTO library_software(nif, book_code, loan) VALUES (947339839, 2, "2020-10-25");
INSERT INTO library_software(nif, book_code, loan) VALUES (947329291, 1, "2020-10-25");
INSERT INTO library_software(nif, book_code, loan) VALUES (947392013, 9, "2020-10-25");

