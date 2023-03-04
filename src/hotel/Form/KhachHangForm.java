package hotel.Form;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import hotel.KhachHang;
import static hotel.MyConnection.getConnection;

public class KhachHangForm extends javax.swing.JFrame {
    public KhachHangForm() {
        initComponents();
        getConnection();
        hienThiDanhSachKhachHang();
    }
    Connection con=null;
    Statement st=null;
    
     public ArrayList<KhachHang> layDanhSachKhachHang() {
        ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
        Connection con = getConnection();
        try {
            st = (Statement) con.createStatement();
            String sql = "SELECT * FROM khachhang";

            ResultSet rs = st.executeQuery(sql);

            KhachHang kh;
            while (rs.next()) {
                kh = new KhachHang(rs.getString("MAKH"),
                        rs.getString("TENKH"),
                        rs.getString("CMND"),
                        rs.getString("QUOCTICH"),
                        rs.getString("GIOITINH"),
                        rs.getInt("TUOI"),
                        rs.getString("SDT"),
                        rs.getString("MAPHONG") );
                dskh.add(kh);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dskh;
    }
     public void hienThiDanhSachKhachHang() {
        String colTieuDe1[] = new String[]{"Customer's code",
                "Customer name",
                "Identity Card",
                "Nationality",
                "Sex",
                "Age",
                "Phone number",
                "Room Code"};

        ArrayList<KhachHang> dskh = layDanhSachKhachHang();

        DefaultTableModel model = new DefaultTableModel(colTieuDe1, 0);

        Object[] row;

        for (int i = 0; i < dskh.size(); i++) {
            row = new Object[8];

            row[0] = dskh.get(i).getMAKH();
            row[1] = dskh.get(i).getTENKH();
            row[2] = dskh.get(i).getCMND();
            row[3] = dskh.get(i).getQUOCTICH();
            row[4] = dskh.get(i).getGIOITINH();
            row[5] = dskh.get(i).getTuoi();
            row[6] = dskh.get(i).getSDT();
            row[7] = dskh.get(i).getMAPHONG();

            model.addRow(row);
        }

        jTableKhachhang.setModel(model);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel4 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldMAKH = new javax.swing.JTextField();
        jTextFieldTENKH = new javax.swing.JTextField();
        jTextFieldCMND = new javax.swing.JTextField();
        jTextFieldQUOCTICH = new javax.swing.JTextField();
        jTextFieldGIOITINHKH = new javax.swing.JTextField();
        jTextFieldTUOI = new javax.swing.JTextField();
        jTextFieldSDT = new javax.swing.JTextField();
        jTextFieldMAPHONGKH = new javax.swing.JTextField();
        them1 = new javax.swing.JButton();
        sua1 = new javax.swing.JButton();
        xoa1 = new javax.swing.JButton();
        thoat1 = new javax.swing.JButton();
        jButtonclear2 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableKhachhang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(204,255 , 204));

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Customer information"));

        jLabel10.setText("Customer's code");

        jLabel11.setText("Customer name");

        jLabel12.setText("Identity Card");

        jLabel13.setText("Nationality");

        jLabel14.setText("Sex");

        jLabel15.setText("Year old ");

        jLabel16.setText("Phone number");

        jLabel17.setText("Room code");

        jTextFieldMAKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMAKHActionPerformed(evt);
            }
        });

        jTextFieldTENKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTENKHActionPerformed(evt);
            }
        });

        jTextFieldMAPHONGKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMAPHONGKHActionPerformed(evt);
            }
        });

        them1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/Form/hinh/THEM.png")));
        them1.setText("More");
        them1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                them1ActionPerformed(evt);
            }
        });

        sua1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/Form/hinh/SUA.png")));
        sua1.setText("Fix");
        sua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sua1ActionPerformed(evt);
            }
        });

        xoa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/Form/hinh/XOA.png")));
        xoa1.setText("Delete");
        xoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoa1ActionPerformed(evt);
            }
        });

        thoat1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/Form/hinh/THOAT.png")));
        thoat1.setText("Exit");
        thoat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thoat1ActionPerformed(evt);
            }
        });

        jButtonclear2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/Form/hinh/CLEAR.png")));
        jButtonclear2.setText("Clear");
        jButtonclear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonclear2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(them1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(xoa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(thoat1)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(sua1)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonclear2))))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldQUOCTICH, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTENKH, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldMAKH, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldGIOITINHKH, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTUOI, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldMAPHONGKH, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldMAKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldTENKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldQUOCTICH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextFieldGIOITINHKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextFieldTUOI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextFieldSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextFieldMAPHONGKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(them1)
                    .addComponent(sua1)
                    .addComponent(jButtonclear2))
                .addGap(28, 28, 28)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xoa1)
                    .addComponent(thoat1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel9.setText("CUSTOMER MANAGEMENT");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTableKhachhang.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableKhachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableKhachhangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableKhachhang);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1089, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }

    private void jTextFieldMAKHActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jTextFieldTENKHActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jTextFieldMAPHONGKHActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void them1ActionPerformed(java.awt.event.ActionEvent evt) {

        Connection con = getConnection();
        try {
            st = (Statement) con.createStatement();
            String query = "INSERT INTO khachhang(MAKH,TENKH, CMND, QUOCTICH, GIOITINH, TUOI, SDT, MAPHONG) VALUES('" + jTextFieldMAKH.getText() + "',"
            + "'" + jTextFieldTENKH.getText() + "','" + jTextFieldCMND.getText() + "', '" + jTextFieldQUOCTICH.getText() + "', '" + jTextFieldGIOITINHKH.getText() + "', '" + jTextFieldTUOI.getText() + "', '" + jTextFieldSDT.getText() + "', '" + jTextFieldMAPHONGKH.getText() + "')";

            st.execute(query);
            hienThiDanhSachKhachHang();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void sua1ActionPerformed(java.awt.event.ActionEvent evt) {

        if (jTableKhachhang.getSelectedRow()==-1) {
            if (jTableKhachhang.getRowCount()==0) {
            }
            else{
            }
        }
        else{
            DefaultTableModel model = (DefaultTableModel) jTableKhachhang.getModel();
            model.setValueAt(jTextFieldMAKH.getText(), jTableKhachhang.getSelectedRow(), 0);
            model.setValueAt(jTextFieldTENKH.getText().toString(), jTableKhachhang.getSelectedRow(), 1);
            model.setValueAt(jTextFieldCMND.getText(), jTableKhachhang.getSelectedRow(), 2);
            model.setValueAt(jTextFieldQUOCTICH.getText(), jTableKhachhang.getSelectedRow(), 3);
            model.setValueAt(jTextFieldGIOITINHKH.getText(), jTableKhachhang.getSelectedRow(), 4);
            model.setValueAt(jTextFieldTUOI.getText(), jTableKhachhang.getSelectedRow(), 5);
            model.setValueAt(jTextFieldSDT.getText(), jTableKhachhang.getSelectedRow(), 6);
            model.setValueAt(jTextFieldMAPHONGKH.getText(), jTableKhachhang.getSelectedRow(), 7);
        }
    }

    private void xoa1ActionPerformed(java.awt.event.ActionEvent evt) {

        Connection con = getConnection();
        try {
            st = (Statement) con.createStatement();
            String query = "DELETE FROM khachhang WHERE MAKH = '" + jTextFieldMAKH.getText() + "'";
            st.executeUpdate(query);
            hienThiDanhSachKhachHang();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void thoat1ActionPerformed(java.awt.event.ActionEvent evt) {

        thoat1.setToolTipText("Click to exit the program ");
        int selected = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit the program?"
           , "Notification", JOptionPane.YES_NO_CANCEL_OPTION);
        if (selected == JOptionPane.YES_NO_OPTION) {
            this.dispose();
        }
    }

    private void jButtonclear2ActionPerformed(java.awt.event.ActionEvent evt) {

        jTextFieldMAKH.setText("");
        jTextFieldTENKH.setText("");
        jTextFieldCMND.setText("");
        jTextFieldQUOCTICH.setText("");
        jTextFieldGIOITINHKH.setText("");
        jTextFieldTUOI.setText("");
        jTextFieldSDT.setText("");
        jTextFieldMAPHONGKH.setText("");
        jTextFieldMAKH.requestFocus();
    }

    private void jTableKhachhangMouseClicked(java.awt.event.MouseEvent evt) {

        int i = jTableKhachhang.getSelectedRow();
        TableModel model = jTableKhachhang.getModel();
        jTextFieldMAKH.setText(model.getValueAt(i, 0).toString());
        jTextFieldTENKH.setText(model.getValueAt(i, 1).toString());
        jTextFieldCMND.setText(model.getValueAt(i, 2).toString());
        jTextFieldQUOCTICH.setText(model.getValueAt(i, 3).toString());
        jTextFieldGIOITINHKH.setText(model.getValueAt(i, 4).toString());
        jTextFieldTUOI.setText(model.getValueAt(i, 5).toString());
        jTextFieldSDT.setText(model.getValueAt(i, 6).toString());
        jTextFieldMAPHONGKH.setText(model.getValueAt(i, 7).toString());
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
            java.util.logging.Logger.getLogger(KhachHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhachHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhachHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhachHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KhachHangForm().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButtonclear2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableKhachhang;
    private javax.swing.JTextField jTextFieldCMND;
    private javax.swing.JTextField jTextFieldGIOITINHKH;
    private javax.swing.JTextField jTextFieldMAKH;
    private javax.swing.JTextField jTextFieldMAPHONGKH;
    private javax.swing.JTextField jTextFieldQUOCTICH;
    private javax.swing.JTextField jTextFieldSDT;
    private javax.swing.JTextField jTextFieldTENKH;
    private javax.swing.JTextField jTextFieldTUOI;
    private javax.swing.JButton sua1;
    private javax.swing.JButton them1;
    private javax.swing.JButton thoat1;
    private javax.swing.JButton xoa1;
}
