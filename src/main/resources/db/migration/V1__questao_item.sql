CREATE TABLE QUESTAO (
    id                  SERIAL       PRIMARY KEY,
    descricao           VARCHAR(255) NOT NULL,
    dificuldade         INT          NOT NULL
);

CREATE TABLE ITEM (
    id                  SERIAL       PRIMARY KEY,
    descricao           VARCHAR(255) NOT NULL,
    opcao               CHAR         NOT NULL,
    id_questao          INT          NOT NULL REFERENCES QUESTAO
);