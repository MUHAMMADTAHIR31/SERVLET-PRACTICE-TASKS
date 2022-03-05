/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dell
 */
public class ItemAddSessionServlet extends HttpServlet {

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
        
        String newItem = request.getParameter("ItemName");
        String qunatity = request.getParameter("Quantity");
        
        HttpSession session=request.getSession();
        
        ArrayList<String> previousItems = (ArrayList<String>)session.getAttribute("previousItems");
        ArrayList<String> previousQuantity = (ArrayList<String>)session.getAttribute("previousQuantity");
        
        if (previousItems == null) {
            previousItems = new ArrayList<String>();
            previousQuantity = new ArrayList<String>();
        }
        
        if ((newItem != null && qunatity !=null ) && ((!newItem.trim().equals("")))) {
            previousItems.add(newItem);
            previousQuantity.add(qunatity);
	}
        
        RequestDispatcher requestDispatcher=null;
        
        if(newItem!=null){
            session.setAttribute("previousItems", previousItems);
            session.setAttribute("previousQuantity",previousQuantity);
            requestDispatcher= request.getRequestDispatcher("ShoppingCartSession.html");
            requestDispatcher.forward(request, response);
        } else{
            out.print("Please Insert Value");
            requestDispatcher= request.getRequestDispatcher("ShowItemSessionServlet");
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
