from abc import ABC, abstractmethod
import random

# ---------- Classes Abstratas e Interface ----------
class Personagem(ABC):
    def __init__(self, nome: str, vida: int, forca: int):
        self._nome = nome
        self._vida = vida
        self._forca = forca
        self._status = []

    @property
    def nome(self):
        return self._nome
    
    @property
    def vida(self):
        return self._vida
    
    @vida.setter
    def vida(self, valor):
        self._vida = max(valor, 0)
    
    @property
    def forca(self):
        return self._forca
    
    @abstractmethod
    def atacar(self, alvo) -> int:
        pass
    
    @abstractmethod
    def defender(self, dano: int):
        pass
    
    def mostrar_status(self):
        status = " | ".join([s.name for s in self._status]) if self._status else "Nenhum"
        print(f"{self._nome} [Vida: {self._vida} | Força: {self._forca} | Status: {status}]")
    
    def esta_vivo(self):
        return self._vida > 0

class HabilidadeEspecial(ABC):
    @abstractmethod
    def usar_habilidade_especial(self, alvo=None):
        pass

# ---------- Classes de Personagens ----------
class Guerreiro(Personagem, HabilidadeEspecial):
    def __init__(self, nome: str, vida: int, forca: int, escudo: int):
        super().__init__(nome, vida, forca)
        self._escudo = escudo
    
    def atacar(self, alvo):
        dano = self._forca + 5
        print(f"{self.nome} ataca {alvo.nome} causando {dano} de dano!")
        return dano
    
    def defender(self, dano: int):
        dano_efetivo = max(dano - self._escudo, 0)
        self.vida -= dano_efetivo
        print(f"{self.nome} bloqueou {self._escudo} de dano! Recebeu {dano_efetivo} de dano.")
        return dano_efetivo
    
    def usar_habilidade_especial(self, alvo=None):
        self._forca *= 2
        self._escudo = 0
        print(f"{self.nome} usa INVESTIDA! Ataque dobrado, escudo quebrado.")

class Mago(Personagem, HabilidadeEspecial):
    def __init__(self, nome: str, vida: int, forca: int, mana: int):
        super().__init__(nome, vida, forca)
        self._mana = mana
    
    def atacar(self, alvo):
        if self._mana < 10:
            print(f"{self.nome} não tem mana suficiente para atacar!")
            return 0
        
        self._mana -= 10
        dano = self._forca * 2
        print(f"{self.nome} lança um feitiço em {alvo.nome} causando {dano} de dano! (Mana: {self._mana})")
        return dano
    
    def defender(self, dano: int):
        self.vida -= dano
        self._mana += 5
        print(f"{self.nome} recebe {dano} de dano e recupera 5 de mana! (Mana: {self._mana})")
        return dano
    
    def usar_habilidade_especial(self, alvo=None):
        self._mana += 20
        print(f"{self.nome} usa TELEPORTE! Recupera 20 de mana. (Mana: {self._mana})")

class Inimigo(Personagem, HabilidadeEspecial):
    def __init__(self, nome: str, vida: int, forca: int, tipo: str):
        super().__init__(nome, vida, forca)
        self._tipo = tipo
    
    def atacar(self, alvo):
        dano = self._forca
        print(f"{self.nome} ataca {alvo.nome} causando {dano} de dano!")
        return dano
    
    def defender(self, dano: int):
        self.vida -= dano
        print(f"{self.nome} recebe {dano} de dano! Vida restante: {self.vida}")
        return dano
    
    def usar_habilidade_especial(self, alvo=None):
        if self._tipo == "Dragão":
            dano = self._forca * 1.5
            print(f"{self.nome} usa SOPRO DE FOGO! Causa {dano} de dano em área!")
            return dano
        return 0
    
    def tomar_decisao(self, aliados):
        aliados_vivos = [a for a in aliados if a.esta_vivo()]
        if not aliados_vivos:
            return None, None
        
        # Escolhe aleatoriamente entre ataque normal e habilidade especial
        if random.random() < 0.3:  # 30% de chance de usar habilidade especial
            return "habilidade", None
        
        # Escolhe o aliado com menos vida
        alvo = min(aliados_vivos, key=lambda x: x.vida)
        return "atacar", alvo

# ---------- Sistema de Batalha ----------
class SistemaBatalha:
    def __init__(self):
        self._aliados = []
        self._inimigos = []
    
    def adicionar_aliado(self, personagem):
        if isinstance(personagem, Personagem):
            self._aliados.append(personagem)
        else:
            raise TypeError("O objeto deve ser um Personagem")
    
    def adicionar_inimigo(self, inimigo):
        if isinstance(inimigo, Inimigo):
            self._inimigos.append(inimigo)
        else:
            raise TypeError("O objeto deve ser um Inimigo")
    
    def _turno_jogador(self, personagem):
        print(f"\n--- Vez de {personagem.nome} ---")
        personagem.mostrar_status()
        
        acao = input("Escolha uma ação (atacar/defender/habilidade): ").lower()
        
        if acao == "atacar":
            print("Alvos disponíveis:")
            for i, inimigo in enumerate(self._inimigos):
                if inimigo.esta_vivo():
                    print(f"{i+1}. {inimigo.nome} (Vida: {inimigo.vida})")
            
            try:
                escolha = int(input("Escolha o número do alvo: ")) - 1
                if 0 <= escolha < len(self._inimigos) and self._inimigos[escolha].esta_vivo():
                    alvo = self._inimigos[escolha]
                    dano = personagem.atacar(alvo)
                    alvo.defender(dano)
                else:
                    print("Alvo inválido! Perdeu a vez.")
            except ValueError:
                print("Entrada inválida! Perdeu a vez.")
        
        elif acao == "habilidade":
            personagem.usar_habilidade_especial()
            print(f"{personagem.nome} usou habilidade especial!")
        
        elif acao == "defender":
            print(f"{personagem.nome} está em posição de defesa!")
            # Implementação real de defesa ocorreria quando atacado
        
        else:
            print("Ação inválida! Perdeu a vez.")
    
    def _turno_inimigo(self, inimigo):
        print(f"\n--- Vez de {inimigo.nome} (IA) ---")
        acao, alvo = inimigo.tomar_decisao(self._aliados)
        
        if not alvo and acao != "habilidade":
            return
        
        if acao == "atacar" and alvo:
            dano = inimigo.atacar(alvo)
            alvo.defender(dano)
        elif acao == "habilidade":
            dano = inimigo.usar_habilidade_especial()
            if dano > 0:
                for aliado in self._aliados:
                    if aliado.esta_vivo():
                        aliado.defender(dano)
    
    def iniciar_batalha(self):
        print("\n===== INÍCIO DA BATALHA =====")
        print("Participantes:")
        for p in self._aliados + self._inimigos:
            p.mostrar_status()
        
        turno = 1
        while any(a.esta_vivo() for a in self._aliados) and any(i.esta_vivo() for i in self._inimigos):
            print(f"\n----- Turno {turno} -----")
            
            # Todos os participantes (ordenados por força)
            participantes = sorted(
                self._aliados + self._inimigos,
                key=lambda x: x.forca,
                reverse=True
            )
            
            for participante in participantes:
                if not participante.esta_vivo():
                    continue
                
                if participante in self._aliados:
                    self._turno_jogador(participante)
                else:
                    self._turno_inimigo(participante)
                
                # Verifica se a batalha terminou
                if not any(i.esta_vivo() for i in self._inimigos):
                    print("\n===== FIM DA BATALHA =====")
                    print("Os heróis venceram! 🎉")
                    return
                    
                if not any(a.esta_vivo() for a in self._aliados):
                    print("\n===== FIM DA BATALHA =====")
                    print("Os inimigos venceram! 💀")
                    return
            
            turno += 1

# ---------- Execução da Batalha ----------
if __name__ == "__main__":
    # Criação dos personagens
    heroi = Guerreiro("Herói", vida=50, forca=15, escudo=5)
    mago = Mago("Mago", vida=40, forca=10, mana=30)
    dragao = Inimigo("Dragão Negro", vida=100, forca=25, tipo="Dragão")
    orc = Inimigo("Orc Guerreiro", vida=60, forca=18, tipo="Orc")
    
    # Configuração da batalha
    sistema = SistemaBatalha()
    sistema.adicionar_aliado(heroi)
    sistema.adicionar_aliado(mago)
    sistema.adicionar_inimigo(dragao)
    sistema.adicionar_inimigo(orc)
    
    # Início da batalha
    sistema.iniciar_batalha()