/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cookies;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
public class ShowServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        showRequest(request, response);
    }
    
    public void showRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
 
        Cookie cookie = null;
        Cookie[] cookies = null;
         
        /***** Get An Array Of Cookies Associated With This Domain *****/
        cookies = request.getCookies();
 
        /***** Set Response Content Type *****/
        response.setContentType("text/html");
 
        /***** Print The Response *****/
        PrintWriter out = response.getWriter();
        String title = "Java Servlet Cookie Example";
        String docType ="<!DOCTYPE html>\n";
 
        out.println(docType +"<html>\n <head><title>" + title + "</title></head>\n <body>\n" );
        
        if(cookies != null) {
            
            out.println("<h2 align = \"center\">Found Added Item and Its Quantity</h2>\n"
                + "<table width = \"250px\" border = \"1\" align = \"center\">\n" +"<tr bgcolor = \"lightgrey\">\n" +
                "<th>Prod ID</th><th>Item Name</th><th>Item Quantity</th><th>Delete</th>\n"+"</tr>\n");
 
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
               
                out.println("<tr> <form action=DeleteServlet?item_name="+cookie.getName()+" method=\"POST\"> <TD>" + (i+1));
                out.println("\n" +" <TD>" + cookie.getName() + "\n" + " <TD>" + cookie.getValue());
                out.println("<TD><button type=submit> Delete </button> </td></form></tr>");
            }
            out.println("</table>");
 
            out.println("<div style='padding-top: 63px; text-align: center; padding-left: 16px;'>"
                + "Do you want to 'Add Item' again? Click Here <a href=ShoppingCart.html>Add Item</a></div>\n");
                       
        } else {
            out.println("<h2 align = \"center\">No Cookies Found ....!</h2>");
        }
        out.println("</body></html>");
        out.close();
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
