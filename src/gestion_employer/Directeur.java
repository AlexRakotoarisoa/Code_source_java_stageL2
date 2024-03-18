/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gestion_employer;


import static gestion_employer.Utilisateur.tested;
import java.awt.Color;
import static java.awt.Color.red;
import static java.awt.Color.white;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.PatternSyntaxException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ALEX RAKOTOARISOA
 */
public class Directeur extends javax.swing.JFrame {

Connection con = null;
Statement st = null;
ResultSet rs ;
ResultSet sr ;
DefaultTableModel model = new DefaultTableModel();
DefaultTableModel modeld = new DefaultTableModel();
static String teste;
static String tested;

    
    
    
    public Directeur() {
        initComponents();
        recherche();
        recherched();
        liste();
        listed();
        s1.setVisible(true);
        s2.setVisible(false);
        notif.setVisible(false);
        dem.setVisible(true);
        Accepter.setEnabled(false);
        Refuser.setEnabled(false);
        modifier_demande.setEnabled(false);
        supprimer_demande.setVisible(false);
        deposer_demande.setEnabled(true);
    }

 String db = "gestion.db";
/****************************  D E M A N D E  ***************************/
        
    private void liste(){
           model.addColumn("");
           model.addColumn("Matricule");
           model.addColumn("Lieu");
           model.addColumn("Objet de la mission");
           model.addColumn("Durée");
           model.addColumn("A partir");
            
            
           Actualiser();
           TableColumn clmn = table_demande.getColumnModel().getColumn(0);
           clmn.setMinWidth(0);
           clmn.setMaxWidth(0);   
   }
    
    public void deplace(){
            int row= table_demande.getSelectedRow();
            this.teste =(table_demande.getModel().getValueAt(row, 0).toString());
            
    }
    
    public String ahona(){
        return teste;
    }
 
    
     public void delete(){
        deplace();
        String del = ahona();
        String sql = "Delete from ordre_de_route where ID_Ordre = '"+del+"'";
        
        try{    
               Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:"+db);
            st=con.createStatement();
            

                    if(JOptionPane.showConfirmDialog(this, "Confirmer la suppression","Confirmation",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
                        st.executeUpdate(sql);
                        Actualiser();
                        JOptionPane.showMessageDialog(null, "Supression réussie");
                      
            }else{
                 return;
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
    
    
    
     public void Actualiser(){
          model.setRowCount(0);
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:"+db);
          st = con.createStatement();
          rs = st.executeQuery("Select * from ordre_de_route");
          
          while (rs.next()){
              model.addRow(new Object[] {rs.getString("ID_ordre"),rs.getString("Matricule"),rs.getString("Lieu"),rs.getString("Objet_Mission"),rs.getString("Duree"),rs.getString("Date_Ordre")});
          
          }
        Recherche_demande.setText("");
        modifier_demande.setEnabled(false);
        supprimer_demande.setVisible(false);
        deposer_demande.setEnabled(true);
          
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
       
       table_demande.setModel(model);                                    
    }
     
  
     
public void recherche(){       
    
    TableRowSorter <TableModel> sorter = new TableRowSorter<>(model);
    table_demande.setRowSorter(sorter);
 
    
       Recherche_demande.getDocument().addDocumentListener(new DocumentListener(){
           
           @Override
           public void insertUpdate(DocumentEvent e){
               search(Recherche_demande.getText(), sorter);
           }
            @Override
           public void removeUpdate(DocumentEvent e){
                search(Recherche_demande.getText(), sorter);
           }

           @Override
           public void changedUpdate(DocumentEvent e) {
                search(Recherche_demande.getText(), sorter);
           }
       });
  
}


private static void search(String text, TableRowSorter<TableModel> sorter){
    if(text.length() == 0){
        sorter.setRowFilter(null);
    }else{
        try{
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }catch(PatternSyntaxException e){
            e.printStackTrace();
        }
    }
    
}

/**********************************************************************************/



 /********************* N O T I F I C A T I O N ******************************/ 
        
    private void listed(){
        modeld.addColumn("");
        modeld.addColumn("Matricule");
        modeld.addColumn("Type");
        modeld.addColumn("Durée");
        modeld.addColumn("Motif");
        modeld.addColumn("Statut");
        modeld.addColumn("Date dépot");
           Actualiserd();
           TableColumn clmd = table_notification.getColumnModel().getColumn(0);
           clmd.setMinWidth(0);
           clmd.setMaxWidth(0);  
           
   }
    
    public void deplaced(){
            int row= table_notification.getSelectedRow();
            this.tested =(table_notification.getModel().getValueAt(row, 0).toString());
            
    }
    
    public String ahonad(){
        return tested;
    }
 
    
    
     public void Actualiserd(){
          modeld.setRowCount(0);
        try{
            String statut = "En attente";
             Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:"+db);
          st = con.createStatement();
          rs = st.executeQuery("Select * from autorisation where Statut ='"+statut+"' ");
          
          while (rs.next()){
              modeld.addRow(new Object[] {rs.getString("ID_Autorisation"),rs.getString("Matricule"),rs.getString("Type"),rs.getInt("Duree"),rs.getString("Motif"),rs.getString("Statut"),rs.getString("Date_dpt")});
          
          }
           Accepter.setEnabled(false);
           Refuser.setEnabled(false);
           Recherche_notification.setText("");
          
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
       
       table_notification.setModel(modeld);                                    
    }
     
  
     
public void recherched(){       
    
    TableRowSorter <TableModel> sorter = new TableRowSorter<>(modeld);
    table_notification.setRowSorter(sorter);
 
    
       Recherche_notification.getDocument().addDocumentListener(new DocumentListener(){
           
           @Override
           public void insertUpdate(DocumentEvent e){
               searchd(Recherche_notification.getText(), sorter);
           }
            @Override
           public void removeUpdate(DocumentEvent e){
                searchd(Recherche_notification.getText(), sorter);
           }

           @Override
           public void changedUpdate(DocumentEvent e) {
                searchd(Recherche_notification.getText(), sorter);
           }
       });
  
}


private static void searchd(String text, TableRowSorter<TableModel> sorter){
    if(text.length() == 0){
        sorter.setRowFilter(null);
    }else{
        try{
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }catch(PatternSyntaxException e){
            e.printStackTrace();
        }
    }
    
}


public void Accept(){
    deplaced();
    String n = ahonad();
    Calendar cal = Calendar.getInstance();
    Date today = cal.getTime();
    String stat = "Valider";
   
    
     try{
            SimpleDateFormat sp = new SimpleDateFormat("yyyy/MM/dd");
            String date = sp.format(today);
             String up = "Update autorisation set Statut = '"+stat+"',Date_vld = '"+date+"' where ID_Autorisation = '"+n+"'";
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:"+db);
            st = con.createStatement();
             if(JOptionPane.showConfirmDialog(this, "Confirmer la validation","Confirmation",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
                        st.executeUpdate(up);
                        Actualiserd();
                        JOptionPane.showMessageDialog(null, "Demande d'autorisation validé");             
                        Accepter.setEnabled(false);
                        Refuser.setEnabled(false);
            }else{
                 return;
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

public void Refu(){
    deplaced();
    String n = ahonad();
    String stat = "Refuser";
   
    
     try{
             String up = "Update autorisation set Statut = '"+stat+"' where ID_Autorisation = '"+n+"'";
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:"+db);
            st = con.createStatement();
             if(JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de vouloir refuser cet demande","Confirmation",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
                        st.executeUpdate(up);
                        Actualiserd();
                        JOptionPane.showMessageDialog(null, "Demande d'autorisation refusé");             
                        Accepter.setEnabled(false);
                        Refuser.setEnabled(false);
            }else{
                 return;
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
/*******************************************************************************/



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        fermer = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        NAVIGATION = new javax.swing.JPanel();
        p2 = new javax.swing.JPanel();
        M5 = new javax.swing.JLabel();
        s2 = new javax.swing.JLabel();
        p1 = new javax.swing.JPanel();
        M4 = new javax.swing.JLabel();
        s1 = new javax.swing.JLabel();
        dem = new javax.swing.JLabel();
        deconnecter = new javax.swing.JLabel();
        notif = new javax.swing.JLabel();
        Dash = new javax.swing.JTabbedPane();
        DEMANDE = new javax.swing.JPanel();
        pannelDemande = new javax.swing.JPanel();
        supprimer_demande = new javax.swing.JButton();
        deposer_demande = new javax.swing.JButton();
        Recherche_demande = new javax.swing.JTextField();
        modifier_demande = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        table_demande = new javax.swing.JTable();
        NOTIFICATION = new javax.swing.JPanel();
        pannelNotification = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_notification = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        Recherche_notification = new javax.swing.JTextField();
        Refuser = new javax.swing.JButton();
        Accepter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        fermer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("X");
        fermer.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 20, 20));

        jPanel10.add(fermer, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, 70, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icone.png"))); // NOI18N
        jPanel10.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 20));

        jLabel4.setText("Gestion de personnel");
        jPanel10.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 120, -1));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 40));

        NAVIGATION.setBackground(new java.awt.Color(0, 102, 102));
        NAVIGATION.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        p2.setBackground(new java.awt.Color(0, 102, 102));
        p2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        p2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                p2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                p2MouseExited(evt);
            }
        });
        p2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        M5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        M5.setForeground(new java.awt.Color(255, 255, 255));
        M5.setText("NOTIFICATION");
        M5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        p2.add(M5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 130, 20));

        s2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        s2.setForeground(new java.awt.Color(0, 204, 204));
        s2.setText("|");
        p2.add(s2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 20));

        NAVIGATION.add(p2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 210, 40));

        p1.setBackground(new java.awt.Color(0, 102, 102));
        p1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        p1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                p1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                p1MouseExited(evt);
            }
        });
        p1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        M4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        M4.setForeground(new java.awt.Color(255, 255, 255));
        M4.setText("DEMANDE");
        M4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        p1.add(M4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 130, 20));

        s1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        s1.setForeground(new java.awt.Color(0, 204, 204));
        s1.setText("|");
        p1.add(s1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 20));

        NAVIGATION.add(p1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 210, 40));

        dem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/demande2.png"))); // NOI18N
        NAVIGATION.add(dem, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        deconnecter.setForeground(new java.awt.Color(255, 255, 255));
        deconnecter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/deco.png"))); // NOI18N
        deconnecter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deconnecter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deconnecterMouseClicked(evt);
            }
        });
        NAVIGATION.add(deconnecter, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, -1, -1));

        notif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/notif.png"))); // NOI18N
        NAVIGATION.add(notif, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        jPanel1.add(NAVIGATION, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 230, 590));

        DEMANDE.setBackground(new java.awt.Color(0, 102, 102));
        DEMANDE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pannelDemande.setBackground(new java.awt.Color(255, 255, 255));
        pannelDemande.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pannelDemandeMouseClicked(evt);
            }
        });
        pannelDemande.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        supprimer_demande.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/del.png"))); // NOI18N
        supprimer_demande.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        supprimer_demande.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimer_demandeActionPerformed(evt);
            }
        });
        pannelDemande.add(supprimer_demande, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 40, 40, 40));

        deposer_demande.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/envo.png"))); // NOI18N
        deposer_demande.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deposer_demande.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deposer_demandeActionPerformed(evt);
            }
        });
        pannelDemande.add(deposer_demande, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 490, 40, 40));

        Recherche_demande.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Recherche_demandeMouseClicked(evt);
            }
        });
        Recherche_demande.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Recherche_demandeActionPerformed(evt);
            }
        });
        pannelDemande.add(Recherche_demande, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 220, 30));

        modifier_demande.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/modifier.png"))); // NOI18N
        modifier_demande.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modifier_demande.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifier_demandeActionPerformed(evt);
            }
        });
        pannelDemande.add(modifier_demande, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 490, 40, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("ENVOYER UNE DEMANDE DE FABRICATION D'ORDRE DE ROUTE");
        pannelDemande.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 570, 30));

        table_demande.setModel(new javax.swing.table.DefaultTableModel(
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
        table_demande.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_demandeMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(table_demande);

        pannelDemande.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 860, 330));

        DEMANDE.add(pannelDemande, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 900, 560));

        Dash.addTab("tab5", DEMANDE);

        NOTIFICATION.setBackground(new java.awt.Color(0, 102, 102));
        NOTIFICATION.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pannelNotification.setBackground(new java.awt.Color(255, 255, 255));
        pannelNotification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pannelNotificationMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pannelNotificationMouseExited(evt);
            }
        });
        pannelNotification.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_notification.setModel(new javax.swing.table.DefaultTableModel(
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
        table_notification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_notificationMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(table_notification);

        pannelNotification.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 860, 330));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("DEMANDE D'AUTORISATION EN ATTENTE DE VOTRE VALIDATION");
        pannelNotification.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 590, 30));

        Recherche_notification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Recherche_notificationMouseClicked(evt);
            }
        });
        Recherche_notification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Recherche_notificationActionPerformed(evt);
            }
        });
        pannelNotification.add(Recherche_notification, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 220, 30));

        Refuser.setText("Refuser");
        Refuser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Refuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefuserActionPerformed(evt);
            }
        });
        pannelNotification.add(Refuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 473, 80, 40));

        Accepter.setText("Valider");
        Accepter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Accepter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccepterActionPerformed(evt);
            }
        });
        pannelNotification.add(Accepter, new org.netbeans.lib.awtextra.AbsoluteConstraints(715, 473, 80, 40));

        NOTIFICATION.add(pannelNotification, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 900, 560));

        Dash.addTab("tab3", NOTIFICATION);

        jPanel1.add(Dash, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, -50, -1, 670));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fermerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fermerMouseClicked
        System.exit(0);
    }//GEN-LAST:event_fermerMouseClicked

    private void fermerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fermerMouseEntered
        fermer.setBackground(red);
    }//GEN-LAST:event_fermerMouseEntered

    private void fermerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fermerMouseExited
        fermer.setBackground(white);
    }//GEN-LAST:event_fermerMouseExited

    private void p2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p2MouseClicked
        Dash.setSelectedIndex(1);
        s1.setVisible(false);
        s2.setVisible(true);
        p2.setBackground(new Color(0,102,102));
        notif.setVisible(true);
        dem.setVisible(false);
        table_notification.getTableHeader().setFont(new Font("Segoe UI",Font.PLAIN,15));
        Actualiserd();

    }//GEN-LAST:event_p2MouseClicked

    private void p2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p2MouseEntered
        p2.setBackground(new Color(0,204,204));
    }//GEN-LAST:event_p2MouseEntered

    private void p2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p2MouseExited
        p2.setBackground(new Color(0,102,102));
    }//GEN-LAST:event_p2MouseExited

    private void p1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p1MouseClicked
        Dash.setSelectedIndex(0);
        s1.setVisible(true);
        s2.setVisible(false);
        p1.setBackground(new Color(0,102,102));
        notif.setVisible(false);
        dem.setVisible(true);
        table_demande.getTableHeader().setFont(new Font("Segoe UI",Font.PLAIN,15));
        Actualiser();

    }//GEN-LAST:event_p1MouseClicked

    private void p1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p1MouseEntered
        p1.setBackground(new Color(0,204,204));
    }//GEN-LAST:event_p1MouseEntered

    private void p1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p1MouseExited
        p1.setBackground(new Color(0,102,102));
    }//GEN-LAST:event_p1MouseExited

    private void deconnecterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deconnecterMouseClicked
        if(JOptionPane.showConfirmDialog(this, "Êtes vous sûr de vouloir se deconnecter","Confirmation",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
            Connexion conn = new Connexion();
            this.dispose();
            conn.setVisible(true);

        }else{
            return;
        }
    }//GEN-LAST:event_deconnecterMouseClicked

    private void supprimer_demandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimer_demandeActionPerformed
        delete();
    }//GEN-LAST:event_supprimer_demandeActionPerformed

    private void deposer_demandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deposer_demandeActionPerformed
        Ordre ord = new Ordre(this);
        ord.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_deposer_demandeActionPerformed

    private void Recherche_demandeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Recherche_demandeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Recherche_demandeMouseClicked

    private void Recherche_demandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Recherche_demandeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Recherche_demandeActionPerformed

    private void modifier_demandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifier_demandeActionPerformed
        Ordre ord = new Ordre(this);
        ord.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_modifier_demandeActionPerformed

    private void table_demandeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_demandeMouseClicked
        modifier_demande.setEnabled(true);
        supprimer_demande.setVisible(true);
        deposer_demande.setEnabled(false);
    }//GEN-LAST:event_table_demandeMouseClicked

    private void table_notificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_notificationMouseClicked
        Accepter.setEnabled(true);
        Refuser.setEnabled(true);
    }//GEN-LAST:event_table_notificationMouseClicked

    private void Recherche_notificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Recherche_notificationMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Recherche_notificationMouseClicked

    private void Recherche_notificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Recherche_notificationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Recherche_notificationActionPerformed

    private void pannelNotificationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pannelNotificationMouseExited
       
    }//GEN-LAST:event_pannelNotificationMouseExited

    private void AccepterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccepterActionPerformed
        Accept();
    }//GEN-LAST:event_AccepterActionPerformed

    private void pannelNotificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pannelNotificationMouseClicked
 Actualiserd();
    }//GEN-LAST:event_pannelNotificationMouseClicked

    private void pannelDemandeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pannelDemandeMouseClicked
        Actualiser();
    }//GEN-LAST:event_pannelDemandeMouseClicked

    private void RefuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefuserActionPerformed
        Refu();
    }//GEN-LAST:event_RefuserActionPerformed

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
            java.util.logging.Logger.getLogger(Directeur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Directeur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Directeur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Directeur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Directeur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Accepter;
    private javax.swing.JPanel DEMANDE;
    private javax.swing.JTabbedPane Dash;
    private javax.swing.JLabel M4;
    private javax.swing.JLabel M5;
    private javax.swing.JPanel NAVIGATION;
    private javax.swing.JPanel NOTIFICATION;
    public javax.swing.JTextField Recherche_demande;
    private javax.swing.JTextField Recherche_notification;
    private javax.swing.JButton Refuser;
    private javax.swing.JLabel deconnecter;
    private javax.swing.JLabel dem;
    public javax.swing.JButton deposer_demande;
    private javax.swing.JPanel fermer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    public javax.swing.JButton modifier_demande;
    private javax.swing.JLabel notif;
    private javax.swing.JPanel p1;
    private javax.swing.JPanel p2;
    private javax.swing.JPanel pannelDemande;
    private javax.swing.JPanel pannelNotification;
    private javax.swing.JLabel s1;
    private javax.swing.JLabel s2;
    public javax.swing.JButton supprimer_demande;
    public javax.swing.JTable table_demande;
    public javax.swing.JTable table_notification;
    // End of variables declaration//GEN-END:variables
}
