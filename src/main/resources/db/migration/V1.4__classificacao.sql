CREATE TABLE classificacao(
    id                  SERIAL       PRIMARY KEY,
    nota                INT          NOT NULL,
    id_simulado         INT          NOT NULL REFERENCES simulado,
    id_aluno            INT          NOT NULL REFERENCES aluno
);