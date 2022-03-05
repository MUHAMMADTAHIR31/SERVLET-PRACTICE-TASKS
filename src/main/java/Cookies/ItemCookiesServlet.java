/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cookies;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
public class ItemCookiesServlet extends HttpServlet {

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
        
        handleRequest(request, response);
    }
    
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
         
        PrintWriter out = response.getWriter();
        
        /***** Create 'Cookies' For ItemName & Quantity*****/
        Cookie ItemName = new Cookie(request.getParameter("ItemName"),request.getParameter("Quantity"));
       // Cookie ItemName = new Cookie(item,quantity);
 
        /***** Setting The Expiry Date For Both The Cookies *****/
        int expireTime = 86400;
        ItemName.setMaxAge(expireTime);
                
        RequestDispatcher requestDispatcher=null;// request.getRequestDispatcher("ShoppingCart.html");
        
        /***** Add Both The Cookies In The Response Header *****/
        if(ItemName!=null){
            response.addCookie(ItemName);
            requestDispatcher= request.getRequestDispatcher("ShoppingCart.html");
            requestDispatcher.forward(request, response);
        } else{
            out.print("Please Insert Value");
            requestDispatcher= request.getRequestDispatcher("ShowServlet");
            requestDispatcher.include(request, response);
        }
            
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
