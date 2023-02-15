package model.dao.impl;

import model.dao.BookDao;
import model.entities.Book;

import java.sql.Connection;
import java.util.List;

public class BookDaoJDBC implements BookDao {
    private Connection conn;

    public BookDaoJDBC(Connection conn){
        this.conn = conn;
    }

    public BookDaoJDBC() {
    }

    @Override
    public void insert(Book obj) {

    }

    @Override
    public void update(Book obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Book findById(Integer id) {
        return null;
    }

    @Override
    public List<Book> findAll() {
        return null;
    }
}
