package dao;

import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements ICategoryDAO {
    SQLConnection sqlConnection = new SQLConnection();
    private final String FIN_BY_ID = "select * from category where id =?";
    private final String FIND_ALL = "select * from category";

    @Override
    public List<Category> findAll() throws SQLException, ClassNotFoundException {
    List<Category> categories = new ArrayList<>();
    Connection connection = sqlConnection.getConnection() ;
    PreparedStatement preparedStatement = connection.prepareStatement(FIN_BY_ID);
    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()){
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        Category category = new Category(id,name);
        categories.add(category);
    }
        return categories ;
    }

    @Override
    public Category findById(int id) {
        Category category = null;
        Connection connection;
        try {
            connection= sqlConnection.getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(FIN_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                category = new Category(id,name);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public void insert(Category category) {

    }

    @Override
    public boolean update(Category category) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
