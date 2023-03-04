
package hotel;

import java.sql.DriverManager;
import java.sql.Connection;


public class MyConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/QL_KHACHSAN?useUnicode=true&characterEncoding=UTF-8";
            Class.forName("com.mysql.jdbc.Driver");
            String username = "root";
            String password = "vantoan123";
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(java.sql.Connection c) {
        try {
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
