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
public class Feedback extends HttpServlet {

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
                out.println("<title>Kfix | Feedback</title>");
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
                out.println("<div class=\"small-container\">");
                out.println("<div class=\"wrapper\">");
                out.println("<div class=\"title\">");
                out.println("Add Feedback");
                out.println("</div>");
                out.println("<form action=\"feedback\" method=\"post\" class=\"form\" onsubmit=\"return validateFeedback();\">");
                out.println("<div class=\"inputfield\">");
                out.println("<label>Name</label>");
                out.println("<input type=\"text\" class=\"input\" id=\"name\" name=\"name\">");
                out.println("</div>");
                out.println("<div class=\"inputfield\">");
                out.println("<label>Country</label>");
                out.println("<div class=\"custom_select\">");
                out.println("<select id=\"country\" name=\"country\">");
                out.println("<option value=\"Select One Country\">Select One Country</option>\n" +
"                                <option value=\"Afghanistan\">Afghanistan</option>\n" +
"                                <option value=\"Åland Islands\">Åland Islands</option>\n" +
"                                <option value=\"Albania\">Albania</option>\n" +
"                                <option value=\"Algeria\">Algeria</option>\n" +
"                                <option value=\"American Samoa\">American Samoa</option>\n" +
"                                <option value=\"Andorra\">Andorra</option>\n" +
"                                <option value=\"Angola\">Angola</option>\n" +
"                                <option value=\"Anguilla\">Anguilla</option>\n" +
"                                <option value=\"Antarctica\">Antarctica</option>\n" +
"                                <option value=\"Antigua and Barbuda\">Antigua and Barbuda</option>\n" +
"                                <option value=\"Argentina\">Argentina</option>\n" +
"                                <option value=\"Armenia\">Armenia</option>\n" +
"                                <option value=\"Aruba\">Aruba</option>\n" +
"                                <option value=\"Australia\">Australia</option>\n" +
"                                <option value=\"Austria\">Austria</option>\n" +
"                                <option value=\"Azerbaijan\">Azerbaijan</option>\n" +
"                                <option value=\"Bahamas\">Bahamas</option>\n" +
"                                <option value=\"Bahrain\">Bahrain</option>\n" +
"                                <option value=\"Bangladesh\">Bangladesh</option>\n" +
"                                <option value=\"Barbados\">Barbados</option>\n" +
"                                <option value=\"Belarus\">Belarus</option>\n" +
"                                <option value=\"Belgium\">Belgium</option>\n" +
"                                <option value=\"Belize\">Belize</option>\n" +
"                                <option value=\"Benin\">Benin</option>\n" +
"                                <option value=\"Bermuda\">Bermuda</option>\n" +
"                                <option value=\"Bhutan\">Bhutan</option>\n" +
"                                <option value=\"Bolivia\">Bolivia</option>\n" +
"                                <option value=\"Bosnia and Herzegovina\">Bosnia and Herzegovina</option>\n" +
"                                <option value=\"Botswana\">Botswana</option>\n" +
"                                <option value=\"Bouvet Island\">Bouvet Island</option>\n" +
"                                <option value=\"Brazil\">Brazil</option>\n" +
"                                <option value=\"British Indian Ocean Territory\">British Indian Ocean Territory</option>\n" +
"                                <option value=\"Brunei Darussalam\">Brunei Darussalam</option>\n" +
"                                <option value=\"Bulgaria\">Bulgaria</option>\n" +
"                                <option value=\"Burkina Faso\">Burkina Faso</option>\n" +
"                                <option value=\"Burundi\">Burundi</option>\n" +
"                                <option value=\"Cambodia\">Cambodia</option>\n" +
"                                <option value=\"Cameroon\">Cameroon</option>\n" +
"                                <option value=\"Canada\">Canada</option>\n" +
"                                <option value=\"Cape Verde\">Cape Verde</option>\n" +
"                                <option value=\"Cayman Islands\">Cayman Islands</option>\n" +
"                                <option value=\"Central African Republic\">Central African Republic</option>\n" +
"                                <option value=\"Chad\">Chad</option>\n" +
"                                <option value=\"Chile\">Chile</option>\n" +
"                                <option value=\"China\">China</option>\n" +
"                                <option value=\"Christmas Island\">Christmas Island</option>\n" +
"                                <option value=\"Cocos (Keeling) Islands\">Cocos (Keeling) Islands</option>\n" +
"                                <option value=\"Colombia\">Colombia</option>\n" +
"                                <option value=\"Comoros\">Comoros</option>\n" +
"                                <option value=\"Congo\">Congo</option>\n" +
"                                <option value=\"Congo, The Democratic Republic of The\">Congo, The Democratic Republic of\n" +
"                                    The</option>\n" +
"                                <option value=\"Cook Islands\">Cook Islands</option>\n" +
"                                <option value=\"Costa Rica\">Costa Rica</option>\n" +
"                                <option value=\"Cote D'ivoire\">Cote D'ivoire</option>\n" +
"                                <option value=\"Croatia\">Croatia</option>\n" +
"                                <option value=\"Cuba\">Cuba</option>\n" +
"                                <option value=\"Cyprus\">Cyprus</option>\n" +
"                                <option value=\"Czech Republic\">Czech Republic</option>\n" +
"                                <option value=\"Denmark\">Denmark</option>\n" +
"                                <option value=\"Djibouti\">Djibouti</option>\n" +
"                                <option value=\"Dominica\">Dominica</option>\n" +
"                                <option value=\"Dominican Republic\">Dominican Republic</option>\n" +
"                                <option value=\"Ecuador\">Ecuador</option>\n" +
"                                <option value=\"Egypt\">Egypt</option>\n" +
"                                <option value=\"El Salvador\">El Salvador</option>\n" +
"                                <option value=\"Equatorial Guinea\">Equatorial Guinea</option>\n" +
"                                <option value=\"Eritrea\">Eritrea</option>\n" +
"                                <option value=\"Estonia\">Estonia</option>\n" +
"                                <option value=\"Ethiopia\">Ethiopia</option>\n" +
"                                <option value=\"Falkland Islands (Malvinas)\">Falkland Islands (Malvinas)</option>\n" +
"                                <option value=\"Faroe Islands\">Faroe Islands</option>\n" +
"                                <option value=\"Fiji\">Fiji</option>\n" +
"                                <option value=\"Finland\">Finland</option>\n" +
"                                <option value=\"France\">France</option>\n" +
"                                <option value=\"French Guiana\">French Guiana</option>\n" +
"                                <option value=\"French Polynesia\">French Polynesia</option>\n" +
"                                <option value=\"French Southern Territories\">French Southern Territories</option>\n" +
"                                <option value=\"Gabon\">Gabon</option>\n" +
"                                <option value=\"Gambia\">Gambia</option>\n" +
"                                <option value=\"Georgia\">Georgia</option>\n" +
"                                <option value=\"Germany\">Germany</option>\n" +
"                                <option value=\"Ghana\">Ghana</option>\n" +
"                                <option value=\"Gibraltar\">Gibraltar</option>\n" +
"                                <option value=\"Greece\">Greece</option>\n" +
"                                <option value=\"Greenland\">Greenland</option>\n" +
"                                <option value=\"Grenada\">Grenada</option>\n" +
"                                <option value=\"Guadeloupe\">Guadeloupe</option>\n" +
"                                <option value=\"Guam\">Guam</option>\n" +
"                                <option value=\"Guatemala\">Guatemala</option>\n" +
"                                <option value=\"Guernsey\">Guernsey</option>\n" +
"                                <option value=\"Guinea\">Guinea</option>\n" +
"                                <option value=\"Guinea-bissau\">Guinea-bissau</option>\n" +
"                                <option value=\"Guyana\">Guyana</option>\n" +
"                                <option value=\"Haiti\">Haiti</option>\n" +
"                                <option value=\"Heard Island and Mcdonald Islands\">Heard Island and Mcdonald Islands\n" +
"                                </option>\n" +
"                                <option value=\"Holy See (Vatican City State)\">Holy See (Vatican City State)</option>\n" +
"                                <option value=\"Honduras\">Honduras</option>\n" +
"                                <option value=\"Hong Kong\">Hong Kong</option>\n" +
"                                <option value=\"Hungary\">Hungary</option>\n" +
"                                <option value=\"Iceland\">Iceland</option>\n" +
"                                <option value=\"India\">India</option>\n" +
"                                <option value=\"Indonesia\">Indonesia</option>\n" +
"                                <option value=\"Iran, Islamic Republic of\">Iran, Islamic Republic of</option>\n" +
"                                <option value=\"Iraq\">Iraq</option>\n" +
"                                <option value=\"Ireland\">Ireland</option>\n" +
"                                <option value=\"Isle of Man\">Isle of Man</option>\n" +
"                                <option value=\"Israel\">Israel</option>\n" +
"                                <option value=\"Italy\">Italy</option>\n" +
"                                <option value=\"Jamaica\">Jamaica</option>\n" +
"                                <option value=\"Japan\">Japan</option>\n" +
"                                <option value=\"Jersey\">Jersey</option>\n" +
"                                <option value=\"Jordan\">Jordan</option>\n" +
"                                <option value=\"Kazakhstan\">Kazakhstan</option>\n" +
"                                <option value=\"Kenya\">Kenya</option>\n" +
"                                <option value=\"Kiribati\">Kiribati</option>\n" +
"                                <option value=\"Korea, Democratic People's Republic of\">Korea, Democratic People's\n" +
"                                    Republic of</option>\n" +
"                                <option value=\"Korea, Republic of\">Korea, Republic of</option>\n" +
"                                <option value=\"Kuwait\">Kuwait</option>\n" +
"                                <option value=\"Kyrgyzstan\">Kyrgyzstan</option>\n" +
"                                <option value=\"Lao People's Democratic Republic\">Lao People's Democratic Republic\n" +
"                                </option>\n" +
"                                <option value=\"Latvia\">Latvia</option>\n" +
"                                <option value=\"Lebanon\">Lebanon</option>\n" +
"                                <option value=\"Lesotho\">Lesotho</option>\n" +
"                                <option value=\"Liberia\">Liberia</option>\n" +
"                                <option value=\"Libyan Arab Jamahiriya\">Libyan Arab Jamahiriya</option>\n" +
"                                <option value=\"Liechtenstein\">Liechtenstein</option>\n" +
"                                <option value=\"Lithuania\">Lithuania</option>\n" +
"                                <option value=\"Luxembourg\">Luxembourg</option>\n" +
"                                <option value=\"Macao\">Macao</option>\n" +
"                                <option value=\"Macedonia, The Former Yugoslav Republic of\">Macedonia, The Former\n" +
"                                    Yugoslav Republic of</option>\n" +
"                                <option value=\"Madagascar\">Madagascar</option>\n" +
"                                <option value=\"Malawi\">Malawi</option>\n" +
"                                <option value=\"Malaysia\">Malaysia</option>\n" +
"                                <option value=\"Maldives\">Maldives</option>\n" +
"                                <option value=\"Mali\">Mali</option>\n" +
"                                <option value=\"Malta\">Malta</option>\n" +
"                                <option value=\"Marshall Islands\">Marshall Islands</option>\n" +
"                                <option value=\"Martinique\">Martinique</option>\n" +
"                                <option value=\"Mauritania\">Mauritania</option>\n" +
"                                <option value=\"Mauritius\">Mauritius</option>\n" +
"                                <option value=\"Mayotte\">Mayotte</option>\n" +
"                                <option value=\"Mexico\">Mexico</option>\n" +
"                                <option value=\"Micronesia, Federated States of\">Micronesia, Federated States of</option>\n" +
"                                <option value=\"Moldova, Republic of\">Moldova, Republic of</option>\n" +
"                                <option value=\"Monaco\">Monaco</option>\n" +
"                                <option value=\"Mongolia\">Mongolia</option>\n" +
"                                <option value=\"Montenegro\">Montenegro</option>\n" +
"                                <option value=\"Montserrat\">Montserrat</option>\n" +
"                                <option value=\"Morocco\">Morocco</option>\n" +
"                                <option value=\"Mozambique\">Mozambique</option>\n" +
"                                <option value=\"Myanmar\">Myanmar</option>\n" +
"                                <option value=\"Namibia\">Namibia</option>\n" +
"                                <option value=\"Nauru\">Nauru</option>\n" +
"                                <option value=\"Nepal\">Nepal</option>\n" +
"                                <option value=\"Netherlands\">Netherlands</option>\n" +
"                                <option value=\"Netherlands Antilles\">Netherlands Antilles</option>\n" +
"                                <option value=\"New Caledonia\">New Caledonia</option>\n" +
"                                <option value=\"New Zealand\">New Zealand</option>\n" +
"                                <option value=\"Nicaragua\">Nicaragua</option>\n" +
"                                <option value=\"Niger\">Niger</option>\n" +
"                                <option value=\"Nigeria\">Nigeria</option>\n" +
"                                <option value=\"Niue\">Niue</option>\n" +
"                                <option value=\"Norfolk Island\">Norfolk Island</option>\n" +
"                                <option value=\"Northern Mariana Islands\">Northern Mariana Islands</option>\n" +
"                                <option value=\"Norway\">Norway</option>\n" +
"                                <option value=\"Oman\">Oman</option>\n" +
"                                <option value=\"Pakistan\">Pakistan</option>\n" +
"                                <option value=\"Palau\">Palau</option>\n" +
"                                <option value=\"Palestinian Territory, Occupied\">Palestinian Territory, Occupied</option>\n" +
"                                <option value=\"Panama\">Panama</option>\n" +
"                                <option value=\"Papua New Guinea\">Papua New Guinea</option>\n" +
"                                <option value=\"Paraguay\">Paraguay</option>\n" +
"                                <option value=\"Peru\">Peru</option>\n" +
"                                <option value=\"Philippines\">Philippines</option>\n" +
"                                <option value=\"Pitcairn\">Pitcairn</option>\n" +
"                                <option value=\"Poland\">Poland</option>\n" +
"                                <option value=\"Portugal\">Portugal</option>\n" +
"                                <option value=\"Puerto Rico\">Puerto Rico</option>\n" +
"                                <option value=\"Qatar\">Qatar</option>\n" +
"                                <option value=\"Reunion\">Reunion</option>\n" +
"                                <option value=\"Romania\">Romania</option>\n" +
"                                <option value=\"Russian Federation\">Russian Federation</option>\n" +
"                                <option value=\"Rwanda\">Rwanda</option>\n" +
"                                <option value=\"Saint Helena\">Saint Helena</option>\n" +
"                                <option value=\"Saint Kitts and Nevis\">Saint Kitts and Nevis</option>\n" +
"                                <option value=\"Saint Lucia\">Saint Lucia</option>\n" +
"                                <option value=\"Saint Pierre and Miquelon\">Saint Pierre and Miquelon</option>\n" +
"                                <option value=\"Saint Vincent and The Grenadines\">Saint Vincent and The Grenadines\n" +
"                                </option>\n" +
"                                <option value=\"Samoa\">Samoa</option>\n" +
"                                <option value=\"San Marino\">San Marino</option>\n" +
"                                <option value=\"Sao Tome and Principe\">Sao Tome and Principe</option>\n" +
"                                <option value=\"Saudi Arabia\">Saudi Arabia</option>\n" +
"                                <option value=\"Senegal\">Senegal</option>\n" +
"                                <option value=\"Serbia\">Serbia</option>\n" +
"                                <option value=\"Seychelles\">Seychelles</option>\n" +
"                                <option value=\"Sierra Leone\">Sierra Leone</option>\n" +
"                                <option value=\"Singapore\">Singapore</option>\n" +
"                                <option value=\"Slovakia\">Slovakia</option>\n" +
"                                <option value=\"Slovenia\">Slovenia</option>\n" +
"                                <option value=\"Solomon Islands\">Solomon Islands</option>\n" +
"                                <option value=\"Somalia\">Somalia</option>\n" +
"                                <option value=\"South Africa\">South Africa</option>\n" +
"                                <option value=\"South Georgia and The South Sandwich Islands\">South Georgia and The South\n" +
"                                    Sandwich Islands</option>\n" +
"                                <option value=\"Spain\">Spain</option>\n" +
"                                <option value=\"Sri Lanka\">Sri Lanka</option>\n" +
"                                <option value=\"Sudan\">Sudan</option>\n" +
"                                <option value=\"Suriname\">Suriname</option>\n" +
"                                <option value=\"Svalbard and Jan Mayen\">Svalbard and Jan Mayen</option>\n" +
"                                <option value=\"Swaziland\">Swaziland</option>\n" +
"                                <option value=\"Sweden\">Sweden</option>\n" +
"                                <option value=\"Switzerland\">Switzerland</option>\n" +
"                                <option value=\"Syrian Arab Republic\">Syrian Arab Republic</option>\n" +
"                                <option value=\"Taiwan, Province of China\">Taiwan, Province of China</option>\n" +
"                                <option value=\"Tajikistan\">Tajikistan</option>\n" +
"                                <option value=\"Tanzania, United Republic of\">Tanzania, United Republic of</option>\n" +
"                                <option value=\"Thailand\">Thailand</option>\n" +
"                                <option value=\"Timor-leste\">Timor-leste</option>\n" +
"                                <option value=\"Togo\">Togo</option>\n" +
"                                <option value=\"Tokelau\">Tokelau</option>\n" +
"                                <option value=\"Tonga\">Tonga</option>\n" +
"                                <option value=\"Trinidad and Tobago\">Trinidad and Tobago</option>\n" +
"                                <option value=\"Tunisia\">Tunisia</option>\n" +
"                                <option value=\"Turkey\">Turkey</option>\n" +
"                                <option value=\"Turkmenistan\">Turkmenistan</option>\n" +
"                                <option value=\"Turks and Caicos Islands\">Turks and Caicos Islands</option>\n" +
"                                <option value=\"Tuvalu\">Tuvalu</option>\n" +
"                                <option value=\"Uganda\">Uganda</option>\n" +
"                                <option value=\"Ukraine\">Ukraine</option>\n" +
"                                <option value=\"United Arab Emirates\">United Arab Emirates</option>\n" +
"                                <option value=\"United Kingdom\">United Kingdom</option>\n" +
"                                <option value=\"United States\">United States</option>\n" +
"                                <option value=\"United States Minor Outlying Islands\">United States Minor Outlying\n" +
"                                    Islands</option>\n" +
"                                <option value=\"Uruguay\">Uruguay</option>\n" +
"                                <option value=\"Uzbekistan\">Uzbekistan</option>\n" +
"                                <option value=\"Vanuatu\">Vanuatu</option>\n" +
"                                <option value=\"Venezuela\">Venezuela</option>\n" +
"                                <option value=\"Viet Nam\">Viet Nam</option>\n" +
"                                <option value=\"Virgin Islands, British\">Virgin Islands, British</option>\n" +
"                                <option value=\"Virgin Islands, U.S.\">Virgin Islands, U.S.</option>\n" +
"                                <option value=\"Wallis and Futuna\">Wallis and Futuna</option>\n" +
"                                <option value=\"Western Sahara\">Western Sahara</option>\n" +
"                                <option value=\"Yemen\">Yemen</option>\n" +
"                                <option value=\"Zambia\">Zambia</option>\n" +
"                                <option value=\"Zimbabwe\">Zimbabwe</option>");
                
                out.println("</select>");
                out.println("</div>");
                out.println("</div>");
                out.println("<div class=\"inputfield\">");
                out.println("<label>Phone</label>");
                out.println("<input type=\"text\" class=\"input\" id=\"phone\" name=\"phone\">");
                out.println("</div>");
                out.println("<div class=\"inputfield\">");
                out.println("<label>Email</label>");
                out.println("<input type=\"text\" class=\"input\" id=\"email\" name=\"email\">");
                out.println("</div>");
                out.println("<div class=\"inputfield\">");
                out.println("<label>Subject</label>");
                out.println("<input type=\"text\" class=\"input\" id=\"subject\" name=\"subject\">");
                out.println("</div>");
                out.println("<div class=\"inputfield\">");
                out.println("<label>Type</label>");
                out.println("<input type=\"text\" class=\"input\" id=\"type\" name=\"type\">");
                out.println("</div>");
                out.println("<div class=\"inputfield\">");
                out.println("<label>Message</label>");
                out.println("<textarea class=\"textarea\" id=\"message\" name=\"message\"></textarea>");
                out.println("</div>");
                out.println("<div class=\"inputfield\">");
                out.println("<input type=\"submit\" value=\"Add Feedback\" class=\"btn\">");
                out.println("</div>");
                out.println("</form>");
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
            response.sendRedirect("feedback.html");
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
        
        HttpSession session = request.getSession();

        String uemail = (String) session.getAttribute("USER");
        
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String name = request.getParameter("name");
            String country = request.getParameter("country");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String subject = request.getParameter("subject");
            String type = request.getParameter("type");
            String message = request.getParameter("message");
            

            // YOU COULD DO HERE MORE SERVER-SIDE FORM VALIDATION OF DATA AS WELL LIKE WE DID IN THE ORIGINAL WEB PAGE USING JAVASCRIPT
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, inital-scale=1.0\">");
            out.println("<title>Kfix | New Feedback</title>");
            out.println("<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"images/kfix-icon.png\" />");
            out.println("<link rel=\"stylesheet\" href=\"css/style.css\">");
            out.println("<script type=\"text/javascript\" src=\"js/site.js\"></script>");
            out.println("</head>");
            out.println("<body>");

            //Loading and register a JDBC Driver
            Class.forName(JDBC_DRIVER);

            //Establishing a Connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
  
            String sql = "INSERT INTO Feedbacks (`Name`, Country, Phone, "
                    + "Email, `Subject`, `Type`, Message, CreationDateTime"
                    + ") VALUES (?, ?, ?, ?, ?, ?, "
                    + "?, NOW())";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, name);                     // 1 specifies the first parameter in the query  
            pStmt.setString(2, country);             // 2 specifies the second parameter in the query
            pStmt.setString(3, phone);
            pStmt.setString(4, email);
            pStmt.setString(5, subject);
            pStmt.setString(6, type);
            pStmt.setString(7, message);
            
            //java.sql.Date date = getCurrentDatetime();
            //pStmt.setDate(3, date);

            
            out.println("<div class=\"container\">");
            out.println("<div class=\"navbar\">");
            out.println("<div class=\"logo\">");
            out.println("<img src=\"images/kfix.png\" width=\"125px\">");
            out.println("</div>");
            out.println("<nav>");
            out.println("<ul id=\"MenuItems\">");
            
            if(uemail != null){
                out.println("<li><a href=\"secure\">Home</a></li>");
                out.println(" <li><a href=\"newRepair\">Add New Repair Request</a></li>");
                out.println("<li><a href=\"allRepairs\">Browse All Repair Records</a></li>");
                out.println("<li><a href=\"logout\">Logout</a></li>");
                out.println("<li><a href=\"feedback.html\">Add Feedback</a></li>");
            }else{
                out.println("<li><a href=\"index.html\">Home</a></li>");
                out.println("<li><a href=\"register.html\">Register</a></li>");
                out.println("<li><a href=\"login.html\">Login</a></li>");
                out.println("<li><a href=\"feedback.html\">Add Feedback</a></li>");
            }
           
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
            
            int k = pStmt.executeUpdate();     // returns number of affected rows
           
            if (k == 1) {
                //insert a record success
                out.println("<img src=\"images/check.png\" alt=\"\" width=\"80px\" height=\"80px\">");
                out.println("<p>Your Feed is Successfuly Registered</p>");
            } else // i.e.  k = 0
            {
                //insert a record error
                
                out.println("<img src=\"images/cross.png\" alt=\"\" width=\"80px\" height=\"80px\">");
                out.println("<p>Something Wrong Happened</p>");
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
