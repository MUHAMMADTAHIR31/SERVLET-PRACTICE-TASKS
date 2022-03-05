/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HideFoam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author Dell
 */
public class WebVisitorServlet extends GenericServlet {

    Properties p;
    int counter;
    String fileName="";
    
   
    @Override
    public void init(ServletConfig conf) throws ServletException{
        
       try{
            fileName=conf.getInitParameter("filename");
            
            FileInputStream f= new FileInputStream(fileName);
            p=new Properties();
            p.load(f);
            
            String realcounter=p.getProperty("counter");
            counter=Integer.parseInt(realcounter);
                    
        }catch(IOException e){
          e.printStackTrace();
        }
    
    }
    
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        ++counter;
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.print("<H3>Counter"+counter+"<H3>");
    }
    
    @Override
    public void destroy(){
        
        try{
            
            String valueNew=String.valueOf(counter);
            System.out.println(""+valueNew);
            FileOutputStream out = new FileOutputStream(fileName);
            p.setProperty("counter", valueNew);
            p.store(out, "My Counter");
            out.close(); 
            
        }catch(IOException e){
            e.printStackTrace();
        } 
    }
}
