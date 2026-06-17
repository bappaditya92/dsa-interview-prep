SELECT name,
       salary,
       salary - LAG(salary) OVER (ORDER BY salary) AS salary_diff
FROM employees;
