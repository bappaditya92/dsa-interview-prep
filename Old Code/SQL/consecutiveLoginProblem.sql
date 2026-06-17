SELECT DISTINCT user_id
FROM
(
SELECT
user_id,
login_date,
login_date - ROW_NUMBER() OVER (PARTITION BY user_id ORDER BY login_date) as grp
FROM Logins
) temp
GROUP BY user_id, grp
HAVING COUNT(*) >= 3;
