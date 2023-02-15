package hotel.Form;

import java.sql.*;
import java.util.ArrayList;
import javax.annotation.processing.Generated;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static hotel.MyConnection.getConnection;
import hotel.Phong;



public class phongform2 extends javax.swing.JFrame {


    public phongform2() {
        initComponents();
        getConnection();
        hienThiDanhSachPhong();
    }

    private void initComponents() {
    }

    Connection con=null;
    Statement st=null;

    public ArrayList<Phong> layDanhSachPhong() {
        ArrayList<Phong> dsp = new ArrayList<Phong>();
        Connection con = getConnection();
        try {
            st = (Statement) con.createStatement();
            String sql = "SELECT * FROM phong";
            ResultSet rs = st.executeQuery(sql);

            Phong p;
            while (rs.next()) {
                p = new Phong(rs.getString("MAPHONG"), rs.getString("TENPHONG"), rs.getString("LOAIPHONG"), rs.getDouble("GIAPHONG"), rs.getString("CHUTHICH"), rs.getString("TINHTRANG"), rs.getString("MANV"), rs.getString("MADV") );

                //Thêm vào danh sách
                dsp.add(p);
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return dsp;
    }
    public void hienThiDanhSachPhong() {
        String colTieuDe1[] = new String[]{"Mã Phòng", "Tên Phòng", "Loại Phòng", "Giá Phòng", "Chú Thích", "Tình Trạng", "Mã Nhân Viên", "Mã Dịch Vụ"};
        ArrayList<Phong> dsp = layDanhSachPhong();

        DefaultTableModel model = new DefaultTableModel(colTieuDe1, 0);

        Object[] row;

        for (int i = 0; i < dsp.size(); i++) {

            row = new Object[8];

            // GÁN GIÁ TRỊ
            row[0] = dsp.get(i).getMAPHONG();
            row[1] = dsp.get(i).getTENPHONG();
            row[2] = dsp.get(i).getLOAIPHONG();
            row[3] = dsp.get(i).getGIAPHONG();
            row[4] = dsp.get(i).getCHUTHICH();
            row[5] = dsp.get(i).getTINHTRANG();
            row[6] = dsp.get(i).getMANV();
            row[7] = dsp.get(i).getMADV();

            model.addRow(row);
        }

        //}catch(ArrayIndexOutOfBoundsException ex){



        jTablePHONG.setModel( model);

    }

    @SuppressWarnings("unchecked")
    Generated Code;
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents


    private void jTablePHONGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePHONGMouseClicked
        // TODO add your handling code here:
        JTable jTablePHONG = new JTable();
        int i = jTablePHONG.getSelectedRow();
        TableModel model = jTablePHONG.getModel();
        AbstractButton jTextFieldMAPHONG = null;
        jTextFieldMAPHONG.setText(model.getValueAt(i, 0).toString());
        AbstractButton jTextFieldTENPHONG = null;
        jTextFieldTENPHONG.setText(model.getValueAt(i, 1).toString());
        AbstractButton jTextFieldLOAIPHONG = null;
        jTextFieldLOAIPHONG.setText(model.getValueAt(i, 2).toString());
        AbstractButton jTextFieldGIAPHONG = null;
        jTextFieldGIAPHONG.setText(model.getValueAt(i, 3).toString());
        AbstractButton jTextFieldCHUTHICHP = null;
        jTextFieldCHUTHICHP.setText(model.getValueAt(i, 4).toString());
        AbstractButton jTextFieldTINHTRANG = null;
        jTextFieldTINHTRANG.setText(model.getValueAt(i, 5).toString());
        AbstractButton jTextFieldMANVP = null;
        jTextFieldMANVP.setText(model.getValueAt(i, 6).toString());
        AbstractButton jTextFieldMADVP = null;
        jTextFieldMADVP.setText(model.getValueAt(i, 7).toString());
    }//GEN-LAST:event_jTablePHONGMouseClicked

    private void them3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_them3ActionPerformed
        // TODO add your handling code here
//        Connection con = getConnection();
//        String insertSql = "INSERT INTO NhanVien(MAPHONG,TENPHONG,LOAIPHONG, GIAPHONG, CHUTHICH, TINHTRANG, MANV, MADV) " +
//                "VALUES(?, ?, ?, ?, ?, ?, ?,?)";
//        try (Connection connection = getConnection()) {
//            PreparedStatement statement = connection.prepareStatement(insertSql);
//
//            statement.setString(1, JTextFieldMAPHONG.getText());
//            statement.setString(2, jTextFieldTENPHONG.getText());
//            statement.setString(3, jTextFieldLOAIPHONG.getText());
//            statement.setDouble(4,Double.valueOf( jTextFieldGIAPHONG.getText()));
//            statement.setString(5, jTextFieldCHUTHICH.getText());
//            statement.setString(6,jTextFieldTINHTRANG.getText());
//            statement.setString(7, jTextFieldMANV.getText());
//            statement.setString(8, jTextFieldMADV.getText());
//            int rowsInserted = statement.executeUpdate();
//            if (rowsInserted > 0) {
//                System.out.println("Data has been successfully inserted into the database.");
//            }
//            hienThiDanhSachPhong();
//        } catch (SQLException e) {
//            System.err.println("Error while inserting data: " + e.getMessage());
//        }
        Connection con = getConnection();
        try {
            // Tạo một đối tượng để thực hiện công việc
            st = (Statement) con.createStatement();
            String query = "INSERT INTO phong(MAPHONG,TENPHONG, LOAIPHONG, GIAPHONG, CHUTHICH, TINHTRANG, MANV, MADV) VALUES('" + jTextFieldMAPHONG.getText() + "',"
                    + "'" + jTextFieldTENPHONG.getText() + "','" + jTextFieldLOAIPHONG.getText() + "', '" + jTextFieldGIAPHONG.getText() + "', '" + jTextFieldCHUTHICHP.getText() + "', '" + jTextFieldTINHTRANG.getText() + "', '" + jTextFieldMANVP.getText() + "', '" + jTextFieldMADVP.getText() + "')";

            st.execute(query);
            hienThiDanhSachPhong();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_them3ActionPerformed

    private void sua3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sua3ActionPerformed
        // TODO add your handling code here:
        if (jTablePHONG.getSelectedRow()==-1) {
            if (jTablePHONG.getRowCount()==0) {
                // lblError.setText("Table is empty");
            }
            else{
                //  lblError.setText("You must select a Tennis Player");
            }
        }
        else{
            DefaultTableModel model = (DefaultTableModel) jTablePHONG.getModel();
            model.setValueAt(jTextFieldMAPHONG.getText(), jTablePHONG.getSelectedRow(), 0);
            model.setValueAt(jTextFieldTENPHONG.getText().toString(), jTablePHONG.getSelectedRow(), 1);
            model.setValueAt(jTextFieldLOAIPHONG.getText(), jTablePHONG.getSelectedRow(), 2);
            model.setValueAt(jTextFieldGIAPHONG.getText(), jTablePHONG.getSelectedRow(), 3);
            model.setValueAt(jTextFieldCHUTHICHP.getText(), jTablePHONG.getSelectedRow(), 4);
            model.setValueAt(jTextFieldTINHTRANG.getText(), jTablePHONG.getSelectedRow(), 5);
            model.setValueAt(jTextFieldMANVP.getText(), jTablePHONG.getSelectedRow(), 6);
            model.setValueAt(jTextFieldMADVP.getText(), jTablePHONG.getSelectedRow(), 7);
        }
    }//GEN-LAST:event_sua3ActionPerformed

    private void xoa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoa3ActionPerformed
        // TODO add your handling code here:
        Connection con = getConnection();
        try {
            // Tạo một đối tượng để thực hiện công việc
            st = (Statement) con.createStatement();
            String query = "DELETE FROM phong WHERE MAPHONG = '" + jTextFieldMAPHONG.getText() + "'";
            st.executeUpdate(query);
            hienThiDanhSachPhong();

        } catch (Exception ex) {

            ex.printStackTrace();
        }

    }//GEN-LAST:event_xoa3ActionPerformed

    private void thoat3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thoat3ActionPerformed
        // TODO add your handling code here:
        thoat3.setToolTipText("Click để thoát chương trình ");
        int selected = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát chương"
                + " trình không", "Thông báo", JOptionPane.YES_NO_CANCEL_OPTION);
        if (selected == JOptionPane.YES_NO_OPTION) {
            this.dispose();

        }
    }//GEN-LAST:event_thoat3ActionPerformed

    private void jButtonclear3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonclear3ActionPerformed
        // TODO add your handling code here:
        jTextFieldMAPHONG.setText("");
        jTextFieldTENPHONG.setText("");
        jTextFieldLOAIPHONG.setText("");
        jTextFieldGIAPHONG.setText("");
        jTextFieldCHUTHICHP.setText("");
        jTextFieldTINHTRANG.setText("");
        jTextFieldMANVP.setText("");
        jTextFieldMADVP.setText("");
        jTextFieldMAPHONG.requestFocus();

    }//GEN-LAST:event_jButtonclear3ActionPerformed


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhongForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonclear3;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTablePHONG;
    private javax.swing.JTextField jTextFieldCHUTHICHP;
    private javax.swing.JTextField jTextFieldGIAPHONG;
    private javax.swing.JTextField jTextFieldLOAIPHONG;
    private javax.swing.JTextField jTextFieldMADVP;
    private javax.swing.JTextField jTextFieldMANVP;
    private javax.swing.JTextField jTextFieldMAPHONG;
    private javax.swing.JTextField jTextFieldTENPHONG;
    private javax.swing.JTextField jTextFieldTINHTRANG;
    private javax.swing.JButton sua3;
    private javax.swing.JButton them3;
    private javax.swing.JButton thoat3;
    private javax.swing.JButton xoa3;
    // End of variables declaration//GEN-END:variables
}