package staff;

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
import ws.perpus.PerpustakaanWS_Service;

/**
 *
 * @author Rosemary
 */
public class StaffHome extends HttpServlet {

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

            } else if (session.getAttribute("status").toString().equalsIgnoreCase("staff")) {

                String query = "select count(idbuku) from buku";
                Statement statement = conn.getConnection().createStatement();
                ResultSet result = statement.executeQuery(query);

//            status untuk membuat session berisi hak akses
                result.next();
                int jumlahBuku = result.getInt(1);

                query = "select count(iduser) from member";
                statement = conn.getConnection().createStatement();
                result = statement.executeQuery(query);

                result.next();
                int jumlahMember = result.getInt(1);

                query = "select count(idpeminjaman) from peminjaman";
                statement = conn.getConnection().createStatement();
                result = statement.executeQuery(query);

                result.next();
                int jumlahPeminjaman = result.getInt(1);

                query = "select count(idpemesanan) from pemesanan";
                statement = conn.getConnection().createStatement();
                result = statement.executeQuery(query);

                result.next();
                int jumlahPemesanan = result.getInt(1);

                int jumlahTransaksi = jumlahPeminjaman + jumlahPemesanan;

                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "\n"
                        + "<head>\n"
                        + "    <title>Perpustakaan SMKN 1 Sedayu</title>\n"
                        + "    <link rel=\"stylesheet\" href=\"../bower_components/font-awesome/css/font-awesome.min.css\">\n"
                        + "    <link rel=\"stylesheet\" href=\"../bower_components/Ionicons/css/ionicons.min.css\">\n"
                        + "    <link rel=\"stylesheet\" href=\"../dist/css/AdminLTE.min.css\">\n"
                        + "    <link rel=\"stylesheet\" href=\"../dist/css/skins/skin-yellow.min.css\">\n"
                        + "    <link rel=\"stylesheet\" href=\"../resources/initializr/css/bootstrap.css\">\n"
                        + "    <link rel=\"stylesheet\" href=\"../resources/initializr/css/bootstrap-theme.css\">\n"
                        + "    <link rel=\"stylesheet\" href=\"../resources/lightbox/css/lightbox.css\" media=\"screen\">\n"
                        + "    <link rel=\"stylesheet\" href=\"../resources/select2/select2.css\" media=\"screen\">\n"
                        + "    <link rel=\"stylesheet\" href=\"../resources/timepicker/bootstrap-timepicker.min.css\" media=\"screen\">\n"
                        + "    <link rel=\"stylesheet\" href=\"../resources/datepicker/css/datepicker.css\" media=\"screen\">\n"
                        + "    <link rel=\"stylesheet\" href=\"../dynamic.css.php\">\n"
                        + "    <script src=\"../resources/jquery/js/jquery-1.12.4.min.js\"></script>\n"
                        + "    <script src=\"../resources/jquery/js/jquery.mark.min.js\"></script>\n"
                        + "    <script src=\"../resources/initializr/js/vendor/bootstrap.min.js\"></script>\n"
                        + "    <script src=\"../resources/lightbox/js/prototype.js\"></script>\n"
                        + "    <script src=\"../resources/lightbox/js/scriptaculous.js?load=effects\"></script>\n"
                        + "    <script src=\"../resources/select2/select2.min.js\"></script>\n"
                        + "    <script src=\"../resources/timepicker/bootstrap-timepicker.min.js\"></script>\n"
                        + "    <script src=\"../resources/jscookie/js.cookie.js\"></script>\n"
                        + "    <script src=\"../resources/datepicker/js/datepicker.packed.js\"></script>\n"
                        + "    <script src=\"../common.js.php\"></script>\n"
                        + "   \n"
                        + "</head>\n"
                        + "\n"
                        + "<body class=\"hold-transition skin-yellow sidebar-mini\">\n"
                        + "    <div class=\"wrapper\">\n"
                        + "        <!-- HEADER -->\n"
                        + "        <header class=\"main-header\">\n"
                        + "            <a href=\"index.html\" class=\"logo\">\n"
                        + "                <span class=\"logo-mini\">Menu</span>\n"
                        + "                <span class=\"logo-lg\"><b>Staff Panel</b></span>\n"
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
                        + "		\n"
                        + "		<!-- Isi -->\n"
                        + "        <div class=\"content-wrapper\"><br>\n"
                        + "            <section class=\"content-header\">\n"
                        + "                <h1>Staff<small>Control panel</small></h1>\n"
                        + "                <ol class=\"breadcrumb\">\n"
                        + "                    <li><a href=\"index.html\"><i class=\"fa fa-dashboard\"></i>Staff</a></li>\n"
                        + "                    <li class=\"active\">dashboard</li>\n"
                        + "                </ol>\n"
                        + "            </section>\n"
                        + "			<!-- Scroll -->\n"
                        + "            <script src=\"../dist/js/adminlte.min.js\"></script>\n"
                        + "            <!DOCTYPE html>\n"
                        + "            <html>\n"
                        + "            <head>\n"
                        + "                <title>Dashboard</title>\n"
                        + "                <link id=\"browser_favicon\" rel=\"shortcut icon\" href=\"../resources/images/appgini-icon.png\">\n"
                        + "                <link rel=\"stylesheet\" href=\"../resources/initializr/css/bootstrap.css\">\n"
                        + "                <link rel=\"stylesheet\" href=\"../resources/initializr/css/bootstrap-theme.css\">\n"
                        + "                <link rel=\"stylesheet\" href=\"../resources/lightbox/css/lightbox.css\" media=\"screen\">\n"
                        + "                <link rel=\"stylesheet\" href=\"../resources/select2/select2.css\" media=\"screen\">\n"
                        + "                <link rel=\"stylesheet\" href=\"../resources/timepicker/bootstrap-timepicker.min.css\" media=\"screen\">\n"
                        + "                <link rel=\"stylesheet\" href=\"../resources/datepicker/css/datepicker.css\" media=\"screen\">\n"
                        + "                <link rel=\"stylesheet\" href=\"../dynamic.css.php\">\n"
                        + "                <script src=\"../resources/jquery/js/jquery-1.12.4.min.js\"></script>\n"
                        + "                <script src=\"../resources/jquery/js/jquery.mark.min.js\"></script>\n"
                        + "                <script src=\"../resources/initializr/js/vendor/bootstrap.min.js\"></script>\n"
                        + "                <script src=\"../resources/lightbox/js/prototype.js\"></script>\n"
                        + "                <script src=\"../resources/lightbox/js/scriptaculous.js?load=effects\"></script>\n"
                        + "                <script src=\"../resources/select2/select2.min.js\"></script>\n"
                        + "                <script src=\"../resources/timepicker/bootstrap-timepicker.min.js\"></script>\n"
                        + "                <script src=\"../resources/jscookie/js.cookie.js\"></script>\n"
                        + "                <script src=\"../resources/datepicker/js/datepicker.packed.js\"></script>\n"
                        + "                <script src=\"../common.js.php\"></script>\n"
                        + "            </head>\n"
                        + "			<body>\n"
                        + "				<div class=\"row\">\n"
                        + "					<div class=\"col-lg-3 col-xs-6\">\n"
                        + "						<div class=\"small-box bg-aqua\">\n"
                        + "							<div class=\"inner\">\n"
                        + "								<h3>" + jumlahBuku + "</h3>\n"
                        + "								<p>Buku</p>\n"
                        + "							</div>\n"
                        + "							<div class=\"icon\">\n"
                        + "								<i class=\"fa fa-book\"></i>\n"
                        + "							</div>\n"
                        + "							<a href=\"lihatbuku.html\" class=\"small-box-footer\">Selengkapnya <i class=\"fa fa-arrow-circle-right\"></i></a>\n"
                        + "						</div>\n"
                        + "					</div>\n"
                        + "					<div class=\"col-lg-3 col-xs-6\">\n"
                        + "						<div class=\"small-box bg-green\">\n"
                        + "							<div class=\"inner\">\n"
                        + "								<h3>" + jumlahMember + "</h3>\n"
                        + "								<p>Member</p>\n"
                        + "							</div>\n"
                        + "							<div class=\"icon\">\n"
                        + "								<i class=\"fa fa-group\"></i>\n"
                        + "							</div>\n"
                        + "							<a href=\"lihatmember.html\" class=\"small-box-footer\">Selengkapnya <i class=\"fa fa-arrow-circle-right\"></i></a>\n"
                        + "						</div>\n"
                        + "					</div>\n"
                        + "					<div class=\"col-lg-3 col-xs-6\">\n"
                        + "						<div class=\"small-box bg-yellow\">\n"
                        + "							<div class=\"inner\">\n"
                        + "								<h3>" + jumlahTransaksi + "</h3>\n"
                        + "								<p>Transaksi</p>\n"
                        + "							</div>\n"
                        + "							<div class=\"icon\">\n"
                        + "								<i class=\"fa fa-newspaper-o\"></i>\n"
                        + "							</div>\n"
                        + "							<a href=\"lihattransaksi.html\" class=\"small-box-footer\">Selengkapnya <i class=\"fa fa-arrow-circle-right\"></i></a>\n"
                        + "						</div>\n"
                        + "					</div>\n"
                        + "					<div class=\"col-lg-3 col-xs-6\">\n"
                        + "						<div class=\"small-box bg-red\">\n"
                        + "							<div class=\"inner\">\n"
                        + "								<h3>" + getTanggalHome() + "</h3>\n"
                        + "								<p>Tanggal Hari Ini</p>\n"
                        + "							</div>\n"
                        + "							<div class=\"icon\">\n"
                        + "								<i class=\"fa fa-dashboard\"></i>\n"
                        + "							</div>\n"
                        + "							<a  class=\"small-box-footer\">-</a>\n"
                        + "						</div>\n"
                        + "					</div>\n"
                        + "				</div>\n"
                        + "			</body>\n"
                        + "		</div>\n"
                        + "	</div>\n"
                        + "</body>\n"
                        + "</html>\n"
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

    private String getTanggalHome() {
        PerpustakaanWS_Service service = new PerpustakaanWS_Service();
        ws.perpus.PerpustakaanWS port = service.getPerpustakaanWSPort();
        return port.getTanggalHome();
    }
}
