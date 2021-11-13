package peminjam;


import java.sql.*;

public class DataBaseConnection {
// Sesuaikan properti jdbcURL dengan basis data anda

    private String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
    private String user = "hr";
    private String password = "MHS175314023";
    private Connection connection = null;

    /**
     * Creates a new instance of UserConnection
     */
    public DataBaseConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(jdbcURL, user, password);
            System.out.println("Koneksi Berhasil!!!");
        } catch (Exception ex) {
            System.out.println("message: " + ex.getMessage());
        }
    }

    public boolean isConnected() {
        if (connection != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean getClosed() {
        if (isConnected()) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return true;
        } else {
            return false;
        }
    }

    public Connection getConnection() {
        return connection;
    }

}
