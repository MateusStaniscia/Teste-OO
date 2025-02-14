CREATE TABLE Pessoa (
    id AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    data_nascimento VARCHAR(10) NOT NULL,
    endereco VARCHAR(100) NOT NULL,
    telefone VARCHAR(15) NOT NULL,
);

CREATE TABLE Aluno (
    id AUTO_INCREMENT PRIMARY KEY,
    id_pessoa INT UNIQUE NOT NULL,
    matricula VARCHAR(20) UNIQUE NOT NULL,
    FOREIGN KEY (id_pessoa) REFERENCES 
)

CREATE TABLE Professor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_pessoa INT UNIQUE NOT NULL,
    siape VARCHAR(20) UNIQUE NOT NULL, 
    FOREIGN KEY (id_pessoa) REFERENCES Pessoa(id) ON DELETE CASCADE,
);

CREATE TABLE Escola (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(100) NOT NULL,
    telefone VARCHAR(15),
    email VARCHAR(100) UNIQUE NOT NULL,
);

CREATE TABLE Disciplina (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    ementa VARCHAR(100) NOT NULL,
    carga_horaria DOUBLE NOT NULL,
    responsável VARCHAR(100) NOT NULL,
    id_professor INT,
    FOREIGN KEY (id_professor) REFERENCES Professor(id) ON DELETE SET NULL,
);

CREATE TABLE Disciplina_Aluno (
    id_disciplina INT,
    id_aluno int,
    PRIMARY KEY (id_disciplina, id_aluno),
    FOREIGN KEY (id_disciplina) REFERENCES Disciplina(id) ON DELETE CASCADE,
    FOREIGN KEY (id_aluno) REFERENCES Aluno(id) ON DELETE CASCADE,
)


DROP TABLE IF EXISTS Disciplina_Aluno;
DROP TABLE IF EXISTS Disciplina;
DROP TABLE IF EXISTS Escola;
DROP TABLE IF EXISTS Professor;
DROP TABLE IF EXISTS Aluno;
DROP TABLE IF EXISTS Pessoa;
