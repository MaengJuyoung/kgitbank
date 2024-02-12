-- INSERT ������ : Create ����� �����
-- INTO���� �߰��ؼ� ��� �ִ� ������ ������
-- 1) ���̺�� �� �Ұ�ȣ�ȿ� �ʵ���� ������ �� ���� ������
INSERT INTO regions(region_id, region_name) VALUES (5, 'KOREA');

-- 2) �ʵ���� ������ �ٲ� ��ġ�ص� �ν��� �� ����
INSERT INTO regions(region_name, region_id) VALUES ('JAPAN', 6);

-- 3) �Ϻ� �ʵ�� �Ӽ��� �����ϱ� ������ �̿� �����ؾ� ��
-- �Ӽ� NULLABLE : ����ִ� ���¸� ����ϴ��� ����
-- -> INSERT INTO regions(region_name) VALUES ('CHINA');
-- �������� : Unique_Key(�ߺ����X, NULL����), Priamry_Key(�ߺ����X, NULL�Ұ�)
-- -> INSERT INTO regions(region_id) VALUES (7);

-- 4) ���� ���� �����ϴ� �뵵�� �ƴ� / UPDATE �Ǵ� DELETE�� INSERT�Ǿ� ��
-- -> INSERT INTO regions(region_name, region_id) VALUES ('JAPAN', 7);

SELECT * FROM regions;