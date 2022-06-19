/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Ryan
 */
public class view_all_records extends javax.swing.JFrame {
Connection conn = null;
PreparedStatement pst = null;
ResultSet rs = null;
String searchby="";
    /**
     * Creates new form view_all_records
     */
    public view_all_records() {
        initComponents();
        conn = food_conn.food_connection();
        update_table();
        total_found();
    }
   
    public void total_found(){
        try{
            String sql = "select count(type) from foods";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                String total = rs.getString("count(type)");
                jLabel2.setText(total);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{
                pst.close();
                rs.close();
            }catch(Exception e){
                
            }
        }
    }
    public void update_table(){
        try{
            String sql="select type as 'Type',price as 'Price',quantity as 'Quantity',amount as 'Amount' from foods";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{
                pst.close();
                rs.close();
            }catch(Exception e){
                
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Food Chain");
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 17)); // NOI18N
        jLabel1.setText("Total found");

        jLabel2.setFont(new java.awt.Font("Sylfaen", 0, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 51));
        jLabel2.setText("found");

        jLabel3.setFont(new java.awt.Font("Sylfaen", 0, 17)); // NOI18N
        jLabel3.setText("Search By");

        jComboBox1.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Rice", "Grilled", "Sinigang", "Others", "Drinks" }));

        jTextField1.setFont(new java.awt.Font("Sylfaen", 0, 17)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        
        if(jComboBox1.getSelectedIndex()==0){
            try{
            String sql = "select type,price,quantity,amount from rice where type like ?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, "%" + jTextField1.getText()+"%");
            rs=pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }finally{
                try{
                    pst.close();
                    rs.close();
                }catch(Exception e){
                    
                }
            }
        }else if(jComboBox1.getSelectedIndex()==1){
             try{
            String sql = "select type,price,quantity,amount from grilled where type like ?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, "%" + jTextField1.getText()+"%");
            rs=pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }finally{
                try{
                    pst.close();
                    rs.close();
                }catch(Exception e){
                    
                }
            }
        }else if(jComboBox1.getSelectedIndex()==2){
             try{
            String sql = "select type,price,quantity,amount from sinigang where type like ?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, "%" + jTextField1.getText()+"%");
            rs=pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }finally{
                try{
                    pst.close();
                    rs.close();
                }catch(Exception e){
                    
                }
            }
        }else if(jComboBox1.getSelectedIndex()==3){
             try{
            String sql = "select type,price,quantity,amount from other where type like ?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, "%" + jTextField1.getText()+"%");
            rs=pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }finally{
                try{
                    pst.close();
                    rs.close();
                }catch(Exception e){
                    
                }
            }
        }else if(jComboBox1.getSelectedIndex()==4){
             try{
            String sql = "select type,price,quantity,amount from drinks where type like ?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, "%" + jTextField1.getText()+"%");
            rs=pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }finally{
                try{
                    pst.close();
                    rs.close();
                }catch(Exception e){
                    
                }
            }
        }
      
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jComboBox1.getSelectedIndex()==0){
           try{
               String sql = "select type,price,quantity,amount from rice";
               pst=conn.prepareStatement(sql);
               rs=pst.executeQuery();
               jTable1.setModel(DbUtils.resultSetToTableModel(rs));
           }catch(Exception e){
               JOptionPane.showMessageDialog(null, e);
           }finally{
               try{
                   pst.close();
                   rs.close();
               }catch(Exception e){
                   
               }
           }
        }else if(jComboBox1.getSelectedIndex()==1){
              try{
               String sql = "select type,price,quantity,amount from grilled";
               pst=conn.prepareStatement(sql);
               rs=pst.executeQuery();
               jTable1.setModel(DbUtils.resultSetToTableModel(rs));
           }catch(Exception e){
               JOptionPane.showMessageDialog(null, e);
           }finally{
               try{
                   pst.close();
                   rs.close();
               }catch(Exception e){
                   
               }
           }
        }else if(jComboBox1.getSelectedIndex()==2){
              try{
               String sql = "select type,price,quantity,amount from sinigang";
               pst=conn.prepareStatement(sql);
               rs=pst.executeQuery();
               jTable1.setModel(DbUtils.resultSetToTableModel(rs));
           }catch(Exception e){
               JOptionPane.showMessageDialog(null, e);
           }finally{
               try{
                   pst.close();
                   rs.close();
               }catch(Exception e){
                   
               }
           }
        }else if(jComboBox1.getSelectedIndex()==3){
              try{
               String sql = "select type,price,quantity,amount from other";
               pst=conn.prepareStatement(sql);
               rs=pst.executeQuery();
               jTable1.setModel(DbUtils.resultSetToTableModel(rs));
           }catch(Exception e){
               JOptionPane.showMessageDialog(null, e);
           }finally{
               try{
                   pst.close();
                   rs.close();
               }catch(Exception e){
                   
               }
           }
        }else if(jComboBox1.getSelectedIndex()==4){
              try{
               String sql = "select type,price,quantity,amount from drinks";
               pst=conn.prepareStatement(sql);
               rs=pst.executeQuery();
               jTable1.setModel(DbUtils.resultSetToTableModel(rs));
           }catch(Exception e){
               JOptionPane.showMessageDialog(null, e);
           }finally{
               try{
                   pst.close();
                   rs.close();
               }catch(Exception e){
                   
               }
           }
        }
        try{
         String sql = "select type,price,quantity,amount from foods ";
     }catch(Exception e){
         JOptionPane.showMessageDialog(null, e);
     }finally{
             try{
                 pst.close();
                 rs.close();
             }catch(Exception e){
                 
             }
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      update_table();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
               /*if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }*/  UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(view_all_records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view_all_records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view_all_records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view_all_records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view_all_records().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
