SELECT * FROM employees WHERE employee_id = 101;
SELECT * FROM employees WHERE job_id = 'IT_PROG';

-- �ǽ� : employees ���̺� ���� �������� �ۼ��ϼ���.
-- 1) job id�� 'IT_PROG'�� �ٹ��ڵ��� salary�� ���� 20000���� �����ϼ���.
UPDATE employees SET salary=20000 WHERE job_id = 'IT_PROG';
SELECT salary FROM employees WHERE job_id = 'IT_PROG';

-- 2) employee_id�� 150�� �ٹ����� salary�� 66666���� �����ϼ���.
UPDATE employees SET salary = 66666 WHERE employee_id = 150;
SELECT salary FROM employees WHERE employee_id = 150;

-- 3) <���̵�-�߻�>
--    1)�� 2)���� ������Ʈ�� ���ڵ带 ��� �� ���ִ�
--    SELECT�������� �����ϼ���.
SELECT * FROM employees WHERE job_id = 'IT_PROG' OR employee_id = 150;

