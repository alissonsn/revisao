CREATE TABLE usuario (
  id                BIGINT       NOT NULL AUTO_INCREMENT,
  authorities       VARCHAR(50),
  email             VARCHAR(120),
  lastPasswordReset DATETIME,
  password          VARCHAR(120) NOT NULL,
  username          VARCHAR(12)  NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE revisao (
  id                BIGINT       NOT NULL AUTO_INCREMENT,
  titulo       		VARCHAR(100),
  inicio 			DATETIME,
  fim 				DATETIME,
  status			VARCHAR(120) NOT NULL,
  ativo				BOOLEAN,
  PRIMARY KEY (id)
);

CREATE TABLE setor (
  id                BIGINT       NOT NULL AUTO_INCREMENT,
  nome       		VARCHAR(100),
  PRIMARY KEY (id)
);