SELECT user_id
FROM orders
GROUP BY user_id
HAVING COUNT(DISTINCT DATE_FORMAT(order_date, '%Y-%m')) > 1;
