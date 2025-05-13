class SensorBase:
    def coletar_dados(self):
        return "Coletando dados genéricos"

class SensorTemperatura(SensorBase):
    def coletar_dados(self):
        dados = super().coletar_dados()
        return "Temperatura: 22°C\n" + dados

class SensorUmidade(SensorBase):
    def coletar_dados(self):
        dados = super().coletar_dados()
        return "Umidade: 45%\n" + dados

class SensorComposto(SensorTemperatura, SensorUmidade):
    def coletar_dados(self):
        dados = super().coletar_dados()
        # Precisamos agora separar e reorganizar a saída
        linhas = dados.strip().split('\n')
        # Extrai só os dados de temperatura e umidade, ignorando "genérico"
        temp = next((l for l in linhas if l.startswith("Temperatura")), "")
        umid = next((l for l in linhas if l.startswith("Umidade")), "")
        return f"Dados Combinados:\n{temp}\n{umid}"

sensor = SensorComposto()
print(sensor.coletar_dados())
