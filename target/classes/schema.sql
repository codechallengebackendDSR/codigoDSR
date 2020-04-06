DROP TABLE IF EXISTS TB_TRANSACTION;


CREATE TABLE TB_TRANSACTION (
  reference      	    VARCHAR NOT NULL primary KEY,
  account_iban  		VARCHAR NOT NULL,
  date			        TIMESTAMP,
  amount		   		INT NOT NULL,
  fee		            INT,
  description			VARCHAR
);