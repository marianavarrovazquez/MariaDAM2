/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coreservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.User;

/**
 *
 * @author maria
 */
public class RegisterServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        synchronized(session) {
            @SuppressWarnings("unchecked")
            List<String> previousItems = (List<String>)session.getAttribute("previousItems");
            if (previousItems == null) {
                previousItems = new ArrayList<String>();
            }
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            
            String firstName=request.getParameter("firstName");  
            String lastName=request.getParameter("lastName");  
            String email=request.getParameter("email");
            
            String title = "Registering with Sessions";
            String docType =
                "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";
            out.println(docType + "<HTML>\n" +
                "<HEAD>"
                    + "<TITLE>" + title + "</TITLE>"
              + "</HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                    "<H1>" + title + "</H1>");
            out.println("<UL>");
            out.println("  <LI>"+ "<strong>First Name : </strong>" + firstName);
            out.println("  <LI>"+ "<strong>Last Name : </strong>" + lastName);
            out.println("  <LI>"+ "<strong>Email Address : </strong>" + email);
            out.println("</UL>");
            out.println("</BODY>" + "</HTML>");
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
