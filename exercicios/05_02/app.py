print("Olá, Mundo!") # Exibe uma mensagem na tela

# Isto é um comentário de uma linha

"""
Isto é
um comentário
de múltiplas linhas
"""

inteiro = 10          # int
fracionado = 2.5      # float
texto = "Olá, Python" # str
logico = True         # bool
lista = [1, 2, 3]     # list
dicionario = {"chave": "valor"}  # dict

x = 5
print(x)          # imprime o valor de x
x = "agora sou texto"   # OK em Python
print(x)          # imprime o novo valor de x

lista = [1, 2]
lista.append(3)         # lista mutável

print(lista)         # imprime a lista

def soma(a, b):
    return a + b

resultado = soma(3, 4)   # 7

print(resultado)         # imprime o resultado da soma

def cumprimentar(nome="Aluno"):
    print(f"Olá, {nome}!")

cumprimentar()           # Olá, Aluno!
cumprimentar(nome="Ana") # Olá, Ana!
