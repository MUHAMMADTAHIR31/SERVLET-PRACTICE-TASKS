/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gzip;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
@WebServlet(name = "GzipEncoded", urlPatterns = {"/GzipEncoded"})
public class GzipEncoded extends HttpServlet {

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
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
                
        String encode=request.getHeader("Accept-Encoding");
        
        try {    
            if(encode==null){
                out=response.getWriter();
                send(out,"un-encoding Page");
            }else if(encode.indexOf("gzip")==-1){
                out=response.getWriter();
                send(out,"unencoded Page");
            }
            else{
                OutputStream os=response.getOutputStream();
                GZIPOutputStream gzipOut=new GZIPOutputStream(os);
                out=new PrintWriter(gzipOut,false);
                response.setHeader("Content-Encoding", "gzip");
                send(out,"Page Encoded with Gzip");
            }
        } finally {
            out.close();
        }
    }
    
    private void send(PrintWriter out,String tittle)throws ServletException, IOException{
       
        String str="HAHAHA LALA MAMA  NANA KAHA KAHAH";
        out.print("<H1>"+tittle+"</H1>");
        
        for(int i=0; i<1000; i++){
            out.println(str);
        }
        
        out.close();
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
        processRequest(request, response);
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
        processRequest(request, response);
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
