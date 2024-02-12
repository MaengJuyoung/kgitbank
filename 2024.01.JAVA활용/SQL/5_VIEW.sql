-- CREATE : DB에서 각종 구성요소/관리요소의 생성을 담당하는 명령어
-- VIEW : 가상 테이블 / 레코드에서 필요한 것만 따와서 볼 수 있게 해주는 것
-- -> 테이블을 직접 건드리지 않음
-- -> 원본이 되는 레코드를 안전하게 사용할 수 있게 도와줌
-- ※ AS 뒤에 붙는 SELECT로 올바르게 읽어서 전달해줘야 함
CREATE VIEW simple_region AS SELECT region_name FROM regions;
SELECT * FROM simple_region;

-- VIEW는 필터링된 레코드를 제공하는 것이 목적임
-- -> 원본의 모든 필드(열)을 가져와서 만들지 않음
-- -> 필요에 따라서는 제약조건도 추가해서, 삭제/삽입/변경이 안되도록 만들기도 함
-- ※ PK는 왠만해선 보여주지 않는게 좋음
CREATE VIEW simple_region_all AS SELECT * FROM regions;
INSERT INTO simple_region_all(region_id, region_name) VALUES (5, 'Korea');
SELECT * FROM simple_region_all;
SELECT * FROM regions;

-- ★ VIEW를 통해 볼 수 있는 것은 레코드의 원본임
-- ★ 필터링된 상태의 레코드를 보게 되는 것
-- ★ VIEW는 실제 레코드를 저장하고 있지 않음







