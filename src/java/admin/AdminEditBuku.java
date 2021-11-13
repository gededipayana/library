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
public class AdminEditBuku extends HttpServlet {

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
                out.println("<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "<head>\n"
                        + "    <title>Perpustakaan SMKN 1 Sedayu</title>\n"
                        + "    <link rel=\"stylesheet\" href=\"../bower_components/bootstrap/dist/css/bootstrap.min.css\">\n"
                        + "    <link rel=\"stylesheet\" href=\"../bower_components/font-awesome/css/font-awesome.min.css\">\n"
                        + "    <link rel=\"stylesheet\" href=\"../dist/css/AdminLTE.min.css\">\n"
                        + "    <link rel=\"stylesheet\" href=\"../dist/css/skins/skin-yellow.min.css\">\n"
                        + "    <link rel=\"stylesheet\" href=\"../resources/initializr/css/bootstrap.css\">\n"
                        + "    <link rel=\"stylesheet\" href=\"../resources/initializr/css/bootstrap-theme.css\">\n"
                        + "    <script src=\"../resources/jquery/js/jquery-1.12.4.min.js\"></script>\n"
                        + "    <script src=\"../resources/lightbox/js/prototype.js\"></script>\n"
                        + "    <script src=\"../resources/lightbox/js/scriptaculous.js?load=effects\"></script>\n"
                        + "    <script src=\"../resources/select2/select2.min.js\"></script>\n"
                        + "    <script src=\"../resources/timepicker/bootstrap-timepicker.min.js\"></script>\n"
                        + "    <script src=\"../resources/jscookie/js.cookie.js\"></script>\n"
                        + "    <script src=\"../resources/datepicker/js/datepicker.packed.js\"></script>\n"
                        + "    <script src=\"../common.js.php\"></script>\n"
                        + "</head>\n"
                        + "<body class=\"hold-transition skin-yellow sidebar-mini\">\n"
                        + "    <div class=\"wrapper\">\n"
                        + "		<!-- HEADER -->\n"
                        + "        <header class=\"main-header\">\n"
                        + "            <a href=\"index.html\" class=\"logo\">\n"
                        + "                <span class=\"logo-mini\">Menu</span>\n"
                        + "                <span class=\"logo-lg\"><b>Admin Panel</b></span>\n"
                        + "            </a>\n"
                        + "            <nav class=\"navbar navbar-static-top\" role=\"navigation\">\n"
                        + "                <a href=\"#\" class=\"sidebar-toggle\" data-toggle=\"push-menu\" role=\"button\">\n"
                        + "                </a>\n"
                        + "            </nav>\n"
                        + "        </header>\n"
                        + "		\n"
                        + "		<!-- Slide Kanan -->\n"
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
                        + "                            <li><a href=\"tambahmember.html\">Tambah Member</a></li>\n"
                        + "                            <li><a href=\"editmember.html\">Edit Member</a></li>\n"
                        + "                            <li><a href=\"hapusmember.html\">Hapus Member</a></li>\n"
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
                        + "                            <li><a href=\"lihatbukua.html\">Lihat Buku</a></li>\n"
                        + "                            <li><a href=\"tambahbuku.html\">Tambah Buku</a></li>\n"
                        + "                            <li><a href=\"editbuku.html\">Edit Buku</a></li>\n"
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
                        + "							<li><a href=\"pembatalanpesanan.html\">Pembatalan Pesanan</a></li>\n"
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
                        + "		\n"
                        + "		<!-- Isi -->\n"
                        + "        <div class=\"content-wrapper\">\n"
                        + "            <br>\n"
                        + "            <section class=\"content-header\">\n"
                        + "\n"
                        + "                <ol class=\"breadcrumb\">\n"
                        + "                    <li><a href=\"index.html\"><i class=\"fa fa-dashboard\"></i>Admin</a></li>\n"
                        + "                    <li class=\"active\">editbuku</li>\n"
                        + "                </ol>\n"
                        + "            </section>\n"
                        + "			<!-- Scroll -->\n"
                        + "            <script src=\"../dist/js/adminlte.min.js\"></script>\n"
                        + "            <div class=\"row\">\n"
                        + "                <div class=\"col-xs-12\">\n"
                        + "                        <div class=\"page-header\">\n"
                        + "                            <h1><a style=\"text-decoration: none; color: inherit;\" href=\"editmember.html\"><img src=\"../resources/table_icons/books.png\"> Edit Buku</a></h1>\n"
                        + "                        </div>\n"
                        + "						<form method=\"post\" action=\"./editbuku.html\">\n"
                        + "						<h1>\n"
                        + "							<div class=\"row\">\n"
                        + "								<div class=\"col-sm-8\">\n"
                        + "									<h3>   Cari</h3>\n"
                        + "								</div>\n"
                        + "								<div class=\"col-sm-5\">		\n"
                        + "									<div class=\"input-group\" id=\"quick-search\">\n"
                        + "										<input type=\"text\" id=\"SearchString\" name=\"katakunci\" value=\"\" class=\"form-control\" placeholder=\"Cari ID Buku\">\n"
                        + "											<span class=\"input-group-btn\">\n"
                        + "												<button name=\"Search_x\" value=\"1\" id=\"Search\" type=\"submit\" onClick=\"#\" class=\"btn btn-default\" title=\"Cari\"><i class=\"glyphicon glyphicon-search\"></i></button>\n"
                        + "											</span>\n"
                        + "									</div>			\n"
                        + "								</div>\n"
                        + "						</h1>\n"
                        + "							</div>\n"
                        + "						</form>\n"
                        + "						<form method=\"post\" name=\"myform\" action=\"../AdminEditBukuSimpan\">\n"
                        + "                        <div class=\"col-xs-12 detail_view \">\n"
                        + "                            <div class=\"panel panel-default\">\n"
                        + "                                <a name=\"detail-view\"></a>\n"
                        + "                                <div class=\"panel-heading\">\n"
                        + "                                    <h3 class=\"panel-title\"><strong>Detail Buku</strong></h3></div>\n"
                        + "                                <div class=\"panel-body\" id=\"Users_dv_container\">\n"
                        + "                                    <div class=\"row\">\n"
                        + "                                        <div class=\"col-md-8 col-lg-10\" id=\"Users_dv_form\">\n"
                        + "                                            <fieldset class=\"form-horizontal\">\n"
                        + "                                                <div class=\"form-group\">\n"
                        + "                                                    <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                    <label for=\"Membership_Number\" class=\"control-label col-lg-3\">ID Buku</label>\n"
                        + "                                                    <div class=\"col-lg-9\">\n"
                        + "                                                        <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"idbuku\" id=\"Membership_Number\" value=\"\" readonly>\n"
                        + "                                                    </div>\n"
                        + "                                                </div>\n"
                        + "                                                <div class=\"form-group\">\n"
                        + "                                                    <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                    <label for=\"Name\" class=\"control-label col-lg-3\">Judul Buku</label>\n"
                        + "                                                    <div class=\"col-lg-9\">\n"
                        + "                                                        <input maxlength=\"140\" type=\"text\" class=\"form-control\" name=\"judulbuku\" id=\"Name\" value=\"\">\n"
                        + "                                                    </div>\n"
                        + "                                                </div>\n"
                        + "                                                <div class=\"form-group\">\n"
                        + "                                                    <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                    <label for=\"Contact\" class=\"control-label col-lg-3\">Penerbit</label>\n"
                        + "                                                    <div class=\"col-lg-9\">\n"
                        + "                                                        <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"penerbit\" id=\"Contact\" value=\"\">\n"
                        + "                                                    </div>\n"
                        + "                                                </div>\n"
                        + "                                                <div class=\"form-group\">\n"
                        + "                                                    <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                    <label for=\"Contact\" class=\"control-label col-lg-3\">Pengarang</label>\n"
                        + "                                                    <div class=\"col-lg-9\">\n"
                        + "                                                        <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"pengarang\" id=\"Contact\" value=\"\">\n"
                        + "                                                    </div>\n"
                        + "                                                </div>\n"
                        + "                                                <div class=\"form-group\">\n"
                        + "                                                    <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                    <label for=\"Contact\" class=\"control-label col-lg-3\">Tahun Terbit</label>\n"
                        + "                                                    <div class=\"col-lg-9\">\n"
                        + "                                                        <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"tahunterbit\" id=\"Contact\" value=\"\">\n"
                        + "                                                    </div>\n"
                        + "                                                </div>\n"
                        + "                                                <div class=\"form-group\">\n"
                        + "                                                    <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                    <label for=\"Contact\" class=\"control-label col-lg-3\">Kategori</label>\n"
                        + "                                                    <div class=\"col-lg-9\">\n"
                        + "                                                        <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"kategori\" id=\"Contact\" value=\"\">\n"
                        + "                                                    </div>\n"
                        + "                                                </div>\n"
                        + "                                            </fieldset>\n"
                        + "                                        </div>\n"
                        + "                                        <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                        <div class=\"col-md-4 col-lg-2\" id=\"Users_dv_action_buttons\">\n"
                        + "                                            <div class=\"btn-toolbar\">\n"
                        + "                                                <div class=\"btn-group-vertical btn-group-lg\" style=\"width: 100%;\">\n"
                        + "                                                    <button type=\"reset\" class=\"btn btn-default\" id=\"deselect\" name=\"deselect_x\" value=\"reset\" title=\"Reset\">\n"
                        + "													<i class=\"glyphicon glyphicon-chevron-left\"></i> Reset\n"
                        + "													</button>\n"
                        + "                                                </div>\n"
                        + "                                                <p></p>\n"
                        + "                                                <div class=\"btn-group-vertical btn-group-lg\" style=\"width: 100%;\">\n"
                        + "                                                    <button type=\"submit\" class=\"btn btn-success\" id=\"insert\" name=\"insert_x\" value=\"1\" onclick=\"return confirm( 'Apakah anda yakin ingin mengubah data ini?');\"><i class=\"glyphicon glyphicon-plus-sign\"></i> Simpan</button>\n"
                        + "                                                </div>\n"
                        + "                                            </div>\n"
                        + "                                        </div>\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "                            </div>\n"
                        + "                        </div>\n"
                        + "					</form>\n"
                        + "                </div>\n"
                        + "            </div>\n"
                        + "        </div>\n"
                        + "    </div>\n"
                        + "</body>\n"
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

            } else if (session.getAttribute("status").toString().equalsIgnoreCase("admin")) {
                String idbuku = request.getParameter("katakunci");

                String judulbuku = "", penerbit = "", pengarang = "", tahunterbit = "", kategori = "";

                String query = "select * from buku where idbuku = '" + idbuku + "'";
                Statement statement = conn.getConnection().createStatement();
                ResultSet result = statement.executeQuery(query);

                //status untuk membuat session berisi hak akses
                while (result.next()) {
                    judulbuku = result.getString(3);
                    penerbit = result.getString(4);
                    pengarang = result.getString(6);
                    tahunterbit = result.getString(5);
                    kategori = result.getString(2);
                }
                out.println("<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "<head>\n"
                        + "    <title>Perpustakaan SMKN 1 Sedayu</title>\n"
                        + "    <link rel=\"stylesheet\" href=\"../bower_components/bootstrap/dist/css/bootstrap.min.css\">\n"
                        + "    <link rel=\"stylesheet\" href=\"../bower_components/font-awesome/css/font-awesome.min.css\">\n"
                        + "    <link rel=\"stylesheet\" href=\"../dist/css/AdminLTE.min.css\">\n"
                        + "    <link rel=\"stylesheet\" href=\"../dist/css/skins/skin-yellow.min.css\">\n"
                        + "    <link rel=\"stylesheet\" href=\"../resources/initializr/css/bootstrap.css\">\n"
                        + "    <link rel=\"stylesheet\" href=\"../resources/initializr/css/bootstrap-theme.css\">\n"
                        + "    <script src=\"../resources/jquery/js/jquery-1.12.4.min.js\"></script>\n"
                        + "    <script src=\"../resources/lightbox/js/prototype.js\"></script>\n"
                        + "    <script src=\"../resources/lightbox/js/scriptaculous.js?load=effects\"></script>\n"
                        + "    <script src=\"../resources/select2/select2.min.js\"></script>\n"
                        + "    <script src=\"../resources/timepicker/bootstrap-timepicker.min.js\"></script>\n"
                        + "    <script src=\"../resources/jscookie/js.cookie.js\"></script>\n"
                        + "    <script src=\"../resources/datepicker/js/datepicker.packed.js\"></script>\n"
                        + "    <script src=\"../common.js.php\"></script>\n"
                        + "</head>\n"
                        + "<body class=\"hold-transition skin-yellow sidebar-mini\">\n"
                        + "    <div class=\"wrapper\">\n"
                        + "		<!-- HEADER -->\n"
                        + "        <header class=\"main-header\">\n"
                        + "            <a href=\"index.html\" class=\"logo\">\n"
                        + "                <span class=\"logo-mini\">Menu</span>\n"
                        + "                <span class=\"logo-lg\"><b>Admin Panel</b></span>\n"
                        + "            </a>\n"
                        + "            <nav class=\"navbar navbar-static-top\" role=\"navigation\">\n"
                        + "                <a href=\"#\" class=\"sidebar-toggle\" data-toggle=\"push-menu\" role=\"button\">\n"
                        + "                </a>\n"
                        + "            </nav>\n"
                        + "        </header>\n"
                        + "		\n"
                        + "		<!-- Slide Kanan -->\n"
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
                        + "                            <li><a href=\"tambahmember.html\">Tambah Member</a></li>\n"
                        + "                            <li><a href=\"editmember.html\">Edit Member</a></li>\n"
                        + "                            <li><a href=\"hapusmember.html\">Hapus Member</a></li>\n"
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
                        + "                            <li><a href=\"tambahbuku.html\">Tambah Buku</a></li>\n"
                        + "                            <li><a href=\"editbuku.html\">Edit Buku</a></li>\n"
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
                        + "							<li><a href=\"pembatalanpesanan.html\">Pembatalan Pesanan</a></li>\n"
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
                        + "		\n"
                        + "		<!-- Isi -->\n"
                        + "        <div class=\"content-wrapper\">\n"
                        + "            <br>\n"
                        + "            <section class=\"content-header\">\n"
                        + "\n"
                        + "                <ol class=\"breadcrumb\">\n"
                        + "                    <li><a href=\"index.html\"><i class=\"fa fa-dashboard\"></i>Admin</a></li>\n"
                        + "                    <li class=\"active\">editbuku</li>\n"
                        + "                </ol>\n"
                        + "            </section>\n"
                        + "			<!-- Scroll -->\n"
                        + "            <script src=\"../dist/js/adminlte.min.js\"></script>\n"
                        + "            <div class=\"row\">\n"
                        + "                <div class=\"col-xs-12\">\n"
                        + "                        <div class=\"page-header\">\n"
                        + "                            <h1><a style=\"text-decoration: none; color: inherit;\" href=\"editmember.html\"><img src=\"../resources/table_icons/books.png\"> Edit Buku</a></h1>\n"
                        + "                        </div>\n"
                        + "						<form method=\"post\" action=\"./editbuku.html\">\n"
                        + "						<h1>\n"
                        + "							<div class=\"row\">\n"
                        + "								<div class=\"col-sm-8\">\n"
                        + "									<h3>   Cari</h3>\n"
                        + "								</div>\n"
                        + "								<div class=\"col-sm-5\">		\n"
                        + "									<div class=\"input-group\" id=\"quick-search\">\n"
                        + "										<input type=\"text\" id=\"SearchString\" name=\"katakunci\" value=\"\" class=\"form-control\" placeholder=\"Cari ID Buku\">\n"
                        + "											<span class=\"input-group-btn\">\n"
                        + "												<button name=\"Search_x\" value=\"1\" id=\"Search\" type=\"submit\" onClick=\"#\" class=\"btn btn-default\" title=\"Quick Search\"><i class=\"glyphicon glyphicon-search\"></i></button>\n"
                        + "											</span>\n"
                        + "									</div>			\n"
                        + "								</div>\n"
                        + "						</h1>\n"
                        + "							</div>\n"
                        + "						</form>\n"
                        + "						<form method=\"post\" name=\"myform\" action=\"../AdminEditBukuSimpan\">\n"
                        + "                        <div class=\"col-xs-12 detail_view \">\n"
                        + "                            <div class=\"panel panel-default\">\n"
                        + "                                <a name=\"detail-view\"></a>\n"
                        + "                                <div class=\"panel-heading\">\n"
                        + "                                    <h3 class=\"panel-title\"><strong>Detail Buku</strong></h3></div>\n"
                        + "                                <div class=\"panel-body\" id=\"Users_dv_container\">\n"
                        + "                                    <div class=\"row\">\n"
                        + "                                        <div class=\"col-md-8 col-lg-10\" id=\"Users_dv_form\">\n"
                        + "                                            <fieldset class=\"form-horizontal\">\n"
                        + "                                                <div class=\"form-group\">\n"
                        + "                                                    <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                    <label for=\"Membership_Number\" class=\"control-label col-lg-3\">ID Buku</label>\n"
                        + "                                                    <div class=\"col-lg-9\">\n"
                        + "                                                        <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"idbuku\" id=\"Membership_Number\" value=" + idbuku + " readonly>\n"
                        + "                                                    </div>\n"
                        + "                                                </div>\n"
                        + "                                                <div class=\"form-group\">\n"
                        + "                                                    <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                    <label for=\"Name\" class=\"control-label col-lg-3\">Judul Buku</label>\n"
                        + "                                                    <div class=\"col-lg-9\">\n"
                        + "                                                        <input maxlength=\"140\" type=\"text\" class=\"form-control\" name=\"judulbuku\" id=\"Name\" value=" + judulbuku + ">\n"
                        + "                                                    </div>\n"
                        + "                                                </div>\n"
                        + "                                                <div class=\"form-group\">\n"
                        + "                                                    <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                    <label for=\"Contact\" class=\"control-label col-lg-3\">Penerbit</label>\n"
                        + "                                                    <div class=\"col-lg-9\">\n"
                        + "                                                        <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"penerbit\" id=\"Contact\" value=" + penerbit + ">\n"
                        + "                                                    </div>\n"
                        + "                                                </div>\n"
                        + "                                                <div class=\"form-group\">\n"
                        + "                                                    <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                    <label for=\"Contact\" class=\"control-label col-lg-3\">Pengarang</label>\n"
                        + "                                                    <div class=\"col-lg-9\">\n"
                        + "                                                        <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"pengarang\" id=\"Contact\" value=" + pengarang + ">\n"
                        + "                                                    </div>\n"
                        + "                                                </div>\n"
                        + "                                                <div class=\"form-group\">\n"
                        + "                                                    <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                    <label for=\"Contact\" class=\"control-label col-lg-3\">Tahun Terbit</label>\n"
                        + "                                                    <div class=\"col-lg-9\">\n"
                        + "                                                        <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"tahunterbit\" id=\"Contact\" value=" + tahunterbit + ">\n"
                        + "                                                    </div>\n"
                        + "                                                </div>\n"
                        + "                                                <div class=\"form-group\">\n"
                        + "                                                    <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                                    <label for=\"Contact\" class=\"control-label col-lg-3\">Kategori</label>\n"
                        + "                                                    <div class=\"col-lg-9\">\n"
                        + "                                                        <input maxlength=\"40\" type=\"text\" class=\"form-control\" name=\"kategori\" id=\"Contact\" value=" + kategori + ">\n"
                        + "                                                    </div>\n"
                        + "                                                </div>\n"
                        + "                                            </fieldset>\n"
                        + "                                        </div>\n"
                        + "                                        <hr class=\"hidden-md hidden-lg\">\n"
                        + "                                        <div class=\"col-md-4 col-lg-2\" id=\"Users_dv_action_buttons\">\n"
                        + "                                            <div class=\"btn-toolbar\">\n"
                        + "                                                <div class=\"btn-group-vertical btn-group-lg\" style=\"width: 100%;\">\n"
                        + "                                                    <button type=\"reset\" class=\"btn btn-default\" id=\"deselect\" name=\"deselect_x\" value=\"reset\" title=\"Reset\">\n"
                        + "													<i class=\"glyphicon glyphicon-chevron-left\"></i> Reset\n"
                        + "													</button>\n"
                        + "                                                </div>\n"
                        + "                                                <p></p>\n"
                        + "                                                <div class=\"btn-group-vertical btn-group-lg\" style=\"width: 100%;\">\n"
                        + "                                                    <button type=\"submit\" class=\"btn btn-success\" id=\"insert\" name=\"insert_x\" value=\"1\" onclick=\"return confirm( 'Apakah anda yakin ingin mengubah data ini?');\"><i class=\"glyphicon glyphicon-plus-sign\"></i> Simpan</button>\n"
                        + "                                                </div>\n"
                        + "                                            </div>\n"
                        + "                                        </div>\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "                            </div>\n"
                        + "                        </div>\n"
                        + "					</form>\n"
                        + "                </div>\n"
                        + "            </div>\n"
                        + "        </div>\n"
                        + "    </div>\n"
                        + "</body>\n"
                        + "</html>");
                statement.close();
                
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
