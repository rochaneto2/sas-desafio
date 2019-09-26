CREATE TABLE valor_questao (
    id                  SERIAL       PRIMARY KEY,
    nivel               VARCHAR(10)  NOT NULL,
    valor               INT          NOT NULL
);

INSERT INTO valor_questao VALUES (1, 'FACIL', 15);
INSERT INTO valor_questao VALUES (2, 'MEDIA', 12);
INSERT INTO valor_questao VALUES (3, 'DIFICIL', 8);