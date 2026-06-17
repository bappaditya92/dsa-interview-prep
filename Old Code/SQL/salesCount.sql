SELECT sale_date, COUNT(*) AS sales_count 
FROM Sales 
GROUP BY sale_date 
ORDER BY sale_date;
