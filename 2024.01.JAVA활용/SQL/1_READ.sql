-- READ : SELECT쿼리문에 의하여 달성됨
-- 작성방식 : 쿼리문의 주요 키워드는 대문자를 일부러 작성함
SELECT * FROM regions;           -- 모든 레코드를 가져오는게 기본값
SELECT region_name FROM regions; -- 필드를 지정하는 것만 가능함
SELECT country_id, region_id FROM countries; -- 여러개면 쉼표로 구분함

-- WHERE절 : if조건문에 대응됨 / 조건식을 작성해서 참인 것만 걸러낼 수 있음
-- 조건식에서는 FROM에서 지정한 테이블의 필드만 골라줘야 함
-- =, >=, <=, >, <, != 6종을 활용해 지정할 수 있음
SELECT * FROM countries WHERE region_id = 3;

-- AND, OR을 붙여 논리연산이 가능함
SELECT * FROM countries WHERE region_id = 3 AND country_id = 'JP';

-- WHERE절은 JAVA에서 쓸 때 작성하여 전송해주게 됨
-- 필요한 것들만 정확하게 받아올 수 있게 됨



