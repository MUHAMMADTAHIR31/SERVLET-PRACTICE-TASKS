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
@WebServlet(name = "ResultPageServlet", urlPatterns = {"/ResultPageServlet"})
public class ResultPageServlet extends HttpServlet {

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
        
        String answer=request.getParameter("non_tcp");
        int prev=Integer.parseInt(request.getParameter("obtain"));
        
        if(answer.equalsIgnoreCase("DOS"))
            prev=prev+100;
        else
            prev=prev+0;
                               
        int total=400;
        double percentage=(prev*100)/total;
        
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet ResultPageServlet</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<Form action=EmailSentServlet method=post>"
                + "<div>Total Score: "+total+"<BR>"
            + "Obtain Score:"+prev+"<BR>"
            + "Percentage:"+percentage+"</div><BR>");
        out.print("Enter Your Email <input type=\"text\" name=\"email\" placeholder=\"Email\"><br><br>");
        out.print("Enter Your Name <input type=\"text\" name=\"name\" placeholder=\"name\"><br><br>");
        out.print("<input type=\"hidden\" name=\"result\" value="+total+""+prev+""+percentage+"><br>");
        out.print("<input type=\"submit\" name=\"submit\" value=\"Submit\"><br></form>");
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
