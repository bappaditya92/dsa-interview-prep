SELECT *, COUNT(*)
FROM users
GROUP BY name, email, age
HAVING COUNT(*) > 1;
