

from os import replace


class SensorBase:
    def coletar_dados(self):
        return "Coletando dados genericos\n"

class SensorTemperatura(SensorBase):
    def coletar_dados(self):
        dados = super().coletar_dados()
        return dados + "Temperatura 22^C\n"

class SensorUmidade(SensorBase):
    def coletar_dados(self):
        dados = super().coletar_dados()
        return dados + "Umidade 45%\n"

class SensorComposto(SensorTemperatura, SensorUmidade):
    def coletar_dados(self):
        dados = super(SensorTemperatura, self).coletar_dados()
        dadosnovo = super(SensorUmidade, self).coletar_dados()
        return dados+ "\n" + dadosnovo



dados = SensorComposto()
print(SensorComposto.__mro__)
value = dados.coletar_dados()
value = value.replace( "Coletando dados genericos\n", "")
print(value)