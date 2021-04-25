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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kamel
 */
public class Secure extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        HttpSession session = request.getSession();

        String uemail = (String) session.getAttribute("USER");

        if (uemail != null) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try {
                out.println("<!DOCTYPE html>");
                out.println("<html lang=\"en\">");
                out.println("<head>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("<meta name=\"viewport\" content=\"width=device-width, inital-scale=1.0\">");
                out.println("<title>Kfix | Repair Shop</title>");
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

                out.println("<div class=\"open\">");
                out.println("<div class=\"small-container\">");
                out.println("<div class=\"row\">");
                out.println("<div class=\"col-2\">");
                out.println("<h1>Give Your Device<br> A Fresh Start!</h1>");
                out.println("<p>We all make mistakes, but what matters is<br> how we go back and fix them.</p>");
                out.println("<a href=\"\" class=\"btn\">Fix Now &#8594; </a>");
                out.println("</div>");
                out.println("<div class=\"col-2\">");
                out.println("<img src=\"images/iphone.png\">");
                out.println("</div>");
                out.println("</div>");
                out.println("</div>");
                out.println("</div>");
                out.println("<div class=\"categories\">");
                out.println("<div class=\"small-container\">");
                out.println("<h2 class=\"title\">Categories</h2>");
                out.println("<div class=\"row\">");
                out.println("<div class=\"col-3\">");
                out.println("<img src=\"images/broken-laptop.jpg\" alt=\"\">");
                out.println("<h4>Laptop</h4>");
                out.println("</div>");
                out.println("<div class=\"col-3\">");
                out.println("<img src=\"images/broken-tablet.jpg\" alt=\"\">");
                out.println("<h4>Tablet</h4>");
                out.println("</div>");
                out.println("<div class=\"col-3\">");
                out.println("<img src=\"images/broken-pc.jpg\" alt=\"\">");
                out.println("<h4>Desktop Computer</h4>");
                out.println("</div>");
                out.println("</div>");
                out.println("</div>");
                out.println("</div>");
                out.println("<div class=\"offer\">");
                out.println("<div class=\"small-container\">");
                out.println("<div class=\"row\">");
                out.println("<div class=\"col-2\">");
                out.println("<img src=\"images/exclusive.png\" alt=\"\" class=\"offer-img\">");
                out.println("</div>");
                out.println("<div class=\"col-2\">");
                out.println("<p>Exclusively Avilable on Shop</p>");
                out.println("<h1>Screwdriver Kit</h1>");
                out.println("<small>");
                out.println("Ideal for fastening screws, and\n"
                        + "compact in size and easy to carry\n"
                        + "with Ergonomic handles provide super grip.<br>");
                out.println("</small>");
                out.println("<a href=\"\" class=\"btn\">Buy Now &#8594;</a>");
                out.println("</div>");
                out.println("</div>");
                out.println("</div>");
                out.println("</div>");
                out.println("<div class=\"review\">");
                out.println("<div class=\"small-container\">");
                out.println("<h2 class=\"title\">Reviews</h2>");
                out.println("<div class=\"row\">");
                out.println("<div class=\"col-3\">");
                out.println("<p>This websit really did help me to fix my broken phone, and it took me\n"
                        + "only 15 minutes to fix it.</p>");
                out.println("<img src=\"images/griezmann.jfif.png\" alt=\"\">");
                out.println("<h3>Antoine Griezmann</h3>");
                out.println("</div>");
                out.println("<div class=\"col-3\">");
                out.println("<p>I always fix my laptop with this application,\n"
                        + "they also have app for both platform android and ios.</p>");
                out.println("<img src=\"images/thiago.jpg\" alt=\"\">");
                out.println("<h3>Thiago Alcantara</h3>");
                out.println("</div>");
                out.println("<div class=\"col-3\">");
                out.println("<p>Great application for those who wants to fix their Phones, Laptops or even Tablets, well done guys</p>");
                out.println("<img src=\"images/salah.jpg\" alt=\"\">");
                out.println("<h3>Mohamed Salah</h3>");
                out.println("</div>");
                out.println("</div>");
                out.println("</div>");
                out.println("</div>");
                out.println("<div class=\"brands\">");
                out.println("<div class=\"small-container\">");
                out.println("<div class=\"row\">");
                out.println("<div class=\"col-5\">");
                out.println("<img src=\"images/logo-oppo.png\" alt=\"\">");
                out.println("</div>");
                out.println("<div class=\"col-5\">");
                out.println("<img src=\"images/logo-paypal.png\" alt=\"\">");
                out.println("</div>");
                out.println("<div class=\"col-5\">");
                out.println("<img src=\"images/logo-huawei.png\" alt=\"\">");
                out.println("</div>");
                out.println("<div class=\"col-5\">");
                out.println("<img src=\"images/logo-samsung.png\" alt=\"\">");
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
        } else {
            response.sendRedirect("index.html");
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
        processRequest(request, response);
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
