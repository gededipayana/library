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
public class AdminLihatMember extends HttpServlet {

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

            } else if (session.getAttribute("status").toString().equalsIgnoreCase("admin")) {

                String query = "select * from member";
                Statement statement = conn.getConnection().createStatement();
                ResultSet result = statement.executeQuery(query);

                //status untuk membuat session berisi hak akses
                out.println("<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "\n"
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
                        + "        <!-- HEADER -->\n"
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
                        + "                        <strong><a href=\"index.html\" class=\"text-success\">" + session.getAttribute("username") + "</a></strong>\n<br>"
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
                        + "                        <a href=\"#\"><i class=\"fa fa-users\"></i> <span> Member</span>\n"
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
                        + "        <div class=\"content-wrapper\"><br>\n"
                        + "            <section class=\"content-header\">\n"
                        + "                <ol class=\"breadcrumb\">\n"
                        + "                    <li><a href=\"index.html\"><i class=\"fa fa-dashboard\"></i>Admin</a></li>\n"
                        + "                    <li class=\"active\">lihatmember</li>\n"
                        + "                </ol>\n"
                        + "            </section>\n"
                        + "			<!-- Scroll -->\n"
                        + "            <script src=\"../dist/js/adminlte.min.js\"></script>\n"
                        + "            <div class=\"row\">\n"
                        + "                <div class=\"col-xs-12\">\n"
                        + "                    <form method=\"post\" name=\"myform\" action=\"./lihatmember.html\">"
                        + "                        <input id=\"EnterAction\" type=\"submit\" style=\"position: absolute; left: 0px; top: -250px;\" onclick=\"return enterAction();\">\n"
                        + "                        <div class=\"page-header\">\n"
                        + "                            <h1>\n"
                        + "								<div class=\"row\"><div class=\"col-sm-8\"><a style=\"text-decoration: none; color: inherit;\" href=\"index.html\">\n"
                        + "								<img src=\"../resources/table_icons/group.png\"> Member</a></div>\n"
                        + "									<div class=\"col-sm-4\">		\n"
                        + "										<div class=\"input-group\" id=\"quick-search\">\n"
                        + "											<input type=\"text\" id=\"SearchString\" name=\"katakunci\" value=\"\" class=\"form-control\" placeholder=\"Cari ID Member / Nama\">\n"
                        + "												<span class=\"input-group-btn\">\n"
                        + "													<button name=\"Search_x\" value=\"1\" id=\"Search\" type=\"submit\" onClick=\"#\" class=\"btn btn-default\" title=\"Cari\"><i class=\"glyphicon glyphicon-search\"></i></button>\n"
                        + "												</span>\n"
                        + "										</div>			\n"
                        + "									</div>\n"
                        + "								</div>\n"
                        + "							</h1>\n"
                        + "                        </div>\n"
                        + "                        <div id=\"top_buttons\" class=\"hidden-print\">\n"
                        + "                            <div class=\"btn-group btn-group-lg visible-md visible-lg all_records pull-left\">\n"
                        + "							<link rel=\"stylesheet\" href=\"../text.css\">\n"
                        + "                               <button type=\"submit\" class=\"btn btn-success\"><i class=\"glyphicon glyphicon-plus-sign\"></i><a href=\"tambahmember.html\"> Tambah Member</a></button>\n"
                        + "                                <button type=\"submit\" class=\"btn btn-success\"><i class=\"glyphicon glyphicon-check\"></i><a href=\"editmember.html\"> Edit Member</a></button>\n"
                        + "                                <button type=\"submit\" class=\"btn btn-success\" href=\"hapusmember.html\"><i class=\"glyphicon glyphicon-remove-circle\"></i><a href=\"hapusmember.html\"> Hapus Member</a></button>\n"
                        + "                            </div>\n"
                        + "                            <div class=\"row\">\n"
                        + "                                <div class=\"table_view col-xs-12 \">\n"
                        + "                                    <div class=\"table-responsive\">\n"
                        + "                                        <table class=\"table table-striped table-bordered table-hover\">\n"
                        + "                                            <thead>\n"
                        + "                                                <tr>\n"
                        + "                                                    <th>ID Member</th>\n"
                        + "                                                    <th>Username</th>\n"
                        + "                                                    <th>Nama</th>\n"
                        + "                                                    <th>Alamat</th>\n"
                        + "                                                    <th>Email</th>\n"
                        + "                                                    <th>No Telp</th>\n"
                        + "                                                    <th>Status</th>\n"
                        + "                                                </tr>\n"
                        + "                                            </thead>\n"
                        + "                                            <tbody>\n");
                while (result.next()) {
                    out.println("<tr>\n");
                    out.println("<td>" + result.getString(1) + "</td>");
                    out.println("<td>" + result.getString(2) + "</td>");
                    out.println("<td>" + result.getString(4) + "</td>");
                    out.println("<td>" + result.getString(6) + "</td>");
                    out.println("<td>" + result.getString(5) + "</td>");
                    out.println("<td>" + result.getString(7) + "</td>");
                    out.println("<td>" + result.getString(8) + "</td>");
                    out.println("</tr>\n");
                }
                out.println("                                            </tbody>\n"
                        + "                                        </table>\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "							</div>\n"
                        + "                        </div>\n"
                        + "                    </form>\n"
                        + "                </div>\n"
                        + "            </div>\n"
                        + "        </div>\n"
                        + "	</div>\n"
                        + "</body>\n"
                        + "\n"
                        + "</html>"
                );
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

                String kataKunci = request.getParameter("katakunci").toUpperCase();

                String query = "select * from member where iduser like '%" + kataKunci + "%' or nama like '%" + kataKunci + "%'";
                Statement statement = conn.getConnection().createStatement();
                ResultSet result = statement.executeQuery(query);

                //status untuk membuat session berisi hak akses
                out.println("<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "\n"
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
                        + "        <!-- HEADER -->\n"
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
                        + "                        <strong><a href=\"index.html\" class=\"text-success\">" + session.getAttribute("username") + "</a></strong>\n<br>"
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
                        + "                        <a href=\"#\"><i class=\"fa fa-users\"></i> <span> Member</span>\n"
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
                        + "        <div class=\"content-wrapper\"><br>\n"
                        + "            <section class=\"content-header\">\n"
                        + "                <ol class=\"breadcrumb\">\n"
                        + "                    <li><a href=\"index.html\"><i class=\"fa fa-dashboard\"></i>Admin</a></li>\n"
                        + "                    <li class=\"active\">lihatmember</li>\n"
                        + "                </ol>\n"
                        + "            </section>\n"
                        + "			<!-- Scroll -->\n"
                        + "            <script src=\"../dist/js/adminlte.min.js\"></script>\n"
                        + "            <div class=\"row\">\n"
                        + "                <div class=\"col-xs-12\">\n"
                        + "                    <form method=\"post\" name=\"myform\" action=\"./lihatmember.html\">"
                        + "                        <input id=\"EnterAction\" type=\"submit\" style=\"position: absolute; left: 0px; top: -250px;\" onclick=\"return enterAction();\">\n"
                        + "                        <div class=\"page-header\">\n"
                        + "                            <h1>\n"
                        + "								<div class=\"row\"><div class=\"col-sm-8\"><a style=\"text-decoration: none; color: inherit;\" href=\"index.html\">\n"
                        + "								<img src=\"../resources/table_icons/group.png\"> Member</a></div>\n"
                        + "									<div class=\"col-sm-4\">		\n"
                        + "										<div class=\"input-group\" id=\"quick-search\">\n"
                        + "											<input type=\"text\" id=\"SearchString\" name=\"katakunci\" value=\"\" class=\"form-control\" placeholder=\"Cari ID Member / Nama\">\n"
                        + "												<span class=\"input-group-btn\">\n"
                        + "													<button name=\"Search_x\" value=\"1\" id=\"Search\" type=\"submit\" onClick=\"#\" class=\"btn btn-default\" title=\"Cari\"><i class=\"glyphicon glyphicon-search\"></i></button>\n"
                        + "												</span>\n"
                        + "										</div>			\n"
                        + "									</div>\n"
                        + "								</div>\n"
                        + "							</h1>\n"
                        + "                        </div>\n"
                        + "                        <div id=\"top_buttons\" class=\"hidden-print\">\n"
                        + "                            <div class=\"btn-group btn-group-lg visible-md visible-lg all_records pull-left\">\n"
                        + "							<link rel=\"stylesheet\" href=\"../text.css\">\n"
                        + "                               <button type=\"submit\" class=\"btn btn-success\"><i class=\"glyphicon glyphicon-plus-sign\"></i><a href=\"tambahmember.html\"> Tambah Member</a></button>\n"
                        + "                                <button type=\"submit\" class=\"btn btn-success\"><i class=\"glyphicon glyphicon-check\"></i><a href=\"editmember.html\"> Edit Member</a></button>\n"
                        + "                                <button type=\"submit\" class=\"btn btn-success\" href=\"hapusmember.html\"><i class=\"glyphicon glyphicon-remove-circle\"></i><a href=\"hapusmember.html\"> Hapus Member</a></button>\n"
                        + "                            </div>\n"
                        + "                            <div class=\"row\">\n"
                        + "                                <div class=\"table_view col-xs-12 \">\n"
                        + "                                    <div class=\"table-responsive\">\n"
                        + "                                        <table class=\"table table-striped table-bordered table-hover\">\n"
                        + "                                            <thead>\n"
                        + "                                                <tr>\n"
                        + "                                                    <th>ID Member</th>\n"
                        + "                                                    <th>Username</th>\n"
                        + "                                                    <th>Nama</th>\n"
                        + "                                                    <th>Alamat</th>\n"
                        + "                                                    <th>Email</th>\n"
                        + "                                                    <th>No Telp</th>\n"
                        + "                                                    <th>Status</th>\n"
                        + "                                                </tr>\n"
                        + "                                            </thead>\n"
                        + "                                            <tbody>\n");

                while (result.next()) {
                    out.println("<tr>\n");
                    out.println("<td>" + result.getString(1) + "</td>");
                    out.println("<td>" + result.getString(2) + "</td>");
                    out.println("<td>" + result.getString(4) + "</td>");
                    out.println("<td>" + result.getString(6) + "</td>");
                    out.println("<td>" + result.getString(5) + "</td>");
                    out.println("<td>" + result.getString(7) + "</td>");
                    out.println("<td>" + result.getString(8) + "</td>");
                    out.println("</tr>\n");
                }
                out.println("                                            </tbody>\n"
                        + "                                        </table>\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "							</div>\n"
                        + "                        </div>\n"
                        + "                    </form>\n"
                        + "                </div>\n"
                        + "            </div>\n"
                        + "        </div>\n"
                        + "	</div>\n"
                        + "</body>\n"
                        + "\n"
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
