class RaizQuadradaError(Exception):
    def __init__(self):
        super().__init__("Erro ao calcular a raiz quadrada")

class Utils:
    @staticmethod
    def calcular_raiz_quadrada(numero):
        if numero < 0:
            raise RaizQuadradaError()
        return numero ** 0.5

try:
    numero = float(input("Digite um número para calcular a raiz quadrada: "))
    resultado = Utils.calcular_raiz_quadrada(numero)
    print(f"A raiz quadrada de {numero} é {resultado}")
except RaizQuadradaError as e:
    print(f"Erro: {e} 🚫")
except Exception as e:
    print(f"Ocorreu um erro inesperado: {e} ❗")
