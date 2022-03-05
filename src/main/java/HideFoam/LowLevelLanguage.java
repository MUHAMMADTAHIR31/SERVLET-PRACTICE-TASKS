/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HideFoam;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
@WebServlet(name = "LowLevelLanguage", urlPatterns = {"/LowLevelLanguage"})
public class LowLevelLanguage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String answer=request.getParameter("middle");
        int prev=Integer.parseInt(request.getParameter("obtain"));
        
        if(answer.equalsIgnoreCase("C"))
            prev=prev+100;
        else
            prev=prev+0;
  
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LowLevelLanguage</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<Form method=POST action=Non_TCPOS>");
            
            out.println("<label for=high>Select Low Level Language:</label><BR>"+
            " <input type=\"radio\" name=\"low\" value=\"Fortan\"> Fortan<BR>\n" +
            "<input type=\"radio\" name=\"low\" value=\"Algole\"> Algole<BR>\n" +
            "<input type=\"radio\" name=\"low\" value=\"Assembly\"> Assembly<br>\n" +
            "<input type=\"hidden\" name=\"obtain\" value="+prev+">"+
            "<input type=\"submit\" name=\"low\" value=\"next\"></Form>");
            
            out.println("</body>");
            out.println("</html>");
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
