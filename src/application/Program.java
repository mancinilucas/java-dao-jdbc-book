package application;

import model.entities.Book;

public class Program {
    public static void main(String[] args) {
        Book obj = new Book(1, "Livro do Desassossego", "Romance", "Fernando Pessoa", 1982);

        System.out.println(obj);
    }
}
