/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletConfig;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Dell
 */
@WebServlet(name = "TestServletConfig", urlPatterns = {"/TestServletConfig"})
public class TestServletConfig extends GenericServlet {
    
    String user,password;
    ServletConfig conf;
    
    @Override
    public void init(ServletConfig conf) throws ServletException{
        
        super.init();
        this.conf=conf;
        
        user=conf.getInitParameter("user");
        password=conf.getInitParameter("password");
        
        System.out.println("Loaded SuccessFully");
        System.out.println("User:"+user);
        System.out.println("Password:"+password);
    
    }
    
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        
        String userName=request.getParameter("user");
        String userPassword=request.getParameter("password");
        
        PrintWriter out=response.getWriter();
        
        if(user.equals(userName) && password.equals(userPassword))
            out.println("<H1>Hello Sir Jee<H1>");
        else
         out.print("<H1>Faild<H1>");
        
    }



}
