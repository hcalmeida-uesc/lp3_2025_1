try:
    numerador = 10
    denominador = int(input("Digite um número para dividir 10: "))
    resultado = numerador / denominador
    print(f"O resultado é {resultado}")
# Captura uma exceção específica
except ZeroDivisionError:
    print("Erro: Não é possível dividir por zero! 🚫")
# Captura outra exceção específica
except ValueError:
    print("Erro: Você precisa digitar um número inteiro! 🔢")
# Captura qualquer outra exceção (usar com cuidado!)
except Exception as e:
    print(f"Ocorreu um erro inesperado: {e}")
finally:    
    print("Fim do da operação de divisão! 🎉")