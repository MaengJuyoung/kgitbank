-- �ǽ� : COUNTRIES ���̺� ���� �������� �ۼ��ϼ���.
-- 1) INSERT ����������  ���̺� �Ʒ��� ���ڵ���� �߰��ϼ���.
-- (1) 'ZA','ZA111',1
-- (2) 'ZB','ZA123',2
-- (3) 'ZC','ZA213',3
-- (4) 'ZD','ZA231',4
-- (5) 'ZE','ZA312',3
-- (6) 'ZF','ZA321',2
-- (7) 'ZG','ZA111',1
-- �ʹ� ��� ;���� ������ ������ �ٹٲ޵� �����ϴ�.
INSERT INTO countries(country_id, country_name, region_id) VALUES ('ZA', 'ZA111', 1);
INSERT INTO countries(country_id, country_name, region_id) VALUES ('ZB', 'ZA123', 2);
INSERT INTO countries(country_id, country_name, region_id) VALUES ('ZC', 'ZA213', 3);
INSERT INTO countries(country_id, country_name, region_id) VALUES ('ZD', 'ZA231', 4);
INSERT INTO countries(country_id, country_name, region_id) VALUES ('ZE', 'ZA312', 3);
INSERT INTO countries(country_id, country_name, region_id) VALUES ('ZF', 'ZA321', 2);
INSERT INTO countries(country_id, country_name, region_id) VALUES ('ZG', 'ZA111', 1);
SELECT * FROM countries;

-- 2) DELETE ���������� ������ ���ڵ带 ã�� �����ϴ� ��������
--    �ۼ��ϼ���
-- (1) country_id�� 'ZG' �̰ų� 'ZA'�� ���ڵ带 �����ϴ� ������
-- �� : PK, UK�� ��� AND�� �� �� ����
DELETE FROM countries WHERE country_id = 'ZG' OR country_id = 'ZA';
SELECT * FROM countries;

-- (2) country_name�� 'ZA123' �̰ų� 'ZA321'�� ���ڵ带 �����ϴ� ������
DELETE FROM countries WHERE country_name = 'ZA123' OR country_name = 'ZA321';
SELECT * FROM countries;

-- (3) country_id�� 'ZC' �� ���ڵ带 �����ϴ� ������
DELETE FROM countries WHERE country_id = 'ZC';
SELECT * FROM countries;








