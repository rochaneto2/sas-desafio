CREATE TABLE prova(
    id                  SERIAL       PRIMARY KEY,
    id_simulado         INT          NOT NULL REFERENCES simulado
);