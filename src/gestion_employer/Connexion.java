/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gestion_employer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALEX RAKOTOARISOA
 */
public class Connexion extends javax.swing.JFrame {

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    DefaultTableModel model = new DefaultTableModel();
    static String teste;
    static String num;
    static String date;
    private Timer rotationTimer;
    
    public Connexion() {
        initComponents();
        Radio_btn();
        Radio_btn1();
        iconRotation();
    }
    
    
String db = "gestion.db";
    
public void Radio_btn(){
    ButtonGroup buttonGroup = new ButtonGroup();
    
    
    dir_connecter.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        dir_connecter.setSelected(false);
    }
    });
     util_connecter.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        util_connecter.setSelected(false);
    }
    });
     buttonGroup.add(dir_connecter);
     buttonGroup.add(util_connecter);
}

public void Radio_btn1(){
    ButtonGroup buttonGroup = new ButtonGroup();
    
    
    dir_inscrire.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        dir_inscrire.setSelected(false);
    }
    });
     util_inscrire.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        util_inscrire.setSelected(false);
    }
    });
     buttonGroup.add(dir_inscrire);
     buttonGroup.add(util_inscrire);
}
    
    
   public void iconRotation(){
       rotationTimer = new Timer(50, new ActionListener() {
           double angle = 0;
           boolean tr = true;
           
           @Override
           public void actionPerformed(ActionEvent e) {
               
               if(tr){
                    feuille.setIcon(rotateIcon(new ImageIcon(getClass().getResource("/image/feuille.png")),angle));   
               angle += Math.toRadians(1);
               if(angle >=Math.toRadians(18)){
                   angle = Math.toRadians(18);
                  tr = false;
               }
               }else{
                    angle -= Math.toRadians(1);
                    if(angle <= 0){
                         angle = 0;
                    tr = true;
                    }
                   
               }
                 feuille.setIcon(rotateIcon(new ImageIcon(getClass().getResource("/image/feuille.png")),angle)); 
           }
       });
       
       addComponentListener(new ComponentAdapter(){
          @Override
          public void componentShown(ComponentEvent e){
              rotationTimer.start();
          }
       });
   } 
    
   public ImageIcon rotateIcon(ImageIcon originalIcon, double angle){
       Image image = originalIcon.getImage();
       int width = originalIcon.getIconWidth();
       int height = originalIcon.getIconHeight();
       
       BufferedImage rotatedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
       Graphics2D g2d = rotatedImage.createGraphics();
       g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
       
       AffineTransform transform = new AffineTransform();
       transform.rotate(angle,width/2,height/2);
       g2d.drawImage(image, transform, null);
       g2d.dispose();
        return new ImageIcon(rotatedImage); 
       
   }
    
    
    
    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        Connecter_btn = new javax.swing.JButton();
        txt_Name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        util_connecter = new javax.swing.JRadioButton();
        dir_connecter = new javax.swing.JRadioButton();
        Edit_btn = new javax.swing.JLabel();
        txt_Password = new javax.swing.JPasswordField();
        fermer = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        feuille = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Inscrire_btn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        util_inscrire = new javax.swing.JRadioButton();
        dir_inscrire = new javax.swing.JRadioButton();
        Retour_btn = new javax.swing.JButton();
        txt_cpas = new javax.swing.JPasswordField();
        txt_pas = new javax.swing.JPasswordField();
        fermer1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Peersonnel.png"))); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, -190, 500, 570));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("DIRECTION REGIONALE");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 210, 50));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("DE L'AGRICULTURE ET DE L'ELEVAGE");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, -1, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-190, 0, 550, 443));

        jTabbedPane1.setBackground(new java.awt.Color(102, 255, 153));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Connecter_btn.setBackground(new java.awt.Color(0, 102, 102));
        Connecter_btn.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        Connecter_btn.setForeground(new java.awt.Color(255, 255, 255));
        Connecter_btn.setText("Connecter");
        Connecter_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Connecter_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Connecter_btnActionPerformed(evt);
            }
        });
        jPanel3.add(Connecter_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 190, 40));

        txt_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NameActionPerformed(evt);
            }
        });
        jPanel3.add(txt_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 230, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Se connecter");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        jLabel2.setText("Nom d'utilisateur :");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        jLabel3.setText("Mot de passe :");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        util_connecter.setText("Utilisateur");
        util_connecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                util_connecterActionPerformed(evt);
            }
        });
        jPanel3.add(util_connecter, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, -1, -1));

        dir_connecter.setText("Directeur ");
        dir_connecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dir_connecterActionPerformed(evt);
            }
        });
        jPanel3.add(dir_connecter, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));

        Edit_btn.setText("<html>\n<u>Creer un compte</u>\n</html>");
        Edit_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Edit_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Edit_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Edit_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Edit_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Edit_btnMousePressed(evt);
            }
        });
        jPanel3.add(Edit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 316, -1, 30));

        txt_Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_PasswordActionPerformed(evt);
            }
        });
        jPanel3.add(txt_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 230, 30));

        fermer.setBackground(new java.awt.Color(255, 255, 255));
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

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("X");

        javax.swing.GroupLayout fermerLayout = new javax.swing.GroupLayout(fermer);
        fermer.setLayout(fermerLayout);
        fermerLayout.setHorizontalGroup(
            fermerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fermerLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        fermerLayout.setVerticalGroup(
            fermerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        jPanel3.add(fermer, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 70, 25));
        jPanel3.add(feuille, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 51, 50, 40));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/branche.png"))); // NOI18N
        jLabel13.setText("jLabel13");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 100, 100));

        jTabbedPane1.addTab("tab1", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Inscrire_btn.setBackground(new java.awt.Color(0, 102, 102));
        Inscrire_btn.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        Inscrire_btn.setForeground(new java.awt.Color(255, 255, 255));
        Inscrire_btn.setText("Inscrire");
        Inscrire_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Inscrire_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inscrire_btnActionPerformed(evt);
            }
        });
        jPanel4.add(Inscrire_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 190, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("S'inscrire");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));
        jPanel4.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 230, 30));

        jLabel5.setText("Nom et Prénom :");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));

        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });
        jPanel4.add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 230, 30));

        jLabel6.setText("Nom d'utilisateur :");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        jLabel7.setText("Mot de passe :");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        jLabel8.setText("Confirmer mot de passe :");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, -1, -1));

        util_inscrire.setText("Utilisateur");
        util_inscrire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                util_inscrireActionPerformed(evt);
            }
        });
        jPanel4.add(util_inscrire, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        dir_inscrire.setText("Directeur ");
        dir_inscrire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dir_inscrireActionPerformed(evt);
            }
        });
        jPanel4.add(dir_inscrire, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, -1, -1));

        Retour_btn.setText("Retour");
        Retour_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Retour_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Retour_btnActionPerformed(evt);
            }
        });
        jPanel4.add(Retour_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, -1, -1));
        jPanel4.add(txt_cpas, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 230, 30));
        jPanel4.add(txt_pas, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 230, 30));

        fermer1.setBackground(new java.awt.Color(255, 255, 255));
        fermer1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fermer1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fermer1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fermer1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fermer1MouseExited(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("X");

        javax.swing.GroupLayout fermer1Layout = new javax.swing.GroupLayout(fermer1);
        fermer1.setLayout(fermer1Layout);
        fermer1Layout.setHorizontalGroup(
            fermer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fermer1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        fermer1Layout.setVerticalGroup(
            fermer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        jPanel4.add(fermer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 70, 25));

        jTabbedPane1.addTab("tab2", jPanel4);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, -37, 380, 480));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Connecter_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Connecter_btnActionPerformed
        String nom = txt_Name.getText();
        String pas = txt_Password.getText();
      
        
       if(dir_connecter.isSelected()){
        
                if (nom.isEmpty() || pas.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Veuillez completer tout les champs vide ","Erreur",JOptionPane.ERROR_MESSAGE);
                }else{
                             try{       
                                    Class.forName("org.sqlite.JDBC");
                                    con = DriverManager.getConnection("jdbc:sqlite:"+db);
                                    st = con.createStatement();
                                    rs = st.executeQuery("Select * from dir where username ='"+nom+"'");
                                            
                                    if(rs.next()){
                                         ResultSet rs1 = st.executeQuery("Select * from dir where username ='"+nom+"' and password='"+pas +"'");
                                            if(rs1.next()){
                                                    JOptionPane.showMessageDialog(null, "Vous êtes connectés","Information",JOptionPane.INFORMATION_MESSAGE);
                                                  Directeur dir = new Directeur();
                                                  dir.setVisible(true);
                                                  this.dispose();
                                          
                                                }else{
                                                   // alert = new Alert(Alert.AlertType.ERROR);
                                                         JOptionPane.showMessageDialog(null, "Mot de passe incorrecte.","Erreur",JOptionPane.ERROR_MESSAGE);                           
                                            }
                                    }else{
                                       JOptionPane.showMessageDialog(null,"Le nom d'utilisateur que vous avez saisi n'éxiste pas. Veuillez vérifier.") ;

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
                
       }else if(util_connecter.isSelected()){
                 if (nom.isEmpty() || pas.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Veuillez completer tout les champs vide ","Erreur",JOptionPane.ERROR_MESSAGE);
                }else{
                            try{            
                                    Class.forName("org.sqlite.JDBC");
                                    con = DriverManager.getConnection("jdbc:sqlite:"+db);
                                    st = con.createStatement();
                                    rs = st.executeQuery("Select * from sec where username ='"+nom+"'");
                                            
                                    if(rs.next()){
                                         ResultSet rs1 = st.executeQuery("Select * from sec where username ='"+nom+"' and password='"+pas +"'");
                                            if(rs1.next()){
                                                    JOptionPane.showMessageDialog(null, "Vous êtes connectés","Information",JOptionPane.INFORMATION_MESSAGE);
                                                    Utilisateur util = new Utilisateur();
                                                    util.setVisible(true);
                                                    this.dispose();
                                          
                                                }else{
                                                   // alert = new Alert(Alert.AlertType.ERROR);
                                                        JOptionPane.showMessageDialog(null, "Mot de passe incorrecte.","Erreur",JOptionPane.ERROR_MESSAGE);                            
                                            }
                                    }else{
                                       JOptionPane.showMessageDialog(null,"Le nom d'utilisateur que vous avez saisi n'éxiste pas. Veuillez vérifier.") ;

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
       }else{
            JOptionPane.showMessageDialog(null, "Veuillez selectionner parmi un de ces options au dessus");
       }          
                  
    }//GEN-LAST:event_Connecter_btnActionPerformed

    private void txt_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NameActionPerformed

    private void Inscrire_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inscrire_btnActionPerformed


String pas = txt_pas.getText();
String Cpas = txt_cpas.getText();

             

           if(dir_inscrire.isSelected()){
                         try{
                                   if(txt_name.getText().isEmpty() || txt_username.getText().isEmpty() || pas.isEmpty()|| Cpas.isEmpty()){
                                    
                                    JOptionPane.showMessageDialog(null, "Veuillez completer tout les champs vide ","Erreur",JOptionPane.ERROR_MESSAGE);
                                    

                                   }else{
                                            if(pas.equals(Cpas)){
                                                if(JOptionPane.showConfirmDialog(this, "Êtes vous sûr de vouloir s'inscrire en tant que Directeur ?","Attention",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
                                                Class.forName("org.sqlite.JDBC");
                                                  con = DriverManager.getConnection("jdbc:sqlite:"+db);
                                                           st = con.createStatement();
                                                           st.executeUpdate("insert into dir (Nom,username,password) values ('"+txt_name.getText()+"','"+txt_username.getText()+"','"+pas+"') ");
                                                                JOptionPane.showMessageDialog(null, "Compte créer avec succès","Information",JOptionPane.INFORMATION_MESSAGE);
                                                            jTabbedPane1.setSelectedIndex(0);
                                                            txt_Name.setText("");
                                                            txt_Password.setText("");
                                                            dir_connecter.setSelected(false);
                                                            util_connecter.setSelected(false);
                                                                   
                                                }else{
                                                    return;
                                                }             

                                            }else{
                                             
                                                  JOptionPane.showMessageDialog(null, "Confirmation du mot de passe incorrecte","Erreur",JOptionPane.ERROR_MESSAGE);    
                          
            
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

               }else if (util_inscrire.isSelected()){
                          try{
                                   if(txt_name.getText().isEmpty() || txt_username.getText().isEmpty() || pas.isEmpty() || Cpas.isEmpty()){
                                            JOptionPane.showMessageDialog(null, "Veuillez completer tout les champs vide ","Erreur",JOptionPane.ERROR_MESSAGE);
                                   }else{
                                            if(pas.equals(Cpas)){
                                                
                                                if(JOptionPane.showConfirmDialog(this, "Êtes vous sûr de vouloir s'inscrire en tant qu'Utilisateur ?","Attention",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
                                                       Class.forName("org.sqlite.JDBC");
                                                            con = DriverManager.getConnection("jdbc:sqlite:"+db);
                                                           st = con.createStatement();
                                                           st.executeUpdate("insert into sec (Nom,username,password) values ('"+txt_name.getText()+"','"+txt_username.getText()+"','"+txt_pas.getText()+"') ");
                                                                        JOptionPane.showMessageDialog(null, "Compte créer avec succès","Information",JOptionPane.INFORMATION_MESSAGE);
                                                            jTabbedPane1.setSelectedIndex(0);
                                                            txt_Name.setText("");
                                                            txt_Password.setText("");
                                                            dir_connecter.setSelected(false);
                                                            util_connecter.setSelected(false);
                                                }else{
                                                   return;
                                                }

                                            }else{
                                             

                                                  JOptionPane.showMessageDialog(null, "Confirmation du mot de passe incorrecte","Erreur",JOptionPane.ERROR_MESSAGE); 
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
               }else{
                      JOptionPane.showMessageDialog(null, "Veuillez selectionner parmi un de ces options au dessus");
}
    }//GEN-LAST:event_Inscrire_btnActionPerformed

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void util_inscrireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_util_inscrireActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_util_inscrireActionPerformed

    private void dir_inscrireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dir_inscrireActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dir_inscrireActionPerformed

    private void util_connecterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_util_connecterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_util_connecterActionPerformed

    private void dir_connecterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dir_connecterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dir_connecterActionPerformed

    private void Edit_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Edit_btnMouseClicked
        txt_name.setText("");
        txt_username.setText("");
        txt_pas.setText("");
        txt_cpas.setText("");
        dir_inscrire.setSelected(false);
        util_inscrire.setSelected(false);
        jTabbedPane1.setSelectedIndex(1);    
    }//GEN-LAST:event_Edit_btnMouseClicked

    private void Retour_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Retour_btnActionPerformed
        jTabbedPane1.setSelectedIndex(0);
        txt_Name.setText("");
        txt_Password.setText("");
        dir_connecter.setSelected(false);
        util_connecter.setSelected(false);
    }//GEN-LAST:event_Retour_btnActionPerformed

    private void txt_PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PasswordActionPerformed

    private void Edit_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Edit_btnMousePressed
      
    }//GEN-LAST:event_Edit_btnMousePressed

    private void fermerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fermerMouseEntered
        fermer.setBackground(Color.red);
    }//GEN-LAST:event_fermerMouseEntered

    private void fermerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fermerMouseExited
        fermer.setBackground(Color.white);
    }//GEN-LAST:event_fermerMouseExited

    private void fermerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fermerMouseClicked
        System.exit(0);
    }//GEN-LAST:event_fermerMouseClicked

    private void Edit_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Edit_btnMouseEntered
        Edit_btn.setForeground(new Color(0,0,204));
    }//GEN-LAST:event_Edit_btnMouseEntered

    private void Edit_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Edit_btnMouseExited
        Edit_btn.setForeground(Color.black);
    }//GEN-LAST:event_Edit_btnMouseExited

    private void fermer1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fermer1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_fermer1MouseClicked

    private void fermer1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fermer1MouseEntered
      fermer1.setBackground(Color.red);
    }//GEN-LAST:event_fermer1MouseEntered

    private void fermer1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fermer1MouseExited
        fermer1.setBackground(Color.white);
    }//GEN-LAST:event_fermer1MouseExited

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
            java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Connexion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Connecter_btn;
    private javax.swing.JLabel Edit_btn;
    private javax.swing.JButton Inscrire_btn;
    private javax.swing.JButton Retour_btn;
    private javax.swing.JRadioButton dir_connecter;
    private javax.swing.JRadioButton dir_inscrire;
    private javax.swing.JPanel fermer;
    private javax.swing.JPanel fermer1;
    private javax.swing.JLabel feuille;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txt_Name;
    private javax.swing.JPasswordField txt_Password;
    private javax.swing.JPasswordField txt_cpas;
    private javax.swing.JTextField txt_name;
    private javax.swing.JPasswordField txt_pas;
    private javax.swing.JTextField txt_username;
    private javax.swing.JRadioButton util_connecter;
    private javax.swing.JRadioButton util_inscrire;
    // End of variables declaration//GEN-END:variables
}
