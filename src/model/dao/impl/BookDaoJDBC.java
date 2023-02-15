package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.BookDao;
import model.entities.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setGenre(rs.getString("genre"));
                book.setAutor(rs.getString("autor"));
                book.setReleaseYear(rs.getInt("release_year"));
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

    @Override
    public List<Book> findAll() {
        return null;
    }
}
