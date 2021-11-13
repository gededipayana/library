/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rosemary
 */
public class login extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {

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
        response.setContentType("text/html");
        DataBaseConnection conn = new DataBaseConnection();
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            String username = request.getParameter("username").toUpperCase();
            String password = request.getParameter("password");
            String status = "default";
            String iduser = "";

            //apabila username atau password kosong
            if (password.equals("") || username.equals("")) {
                response.sendRedirect("./failed.html");
            }

            String query = "select * from member where iduser = '" + username + "' and pass = '" + password + "'";
            Statement statement = conn.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query);

            //status untuk membuat session berisi hak akses
            while (result.next()) {
                status = result.getString(8);
                iduser = result.getString(1);
                username = result.getString(2);
            }
            
            session.setAttribute("iduser", iduser);
            session.setAttribute("status", status);
            session.setAttribute("username", username);
            
            //redirect sesuai hak akses
            if (status.equalsIgnoreCase("admin")) {
                response.sendRedirect("./admin/index.html");
            } else if (status.equalsIgnoreCase("staff")) {
                response.sendRedirect("./staff/index.html");
            } else if (status.equalsIgnoreCase("peminjam")) {
                response.sendRedirect("./peminjam/index.html");
            } else { //jika id tidak ditemukan maka mencari dari username
                statement.close();
                query = "select * from member where username = '" + username + "' and pass = '" + password + "'";
                statement = conn.getConnection().createStatement();
                result = statement.executeQuery(query);

                while (result.next()) {
                    status = result.getString(8);
                    iduser = result.getString(1);
                    username = result.getString(2);
                }
                session.setAttribute("iduser", iduser);
                session.setAttribute("status", status);
                session.setAttribute("username", username);
            }

            statement.close();

            if (status.equalsIgnoreCase("admin")) {
                response.sendRedirect("./admin/index.html");
            } else if (status.equalsIgnoreCase("staff")) {
                response.sendRedirect("./staff/index.html");
            } else if (status.equalsIgnoreCase("peminjam")) {
                response.sendRedirect("./peminjam/index.html");
            } else {
                response.sendRedirect("./failed.html");
            }
        } catch (Exception ex) {
            out.println("message: " + ex.getMessage());
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
