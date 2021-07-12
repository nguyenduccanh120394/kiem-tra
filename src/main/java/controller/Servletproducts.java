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

                break;
            case "edit":

                break;
            case "delete":

                break;
        }

    }
    private void create(HttpServletRequest request,HttpServletResponse response){
        String name = request.getParameter("name");


    }
}

