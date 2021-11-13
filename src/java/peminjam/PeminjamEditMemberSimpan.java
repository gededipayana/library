/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peminjam;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rosemary
 */
public class PeminjamEditMemberSimpan extends HttpServlet {

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
        DataBaseConnection conn = new DataBaseConnection();
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();

            if (session.getAttribute("status") == null) {
                response.sendRedirect("../home");

            } else if (session.getAttribute("status").toString().equalsIgnoreCase("peminjam")) {
                String iduser = request.getParameter("iduser");
                String username = request.getParameter("username");
                String pass = request.getParameter("password");
                String nama = request.getParameter("nama");
                String alamat = request.getParameter("alamat");
                String email = request.getParameter("email");
                String notelp = request.getParameter("notelp");

                //apabila salah satu tidak terisi
                if (username.equals("") || pass.equals("") || nama.equals("")) {
                    response.sendRedirect("peminjam/editmember.html");
                } else { //cek user sudah ada atau belum di database
                    if (alamat.equals("")) {
                        alamat = " ";
                    } else if(email.equals("")){
                        email = " ";
                    }else if (notelp.equals("")) {
                        notelp = " ";
                    }
                    String query = "update member set username = '" + username
                            + "', pass = '" + pass
                            + "', nama = '" + nama
                            + "', alamat = '" + alamat
                            + "', email = '" + email
                            + "', notelp = '" + notelp + "'"
                            + "where iduser = '" + iduser + "'";

                    Statement statement = conn.getConnection().createStatement();
                    ResultSet result = statement.executeQuery(query);

                    response.sendRedirect("peminjam/lihatmember.html");

                    statement.close();
                }
            } else {
                response.sendRedirect("../home");
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
