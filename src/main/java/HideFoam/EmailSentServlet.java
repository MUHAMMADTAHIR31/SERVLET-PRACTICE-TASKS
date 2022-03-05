/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HideFoam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.*;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
@WebServlet(name = "EmailSentServlet", urlPatterns = {"/EmailSentServlet"})
public class EmailSentServlet extends HttpServlet {

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
        
        String to=request.getParameter("email");
        String subject="Test Marks Result ";
        String result=request.getParameter("result");
        
        EmailSentServlet.send(to, subject, result);
        
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Email Sent Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Please Check your Mail For Result</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
    
    public static void send(String to,String subject,String msg){  
  
        final String user="tahirsindhi872@gmail.com";//change accordingly  
        final String pass="18cse31muet";  

        //1st step) Get the session object    
        //Properties props = new Properties();  
       // props.put("mail.smtp.host", "smtp.gmail.com");//change accordingly  
       // props.put("mail.smtp.auth", "true");  
          Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");
    //props.put("mail.smtp.user", user);
    //props.put("mail.smtp.password", "myPassword");
    props.put("mail.smtp.port", "587"); 
   props.put("mail.smtp.starttls.enable", "true");
       
        Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator(){
           @Override
            protected PasswordAuthentication getPasswordAuthentication() {  
                return new PasswordAuthentication(user,pass);  
            }  
        });  
        
        //2nd step)compose message  
        try {  
            MimeMessage message = new MimeMessage(session);  
            message.setFrom(new InternetAddress(user));  
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
            message.setSubject(subject);  
            message.setText(msg);  

            //3rd step)send message  
            Transport.send(message);  
            System.out.println("Done");  
        } catch (MessagingException e) {  
          throw new RuntimeException(e);  
        }  

    }  
}
