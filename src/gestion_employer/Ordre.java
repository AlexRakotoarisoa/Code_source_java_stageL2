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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ALEX RAKOTOARISOA
 */
public class Ordre extends javax.swing.JFrame {


    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement prepare = null;
    Directeur dir;
    Date dt = null;
    public Ordre(Directeur dir) {
        initComponents();
        this.dir = dir ;
        valeurRecu();
    }
String db = "gestion.db";
    
    
    

    
     public void valeurRecu(){
  try{
            int row = dir.table_demande.getSelectedRow();
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:"+db);
            st=con.createStatement();
             rs = st.executeQuery("Select Matricule from personnel");
            
                        LinkedList<String> liste1 = new LinkedList<>();
                        while(rs.next()){
                            String pr = rs.getString("Matricule");
                            liste1.add(pr);
                        }
                        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(liste1.toArray(new String[0]));
                        txt_Matricule.setModel(model);
                        
                        
            if (row == -1){
                txt_Duree.setText("");
                txt_Lieu.setText("");
                txt_Objet.setText("");   
                btn_envoyer.setEnabled(true);
                btn_modifier.setEnabled(false);
                        
                }else{
            try{
            
                dir.deplace();
                String d = dir.ahona();
                String sql = "Select * from ordre_de_route where ID_Ordre = '"+d+"'";
                        rs = st.executeQuery(sql);
                        rs.next();
                        String dur = rs.getString("Duree_Ordre");
                        txt_Duree.setText(dur);
                        String al = rs.getString("Lieu");
                        txt_Lieu.setText(al);
                        String obj = rs.getString("Objet_Mission");
                        txt_Objet.setText(obj); 
                        dt= rs.getDate("Date_Ordre");
                        txt_debut.setDate(dt);
                        String Matr = rs.getString("Matricule");
                        txt_Matricule.setSelectedItem(Matr);  
                        btn_modifier.setEnabled(true);
                        btn_envoyer.setEnabled(false);
                        
           }catch(Exception e){
                                System.err.println(e);
                             }finally{
                   if(rs != null){
                        try{
                            rs.close();
                        }catch(SQLException e){
                             e.printStackTrace();
                        }
                          }  if(st != null){
                        try{
                            st.close();
                        }catch(SQLException e){
                             e.printStackTrace();
                        }
                        }if(con != null){
                        try{
                            con.close();
                        }catch(SQLException e){
                             e.printStackTrace();
                        }
            }
    }
    
    }
    }catch(Exception e){
                                System.err.println(e);
                             }finally{
                   if(rs != null){
                        try{
                            rs.close();
                        }catch(SQLException e){
                             e.printStackTrace();
                        }
                          }  if(st != null){
                        try{
                            st.close();
                        }catch(SQLException e){
                             e.printStackTrace();
                        }
                        }if(con != null){
                        try{
                            con.close();
                        }catch(SQLException e){
                             e.printStackTrace();
                        }
            }
    }
           
    
    
    }
     
     
      public void ajouter(){
            String matricule = txt_Matricule.getSelectedItem().toString();  
            String dur =  txt_Duree.getText(); 
            String lieu = txt_Lieu.getText();
            String obj = txt_Objet.getText();
            Date deb = txt_debut.getDate();
            String di = "Directeur";

       String sql = "insert into ordre_de_route (Matricule,Duree,Lieu,Objet_Mission,Date_Ordre,ID_Directeur) values (?,?,?,?,?,?)";
        
         if (matricule.isEmpty() || dur.isEmpty() || lieu.isEmpty() || obj.isEmpty() ||deb == null){
             JOptionPane.showMessageDialog(null, " Veuillez completer tout les champs vide ");
         }else{
             try{
                 
                 SimpleDateFormat sp = new SimpleDateFormat("yyyy/MM/dd");
                 String date = sp.format(deb);
                  Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:"+db);
                    prepare = con.prepareStatement(sql);
                    prepare.setString(1, matricule);
                    prepare.setString(2, dur);
                    prepare.setString(3, lieu);
                    prepare.setString(4, obj);
                    prepare.setString(5, date);
                    prepare.setString(6, di);
                    prepare.executeUpdate();    
                            JOptionPane.showMessageDialog(null, "Ajout avec succès");
                            dir.Actualiser();
                            dir.setEnabled(true);
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
      
      
       public void modifier(){
            String matricule = txt_Matricule.getSelectedItem().toString();  
            String dur =  txt_Duree.getText(); 
            String lieu = txt_Lieu.getText();
            String obj = txt_Objet.getText();
            Date deb = txt_debut.getDate();
             dir.deplace();
                String d = dir.ahona();

       String sql = "update ordre_de_route set Matricule = ?,Duree = ? ,Lieu = ?, Objet_Mission = ?, Date_Ordre=? where ID_Ordre = ?";
        
         if (matricule.isEmpty() || dur.isEmpty() || lieu.isEmpty() || obj.isEmpty() || deb == null){
             JOptionPane.showMessageDialog(null, " Veuillez completer tout les champs vide ");
         }else{
             try{
                 
                 SimpleDateFormat sp = new SimpleDateFormat("yyyy/MM/dd");
                 String date = sp.format(deb);
                  Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:"+db);
                    prepare = con.prepareStatement(sql);
                    prepare.setString(1, matricule);
                    prepare.setString(2, dur);
                    prepare.setString(3, lieu);
                    prepare.setString(4, obj);
                    prepare.setString(5, date);
                     prepare.setString(6, d);
                    prepare.executeUpdate();    
                            JOptionPane.showMessageDialog(null, "Modification avec succès");
                            dir.Actualiser();
                            dir.setEnabled(true);
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
        txt_Duree = new javax.swing.JTextField();
        txt_Lieu = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_modifier = new javax.swing.JButton();
        txt_Matricule = new javax.swing.JComboBox<>();
        btn_envoyer = new javax.swing.JButton();
        fermer = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txt_debut = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_Objet = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("INFORMATION ORDRE DE ROUTE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, 44));

        txt_Duree.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_Duree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DureeActionPerformed(evt);
            }
        });
        jPanel1.add(txt_Duree, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 230, 30));

        txt_Lieu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txt_Lieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 230, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("A partir du :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 130, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Matricule :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 90, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Duree :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 110, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Lieu  :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 110, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Objet Mission :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 110, 30));

        btn_modifier.setText("Modifier");
        btn_modifier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modifierActionPerformed(evt);
            }
        });
        jPanel1.add(btn_modifier, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, -1, 30));

        txt_Matricule.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txt_Matricule.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txt_MatriculeItemStateChanged(evt);
            }
        });
        jPanel1.add(txt_Matricule, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 230, 30));

        btn_envoyer.setText("Envoyer");
        btn_envoyer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_envoyer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_envoyerActionPerformed(evt);
            }
        });
        jPanel1.add(btn_envoyer, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, -1, 30));

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

        txt_debut.setDateFormatString("yyyy/MM/dd");
        jPanel1.add(txt_debut, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 228, 30));

        txt_Objet.setColumns(20);
        txt_Objet.setLineWrap(true);
        txt_Objet.setRows(5);
        txt_Objet.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txt_Objet);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 230, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 489, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_DureeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DureeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DureeActionPerformed

    private void btn_modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifierActionPerformed
        modifier();
    }//GEN-LAST:event_btn_modifierActionPerformed

    private void btn_envoyerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_envoyerActionPerformed
        ajouter();
    }//GEN-LAST:event_btn_envoyerActionPerformed

    private void fermerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fermerMouseClicked
        dir.setVisible(true);
        this.dispose();
        dir.setEnabled(true);
        dir.Actualiser();
    }//GEN-LAST:event_fermerMouseClicked

    private void fermerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fermerMouseEntered
        fermer.setBackground(Color.red);
    }//GEN-LAST:event_fermerMouseEntered

    private void fermerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fermerMouseExited
        fermer.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_fermerMouseExited

    private void txt_MatriculeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txt_MatriculeItemStateChanged

    }//GEN-LAST:event_txt_MatriculeItemStateChanged

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
            java.util.logging.Logger.getLogger(Ordre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ordre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ordre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ordre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_envoyer;
    private javax.swing.JButton btn_modifier;
    private javax.swing.JPanel fermer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_Duree;
    private javax.swing.JTextField txt_Lieu;
    private javax.swing.JComboBox<String> txt_Matricule;
    private javax.swing.JTextArea txt_Objet;
    private com.toedter.calendar.JDateChooser txt_debut;
    // End of variables declaration//GEN-END:variables
}
