INSERT INTO regions(region_id, region_name) VALUES (5, 'KOREA');
SELECT * FROM regions;

-- UPDATE ������ ������� ��� ���ڵ带 �����ϱ� ���� ������
-- UPDATE regions SET region_id=6; 
-- -> ��� ���ڵ��� ���� ������
-- -> �����ͺ��̽��� ���� �׷��� ���ϴ� �Ͱ� ���� ����� ������

-- WHERE���� �Բ� �����ؼ� ��� �� -> �Ϻ��� ���Ÿ� �ʿ��ϱ� ������...
UPDATE regions SET region_id = 6 WHERE region_name = 'KOREA';

-- �� : Primary/UniqueŰ(�ߺ������ �ȵ�)�� ������ �ʵ带 �̿��� �˻��ϸ�
--     ��Ȯ�ϰ� �ʿ��� �͸� ã�� �� ����
UPDATE regions SET region_name = 'Korea' WHERE region_id = 6;

SELECT * FROM regions;