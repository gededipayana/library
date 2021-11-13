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
public class AdminTambahMember extends HttpServlet {

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

        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();

            if (session.getAttribute("status") == null) {
                response.sendRedirect("../home");

            } else if (session.getAttribute("status").toString().equalsIgnoreCase("admin")) {
                out.println("<!DOCTYPE html>\n"
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
                        + "\n"
                        + "    </head>\n"
                        + "    <body class=\"hold-transition skin-yellow sidebar-mini\">\n"
                        + "        <div class=\"wrapper\">\n"
                        + "            <!-- HEADER -->\n"
                        + "            <header class=\"main-header\">\n"
                        + "                <a href=\"index.html\" class=\"logo\">\n"
                        + "                    <span class=\"logo-mini\">Menu</span>\n"
                        + "                    <span class=\"logo-lg\"><b>Admin Panel</b></span>\n"
                        + "                </a>\n"
                        + "                <nav class=\"navbar navbar-static-top\" role=\"navigation\">\n"
                        + "                    <a href=\"#\" class=\"sidebar-toggle\" data-toggle=\"push-menu\" role=\"button\">\n"
                        + "                    </a>\n"
                        + "                </nav>\n"
                        + "            </header>\n"
                        + "\n"
                        + "            <!-- Slide Kanan -->\n"
                        + "            <aside class=\"main-sidebar\">\n"
                        + "                <section class=\"sidebar\"><br>\n"
                        + "                    <div class=\"user-panel\">\n"
                        + "                        <div class=\"pull-left image\">\n"
                        + "                            <img src=\"../dist/img/ic10.png\" class=\"img-circle\" alt=\"User Image\">\n"
                        + "                        </div>\n"
                        + "                        <div class=\"pull-left info\">\n"
                        + "                            <strong><a href=\"index.html\" class=\"text-success\">" + session.getAttribute("username") + "</a></strong>\n<br>"
                        + "                            <a href=\"#\"><i class=\"fa fa-circle text-success\"></i> Online</a>\n"
                        + "                        </div>\n"
                        + "                    </div>\n"
                        + "\n"
                        + "                    <ul class=\"sidebar-menu\" data-widget=\"tree\">\n"
                        + "                        <li class=\"header\"></li>\n"
                        + "                        <li class=\"active\">\n"
                        + "                            <a href=\"index.html\"><i class=\"fa fa-dashboard\"></i>\n"
                        + "                                <span>Dashboard</span>\n"
                        + "                            </a>\n"
                        + "                        </li>\n"
                        + "                        <li class=\"treeview\">\n"
                        + "                            <a href=\"#\"><i class=\"fa fa-users\"></i> <span>Member</span>\n"
                        + "                                <span class=\"pull-right-container\">\n"
                        + "                                    <i class=\"fa fa-angle-left pull-right\"></i>\n"
                        + "                                </span>\n"
                        + "                            </a>\n"
                        + "                            <ul class=\"treeview-menu\">\n"
                        + "                                <li><a href=\"lihatmember.html\">Lihat Member</a></li>\n"
                        + "                                <li><a href=\"tambahmember.html\">Tambah Member</a></li>\n"
                        + "                                <li><a href=\"editmember.html\">Edit Member</a></li>\n"
                        + "                                <li><a href=\"hapusmember.html\">Hapus Member</a></li>\n"
                        + "                            </ul>\n"
                        + "                        </li>\n"
                        + "                        <li class=\"treeview\">\n"
                        + "                            <a href=\"#\"><i class=\"fa fa-book\"></i> \n"
                        + "                                <span>Buku</span>\n"
                        + "                                <span class=\"pull-right-container\">\n"
                        + "                                    <i class=\"fa fa-angle-left pull-right\"></i>\n"
                        + "                                </span>\n"
                        + "                            </a>\n"
                        + "                            <ul class=\"treeview-menu\">\n"
                        + "                                <li><a href=\"lihatbuku.html\">Lihat Buku</a></li>\n"
                        + "                                <li><a href=\"tambahbuku.html\">Tambah Buku</a></li>\n"
                        + "                                <li><a href=\"editbuku.html\">Edit Buku</a></li>\n"
                        + "                            </ul>\n"
                        + "                        </li>\n"
                        + "                        <li class=\"treeview\">\n"
                        + "                            <a href=\"#\"><i class=\"fa fa-newspaper-o\"></i> <span>Transaksi</span>\n"
                        + "                                <span class=\"pull-right-container\">\n"
                        + "                                    <i class=\"fa fa-angle-left pull-right\"></i>\n"
                        + "                                </span>\n"
                        + "                            </a>\n"
                        + "                            <ul class=\"treeview-menu\">\n"
                        + "                                <li><a href=\"lihattransaksi.html\">Lihat Transaksi</a></li>\n"
                        + "                                <li><a href=\"peminjamanlangsung.html\">Peminjaman Langsung</a></li>\n"
                        + "                                <li><a href=\"validasipemesanan.html\">Validasi Pemesanan</a></li>\n"
                        + "                                <li><a href=\"pengembalianbuku.html\">Pengembalian Buku</a></li>\n"
                        + "                                <li><a href=\"pembatalanpesanan.html\">Pembatalan Pesanan</a></li>\n"
                        + "                            </ul>\n"
                        + "                        </li>\n"
                        + "                        <li>\n"
                        + "                            <a href=\"../logout\">\n"
                        + "                                <i class=\"glyphicon glyphicon-log-out\"></i> <span>Keluar</span>\n"
                        + "                            </a>\n"
                        + "                        </li>\n"
                        + "                    </ul>\n"
                        + "                </section>\n"
                        + "            </aside>\n"
                        + "\n"
                        + "            <!-- Isi -->\n"
                        + "            <div class=\"content-wrapper\">\n"
                        + "                <br>\n"
                        + "                <section class=\"content-header\">\n"
                        + "                    <ol class=\"breadcrumb\">\n"
                        + "                        <li><a href=\"index.html\"><i class=\"fa fa-dashboard\"></i>Admin</a></li>\n"
                        + "                        <li class=\"active\">tambahmember</li>\n"
                        + "                    </ol>\n"
                        + "                </section>\n"
                        + "                <script src=\"../dist/js/adminlte.min.js\"></script>\n"
                        + "\n"
                        + "                <div class=\"row\">\n"
                        + "                    <div class=\"col-xs-12\">\n"
                        + "                        <form method=\"post\" name=\"myform\" action=\"./tambahmember.html\">\n"
                        + "                            <div class=\"page-header\">\n"
                        + "                                <h1><a style=\"text-decoration: none; color: inherit;\" href=\"tambahmember.html\"><img src=\"../resources/table_icons/group.png\"> Tambah Member</a></h1>\n"
                        + "                            </div>\n"
                        + "                            <div class=\"col-xs-12 detail_view \">\n"
                        + "                                <div class=\"panel panel-default\">\n"
                        + "                                    <a name=\"detail-view\"></a>\n"
                        + "                                    <div class=\"panel-heading\">\n"
                        + "                                        <h3 class=\"panel-title\"><strong>Detail Member</strong></h3>\n"
                        + "                                    </div>\n"
                        + "                                    <div class=\"panel-body\" id=\"Users_dv_container\">\n"
                        + "                                        <div class=\"row\">\n"
                        + "                                            <div class=\"col-md-8 col-lg-10\" id=\"Users_dv_form\">\n"
                        + "                                                <fieldset class=\"form-horizontal\">\n"
                        + "                                                    <div class=\"form-group\">\n"
                        + "                                                        <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                        <label for=\"Membership_Number\" class=\"control-label col-lg-3\">ID Member</label>\n"
                        + "                                                        <div class=\"col-lg-9\">\n"
                        + "                                                            <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"iduser\" id=\"Membership_Number\" value=\"\">\n"
                        + "                                                        </div>\n"
                        + "                                                    </div>\n"
                        + "                                                    <div class=\"form-group\">\n"
                        + "                                                        <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                        <label for=\"Name\" class=\"control-label col-lg-3\">Username</label>\n"
                        + "                                                        <div class=\"col-lg-9\">\n"
                        + "                                                            <input maxlength=\"140\" type=\"text\" class=\"form-control\" name=\"username\" id=\"Name\" value=\"\">\n"
                        + "                                                        </div>\n"
                        + "                                                    </div>\n"
                        + "                                                    <div class=\"form-group\">\n"
                        + "                                                        <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                        <label for=\"Name\" class=\"control-label col-lg-3\">Password</label>\n"
                        + "                                                        <div class=\"col-lg-9\">\n"
                        + "                                                            <input maxlength=\"140\" type=\"text\" class=\"form-control\" name=\"pass\" id=\"Name\" value=\"\">\n"
                        + "                                                        </div>\n"
                        + "                                                    </div>\n"
                        + "                                                    <div class=\"form-group\">\n"
                        + "                                                        <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                        <label for=\"Name\" class=\"control-label col-lg-3\">Nama</label>\n"
                        + "                                                        <div class=\"col-lg-9\">\n"
                        + "                                                            <input maxlength=\"140\" type=\"text\" class=\"form-control\" name=\"nama\" id=\"Name\" value=\"\">\n"
                        + "                                                        </div>\n"
                        + "                                                    </div>\n"
                        + "                                                    <div class=\"form-group\">\n"
                        + "                                                        <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                        <label for=\"Contact\" class=\"control-label col-lg-3\">Alamat</label>\n"
                        + "                                                        <div class=\"col-lg-9\">\n"
                        + "                                                            <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"alamat\" id=\"Contact\" value=\"\">\n"
                        + "                                                        </div>\n"
                        + "                                                    </div>\n"
                        + "                                                    <div class=\"form-group\">\n"
                        + "                                                        <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                        <label for=\"Contact\" class=\"control-label col-lg-3\">Email</label>\n"
                        + "                                                        <div class=\"col-lg-9\">\n"
                        + "                                                            <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"email\" id=\"Contact\" value=\"\">\n"
                        + "                                                        </div>\n"
                        + "                                                    </div>\n"
                        + "                                                    <div class=\"form-group\">\n"
                        + "                                                        <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                        <label for=\"Contact\" class=\"control-label col-lg-3\">No Telp</label>\n"
                        + "                                                        <div class=\"col-lg-9\">\n"
                        + "                                                            <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"notelp\" id=\"Contact\" value=\"\">\n"
                        + "                                                        </div>\n"
                        + "                                                    </div>\n"
                        + "\n"
                        + "\n"
                        + "\n"
                        + "                                                    <div class=\"form-group\">\n"
                        + "                                                        <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                        <label for=\"Purchase_Date\" class=\"control-label col-lg-3\">Status</label>\n"
                        + "                                                        <div class=\"col-lg-9\">\n"
                        + "                                                            <table style=\"width: 100%;\"><tr><td style=\"width: calc(50% - 4em);\" class=\"date_combo\"><select name=\"status\" id=\"Purchase_Date-mm\" class=\"form-control\" style=\"\">\n"
                        + "                                                                            <option value=\"\">&nbsp;</option>\n"
                        + "                                                                            <option value=\"ADMIN\">ADMIN</option>\n"
                        + "                                                                            <option value=\"STAFF\">STAFF</option>\n"
                        + "                                                                            <option value=\"PEMINJAM\">PEMINJAM</option>\n"
                        + "                                                                </tr></table>\n"
                        + "                                                        </div>\n"
                        + "                                                    </div>\n"
                        + "\n"
                        + "\n"
                        + "                                                </fieldset>\n"
                        + "                                            </div>\n"
                        + "                                            <div class=\"col-md-4 col-lg-2\" id=\"Users_dv_action_buttons\">\n"
                        + "                                                <div class=\"btn-toolbar\">\n"
                        + "                                                    <div class=\"btn-group-vertical btn-group-lg\" style=\"width: 100%;\">\n"
                        + "                                                        <button type=\"reset\" class=\"btn btn-default\" id=\"deselect\" name=\"deselect_x\" value=\"Reset\">\n"
                        + "                                                            <i class=\"glyphicon glyphicon-chevron-left\"></i> Bersihkan</button>\n"
                        + "                                                    </div>\n"
                        + "                                                    <p></p>\n"
                        + "                                                    <div class=\"btn-group-vertical btn-group-lg\" style=\"width: 100%;\">\n"
                        + "                                                        <button type=\"submit\" class=\"btn btn-success\" id=\"insert\" name=\"insert_x\" value=\"1\" onclick=\"return confirm('Apakah anda yakin ingin menambahkan data ini?');\"><i class=\"glyphicon glyphicon-plus-sign\"></i> Simpan</button>\n"
                        + "                                                    </div>\n"
                        + "                                                </div>\n"
                        + "                                            </div>\n"
                        + "                                        </div>\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "                            </div>\n"
                        + "                        </form>\n"
                        + "                    </div>\n"
                        + "                </div>\n"
                        + "            </div>\n"
                        + "        </div>\n"
                        + "    </body>\n"
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
        response.setContentType("text/html");
        DataBaseConnection conn = new DataBaseConnection();
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();

            if (session.getAttribute("status") == null) {
                response.sendRedirect("../home");

            } else if (session.getAttribute("status").toString().equalsIgnoreCase("admin")) {
                String iduser = request.getParameter("iduser").toUpperCase();
                String username = request.getParameter("username").toUpperCase();
                String pass = request.getParameter("pass");
                String nama = request.getParameter("nama").toUpperCase();
                String alamat = request.getParameter("alamat").toUpperCase();
                String email = request.getParameter("email").toUpperCase();
                String noTelp = request.getParameter("notelp").toUpperCase();
                String status = request.getParameter("status");

                //apabila salah satu tidak terisi
                if (iduser.equals("") || username.equals("") || pass.equals("") || nama.equals("") || status.equals("")) {
                    response.sendRedirect("./tambahmember.html");
                } else { //cek user sudah ada atau belum di database
                    String query = "select * from member where iduser = '" + iduser + "'";
                    Statement statement = conn.getConnection().createStatement();
                    ResultSet result = statement.executeQuery(query);

                    String found = "";
                    while (result.next()) {
                        found = result.getString(1);
                    }

                    if (found.equals("")) { //buat member jika belum ada
                        String query2 = "insert into member values ('" + iduser + "', '" + username + "', '" + pass + "', '" + nama + "', '"
                                + email + "', '" + alamat + "', '" + noTelp + "', '" + status + "')";
                        Statement statement2 = conn.getConnection().createStatement();
                        statement2.executeUpdate(query2);
                        response.sendRedirect("./lihatmember.html");
                        statement2.close();
                    } else { //jika iduser ditemukan sama di dalam database
                        out.println("<!DOCTYPE html>\n"
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
                                + "\n"
                                + "    </head>\n"
                                + "    <body class=\"hold-transition skin-yellow sidebar-mini\">\n"
                                + "        <div class=\"wrapper\">\n"
                                + "            <!-- HEADER -->\n"
                                + "            <header class=\"main-header\">\n"
                                + "                <a href=\"index.html\" class=\"logo\">\n"
                                + "                    <span class=\"logo-mini\">Menu</span>\n"
                                + "                    <span class=\"logo-lg\"><b>Admin Panel</b></span>\n"
                                + "                </a>\n"
                                + "                <nav class=\"navbar navbar-static-top\" role=\"navigation\">\n"
                                + "                    <a href=\"#\" class=\"sidebar-toggle\" data-toggle=\"push-menu\" role=\"button\">\n"
                                + "                    </a>\n"
                                + "                </nav>\n"
                                + "            </header>\n"
                                + "\n"
                                + "            <!-- Slide Kanan -->\n"
                                + "            <aside class=\"main-sidebar\">\n"
                                + "                <section class=\"sidebar\"><br>\n"
                                + "                    <div class=\"user-panel\">\n"
                                + "                        <div class=\"pull-left image\">\n"
                                + "                            <img src=\"../dist/img/ic10.png\" class=\"img-circle\" alt=\"User Image\">\n"
                                + "                        </div>\n"
                                + "                        <div class=\"pull-left info\">\n"
                                + "                            <strong><a href=\"index.html\" class=\"text-success\">" + session.getAttribute("username") + "</a></strong>\n<br>"
                                + "                            <a href=\"#\"><i class=\"fa fa-circle text-success\"></i> Online</a>\n"
                                + "                        </div>\n"
                                + "                    </div>\n"
                                + "\n"
                                + "                    <ul class=\"sidebar-menu\" data-widget=\"tree\">\n"
                                + "                        <li class=\"header\"></li>\n"
                                + "                        <li class=\"active\">\n"
                                + "                            <a href=\"index.html\"><i class=\"fa fa-dashboard\"></i>\n"
                                + "                                <span>Dashboard</span>\n"
                                + "                            </a>\n"
                                + "                        </li>\n"
                                + "                        <li class=\"treeview\">\n"
                                + "                            <a href=\"#\"><i class=\"fa fa-users\"></i> <span>Member</span>\n"
                                + "                                <span class=\"pull-right-container\">\n"
                                + "                                    <i class=\"fa fa-angle-left pull-right\"></i>\n"
                                + "                                </span>\n"
                                + "                            </a>\n"
                                + "                            <ul class=\"treeview-menu\">\n"
                                + "                                <li><a href=\"lihatmember.html\">Lihat Member</a></li>\n"
                                + "                                <li><a href=\"tambahmember.html\">Tambah Member</a></li>\n"
                                + "                                <li><a href=\"editmember.html\">Edit Member</a></li>\n"
                                + "                                <li><a href=\"hapusmember.html\">Hapus Member</a></li>\n"
                                + "                            </ul>\n"
                                + "                        </li>\n"
                                + "                        <li class=\"treeview\">\n"
                                + "                            <a href=\"#\"><i class=\"fa fa-book\"></i> \n"
                                + "                                <span>Buku</span>\n"
                                + "                                <span class=\"pull-right-container\">\n"
                                + "                                    <i class=\"fa fa-angle-left pull-right\"></i>\n"
                                + "                                </span>\n"
                                + "                            </a>\n"
                                + "                            <ul class=\"treeview-menu\">\n"
                                + "                                <li><a href=\"lihatbuku.html\">Lihat Buku</a></li>\n"
                                + "                                <li><a href=\"tambahbuku.html\">Tambah Buku</a></li>\n"
                                + "                                <li><a href=\"editbuku.html\">Edit Buku</a></li>\n"
                                + "                            </ul>\n"
                                + "                        </li>\n"
                                + "                        <li class=\"treeview\">\n"
                                + "                            <a href=\"#\"><i class=\"fa fa-newspaper-o\"></i> <span>Transaksi</span>\n"
                                + "                                <span class=\"pull-right-container\">\n"
                                + "                                    <i class=\"fa fa-angle-left pull-right\"></i>\n"
                                + "                                </span>\n"
                                + "                            </a>\n"
                                + "                            <ul class=\"treeview-menu\">\n"
                                + "                                <li><a href=\"lihattransaksi.html\">Lihat Transaksi</a></li>\n"
                                + "                                <li><a href=\"peminjamanlangsung.html\">Peminjaman Langsung</a></li>\n"
                                + "                                <li><a href=\"validasipemesanan.html\">Validasi Pemesanan</a></li>\n"
                                + "                                <li><a href=\"pengembalianbuku.html\">Pengembalian Buku</a></li>\n"
                                + "                                <li><a href=\"pembatalanpesanan.html\">Pembatalan Pesanan</a></li>\n"
                                + "                            </ul>\n"
                                + "                        </li>\n"
                                + "                        <li>\n"
                                + "                            <a href=\"../logout\">\n"
                                + "                                <i class=\"glyphicon glyphicon-log-out\"></i> <span>Keluar</span>\n"
                                + "                            </a>\n"
                                + "                        </li>\n"
                                + "                    </ul>\n"
                                + "                </section>\n"
                                + "            </aside>\n"
                                + "\n"
                                + "            <!-- Isi -->\n"
                                + "            <div class=\"content-wrapper\">\n"
                                + "                <br>\n"
                                + "                <section class=\"content-header\">\n"
                                + "                    <ol class=\"breadcrumb\">\n"
                                + "                        <li><a href=\"index.html\"><i class=\"fa fa-dashboard\"></i>Admin</a></li>\n"
                                + "                        <li class=\"active\">tambahmember</li>\n"
                                + "                    </ol>\n"
                                + "                </section>\n"
                                + "                <script src=\"../dist/js/adminlte.min.js\"></script>\n"
                                + "\n"
                                + "                <div class=\"row\">\n"
                                + "                    <div class=\"col-xs-12\">\n"
                                + "                        <form method=\"post\" name=\"myform\" action=\"./tambahmember.html\">\n"
                                + "                            <div class=\"page-header\">\n"
                                + "                                <h1><a style=\"text-decoration: none; color: inherit;\" href=\"tambahmember.html\"><img src=\"../resources/table_icons/group.png\"> Tambah Member</a></h1>\n"
                                + "                            </div>\n"
                                + "                            <div class=\"col-xs-12 detail_view \">\n"
                                + "                                <div class=\"panel panel-default\">\n"
                                + "                                    <a name=\"detail-view\"></a>\n"
                                + "                                    <div class=\"panel-heading\">\n"
                                + "                                        <h3 class=\"panel-title\"><strong>Detail Member - <font color=\"red\">Member sudah terdaftar</font></strong></h3>\n"
                                + "                                    </div>\n"
                                + "                                    <div class=\"panel-body\" id=\"Users_dv_container\">\n"
                                + "                                        <div class=\"row\">\n"
                                + "                                            <div class=\"col-md-8 col-lg-10\" id=\"Users_dv_form\">\n"
                                + "                                                <fieldset class=\"form-horizontal\">\n"
                                + "                                                    <div class=\"form-group\">\n"
                                + "                                                        <hr class=\"hidden-md hidden-lg\">\n"
                                + "                                                        <label for=\"Membership_Number\" class=\"control-label col-lg-3\">ID Member</label>\n"
                                + "                                                        <div class=\"col-lg-9\">\n"
                                + "                                                            <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"iduser\" id=\"Membership_Number\" value=\"" + iduser + "\">\n"
                                + "                                                        </div>\n"
                                + "                                                    </div>\n"
                                + "                                                    <div class=\"form-group\">\n"
                                + "                                                        <hr class=\"hidden-md hidden-lg\">\n"
                                + "                                                        <label for=\"Name\" class=\"control-label col-lg-3\">Username</label>\n"
                                + "                                                        <div class=\"col-lg-9\">\n"
                                + "                                                            <input maxlength=\"140\" type=\"text\" class=\"form-control\" name=\"username\" id=\"Name\" value=\"" + username + "\">\n"
                                + "                                                        </div>\n"
                                + "                                                    </div>\n"
                                + "                                                    <div class=\"form-group\">\n"
                                + "                                                        <hr class=\"hidden-md hidden-lg\">\n"
                                + "                                                        <label for=\"Name\" class=\"control-label col-lg-3\">Password</label>\n"
                                + "                                                        <div class=\"col-lg-9\">\n"
                                + "                                                            <input maxlength=\"140\" type=\"text\" class=\"form-control\" name=\"pass\" id=\"Name\" value=\"" + pass + "\">\n"
                                + "                                                        </div>\n"
                                + "                                                    </div>\n"
                                + "                                                    <div class=\"form-group\">\n"
                                + "                                                        <hr class=\"hidden-md hidden-lg\">\n"
                                + "                                                        <label for=\"Name\" class=\"control-label col-lg-3\">Nama</label>\n"
                                + "                                                        <div class=\"col-lg-9\">\n"
                                + "                                                            <input maxlength=\"140\" type=\"text\" class=\"form-control\" name=\"nama\" id=\"Name\" value=\"" + nama + "\">\n"
                                + "                                                        </div>\n"
                                + "                                                    </div>\n"
                                + "                                                    <div class=\"form-group\">\n"
                                + "                                                        <hr class=\"hidden-md hidden-lg\">\n"
                                + "                                                        <label for=\"Contact\" class=\"control-label col-lg-3\">Alamat</label>\n"
                                + "                                                        <div class=\"col-lg-9\">\n"
                                + "                                                            <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"alamat\" id=\"Contact\" value=\"" + alamat + "\">\n"
                                + "                                                        </div>\n"
                                + "                                                    </div>\n"
                                + "                                                    <div class=\"form-group\">\n"
                                + "                                                        <hr class=\"hidden-md hidden-lg\">\n"
                                + "                                                        <label for=\"Contact\" class=\"control-label col-lg-3\">Email</label>\n"
                                + "                                                        <div class=\"col-lg-9\">\n"
                                + "                                                            <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"email\" id=\"Contact\" value=\"" + email + "\">\n"
                                + "                                                        </div>\n"
                                + "                                                    </div>\n"
                                + "                                                    <div class=\"form-group\">\n"
                                + "                                                        <hr class=\"hidden-md hidden-lg\">\n"
                                + "                                                        <label for=\"Contact\" class=\"control-label col-lg-3\">No Telp</label>\n"
                                + "                                                        <div class=\"col-lg-9\">\n"
                                + "                                                            <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"notelp\" id=\"Contact\" value=\"" + noTelp + "\">\n"
                                + "                                                        </div>\n"
                                + "                                                    </div>\n"
                                + "\n"
                                + "\n"
                                + "\n"
                                + "                                                    <div class=\"form-group\">\n"
                                + "                                                        <hr class=\"hidden-md hidden-lg\">\n"
                                + "                                                        <label for=\"Purchase_Date\" class=\"control-label col-lg-3\">Status</label>\n"
                                + "                                                        <div class=\"col-lg-9\">\n"
                                + "                                                            <table style=\"width: 100%;\"><tr><td style=\"width: calc(50% - 4em);\" class=\"date_combo\"><select name=\"status\" id=\"Purchase_Date-mm\" class=\"form-control\" style=\"\">\n"
                                + "                                                                            <option value=\"\">&nbsp;</option>\n"
                                + "                                                                            <option value=\"ADMIN\">ADMIN</option>\n"
                                + "                                                                            <option value=\"STAFF\">STAFF</option>\n"
                                + "                                                                            <option value=\"PEMINJAM\">PEMINJAM</option>\n"
                                + "                                                                </tr></table>\n"
                                + "                                                        </div>\n"
                                + "                                                    </div>\n"
                                + "\n"
                                + "\n"
                                + "                                                </fieldset>\n"
                                + "                                            </div>\n"
                                + "                                            <div class=\"col-md-4 col-lg-2\" id=\"Users_dv_action_buttons\">\n"
                                + "                                                <div class=\"btn-toolbar\">\n"
                                + "                                                    <div class=\"btn-group-vertical btn-group-lg\" style=\"width: 100%;\">\n"
                                + "                                                        <button type=\"reset\" class=\"btn btn-default\" id=\"deselect\" name=\"deselect_x\" value=\"Reset\">\n"
                                + "                                                            <i class=\"glyphicon glyphicon-chevron-left\"></i> Bersihkan</button>\n"
                                + "                                                    </div>\n"
                                + "                                                    <p></p>\n"
                                + "                                                    <div class=\"btn-group-vertical btn-group-lg\" style=\"width: 100%;\">\n"
                                + "                                                        <button type=\"submit\" class=\"btn btn-success\" id=\"insert\" name=\"insert_x\" value=\"1\" onclick=\"return confirm('Apakah anda yakin ingin menambahkan data ini?');\"><i class=\"glyphicon glyphicon-plus-sign\"></i> Simpan</button>\n"
                                + "                                                    </div>\n"
                                + "                                                </div>\n"
                                + "                                            </div>\n"
                                + "                                        </div>\n"
                                + "                                    </div>\n"
                                + "                                </div>\n"
                                + "                            </div>\n"
                                + "                        </form>\n"
                                + "                    </div>\n"
                                + "                </div>\n"
                                + "            </div>\n"
                                + "        </div>\n"
                                + "    </body>\n"
                                + "</html>");
                    }

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
