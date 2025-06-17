class SenhaInvalidaError(Exception):
    """Exceção para senhas inválidas."""
    def __init__(self):
        super().__init__("Senha insegura")
        
class Login:
    @staticmethod
    def validar_senha(senha):
        """Valida a senha de acordo com os critérios especificados."""
        if len(senha) < 8:
            raise SenhaInvalidaError()


try:
    Login.validar_senha(input("Digite uma senha: "))
    print("Senha válida! ✅")
except SenhaInvalidaError as e:
    print(f"Erro: {e} 🚫")