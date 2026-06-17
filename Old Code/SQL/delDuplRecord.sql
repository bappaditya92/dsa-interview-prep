DELETE FROM Employee
WHERE id NOT IN
(
SELECT MIN(id)
FROM Employee
GROUP BY name
);
