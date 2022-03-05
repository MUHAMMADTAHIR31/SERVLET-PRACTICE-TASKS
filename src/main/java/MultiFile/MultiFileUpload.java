/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiFile;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import com.oreilly.servlet.MultipartRequest;

/**
 *
 * @author Dell
 */
@WebServlet(name = "MultiFileUpload", urlPatterns = {"/MultiFileUpload"})
public class MultiFileUpload extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
      res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        try {
              
            MultipartRequest m = new MultipartRequest(req,"D://download"); 
            String firstName=m.getParameter("name");
            String fName=m.getParameter("fname");
            System.out.println("First Name:"+firstName);
            System.out.println("Father Name:"+fName);
              
            out.print("File Uploadede SuccessFully");
        } finally {
            out.close();
        }
    }
}
