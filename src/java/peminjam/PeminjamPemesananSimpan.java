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
import ws.perpus.PerpustakaanWS_Service;

/**
 *
 * @author Rosemary
 */
public class PeminjamPemesananSimpan extends HttpServlet {

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

                String idPeminjam = (String) session.getAttribute("iduser");
                String idBuku = request.getParameter("idbuku");
                String idPemesananLama = "", idBukuLama = "";
                String idPeminjaman = getTanggal() + getWaktu();
                String tglPesan = getTanggalSQL();

                String query = "select * from pemesanan where idpeminjam = '" + idPeminjam + "'";
                Statement statement = conn.getConnection().createStatement();
                ResultSet result = statement.executeQuery(query);
                while (result.next()) {
                    idPemesananLama = result.getString(1);
                    idBukuLama = result.getString(3);
                }
                statement.close();

                if (!idPemesananLama.equals("")) {
                    String query2 = "delete from pemesanan where idpemesanan = '" + idPemesananLama + "'";
                    Statement statement2 = conn.getConnection().createStatement();
                    statement2.executeUpdate(query2);
                    statement2.close();

                    String query3 = "update buku set status = 'TERSEDIA'"
                            + "where idbuku = '" + idBukuLama + "'";
                    Statement statement3 = conn.getConnection().createStatement();
                    statement3.executeUpdate(query3);
                    statement3.close();

                }

                String query4 = "insert into pemesanan values ('" + idPeminjaman + "', '" + idPeminjam + "', '" + idBuku + "', '" + tglPesan + "')";
                Statement statement4 = conn.getConnection().createStatement();
                statement4.executeUpdate(query4);
                statement4.close();

                String query5 = "update buku set status = 'DIPESAN'"
                        + "where idbuku = '" + idBuku + "'";
                Statement statement5 = conn.getConnection().createStatement();
                statement5.executeUpdate(query5);
                statement5.close();

                response.sendRedirect("peminjam/lihattransaksi.html");
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

    private String getTanggal() {
        PerpustakaanWS_Service service = new PerpustakaanWS_Service();
        ws.perpus.PerpustakaanWS port = service.getPerpustakaanWSPort();
        return port.getTanggal();
    }

    private String getTanggalSQL() {
        PerpustakaanWS_Service service = new PerpustakaanWS_Service();
        ws.perpus.PerpustakaanWS port = service.getPerpustakaanWSPort();
        return port.getTanggalSQL();
    }

    private String getWaktu() {
        PerpustakaanWS_Service service = new PerpustakaanWS_Service();
        ws.perpus.PerpustakaanWS port = service.getPerpustakaanWSPort();
        return port.getWaktu();
    }
}
