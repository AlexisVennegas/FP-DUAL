-- vamos a crear una scrip 

DROP DATABASE IF EXISTS ongs;

CREATE DATABASE ongs;

USE ongs;

CREATE TABLE asociacion (
    cif char(9),
    denominacion varchar(20), 
    direccion varchar(100),
    provincia varchar(20),
    tipo varchar(10),
    utilidad boolean;
);


