SELECT r.REST_ID,
       r.REST_NAME,
       r.FOOD_TYPE,
       r.FAVORITES,
       r.ADDRESS,
       ROUND(
               AVG(rr.REVIEW_SCORE), 2
       ) AS SCORE
FROM REST_INFO r
         JOIN
     REST_REVIEW rr
     ON
         r.REST_ID = rr.REST_ID
WHERE r.ADDRESS LIKE '서울%'
GROUP BY r.REST_ID
ORDER BY SCORE DESC, r.FAVORITES DESC;
