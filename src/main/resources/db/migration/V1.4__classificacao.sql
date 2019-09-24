CREATE TABLE CLASSIFICACAO(
    id                  SERIAL       PRIMARY KEY,
    nota                INT          NOT NULL,
    id_simulado         INT          NOT NULL REFERENCES SIMULADO,
    id_aluno            INT          NOT NULL REFERENCES ALUNO
);