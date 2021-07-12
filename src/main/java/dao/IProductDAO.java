package dao;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    List<Product> findAll () throws SQLException, ClassNotFoundException;
    Product findById(int id);
    void insert(Product product);
    boolean update(Product product) throws SQLException, ClassNotFoundException;
    boolean delete(int id) throws SQLException, ClassNotFoundException;
}
