SELECT * FROM employees WHERE employee_id = 101;
SELECT * FROM employees WHERE job_id = 'IT_PROG';

-- 실습 : employees 테이블에 대한 쿼리문을 작성하세요.
-- 1) job id가 'IT_PROG'인 근무자들의 salary를 전부 20000으로 갱신하세요.
UPDATE employees SET salary=20000 WHERE job_id = 'IT_PROG';
SELECT salary FROM employees WHERE job_id = 'IT_PROG';

-- 2) employee_id가 150인 근무자의 salary를 66666으로 갱신하세요.
UPDATE employees SET salary = 66666 WHERE employee_id = 150;
SELECT salary FROM employees WHERE employee_id = 150;

-- 3) <난이도-중상>
--    1)과 2)에서 업데이트된 레코드를 골라서 볼 수있는
--    SELECT쿼리문을 구성하세요.
SELECT * FROM employees WHERE job_id = 'IT_PROG' OR employee_id = 150;

