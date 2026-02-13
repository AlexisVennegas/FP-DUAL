


1. Obtener todos los datos de todos los empleados.
-- 65-. Obten los empleados del departamento 10 que tienen el 
-- mismo empleo que alguien del departamento de Ventas. Desconocemos el c´odigo de dicho departamento.

SELECT * FROM emp 
WHERE deptno = 10
and job in (
    SELECT job FROM emp 
    WHERE deptno = (
        SELECT deptno FROM dept 
        WHERE dname = 'SALES'
    )
);

-- 66. Halla los empleados que tienen por lo menos un empleado a su mando, ordenados inversamente
-- por nombre.

SELECT * FROM emp e
JOIN dept d ON e.deptno = d.deptno;


-- 67. Obt´en informaci´on sobre los empleados que tienen el mismo trabajo que que alg´un empleado
-- que trabaje en Chicago.

SELECT * FROM emp e
join dept d ON e.deptno = d.deptno
where d.loc = 'CHICAGO';

select * from emp
where job in (
    select job from emp
    where deptno = (
        select deptno from dept
        where loc = 'CHICAGO'
    )
);


-- . ¿Qu´e empleos distintos encontramos en la empresa, y cu´antos empleados desempe˜nan cada uno
-- de ellos?

SELECT job, COUNT(1) AS num_empleados
FROM emp    
GROUP BY job;


-- 69. Halla la suma de salarios de cada departamento.

SELECT d.dname, SUM(e.sal) AS total_salario 
FROM emp e 
left JOIN dept d ON e.deptno = d.deptno 
GROUP BY d.dname;


-- 70 todos lso departamentos sin empleados

Select * from dept d
where d.deptno NOT IN (
    select e.deptno from emp e
);


-- 71. Halla los empleados que no tienen a otro empleado a sus ´ordenes.

select 



-- 75. Obt´en un listado en el que se reflejen los empleados y los nombres de sus jefes. En el listado
-- deben aparecer todos los empleados, aunque no tengan jefe, poniendo un nulo el nombre de ´este

select e.ename as empleado, j.ename as jefe
from emp e
left join emp j ON e.mgr = j.empno;


-- 76  Lista los empleados que tengan el mayor salario de su departamento
-- DESCRIPCIÓN:
-- Esta consulta obtiene el nombre del empleado, su salario y el nombre del departamento
-- para todos los empleados que tienen el salario máximo dentro de su respectivo departamento.
--
-- LÓGICA:
-- 1. Se realiza un JOIN entre la tabla 'emp' (empleados) y 'dept' (departamentos)
--    usando el número de departamento (deptno) como clave de unión.
-- 2. La cláusula WHERE filtra solo los empleados cuyo salario sea igual al máximo
--    salario del empleado en su propio departamento.
-- 3. La subconsulta SELECT MAX(sal) calcula dinámicamente el salario máximo
--    para cada departamento.
--
-- TABLAS UTILIZADAS:

USE testjoin;
SELECT e.ename, e.sal, d.dname
FROM emp e
JOIN dept d ON e.deptno = d.deptno
WHERE e.sal = (
    SELECT MAX(sal) FROM emp WHERE deptno = e.deptno
);



-- 77. Deseamos saber cu´antos empleados supervisa cada jefe. Para ello, obt´en un listado en el que
-- se reflejen el c´odigo y el nombre de cada jefe, junto al n´umero de empleados que supervisa
-- directamente. Como puede haber empleados sin jefe, para estos se indicar´a s´olo el n´umero de
-- ellos, y los valores restantes (c´odigo y nombre del jefe) se dejar´an como nulos.


    select j.empno as codigo, j.ename as nombre, COUNT(e.empno) as esclavos
    from emp e
    right join emp j ON e.mgr = j.empno
    GROUP BY j.empno, j.ename;


-- 78. Hallar el departamento cuya suma de salarios sea la m´as alta, mostrando esta suma de salarios
-- y el nombre del departamento


-- DESCRIPCIÓN: Consulta que calcula el salario total por departamento
-- PROPÓSITO: Obtener la suma de salarios agrupados por nombre de departamento
-- TABLAS UTILIZADAS:
--   - emp: Tabla de empleados (contiene sal y deptno)
--   - dept: Tabla de departamentos (contiene dname y deptno)
-- CAMPOS RETORNADOS:
--   - nombre_depart: Nombre del departamento (de la tabla dept)
--   - suma_sal: Suma total de salarios por departamento
-- LÓGICA:
--   1. Realiza un JOIN INNER entre emp y dept usando deptno como clave
--   2. Agrupa los resultados por nombre de departamento
--   3. Suma los salarios de todos los empleados en cada departamento
-- NOTAS: Requiere que existan registros en ambas tablas con deptno válido


select d.dname as nombre_depart, sum(e.sal) as suma_sal
from emp e
join dept d ON e.deptno = d.deptno
GROUP BY d.dname;