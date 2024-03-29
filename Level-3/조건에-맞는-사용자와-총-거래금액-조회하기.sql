-- 코드를 입력하세요
SELECT u.USER_ID, u.NICKNAME, SUM(PRICE) AS TOTAL_SALES
FROM (
    SELECT WRITER_ID, PRICE
    FROM USED_GOODS_BOARD
    WHERE STATUS = 'DONE') AS b
    INNER JOIN USED_GOODS_USER AS u
    ON b.WRITER_ID = u.USER_ID
GROUP BY u.USER_ID
HAVING SUM(PRICE) >= 700000
ORDER BY TOTAL_SALES
