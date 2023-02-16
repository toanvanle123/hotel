
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
            e.printStackTrace();// TODO: handle exception
        }
        return conn;
    }

    public static void closeConnection(java.sql.Connection c) {
        try {
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // </editor-fold>//GEN-END:initComponents
    //GEN-FIRST:event_jTablePHONGMouseClicked
    //GEN-LAST:event_jTablePHONGMouseClicked
    //GEN-LAST:event_them3ActionPerformed
    //GEN-FIRST:event_them3ActionPerformed
    //GEN-FIRST:event_sua3ActionPerformed
    //GEN-LAST:event_sua3ActionPerformed
    //GEN-FIRST:event_xoa3ActionPerformed
    //GEN-LAST:event_xoa3ActionPerformed
    //GEN-FIRST:event_thoat3ActionPerformed
    //GEN-LAST:event_thoat3ActionPerformed
    //GEN-FIRST:event_jButtonclear3ActionPerformed
    //GEN-LAST:event_jButtonclear3ActionPerformed
}
