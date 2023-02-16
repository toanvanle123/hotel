
package hotel.Form;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import hotel.DichVu;
import static hotel.MyConnection.getConnection;




public class DichVuForm extends javax.swing.JFrame {

    
    public DichVuForm() {
        initComponents();
        getConnection();
        hienThiDanhSachDichVu();
    }
    Connection con= null;
    Statement st= null;
    
        public ArrayList<DichVu> layDanhSachDichVu() {
        ArrayList<DichVu> dsdv = new ArrayList<DichVu>();
        Connection con = getConnection();
        try {
            st = (Statement) con.createStatement();
            String sql = "SELECT * FROM dichvu";

            ResultSet rs = st.executeQuery(sql);

            DichVu dv;
            while (rs.next()) {
                dv = new DichVu(rs.getString("MADV"), rs.getString("TENDV"), rs.getDouble("GIADV") );


                dsdv.add(dv);
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return dsdv;
    }
    public void hienThiDanhSachDichVu() {
        String colTieuDe1[] = new String[]{"Service Code", "Service name", "Service prices"};
        ArrayList<DichVu> dsdv = layDanhSachDichVu();

        DefaultTableModel model = new DefaultTableModel(colTieuDe1, 0);

        Object[] row;

        for (int i = 0; i < dsdv.size(); i++) {

            row = new Object[3];


            row[0] = dsdv.get(i).getMADV();
            row[1] = dsdv.get(i).getTENNVL();
            row[2] = dsdv.get(i).getGIADV();

            model.addRow(row);
        }
        


        jTableDichvu.setModel(model);

    }


    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextFieldMADV = new javax.swing.JTextField();
        jTextFieldTENDV = new javax.swing.JTextField();
        jTextFieldGIADV = new javax.swing.JTextField();
        them2 = new javax.swing.JButton();
        sua2 = new javax.swing.JButton();
        xoa2 = new javax.swing.JButton();
        thoat2 = new javax.swing.JButton();
        jButtonclear1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableDichvu = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel7.setBackground(new java.awt.Color(0, 204, 255));

        jLabel18.setBackground(new java.awt.Color(0, 0, 255));
        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel18.setText("LIST OF SERVICES");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Information Services"));

        jLabel19.setText("Service Code");

        jLabel20.setText("Service name");

        jLabel21.setText("Service prices");

        them2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/Form/hinh/THEM.png")));
        them2.setText("More");
        them2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                them2ActionPerformed(evt);
            }
        });

        sua2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/Form/hinh/SUA.png")));
        sua2.setText("Fix");
        sua2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sua2ActionPerformed(evt);
            }
        });

        xoa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/Form/hinh/XOA.png")));
        xoa2.setText("Delete");
        xoa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoa2ActionPerformed(evt);
            }
        });

        thoat2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/Form/hinh/THOAT.png")));
        thoat2.setText("Exit");
        thoat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thoat2ActionPerformed(evt);
            }
        });

        jButtonclear1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/Form/hinh/CLEAR.png")));
        jButtonclear1.setText("Clear");
        jButtonclear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonclear1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel21)
                        .addComponent(jLabel20)
                        .addComponent(jLabel19))
                    .addComponent(them2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(xoa2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldMADV, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                            .addComponent(jTextFieldTENDV)
                            .addComponent(jTextFieldGIADV)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(thoat2)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(sua2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonclear1)))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextFieldMADV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTextFieldTENDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextFieldGIADV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(them2)
                    .addComponent(sua2)
                    .addComponent(jButtonclear1))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xoa2)
                    .addComponent(thoat2))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jTableDichvu.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableDichvu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDichvuMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableDichvu);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        pack();
    }

    private void them2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Connection con = getConnection();
        try {

            st = (Statement) con.createStatement();
            String query = "INSERT INTO DichVu(MADV,TENDV, GIADV) VALUES('" + jTextFieldMADV.getText() + "',"
            + "'" + jTextFieldTENDV.getText() + "','" + jTextFieldGIADV.getText() + "')";

            st.execute(query);
            hienThiDanhSachDichVu();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void sua2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (jTableDichvu.getSelectedRow()==-1) {
            if (jTableDichvu.getRowCount()==0) {

            }
            else{

            }
        }
        else{
            DefaultTableModel model = (DefaultTableModel) jTableDichvu.getModel();
            model.setValueAt(jTextFieldMADV.getText(), jTableDichvu.getSelectedRow(), 0);
            model.setValueAt(jTextFieldTENDV.getText().toString(), jTableDichvu.getSelectedRow(), 1);
            model.setValueAt(jTextFieldGIADV.getText(), jTableDichvu.getSelectedRow(), 2);
        }

    }

    private void xoa2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Connection con = getConnection();
        try {

            st = (Statement) con.createStatement();
            String query = "DELETE FROM dichvu WHERE MADV = '" + jTextFieldMADV.getText() + "'";
            st.executeUpdate(query);
            hienThiDanhSachDichVu();

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    private void thoat2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        thoat2.setToolTipText("Click to exit the program ");
        int selected = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit the program?"
            , "Notification", JOptionPane.YES_NO_CANCEL_OPTION);
        if (selected == JOptionPane.YES_NO_OPTION) {
            this.dispose();

        }

    }

    private void jButtonclear1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        jTextFieldMADV.setText("");
        jTextFieldTENDV.setText("");
        jTextFieldGIADV.setText("");
        jTextFieldMADV.requestFocus();
    }

    private void jTableDichvuMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here
        int i = jTableDichvu.getSelectedRow();
        TableModel model = jTableDichvu.getModel();
        jTextFieldMADV.setText(model.getValueAt(i, 0).toString());
        jTextFieldTENDV.setText(model.getValueAt(i, 1).toString());
        jTextFieldGIADV.setText(model.getValueAt(i, 2).toString());

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
            java.util.logging.Logger.getLogger(DichVuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DichVuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DichVuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DichVuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DichVuForm().setVisible(true);
            }
        });
    }


    private javax.swing.JButton jButtonclear1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableDichvu;
    private javax.swing.JTextField jTextFieldGIADV;
    private javax.swing.JTextField jTextFieldMADV;
    private javax.swing.JTextField jTextFieldTENDV;
    private javax.swing.JButton sua2;
    private javax.swing.JButton them2;
    private javax.swing.JButton thoat2;
    private javax.swing.JButton xoa2;

}
