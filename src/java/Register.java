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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kamel
 */
public class Register extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            // YOU COULD DO HERE MORE SERVER-SIDE FORM VALIDATION OF DATA AS WELL LIKE WE DID IN THE ORIGINAL WEB PAGE USING JAVASCRIPT
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, inital-scale=1.0\">");
            out.println("<title>Kfix | New Register</title>");
            out.println("<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"images/kfix-icon.png\" />");
            out.println("<link rel=\"stylesheet\" href=\"css/style.css\">");
            out.println("<script type=\"text/javascript\" src=\"js/site.js\"></script>");
            out.println("</head>");
            out.println("<body>");

            //Loading and register a JDBC Driver
            Class.forName(JDBC_DRIVER);

            //Establishing a Connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Select statement to list if there is already user with specific email or not
            String sql1 = "SELECT Email FROM Users WHERE Email = ?;";
            PreparedStatement pStmt1 = conn.prepareStatement(sql1);
            pStmt1.setString(1, email);

            // Insert statment
            String sql2 = "INSERT INTO Users (FullName, Email, `Password`, "
                    + "CreationDateTime) VALUES (?, ?, md5(?), NOW());";
            PreparedStatement pStmt2 = conn.prepareStatement(sql2);
            pStmt2.setString(1, name);                     // 1 specifies the first parameter in the query  
            pStmt2.setString(2, email);             // 2 specifies the second parameter in the query
            pStmt2.setString(3, password);

            out.println("<div class=\"container\">");
            out.println("<div class=\"navbar\">");
            out.println("<div class=\"logo\">");
            out.println("<img src=\"images/kfix.png\" width=\"125px\">");
            out.println("</div>");
            out.println("<nav>");

            out.println("<ul id=\"MenuItems\">");
            out.println("<li><a href=\"index.html\">Home</a></li>");
            out.println("<li><a href=\"register.html\">Register</a></li>");
            out.println("<li><a href=\"login.html\">Login</a></li>");
            out.println("<li><a href=\"feedback.html\">Add Feedback</a></li>");
            out.println("</ul>");
            out.println("</nav>");
            out.println("<img src=\"images/cart.png\" alt=\"\" width=\"30px\" height=\"30px\">");
            out.println("<img src=\"images/menu.png\" class=\"menu-icon\" onclick=\"menutoggle();\">");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class=\"head-result\">");
            out.println("<div class=\"small-container\">");
            out.println("<div class=\"wrapper\">");
            out.println("<div class=\"title\">");
            out.println("Result");
            out.println("</div>");
            out.println("<div class=\"result\">");

            ResultSet rs = pStmt1.executeQuery();

            // True if there is a user registered with that email, else otherways
            if (rs.next()) {
                out.println("<img src=\"images/cross.png\" alt=\"\" width=\"80px\" height=\"80px\">");
                out.println("<p>This email address already exists!<br> Please provide another email address</p>");
            } else {
                int k = pStmt2.executeUpdate();     // returns number of affected row
                if (k == 1) {
                    //insert a record success
                    out.println("<img src=\"images/check.png\" alt=\"\" width=\"80px\" height=\"80px\">");
                    out.println("<p>Your Registration Done Successfuly</p>");
                } else { // i.e.  k = 0
                    //insert a record error
                    out.println("<img src=\"images/cross.png\" alt=\"\" width=\"80px\" height=\"80px\">");
                    out.println("<p>Your Registration Not Completed</p>");
                }
            }

            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class=\"footer\">");
            out.println("<div class=\"container\">");
            out.println("<div class=\"row\">");
            out.println("<div class=\"footer-col-1\">");
            out.println("<h3>Download Our App</h3>");
            out.println("<p>Download App for Android and ios mobile phone.</p>");
            out.println("<div class=\"app-logo\">");
            out.println("<img src=\"images/play-store.png\" alt=\"\">");
            out.println("<img src=\"images/app-store.png\" alt=\"\">");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class=\"footer-col-2\">");
            out.println("<img src=\"images/kfixref.png\" alt=\"\">");
            out.println("<p>Our purpose is to sustainably help people, and devices Accessories accessible to the many.</p>");
            out.println("</div>");
            out.println("<div class=\"footer-col-3\">");
            out.println("<h3>Useful Links</h3>");
            out.println("<ul>");
            out.println("<li>Coupons</li>");
            out.println("<li>Blog Post</li>");
            out.println("<li>Return Policy</li>");
            out.println("<li>Join Affiliate</li>");
            out.println("</ul>");
            out.println("</div>");
            out.println("<div class=\"footer-col-4\">");
            out.println("<h3>Follow us</h3>");
            out.println("<ul>");
            out.println("<li>Facebook</li>");
            out.println("<li>Twitter</li>");
            out.println("<li>Instagram</li>");
            out.println("<li>YouTube</li>");
            out.println("</ul>");
            out.println("</div>");
            out.println("</div>");
            out.println("<hr>");
            out.println("<p class=\"copyright\">Copyright 2021 - Kfix</p>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

        } catch (Exception ex) {
            throw new ServletException(ex);
        } finally {
            out.close();
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

}
