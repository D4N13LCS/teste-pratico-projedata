# 🧾 Projeto Java - Gestão de Funcionários

## 📌 Descrição

Este projeto foi desenvolvido como solução para um teste prático de programação em Java.
O objetivo é manipular uma lista de funcionários, aplicando conceitos de **Programação Orientada a Objetos**, **Streams**, **formatação de dados** e **boas práticas de organização de código**.

---

## 🛠️ Tecnologias utilizadas

* Java 8+
* API `java.time` (LocalDate, Period)
* `BigDecimal` para cálculos financeiros
* Streams (`stream`, `filter`, `sorted`)
* Leitura de arquivos com `Scanner`

---

## 📂 Estrutura do projeto

```
src/
├── entities/
│   ├── Pessoa.java
│   └── Funcionario.java
│
├── services/
│   ├── FuncionarioFileReader.java
│   └── FuncionarioService.java
│
└── Program.java
```

---

## 🧠 Conceitos aplicados

* Herança (`Funcionario` herda de `Pessoa`)
* Encapsulamento
* Separação de responsabilidades (Service, leitura de arquivo, execução)
* Manipulação de listas e coleções (`List`, `Map`)
* Programação funcional com Streams
* Formatação de datas e valores monetários

---

## 📥 Entrada de dados

Os dados dos funcionários são lidos a partir de um arquivo `.csv` com o seguinte formato:

```
Nome,DataNascimento,Salario,Funcao
```

### Exemplo:

```
Maria,18/10/2000,2009.44,Operador
João,12/05/1990,2284.38,Operador
```

---

## ⚙️ Funcionalidades implementadas

✔ Inserção de funcionários via arquivo CSV
✔ Remoção de funcionário por nome
✔ Listagem completa dos funcionários com formatação
✔ Aumento de salário em 10%
✔ Agrupamento por função (`Map<String, List<Funcionario>>`)
✔ Listagem de funcionários agrupados por função
✔ Filtro de aniversariantes (meses 10 e 12)
✔ Identificação do funcionário mais velho
✔ Ordenação alfabética
✔ Cálculo do total de salários
✔ Cálculo de quantos salários mínimos cada funcionário recebe

---

## 🖥️ Execução

1. Compile o projeto
2. Certifique-se de que o caminho do arquivo CSV está correto no `Program.java`
3. Execute a classe principal:

```bash
java Program
```

---

## 📊 Exemplo de saída

```
Lista de funcionários:

1 Maria 18/10/2000 2.009,44 Operador
...

Funcionário mais velho:
Nome: Caio
Idade: 64

Total salários: 48.000,00
```

---

## 👨‍💻 Autor

Daniel Cardoso
