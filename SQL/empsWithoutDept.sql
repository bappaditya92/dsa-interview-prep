SELECT e.*
FROM employees e
LEFT JOIN departments d
ON e.department_id = d.id
WHERE d.id IS NULL;
