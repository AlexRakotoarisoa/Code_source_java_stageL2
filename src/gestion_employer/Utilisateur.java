/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gestion_employer;


import java.awt.Color;
import static java.awt.Color.black;
import static java.awt.Color.red;
import static java.awt.Color.white;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.PatternSyntaxException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.text.MessageFormat;
import java.util.Locale;




/**
 *
 * @author ALEX RAKOTOARISOA
 */
public class Utilisateur extends javax.swing.JFrame {


Connection con = null;
Statement st = null;
Statement stx = null;
ResultSet rs ;
ResultSet sr ;
DefaultTableModel model = new DefaultTableModel();
DefaultTableModel model1 = new DefaultTableModel();
DefaultTableModel model2 = new DefaultTableModel();
DefaultTableModel modeld = new DefaultTableModel();
DefaultTableModel modeln = new DefaultTableModel();
static String testen;
static String tested;
static String teste;
static String teste1;
static String teste2;
static String teste21;
static String teste211;
    


public Utilisateur() {
        initComponents();
       
         modifier_pers.setEnabled(false);
         supprimer_pers.setVisible(false);
        liste2();
        liste1();
        liste();
        listed();
        listen();
        recherche();
        recherche1();
        recherche2();
        recherched();
        recherchen();
        visibleNavigation();
        tablePersonnel.getTableHeader().setFont(new Font("Segoe UI",Font.PLAIN,15));
        Service.setVisible(false);
        poste.setVisible(false);
        pt.setVisible(false);
        serv.setVisible(false);
        notif.setVisible(false);
        dem.setVisible(false);
        user.setVisible(true);
        
        imprimer_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                impression(tablePersonnel);
                JOptionPane.showMessageDialog(null, "PDF générer avec succès");
            }
        });
    }

String db = "gestion.db";
   public void visibleNavigation(){
       s1.setVisible(true);
       s2.setVisible(false);
       s3.setVisible(false);
       s4.setVisible(false);
       s5.setVisible(false);
   }
   
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        fermer = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        NAVIGATION = new javax.swing.JPanel();
        P5 = new javax.swing.JPanel();
        M5 = new javax.swing.JLabel();
        s5 = new javax.swing.JLabel();
        P4 = new javax.swing.JPanel();
        M4 = new javax.swing.JLabel();
        s4 = new javax.swing.JLabel();
        P3 = new javax.swing.JPanel();
        M3 = new javax.swing.JLabel();
        s3 = new javax.swing.JLabel();
        P2 = new javax.swing.JPanel();
        M2 = new javax.swing.JLabel();
        s2 = new javax.swing.JLabel();
        P1 = new javax.swing.JPanel();
        M1 = new javax.swing.JLabel();
        s1 = new javax.swing.JLabel();
        pt = new javax.swing.JLabel();
        notif = new javax.swing.JLabel();
        serv = new javax.swing.JLabel();
        dem = new javax.swing.JLabel();
        deconnecter = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        Dash = new javax.swing.JTabbedPane();
        PERSONNEL = new javax.swing.JPanel();
        panelPersonnel = new javax.swing.JPanel();
        Recherche_pers = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePersonnel = new javax.swing.JTable();
        supprimer_pers = new javax.swing.JButton();
        modifier_pers = new javax.swing.JButton();
        ajouter_pers = new javax.swing.JButton();
        imprimer_btn = new javax.swing.JButton();
        SERVICE = new javax.swing.JPanel();
        pannelService = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_service = new javax.swing.JTable();
        Recherche_service = new javax.swing.JTextField();
        ajouter_service = new javax.swing.JButton();
        modifier_service = new javax.swing.JButton();
        supprimer_service = new javax.swing.JButton();
        Service = new javax.swing.JLabel();
        POSTE = new javax.swing.JPanel();
        pannelPoste = new javax.swing.JPanel();
        modifier_poste = new javax.swing.JButton();
        supprimer_poste = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_poste = new javax.swing.JTable();
        ajouter_poste = new javax.swing.JButton();
        Recherche_poste = new javax.swing.JTextField();
        poste = new javax.swing.JLabel();
        DEMANDE = new javax.swing.JPanel();
        pannelDemande = new javax.swing.JPanel();
        supprimer_demande = new javax.swing.JButton();
        deposer_demande = new javax.swing.JButton();
        Recherche_demande = new javax.swing.JTextField();
        modifier_demande = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        table_demanded = new javax.swing.JTable();
        NOTIFICATION = new javax.swing.JPanel();
        pannelNotification = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_notification = new javax.swing.JTable();
        Recherche_notification = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

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

        P5.setBackground(new java.awt.Color(0, 102, 102));
        P5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        P5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                P5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                P5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                P5MouseExited(evt);
            }
        });
        P5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        M5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        M5.setForeground(new java.awt.Color(255, 255, 255));
        M5.setText("NOTIFICATION");
        M5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        P5.add(M5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 130, 20));

        s5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        s5.setForeground(new java.awt.Color(0, 204, 204));
        s5.setText("|");
        P5.add(s5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 20));

        NAVIGATION.add(P5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 210, 40));

        P4.setBackground(new java.awt.Color(0, 102, 102));
        P4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        P4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                P4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                P4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                P4MouseExited(evt);
            }
        });
        P4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        M4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        M4.setForeground(new java.awt.Color(255, 255, 255));
        M4.setText("CONGE");
        M4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        P4.add(M4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 130, 20));

        s4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        s4.setForeground(new java.awt.Color(0, 204, 204));
        s4.setText("|");
        P4.add(s4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 20));

        NAVIGATION.add(P4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 210, 40));

        P3.setBackground(new java.awt.Color(0, 102, 102));
        P3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        P3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                P3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                P3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                P3MouseExited(evt);
            }
        });
        P3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        M3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        M3.setForeground(new java.awt.Color(255, 255, 255));
        M3.setText("POSTE");
        M3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        P3.add(M3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 130, 20));

        s3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        s3.setForeground(new java.awt.Color(0, 204, 204));
        s3.setText("|");
        P3.add(s3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 20));

        NAVIGATION.add(P3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 210, 40));

        P2.setBackground(new java.awt.Color(0, 102, 102));
        P2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        P2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                P2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                P2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                P2MouseExited(evt);
            }
        });
        P2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        M2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        M2.setForeground(new java.awt.Color(255, 255, 255));
        M2.setText("SERVICE");
        M2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        P2.add(M2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 90, 20));

        s2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        s2.setForeground(new java.awt.Color(0, 204, 204));
        s2.setText("|");
        P2.add(s2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 20));

        NAVIGATION.add(P2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 210, 40));

        P1.setBackground(new java.awt.Color(0, 102, 102));
        P1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        P1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                P1MouseMoved(evt);
            }
        });
        P1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                P1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                P1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                P1MouseExited(evt);
            }
        });
        P1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        M1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        M1.setForeground(new java.awt.Color(255, 255, 255));
        M1.setText("PERSONNEL");
        P1.add(M1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 110, 20));

        s1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        s1.setForeground(new java.awt.Color(0, 204, 204));
        s1.setText("|");
        P1.add(s1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 20));

        NAVIGATION.add(P1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 210, 40));

        pt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/poste.png"))); // NOI18N
        NAVIGATION.add(pt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        notif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/notif.png"))); // NOI18N
        NAVIGATION.add(notif, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        serv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/service.png"))); // NOI18N
        NAVIGATION.add(serv, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

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

        user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user.png"))); // NOI18N
        NAVIGATION.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        jPanel1.add(NAVIGATION, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 230, 590));

        PERSONNEL.setBackground(new java.awt.Color(0, 102, 102));
        PERSONNEL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPersonnel.setBackground(new java.awt.Color(255, 255, 255));
        panelPersonnel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelPersonnelMouseClicked(evt);
            }
        });
        panelPersonnel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Recherche_pers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Recherche_persMouseClicked(evt);
            }
        });
        Recherche_pers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Recherche_persActionPerformed(evt);
            }
        });
        panelPersonnel.add(Recherche_pers, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 220, 30));

        tablePersonnel.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePersonnel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePersonnelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePersonnel);

        panelPersonnel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 860, 370));

        supprimer_pers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/del.png"))); // NOI18N
        supprimer_pers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        supprimer_pers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimer_persActionPerformed(evt);
            }
        });
        panelPersonnel.add(supprimer_pers, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, 40, 40));

        modifier_pers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ModifierP.png"))); // NOI18N
        modifier_pers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modifier_pers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifier_persActionPerformed(evt);
            }
        });
        panelPersonnel.add(modifier_pers, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 490, 40, 40));

        ajouter_pers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/AjoutP.png"))); // NOI18N
        ajouter_pers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ajouter_pers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter_persActionPerformed(evt);
            }
        });
        panelPersonnel.add(ajouter_pers, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 490, 40, 40));

        imprimer_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pdf.png"))); // NOI18N
        imprimer_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        imprimer_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimer_btnActionPerformed(evt);
            }
        });
        panelPersonnel.add(imprimer_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 40, 40));

        PERSONNEL.add(panelPersonnel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 900, 560));

        Dash.addTab("bibi", PERSONNEL);

        SERVICE.setBackground(new java.awt.Color(0, 102, 102));
        SERVICE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pannelService.setBackground(new java.awt.Color(255, 255, 255));
        pannelService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pannelServiceMouseClicked(evt);
            }
        });
        pannelService.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_service.setModel(new javax.swing.table.DefaultTableModel(
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
        table_service.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_serviceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                table_serviceMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(table_service);

        pannelService.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 860, 370));

        Recherche_service.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Recherche_serviceMouseClicked(evt);
            }
        });
        Recherche_service.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Recherche_serviceActionPerformed(evt);
            }
        });
        pannelService.add(Recherche_service, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 220, 30));

        ajouter_service.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ajout.png"))); // NOI18N
        ajouter_service.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ajouter_service.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter_serviceActionPerformed(evt);
            }
        });
        pannelService.add(ajouter_service, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 490, 40, 40));

        modifier_service.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/modifier.png"))); // NOI18N
        modifier_service.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modifier_service.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifier_serviceActionPerformed(evt);
            }
        });
        pannelService.add(modifier_service, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 490, 40, 40));

        supprimer_service.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/del.png"))); // NOI18N
        supprimer_service.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        supprimer_service.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimer_serviceActionPerformed(evt);
            }
        });
        pannelService.add(supprimer_service, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, 40, 40));

        Service.setText("jLabel3");
        pannelService.add(Service, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, -1, -1));

        SERVICE.add(pannelService, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 900, 560));

        Dash.addTab("tab2", SERVICE);

        POSTE.setBackground(new java.awt.Color(0, 102, 102));
        POSTE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pannelPoste.setBackground(new java.awt.Color(255, 255, 255));
        pannelPoste.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pannelPosteMouseClicked(evt);
            }
        });
        pannelPoste.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        modifier_poste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/modifier.png"))); // NOI18N
        modifier_poste.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modifier_poste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifier_posteActionPerformed(evt);
            }
        });
        pannelPoste.add(modifier_poste, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 490, 40, 40));

        supprimer_poste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/del.png"))); // NOI18N
        supprimer_poste.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        supprimer_poste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimer_posteActionPerformed(evt);
            }
        });
        pannelPoste.add(supprimer_poste, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, 40, 40));

        table_poste.setModel(new javax.swing.table.DefaultTableModel(
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
        table_poste.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_posteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_poste);

        pannelPoste.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 860, 370));

        ajouter_poste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ajout.png"))); // NOI18N
        ajouter_poste.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ajouter_poste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter_posteActionPerformed(evt);
            }
        });
        pannelPoste.add(ajouter_poste, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 490, 40, 40));

        Recherche_poste.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Recherche_posteMouseClicked(evt);
            }
        });
        Recherche_poste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Recherche_posteActionPerformed(evt);
            }
        });
        pannelPoste.add(Recherche_poste, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 220, 30));

        poste.setText("jLabel3");
        pannelPoste.add(poste, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, -1, -1));

        POSTE.add(pannelPoste, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 900, 560));

        Dash.addTab("tab4", POSTE);

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
        pannelDemande.add(Recherche_demande, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 220, 30));

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
        jLabel3.setText("LISTE DES DEMANDES ENVOYÉS AU DIRECTEUR");
        pannelDemande.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 450, 30));

        table_demanded.setModel(new javax.swing.table.DefaultTableModel(
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
        table_demanded.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_demandedMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(table_demanded);

        pannelDemande.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 860, 330));

        DEMANDE.add(pannelDemande, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 900, 560));

        Dash.addTab("tab5", DEMANDE);

        NOTIFICATION.setBackground(new java.awt.Color(0, 102, 102));
        NOTIFICATION.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pannelNotification.setBackground(new java.awt.Color(255, 255, 255));
        pannelNotification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pannelNotificationMouseClicked(evt);
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

        pannelNotification.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 860, 370));

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
        pannelNotification.add(Recherche_notification, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 220, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("FABRICATION D'ORDRE DE ROUTE");
        pannelNotification.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 450, 30));

        NOTIFICATION.add(pannelNotification, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 900, 560));

        Dash.addTab("tab3", NOTIFICATION);

        jPanel1.add(Dash, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, -50, -1, 670));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Recherche_persActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Recherche_persActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Recherche_persActionPerformed

    private void P1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P1MouseMoved

    }//GEN-LAST:event_P1MouseMoved

    private void P1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P1MouseEntered
        P1.setBackground(new Color(0,204,204));

    }//GEN-LAST:event_P1MouseEntered

    private void P1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P1MouseExited
      P1.setBackground(new Color(0,102,102));
     
    }//GEN-LAST:event_P1MouseExited

    private void P1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P1MouseClicked
       Dash.setSelectedIndex(0);
        s1.setVisible(true);
       s2.setVisible(false);
       s3.setVisible(false);
       s4.setVisible(false);
       s5.setVisible(false);
       P1.setBackground(new Color(0,102,102));
       tablePersonnel.getTableHeader().setFont(new Font("Segoe UI",Font.PLAIN,15));
        Actualiser();
        pt.setVisible(false);
        serv.setVisible(false);
        notif.setVisible(false);
          dem.setVisible(false);
             user.setVisible(true);
    }//GEN-LAST:event_P1MouseClicked

    private void P2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P2MouseClicked
        Dash.setSelectedIndex(1); 
        s1.setVisible(false);
       s2.setVisible(true);
       s3.setVisible(false);
       s4.setVisible(false);
       s5.setVisible(false);
       P2.setBackground(new Color(0,102,102));
       table_service.getTableHeader().setFont(new Font("Segoe UI",Font.PLAIN,15));
       Actualiser1();
       pt.setVisible(false);
        serv.setVisible(true);
        notif.setVisible(false);
          dem.setVisible(false);
             user.setVisible(false);
    }//GEN-LAST:event_P2MouseClicked

    private void P3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P3MouseClicked
       Dash.setSelectedIndex(2);
       s1.setVisible(false);
       s2.setVisible(false);
       s3.setVisible(true);
       s4.setVisible(false);
       s5.setVisible(false);
       P3.setBackground(new Color(0,102,102));
       table_poste.getTableHeader().setFont(new Font("Segoe UI",Font.PLAIN,15));
       Actualiser2();
       pt.setVisible(true);
        serv.setVisible(false);
        notif.setVisible(false);
          dem.setVisible(false);
             user.setVisible(false);
    }//GEN-LAST:event_P3MouseClicked

    private void P4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P4MouseClicked
  Dash.setSelectedIndex(3);
        s1.setVisible(false);
       s2.setVisible(false);
       s3.setVisible(false);
       s4.setVisible(true);
       s5.setVisible(false);
       P4.setBackground(new Color(0,102,102));
        pt.setVisible(false);
        serv.setVisible(false);
        notif.setVisible(false);
        dem.setVisible(true);
           user.setVisible(false);
       table_demanded.getTableHeader().setFont(new Font("Segoe UI",Font.PLAIN,15));
        Actualiserd();
         
    }//GEN-LAST:event_P4MouseClicked

    private void P5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P5MouseClicked
        Dash.setSelectedIndex(4); 
       s1.setVisible(false);
       s2.setVisible(false);
       s3.setVisible(false);
       s4.setVisible(false);
       s5.setVisible(true);
       P5.setBackground(new Color(0,102,102));
       table_notification.getTableHeader().setFont(new Font("Segoe UI",Font.PLAIN,15));
       pt.setVisible(false);
       serv.setVisible(false);
       notif.setVisible(true);
       user.setVisible(false);
        dem.setVisible(false);
         
       Actualisern();
    }//GEN-LAST:event_P5MouseClicked

    private void P2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P2MouseEntered
         P2.setBackground(new Color(0,204,204));
    }//GEN-LAST:event_P2MouseEntered

    private void P2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P2MouseExited
         P2.setBackground(new Color(0,102,102));
     
    }//GEN-LAST:event_P2MouseExited

    private void P3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P3MouseEntered
         P3.setBackground(new Color(0,204,204)); 
    }//GEN-LAST:event_P3MouseEntered

    private void P3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P3MouseExited
           P3.setBackground(new Color(0,102,102));
    }//GEN-LAST:event_P3MouseExited

    private void P4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P4MouseEntered
        P4.setBackground(new Color(0,204,204)); 
    }//GEN-LAST:event_P4MouseEntered

    private void P4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P4MouseExited
        P4.setBackground(new Color(0,102,102));
    }//GEN-LAST:event_P4MouseExited

    private void P5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P5MouseEntered
       P5.setBackground(new Color(0,204,204)); 
    }//GEN-LAST:event_P5MouseEntered

    private void P5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P5MouseExited
         P5.setBackground(new Color(0,102,102));
    }//GEN-LAST:event_P5MouseExited

    private void fermerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fermerMouseEntered
       fermer.setBackground(red);
    }//GEN-LAST:event_fermerMouseEntered

    private void fermerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fermerMouseExited
        fermer.setBackground(white);
    }//GEN-LAST:event_fermerMouseExited

    private void fermerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fermerMouseClicked
        System.exit(0);
    }//GEN-LAST:event_fermerMouseClicked

    private void ajouter_persActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouter_persActionPerformed
        Ajout_personnel prs = new Ajout_personnel(this);
        prs.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_ajouter_persActionPerformed

    private void modifier_persActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifier_persActionPerformed
        Ajout_personnel prs = new Ajout_personnel(this);
        prs.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_modifier_persActionPerformed

    private void Recherche_persMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Recherche_persMouseClicked

    }//GEN-LAST:event_Recherche_persMouseClicked

    private void Recherche_serviceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Recherche_serviceMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Recherche_serviceMouseClicked

    private void Recherche_serviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Recherche_serviceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Recherche_serviceActionPerformed

    private void deconnecterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deconnecterMouseClicked
             if(JOptionPane.showConfirmDialog(this, "Êtes vous sûr de vouloir se deconnecter","Confirmation",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
                      Connexion conn = new Connexion();
                       this.dispose();
                      conn.setVisible(true);
                      
                    }else{
                        return;
                    }
    }//GEN-LAST:event_deconnecterMouseClicked

    private void supprimer_serviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimer_serviceActionPerformed
        delete1();
    }//GEN-LAST:event_supprimer_serviceActionPerformed

    private void modifier_serviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifier_serviceActionPerformed
        Ajout_Service serv = new Ajout_Service(this);
        serv.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_modifier_serviceActionPerformed

    private void ajouter_serviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouter_serviceActionPerformed
         Ajout_Service serv = new Ajout_Service(this);
        serv.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_ajouter_serviceActionPerformed

    private void Recherche_posteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Recherche_posteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Recherche_posteMouseClicked

    private void Recherche_posteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Recherche_posteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Recherche_posteActionPerformed

    private void supprimer_posteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimer_posteActionPerformed
        delete2();
    }//GEN-LAST:event_supprimer_posteActionPerformed

    private void table_posteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_posteMouseClicked
        modifier_poste.setEnabled(true);
        supprimer_poste.setVisible(true);
        ajouter_poste.setEnabled(false);
        int row= table_poste.getSelectedRow();
        this.teste211 =(table_poste.getModel().getValueAt(row, 1).toString());
        poste.setText(teste211);
    }//GEN-LAST:event_table_posteMouseClicked

    private void ajouter_posteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouter_posteActionPerformed
        Ajout_Poste ajout = new Ajout_Poste(this);
        ajout.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_ajouter_posteActionPerformed

    private void modifier_posteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifier_posteActionPerformed
        Ajout_Poste ajout = new Ajout_Poste(this);
        ajout.setVisible(true);
         this.setEnabled(false);
    }//GEN-LAST:event_modifier_posteActionPerformed

    private void Recherche_demandeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Recherche_demandeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Recherche_demandeMouseClicked

    private void Recherche_demandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Recherche_demandeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Recherche_demandeActionPerformed

    private void supprimer_demandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimer_demandeActionPerformed
         deleted();
    }//GEN-LAST:event_supprimer_demandeActionPerformed

    private void modifier_demandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifier_demandeActionPerformed
          Demander dem = new Demander(this);
        dem.setVisible(true);
         this.setEnabled(false);
    }//GEN-LAST:event_modifier_demandeActionPerformed

    private void deposer_demandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deposer_demandeActionPerformed
        Demander dem = new Demander(this);
        dem.setVisible(true);
         this.setEnabled(false);
    }//GEN-LAST:event_deposer_demandeActionPerformed

    private void tablePersonnelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePersonnelMouseClicked
        modifier_pers.setEnabled(true);
        supprimer_pers.setVisible(true);
        ajouter_pers.setEnabled(false);
    }//GEN-LAST:event_tablePersonnelMouseClicked

    private void table_serviceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_serviceMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_table_serviceMouseEntered

    private void table_serviceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_serviceMouseClicked
        modifier_service.setEnabled(true);
        supprimer_service.setVisible(true);
        ajouter_service.setEnabled(false);
        int row= table_service.getSelectedRow();
        this.teste21 =(table_service.getModel().getValueAt(row, 1).toString());
        Service.setText(teste21);
    }//GEN-LAST:event_table_serviceMouseClicked

    private void table_demandedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_demandedMouseClicked
          modifier_demande.setEnabled(true);
          supprimer_demande.setVisible(true);
          deposer_demande.setEnabled(false);
    }//GEN-LAST:event_table_demandedMouseClicked

    private void table_notificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_notificationMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_table_notificationMouseClicked

    private void Recherche_notificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Recherche_notificationMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Recherche_notificationMouseClicked

    private void Recherche_notificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Recherche_notificationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Recherche_notificationActionPerformed

    private void supprimer_persActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimer_persActionPerformed
        delete();
    }//GEN-LAST:event_supprimer_persActionPerformed

    private void imprimer_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimer_btnActionPerformed

    }//GEN-LAST:event_imprimer_btnActionPerformed

    private void panelPersonnelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelPersonnelMouseClicked
        Actualiser();
    }//GEN-LAST:event_panelPersonnelMouseClicked

    private void pannelServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pannelServiceMouseClicked
                Actualiser1();
    }//GEN-LAST:event_pannelServiceMouseClicked

    private void pannelPosteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pannelPosteMouseClicked
                    Actualiser2();
    }//GEN-LAST:event_pannelPosteMouseClicked

    private void pannelDemandeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pannelDemandeMouseClicked
                Actualiserd();
    }//GEN-LAST:event_pannelDemandeMouseClicked

    private void pannelNotificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pannelNotificationMouseClicked
        Actualisern();
    }//GEN-LAST:event_pannelNotificationMouseClicked

     /********************* P E R S O N N E L ******************************/ 
    
    public void deplace(){
            int row= tablePersonnel.getSelectedRow();
            this.teste =(tablePersonnel.getModel().getValueAt(row, 0).toString());
            
    }
    
    public String ahona(){
        return teste;
    }
 
    public void delete(){
        deplace();
        String del = ahona();
        
        
        
        String sql = "Delete from personnel where Matricule = '"+del+"'";
        String sql1 = "Delete from autorisation where Matricule = '"+del+"'";
        
        try{    
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:"+db);
            st=con.createStatement();
            sr=st.executeQuery("Select Matricule from autorisation where Matricule = '"+ del+"'");
            
            if(sr.next()){
                    if(JOptionPane.showConfirmDialog(this, "Confirmer la suppression","Confirmation",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
                        st.executeUpdate(sql);
                        st.executeUpdate(sql1);
                        JOptionPane.showMessageDialog(null, "Supression réussie");
                        Actualiser();
                    }else{
                        return;
                    }
                
            }else{
                  if(JOptionPane.showConfirmDialog(this, "Confirmer la suppression","Confirmation",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
                        st.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null, "Supression réussie");
                        Actualiser();
                    }else{
                      return;
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
    
    
    
     public void Actualiser(){
          model.setRowCount(0);
        try{
          Class.forName("org.sqlite.JDBC");
          con = DriverManager.getConnection("jdbc:sqlite:"+db);
          st = con.createStatement();
          rs = st.executeQuery("Select * from personnel order by Matricule ASC");
          
          while (rs.next()){
              model.addRow(new Object[] {rs.getString("Matricule"),rs.getString("Nom_Pers"),rs.getString("Prenom_Pers"),rs.getString("Corps_As"),rs.getString("Grade"),rs.getString("Service"),rs.getString("Poste"),rs.getString("Date_Emb"),rs.getString("Date_Eff")});
          
          }
          modifier_pers.setEnabled(false);
          supprimer_pers.setVisible(false);
          ajouter_pers.setEnabled(true);
          Recherche_pers.setText("");
          
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
       
       tablePersonnel.setModel(model);                                    
    }
     
     
     
public void recherche(){       
    
    TableRowSorter<TableModel>  sorter = new TableRowSorter<>(model);
       tablePersonnel.setRowSorter(sorter);
 
    
       Recherche_pers.getDocument().addDocumentListener(new DocumentListener(){
           
           @Override
           public void insertUpdate(DocumentEvent e){
               search(Recherche_pers.getText(), sorter);
           }
             @Override
           public void removeUpdate(DocumentEvent e){
                search(Recherche_pers.getText(), sorter);
           }

           @Override
           public void changedUpdate(DocumentEvent e) {
                search(Recherche_pers.getText(), sorter);
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


        private void liste(){
           model.addColumn("Matricule");
           model.addColumn("Nom");
           model.addColumn("Prenom");
           model.addColumn("Corps assimilé");
            model.addColumn("Grade");
           model.addColumn("Service");
           model.addColumn("Poste");
           model.addColumn("Date Emb");
            model.addColumn("Date Eff");
           Actualiser();
            TableColumn clm = tablePersonnel.getColumnModel().getColumn(0);
            clm.setMaxWidth(98);
            TableColumn clm3 = tablePersonnel.getColumnModel().getColumn(1);
           clm3.setMinWidth(98);
           TableColumn clm1 = tablePersonnel.getColumnModel().getColumn(3);
           clm1.setMinWidth(100);
             TableColumn clm2 = tablePersonnel.getColumnModel().getColumn(6);
           clm2.setMinWidth(130);
          
       
   }

     

/*******************************************************************************/
        
        
        
        
        
     /********************* D  E  M  A  N  D  E ******************************/ 
        
    private void listed(){
        modeld.addColumn("");
        modeld.addColumn("Matricule");
        modeld.addColumn("Déstinataire");
        modeld.addColumn("Type");
        modeld.addColumn("Durée");
        modeld.addColumn("Motif");
        modeld.addColumn("Statut");
        modeld.addColumn("En jouir de l'année");
        modeld.addColumn("Date validation");
           Actualiserd();
           TableColumn clmd = table_demanded.getColumnModel().getColumn(0);
        TableColumn clmd1 = table_demanded.getColumnModel().getColumn(1);
        TableColumn clmd2 = table_demanded.getColumnModel().getColumn(2);
        TableColumn clmd3 = table_demanded.getColumnModel().getColumn(3);
        TableColumn clmd4 = table_demanded.getColumnModel().getColumn(4);
        
           
           clmd.setMinWidth(0);
           clmd.setMaxWidth(0);
           clmd1.setMaxWidth(80);
           clmd2.setMinWidth(70);
           clmd3.setMinWidth(120);
           clmd4.setMaxWidth(60);
   }
    
    public void deplaced(){
            int row= table_demanded.getSelectedRow();
            this.tested =(table_demanded.getModel().getValueAt(row, 0).toString());
            
    }
    
    public String ahonad(){
        return tested;
    }
 
    public void deleted(){
        deplaced();
        String del = ahonad();
        
        
        
        String sql = "Delete from autorisation where ID_Autorisation = '"+del+"'";
        String sql1 = "Select Type,Duree,Matricule from autorisation where ID_Autorisation = '"+del+"'";
      
        
        try{    
               Class.forName("org.sqlite.JDBC");
               con = DriverManager.getConnection("jdbc:sqlite:"+db);
               st=con.createStatement();
               stx = con.createStatement();
               rs = st.executeQuery(sql1);
               rs.next();
               String tt = rs.getString("Type");

             try{ 

                     if(JOptionPane.showConfirmDialog(this, "Confirmer la suppression","Confirmation",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
                         st.executeUpdate(sql);
                       
                        Actualiserd();
                        JOptionPane.showMessageDialog(null, "Supression réussie");
                     
               }else{
                    return;
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
    
    
    
     public void Actualiserd(){
          modeld.setRowCount(0);
        try{
             Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:"+db);
          st = con.createStatement();
          rs = st.executeQuery("Select * from autorisation order by Jouir_annee ASC");
          
          while (rs.next()){
              modeld.addRow(new Object[] {rs.getString("ID_Autorisation"),rs.getString("Matricule"),rs.getString("ID_Directeur"),rs.getString("Type"),rs.getString("Duree"),rs.getString("Motif"),rs.getString("Statut"),rs.getString("Jouir_annee"),rs.getString("Date_vld")});
          
          }
          modifier_demande.setEnabled(false);
          supprimer_demande.setVisible(false);
          deposer_demande.setEnabled(true);
          Recherche_demande.setText("");
          
      }catch(SQLException | ClassNotFoundException e){
                                          System.err.println(e);
      }finally{
            if(rs!=null){
                try{
                    rs.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(st!=null){
                try{
                    st.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(con != null){
                try{
                    con.close();
                }catch(SQLException e){
                     System.err.println("Fermer la base de donné1");
                }
            }
    }
       
       table_demanded.setModel(modeld);                                    
    }
     
  
     
public void recherched(){       
    
    TableRowSorter <TableModel> sorter = new TableRowSorter<>(modeld);
    table_demanded.setRowSorter(sorter);
 
    
       Recherche_demande.getDocument().addDocumentListener(new DocumentListener(){
           
           @Override
           public void insertUpdate(DocumentEvent e){
               searchd(Recherche_demande.getText(), sorter);
           }
            @Override
           public void removeUpdate(DocumentEvent e){
                searchd(Recherche_demande.getText(), sorter);
           }

           @Override
           public void changedUpdate(DocumentEvent e) {
                searchd(Recherche_demande.getText(), sorter);
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
/*******************************************************************************/
         
         
/****************************  N O T I F I C A T I O N ***************************/
        
    private void listen(){
           modeln.addColumn("");
           modeln.addColumn("Matricule");
           modeln.addColumn("Lieu");
           modeln.addColumn("Objet de la mission");
            modeln.addColumn("Durée");
            modeln.addColumn("A partir");
                        modeln.addColumn("Envoyeur");
            
           Actualisern();
           TableColumn clmn = table_notification.getColumnModel().getColumn(0);
           clmn.setMinWidth(0);
           clmn.setMaxWidth(0);   
   }
    
    public void deplacen(){
            int row= table_notification.getSelectedRow();
            this.testen =(table_notification.getModel().getValueAt(row, 0).toString());
            
    }
    
    public String ahonan(){
        return testen;
    }
 
    
    
    
    
     public void Actualisern(){
          modeln.setRowCount(0);
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:"+db);
          st = con.createStatement();
          rs = st.executeQuery("Select * from ordre_de_route");
          
          while (rs.next()){
              modeln.addRow(new Object[] {rs.getString("ID_ordre"),rs.getString("Matricule"),rs.getString("Lieu"),rs.getString("Objet_Mission"),rs.getString("Duree"),rs.getString("Date_Ordre"),rs.getString("ID_Directeur")});
          
          }
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
       
       table_notification.setModel(modeln);                                    
    }
     
  
     
public void recherchen(){       
    
    TableRowSorter <TableModel> sorter = new TableRowSorter<>(modeln);
    table_notification.setRowSorter(sorter);
 
    
       Recherche_notification.getDocument().addDocumentListener(new DocumentListener(){
           
           @Override
           public void insertUpdate(DocumentEvent e){
               searchn(Recherche_notification.getText(), sorter);
           }
            @Override
           public void removeUpdate(DocumentEvent e){
                searchn(Recherche_notification.getText(), sorter);
           }

           @Override
           public void changedUpdate(DocumentEvent e) {
                searchn(Recherche_notification.getText(), sorter);
           }
       });
  
}


private static void searchn(String text, TableRowSorter<TableModel> sorter){
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
         
         
         
         
         
         
         
/************************** P O S T E *************************************/
        private void liste2(){
            model2.addColumn("");
            model2.addColumn("Poste");
            model2.addColumn("Activité pincipale");  
            model2.addColumn("Activité secondaire");  
            Actualiser2();
            TableColumn clm1 = table_poste.getColumnModel().getColumn(0);
          /*  TableColumn clmd = table_poste.getColumnModel().getColumn(2);
            clmd.setMinWidth(400);*/
           clm1.setMinWidth(0);
           clm1.setMaxWidth(0);
            
       
   }
           
 public void Actualiser2(){
          model2.setRowCount(0);
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:"+db);
          st = con.createStatement();
          rs = st.executeQuery("Select * from poste");
          
          while (rs.next()){
              model2.addRow(new Object[] {rs.getString("ID_Poste"),rs.getString("Poste"),rs.getString("Activite_prin"),rs.getString("Activite_second")});
          
          }
          modifier_poste.setEnabled(false);
          supprimer_poste.setVisible(false);
          ajouter_poste.setEnabled(true);    
          Recherche_poste.setText("");
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
       
       table_poste.setModel(model2);                                    
    }  
           
           
         

    public void deplace2(){
            int row= table_poste.getSelectedRow();
            this.teste2 =(table_poste.getModel().getValueAt(row, 0).toString());
            
    }
    
    public String ahona2(){
        return teste2;
    }  
         
    
         
   
    public void delete2(){
        deplace2();
        String del = ahona2();
        String a = "Poste supprimée";
        String b = poste.getText();
        
        
        String sql = "Delete from poste where ID_Poste = '"+del+"'";
        String sql1 = "Update personnel set Poste = '"+a+"' where Poste = '"+b+"'";
        
        try{    
               Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:"+db);
            st=con.createStatement();
     
                  if(JOptionPane.showConfirmDialog(this, "Confirmer la suppression","Confirmation",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
                        st.executeUpdate(sql);
                        st.executeUpdate(sql1);
                        JOptionPane.showMessageDialog(null, "Supression réussie");
                        Actualiser2();
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
         
    
   public void recherche2(){       
    
    TableRowSorter <TableModel> sorter = new TableRowSorter<>(model2);
    table_poste.setRowSorter(sorter);
 
    
       Recherche_poste.getDocument().addDocumentListener(new DocumentListener(){
           
           @Override
           public void insertUpdate(DocumentEvent e){
               search2(Recherche_poste.getText(), sorter);
           }
            @Override
           public void removeUpdate(DocumentEvent e){
                search2(Recherche_poste.getText(), sorter);
           }

           @Override
           public void changedUpdate(DocumentEvent e) {
                search2(Recherche_poste.getText(), sorter);
           }
       });
  
}


private static void search2(String text, TableRowSorter<TableModel> sorter){
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
 




/************************** S E R V I C E *************************************/
        private void liste1(){
            model1.addColumn("");
            model1.addColumn("Service");
            model1.addColumn("Chef de Service");
            model1.addColumn("Desciption du service");     
            Actualiser1();
             TableColumn clm = table_service.getColumnModel().getColumn(0);
           clm.setMinWidth(0);
           clm.setMaxWidth(0);
            
       
   }
           
 public void Actualiser1(){
          model1.setRowCount(0);
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:"+db);
          st = con.createStatement();
          rs = st.executeQuery("Select * from service");
          
          while (rs.next()){
              model1.addRow(new Object[] {rs.getString("ID_Service"),rs.getString("Service"),rs.getString("Chef_Service"),rs.getString("Description_Serv")});
          
          }
          modifier_service.setEnabled(false);
          supprimer_service.setVisible(false);
          ajouter_service.setEnabled(true);
          Recherche_service.setText("");
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
       
       table_service.setModel(model1);                                    
    }  
           
           
         

    public void deplace1(){
            int row= table_service.getSelectedRow();
            this.teste1 =(table_service.getModel().getValueAt(row, 0).toString());
            
    }
    
    public String ahona1(){
        return teste1;
    }  
         
   
    public void delete1(){
        deplace1();
        String del = ahona1();
        String service = Service.getText();
        String a = "Service supprimée";
        
        
        
        String sql = "Delete from service where ID_Service = '"+del+"'";
        String sql1 = "Update personnel set Service ='"+a+"' where Service = '"+service+"'";

        
        try{    
                Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:"+db);
            st=con.createStatement();
     
                  if(JOptionPane.showConfirmDialog(this, "Confirmer la suppression","Confirmation",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
                        st.executeUpdate(sql);
                        st.executeUpdate(sql1);
                        JOptionPane.showMessageDialog(null, "Supression réussie");
                        Actualiser1();
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
         
    
   public void recherche1(){       
    
    TableRowSorter <TableModel> sorter = new TableRowSorter<>(model1);
    table_service.setRowSorter(sorter);
 
    
       Recherche_service.getDocument().addDocumentListener(new DocumentListener(){
           
           @Override
           public void insertUpdate(DocumentEvent e){
               search1(Recherche_service.getText(), sorter);
           }
            @Override
           public void removeUpdate(DocumentEvent e){
                search1(Recherche_service.getText(), sorter);
           }

           @Override
           public void changedUpdate(DocumentEvent e) {
                search1(Recherche_service.getText(), sorter);
           }
       });
  
}


private static void search1(String text, TableRowSorter<TableModel> sorter){
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
/******************************************************************************/
     
public static void impression(JTable table){
         
        MessageFormat header = new MessageFormat("Liste des personnels");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try{
            tablePersonnel.print(JTable.PrintMode.FIT_WIDTH,header,footer);
             
             
         }catch(java.awt.print.PrinterException e){
             e.printStackTrace();
         }
     }




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
            java.util.logging.Logger.getLogger(Utilisateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Utilisateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Utilisateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Utilisateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Utilisateur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DEMANDE;
    private javax.swing.JTabbedPane Dash;
    private javax.swing.JLabel M1;
    private javax.swing.JLabel M2;
    private javax.swing.JLabel M3;
    private javax.swing.JLabel M4;
    private javax.swing.JLabel M5;
    private javax.swing.JPanel NAVIGATION;
    private javax.swing.JPanel NOTIFICATION;
    private javax.swing.JPanel P1;
    private javax.swing.JPanel P2;
    private javax.swing.JPanel P3;
    private javax.swing.JPanel P4;
    private javax.swing.JPanel P5;
    private javax.swing.JPanel PERSONNEL;
    private javax.swing.JPanel POSTE;
    public javax.swing.JTextField Recherche_demande;
    private javax.swing.JTextField Recherche_notification;
    private javax.swing.JTextField Recherche_pers;
    public javax.swing.JTextField Recherche_poste;
    private javax.swing.JTextField Recherche_service;
    private javax.swing.JPanel SERVICE;
    public javax.swing.JLabel Service;
    public javax.swing.JButton ajouter_pers;
    public javax.swing.JButton ajouter_poste;
    public javax.swing.JButton ajouter_service;
    private javax.swing.JLabel deconnecter;
    private javax.swing.JLabel dem;
    public javax.swing.JButton deposer_demande;
    private javax.swing.JPanel fermer;
    private javax.swing.JButton imprimer_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    public javax.swing.JButton modifier_demande;
    public javax.swing.JButton modifier_pers;
    public javax.swing.JButton modifier_poste;
    public javax.swing.JButton modifier_service;
    private javax.swing.JLabel notif;
    private javax.swing.JPanel panelPersonnel;
    private javax.swing.JPanel pannelDemande;
    private javax.swing.JPanel pannelNotification;
    private javax.swing.JPanel pannelPoste;
    private javax.swing.JPanel pannelService;
    public javax.swing.JLabel poste;
    private javax.swing.JLabel pt;
    private javax.swing.JLabel s1;
    private javax.swing.JLabel s2;
    private javax.swing.JLabel s3;
    private javax.swing.JLabel s4;
    private javax.swing.JLabel s5;
    private javax.swing.JLabel serv;
    public javax.swing.JButton supprimer_demande;
    public javax.swing.JButton supprimer_pers;
    public javax.swing.JButton supprimer_poste;
    public javax.swing.JButton supprimer_service;
    public static javax.swing.JTable tablePersonnel;
    public javax.swing.JTable table_demanded;
    public javax.swing.JTable table_notification;
    public javax.swing.JTable table_poste;
    public javax.swing.JTable table_service;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
