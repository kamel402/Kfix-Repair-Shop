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
import javax.servlet.http.HttpSession;

/**
 *
 * @author kamel
 */
public class AllRepairs extends HttpServlet {

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
        
        HttpSession session = request.getSession();

        String uemail = (String) session.getAttribute("USER");
        
        if(uemail != null){
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            // YOU COULD DO HERE MORE SERVER-SIDE FORM VALIDATION OF DATA AS WELL LIKE WE DID IN THE ORIGINAL WEB PAGE USING JAVASCRIPT
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, inital-scale=1.0\">");
            out.println("<title>All Repairs</title>");
            out.println("<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"images/kfix-icon.png\" />");
            out.println("<link rel=\"stylesheet\" href=\"css/style.css\">");
            out.println("<script type=\"text/javascript\" src=\"js/site.js\"></script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container\">");
            out.println("<div class=\"navbar\">");
            out.println("<div class=\"logo\">");
            out.println("<img src=\"images/kfix.png\" width=\"125px\">");
            out.println("</div>");
            out.println("<nav>");
            out.println("<ul id=\"MenuItems\">");
            out.println("<li><a href=\"secure\">Home</a></li>");
            out.println(" <li><a href=\"newRepair\">Add New Repair Request</a></li>");
            out.println("<li><a href=\"allRepairs\">Browse All Repair Records</a></li>");
            out.println("<li><a href=\"logout\">Logout</a></li>");
            out.println("<li><a href=\"feedback\">Add Feedback</a></li>");
            out.println("</ul>");
            out.println("</nav>");
            out.println("<img src=\"images/cart.png\" alt=\"\" width=\"30px\" height=\"30px\">");
            out.println("<img src=\"images/menu.png\" class=\"menu-icon\" onclick=\"menutoggle();\">");
            out.println("</div>");
            out.println("</div>");

            out.println("<div class=\"new-repair\">");
            out.println("<div class=\"container\">");
            out.println("<div class=\"title\">");
            out.println("All Repairs");
            out.println("</div>");
            out.println("<div class=\"table-responsive\">");
            //Loading and register a JDBC Driver
            Class.forName(JDBC_DRIVER);

            //Establishing a Connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "select * from Repairs";

            PreparedStatement pStmt = conn.prepareStatement(sql);
            ResultSet rs = pStmt.executeQuery();

            if (!rs.isBeforeFirst()) {

            } else {
                
                
                out.println("<table>");
                out.println("<tr id=\"tableHeader\">");
                out.println("<th>ID</th>");
                out.println("<th>Owner</th>");
                out.println("<th>SerialNumber</th>");
                out.println("<th>Type</th>");
                out.println("<th>Model</th>");
                out.println("<th>MemoryGB</th>");
                out.println("<th>HardDeskGB</th>");
                out.println("<th>Problems</th>");
                out.println("<th>Cost</th>");
                out.println("<th>Status</th>");
                out.println("<th>FinishDateTime</th>");
                out.println("<th>DeliveryDateTime</th>");
                out.println("</tr>");

                while (rs.next()) {
                    out.println("<tr class=\"tableRow\">");

                    out.println(" <td>" + rs.getInt("RepairID") + " </td> ");
                    out.println(" <td>" + rs.getString("ComputerOwner") + " </td> ");
                    out.println(" <td>" + rs.getString("ComputerSerialNumber") + " </td> ");
                    out.println(" <td>" + rs.getString("Type") + " </td> ");
                    out.println(" <td>" + rs.getString("Model") + " </td> ");
                    out.println(" <td>" + rs.getInt("MemoryGB") + " </td> ");
                    out.println(" <td>" + rs.getInt("HardDeskGB") + " </td> ");
                    out.println(" <td>" + rs.getString("Problems") + " </td> ");
                    out.println(" <td>" + rs.getFloat("RepairCost") + " </td> ");
                    out.println(" <td>" + rs.getString("RepairStatus") + " </td> ");
                    out.println(" <td>" + rs.getTimestamp("RepairFinishDateTime") + " </td> ");
                    out.println(" <td>" + rs.getTimestamp("RepairDeliveryDateTime") + " </td> ");

                    out.println("</tr>");

                }

                out.println("</table>");
                
            }
            
        } catch (Exception ex) {
            //throw new ServletException(ex);
            out.println("There was an error exception meesage: ");

        } finally {
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
            out.close();
        }

    }else{
            response.sendRedirect("login.html");
        }
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

//
    }

    //public java.sql.Date getCurrentDatetime() {
    //    java.util.Date today = new java.util.Date();
    //    return new java.sql.Date(today.getTime());
    //}
}
