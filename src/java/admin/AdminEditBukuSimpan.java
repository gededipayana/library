package admin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class AdminEditBukuSimpan extends HttpServlet {

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
        DataBaseConnection conn = new DataBaseConnection();
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();

            if (session.getAttribute("status") == null) {
                response.sendRedirect("../home");

            } else if (session.getAttribute("status").toString().equalsIgnoreCase("admin")) {

                String idbuku = request.getParameter("idbuku");
                String kategori = request.getParameter("kategori");
                String judulbuku = request.getParameter("judulbuku");
                String penerbit = request.getParameter("penerbit");
                String tahunterbit = request.getParameter("tahunterbit");
                String pengarang = request.getParameter("pengarang");

                //apabila salah satu tidak terisi
                if (idbuku.equals("") || kategori.equals("") || judulbuku.equals("") || penerbit.equals("") || tahunterbit.equals("") || pengarang.equals("")) {
                    response.sendRedirect("admin/editbuku.html");
                } else { //cek buku sudah ada atau belum di database
                    String query = "update buku set kategori = '" + kategori
                            + "', judul_buku = '" + judulbuku
                            + "', penerbit = '" + penerbit
                            + "', tahun_terbit = '" + tahunterbit
                            + "', pengarang = '" + pengarang + "'"
                            + "where idbuku = '" + idbuku + "'";

                    Statement statement = conn.getConnection().createStatement();
                    ResultSet result = statement.executeQuery(query);

                    response.sendRedirect("admin/lihatbuku.html");

                    statement.close();
                }
            } else {
                response.sendRedirect("../home");
            }
        } catch (Exception ex) {
            out.println("message: " + ex.getMessage());
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
