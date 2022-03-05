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
@WebServlet(name = "Non_TCPOS", urlPatterns = {"/Non_TCPOS"})
public class Non_TCPOS extends HttpServlet {

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
        PrintWriter out = response.getWriter();
            
        String answer=request.getParameter("low");
        int prev=Integer.parseInt(request.getParameter("obtain"));
        
      
            if(answer.equalsIgnoreCase("Assembly"))
                prev=prev+100;
            else
                prev=prev+0;
       
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Non_TCPOS</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<Form method=POST action=ResultPageServlet>");
            
            out.println("<label for=high>Select Non Tcp/IP based OS:</label><BR>"+
            " <input type=\"radio\" name=\"non_tcp\" value=\"Solaries\"> Solaries<br>\n" +
            "<input type=\"radio\" name=\"non_tcp\" value=\"DOS\"> DOS<br>\n" +
            "<input type=\"radio\" name=\"non_tcp\" value=\"Linux\"> Linux<br>\n" +
            "<input type=\"radio\" name=\"non_tcp\" value=\"Windows\"> Windows<br>"+
            "<input type=\"hidden\" name=\"obtain\" value="+prev+">"+
            "<input type=\"hidden\" name=\"obtain\" value="+prev+">"+
            "<input type=\"submit\" name=\"next\" value=\"Next\"></Form>");
            
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
