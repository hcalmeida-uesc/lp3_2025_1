from abc import ABC, abstractmethod

class IAutenticacao(ABC):
    @abstractmethod
    def autenticar(self, senha):
        pass
    
class ICRAA(ABC):
    @abstractmethod
    def calcularCRAA(self):
        pass
    
    
class Usuario():
    def __init__(self, nome):
        self.nome = nome
        
class Professor(Usuario, IAutenticacao):
    def __init__(self, nome, senha):
        super().__init__(nome)
        self.senha = senha
        
    def autenticar(self, senha):
        return self.senha == senha
    
class Aluno(Usuario, ICRAA, IAutenticacao):
    def __init__(self, nome, senha, notas):
        super().__init__(nome)
        self.senha = senha
        self.notas = notas
        
    def calcularCRAA(self):
        return sum(self.notas) / len(self.notas)
    
    def autenticar(self, senha):
        return self.senha == senha
    
# Exemplo de uso

professor = Professor("Carlos", "senha123")
aluno = Aluno("Ana", "senha456", [8.0, 9.0, 7.5])   
print(professor.autenticar("senha123"))  # True
print(aluno.autenticar("senha456"))  # True
print(aluno.calcularCRAA())  # 8.166666666666666 