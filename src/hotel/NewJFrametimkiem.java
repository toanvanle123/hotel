
package hotel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class NewJFrametimkiem extends javax.swing.JFrame {


    public NewJFrametimkiem() {
        initComponents();
    }
    Statement st=null;
    Connection con=null;
    ResultSet rs=null;


    @SuppressWarnings()
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTabletimkiemnhanvien = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldTKnhanvien = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabletimkiemnhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "mã nhân viên", "Tên Nhân Viên", "Chức Vụ", "Lương Nhân Viên", "Ngày Sinh", "Giới tính", "Chú Thích"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTabletimkiemnhanvien);

        jLabel1.setText("Mã Nhân Viên");

        jTextFieldTKnhanvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTKnhanvienActionPerformed(evt);
            }
        });

        jButton1.setText("Tìm Kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jTextFieldTKnhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldTKnhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

       String TK[]={
           "MÃ SINH VIÊN","HỌ TÊN ","NƠI SINH ","ĐỊA CHỈ","GIỚI TÍNH","MÃ LỚP"

       };
       DefaultTableModel modelTable=new DefaultTableModel(TK,0);
       try{
           st=con.createStatement();
           String sql="select * from nhanvien ";
           if(jTextFieldTKnhanvien.getText().length()>0){
              sql=sql + "where MANV like '%"+jTextFieldTKnhanvien.getText()+"%'";
           }
           rs=st.executeQuery(sql);
           modelTable.setRowCount(0);
           if(rs.isBeforeFirst()==false){
               JOptionPane.showMessageDialog(this, "Không tìm được dữ liệu !");
           }
            Vector data=null;
           while (rs.next()){
               data=new Vector();
               data.add(rs.getString("MANV"));
               data.add(rs.getString("TENNV"));
               data.add(rs.getString("CHUCVU"));
               data.add(rs.getDouble("LUONGNV"));
               data.add(rs.getDate("NGAYSINH"));
               data.add(rs.getString("GIOITINH"));
               data.add(rs.getString("CHUTHICH"));
               modelTable.addRow(data);
           }
           jTabletimkiemnhanvien.setModel(modelTable);
      
           
       }catch(Exception e){
           e.printStackTrace();
      
       }
        
    }

    private void jTextFieldTKnhanvienActionPerformed(java.awt.event.ActionEvent evt) {

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
            java.util.logging.Logger.getLogger(NewJFrametimkiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrametimkiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrametimkiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrametimkiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrametimkiem().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabletimkiemnhanvien;
    private javax.swing.JTextField jTextFieldTKnhanvien;
}
