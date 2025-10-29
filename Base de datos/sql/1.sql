DROP DATABASE ongs;
CREATE DATABASE ongs;
USE ongs;
CREATE TABLE asociacion(
  cif CHAR(9) PRIMARY KEY,
  denominacion VARCHAR(200) NOT NULL,
  direccion VARCHAR(200) NOT NULL,
  provincia VARCHAR(11) NOT NULL,
  tipo VARCHAR(20) NOT NULL,
  utilidad VARCHAR(250)
);

create table socio(
	dni char(9),
	nombre varchar(20) NOT NULL,
	direccion varchar(200) NOT NULL,
	provincia varchar(11) NOT NULL ,
	fecha_alta date NOT NULL,
	cuota_mensual float(6,2) NOT NULL,
        aportacion_anual float(6,2) NOT NULL, 
	CONSTRAINT pk_socio primary key (dni)
);

CREATE TABLE trabajador(
	dni CHAR(9) PRIMARY KEY,
	nombre VARCHAR(20) NOT NULL,
	fecha_ingreso DATE NOT NULL
); 

create table asociacion_socio(
	dni char(9),
	cif char(9),
	primary key (dni,cif),
        CONSTRAINT fk_asoc_soc_socio FOREIGN KEY(dni) REFERENCES socio(dni),
        CONSTRAINT fk_asoc_soc_asociacion FOREIGN KEY(cif) REFERENCES asociacion(cif)
); 

CREATE TABLE proyecto(
cif CHAR(9),
numproyecto CHAR(10),
zona VARCHAR(30) NOT NULL,
objetivo VARCHAR(50) NOT NULL,
beneficiarios VARCHAR(50) NOT NULL,
cifsubproyecto CHAR(10) NOT NULL,
numsubproyecto CHAR(10) NOT NULL,
PRIMARY KEY (cif, numproyecto),
CONSTRAINT fk_proyecto_asoc FOREIGN KEY(cif) REFERENCES asociacion(cif),
CONSTRAINT fk_proyecto_subproy FOREIGN KEY(cifsubproyecto) REFERENCES proyecto(cif)
); 

CREATE TABLE voluntario(
  dni_tabla CHAR(10) PRIMARY KEY,
  edad INT(2) NOT NULL,
  profesión VARCHAR(200) NOT NULL,
  horas_trabajo INT(3) NOT NULL
); 

CREATE TABLE asalariado(
	dni_t char(9) PRIMARY KEY,
        sueldo float(6,2) NOT NULL,
        cargo enum('coordinador','director','manager','oficinista') NOT NULL,
	irpf float(6,2) NOT NULL,
	pago_ss float(6,2) NOT NULL
); 

create table trabajador_asociacion(
	cif CHAR(9),
	dni CHAR(9),
	primary key (cif,dni)
); 