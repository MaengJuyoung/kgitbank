-- READ : SELECT�������� ���Ͽ� �޼���
-- �ۼ���� : �������� �ֿ� Ű����� �빮�ڸ� �Ϻη� �ۼ���
SELECT * FROM regions;           -- ��� ���ڵ带 �������°� �⺻��
SELECT region_name FROM regions; -- �ʵ带 �����ϴ� �͸� ������
SELECT country_id, region_id FROM countries; -- �������� ��ǥ�� ������

-- WHERE�� : if���ǹ��� ������ / ���ǽ��� �ۼ��ؼ� ���� �͸� �ɷ��� �� ����
-- ���ǽĿ����� FROM���� ������ ���̺��� �ʵ常 ������ ��
-- =, >=, <=, >, <, != 6���� Ȱ���� ������ �� ����
SELECT * FROM countries WHERE region_id = 3;

-- AND, OR�� �ٿ� �������� ������
SELECT * FROM countries WHERE region_id = 3 AND country_id = 'JP';

-- WHERE���� JAVA���� �� �� �ۼ��Ͽ� �������ְ� ��
-- �ʿ��� �͵鸸 ��Ȯ�ϰ� �޾ƿ� �� �ְ� ��



