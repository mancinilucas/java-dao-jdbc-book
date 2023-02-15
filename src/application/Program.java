package application;

import model.dao.BookDao;
import model.dao.DaoFactory;
import model.entities.Book;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        BookDao bookDao = DaoFactory.createBookDao();

        System.out.println("===TESTE 1: Book findById ====");
        Book book = bookDao.findById(1);
        System.out.println(book);

        System.out.println("\n===TESTE 2: Book findAll ====");
        List<Book>list = bookDao.findAll();
        for(Book obj : list){
            System.out.println(obj);
        }

        System.out.println("\n===TESTE 3: Book insert ====");
        Book newBook = new Book(null, "Futuro Ancestral", "Ciencias Ambientais", "Ailton Krenak", 2022);
        bookDao.insert(newBook);
        System.out.println("Inserted! New Id = " + newBook.getId());


    }
}
