CREATE TABLE PROVA(
    id                  SERIAL       PRIMARY KEY,
    id_simulado         INT          NOT NULL REFERENCES SIMULADO,
    opcao               CHAR         NOT NULL,
    id_questao          INT          NOT NULL REFERENCES QUESTAO
);

ALTER TABLE QUESTAO ADD id_prova        INT         NOT NULL REFERENCES PROVA;