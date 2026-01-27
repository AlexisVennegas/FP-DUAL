


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

