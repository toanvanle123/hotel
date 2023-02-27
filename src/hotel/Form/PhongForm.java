package hotel.Form;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static hotel.MyConnection.getConnection;
import hotel.Phong;



public class PhongForm extends JFrame {

    
    public PhongForm() {
        initComponents();
        getConnection();
        hienThiDanhSachPhong();
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
                p = new Phong(rs.getString("MAPHONG"),
                        rs.getString("TENPHONG"),
                        rs.getString("LOAIPHONG"),
                        rs.getDouble("GIAPHONG"),
                        rs.getString("CHUTHICH"),
                        rs.getString("TINHTRANG"),
                        rs.getString("MANV"),
                        rs.getString("MADV") );

               
                dsp.add(p);
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return dsp;
    }
    public void hienThiDanhSachPhong() {
        String colTieuDe1[] = new String[]{"Room Code", "Room Name", "Kind of room", "Room Rates", "Note", "Status", "Employee Code", "Service Code"};
        ArrayList<Phong> dsp = layDanhSachPhong();

        DefaultTableModel model = new DefaultTableModel(colTieuDe1, 0);

        Object[] row;

        for (int i = 0; i < dsp.size(); i++) {

            row = new Object[8];

            
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


        jTablePHONG.setModel(model);

    }

    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTablePHONG = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextFieldMAPHONG = new javax.swing.JTextField();
        jTextFieldTENPHONG = new javax.swing.JTextField();
        jTextFieldLOAIPHONG = new javax.swing.JTextField();
        jTextFieldGIAPHONG = new javax.swing.JTextField();
        jTextFieldCHUTHICHP = new javax.swing.JTextField();
        jTextFieldTINHTRANG = new javax.swing.JTextField();
        them3 = new javax.swing.JButton();
        sua3 = new javax.swing.JButton();
        xoa3 = new javax.swing.JButton();
        thoat3 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jTextFieldMANVP = new javax.swing.JTextField();
        jTextFieldMADVP = new javax.swing.JTextField();
        jButtonclear3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(204, 255,204 ));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel22.setText("ROOM MANAGEMENT");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
                jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel22)
                                .addGap(155, 155, 155))
        );
        jPanel17Layout.setVerticalGroup(
                jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(30, 30, 30))
        );

        jTablePHONG.setModel(new javax.swing.table.DefaultTableModel(
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
        jTablePHONG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePHONGMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTablePHONG);

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder("ROOM INFORMATION"));

        jLabel23.setText("Room Code");

        jLabel24.setText("Room Name");

        jLabel25.setText("Kind of room");

        jLabel26.setText("Room Rates");

        jLabel27.setText("Note");

        jLabel28.setText("Status");
        

        them3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/Form/hinh/THEM.png")));
        them3.setText("More");
        them3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                them3ActionPerformed(evt);
            }
        });

        sua3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/Form/hinh/SUA.png")));
        sua3.setText("Fix");
        sua3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sua3ActionPerformed(evt);
            }
        });

        xoa3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/Form/hinh/XOA.png")));
        xoa3.setText("Delete");
        xoa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoa3ActionPerformed(evt);
            }
        });

        thoat3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/Form/hinh/THOAT.png")));
        thoat3.setText("Exit");
        thoat3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thoat3ActionPerformed(evt);
            }
        });

        jLabel29.setText("Employee Code");

        jLabel30.setText("Service Code");

        jButtonclear3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/Form/hinh/CLEAR.png")));
        jButtonclear3.setText("Clear");
        jButtonclear3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonclear3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
                jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel18Layout.createSequentialGroup()
                                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(xoa3)
                                                        .addComponent(them3))
                                                .addGap(6, 6, Short.MAX_VALUE)
                                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(sua3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(thoat3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addComponent(jButtonclear3))
                                        .addGroup(jPanel18Layout.createSequentialGroup()
                                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel23)
                                                        .addComponent(jLabel24)
                                                        .addComponent(jLabel25)
                                                        .addComponent(jLabel26)
                                                        .addComponent(jLabel27)
                                                        .addComponent(jLabel28)
                                                        .addComponent(jLabel29)
                                                        .addComponent(jLabel30))
                                                .addGap(71, 71, 71)
                                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextFieldMAPHONG, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                                        .addComponent(jTextFieldTENPHONG)
                                                        .addComponent(jTextFieldLOAIPHONG)
                                                        .addComponent(jTextFieldGIAPHONG)
                                                        .addComponent(jTextFieldCHUTHICHP)
                                                        .addComponent(jTextFieldTINHTRANG)
                                                        .addComponent(jTextFieldMANVP)
                                                        .addComponent(jTextFieldMADVP))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
                jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel23)
                                        .addComponent(jTextFieldMAPHONG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel24)
                                        .addComponent(jTextFieldTENPHONG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel25)
                                        .addComponent(jTextFieldLOAIPHONG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel26)
                                        .addComponent(jTextFieldGIAPHONG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel27)
                                        .addComponent(jTextFieldCHUTHICHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel28)
                                        .addComponent(jTextFieldTINHTRANG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel29)
                                        .addComponent(jTextFieldMANVP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel30)
                                        .addComponent(jTextFieldMADVP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(them3)
                                        .addComponent(sua3)
                                        .addComponent(jButtonclear3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(xoa3)
                                        .addComponent(thoat3))
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(342, 342, 342)
                                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(49, 49, 49)
                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(99, 99, 99)
                                                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1094, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap()))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 510, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }

    private void jTablePHONGMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        int i = jTablePHONG.getSelectedRow();
        TableModel model = jTablePHONG.getModel();
        jTextFieldMAPHONG.setText(model.getValueAt(i, 0).toString());
        jTextFieldTENPHONG.setText(model.getValueAt(i, 1).toString());
        jTextFieldLOAIPHONG.setText(model.getValueAt(i, 2).toString());
        jTextFieldGIAPHONG.setText(model.getValueAt(i, 3).toString());
        jTextFieldCHUTHICHP.setText(model.getValueAt(i, 4).toString());
        jTextFieldTINHTRANG.setText(model.getValueAt(i, 5).toString());
        jTextFieldMANVP.setText(model.getValueAt(i, 6).toString());
        jTextFieldMADVP.setText(model.getValueAt(i, 7).toString());
    }

    private void them3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here
        Connection con = getConnection();
        try {
            st = (Statement) con.createStatement();
            String query = "INSERT INTO phong(MAPHONG,TENPHONG, LOAIPHONG, GIAPHONG, CHUTHICH, TINHTRANG, MANV, MADV) VALUES('" + jTextFieldMAPHONG.getText() + "',"
                    + "'" + jTextFieldTENPHONG.getText() + "','" + jTextFieldLOAIPHONG.getText() + "', '" + jTextFieldGIAPHONG.getText() + "', '" + jTextFieldCHUTHICHP.getText() + "', '" + jTextFieldTINHTRANG.getText() + "', '" + jTextFieldMANVP.getText() + "', '" + jTextFieldMADVP.getText() + "')";

            st.execute(query);
            hienThiDanhSachPhong();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void sua3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (jTablePHONG.getSelectedRow()==-1) {
            if (jTablePHONG.getRowCount()==0) {

            }
            else{

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
    }

    private void xoa3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Connection con = getConnection();
        try {
            st = (Statement) con.createStatement();
            String query = "DELETE FROM phong WHERE MAPHONG = '" + jTextFieldMAPHONG.getText() + "'";
            st.executeUpdate(query);
            hienThiDanhSachPhong();

        } catch (Exception ex) {

            ex.printStackTrace();
        }

    }

    private void thoat3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        thoat3.setToolTipText("Click to exit the program ");
        int selected = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit the program?"
                , "Notification", JOptionPane.YES_NO_CANCEL_OPTION);
        if (selected == JOptionPane.YES_NO_OPTION) {
            this.dispose();

        }
    }

    private void jButtonclear3ActionPerformed(java.awt.event.ActionEvent evt) {
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
            java.util.logging.Logger.getLogger(PhongForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhongForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhongForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhongForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

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
}
