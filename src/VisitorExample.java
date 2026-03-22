package com.example.visitor;

// Interface Visitor - Declara métodos para cada tipo de produto
interface TaxVisitor {
 void visit(Book book);
 void visit(Food food);
 void visit(Electronics electronics);
 double getTaxAmount();
}

// Element Interface - Produtos aceitam visitantes
interface Product {
 void accept(TaxVisitor visitor);
 double getPrice();
 String getName();
}

// Concrete Elements - Implementam accept() chamando visit()
class Book implements Product {
 private double price;
 private String name;
 
 public Book(double price, String name) {
 this.price = price;
 this.name = name;
 }
 
 @Override
 public void accept(TaxVisitor visitor) {
 visitor.visit(this); // Double dispatch: this é Book
 }
 
 @Override
 public double getPrice() { return price; }
 @Override
 public String getName() { return name; }
}

class Food implements Product {
 private double price;
 private String name;
 
 public Food(double price, String name) {
 this.price = price;
 this.name = name;
 }
 
 @Override
 public void accept(TaxVisitor visitor) {
 visitor.visit(this);
 }
 
 @Override
 public double getPrice() { return price; }
 @Override
 public String getName() { return name; }
}

class Electronics implements Product {
 private double price;
 private String name;
 
 public Electronics(double price, String name) {
 this.price = price;
 this.name = name;
 }
 
 @Override
 public void accept(TaxVisitor visitor) {
 visitor.visit(this);
 }
 
 @Override
 public double getPrice() { return price; }
 @Override
 public String getName() { return name; }
}

// Concrete Visitor - Implementa cálculo de impostos
class TaxCalculatorVisitor implements TaxVisitor {
 private double taxAmount = 0;
 
 @Override
 public void visit(Book book) {
 // Livros têm 5% de imposto
 taxAmount += book.getPrice() * 0.05;
 System.out.println("Livro: " + book.getName() + 
 " - Imposto: R$" + 
 String.format("%.2f", book.getPrice() * 0.05));
 }
 
 @Override
 public void visit(Food food) {
 // Alimentos têm 0% de imposto
 System.out.println("Alimento: " + food.getName() + 
 " - Imposto: R$0.00");
 }
 
 @Override
 public void visit(Electronics electronics) {
 // Eletrônicos têm 15% de imposto
 taxAmount += electronics.getPrice() * 0.15;
 System.out.println("Eletrônico: " + electronics.getName() + 
 " - Imposto: R$" + 
 String.format("%.2f", electronics.getPrice() * 0.15));
 }
 
 @Override
 public double getTaxAmount() {
 return taxAmount;
 }
}

// Cliente - Executa o padrão
public class VisitorExample {
 public static void main(String[] args) {
 // Cria produtos
 Product book = new Book(50.0, "Design Patterns");
 Product food = new Food(30.0, "Arroz");
 Product electronics = new Electronics(1000.0, "Laptop");
 
 // Cria visitor
 TaxVisitor taxCalculator = new TaxCalculatorVisitor();
 
 // Cada produto aceita o visitor
 book.accept(taxCalculator);
 food.accept(taxCalculator);
 electronics.accept(taxCalculator);
 
 // Exibe resultado total
 System.out.println("\nImposto Total: R$" + 
 String.format("%.2f", taxCalculator.getTaxAmount()));
 }
}
