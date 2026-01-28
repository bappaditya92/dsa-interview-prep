SELECT month, user_id, total_amount
FROM (
  SELECT
    DATE_FORMAT(order_date, '%Y-%m') AS month,
    user_id,
    SUM(amount) AS total_amount,
    RANK() OVER (
      PARTITION BY DATE_FORMAT(order_date, '%Y-%m')
      ORDER BY SUM(amount) DESC
    ) AS rnk
  FROM orders
  GROUP BY month, user_id
) t
WHERE rnk = 1;
