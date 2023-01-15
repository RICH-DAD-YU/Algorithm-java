SELECT ORDER_ID, PRODUCT_ID, DATE_FORMAT(OUT_DATE, "%Y-%m-%d") AS "OUT_DATE",
        CASE WHEN substring(OUT_DATE, 1, 10) <= "2022-05-01" THEN "출고완료"
             WHEN substring(OUT_DATE, 1, 10) > "2022-05-01" THEN "출고대기"
             WHEN substring(OUT_DATE, 1, 10) IS NULL THEN "출고미정"
             END AS "출고여부"
FROM FOOD_ORDER
ORDER BY ORDER_ID