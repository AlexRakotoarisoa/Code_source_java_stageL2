
package gestion_employer;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class Ajout_personnel extends javax.swing.JFrame {
 Connection con = null;
Statement st = null;
ResultSet rs = null;

    Utilisateur util;
    
    public Ajout_personnel(Utilisateur util) {
        initComponents();
        this.util=util;
        valeurRecu();
        combo();
        combo1();
        
        
    }
    
String db = "gestion.db";
     public void combo(){
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:"+db);
            st=con.createStatement();
            rs = st.executeQuery("Select Service from service");
            
            LinkedList<String> liste = new LinkedList<>();
            while(rs.next()){
                String pr = rs.getString("Service");
                liste.add(pr);
            }
            rs.close();
            st.close();
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(liste.toArray(new String[0]));
            txt_service1.setModel(model);
            
            
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
     
     
     public void combo1(){
        try{
             Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:"+db);
            st=con.createStatement();
            rs = st.executeQuery("Select Poste from poste");
            
            LinkedList<String> liste1 = new LinkedList<>();
            while(rs.next()){
                String pr = rs.getString("Poste");
                liste1.add(pr);
            }
            rs.close();
            st.close();
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(liste1.toArray(new String[0]));
            txt_poste.setModel(model);
            
            
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
    
    public void valeurRecu(){
  
             int row = util.tablePersonnel.getSelectedRow();
            if (row == -1){
                txt_matricule.setText("");  
                txt_nom.setText(""); 
                txt_prenom.setText("");
                txt_corps.setText("");
                txt_grade.setText("");
                txt_service1.setSelectedItem("");
                txt_poste.setSelectedItem("");
                txt_NumTel.setText("");
                txt_NumCIN.setText("");
                txt_LieuDelivrance.setText("");
                txt_Email.setText("");
                btn_modifier.setEnabled(false);
                
                }else{
                util.deplace();
                String d = util.ahona();
         try{
             SimpleDateFormat sp = new SimpleDateFormat("yyyy/MM/dd");
                 
        
                String sql = "Select * from personnel where Matricule = '"+d+"'";
                  Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:"+db);
                        st=con.createStatement();
                        rs = st.executeQuery(sql);
                        rs.next();
                        txt_matricule.setText(d);
                        String nom = rs.getString("Nom_Pers");
                        txt_nom.setText(nom);
                        String prenom = rs.getString("Prenom_Pers");
                        txt_prenom.setText(prenom);
                        String corps = rs.getString("Corps_As");
                        txt_corps.setText(corps);
                        String grade = rs.getString("Grade");
                        txt_grade.setText(grade);
                        String service = rs.getString("Service");
                        txt_service1.setSelectedItem(service);
                        String poste = rs.getString("Poste");
                        txt_poste.setSelectedItem(poste);
                        String sexe = rs.getString("Sexe");
                        txt_Sexe.setSelectedItem(sexe);
                        
                        String tel = rs.getString("Num_Tel");
                        txt_NumTel.setText(tel);
                        String cin = rs.getString("Num_CIN");
                        txt_NumCIN.setText(cin);
                        String Lieu = rs.getString("Lieu_Delivrance");
                        txt_LieuDelivrance.setText(Lieu);
                        String email = rs.getString("Email");
                        txt_Email.setText(email);
                        
                        String embauche = rs.getString("Date_Emb");
                        Date ee = sp.parse(embauche);
                        txt_embauche.setDate(ee);
                        String effet = rs.getString("Date_Eff");
                        Date eff = sp.parse(effet);
                        txt_effet.setDate(eff);
                        
                        String delivr = rs.getString("Date_Delivrance");
                        Date deliv = sp.parse(delivr);
                        txt_DateDelivrance.setDate(deliv);
                        
                        btn_ajouter.setEnabled(false);
                        txt_matricule.setEditable(false);
                        
           }catch(Exception e){
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
        String Matricule = txt_matricule.getText();
        String Nom = txt_nom.getText();
        String Prenom = txt_prenom.getText();
        String Corps = txt_corps.getText();
        String Grade = txt_grade.getText();
        
        String numTel = txt_NumTel.getText();
        String numCIN = txt_NumCIN.getText();
        String lieuDelivrance = txt_LieuDelivrance.getText();
        String email = txt_Email.getText();
        Date delivrance = txt_DateDelivrance.getDate();
        
        Date Embauche = txt_embauche.getDate();
        Date Effet = txt_effet.getDate();
        String sexe = txt_Sexe.getSelectedItem().toString();
        
         if (Matricule.isEmpty() || Nom.isEmpty() || Prenom.isEmpty() || Corps.isEmpty() ||Grade.isEmpty()|| numTel.isEmpty()|| numCIN.isEmpty()|| lieuDelivrance.isEmpty()|| email.isEmpty()||txt_service1.getSelectedItem() == null|| txt_poste.getSelectedItem() == null|| txt_Sexe.getSelectedItem() == null ||  Embauche == null||  Effet == null ||  delivrance == null){
             JOptionPane.showMessageDialog(null, "Veuillez completer tout les champs vide ");
             
         }else{
                String Service =  txt_service1.getSelectedItem().toString();
                String Poste = txt_poste.getSelectedItem().toString();
                SimpleDateFormat sp = new SimpleDateFormat("yyyy/MM/dd");
                String date = sp.format(txt_embauche.getDate());
                SimpleDateFormat ps = new SimpleDateFormat("yyyy/MM/dd");
                String date1 = ps.format(txt_effet.getDate());
                 SimpleDateFormat del = new SimpleDateFormat("yyyy/MM/dd");
                String date2 = del.format(txt_DateDelivrance.getDate());
             
                String sql = "insert into personnel (Matricule,Nom_Pers,Prenom_Pers,Corps_As,Grade,Service,Poste,Date_Emb,Date_Eff,Sexe,Num_Tel,Num_CIN,Date_Delivrance,Lieu_Delivrance,Email) values ('"+Matricule+"','"+Nom+"','"+Prenom+"','"+Corps+"','"+Grade+"','"+Service+"','"+Poste+"','"+date+"','"+date1+"','"+sexe+"','"+numTel+"','"+numCIN+"','"+date2+"','"+lieuDelivrance+"','"+email+"')";
                        
             try{
                    Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:"+db);
                        st=con.createStatement();
                        rs=st.executeQuery("Select Matricule from personnel where Matricule ='"+Matricule+"' ");
                        if(rs.next()){
                            JOptionPane.showMessageDialog(null, "Ce Matricule éxiste déja, veuillez lui attribuer un autre ");
                        }else{
                            st.executeUpdate(sql);
                            JOptionPane.showMessageDialog(null, "Ajout avec succès");
                            con.close();
                            util.Actualiser();
                            util.setEnabled(true);
                            this.dispose();
                            
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
        
        String Matricule = txt_matricule.getText();
        String Nom = txt_nom.getText();
        String Prenom = txt_prenom.getText();
        String Corps = txt_corps.getText();
        String Grade = txt_grade.getText();
        String sexe = txt_Sexe.getSelectedItem().toString();
        Date Embauche = txt_embauche.getDate();
        Date Effet = txt_effet.getDate();
        String numTel = txt_NumTel.getText();
        String numCIN = txt_NumCIN.getText();
        String lieuDelivrance = txt_LieuDelivrance.getText();
        String email = txt_Email.getText();
        Date delivrance = txt_DateDelivrance.getDate();
        
        
         if (Matricule.isEmpty() || Nom.isEmpty() || Prenom.isEmpty() || Corps.isEmpty() ||Grade.isEmpty()|| numTel.isEmpty()|| numCIN.isEmpty()|| lieuDelivrance.isEmpty()|| email.isEmpty()||txt_service1.getSelectedItem() == null|| txt_poste.getSelectedItem() == null|| txt_Sexe.getSelectedItem() == null ||  Embauche == null||  Effet == null ||  delivrance == null){
             JOptionPane.showMessageDialog(null, "Veuillez completer tout les champs vide ");
         }else{
             String Service =  txt_service1.getSelectedItem().toString();
           String Poste = txt_poste.getSelectedItem().toString();
                SimpleDateFormat sp = new SimpleDateFormat("yyyy/MM/dd");
                String date = sp.format(txt_embauche.getDate());
                 SimpleDateFormat ps = new SimpleDateFormat("yyyy/MM/dd");
                String date1 = ps.format(txt_effet.getDate());
                 SimpleDateFormat deli = new SimpleDateFormat("yyyy/MM/dd");
                String dateDeli = deli.format(txt_DateDelivrance.getDate());
                
                String sql = "Update personnel set Nom_Pers='"+Nom+"',Prenom_Pers='"+Prenom+"',Corps_As='"+Corps+"',Grade='"+Grade+"',Service='"+Service+"',Poste='"+Poste+"',Date_Emb = '"+date+"',Date_Eff = '"+date1+"',Sexe = '"+sexe+"',Num_Tel = '"+numTel+"',Num_CIN = '"+numCIN+"',Date_Delivrance = '"+dateDeli+"',Lieu_Delivrance = '"+lieuDelivrance+"',Email = '"+email+"' where Matricule='"+Matricule+"'";
             try{
                      Class.forName("org.sqlite.JDBC");
                      con = DriverManager.getConnection("jdbc:sqlite:"+db);
                        st=con.createStatement();
                        st.executeUpdate(sql);
                            JOptionPane.showMessageDialog(null, "Modification avec succès");
                            con.close();
                            util.Actualiser();
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
        txt_matricule = new javax.swing.JTextField();
        txt_nom = new javax.swing.JTextField();
        txt_prenom = new javax.swing.JTextField();
        txt_corps = new javax.swing.JTextField();
        txt_grade = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btn_modifier = new javax.swing.JButton();
        txt_poste = new javax.swing.JComboBox<>();
        txt_Sexe = new javax.swing.JComboBox<>();
        btn_ajouter = new javax.swing.JButton();
        fermer = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txt_effet = new com.toedter.calendar.JDateChooser();
        txt_embauche = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        txt_service1 = new javax.swing.JComboBox<>();
        txt_Email = new javax.swing.JTextField();
        txt_NumTel = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_NumCIN = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_LieuDelivrance = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txt_DateDelivrance = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("INFORMATION DU PERSONNEL");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, 44));

        txt_matricule.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txt_matricule, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 230, 30));

        txt_nom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txt_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 230, 30));

        txt_prenom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txt_prenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 230, 30));

        txt_corps.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_corps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_corpsActionPerformed(evt);
            }
        });
        jPanel1.add(txt_corps, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 230, 30));

        txt_grade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txt_grade, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 230, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Email : ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 140, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Matricule :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 90, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nom :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 90, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Prenom :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 90, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Corps Assimilé :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 110, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Grade :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 110, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Service :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 110, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Poste :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 110, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Date d'Embauche :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 130, 30));

        btn_modifier.setText("Modifier");
        btn_modifier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modifierActionPerformed(evt);
            }
        });
        jPanel1.add(btn_modifier, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 420, -1, 30));

        txt_poste.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txt_poste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_posteActionPerformed(evt);
            }
        });
        jPanel1.add(txt_poste, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 230, 30));

        txt_Sexe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));
        jPanel1.add(txt_Sexe, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 230, 30));

        btn_ajouter.setText("Ajouter");
        btn_ajouter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ajouterActionPerformed(evt);
            }
        });
        jPanel1.add(btn_ajouter, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 420, -1, 30));

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

        jPanel1.add(fermer, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 70, 25));

        txt_effet.setDateFormatString("yyyy/MM/dd");
        jPanel1.add(txt_effet, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 228, 25));

        txt_embauche.setDateFormatString("yyyy/MM/dd");
        jPanel1.add(txt_embauche, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, 228, 25));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Sexe :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 110, 30));

        txt_service1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(txt_service1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 230, 30));
        jPanel1.add(txt_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, 230, 30));
        jPanel1.add(txt_NumTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 230, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Date d'Effet :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 130, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Numero téléphone :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 140, 30));
        jPanel1.add(txt_NumCIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, 230, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Numéro CIN :");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 140, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Délivré le :");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 140, 30));
        jPanel1.add(txt_LieuDelivrance, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, 230, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("A :");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 140, 30));

        txt_DateDelivrance.setDateFormatString("yyyy/MM/dd");
        jPanel1.add(txt_DateDelivrance, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 252, 228, 25));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 480));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifierActionPerformed
        modifier();
    }//GEN-LAST:event_btn_modifierActionPerformed

    private void txt_corpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_corpsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_corpsActionPerformed

    private void btn_ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ajouterActionPerformed
        ajouter();
    }//GEN-LAST:event_btn_ajouterActionPerformed

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

    private void txt_posteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_posteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_posteActionPerformed

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
            java.util.logging.Logger.getLogger(Ajout_personnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ajout_personnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ajout_personnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ajout_personnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ajouter;
    private javax.swing.JButton btn_modifier;
    private javax.swing.JPanel fermer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser txt_DateDelivrance;
    private javax.swing.JTextField txt_Email;
    private javax.swing.JTextField txt_LieuDelivrance;
    private javax.swing.JTextField txt_NumCIN;
    private javax.swing.JTextField txt_NumTel;
    private javax.swing.JComboBox<String> txt_Sexe;
    private javax.swing.JTextField txt_corps;
    private com.toedter.calendar.JDateChooser txt_effet;
    private com.toedter.calendar.JDateChooser txt_embauche;
    private javax.swing.JTextField txt_grade;
    private javax.swing.JTextField txt_matricule;
    private javax.swing.JTextField txt_nom;
    private javax.swing.JComboBox<String> txt_poste;
    private javax.swing.JTextField txt_prenom;
    private javax.swing.JComboBox<String> txt_service1;
    // End of variables declaration//GEN-END:variables
}
