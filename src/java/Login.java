/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kamel
 */
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // JDBC driver name and database URL
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/RepairShopDB";

    //  Database credentials
    static final String USER = "Your user";
    static final String PASS = "Your password";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (isLoginValid(email, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("USER", email);
            response.sendRedirect("secure");
        } else {
            response.sendRedirect("login.html");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public boolean isLoginValid(String email, String pass) {
        boolean valid = false;
        try {
            //Loading and ligin a JDBC Driver
            Class.forName(JDBC_DRIVER);

            //Establishing a Connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Select statement to list if there is already user with specific email or not
            String sql = "SELECT Email, `Password` FROM Users WHERE Email = ? AND `Password` = md5(?);";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, email);
            pStmt.setString(2, pass);

            ResultSet rs = pStmt.executeQuery();

            if (rs.next()) {
                System.out.println("yes it is valid");
                valid = true;  // Existing user
            } else {
                
                System.out.println("no it is not valid");
                valid = false; // Not Existing user
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return valid;
    }

}
