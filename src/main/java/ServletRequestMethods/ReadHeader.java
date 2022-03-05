/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletRequestMethods;

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
@WebServlet(name = "ReadHeader", urlPatterns = {"/ReadHeader"})
public class ReadHeader extends GenericServlet {
 
    @Override
    public void service(ServletRequest request, ServletResponse response)throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        ServletInputStream fis=request.getInputStream();
        
        String localadree=request.getLocalAddr();
        String localName=request.getLocalName();
        String serverName=request.getServerName();
        String remoteName=request.getRemoteHost();
        String protocol=request.getProtocol();
        String characterEncoding=request.getCharacterEncoding();
                
        int leng=request.getContentLength();
        int serverPort=request.getServerPort();
        int remotePort=request.getRemotePort();

        out.println("Server Name: "+serverName+"</br>");
        out.println("CharacterEncoding: "+characterEncoding+"</br>");
        out.println("Length: "+leng+"</br>");
        out.println("Server Port: "+serverPort+"</br>");
        out.println("Remote Port: "+remotePort+"</br>");
        out.println("Input Stream: "+fis+"</br>");
        out.println("LocalAdree: "+localadree+"</br>");
        out.println("LocalName: "+localName+"</br>");
        out.println("Remote Name: "+remoteName+"</br>");
        out.println("Protocol: "+protocol+"</br>");
    }
}
