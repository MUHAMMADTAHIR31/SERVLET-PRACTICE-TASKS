package ServletConfig;

import java.io.FileInputStream;
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
public class PasswordVerifyServlet extends GenericServlet {
    
    Properties p;
    
    @Override
    public void init(ServletConfig conf) throws ServletException{
        
        super.init();
        String fileName=conf.getInitParameter("filename");
        try{
            FileInputStream f= new FileInputStream(fileName);
            p=new Properties();
            p.load(f);
        }catch(IOException e){
          e.printStackTrace();
        }
    }
    
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String user=request.getParameter("userName");
        String userPassword=request.getParameter("password");
        
        PrintWriter out=response.getWriter();
        String realPassword=p.getProperty(user);
        
        if(realPassword==null)
            askForPassword(out);
        if(realPassword.equals(userPassword))
            out.print("<H1>WellCome<H1>");
        else
           askForPassword(out);
    }

    private void askForPassword(PrintWriter out) {
        
        out.print("<form action=\"AuthenticationServlet\" method=\"POST\">\"Enter UserName= <BR>");
        out.print(" <input type=\"text\" name=\"userName\"><BR>\n" +"Enter Password:<BR><input type=\"password\" name=\"password\"><BR>");
        out.print("<input type=\"submit\" value=\"send\"></form>");
    }
    
}
