/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletRequestMethods;

import com.oreilly.servlet.MultipartRequest;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Dell
*/

@WebServlet(name = "UploadServlet", urlPatterns = {"/UploadServlet"})
public class UploadServlet extends GenericServlet {
    
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        
        try {
            
            ServletInputStream in = request.getInputStream();
            
            int contentLen = request.getContentLength();
            byte data[] = new byte[contentLen];
            int numOfBytesRead = in.read(data,0,data.length);
            
            FileOutputStream f = new FileOutputStream("D:\\xyz.txt");
            f.write(data,0,data.length);
            f.close();
            
            out.println("File Uploaded..."+numOfBytesRead);
            out.println("File Uploaded..."+data.length);
            
       } finally {
            out.close();
        }
    }
}
