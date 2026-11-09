# 🅿️ ParkEasy — Sistema de Estacionamento Inteligente

<p>
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />
  <img src="https://img.shields.io/badge/POO-Orientação%20a%20Objetos-blue?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Status-Concluído-success?style=for-the-badge" />
</p>

Sistema de gerenciamento de estacionamento desenvolvido em Java como exercício de **Programação Orientada a Objetos** (FIAP — 2° Ano SI).

---

## 📋 Funcionalidades

O sistema roda via terminal com um menu interativo de 5 opções:

```
#### Estacionamento ParkEasy ####
[1] Entrada de veículo
[2] Saída de veículo
[3] Imprimir veículos estacionados
[4] Imprimir a receita
[5] Finalizar
```

| Opção | Descrição |
|-------|-----------|
| `[1]` Entrada | Busca o veículo pela placa. Se não cadastrado, realiza o cadastro completo (marca, modelo, proprietário e CPF). Registra a hora de entrada no formato `HH:mm`. |
| `[2]` Saída | Localiza o veículo pela placa, registra a hora de saída e calcula automaticamente o valor da estadia. |
| `[3]` Estacionados | Lista as placas dos veículos que ainda estão no estacionamento (sem hora de saída). |
| `[4]` Receita | Soma e exibe a receita total acumulada de todas as saídas registradas. |
| `[5]` Finalizar | Encerra o sistema. |

---

## 🏗️ Estrutura do Projeto

```
ex05/
├── Main.java          → Lógica principal, menu e métodos estáticos
├── Veiculo.java       → Atributos: marca, modelo, placa, proprietário
├── Prorpietario.java  → Atributos: nome, CPF
└── Controle.java      → Registro de entrada/saída + cálculo da estadia
```

---

## 💡 Conceitos Aplicados

- **Arrays de objetos** — `Veiculo[10]` e `Controle[20]` para armazenar os registros
- **Múltiplas classes** — relacionamento entre `Veiculo`, `Prorpietario` e `Controle`
- **`LocalTime` + `Duration`** — cálculo preciso do tempo de permanência em minutos
- **`DecimalFormat`** — formatação do valor cobrado em R$
- **Loop `do-while`** com `switch` — controle de fluxo do menu
- **Busca linear** — pesquisa de veículo por placa nos arrays

---

## 💰 Cálculo da Estadia

```java
// Controle.java
LocalTime inicio = LocalTime.parse(horaEntrada); // "08:30"
LocalTime fim    = LocalTime.parse(horaSaida);   // "10:15"
long tempo       = Duration.between(inicio, fim).toMinutes(); // 105 min
double valor     = 0.75 * tempo;                 // R$ 78,75
```

**Tarifa:** R$ 0,75 por minuto de permanência.

---

## ▶️ Como Executar

1. Clone o repositório
2. Compile as classes dentro da pasta `ex05/`:
```bash
javac ex05/*.java
```
3. Execute a partir da raiz do projeto:
```bash
java ex05.Main
```

---

## 👨‍💻 Autor

**Felipe Slavic** · [github.com/felipedSlavic](https://github.com/felipedSlavic)  
