CREATE TABLE departments (
    dept_id INT,
    dept_name VARCHAR(50)
);

SELECT e.name, d.dept_name
FROM employees e
INNER JOIN departments d
ON e.department = d.dept_name;
