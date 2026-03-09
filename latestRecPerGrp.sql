SELECT *
FROM (
    SELECT *,
           ROW_NUMBER() OVER (
           PARTITION BY customer_id 
           ORDER BY order_date DESC) AS rn
    FROM orders
) t
WHERE rn = 1;
