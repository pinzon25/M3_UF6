DROP DATABASE IF EXISTS Cotxes;
CREATE DATABASE Cotxes;

USE Cotxes;

/*DROP USER 'Ricard'@'localhost';
CREATE USER 'Ricard'@'localhost' IDENTIFIED BY '1234';
*/

DROP TABLE IF EXISTS Cotxe;
CREATE TABLE cotxe(
Model VARCHAR(50),
Potencia_motor INTEGER(4),
Acceleracio_cent FLOAT,
Origen_europeu BOOLEAN,
Data_fabricacio DATE
);

INSERT INTO Cotxe VALUES('Subaru impreza GT Turbo', 218, 6.3, false, '1993-3-21');
INSERT INTO Cotxe VALUES('Mitsubishi Lancer EVO 8', 230, 6.1, false, '2005-3-3');

#select * from Cotxe;