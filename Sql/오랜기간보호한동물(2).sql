SELECT i.ANIMAL_ID, i.NAME
FROM ANIMAL_INS i
JOIN ANIMAL_OUTS o
ON i.ANIMAL_ID = o.ANIMAL_ID
WHERE o.DATETIME IS NOT NULL
ORDER BY (o.DATETIME - i.DATETIME) desc limit 2