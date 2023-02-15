package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.BookDao;
import model.entities.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                    "SELECT books.* "
                            + "FROM books "
                            + "WHERE books.id = ?"

            );
            st.setInt(1, id);
            rs = st.executeQuery();
            if(rs.next()){
                Book book = instantiateBook(rs);
                return book;
            }
            return null;
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    private Book instantiateBook(ResultSet rs)throws SQLException{
        Book book = new Book();
        book.setId(rs.getInt("id"));
        book.setTitle(rs.getString("title"));
        book.setGenre(rs.getString("genre"));
        book.setAutor(rs.getString("autor"));
        book.setReleaseYear(rs.getInt("release_year"));
        return book;
    }

    @Override
    public List<Book> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                    "SELECT books.* "
                    + "FROM books "
                    + "ORDER BY title"
            );
            rs = st.executeQuery();
            List<Book>list = new ArrayList<>();

            while(rs.next()){
                Book book = instantiateBook(rs);
                list.add(book);
            }
            return list;
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }


}
