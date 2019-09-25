CREATE TABLE prova(
    id                  SERIAL       PRIMARY KEY,
    id_simulado         INT          NOT NULL REFERENCES simulado,
    opcao               CHAR         NOT NULL,
    id_questao          INT          NOT NULL REFERENCES questao
);

ALTER TABLE questao ADD id_prova        INT         NOT NULL REFERENCES prova;