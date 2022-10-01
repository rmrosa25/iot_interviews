-- temporary store procedure for remove foreign key
DROP PROCEDURE IF EXISTS __tmp_removeFK;
DELIMITER $$
CREATE PROCEDURE __tmp_removeFK (tableName varchar(64))
BEGIN
  DECLARE fkName varchar(64);
  DECLARE sqlDropFK varchar(250);
  DECLARE done INT DEFAULT 0;

  DECLARE fkCursor CURSOR FOR
    SELECT CONSTRAINT_NAME FROM information_schema.TABLE_CONSTRAINTS TC
    WHERE TC.TABLE_SCHEMA = database()
    AND   TC.TABLE_NAME = tableName
    AND   TC.CONSTRAINT_TYPE = 'FOREIGN KEY';
  DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET done = 1;

  OPEN fkCursor;
  FETCH fkCursor INTO fkName;

  WHILE done = 0 DO
    SET @sqlDropFK = CONCAT('ALTER TABLE ', tableName ,' DROP FOREIGN KEY ', fkName, ';');
    PREPARE stmt_dropFK FROM @sqlDropFK;
    EXECUTE stmt_dropFK;
    DEALLOCATE PREPARE stmt_dropFK;

    FETCH fkCursor INTO fkName;
  END WHILE;

  CLOSE fkCursor;
END $$

DELIMITER ;

-- Remove departments foreign key constraint
CALL __tmp_removeFK('departments');

-- Remove employees foreign key constraint
CALL __tmp_removeFK('employees');

-- Remove temporary store procedure for remove foreign key
DROP PROCEDURE IF EXISTS __tmp_removeFK;

DROP TABLE IF EXISTS departments;

DROP TABLE IF EXISTS employees;

CREATE TABLE departments (
   id int auto_increment NOT NULL COMMENT 'id'
  ,departmentName varchar(128) NOT NULL COMMENT 'Name'
  ,CONSTRAINT PK_departments PRIMARY KEY (id)
);
CREATE INDEX IK_departments_departmentName ON departments (departmentName);

CREATE TABLE employees (
   id int auto_increment NOT NULL COMMENT 'id'
  ,employeeName varchar(128) NOT NULL COMMENT 'Name'
  ,departmentId int NULL COMMENT 'Department'
  ,CONSTRAINT PK_employees PRIMARY KEY (id)
);
CREATE INDEX IK_employees_employeeName ON employees (employeeName);

