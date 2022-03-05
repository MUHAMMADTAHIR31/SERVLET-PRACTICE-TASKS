/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dell
 */
public class ShowItemSessionServlet extends HttpServlet {

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
        showRequest(request, response);
    }
    
    public void showRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
 
        /***** Print The Response *****/
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session=request.getSession(true);
       
        ArrayList<String> previousItems = (ArrayList<String>)session.getAttribute("previousItems");
        ArrayList<String> previousQuantity = (ArrayList<String>)session.getAttribute("previousQuantity");
       
        Iterator aIterator = previousItems.iterator();
        Iterator bIterator = previousQuantity.iterator();
        
        out.println("<!DOCTYPE html>\n<html>\n <head><title> Java Servlet Cookie Example </title></head>\n <body>\n" );
        
        if(previousItems.isEmpty()) {
            out.println("<I>No items</I>");
        }
        
        else{
            out.println("<h2 align = \"center\">Found Added Item and Its Quantity</h2>\n"
                + "<table width = \"250px\" border = \"1\" align = \"center\">\n" +"<tr bgcolor = \"lightgrey\">\n" +
                "<th>Prod ID</th><th>Item Name</th><th>Item Quantity</th><th>Delete</th>\n"+"</tr>\n");
            
            int i=1;
            while (aIterator.hasNext() && bIterator.hasNext()) {
                
                String item =(String) aIterator.next();
                String itemQuantity = (String) bIterator.next();
        
                out.println("<tr> <form action=ItemDeleteSessionServlet?item_name="+previousItems+" method=\"POST\"> <TD>" + (i));
                out.println("\n" +" <TD>" + item + "\n" + " <TD>" + itemQuantity);
                out.println("<TD><button type=submit> Delete </button> </td></form></tr>");
                
                i++;
            }
        }
        out.println("</table>");
 
        out.println("<div style='padding-top: 63px; text-align: center; padding-left: 16px;'>"
        + "Do you want to 'Add Item' again? Click Here <a href=ShoppingCartSession.html>Add Item</a></div>\n");
                       
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
