/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletConfig;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Dell
 */
public class PasswordBuilder {
    
    public static void main(String arg[]){
        
        try{
            
            /* Matching Password 
                FileInputStream f= new FileInputStream(fileName);
                Properties p=new Properties();
                p.load(f);
     
        
            String user=request.getParameter("userName");
            String userPassword=request.getParameter("password");
            String realPassword=p.getProperty(user);
            
            if(realPassword.equals(userPassword)) Matched
            else Try Again
            
            */
            //update
                 FileInputStream in = new FileInputStream("D:\\download\\passwords.properties");
                Properties props = new Properties();
                props.load(in);
                in.close();

                FileOutputStream out = new FileOutputStream("D:\\download\\passwords.properties");
                props.setProperty("tahir", "35");
                props.store(out, null);
                out.close();
            
         /*   
            // Insert / Set Passwords
            Properties p = new Properties();

            p.setProperty("ali", "bell");
            p.setProperty("danish", "59");
            p.setProperty("Ovii", "19");


            FileOutputStream fout = new FileOutputStream("D:\\download\\passwords.properties");
            p.store(fout, "My Passwords");
        
        // Delete Method
        /*
               Properties p = new Properties();   
            //FileInputStream fin = new FileInputStream("D:\\download\\passwords.properties"); 
            //p.load(fin);

            if (p.remove("key") != null) {

            //FileOutputStream fout = new FileOutputStream("D:\\download\\passwords.properties");
            //p.store(fout, "My Passwords");

            //fin.close();
        }// if End
        */
        //fout.close();
        System.out.println("Done");
        }catch(IOException e){
          e.printStackTrace();
        }finally{
            
        } 
    }
}
