-- 실습 : COUNTRIES 테이블에 대한 쿼리문을 작성하세요.
-- 1) INSERT 쿼리문으로  테이블에 아래의 레코드들을 추가하세요.
-- (1) 'ZA','ZA111',1
-- (2) 'ZB','ZA123',2
-- (3) 'ZC','ZA213',3
-- (4) 'ZD','ZA231',4
-- (5) 'ZE','ZA312',3
-- (6) 'ZF','ZA321',2
-- (7) 'ZG','ZA111',1
-- 너무 길면 ;으로 끝나니 적절한 줄바꿈도 좋습니다.
INSERT INTO countries(country_id, country_name, region_id) VALUES ('ZA', 'ZA111', 1);
INSERT INTO countries(country_id, country_name, region_id) VALUES ('ZB', 'ZA123', 2);
INSERT INTO countries(country_id, country_name, region_id) VALUES ('ZC', 'ZA213', 3);
INSERT INTO countries(country_id, country_name, region_id) VALUES ('ZD', 'ZA231', 4);
INSERT INTO countries(country_id, country_name, region_id) VALUES ('ZE', 'ZA312', 3);
INSERT INTO countries(country_id, country_name, region_id) VALUES ('ZF', 'ZA321', 2);
INSERT INTO countries(country_id, country_name, region_id) VALUES ('ZG', 'ZA111', 1);
SELECT * FROM countries;

-- 2) DELETE 쿼리문으로 지정한 레코드를 찾아 삭제하는 쿼리문을
--    작성하세요
-- (1) country_id가 'ZG' 이거나 'ZA'인 레코드를 제거하는 쿼리문
-- 팁 : PK, UK일 경우 AND를 걸 수 없음
DELETE FROM countries WHERE country_id = 'ZG' OR country_id = 'ZA';
SELECT * FROM countries;

-- (2) country_name이 'ZA123' 이거나 'ZA321'인 레코드를 제거하는 쿼리문
DELETE FROM countries WHERE country_name = 'ZA123' OR country_name = 'ZA321';
SELECT * FROM countries;

-- (3) country_id이 'ZC' 인 레코드를 제거하는 쿼리문
DELETE FROM countries WHERE country_id = 'ZC';
SELECT * FROM countries;








