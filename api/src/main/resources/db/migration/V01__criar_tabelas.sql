CREATE TABLE usuario (
  id_usuario        BIGINT       NOT NULL AUTO_INCREMENT,
  authorities       VARCHAR(100),
  email             VARCHAR(120),
  lastPasswordReset DATETIME,
  password          VARCHAR(120) NOT NULL,
  username          VARCHAR(12)  NOT NULL,
  PRIMARY KEY (id_usuario)
);

CREATE TABLE revisao (
  id_revisao        BIGINT       NOT NULL AUTO_INCREMENT,
  titulo       		VARCHAR(100),
  inicio 			DATETIME,
  fim 				DATETIME,
  status			VARCHAR(120) NOT NULL,
  ativo				BOOLEAN,
  PRIMARY KEY (id_revisao)
);

CREATE TABLE setor (
  id_setor          BIGINT       NOT NULL AUTO_INCREMENT,
  nome       		VARCHAR(100),
  PRIMARY KEY (id_setor)
);

CREATE TABLE aprovador (
  id_aprovador      BIGINT       NOT NULL AUTO_INCREMENT,
  id_usuario        BIGINT		 NOT NULL,
  id_setor			BIGINT		 NOT NULL,
  PRIMARY KEY (id_aprovador),
  FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
  FOREIGN KEY (id_setor) REFERENCES setor(id_setor)
);