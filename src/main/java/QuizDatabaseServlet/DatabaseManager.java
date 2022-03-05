/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuizDatabaseServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Dell
 */
public class DatabaseManager {
    
    private static Connection con;
    
    static{
        try {
            init();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private static void init()throws ClassNotFoundException,SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
    }
    
    public static Vector getData()throws SQLException,IOException{
        
        String query="SELECT QUESTION FROM QUESTIONS ORDER by Q_ID LIMIT 3";
        System.out.println(query);
              
        Statement st=null;
        ResultSet result=null;
        
        try{
        
            Vector v = new Vector();
            
            st=con.createStatement();
            result=st.executeQuery(query);
          
            while(result.next()){
                
                QuestionBean bean =  new QuestionBean();
                
                bean.setQ_id(result.getInt("Q_ID"));
                bean.setQuestion(result.getString("Question"));
                                
                v.add(bean);
            }
            return v;
        }finally{
        if(result!=null)result.close();
        if(st!=null)st.close();
        }//try
    }
    
    //
    public static Vector getAnswer(int Q_ID)throws SQLException,IOException{
        
        String query="SELECT ANS FROM ANSWER WHERE Q_ID="+Q_ID;
        System.out.println(query);
        
        Statement st=null;
        ResultSet result=null;
        
        try{
            
            Vector v = new Vector(); 
            st=con.createStatement();
            
            result=st.executeQuery(query);
          
            while(result.next()){
                
                AnswerBean bean =  new AnswerBean();
                
                //bean.setQ_id(result.getInt("Q_ID"));
                bean.setAns_id(result.getInt("Ans_Id"));
                bean.setAns(result.getString("ans"));
               // bean.setIs_correct(result.getBoolean("is_correct"));
                                
                v.add(bean);
            }
            return v;
        }finally{
        if(result!=null)result.close();
        if(st!=null)st.close();
        }//try
    }
}
