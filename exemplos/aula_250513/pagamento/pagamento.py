from abc import ABC, abstractmethod

class Pagamento(ABC):
    def __init__(self, valor):
        self.valor = valor

    @abstractmethod
    def processarPagamento(self):
        pass
    
class CartaoCredito(Pagamento):
    def __init__(self, valor, numero_cartao):
        super().__init__(valor)
        self.numero_cartao = numero_cartao

    def processarPagamento(self):
        print(f'Pagamento de {self.valor} processado via Cartão de Crédito: {self.numero_cartao}')
        
class Boleto(Pagamento):
    def __init__(self, valor, codigo_barras):
        super().__init__(valor)
        self.codigo_barras = codigo_barras

    def processarPagamento(self):
        print(f'Pagamento de {self.valor} processado via Boleto: {self.codigo_barras}')
        
class Pix(Pagamento):
    def __init__(self, valor, chave_pix):
        super().__init__(valor)
        self.chave_pix = chave_pix

    def processarPagamento(self):
        print(f'Pagamento de {self.valor} processado via Pix: {self.chave_pix}')
        
# Exemplo de uso
pagamento_cartao = CartaoCredito(100.0, '1234-5678-9012-3456')
pagamento_cartao.processarPagamento()