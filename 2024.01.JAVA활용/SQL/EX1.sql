-- �ǽ�
-- 1) JOBS���̺�κ��� MIN_SALARY�� 10000�̻��� ���ڵ常
--   �о���̴� SELECT �������� �ۼ��ϼ���.
SELECT * FROM jobs WHERE min_salary >= 10000;

-- 2) JOBS���̺�κ��� MAX_SALARY�� 10000�̸��� ���ڵ常
--   �о���̴� SELECT �������� �ۼ��ϼ���.
SELECT * FROM jobs WHERE max_salary < 10000;

-- 3) JOBS���̺�κ��� MIN_SALARY�� 5000�̻��̰�
--   MAX_SALARY�� 10000�̸��� ���ڵ常 �о���̴� SELECT �������� �ۼ��ϼ���.
SELECT * FROM jobs WHERE min_salary >= 5000 AND max_salary < 10000;
