-- CREATE : DB���� ���� �������/��������� ������ ����ϴ� ��ɾ�
-- VIEW : ���� ���̺� / ���ڵ忡�� �ʿ��� �͸� ���ͼ� �� �� �ְ� ���ִ� ��
-- -> ���̺��� ���� �ǵ帮�� ����
-- -> ������ �Ǵ� ���ڵ带 �����ϰ� ����� �� �ְ� ������
-- �� AS �ڿ� �ٴ� SELECT�� �ùٸ��� �о ��������� ��
CREATE VIEW simple_region AS SELECT region_name FROM regions;
SELECT * FROM simple_region;

-- VIEW�� ���͸��� ���ڵ带 �����ϴ� ���� ������
-- -> ������ ��� �ʵ�(��)�� �����ͼ� ������ ����
-- -> �ʿ信 ���󼭴� �������ǵ� �߰��ؼ�, ����/����/������ �ȵǵ��� ����⵵ ��
-- �� PK�� �ظ��ؼ� �������� �ʴ°� ����
CREATE VIEW simple_region_all AS SELECT * FROM regions;
INSERT INTO simple_region_all(region_id, region_name) VALUES (5, 'Korea');
SELECT * FROM simple_region_all;
SELECT * FROM regions;

-- �� VIEW�� ���� �� �� �ִ� ���� ���ڵ��� ������
-- �� ���͸��� ������ ���ڵ带 ���� �Ǵ� ��
-- �� VIEW�� ���� ���ڵ带 �����ϰ� ���� ����







