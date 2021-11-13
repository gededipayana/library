/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staff;

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
public class StaffPeminjamanLangsung extends HttpServlet {

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
        response.setContentType("text/html");
        DataBaseConnection conn = new DataBaseConnection();
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();

            if (session.getAttribute("status") == null) {
                response.sendRedirect("../home");

            } else if (session.getAttribute("status").toString().equalsIgnoreCase("staff")) {

                String idpeminjam = "", usernamepeminjam = "", namapeminjam = "", alamatpeminjam = "", idbuku = "",
                        judulbuku = "", penerbit = "", pengarang = "", tahunterbit = "", kategori = "", statusBuku = "";

                if (session.getAttribute("idpeminjam") != null) {
                    idpeminjam = (String) session.getAttribute("idpeminjam");
                    usernamepeminjam = (String) session.getAttribute("usernamepeminjam");
                    namapeminjam = (String) session.getAttribute("namapeminjam");
                    alamatpeminjam = (String) session.getAttribute("alamatpeminjam");
                }

                if (session.getAttribute("idbuku") != null) {
                    idbuku = (String) session.getAttribute("idbuku");
                    judulbuku = (String) session.getAttribute("judulbuku");
                    penerbit = (String) session.getAttribute("penerbit");
                    pengarang = (String) session.getAttribute("pengarang");
                    tahunterbit = (String) session.getAttribute("tahunterbit");
                    kategori = (String) session.getAttribute("kategori");
                    statusBuku = (String) session.getAttribute("statusbuku");
                }

                out.println("F<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "    <head>\n"
                        + "        <title>Perpustakaan SMKN 1 Sedayu</title>\n"
                        + "        <link rel=\"stylesheet\" href=\"../bower_components/bootstrap/dist/css/bootstrap.min.css\">\n"
                        + "        <link rel=\"stylesheet\" href=\"../bower_components/font-awesome/css/font-awesome.min.css\">\n"
                        + "        <link rel=\"stylesheet\" href=\"../dist/css/AdminLTE.min.css\">\n"
                        + "        <link rel=\"stylesheet\" href=\"../dist/css/skins/skin-yellow.min.css\">\n"
                        + "        <link rel=\"stylesheet\" href=\"../resources/initializr/css/bootstrap.css\">\n"
                        + "        <link rel=\"stylesheet\" href=\"../resources/initializr/css/bootstrap-theme.css\">\n"
                        + "        <script src=\"../resources/jquery/js/jquery-1.12.4.min.js\"></script>\n"
                        + "        <script src=\"../resources/lightbox/js/prototype.js\"></script>\n"
                        + "        <script src=\"../resources/lightbox/js/scriptaculous.js?load=effects\"></script>\n"
                        + "        <script src=\"../resources/select2/select2.min.js\"></script>\n"
                        + "        <script src=\"../resources/timepicker/bootstrap-timepicker.min.js\"></script>\n"
                        + "        <script src=\"../resources/jscookie/js.cookie.js\"></script>\n"
                        + "        <script src=\"../resources/datepicker/js/datepicker.packed.js\"></script>\n"
                        + "        <script src=\"../common.js.php\"></script>\n"
                        + "    </head>\n"
                        + "    <body class=\"hold-transition skin-yellow sidebar-mini\">\n"
                        + "        <div class=\"wrapper\">\n"
                        + "            <!-- HEADER -->\n"
                        + "            <header class=\"main-header\">\n"
                        + "                <a href=\"index.html\" class=\"logo\">\n"
                        + "                    <span class=\"logo-mini\">Menu</span>\n"
                        + "                    <span class=\"logo-lg\"><b>Staff Panel</b></span>\n"
                        + "                </a>\n"
                        + "                <nav class=\"navbar navbar-static-top\" role=\"navigation\">\n"
                        + "                    <a href=\"#\" class=\"sidebar-toggle\" data-toggle=\"push-menu\" role=\"button\">\n"
                        + "                    </a>\n"
                        + "                </nav>\n"
                        + "            </header>\n"
                        + "\n"
                        + "            <!-- Slide Kanan -->\n"
                        + "        <aside class=\"main-sidebar\">\n"
                        + "            <section class=\"sidebar\"><br>\n"
                        + "                <div class=\"user-panel\">\n"
                        + "                    <div class=\"pull-left image\">\n"
                        + "                        <img src=\"../dist/img/ic10.png\" class=\"img-circle\" alt=\"User Image\">\n"
                        + "                    </div>\n"
                        + "                    <div class=\"pull-left info\">\n"
                        + "                            <strong><a href=\"index.html\" class=\"text-success\">" + session.getAttribute("username") + "</a></strong>\n<br>"
                        + "                        <a href=\"#\"><i class=\"fa fa-circle text-success\"></i> Online</a>\n"
                        + "                    </div>\n"
                        + "                </div>\n"
                        + "\n"
                        + "                <ul class=\"sidebar-menu\" data-widget=\"tree\">\n"
                        + "                    <li class=\"header\"></li>\n"
                        + "                    <li class=\"active\">\n"
                        + "						<a href=\"index.html\"><i class=\"fa fa-dashboard\"></i>\n"
                        + "						<span>Dashboard</span>\n"
                        + "						</a>\n"
                        + "					</li>\n"
                        + "                    <li class=\"treeview\">\n"
                        + "                        <a href=\"#\"><i class=\"fa fa-users\"></i> <span>Member</span>\n"
                        + "						<span class=\"pull-right-container\">\n"
                        + "							<i class=\"fa fa-angle-left pull-right\"></i>\n"
                        + "						</span>\n"
                        + "						</a>\n"
                        + "                        <ul class=\"treeview-menu\">\n"
                        + "                            <li><a href=\"lihatmember.html\">Lihat Member</a></li>\n"
                        + "                            <li><a href=\"editmember.html\">Edit Member</a></li>\n"
                        + "                        </ul>\n"
                        + "                    </li>\n"
                        + "                    <li class=\"treeview\">\n"
                        + "                        <a href=\"#\"><i class=\"fa fa-book\"></i> \n"
                        + "						<span>Buku</span>\n"
                        + "						<span class=\"pull-right-container\">\n"
                        + "							<i class=\"fa fa-angle-left pull-right\"></i>\n"
                        + "						</span>\n"
                        + "						</a>\n"
                        + "                        <ul class=\"treeview-menu\">\n"
                        + "                            <li><a href=\"lihatbuku.html\">Lihat Buku</a></li>\n"
                        + "                        </ul>\n"
                        + "                    </li>\n"
                        + "                    <li class=\"treeview\">\n"
                        + "                        <a href=\"#\"><i class=\"fa fa-newspaper-o\"></i> <span>Transaksi</span>\n"
                        + "						<span class=\"pull-right-container\">\n"
                        + "							<i class=\"fa fa-angle-left pull-right\"></i>\n"
                        + "						</span>\n"
                        + "						</a>\n"
                        + "                        <ul class=\"treeview-menu\">\n"
                        + "							<li><a href=\"lihattransaksi.html\">Lihat Transaksi</a></li>\n"
                        + "                            <li><a href=\"peminjamanlangsung.html\">Peminjaman Langsung</a></li>\n"
                        + "                            <li><a href=\"validasipemesanan.html\">Validasi Pemesanan</a></li>\n"
                        + "                            <li><a href=\"pengembalianbuku.html\">Pengembalian Buku</a></li>\n"
                        + "                            <li><a href=\"pembatalanpesanan.html\">Pembatalan Pesanan</a></li>\n"
                        + "                        </ul>\n"
                        + "                    </li>\n"
                        + "                    <li>\n"
                        + "						<a href=\"../logout\">\n"
                        + "						<i class=\"glyphicon glyphicon-log-out\"></i> <span>Keluar</span>\n"
                        + "						</a>\n"
                        + "					</li>\n"
                        + "                </ul>\n"
                        + "            </section>\n"
                        + "        </aside>\n"
                        + "\n"
                        + "            <!-- Isi -->\n"
                        + "            <div class=\"content-wrapper\"><br>\n"
                        + "                <section class=\"content-header\">\n"
                        + "                    <ol class=\"breadcrumb\">\n"
                        + "                        <li><a href=\"index.html\"><i class=\"fa fa-dashboard\"></i>Staff</a></li>\n"
                        + "                        <li class=\"active\">peminjamanlangsung</li>\n"
                        + "                    </ol>\n"
                        + "                </section>\n"
                        + "                <!-- Scroll -->\n"
                        + "                <script src=\"../dist/js/adminlte.min.js\"></script>\n"
                        + "                <div class=\"row\">\n"
                        + "                    <div class=\"col-xs-12\">\n"
                        + "                        <div class=\"page-header\">\n"
                        + "                            <!-- Judul -->\n"
                        + "                            <h1>\n"
                        + "                                <form method=\"post\" action=\"./peminjamanlangsung.html\">\n"
                        + "                                    <div class=\"col-sm-8\">\n"
                        + "                                        <div class=\"row\"><div class=\"col-sm-8\"><a style=\"text-decoration: none; color: inherit;\" href=\"index.html\">\n"
                        + "                                                    <img src=\"../resources/table_icons/blogs.png\"> Peminjaman Langsung</a></div>\n"
                        + "                                            <div class=\"col-sm-8\">\n"
                        + "                                                <br><h3>ID Peminjaman</h3>\n"
                        + "                                            </div>\n"
                        + "                                            <div class=\"col-sm-5\">		\n"
                        + "                                                <div class=\"input-group\" id=\"quick-search\">\n"
                        + "                                                    <input type=\"text\" id=\"SearchString\" name=\"katakuncipeminjam\" value=\"\" class=\"form-control\" placeholder=\"Cari\">\n"
                        + "                                                    <span class=\"input-group-btn\">\n"
                        + "                                                        <button name=\"Search_x\" value=\"1\" id=\"Search\" type=\"submit\" onClick=\"#\" class=\"btn btn-default\" title=\"Quick Search\"><i class=\"glyphicon glyphicon-search\"></i></button>\n"
                        + "                                                    </span>\n"
                        + "                                                </div>			\n"
                        + "                                            </div>\n"
                        + "                                            <div class=\"col-sm-8\">\n"
                        + "                                                <h3>ID Buku</h3>\n"
                        + "                                            </div>\n"
                        + "                                            <div class=\"col-sm-5\">		\n"
                        + "                                                <div class=\"input-group\" id=\"quick-search\">\n"
                        + "                                                    <input type=\"text\" id=\"SearchString\" name=\"katakuncibuku\" value=\"\" class=\"form-control\" placeholder=\"Cari\">\n"
                        + "                                                    <span class=\"input-group-btn\">\n"
                        + "                                                        <button name=\"Search_x\" value=\"1\" id=\"Search\" type=\"submit\" onClick=\"#\" class=\"btn btn-default\" title=\"Quick Search\"><i class=\"glyphicon glyphicon-search\"></i></button>\n"
                        + "                                                    </span>\n"
                        + "                                                </div>			\n"
                        + "                                            </div>\n"
                        + "                                        </div>\n"
                        + "                                    </div>\n"
                        + "                                </form>\n"
                        + "                            </h1>\n"
                        + "                        </div>\n"
                        + "                    </div>\n"
                        + "                    <span><br></span>\n"
                        + "                    <form method=\"post\" name=\"myform\" action=\"../StaffPeminjamanLangsungSimpan\">\n"
                        + "                        <div class=\"col-sm-12\">		\n"
                        + "                            <div class=\"col-xs-12 detail_view \">\n"
                        + "                                <div class=\"panel panel-default\">\n"
                        + "                                    <a name=\"detail-view\"></a>\n"
                        + "                                    <div class=\"panel-heading\">\n"
                        + "                                        <h3 class=\"panel-title\"><strong>Detail</strong></h3>\n"
                        + "                                    </div>\n"
                        + "                                    <div class=\"panel-body\" id=\"Users_dv_container\">\n"
                        + "                                        <div class=\"row\">\n"
                        + "                                            <div class=\"col-md-8 col-lg-10\" id=\"Users_dv_form\">\n"
                        + "                                                <div class=\"panel-heading\">\n"
                        + "                                                    <h3 class=\"panel-title\"><strong>Detail Peminjam</strong></h3>\n"
                        + "                                                </div>\n"
                        + "                                                        <fieldset class=\"form-horizontal\">\n"
                        + "                                                            <div class=\"form-group\">\n"
                        + "                                                                <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                                <label for=\"Membership_Number\" class=\"control-label col-lg-3\">ID User</label>\n"
                        + "                                                                <div class=\"col-lg-9\">\n"
                        + "                                                                    <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"idpeminjam\" id=\"Membership_Number\" value=\"" + idpeminjam + "\" readonly>\n"
                        + "                                                                </div>\n"
                        + "                                                            </div>\n"
                        + "                                                            <div class=\"form-group\">\n"
                        + "                                                                <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                                <label for=\"Name\" class=\"control-label col-lg-3\">Username</label>\n"
                        + "                                                                <div class=\"col-lg-9\">\n"
                        + "                                                                    <input maxlength=\"140\" type=\"text\" class=\"form-control\" name=\"usernamepeminjam\" id=\"Name\" value=\"" + usernamepeminjam + "\" readonly>\n"
                        + "                                                                </div>\n"
                        + "                                                            </div>\n"
                        + "                                                            <div class=\"form-group\">\n"
                        + "                                                                <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                                <label for=\"Contact\" class=\"control-label col-lg-3\">Nama</label>\n"
                        + "                                                                <div class=\"col-lg-9\">\n"
                        + "                                                                    <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"namapeminjam\" id=\"Contact\" value=\"" + namapeminjam + "\" readonly>\n"
                        + "                                                                </div>\n"
                        + "                                                            </div>\n"
                        + "                                                            <div class=\"form-group\">\n"
                        + "                                                                <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                                <label for=\"Contact\" class=\"control-label col-lg-3\">Alamat</label>\n"
                        + "                                                                <div class=\"col-lg-9\">\n"
                        + "                                                                    <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"alamatpeminjam\" id=\"Contact\" value=\"" + alamatpeminjam + "\" readonly>\n"
                        + "                                                                </div>\n"
                        + "                                                            </div>\n"
                        + "                                                        </fieldset>\n"
                        + "                                                        <hr>\n"
                        + "                                                        <div class=\"panel-heading\">\n"
                        + "                                                            <h3 class=\"panel-title\"><strong>Buku Detail");

                if (statusBuku.equalsIgnoreCase("dipinjam") || statusBuku.equalsIgnoreCase("dipesan")) {
                    out.println(" - <font color=\"red\">" + statusBuku + "</font>");
                }

                out.println("</strong></h3>\n"
                        + "                                                        </div>\n"
                        + "                                                        <fieldset class=\"form-horizontal\">\n"
                        + "                                                            <div class=\"form-group\">\n"
                        + "                                                                <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                                <label for=\"Membership_Number\" class=\"control-label col-lg-3\">ID Buku</label>\n"
                        + "                                                                <div class=\"col-lg-9\">\n"
                        + "                                                                    <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"idbuku\" id=\"Membership_Number\" value=\"" + idbuku + "\" readonly>\n"
                        + "                                                                </div>\n"
                        + "                                                            </div>\n"
                        + "                                                            <div class=\"form-group\">\n"
                        + "                                                                <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                                <label for=\"Name\" class=\"control-label col-lg-3\">Judul Buku</label>\n"
                        + "                                                                <div class=\"col-lg-9\">\n"
                        + "                                                                    <input maxlength=\"140\" type=\"text\" class=\"form-control\" name=\"judulbuku\" id=\"Name\" value=\"" + judulbuku + "\" readonly>\n"
                        + "                                                                </div>\n"
                        + "                                                            </div>\n"
                        + "                                                            <div class=\"form-group\">\n"
                        + "                                                                <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                                <label for=\"Contact\" class=\"control-label col-lg-3\">Penerbit</label>\n"
                        + "                                                                <div class=\"col-lg-9\">\n"
                        + "                                                                    <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"penerbit\" id=\"Contact\" value=\"" + penerbit + "\" readonly>\n"
                        + "                                                                </div>\n"
                        + "                                                            </div>\n"
                        + "                                                            <div class=\"form-group\">\n"
                        + "                                                                <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                                <label for=\"Contact\" class=\"control-label col-lg-3\">Pengarang</label>\n"
                        + "                                                                <div class=\"col-lg-9\">\n"
                        + "                                                                    <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"pengarang\" id=\"Contact\" value=\"" + pengarang + "\" readonly>\n"
                        + "                                                                </div>\n"
                        + "                                                            </div>\n"
                        + "                                                            <div class=\"form-group\">\n"
                        + "                                                                <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                                <label for=\"Contact\" class=\"control-label col-lg-3\">Tahun Terbit</label>\n"
                        + "                                                                <div class=\"col-lg-9\">\n"
                        + "                                                                    <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"tahunterbit\" id=\"Contact\" value=\"" + tahunterbit + "\" readonly>\n"
                        + "                                                                </div>\n"
                        + "                                                            </div>\n"
                        + "                                                            <div class=\"form-group\">\n"
                        + "                                                                <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                                <label for=\"Contact\" class=\"control-label col-lg-3\">Kategori</label>\n"
                        + "                                                                <div class=\"col-lg-9\">\n"
                        + "                                                                    <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"kategori\" id=\"Contact\" value=\"" + kategori + "\" readonly>\n"
                        + "                                                                </div>\n"
                        + "                                                            </div>\n"
                        + "                                                            <div class=\"form-group\">\n"
                        + "                                                                <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                                <label for=\"Contact\" class=\"control-label col-lg-3\">Status</label>\n"
                        + "                                                                <div class=\"col-lg-9\">\n"
                        + "                                                                    <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"status\" id=\"Contact\" value=\"" + statusBuku + "\" readonly>\n"
                        + "                                                                </div>\n"
                        + "                                                            </div>\n"
                        + "                                                        </fieldset>\n"
                        + "                                            </div>\n"
                        + "                                            <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                            <div class=\"col-md-4 col-lg-2\" id=\"Users_dv_action_buttons\">\n");
                if (statusBuku.equalsIgnoreCase("tersedia")) {
                    out.println("                                                        <div class=\"btn-toolbar\">\n"
                            + "                                                            <br><br>\n"
                            + "                                                            <div class=\"btn-group-vertical btn-group-lg\" style=\"width: 100%;\">\n"
                            + "                                                                <button type=\"submit\" class=\"btn btn-success\" id=\"insert\" name=\"insert_x\" value=\"1\" onclick=\"return Users_validateData();\"><i class=\"glyphicon glyphicon-plus-sign\"></i> Konfirmasi</button>\n"
                            + "                                                            </div>\n"
                            + "                                                        </div>\n");
                }
                out.println("                                            </div>\n"
                        + "                                        </div>\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "                            </div>	\n"
                        + "                        </div>\n"
                        + "                    </form>\n"
                        + "                </div>\n"
                        + "            </div>\n"
                        + "        </div>\n"
                        + "    </div>\n"
                        + "</div>\n"
                        + "</body>\n"
                        + "\n"
                        + "</html>");
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
        DataBaseConnection conn = new DataBaseConnection();
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();

            if (session.getAttribute("status") == null) {
                response.sendRedirect("../home");

            } else if (session.getAttribute("status").toString().equalsIgnoreCase("staff")) {

                String idpeminjam = "", usernamepeminjam = "", namapeminjam = "", alamatpeminjam = "", idbuku = "",
                        judulbuku = "", penerbit = "", pengarang = "", tahunterbit = "", kategori = "", statusBuku = "";

                //cek inputan apakah null
                if (request.getParameter("katakuncipeminjam") != null) {
                    String katakuncipeminjam = request.getParameter("katakuncipeminjam").toUpperCase();
                    String query = "select * from member where iduser = '" + katakuncipeminjam + "'";
                    Statement statement = conn.getConnection().createStatement();
                    ResultSet result = statement.executeQuery(query);

                    while (result.next()) {
                        session.setAttribute("idpeminjam", result.getString(1));
                        session.setAttribute("usernamepeminjam", result.getString(2));
                        session.setAttribute("namapeminjam", result.getString(4));
                        session.setAttribute("alamatpeminjam", result.getString(6));
                    }
                }

                if (request.getParameter("katakuncibuku") != null) {
                    String katakuncibuku = request.getParameter("katakuncibuku").toUpperCase();
                    String query2 = "select * from buku where idbuku = '" + katakuncibuku + "'";
                    Statement statement2 = conn.getConnection().createStatement();
                    ResultSet result2 = statement2.executeQuery(query2);

                    while (result2.next()) {
                        session.setAttribute("idbuku", result2.getString(1));
                        session.setAttribute("judulbuku", result2.getString(3));
                        session.setAttribute("penerbit", result2.getString(4));
                        session.setAttribute("pengarang", result2.getString(6));
                        session.setAttribute("tahunterbit", result2.getString(5));
                        session.setAttribute("kategori", result2.getString(2));
                        session.setAttribute("statusbuku", result2.getString(7));
                    }
                }
//
                if (session.getAttribute("idpeminjam") != null) {
                    idpeminjam = (String) session.getAttribute("idpeminjam");
                    usernamepeminjam = (String) session.getAttribute("usernamepeminjam");
                    namapeminjam = (String) session.getAttribute("namapeminjam");
                    alamatpeminjam = (String) session.getAttribute("alamatpeminjam");
                }

                if (session.getAttribute("idbuku") != null) {
                    idbuku = (String) session.getAttribute("idbuku");
                    judulbuku = (String) session.getAttribute("judulbuku");
                    penerbit = (String) session.getAttribute("penerbit");
                    pengarang = (String) session.getAttribute("pengarang");
                    tahunterbit = (String) session.getAttribute("tahunterbit");
                    kategori = (String) session.getAttribute("kategori");
                    statusBuku = (String) session.getAttribute("statusbuku");
                }

                out.println("F<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "    <head>\n"
                        + "        <title>Perpustakaan SMKN 1 Sedayu</title>\n"
                        + "        <link rel=\"stylesheet\" href=\"../bower_components/bootstrap/dist/css/bootstrap.min.css\">\n"
                        + "        <link rel=\"stylesheet\" href=\"../bower_components/font-awesome/css/font-awesome.min.css\">\n"
                        + "        <link rel=\"stylesheet\" href=\"../dist/css/AdminLTE.min.css\">\n"
                        + "        <link rel=\"stylesheet\" href=\"../dist/css/skins/skin-yellow.min.css\">\n"
                        + "        <link rel=\"stylesheet\" href=\"../resources/initializr/css/bootstrap.css\">\n"
                        + "        <link rel=\"stylesheet\" href=\"../resources/initializr/css/bootstrap-theme.css\">\n"
                        + "        <script src=\"../resources/jquery/js/jquery-1.12.4.min.js\"></script>\n"
                        + "        <script src=\"../resources/lightbox/js/prototype.js\"></script>\n"
                        + "        <script src=\"../resources/lightbox/js/scriptaculous.js?load=effects\"></script>\n"
                        + "        <script src=\"../resources/select2/select2.min.js\"></script>\n"
                        + "        <script src=\"../resources/timepicker/bootstrap-timepicker.min.js\"></script>\n"
                        + "        <script src=\"../resources/jscookie/js.cookie.js\"></script>\n"
                        + "        <script src=\"../resources/datepicker/js/datepicker.packed.js\"></script>\n"
                        + "        <script src=\"../common.js.php\"></script>\n"
                        + "    </head>\n"
                        + "    <body class=\"hold-transition skin-yellow sidebar-mini\">\n"
                        + "        <div class=\"wrapper\">\n"
                        + "            <!-- HEADER -->\n"
                        + "            <header class=\"main-header\">\n"
                        + "                <a href=\"index.html\" class=\"logo\">\n"
                        + "                    <span class=\"logo-mini\">Menu</span>\n"
                        + "                    <span class=\"logo-lg\"><b>Staff Panel</b></span>\n"
                        + "                </a>\n"
                        + "                <nav class=\"navbar navbar-static-top\" role=\"navigation\">\n"
                        + "                    <a href=\"#\" class=\"sidebar-toggle\" data-toggle=\"push-menu\" role=\"button\">\n"
                        + "                    </a>\n"
                        + "                </nav>\n"
                        + "            </header>\n"
                        + "\n"
                        + "            <!-- Slide Kanan -->\n"
                        + "        <aside class=\"main-sidebar\">\n"
                        + "            <section class=\"sidebar\"><br>\n"
                        + "                <div class=\"user-panel\">\n"
                        + "                    <div class=\"pull-left image\">\n"
                        + "                        <img src=\"../dist/img/ic10.png\" class=\"img-circle\" alt=\"User Image\">\n"
                        + "                    </div>\n"
                        + "                    <div class=\"pull-left info\">\n"
                        + "                            <strong><a href=\"index.html\" class=\"text-success\">" + session.getAttribute("username") + "</a></strong>\n<br>"
                        + "                        <a href=\"#\"><i class=\"fa fa-circle text-success\"></i> Online</a>\n"
                        + "                    </div>\n"
                        + "                </div>\n"
                        + "\n"
                        + "                <ul class=\"sidebar-menu\" data-widget=\"tree\">\n"
                        + "                    <li class=\"header\"></li>\n"
                        + "                    <li class=\"active\">\n"
                        + "						<a href=\"index.html\"><i class=\"fa fa-dashboard\"></i>\n"
                        + "						<span>Dashboard</span>\n"
                        + "						</a>\n"
                        + "					</li>\n"
                        + "                    <li class=\"treeview\">\n"
                        + "                        <a href=\"#\"><i class=\"fa fa-users\"></i> <span>Member</span>\n"
                        + "						<span class=\"pull-right-container\">\n"
                        + "							<i class=\"fa fa-angle-left pull-right\"></i>\n"
                        + "						</span>\n"
                        + "						</a>\n"
                        + "                        <ul class=\"treeview-menu\">\n"
                        + "                            <li><a href=\"lihatmember.html\">Lihat Member</a></li>\n"
                        + "                            <li><a href=\"editmember.html\">Edit Member</a></li>\n"
                        + "                        </ul>\n"
                        + "                    </li>\n"
                        + "                    <li class=\"treeview\">\n"
                        + "                        <a href=\"#\"><i class=\"fa fa-book\"></i> \n"
                        + "						<span>Buku</span>\n"
                        + "						<span class=\"pull-right-container\">\n"
                        + "							<i class=\"fa fa-angle-left pull-right\"></i>\n"
                        + "						</span>\n"
                        + "						</a>\n"
                        + "                        <ul class=\"treeview-menu\">\n"
                        + "                            <li><a href=\"lihatbuku.html\">Lihat Buku</a></li>\n"
                        + "                        </ul>\n"
                        + "                    </li>\n"
                        + "                    <li class=\"treeview\">\n"
                        + "                        <a href=\"#\"><i class=\"fa fa-newspaper-o\"></i> <span>Transaksi</span>\n"
                        + "						<span class=\"pull-right-container\">\n"
                        + "							<i class=\"fa fa-angle-left pull-right\"></i>\n"
                        + "						</span>\n"
                        + "						</a>\n"
                        + "                        <ul class=\"treeview-menu\">\n"
                        + "							<li><a href=\"lihattransaksi.html\">Lihat Transaksi</a></li>\n"
                        + "                            <li><a href=\"peminjamanlangsung.html\">Peminjaman Langsung</a></li>\n"
                        + "                            <li><a href=\"validasipemesanan.html\">Validasi Pemesanan</a></li>\n"
                        + "                            <li><a href=\"pengembalianbuku.html\">Pengembalian Buku</a></li>\n"
                        + "                            <li><a href=\"pembatalanpesanan.html\">Pembatalan Pesanan</a></li>\n"
                        + "                        </ul>\n"
                        + "                    </li>\n"
                        + "                    <li>\n"
                        + "						<a href=\"../logout\">\n"
                        + "						<i class=\"glyphicon glyphicon-log-out\"></i> <span>Keluar</span>\n"
                        + "						</a>\n"
                        + "					</li>\n"
                        + "                </ul>\n"
                        + "            </section>\n"
                        + "        </aside>\n"
                        + "\n"
                        + "            <!-- Isi -->\n"
                        + "            <div class=\"content-wrapper\"><br>\n"
                        + "                <section class=\"content-header\">\n"
                        + "                    <ol class=\"breadcrumb\">\n"
                        + "                        <li><a href=\"index.html\"><i class=\"fa fa-dashboard\"></i>Staff</a></li>\n"
                        + "                        <li class=\"active\">peminjamanlangsung</li>\n"
                        + "                    </ol>\n"
                        + "                </section>\n"
                        + "                <!-- Scroll -->\n"
                        + "                <script src=\"../dist/js/adminlte.min.js\"></script>\n"
                        + "                <div class=\"row\">\n"
                        + "                    <div class=\"col-xs-12\">\n"
                        + "                        <div class=\"page-header\">\n"
                        + "                            <!-- Judul -->\n"
                        + "                            <h1>\n"
                        + "                                <form method=\"post\" action=\"./peminjamanlangsung.html\">\n"
                        + "                                    <div class=\"col-sm-8\">\n"
                        + "                                        <div class=\"row\"><div class=\"col-sm-8\"><a style=\"text-decoration: none; color: inherit;\" href=\"index.html\">\n"
                        + "                                                    <img src=\"../resources/table_icons/blogs.png\"> Peminjaman Langsung</a></div>\n"
                        + "                                            <div class=\"col-sm-8\">\n"
                        + "                                                <br><h3>ID Peminjaman</h3>\n"
                        + "                                            </div>\n"
                        + "                                            <div class=\"col-sm-5\">		\n"
                        + "                                                <div class=\"input-group\" id=\"quick-search\">\n"
                        + "                                                    <input type=\"text\" id=\"SearchString\" name=\"katakuncipeminjam\" value=\"\" class=\"form-control\" placeholder=\"Cari\">\n"
                        + "                                                    <span class=\"input-group-btn\">\n"
                        + "                                                        <button name=\"Search_x\" value=\"1\" id=\"Search\" type=\"submit\" onClick=\"#\" class=\"btn btn-default\" title=\"Quick Search\"><i class=\"glyphicon glyphicon-search\"></i></button>\n"
                        + "                                                    </span>\n"
                        + "                                                </div>			\n"
                        + "                                            </div>\n"
                        + "                                            <div class=\"col-sm-8\">\n"
                        + "                                                <h3>ID Buku</h3>\n"
                        + "                                            </div>\n"
                        + "                                            <div class=\"col-sm-5\">		\n"
                        + "                                                <div class=\"input-group\" id=\"quick-search\">\n"
                        + "                                                    <input type=\"text\" id=\"SearchString\" name=\"katakuncibuku\" value=\"\" class=\"form-control\" placeholder=\"Cari\">\n"
                        + "                                                    <span class=\"input-group-btn\">\n"
                        + "                                                        <button name=\"Search_x\" value=\"1\" id=\"Search\" type=\"submit\" onClick=\"#\" class=\"btn btn-default\" title=\"Quick Search\"><i class=\"glyphicon glyphicon-search\"></i></button>\n"
                        + "                                                    </span>\n"
                        + "                                                </div>			\n"
                        + "                                            </div>\n"
                        + "                                        </div>\n"
                        + "                                    </div>\n"
                        + "                                </form>\n"
                        + "                            </h1>\n"
                        + "                        </div>\n"
                        + "                    </div>\n"
                        + "                    <span><br></span>\n"
                        + "                    <form method=\"post\" name=\"myform\" action=\"../StaffPeminjamanLangsungSimpan\">\n"
                        + "                        <div class=\"col-sm-12\">		\n"
                        + "                            <div class=\"col-xs-12 detail_view \">\n"
                        + "                                <div class=\"panel panel-default\">\n"
                        + "                                    <a name=\"detail-view\"></a>\n"
                        + "                                    <div class=\"panel-heading\">\n"
                        + "                                        <h3 class=\"panel-title\"><strong>Detail</strong></h3>\n"
                        + "                                    </div>\n"
                        + "                                    <div class=\"panel-body\" id=\"Users_dv_container\">\n"
                        + "                                        <div class=\"row\">\n"
                        + "                                            <div class=\"col-md-8 col-lg-10\" id=\"Users_dv_form\">\n"
                        + "                                                <div class=\"panel-heading\">\n"
                        + "                                                    <h3 class=\"panel-title\"><strong>Detail Peminjam</strong></h3>\n"
                        + "                                                </div>\n"
                        + "                                                        <fieldset class=\"form-horizontal\">\n"
                        + "                                                            <div class=\"form-group\">\n"
                        + "                                                                <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                                <label for=\"Membership_Number\" class=\"control-label col-lg-3\">ID User</label>\n"
                        + "                                                                <div class=\"col-lg-9\">\n"
                        + "                                                                    <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"idpeminjam\" id=\"Membership_Number\" value=\"" + idpeminjam + "\" readonly>\n"
                        + "                                                                </div>\n"
                        + "                                                            </div>\n"
                        + "                                                            <div class=\"form-group\">\n"
                        + "                                                                <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                                <label for=\"Name\" class=\"control-label col-lg-3\">Username</label>\n"
                        + "                                                                <div class=\"col-lg-9\">\n"
                        + "                                                                    <input maxlength=\"140\" type=\"text\" class=\"form-control\" name=\"usernamepeminjam\" id=\"Name\" value=\"" + usernamepeminjam + "\" readonly>\n"
                        + "                                                                </div>\n"
                        + "                                                            </div>\n"
                        + "                                                            <div class=\"form-group\">\n"
                        + "                                                                <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                                <label for=\"Contact\" class=\"control-label col-lg-3\">Nama</label>\n"
                        + "                                                                <div class=\"col-lg-9\">\n"
                        + "                                                                    <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"namapeminjam\" id=\"Contact\" value=\"" + namapeminjam + "\" readonly>\n"
                        + "                                                                </div>\n"
                        + "                                                            </div>\n"
                        + "                                                            <div class=\"form-group\">\n"
                        + "                                                                <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                                <label for=\"Contact\" class=\"control-label col-lg-3\">Alamat</label>\n"
                        + "                                                                <div class=\"col-lg-9\">\n"
                        + "                                                                    <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"alamatpeminjam\" id=\"Contact\" value=\"" + alamatpeminjam + "\" readonly>\n"
                        + "                                                                </div>\n"
                        + "                                                            </div>\n"
                        + "                                                        </fieldset>\n"
                        + "                                                        <hr>\n"
                        + "                                                        <div class=\"panel-heading\">\n"
                        + "                                                            <h3 class=\"panel-title\"><strong>Buku Detail");

                if (statusBuku.equalsIgnoreCase("dipinjam") || statusBuku.equalsIgnoreCase("dipesan")) {
                    out.println(" - <font color=\"red\">" + statusBuku + "</font>");
                }

                out.println("</strong></h3>\n"
                        + "                                                        </div>\n"
                        + "                                                        <fieldset class=\"form-horizontal\">\n"
                        + "                                                            <div class=\"form-group\">\n"
                        + "                                                                <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                                <label for=\"Membership_Number\" class=\"control-label col-lg-3\">ID Buku</label>\n"
                        + "                                                                <div class=\"col-lg-9\">\n"
                        + "                                                                    <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"idbuku\" id=\"Membership_Number\" value=\"" + idbuku + "\" readonly>\n"
                        + "                                                                </div>\n"
                        + "                                                            </div>\n"
                        + "                                                            <div class=\"form-group\">\n"
                        + "                                                                <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                                <label for=\"Name\" class=\"control-label col-lg-3\">Judul Buku</label>\n"
                        + "                                                                <div class=\"col-lg-9\">\n"
                        + "                                                                    <input maxlength=\"140\" type=\"text\" class=\"form-control\" name=\"judulbuku\" id=\"Name\" value=\"" + judulbuku + "\" readonly>\n"
                        + "                                                                </div>\n"
                        + "                                                            </div>\n"
                        + "                                                            <div class=\"form-group\">\n"
                        + "                                                                <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                                <label for=\"Contact\" class=\"control-label col-lg-3\">Penerbit</label>\n"
                        + "                                                                <div class=\"col-lg-9\">\n"
                        + "                                                                    <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"penerbit\" id=\"Contact\" value=\"" + penerbit + "\" readonly>\n"
                        + "                                                                </div>\n"
                        + "                                                            </div>\n"
                        + "                                                            <div class=\"form-group\">\n"
                        + "                                                                <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                                <label for=\"Contact\" class=\"control-label col-lg-3\">Pengarang</label>\n"
                        + "                                                                <div class=\"col-lg-9\">\n"
                        + "                                                                    <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"pengarang\" id=\"Contact\" value=\"" + pengarang + "\" readonly>\n"
                        + "                                                                </div>\n"
                        + "                                                            </div>\n"
                        + "                                                            <div class=\"form-group\">\n"
                        + "                                                                <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                                <label for=\"Contact\" class=\"control-label col-lg-3\">Tahun Terbit</label>\n"
                        + "                                                                <div class=\"col-lg-9\">\n"
                        + "                                                                    <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"tahunterbit\" id=\"Contact\" value=\"" + tahunterbit + "\" readonly>\n"
                        + "                                                                </div>\n"
                        + "                                                            </div>\n"
                        + "                                                            <div class=\"form-group\">\n"
                        + "                                                                <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                                <label for=\"Contact\" class=\"control-label col-lg-3\">Kategori</label>\n"
                        + "                                                                <div class=\"col-lg-9\">\n"
                        + "                                                                    <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"kategori\" id=\"Contact\" value=\"" + kategori + "\" readonly>\n"
                        + "                                                                </div>\n"
                        + "                                                            </div>\n"
                        + "                                                            <div class=\"form-group\">\n"
                        + "                                                                <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                                <label for=\"Contact\" class=\"control-label col-lg-3\">Status</label>\n"
                        + "                                                                <div class=\"col-lg-9\">\n"
                        + "                                                                    <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"status\" id=\"Contact\" value=\"" + statusBuku + "\" readonly>\n"
                        + "                                                                </div>\n"
                        + "                                                            </div>\n"
                        + "                                                        </fieldset>\n"
                        + "                                            </div>\n"
                        + "                                            <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                            <div class=\"col-md-4 col-lg-2\" id=\"Users_dv_action_buttons\">\n");
                if (statusBuku.equalsIgnoreCase("tersedia")) {
                    out.println("                                                        <div class=\"btn-toolbar\">\n"
                            + "                                                            <br><br>\n"
                            + "                                                            <div class=\"btn-group-vertical btn-group-lg\" style=\"width: 100%;\">\n"
                            + "                                                                <button type=\"submit\" class=\"btn btn-success\" id=\"insert\" name=\"insert_x\" value=\"1\" onclick=\"return Users_validateData();\"><i class=\"glyphicon glyphicon-plus-sign\"></i> Konfirmasi</button>\n"
                            + "                                                            </div>\n"
                            + "                                                        </div>\n");
                }
                out.println("                                            </div>\n"
                        + "                                        </div>\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "                            </div>	\n"
                        + "                        </div>\n"
                        + "                    </form>\n"
                        + "                </div>\n"
                        + "            </div>\n"
                        + "        </div>\n"
                        + "    </div>\n"
                        + "</div>\n"
                        + "</body>\n"
                        + "\n"
                        + "</html>");

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
