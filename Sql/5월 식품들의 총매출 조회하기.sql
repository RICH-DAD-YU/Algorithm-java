SELECT p.PRODUCT_ID, p.PRODUCT_NAME, (SUM(o.AMOUNT) * p.PRICE) AS 'TOTAL_SALES'
FROM FOOD_PRODUCT p
JOIN FOOD_ORDER o
ON p.PRODUCT_ID = o.PRODUCT_ID
WHERE YEAR(o.PRODUCE_DATE) = 2022 AND MONTH(o.PRODUCE_DATE) = 5
GROUP BY p.PRODUCT_NAME
ORDER BY TOTAL_SALES desc, p.PRODUCT_ID