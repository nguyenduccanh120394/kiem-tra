package dao;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO{
    SQLConnection sqlConnection = new SQLConnection();

private final String SELECT_ALL = "select * from product";
private final String SELECT_BY_ID = "select * from product where id =?";
private final String ADD = "insert into product (name,price,quantity,color,description,idCategory)";
private final String DELETE = "delete from product where id = ?;";
private static final String UPDATE_SQL = "update product set name = ?,price= ?, quantity =?, color =?,description=?,idCategory=? where id = ?;";


    @Override
    public List<Product> findAll() throws SQLException, ClassNotFoundException {
        List<Product>products= new ArrayList<>();
        Connection connection = sqlConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name= resultSet.getString("name");
            int price = resultSet.getInt("price");
            int quantity=resultSet.getInt("quantity");
            String color = resultSet.getString("color");
            String description= resultSet.getString("description");
            int idCategory = resultSet.getInt("idCategory");
            Product product = new Product(id,name,price,quantity,color,description,idCategory);
            products.add(product);
        }
        return products;
    }

    @Override
    public Product findById(int id) {
      Product product = null;
        Connection connection ;
        try {
            connection = sqlConnection.getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                int idCategory = resultSet.getInt("idCategory");
                product = new Product(id,name,price,quantity,color,description,idCategory);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void insert(Product product) {
        Connection connection;
        try {
           connection = sqlConnection.getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement(ADD);
           preparedStatement.setString(1, product.getName());
           preparedStatement.setInt(2,product.getPrice());
           preparedStatement.setInt(3,product.getQuantity());
           preparedStatement.setString(4,product.getColor());
           preparedStatement.setString(5,product.getDescription());
           preparedStatement.setInt(6,product.getIdCategory());
           preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean update(Product product) throws SQLException, ClassNotFoundException {
    boolean rowUpdate;
    Connection connection = sqlConnection.getConnection();
    PreparedStatement preparedStatement =connection.prepareStatement(UPDATE_SQL);
    preparedStatement.setString(1,product.getName());
    preparedStatement.setInt(2,product.getPrice());
    preparedStatement.setInt(3,product.getQuantity());
    preparedStatement.setString(4,product.getColor());
    preparedStatement.setString(5,product.getDescription());
    preparedStatement.setInt(6,product.getIdCategory());
    preparedStatement.setInt(7,product.getId());
    rowUpdate=preparedStatement.executeUpdate()>0;
    return rowUpdate;
    }

    @Override
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        boolean rowDelete;
        Connection connection = sqlConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        rowDelete = preparedStatement.executeUpdate() > 0;
        return rowDelete;
    }
}
