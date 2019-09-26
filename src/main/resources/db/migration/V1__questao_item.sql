CREATE TABLE questao (
    id                  SERIAL       PRIMARY KEY,
    descricao           VARCHAR(255) NOT NULL,
    dificuldade         VARCHAR(10)  NOT NULL,
    gabarito            CHAR         NOT NULL,
    id_prova            INT          NOT NULL REFERENCES prova
);

CREATE TABLE item (
    id                  SERIAL       PRIMARY KEY,
    descricao           VARCHAR(255) NOT NULL,
    opcao               CHAR         NOT NULL,
    id_questao          INT          NOT NULL REFERENCES questao
);