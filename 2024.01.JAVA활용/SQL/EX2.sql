-- �ǽ�
-- 1) COUNTRIES ���̺� INSERT�� �̿��� ���ڵ带 �߰��ϼ���.
--   �߰��� ���ڵ�� ������� 'KR', 'KOREA', 5 �Դϴ�.
INSERT INTO countries(country_id, country_name, region_id) VALUES ('KR', 'KOREA', 5);

-- 2) COUNTRIES ���̺� INSERT�� �̿��� ���ڵ带 �߰��ϼ���.
--   �߰��� ���ڵ�� 'Ukraine', 6, 'UR' �Դϴ�.
INSERT INTO countries(country_name, region_id, country_id) VALUES ('Ukraine', 6, 'UR');

-- 3) COUNTRIES ���̺� INSERT�� �̿��� ���ڵ带 �߰��ϼ���.
--   �߰��� ���ڵ�� 7, 'EN', 'ENGLAND' �Դϴ�.
INSERT INTO countries(region_id, country_id, country_name) VALUES (5, 'EN', 'ENGLAND');

-- ���Ȯ���� SELECT�� �մϴ�.
SELECT * FROM countries;