INSERT INTO regions(region_id, region_name) VALUES (5, 'KOREA');
SELECT * FROM regions;

-- UPDATE 기존에 만들어진 모든 레코드를 갱신하기 위한 쿼리문
-- UPDATE regions SET region_id=6; 
-- -> 모든 레코드의 값이 망가짐
-- -> 데이터베이스에 대한 테러를 가하는 것과 같은 결과를 유발함

-- WHERE절과 함께 조합해서 써야 함 -> 일부의 갱신만 필요하기 때문에...
UPDATE regions SET region_id = 6 WHERE region_name = 'KOREA';

-- 팁 : Primary/Unique키(중복허용이 안됨)가 설정된 필드를 이용해 검색하면
--     정확하게 필요한 것만 찾을 수 있음
UPDATE regions SET region_name = 'Korea' WHERE region_id = 6;

SELECT * FROM regions;