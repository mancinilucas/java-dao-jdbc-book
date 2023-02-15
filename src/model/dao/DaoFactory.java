package model.dao;

import db.DB;
import model.dao.impl.BookDaoJDBC;

public class DaoFactory {
    public static BookDao createBookDao(){
        return new BookDaoJDBC(DB.getConnection());
        }
    }
