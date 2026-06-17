SELECT e.name AS Employee
FROM Employee e
JOIN Employee m
ON e.manager_id = m.id
WHERE e.salary > m.salary;
