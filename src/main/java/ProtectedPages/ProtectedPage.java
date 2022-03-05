/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProtectedPages;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.Properties;
import java.util.StringTokenizer;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Dell
 */
@WebServlet(name = "ProtectedPage", urlPatterns = {"/ProtectedPage"})
public class ProtectedPage extends HttpServlet {

    private Properties passwords;
    
    @Override
    public void init(ServletConfig conf)throws ServletException{
        super.init(conf);
        
        String filename=conf.getInitParameter("Password-File");
        passwords=new Properties();
        
        try{
        FileInputStream file=new FileInputStream(filename);
        passwords.load(file);
        
        System.out.println("Password Loads SuccessFull");
        
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String authorization=request.getHeader("Authorization");
        
        if(authorization==null)
            askForPassword(response);
        else{
            
            String userInfo=authorization.substring(6).trim();
            
            byte[] decodedBytes = Base64.getDecoder().decode(userInfo);
            String nameAndPassword = new String(decodedBytes);
            
            StringTokenizer tokens=new StringTokenizer(nameAndPassword,":");
            
            String name = tokens.nextToken();
            String password=tokens.nextToken();
            
            String realPAssword=passwords.getProperty(name);
            
            if(realPAssword!=null && realPAssword.equals(password))
                welcome(out);
            else
             askForPassword(response);
        }
    }
    
    public void askForPassword(HttpServletResponse response){
        
        response.setStatus(401);
        response.setHeader("WWW-Authenticate", "BASIC realm=\"privileged-few\"");
    }
    
    public void welcome(PrintWriter out)throws IOException{
        out.print("<H1> WelCome </H1>");
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
