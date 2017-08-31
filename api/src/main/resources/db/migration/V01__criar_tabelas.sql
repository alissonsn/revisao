CREATE TABLE usuario (
  id_usuario        BIGINT       NOT NULL AUTO_INCREMENT,
  authorities       VARCHAR(100),
  email             VARCHAR(120),
  lastPasswordReset DATETIME,
  password          VARCHAR(120) NOT NULL,
  username          VARCHAR(12)  NOT NULL,
  PRIMARY KEY (id_usuario)
);
