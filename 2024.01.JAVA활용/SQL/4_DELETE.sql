INSERT INTO regions(region_id, region_name) VALUES (5, 'Korea1');
INSERT INTO regions(region_id, region_name) VALUES (6, 'Korea1');
INSERT INTO regions(region_id, region_name) VALUES (7, 'Korea2');
INSERT INTO regions(region_id, region_name) VALUES (8, 'Korea2');
INSERT INTO regions(region_id, region_name) VALUES (9, 'Korea3');
INSERT INTO regions(region_id, region_name) VALUES (10, 'Korea3');
SELECT * FROM regions;

-- DELETE : 레코드를 삭제하는 쿼리문
-- ※ 특정필드의 제거는 UPDATE를 응용하여 처리함
-- ※ 정확하게 조건을 걸어서 제거를 진행함

-- DELETE를 할 때 WHERE의 조건에 primary/unique key로 중복이 없는 것으로 지정함
DELETE FROM regions WHERE region_id = 5;
DELETE FROM regions WHERE region_id = 6;
SELECT * FROM regions;

-- DELETE를 할 때 여러개를 지우겠다면 말리지 않지만, 지우고자 하는 것을 지정할 수 있는지 확인해야 함
DELETE FROM regions WHERE region_name = 'Korea2' OR region_name = 'Korea3';
SELECT * FROM regions;

-- COMMIT : 즉시 반영하라고 지시하는 쿼리문
-- -> UPDATE, INSERT, DELETE에 주로 같이 쓰는 경우가 많음
-- -> 데이터베이스의 설정에 따라 COMMIT을 수동처리하는 경우가 있음
COMMIT;
-- -> 반영되어도 상관이 없는지 진지하게 고민해야 함