-- 실습
-- 1) JOBS테이블로부터 MIN_SALARY가 10000이상인 레코드만
--   읽어들이는 SELECT 쿼리문을 작성하세요.
SELECT * FROM jobs WHERE min_salary >= 10000;

-- 2) JOBS테이블로부터 MAX_SALARY가 10000미만인 레코드만
--   읽어들이는 SELECT 쿼리문을 작성하세요.
SELECT * FROM jobs WHERE max_salary < 10000;

-- 3) JOBS테이블로부터 MIN_SALARY가 5000이상이고
--   MAX_SALARY가 10000미만인 레코드만 읽어들이는 SELECT 쿼리문을 작성하세요.
SELECT * FROM jobs WHERE min_salary >= 5000 AND max_salary < 10000;
