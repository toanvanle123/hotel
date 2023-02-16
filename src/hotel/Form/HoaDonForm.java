
package hotel.Form;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import hotel.HoaDon;
import static hotel.MyConnection.getConnection;

public class HoaDonForm extends javax.swing.JFrame {


    public HoaDonForm() {
        initComponents();
        getConnection();
        hienThiDanhSachHoaDon();
    }
    
    Connection con=null;
    Statement st=null;
    
    public ArrayList<HoaDon> layDanhSachHoaDon() {
        ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
        Connection con = getConnection();
        try {
            st = (Statement) con.createStatement();
            String sql = "SELECT * FROM hoadon";

            ResultSet rs = st.executeQuery(sql);

            HoaDon hd;
            while (rs.next()) {
                hd = new HoaDon(rs.getString("MAHD"), rs.getString("MANV"), rs.getString("MAPHONG"), rs.getDate("NGAY"), rs.getDouble("GIAHD") );


                dshd.add(hd);
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return dshd;
    }
     public void hienThiDanhSachHoaDon() {
        String colTieuDe1[] = new String[]{"Code Bill", "Employee Code", "Room Code", "Day", "Invoice Price"};
        ArrayList<HoaDon> dshd = layDanhSachHoaDon();

        DefaultTableModel model = new DefaultTableModel(colTieuDe1, 0);

        Object[] row;

        for (int i = 0; i < dshd.size(); i++) {

            row = new Object[5];


            row[0] = dshd.get(i).getMAHD();
            row[1] = dshd.get(i).getMANV();
            row[2] = dshd.get(i).getMAPHONG();
            row[3] = dshd.get(i).getNGAY();
            row[4] = dshd.get(i).getGIAHD();

            model.addRow(row);
        }
        


        jTableHOADON.setModel(model);

    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jTextFieldMAHD = new javax.swing.JTextField();
        jTextFieldMANVHD = new javax.swing.JTextField();
        jTextFieldMAPHONGHD = new javax.swing.JTextField();
        jTextFieldNGAY = new javax.swing.JTextField();
        jTextFieldGIAHD = new javax.swing.JTextField();
        them4 = new javax.swing.JButton();
        sua4 = new javax.swing.JButton();
        xoa4 = new javax.swing.JButton();
        thoat4 = new javax.swing.JButton();
        jButtonclear4 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableHOADON = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 255));

        jPanel6.setBackground(new java.awt.Color(0, 204, 255));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 36));
        jLabel31.setText("Bill");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(199, 199, 199))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel31))
        );
        String colTieuDe1[] = new String[]{"Code Bill", "Employee Code", "Room Code", "Day", "Invoice Price"};
        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder("Invoice Information"));

        jLabel32.setText("Code Bill");

        jLabel33.setText("Employee Code");

        jLabel34.setText("Room Code");

        jLabel35.setText("Day");

        jLabel36.setText("Invoice Price");

        jTextFieldMAHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMAHDActionPerformed(evt);
            }
        });

        jTextFieldMAPHONGHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMAPHONGHDActionPerformed(evt);
            }
        });

        them4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/Form/hinh/THEM.png")));
        them4.setText("More");
        them4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                them4ActionPerformed(evt);
            }
        });

        sua4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/Form/hinh/SUA.png")));
        sua4.setText("Fix");
        sua4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sua4ActionPerformed(evt);
            }
        });

        xoa4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/Form/hinh/XOA.png")));
        xoa4.setText("Delete");
        xoa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoa4ActionPerformed(evt);
            }
        });

        thoat4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/Form/hinh/THOAT.png")));
        thoat4.setText("Exit");
        thoat4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thoat4ActionPerformed(evt);
            }
        });

        jButtonclear4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/Form/hinh/CLEAR.png")));
        jButtonclear4.setText("Clear");
        jButtonclear4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonclear4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(xoa4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(them4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(sua4)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonclear4))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldGIAHD, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                            .addComponent(jTextFieldNGAY)
                            .addComponent(jTextFieldMAPHONGHD)
                            .addComponent(jTextFieldMANVHD)
                            .addComponent(jTextFieldMAHD)))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(thoat4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jTextFieldMAHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(jTextFieldMANVHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(jTextFieldMAPHONGHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(jTextFieldNGAY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(jTextFieldGIAHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(them4)
                    .addComponent(sua4)
                    .addComponent(jButtonclear4))
                .addGap(26, 26, 26)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xoa4)
                    .addComponent(thoat4))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTableHOADON.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableHOADON.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableHOADONMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTableHOADON);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 806, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 5, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 6, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }

    private void jTextFieldMAHDActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextFieldMAPHONGHDActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void them4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Connection con = getConnection();
        try {

            st = (Statement) con.createStatement();
            String query = "INSERT INTO hoadon(MAHD,MANV, MAPHONG, NGAY, GIAHD) VALUES('" + jTextFieldMAHD.getText() + "',"
            + "'" + jTextFieldMANVHD.getText() + "','" + jTextFieldMAPHONGHD.getText() + "', '" + jTextFieldNGAY.getText() + "', '" + jTextFieldGIAHD.getText() + "')";

            st.execute(query);
            hienThiDanhSachHoaDon();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void sua4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (jTableHOADON.getSelectedRow()==-1) {
            if (jTableHOADON.getRowCount()==0) {

            }
            else{

            }
        }
        else{
            DefaultTableModel model = (DefaultTableModel) jTableHOADON.getModel();
            model.setValueAt(jTextFieldMAHD.getText(), jTableHOADON.getSelectedRow(), 0);
            model.setValueAt(jTextFieldMANVHD.getText().toString(), jTableHOADON.getSelectedRow(), 1);
            model.setValueAt(jTextFieldMAPHONGHD.getText(), jTableHOADON.getSelectedRow(), 2);
            model.setValueAt(jTextFieldNGAY.getText(), jTableHOADON.getSelectedRow(), 3);
            model.setValueAt(jTextFieldGIAHD.getText(), jTableHOADON.getSelectedRow(), 4);
        }

    }

    private void xoa4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Connection con = getConnection();
        try {

            st = (Statement) con.createStatement();
            String query = "DELETE FROM hoadon WHERE MAHD = '" + jTextFieldMAHD.getText() + "'";
            st.executeUpdate(query);
            hienThiDanhSachHoaDon();

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    private void thoat4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        thoat4.setToolTipText("Click to exit the program ");
        int selected = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit the program?"
            , "Notification", JOptionPane.YES_NO_CANCEL_OPTION);
        if (selected == JOptionPane.YES_NO_OPTION) {
            this.dispose();

        }
    }

    private void jButtonclear4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        jTextFieldMAHD.setText("");
        jTextFieldMANVHD.setText("");
        jTextFieldMAPHONGHD.setText("");
        jTextFieldNGAY.setText("");
        jTextFieldGIAHD.setText("");
        jTextFieldMAHD.requestFocus();

    }

    private void jTableHOADONMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        int i = jTableHOADON.getSelectedRow();
        TableModel model = jTableHOADON.getModel();
        jTextFieldMAHD.setText(model.getValueAt(i, 0).toString());
        jTextFieldMANVHD.setText(model.getValueAt(i, 1).toString());
        jTextFieldMAPHONGHD.setText(model.getValueAt(i, 2).toString());
        jTextFieldNGAY.setText(model.getValueAt(i, 3).toString());
        jTextFieldGIAHD.setText(model.getValueAt(i, 4).toString());
    }


    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HoaDonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDonForm().setVisible(true);
            }
        });
    }

    
    private javax.swing.JButton jButtonclear4;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTableHOADON;
    private javax.swing.JTextField jTextFieldGIAHD;
    private javax.swing.JTextField jTextFieldMAHD;
    private javax.swing.JTextField jTextFieldMANVHD;
    private javax.swing.JTextField jTextFieldMAPHONGHD;
    private javax.swing.JTextField jTextFieldNGAY;
    private javax.swing.JButton sua4;
    private javax.swing.JButton them4;
    private javax.swing.JButton thoat4;
    private javax.swing.JButton xoa4;
   
}
