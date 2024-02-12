-- JOIN : SELECT와 조합되어 사용되는 쿼리문
-- -> 서로 다른 테이블을 엮어서 필요한 쿼리결과가 나오도록 도와줌
-- -> 스키마를 통해 조합이 가능한지를 체크해줘야 함

-- JOIN을 그냥 쓰면 INNER JOIN으로 작동함

-- 1) INNER JOIN : 필드가 null인 경우 보여주지 않음
SELECT r.region_name, c.country_name
FROM regions r INNER JOIN countries c ON r.region_id = c.region_id;
-- 2) LEFT JOIN : 붙여주는 테이블에 레코드가 없으면 null로 채워줌
SELECT r.region_name, c.country_name
FROM regions r LEFT JOIN countries c ON r.region_id = c.region_id;
-- 3) RIGHT JOIN : 기준 테이블에 레코드가 없으면 null로 채워줌
SELECT r.region_name, c.country_name
FROM regions r RIGHT JOIN countries c ON r.region_id = c.region_id;
-- 4) FULL OUTER JOIN : 일치하지 않는 것들도 모두 null로 채워줌
SELECT r.region_name, c.country_name
FROM regions r FULL OUTER JOIN countries c ON r.region_id = c.region_id;
