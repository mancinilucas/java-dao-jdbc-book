package model.dao;

import model.entities.Book;

import java.util.List;

public interface BookDao {
    void insert(Book obj);
    void update(Book obj);
    void deleteById(Integer id);
    Book findById(Integer id);
    List<Book>findAll();
}
