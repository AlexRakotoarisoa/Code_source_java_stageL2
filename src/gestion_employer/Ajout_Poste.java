/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gestion_employer;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ALEX RAKOTOARISOA
 */
public class Ajout_Poste extends javax.swing.JFrame {

     Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement prepare = null;

Utilisateur util;
    public Ajout_Poste(Utilisateur util) {
        initComponents();
        this.util = util;
        valeurRecu();
    }
    
    

String db = "gestion.db";
  public void valeurRecu(){
  
             int row = util.table_poste.getSelectedRow();
            if (row == -1){
                txt_poste.setText("");  
                txt_prin.setText("");
                txt_second.setText(""); 
                modif_btn.setEnabled(false);
            }else{
                util.deplace2();
                String d = util.ahona2();
                    try{


                           String sql = "Select * from poste where ID_Poste = '"+d+"'";
                          Class.forName("org.sqlite.JDBC");
                          con = DriverManager.getConnection("jdbc:sqlite:"+db);
                                   st=con.createStatement();
                                   rs = st.executeQuery(sql);
                                   rs.next();
                                    String nom = rs.getString("Poste");
                                   txt_poste.setText(nom);
                                   String pr = rs.getString("Activite_prin");
                                   txt_prin.setText(pr);
                                   String sd = rs.getString("Activite_second");
                                   txt_second.setText(sd);
                                   ajout_btn.setEnabled(false);
                                  

                    }catch(SQLException | ClassNotFoundException e){
                                          System.err.println(e);
                      }finally{
            if(con != null){
                try{
                    con.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
        }
    }
    }
    
    }
    
    
    
     public void ajouter(){
        String nom = txt_poste.getText();
        String pr = txt_prin.getText();  
        String sd = txt_second.getText();
        String sql = "insert into poste (Poste,Activite_prin,Activite_second) values (?,?,?)";
        
         if (nom.isEmpty() || pr.isEmpty() || sd.isEmpty()){
             JOptionPane.showMessageDialog(null, "Veuillez completer tout les champs vide ");
         }else{
             try{
                   Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:"+db);
                        st=con.createStatement();
                        rs=st.executeQuery("Select Poste from poste where Poste ='"+nom+"' ");
                        if(rs.next()){
                            JOptionPane.showMessageDialog(null, "Ce Service éxiste déja, veuillez saisir un autre ");
                        }else{
                          try{
                           Class.forName("org.sqlite.JDBC");
                          con = DriverManager.getConnection("jdbc:sqlite:"+db);   
                            prepare = con.prepareStatement(sql);
                            prepare.setString(1,nom);
                            prepare.setString(2, pr);
                            prepare.setString(3, sd);
                            prepare.executeUpdate();     
                            JOptionPane.showMessageDialog(null, "Ajout avec succès");
                            con.close();
                            util.Actualiser2();
                            util.setEnabled(true);
                            this.dispose();
                            }catch(SQLException | ClassNotFoundException e){
                                          System.err.println(e);
                             }finally{
            if(con != null){
                try{
                    con.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
        }
    }                   
                            }

              }catch(SQLException | ClassNotFoundException e){
                                          System.err.println(e);
                         }finally{
            if(con != null){
                try{
                    con.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
        }
    }
               
       }
    }

      public void modifier(){
        util.deplace2();
        String d = util.ahona2();
        
        String nom = txt_poste.getText();
        String pr = txt_prin.getText();
        String sd = txt_second.getText();
        String dd = util.poste.getText();
        
                String sql = "update poste set Poste = ?,Activite_prin = ?,Activite_second = ? where ID_Poste = ?";
                String sql1 = "update personnel set Poste =? where Poste =? ";
        
         if (nom.isEmpty() || pr.isEmpty() || sd.isEmpty()){
             JOptionPane.showMessageDialog(null, "Veuillez completer tout les champs vide ");
         }else{
             try{
                    Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:"+db);
                    PreparedStatement prepa = con.prepareStatement(sql);
                     PreparedStatement p = con.prepareStatement(sql1);
                    prepa.setString(1, nom);
                    prepa.setString(2, pr);
                    prepa.setString(3, sd);
                    prepa.setString(4, d);
                    prepa.executeUpdate();
                     p.setString(1, nom);
                    p.setString(2, dd);
                    p.executeUpdate();   
                            JOptionPane.showMessageDialog(null, "Modification avec succès");
                            con.close();
                            util.Actualiser2();
                            util.setEnabled(true);
                            this.dispose();
                            
                            

           }catch(SQLException | ClassNotFoundException e){
                                          System.err.println(e);
              }finally{
            if(con != null){
                try{
                    con.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
        }
    }
       }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_poste = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        modif_btn = new javax.swing.JButton();
        ajout_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_prin = new javax.swing.JTextArea();
        fermer = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_second = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("INFORMATION POSTE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 260, 44));

        txt_poste.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_poste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_posteActionPerformed(evt);
            }
        });
        jPanel1.add(txt_poste, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 230, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nom du Poste :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 130, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Activité secondaire :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 140, 30));

        modif_btn.setText("Modifier");
        modif_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modif_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modif_btnActionPerformed(evt);
            }
        });
        jPanel1.add(modif_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, -1, 30));

        ajout_btn.setText("Ajouter");
        ajout_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ajout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajout_btnActionPerformed(evt);
            }
        });
        jPanel1.add(ajout_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, -1, 30));

        txt_prin.setColumns(20);
        txt_prin.setLineWrap(true);
        txt_prin.setRows(5);
        txt_prin.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txt_prin);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 230, 90));

        fermer.setBackground(new java.awt.Color(0, 153, 153));
        fermer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fermer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fermerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fermerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fermerMouseExited(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("X");

        javax.swing.GroupLayout fermerLayout = new javax.swing.GroupLayout(fermer);
        fermer.setLayout(fermerLayout);
        fermerLayout.setHorizontalGroup(
            fermerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fermerLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        fermerLayout.setVerticalGroup(
            fermerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        jPanel1.add(fermer, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 70, 25));

        txt_second.setColumns(20);
        txt_second.setLineWrap(true);
        txt_second.setRows(5);
        txt_second.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txt_second);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 230, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Activité principale :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 140, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 430));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void modif_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modif_btnActionPerformed
        modifier();
    }//GEN-LAST:event_modif_btnActionPerformed

    private void txt_posteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_posteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_posteActionPerformed

    private void ajout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajout_btnActionPerformed
        ajouter();
    }//GEN-LAST:event_ajout_btnActionPerformed

    private void fermerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fermerMouseClicked
        util.setVisible(true);
        this.dispose();
        util.setEnabled(true);
        util.Actualiser();
    }//GEN-LAST:event_fermerMouseClicked

    private void fermerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fermerMouseEntered
        fermer.setBackground(Color.red);
    }//GEN-LAST:event_fermerMouseEntered

    private void fermerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fermerMouseExited
        fermer.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_fermerMouseExited

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ajout_Poste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ajout_Poste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ajout_Poste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ajout_Poste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajout_btn;
    private javax.swing.JPanel fermer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton modif_btn;
    private javax.swing.JTextField txt_poste;
    private javax.swing.JTextArea txt_prin;
    private javax.swing.JTextArea txt_second;
    // End of variables declaration//GEN-END:variables
}
