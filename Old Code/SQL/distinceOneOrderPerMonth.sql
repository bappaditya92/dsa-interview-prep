SELECT
  DATE_FORMAT(order_date, '%Y-%m') AS month,
  COUNT(DISTINCT user_id) AS monthly_active_users
FROM orders
GROUP BY month
ORDER BY month;
