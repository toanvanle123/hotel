package hotel.Form;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static hotel.MyConnection.getConnection;
import hotel.NhanVien;

public class NhanVienForm extends javax.swing.JFrame {
    public NhanVienForm() {
        initComponents();
        getConnection();
        hienThiDanhSachNhanVien();
    }
    Connection con= null;
    Statement st= null;
    
    public ArrayList<NhanVien> layDanhSachNhanVien() {
        ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
        Connection con = getConnection();
        try {
            st = (Statement) con.createStatement();
            String sql = "SELECT * FROM nhanvien";
            ResultSet rs = st.executeQuery(sql);

            NhanVien nv;
            while (rs.next()) {
                nv = new NhanVien(rs.getString("MANV"),
                        rs.getString("TENNV"),
                        rs.getString("CHUCVU"),
                        rs.getDouble("LUONGNV"),
                        rs.getDate("NGAYSINH"),
                        rs.getString("GIOITINH"),
                        rs.getString("CHUTHICH") );

                dsnv.add(nv);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dsnv;
    }
    
    public void hienThiDanhSachNhanVien() {
        String colTieuDe1[] = new String[]{"Employee Code",
                                            "Staff's name",
                                            "Position",
                                            "Wage",
                                            "Date of birth",
                                            "Sex",
                                            "Note"};

        ArrayList<NhanVien> dsnv = layDanhSachNhanVien();

        DefaultTableModel model = new DefaultTableModel(colTieuDe1, 0);

        Object[] row;

        for (int i = 0; i < dsnv.size(); i++) {
            row = new Object[7];
            row[0] = dsnv.get(i).getMANV();
            row[1] = dsnv.get(i).getTENNV();
            row[2] = dsnv.get(i).getCHUCVU();
            row[3] = dsnv.get(i).getLUONGNV();
            row[4] = dsnv.get(i).getNGAYSINH();
            row[5] = dsnv.get(i).getGIOITINH();
            row[6] = dsnv.get(i).getCHUTHICH();

            model.addRow(row);
        }

        jTableNhanvien.setModel(model);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldMANV = new javax.swing.JTextField();
        jTextFieldTENNV = new javax.swing.JTextField();
        jTextFieldCHUCVU = new javax.swing.JTextField();
        jTextFieldLUONG = new javax.swing.JTextField();
        jTextFieldNGAYSINH = new javax.swing.JTextField();
        jTextFieldGIOITINH = new javax.swing.JTextField();
        jTextFieldCHUTHICH = new javax.swing.JTextField();
        them = new javax.swing.JButton();
        sua = new javax.swing.JButton();
        xoa = new javax.swing.JButton();
        thoat = new javax.swing.JButton();
        jButtonclear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableNhanvien = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel1.setText("EMPLOYEE MANAGER");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(87, 87, 87))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Staff information"));
        jLabel2.setText("Employee Code");

        jLabel3.setText("Staff's name");

        jLabel4.setText("Position");

        jLabel5.setText("Age");

        jLabel6.setText("Date of birth");

        jLabel7.setText("Sex");

        jLabel8.setText("Note");

        jTextFieldTENNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTENNVActionPerformed(evt);
            }
        });

        jTextFieldLUONG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLUONGActionPerformed(evt);
            }
        });

        them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/Form/hinh/THEM.png")));
        them.setText("More");
        them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themActionPerformed(evt);
            }
        });

        sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/Form/hinh/SUA.png")));
        sua.setText("Fix");
        sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaActionPerformed(evt);
            }
        });

        xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/Form/hinh/XOA.png")));
        xoa.setText("Delete");
        xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaActionPerformed(evt);
            }
        });

        thoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/Form/hinh/THOAT.png")));
        thoat.setText("Exit");
        thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thoatActionPerformed(evt);
            }
        });

        jButtonclear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/Form/hinh/CLEAR.png")));
        jButtonclear.setText("Clear");
        jButtonclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonclearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(xoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(them, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(thoat)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(sua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonclear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel2))
                                            .addGap(18, 18, 18))
                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(29, 29, 29)))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(39, 39, 39)))
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextFieldLUONG)
                                    .addComponent(jTextFieldCHUCVU, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldTENNV)
                                    .addComponent(jTextFieldMANV, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel8))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldGIOITINH)
                                    .addComponent(jTextFieldNGAYSINH)
                                    .addComponent(jTextFieldCHUTHICH))))))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldMANV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldTENNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldCHUCVU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldLUONG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldNGAYSINH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldGIOITINH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldCHUTHICH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(them)
                    .addComponent(sua)
                    .addComponent(jButtonclear))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xoa)
                    .addComponent(thoat))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTableNhanvien.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableNhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableNhanvienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableNhanvien);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1005, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 536, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }

    private void jTableNhanvienMouseClicked(java.awt.event.MouseEvent evt) {

        int i = jTableNhanvien.getSelectedRow();
        TableModel model = jTableNhanvien.getModel();
        jTextFieldMANV.setText(model.getValueAt(i, 0).toString());
        jTextFieldTENNV.setText(model.getValueAt(i, 1).toString());
        jTextFieldCHUCVU.setText(model.getValueAt(i, 2).toString());
        jTextFieldLUONG.setText(model.getValueAt(i, 3).toString());
        jTextFieldNGAYSINH.setText(model.getValueAt(i, 4).toString());
        jTextFieldGIOITINH.setText(model.getValueAt(i, 5).toString());
        jTextFieldCHUTHICH.setText(model.getValueAt(i, 6).toString());
    }

    private void jButtonclearActionPerformed(java.awt.event.ActionEvent evt) {

        jTextFieldMANV.setText("");
        jTextFieldTENNV.setText("");
        jTextFieldCHUCVU.setText("");
        jTextFieldLUONG.setText("");
        jTextFieldNGAYSINH.setText("");
        jTextFieldGIOITINH.setText("");
        jTextFieldCHUTHICH.setText("");
        jTextFieldMANV.requestFocus();
    }

    private void thoatActionPerformed(java.awt.event.ActionEvent evt) {

        thoat.setToolTipText("Click to exit the program ");
        int selected = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit the program?"
            , "Notification", JOptionPane.YES_NO_CANCEL_OPTION);
        if (selected == JOptionPane.YES_NO_OPTION) {
            this.dispose();

        }
    }

    private void xoaActionPerformed(java.awt.event.ActionEvent evt) {

        Connection con = getConnection();
        try {
            st = (Statement) con.createStatement();
            String query = "DELETE FROM NhanVien WHERE MANV = '" + jTextFieldMANV.getText() + "'";
            st.executeUpdate(query);
            hienThiDanhSachNhanVien();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void suaActionPerformed(java.awt.event.ActionEvent evt) {

        if (jTableNhanvien.getSelectedRow()==-1) {
            if (jTableNhanvien.getRowCount()==0) {
            }
            else{
            }
        }
        else{
            DefaultTableModel model = (DefaultTableModel) jTableNhanvien.getModel();
            model.setValueAt(jTextFieldMANV.getText(), jTableNhanvien.getSelectedRow(), 0);
            model.setValueAt(jTextFieldTENNV.getText().toString(), jTableNhanvien.getSelectedRow(), 1);
            model.setValueAt(jTextFieldCHUCVU.getText(), jTableNhanvien.getSelectedRow(), 2);
            model.setValueAt(jTextFieldLUONG.getText(), jTableNhanvien.getSelectedRow(), 2);
            model.setValueAt(jTextFieldNGAYSINH.getText(), jTableNhanvien.getSelectedRow(), 2);
            model.setValueAt(jTextFieldGIOITINH.getText(), jTableNhanvien.getSelectedRow(), 2);
            model.setValueAt(jTextFieldCHUTHICH.getText(), jTableNhanvien.getSelectedRow(), 2);
        }
    }

    private void themActionPerformed(java.awt.event.ActionEvent evt) {

        Connection con = getConnection();
        String insertSql = "INSERT INTO NhanVien(MANV,TENNV,CHUCVU, LUONGNV, NGAYSINH, GIOITINH, CHUTHICH) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(insertSql);
            statement.setString(1, jTextFieldMANV.getText());
            statement.setString(2, jTextFieldTENNV.getText());
            statement.setString(3, jTextFieldCHUCVU.getText());
            statement.setDouble(4,Double.valueOf( jTextFieldLUONG.getText()));
            statement.setDate(5,Date.valueOf(jTextFieldNGAYSINH.getText()));
            statement.setString(6,jTextFieldGIOITINH.getText());
            statement.setString(7, jTextFieldCHUTHICH.getText());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Data has been successfully inserted into the database.");
            }
            hienThiDanhSachNhanVien();
        } catch (SQLException e) {
            System.err.println("Error while inserting data: " + e.getMessage());
        }

    }

    private void jTextFieldLUONGActionPerformed(java.awt.event.ActionEvent evt) {

    }
    private void jTextFieldTENNVActionPerformed(java.awt.event.ActionEvent evt) {

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
            java.util.logging.Logger.getLogger(NhanVienForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanVienForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanVienForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanVienForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhanVienForm().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButtonclear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableNhanvien;
    private javax.swing.JTextField jTextFieldCHUCVU;
    private javax.swing.JTextField jTextFieldCHUTHICH;
    private javax.swing.JTextField jTextFieldGIOITINH;
    private javax.swing.JTextField jTextFieldLUONG;
    private javax.swing.JTextField jTextFieldMANV;
    private javax.swing.JTextField jTextFieldNGAYSINH;
    private javax.swing.JTextField jTextFieldTENNV;
    private javax.swing.JButton sua;
    private javax.swing.JButton them;
    private javax.swing.JButton thoat;
    private javax.swing.JButton xoa;
}
