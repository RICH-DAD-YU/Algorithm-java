SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, IF(FREEZER_YN IS NULL, 'N', FREEZER_YN) AS 'FREEZER_YN'
FROM FOOD_WAREHOUSE
WHERE substring(ADDRESS, 1, 3) = '경기도'
ORDER BY WAREHOUSE_ID;