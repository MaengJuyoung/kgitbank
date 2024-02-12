-- JOIN : SELECT�� ���յǾ� ���Ǵ� ������
-- -> ���� �ٸ� ���̺��� ��� �ʿ��� ��������� �������� ������
-- -> ��Ű���� ���� ������ ���������� üũ����� ��

-- JOIN�� �׳� ���� INNER JOIN���� �۵���

-- 1) INNER JOIN : �ʵ尡 null�� ��� �������� ����
SELECT r.region_name, c.country_name
FROM regions r INNER JOIN countries c ON r.region_id = c.region_id;
-- 2) LEFT JOIN : �ٿ��ִ� ���̺� ���ڵ尡 ������ null�� ä����
SELECT r.region_name, c.country_name
FROM regions r LEFT JOIN countries c ON r.region_id = c.region_id;
-- 3) RIGHT JOIN : ���� ���̺� ���ڵ尡 ������ null�� ä����
SELECT r.region_name, c.country_name
FROM regions r RIGHT JOIN countries c ON r.region_id = c.region_id;
-- 4) FULL OUTER JOIN : ��ġ���� �ʴ� �͵鵵 ��� null�� ä����
SELECT r.region_name, c.country_name
FROM regions r FULL OUTER JOIN countries c ON r.region_id = c.region_id;
