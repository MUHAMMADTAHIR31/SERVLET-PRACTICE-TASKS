/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
public class HttpPasswordVerifyServlet extends HttpServlet {

    Properties p;
       
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html");
       PrintWriter out=response.getWriter();
       
        ServletConfig conf=getServletConfig();
        String fileName=conf.getInitParameter("filename");
        try{
            FileInputStream f= new FileInputStream(fileName);
            p=new Properties();
            p.load(f);
        }catch(IOException e){
          e.printStackTrace();
        }
        
        String user=request.getParameter("userName");
        String userPassword=request.getParameter("password");
     
        String realPassword=p.getProperty(user);
        RequestDispatcher requestDispatcher=null;
        
        if(realPassword==null){
            out.println("<H1>Password Not Found <H2>");
            
         //  response.sendRedirect("TestConfigServlet.html");
            requestDispatcher=request.getRequestDispatcher("TestConfigServlet.html");
            requestDispatcher.include(request, response);
            out.println("<H1>Password Not Found <H2>");
        }
        if(realPassword.equals(userPassword)){
            requestDispatcher=request.getRequestDispatcher("index.html");
            requestDispatcher.forward(request, response);
        }else{
            out.println("<H1>Password Not Found <H2>");
            requestDispatcher=request.getRequestDispatcher("TestConfigServlet.html");
            requestDispatcher.include(request, response);
            out.println("<H1>Password Not Found <H2>");
        }
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
