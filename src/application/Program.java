package application;

import model.dao.BookDao;
import model.dao.DaoFactory;
import model.entities.Book;

public class Program {
    public static void main(String[] args) {
        BookDao bookDao = DaoFactory.createBookDao();

        Book book = bookDao.findById(1);

        System.out.println(book);
    }
}
