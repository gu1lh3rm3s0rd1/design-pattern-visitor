# design-pattern-visitor

Este projeto demonstra a implementação do padrão de projeto **Visitor**, conforme descrito no livro *Design Patterns (GoF)*.

## 📌 Objetivo

Demonstrar como separar algoritmos da estrutura de objetos, permitindo adicionar novas operações sem modificar as classes existentes.

## 🧠 Conceito

O padrão Visitor permite definir novas operações sobre uma estrutura de objetos sem alterar as classes desses objetos.

## 🏗️ Estrutura

- **Visitor (TaxVisitor)** → Interface com métodos `visit`
- **ConcreteVisitor (TaxCalculatorVisitor)** → Implementa regras de negócio
- **Element (Product)** → Interface com método `accept`
- **ConcreteElements (Book, Food, Electronics)** → Chamam o visitor

## 🔁 Double Dispatch

O método `accept()` chama `visitor.visit(this)`, permitindo que o método correto seja escolhido em tempo de execução.

## 💡 Exemplo

O sistema calcula impostos para diferentes tipos de produtos:

- Livros → 5%
- Alimentos → 0%
- Eletrônicos → 15%

## ▶️ Execução

```bash
javac VisitorExample.java
java VisitorExample