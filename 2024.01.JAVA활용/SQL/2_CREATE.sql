-- INSERT 쿼리문 : Create 기능을 담당함
-- INTO절을 추가해서 어디에 넣는 것인지 설정함
-- 1) 테이블명 옆 소괄호안에 필드명을 지정해 쓸 것을 권장함
INSERT INTO regions(region_id, region_name) VALUES (5, 'KOREA');

-- 2) 필드명을 순서를 바꿔 배치해도 인식할 수 있음
INSERT INTO regions(region_name, region_id) VALUES ('JAPAN', 6);

-- 3) 일부 필드는 속성이 존재하기 때문에 이에 주의해야 함
-- 속성 NULLABLE : 비어있는 상태를 허용하는지 여부
-- -> INSERT INTO regions(region_name) VALUES ('CHINA');
-- 제약조건 : Unique_Key(중복허용X, NULL가능), Priamry_Key(중복허용X, NULL불가)
-- -> INSERT INTO regions(region_id) VALUES (7);

-- 4) 기존 것을 수정하는 용도가 아님 / UPDATE 또는 DELETE후 INSERT되야 함
-- -> INSERT INTO regions(region_name, region_id) VALUES ('JAPAN', 7);

SELECT * FROM regions;