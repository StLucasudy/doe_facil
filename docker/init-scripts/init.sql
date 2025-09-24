CREATE TABLE enderecos (
    id SERIAL PRIMARY KEY,
    rua VARCHAR(255) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    cep VARCHAR(10) NOT NULL,
    complemento VARCHAR(255)
);


CREATE TABLE ongs (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cnpj VARCHAR(20) UNIQUE NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(100),
    area_atuacao VARCHAR(100),
    endereco_id INT REFERENCES enderecos(id) ON DELETE SET NULL
);


CREATE TABLE colaboradores (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    email VARCHAR(100),
    telefone VARCHAR(20),
    cargo VARCHAR(100),
    ong_id INT NOT NULL REFERENCES ongs(id) ON DELETE CASCADE
);


CREATE TABLE doacoes (
    id SERIAL PRIMARY KEY,
    tipo VARCHAR(20) CHECK (tipo IN ('FINANCEIRA', 'PRODUTO')),
    descricao TEXT NOT NULL,
    valor NUMERIC(10,2),
    data_doacao DATE NOT NULL,
    doador VARCHAR(255),
    colaborador_id INT NOT NULL REFERENCES colaboradores(id) ON DELETE CASCADE,
    ong_id INT NOT NULL REFERENCES ongs(id) ON DELETE CASCADE
);
