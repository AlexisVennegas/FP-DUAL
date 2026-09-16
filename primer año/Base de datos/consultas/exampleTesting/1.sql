CREATE TABLE empleados (
 id INT PRIMARY KEY AUTO_INCREMENT,
 nombre VARCHAR(50),
 salario DECIMAL(10,2),
 departamento_id INT
);

-- 1. Cambia el tipo de salario usando la tabla empleadosa DECIMAL(12,2) y hazlo NOT NULL con valor por
-- defecto 0

use testing2
ALTER TABLE `empleados`
CHANGE COLUMN `salario` `salario` DECIMAL(12,2) NOT NULL DEFAULT 0 AFTER `nombre`;

select * from empleados;

-- 2. Añade una columna fecha_contratacion con valor por defecto la fecha actual.
ALTER TABLE `empleados`
ADD COLUMN `fecha_contratacion` DATE NOT NULL DEFAULT CURRENT_DATE AFTER `salario`;