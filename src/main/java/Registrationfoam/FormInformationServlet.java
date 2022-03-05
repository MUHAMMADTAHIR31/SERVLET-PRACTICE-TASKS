/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registrationfoam;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
@WebServlet(name = "FormInformationServlet", urlPatterns = {"/FormInformationServlet"})
public class FormInformationServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException,Exception{
       
            String name=request.getParameter("Name");
            String fname=request.getParameter("FName");
            String surname=request.getParameter("Surname");
            String email=request.getParameter("email");
            String dob=request.getParameter("dob");
            String group=request.getParameter("group");
            String gender=request.getParameter("gender");
            String remarks=request.getParameter("textarea_comments");
            String[] services=request.getParameterValues("services");
            
            PrintWriter out=response.getWriter();
            
        try{ 
            
            out.println("Name: "+name);
            out.println("FName: "+fname);
            out.println("Surname: "+surname);
            out.println("email:"+email);
            out.println("Dob: "+dob);
            out.println("Group: "+group);
            out.println("Gender: "+gender);
                for (String service : services) {
                    out.println("services: " + service);
                }
            out.println("Remarks: "+remarks);
            
           /* Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
                out.print("System Connected");
                
                PreparedStatement ps = con.prepareStatement("insert into form values(?,?,?,?,?,?,?)");

            ps.setString(1, name);
            ps.setString(2, fname);
            ps.setString(3, surname);
            ps.setString(4,email);
            ps.setString(5, dob);
            ps.setString(6, group);
            ps.setString(7, gender);
            
            int i = ps.executeUpdate();
            
            if(i > 0) {
                out.println("You are sucessfully registered");
            }*/
        }catch(Exception e){
            e.printStackTrace();
        } finally {
           out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
