package controller;

import dao.CategoryDAO;
import dao.ICategoryDAO;
import dao.IProductDAO;
import dao.ProductDAO;
import model.Category;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "Servletproducts", urlPatterns = "/products")
public class Servletproducts extends HttpServlet {
    private IProductDAO productDAO = new ProductDAO();
    private ICategoryDAO categoryDAO = new CategoryDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                showCreate(request,response);
                break;
            case "edit":
                showEdit(request,response);
                break;
            default:
                try {
                    showListProduct(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
    private void showListProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
        List<Product>products= productDAO.findAll();
        List<Category> categories = categoryDAO.findAll();
        request.setAttribute("categories",categories);
        request.setAttribute("products",products);
        RequestDispatcher dispatcher= request.getRequestDispatcher("product/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showCreate(HttpServletRequest request,HttpServletResponse response){
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showEdit(HttpServletRequest request,HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        Product product=productDAO.findById(id);
        request.setAttribute("product",product);
        RequestDispatcher dispatcher=request.getRequestDispatcher("product/edit.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                create(request,response);
                break;
            case "edit":
                try {
                    edit(request,response);
                    showListProduct(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                delete(request,response);
                break;
        }

    }
    private void create(HttpServletRequest request,HttpServletResponse response){
        String name = request.getParameter("name");
        int price =Integer.parseInt(request.getParameter("price"));
        int quantity =Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description =request.getParameter("description");
        int idCategory = Integer.parseInt(request.getParameter("idCategory"));
        Product product =new Product(name,price,quantity,color,description,idCategory);
        productDAO.insert(product);
    }
    private void edit(HttpServletRequest request,HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        Product product= productDAO.findById(id);
        productDAO.insert(product);
    }
    private  void delete(HttpServletRequest request,HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            productDAO.delete(id);
            showListProduct(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

