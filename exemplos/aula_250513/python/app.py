from abc import ABC, abstractmethod

class Funcionario(ABC):
    def __init__(self, nome, salario):
        self.nome = nome
        self.salario = salario

    def iniciarDia(self):
        print(f'{self.nome} iniciou o dia de trabalho.')
        
    def finalizarDia(self):
        print(f'{self.nome} finalizou o dia de trabalho.')
        
    @abstractmethod
    def calcularSalario(self):
        pass
        
class Gerente(Funcionario):
    def __init__(self, nome, salario, bonus):
        super().__init__(nome, salario)
        self.bonus = bonus
        
    def calcularSalario(self):
        return self.salario + self.bonus
        
class Operador(Funcionario):
    def __init__(self, nome, salario):
        super().__init__(nome, salario)
        
    def calcularSalario(self):
        return self.salario
        

samuel = Gerente('Samuel', 5000, 1000)
ronaldo = Operador('Ronaldo', 3000)

samuel.iniciarDia()
print(f'Salário do Gerente: {samuel.calcularSalario()}')
    