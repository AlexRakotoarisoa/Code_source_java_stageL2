/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gestion_employer;


import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ALEX RAKOTOARISOA
 */
public class Ajout_Service extends javax.swing.JFrame {

     Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement prepare = null;

    Utilisateur util;
    public Ajout_Service(Utilisateur util) {
        initComponents();
        this.util = util;
        valeurRecu();
    }
String db = "gestion.db";
    
    public void valeurRecu(){
  
             int row = util.table_service.getSelectedRow();
            if (row == -1){
                txt_nomServ.setText("");  
                txt_Chef.setText(""); 
                txt_Desc.setText("");
                btn_Modif.setEnabled(false);
            }else{
                util.deplace1();
                String d = util.ahona1();
                    try{


                           String sql = "Select * from service where ID_Service = '"+d+"'";
                           Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:"+db);
                                   st=con.createStatement();
                                   rs = st.executeQuery(sql);
                                   rs.next();
                                    String nom = rs.getString("Service");
                                   txt_nomServ.setText(nom);
                                   String chef = rs.getString("Chef_Service");
                                   txt_Chef.setText(chef);
                                   String desc = rs.getString("Description_Serv");
                                   txt_Desc.setText(desc);
                                   btn_Ajout.setEnabled(false);
                                  
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
        String nom = txt_nomServ.getText();
        String chef = txt_Chef.getText();
        String desc = txt_Desc.getText();
       
        
        String sql = "insert into service (Service,Chef_Service,Description_Serv) values (?,?,?)";
        
         if (nom.isEmpty() || chef.isEmpty() || desc.isEmpty()){
             JOptionPane.showMessageDialog(null, "Veuillez completer tout les champs vide ");
         }else{
             try{
                    Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:"+db);
                        st=con.createStatement();
                        rs=st.executeQuery("Select Service from service where Service ='"+nom+"' ");
                        if(rs.next()){
                            JOptionPane.showMessageDialog(null, "Ce Service éxiste déja, veuillez saisir un autre ");
                        }else{
                          try{
                             Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:"+db);
                            prepare = con.prepareStatement(sql);
                            prepare.setString(1,nom);
                            prepare.setString(2, chef);
                            prepare.setString(3, desc);
                            prepare.executeUpdate();     
                            JOptionPane.showMessageDialog(null, "Ajout avec succès");
                            con.close();
                            util.Actualiser1();
                            util.setEnabled(true);
                            util.setVisible(true);
                            this.dispose();
                         }catch(SQLException | ClassNotFoundException e){
                                          System.err.println(e);
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
        util.deplace1();
        String d = util.ahona1();
        
       
        
        
        String nom = txt_nomServ.getText();
        String chef = txt_Chef.getText();
        String desc = txt_Desc.getText();
        String dd = util.Service.getText();
        
                String sql = "update service set Service = ?,Chef_Service = ?,Description_Serv = ? where ID_Service = ?";
                String sql1 = "update personnel set Service =? where Service =? ";
        
         if (nom.isEmpty() || chef.isEmpty() || desc.isEmpty()){
             JOptionPane.showMessageDialog(null, "Veuillez completer tout les champs vide ");
         }else{
             try{
                   Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:"+db);
                    PreparedStatement p = con.prepareStatement(sql1);
                    PreparedStatement prepa = con.prepareStatement(sql);
                    prepa.setString(1, nom);
                    prepa.setString(2, chef);
                    prepa.setString(3, desc);
                    prepa.setString(4, d);
                    prepa.executeUpdate();    
                    p.setString(1, nom);
                    p.setString(2, dd);
                    p.executeUpdate();   
                            JOptionPane.showMessageDialog(null, "Modification avec succès");
                            con.close();
                            util.Actualiser1();
                            util.setEnabled(true);
                            util.setVisible(true);
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
        txt_nomServ = new javax.swing.JTextField();
        txt_Chef = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_Modif = new javax.swing.JButton();
        btn_Ajout = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_Desc = new javax.swing.JTextArea();
        fermer = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("INFORMATION SERVICE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 280, 44));

        txt_nomServ.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txt_nomServ, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 230, 30));

        txt_Chef.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txt_Chef, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 230, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nom du Service :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 130, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Chef du Service :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 120, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Description :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 90, 30));

        btn_Modif.setText("Modifier");
        btn_Modif.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Modif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModifActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Modif, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, -1, 30));

        btn_Ajout.setText("Ajouter");
        btn_Ajout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Ajout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AjoutActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Ajout, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, -1, 30));

        txt_Desc.setColumns(20);
        txt_Desc.setLineWrap(true);
        txt_Desc.setRows(5);
        txt_Desc.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txt_Desc);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 230, 90));

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 390));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModifActionPerformed
        modifier();
    }//GEN-LAST:event_btn_ModifActionPerformed

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

    private void btn_AjoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AjoutActionPerformed
        ajouter();
    }//GEN-LAST:event_btn_AjoutActionPerformed

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
            java.util.logging.Logger.getLogger(Ajout_Service.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ajout_Service.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ajout_Service.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ajout_Service.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
       
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Ajout;
    private javax.swing.JButton btn_Modif;
    private javax.swing.JPanel fermer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_Chef;
    private javax.swing.JTextArea txt_Desc;
    private javax.swing.JTextField txt_nomServ;
    // End of variables declaration//GEN-END:variables
}
