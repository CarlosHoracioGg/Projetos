/*
 "ConnectionStrings": {
    "FilmesConnection": "Server=localhost;Database=FilmesDB;Trusted_Connection=True;TrustServerCertificate=True;Encrypt=False;"
  },
*/

CREATE DATABASE FilmesDB;
GO

USE FilmesDB;
GO

CREATE TABLE Filmes (
    Id INT PRIMARY KEY IDENTITY(1,1),
    Titulo NVARCHAR(100),
    Genero NVARCHAR(50),
    Ano INT
);
GO

INSERT INTO Filmes (Titulo, Genero, Ano) VALUES
('Interestelar', 'Ficção Científica', 2014),
('Matrix', 'Ação', 1999),
('Cidade de Deus', 'Drama', 2002);
GO


SELECT Id, Titulo, Genero, Ano FROM Filmes;

SELECT * FROM Filmes;

SELECT * FROM Filmes where id = 1;

INSERT INTO Filmes (Titulo, Genero, Ano) VALUES ('E o vento levou','drama','1950');

DELETE FROM Filmes WHERE Id = 5;

UPDATE Filmes SET Titulo = 'Cidade de Deus', Genero = 'Terror', Ano = '2025' WHERE Id = 3