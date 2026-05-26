# RotaAcessível 🦽

Sistema de mapeamento de obstáculos arquitetônicos para pessoas com mobilidade reduzida, desenvolvido em Java com Programação Orientada a Objetos.

## 📋 Sobre o projeto

Calçadas irregulares, degraus e falta de rampas são barreiras reais para cadeirantes, idosos e pessoas com mobilidade reduzida. O RotaAcessível permite cadastrar, consultar e gerenciar registros dessas barreiras em endereços específicos.

**Problema social:** Mobilidade urbana — projeto #04 (RotaAcessível)  
**Disciplinas:** Algoritmos e Programação + Programação Orientada a Objetos  
**Universidade:** Anhembi Morumbi

## 👨‍💻 Autores

| Nome | RA |
|------|----|
| Arafat Maratuly | 12526146265 |
| Rinat Tagaibekov | 12526144122 |

## 🗂️ Estrutura de pacotes

```
src/
├── model/
│   ├── Obstaculo.java          ← classe abstrata (herança)
│   ├── Degrau.java             ← subclasse (polimorfismo)
│   ├── CalcadaIrregular.java   ← subclasse (polimorfismo)
│   ├── RampaInexistente.java   ← subclasse (polimorfismo)
│   └── Usuario.java
├── service/
│   └── MapaService.java        ← lógica CRUD + ArrayList
└── view/
    └── Main.java               ← menu interativo
```

## 🧱 Conceitos de POO aplicados

| Conceito | Onde está no código |
|----------|---------------------|
| **Herança** | `Degrau`, `CalcadaIrregular`, `RampaInexistente` estendem `Obstaculo` |
| **Polimorfismo** | `exibirDetalhes()` sobrescrito em cada subclasse; chamado via `List<Obstaculo>` |
| **Encapsulamento** | Todos os atributos `private` com getters e setters |
| **Sobrecarga (overload)** | 2 construtores em cada subclasse e em `Usuario` |
| **ArrayList** | `List<Obstaculo>` em `MapaService` armazena qualquer subtipo |
| **Abstração** | `Obstaculo` é abstrata — não pode ser instanciada diretamente |

## ▶️ Como executar

**Pré-requisito:** Java JDK 11 ou superior instalado.

```bash
# 1. Clone o repositório
git clone https://github.com/cazaquedigital/ProjetoA3.git
cd ProjetoA3

# 2. Compile
javac -encoding UTF-8 -d out src/model/*.java src/service/*.java src/view/*.java

# 3. Execute
java -cp out view.Main
```

## 🔧 Funcionalidades do menu

1. **Adicionar obstáculo** — cadastra Degrau, Calçada Irregular ou Rampa Inexistente  
2. **Listar todos** — exibe todos os registros com detalhes  
3. **Buscar** — filtra por palavra-chave na localização ou descrição  
4. **Atualizar nível de perigo** — edita a criticidade de um registro (1–10)  
5. **Remover** — deleta um obstáculo pelo número  
6. **Estatísticas** — resumo por faixa de perigo (crítico / moderado / baixo)  

## 🔗 Links

- **Vídeo demonstrativo:** https://youtu.be/-PKtDVYXWf0
