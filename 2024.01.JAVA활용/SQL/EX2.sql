-- 실습
-- 1) COUNTRIES 테이블에 INSERT를 이용해 레코드를 추가하세요.
--   추가할 레코드는 순서대로 'KR', 'KOREA', 5 입니다.
INSERT INTO countries(country_id, country_name, region_id) VALUES ('KR', 'KOREA', 5);

-- 2) COUNTRIES 테이블에 INSERT를 이용해 레코드를 추가하세요.
--   추가할 레코드는 'Ukraine', 6, 'UR' 입니다.
INSERT INTO countries(country_name, region_id, country_id) VALUES ('Ukraine', 6, 'UR');

-- 3) COUNTRIES 테이블에 INSERT를 이용해 레코드를 추가하세요.
--   추가할 레코드는 7, 'EN', 'ENGLAND' 입니다.
INSERT INTO countries(region_id, country_id, country_name) VALUES (5, 'EN', 'ENGLAND');

-- 결과확인은 SELECT로 합니다.
SELECT * FROM countries;