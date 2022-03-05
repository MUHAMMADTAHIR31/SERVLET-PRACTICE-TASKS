/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HideFoam;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
public class HideFieldServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String newAmountStr=request.getParameter("newAmount");
        String prevAmountStr=request.getParameter("prevAmount");
        
        int newAmount=0;
        int prevAmount=0;
        
        try{
        
            newAmount=Integer.parseInt(newAmountStr);
            prevAmount=Integer.parseInt(prevAmountStr);
        
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
        
        prevAmount += newAmount;
        
        out.println("<Form action=HideFieldServlet method=Post>");
        out.println("Enter Amount:");
        out.println("<input type=text name=newAmount><BR>");
        out.println("<input type=hidden name=prevAmount value="+prevAmount+">");
        out.println("<input type=submit value=addition><BR></Form>");
        out.println("Total Amount Rs: "+prevAmount);
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
