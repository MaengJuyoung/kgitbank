INSERT INTO regions(region_id, region_name) VALUES (5, 'Korea1');
INSERT INTO regions(region_id, region_name) VALUES (6, 'Korea1');
INSERT INTO regions(region_id, region_name) VALUES (7, 'Korea2');
INSERT INTO regions(region_id, region_name) VALUES (8, 'Korea2');
INSERT INTO regions(region_id, region_name) VALUES (9, 'Korea3');
INSERT INTO regions(region_id, region_name) VALUES (10, 'Korea3');
SELECT * FROM regions;

-- DELETE : ���ڵ带 �����ϴ� ������
-- �� Ư���ʵ��� ���Ŵ� UPDATE�� �����Ͽ� ó����
-- �� ��Ȯ�ϰ� ������ �ɾ ���Ÿ� ������

-- DELETE�� �� �� WHERE�� ���ǿ� primary/unique key�� �ߺ��� ���� ������ ������
DELETE FROM regions WHERE region_id = 5;
DELETE FROM regions WHERE region_id = 6;
SELECT * FROM regions;

-- DELETE�� �� �� �������� ����ڴٸ� ������ ������, ������� �ϴ� ���� ������ �� �ִ��� Ȯ���ؾ� ��
DELETE FROM regions WHERE region_name = 'Korea2' OR region_name = 'Korea3';
SELECT * FROM regions;

-- COMMIT : ��� �ݿ��϶�� �����ϴ� ������
-- -> UPDATE, INSERT, DELETE�� �ַ� ���� ���� ��찡 ����
-- -> �����ͺ��̽��� ������ ���� COMMIT�� ����ó���ϴ� ��찡 ����
COMMIT;
-- -> �ݿ��Ǿ ����� ������ �����ϰ� ����ؾ� ��