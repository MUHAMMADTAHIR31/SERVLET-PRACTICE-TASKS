/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuizOnline;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dell
 */
@WebServlet(name = "ResultServlet", urlPatterns = {"/ResultServlet"})
public class ResultServlet extends HttpServlet {

    int i=0;
    double percentage=0.0;
    String marked_ans[],ans[];
    int a[];
    HttpSession session;
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        
        int correct=0;
	session = req.getSession();
	PrintWriter pw=res.getWriter();
		
	pw.println("<html><body>");
	pw.println("<head>");
	pw.println("<link rel='icon' href='favicon.ico' type='image/x-icon' sizes='16x16'>");
	pw.println("<link rel='stylesheet' type='text/css' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'/>");
        pw.println("<style>");
        pw.println("div {border:1px solid black;margin:10 0 0 0;padding:30 0 0 0;max-width:800px;font-family:Verdana;font-size:12px;color:#58585A;box-sizing:border-box;}");
        pw.println("table {border:2px solid black;margin-bottom:10px;}");
	pw.println("td,th {padding:5px;padding-bottom:5px;padding-top:5px;border:1px solid black;}");
	pw.println("</style>");
		
	pw.println("<title>Java Quiz</title>");
		
	pw.println("<script>"); 
        pw.println("window.location.hash='no-back-button';");
        pw.println("window.location.hash='Again-No-back-button';");//again because google chrome don't insert first hash into history
        pw.println("window.onhashchange=function(){window.location.hash='no-back-button';}");
        pw.println("</script>");
		
	pw.println("</head>");
		
	marked_ans = (String[])session.getAttribute("options");
        ans = (String[])session.getAttribute("ans");
	a = (int[])session.getAttribute("arr");
	session.invalidate();
	
        for(int j=0;j<15;j++){
            if(marked_ans[j].charAt(0)==ans[j].charAt(0)){
                correct++;
            }
	}

        percentage=((double)correct)/15.0;
	pw.println("<div class='container table-responsive'>");
	pw.println("<b><center>Test End</center></b><br>");
	pw.println("<center>You have completed the test and answered <b>"+String.format("%.2f",percentage*100)+"%</b> of the questions correctly.</center>");
	
	pw.println("<br><table class='table-responsive'>");
	pw.println("<tr>");
	pw.println("<th>Question</th>");
	pw.println("<th>Marked Answer</th>");
	pw.println("<th>Correct Answer</th>");
	pw.println("</tr>");
		
	Connection con=DatabaseManager.con;
        
        for(int i=0;i<15;i++){
            try{
                String query="select ques from quiz where qno=?";
                PreparedStatement ps=con.prepareStatement(query);
                ps.setInt(1,a[i]);
                ResultSet rs=ps.executeQuery();

                String query1="select "+ans[i]+" from quiz where qno=?";
                PreparedStatement ps1=con.prepareStatement(query1);

                ps1.setInt(1,a[i]);
                ResultSet rs1=ps1.executeQuery();

                String query2="select "+marked_ans[i]+" from quiz where qno=?";
                PreparedStatement ps2=con.prepareStatement(query2);

                ps2.setInt(1,a[i]);
                ResultSet rs2=ps2.executeQuery();

                while(rs.next()){
                    rs1.next(); 
                    rs2.next();

                    pw.println("<tr >");	
                    if(rs1.getString(1).equals(rs2.getString(1))){

                        pw.println("<td><font color='green'>"+rs.getString(1)+"</font></td>");
                        pw.println("<td><font color='green'>"+rs2.getString(1)+"</font></td>");
                        pw.println("<td><font color='green'>"+rs1.getString(1)+"</font></td>");
                    }

                    else{
                        pw.println("<td><font color='red'>"+rs.getString(1)+"</font></td>");
                        pw.println("<td><font color='red'>"+rs2.getString(1)+"</font></td>");
                        pw.println("<td><font color='red'>"+rs1.getString(1)+"</font></td>");
                    }

                    pw.println("</tr>");	
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
	pw.println("</table>");
	pw.println("<u><a href='Quiz_QuestionServlet' style='font-size:15px;'>Start a new Java Quiz</a></u><br>");
	pw.println("<br></div></body></html>");	
    
    }
}
