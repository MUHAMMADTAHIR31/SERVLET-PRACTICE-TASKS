/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registrationfoam;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Dell
 */
@WebServlet(name = "InterfaceServlet", urlPatterns = {"/InterfaceServlet"})
public class InterfaceServlet implements Servlet{
    
    private ServletConfig sc;
    
    @Override
    public void init(ServletConfig sc) throws ServletException {
      this.sc=sc;
        System.err.println("init()  Method");
    }

    @Override
    public ServletConfig getServletConfig() {
        return sc;
    }

    @Override
    public void service(ServletRequest sr, ServletResponse sr1) throws ServletException, IOException {
        PrintWriter out=sr1.getWriter();
        out.print("Test Servlet");
        System.err.println("Service()");
    }

    @Override
    public String getServletInfo() {
        return "It is Test servlet";
    }

    @Override
    public void destroy() {
        System.err.println("Destory()");
    }
}
