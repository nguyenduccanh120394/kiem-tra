package dao;

import model.Category;
import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryDAO {
    List<Category> findAll () throws SQLException, ClassNotFoundException;
    Category findById(int id);
    void insert(Category category);
    boolean update(Category category);
    boolean delete(int id);
}
