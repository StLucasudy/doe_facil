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
    endereco_id INT REFERENCES enderecos(id) ON DELETE SET NULL,
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


insert into enderecos(id, rua, numero, cep, complemento)
	values(1, 'Rua XV de Novembro', '268', '01014-000', 'predio histórico');

insert into enderecos(id, rua, numero, cep, complemento)
	values(2, 'Avenida Paulista', '1578', '01310-200', 'proximo ao Masp');

insert into enderecos(id, rua, numero, cep, complemento)
	values(3, 'Rua Oscar Freire', '840', '01426-000', 'loja');

insert into enderecos(id, rua, numero, cep, complemento)
	values(4, 'Rua Augusta', '2690', '01412-100', 'quase esquina com a Av. Paulista');

insert into enderecos(id, rua, numero, cep, complemento)
	values(5, 'Rua Frei Caneca', '569', '01307-001', 'Shopping Frei Caneca');

insert into ongs(id, nome, cnpj, telefone, email, area_atuacao, endereco_id)
	values(1, 'vamos viver', '23293954000135', '4223682112', 'vamos.viver@gmail.com', 'ajudar moradores de rua', 1);