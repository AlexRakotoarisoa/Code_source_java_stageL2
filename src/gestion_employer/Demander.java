
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
import javax.swing.text.AbstractDocument;

/**
 *
 * @author ALEX RAKOTOARISOA
 */
public class Demander extends javax.swing.JFrame {

     Connection con = null;
     Connection conx = null;
    Statement st = null;
    Statement stx = null;
    ResultSet rs = null;
    ResultSet rsx = null;
    ResultSet rs1 = null;
    ResultSet rs2 = null;
    ResultSet rsu = null;
    PreparedStatement prepare = null;
    Utilisateur util;
  
    
    
    
    
    public Demander( Utilisateur util) {
        initComponents();
        this.util = util ;
        
        valeurRecu();
       // changement();

    }

String db = "gestion.db";


public void valeurRecu(){
    try{
            
            int row = util.table_demanded.getSelectedRow();
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:"+db);
            st=con.createStatement();
            
            //initialiser la Matricule
            LinkedList<String> liste1 = new LinkedList<>();
              rs = st.executeQuery("Select Matricule from personnel");                              
                                 while(rs.next()){
                                     String pr = rs.getString("Matricule");
                                     liste1.add(pr);
                                 }
             DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(liste1.toArray(new String[0]));
             txt_Matricule.setModel(model);
             
          
                
       
             
        if (row == -1){             
                 //changement();
                                txt_Duree.setText(""); 
                                txt_Type.setSelectedItem("");
                                txt_Motif.setText("");
                                btn_modifier.setEnabled(false);
                                txt_Jouir.setEnabled(false);
                                lbl_Jouir.setEnabled(false);
                               
        }else{
                        util.deplaced();
                        String d = util.ahonad();
                        
                try{
                         SimpleDateFormat sp = new SimpleDateFormat("yyyy");
                        String sql2 = "Select * from autorisation where ID_Autorisation = '"+d+"'";
                            rs1 = st.executeQuery(sql2);
                            rs1.next();
                            
                            String Matricule = rs1.getString("Matricule");
                          
                            String motif = rs1.getString("Motif");
                            
                            String Dure = rs1.getString("Duree");
                            
                            String type = rs1.getString("Type");
                            String jouir = rs1.getString("Jouir_annee");
                            
                            if(rs1.getString("Jouir_annee") == null || rs1.getString("Jouir_annee").equals("") ){
                                   txt_Matricule.setSelectedItem(Matricule);
                                   Matr();
                                   txt_Motif.setText(motif);
                                   txt_Duree.setText(Dure);
                                   txt_Type.setSelectedItem(type); 
                                   txt_Jouir.setEnabled(false);
                                   
                            }else{
                                   Date ee = sp.parse(jouir);
                                   txt_Matricule.setSelectedItem(Matricule);
                                   Matr();
                                   txt_Motif.setText(motif);
                                   txt_Duree.setText(Dure);
                                   txt_Type.setSelectedItem(type); 
                                   txt_Jouir.setDate(ee);
                            }
                            btn_ajouter.setEnabled(false);
            
                 
                     
                }catch(Exception e){
                                System.err.println(e);
                             }finally{
                   if(rs1 != null){
                        try{
                            rs1.close();
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


    
public void demande(){
    DefaultComboBoxModel <String> cmb = new DefaultComboBoxModel<>();
    
    cmb.addElement("Permission absence");
    cmb.addElement("Congé");
    cmb.addElement("Congé de paternité");
    cmb.addElement("Congé maladie");
    cmb.addElement("Congé spécial");
    cmb.addElement("Congé de formation");
    txt_Type.setModel(cmb);
}

public void demandef(){
    DefaultComboBoxModel <String> cmb = new DefaultComboBoxModel<>();
    
    cmb.addElement("Permission absence");
    cmb.addElement("Congé");  
    cmb.addElement("Congé de maternité");
    cmb.addElement("Congé maladie");
    cmb.addElement("Congé spécial");
    cmb.addElement("Congé de formation");
    txt_Type.setModel(cmb);
}

      








     
     public void ajouter(){
            String matricule = txt_Matricule.getSelectedItem().toString();  
            String dur =  txt_Duree.getText(); 
            String motif = txt_Motif.getText();
            String statut = "En attente";
            String Dir = "Directeur";
            Calendar cal = Calendar.getInstance();
            Date today = cal.getTime();
            String type = txt_Type.getSelectedItem().toString();
           
       String sql = "insert into autorisation (Matricule,Duree,Type,Statut,Motif,ID_Directeur,Date_dpt,Jouir_annee) values (?,?,?,?,?,?,?,?)";
        String sq0 = "insert into autorisation (Matricule,Duree,Type,Statut,Motif,ID_Directeur,Date_dpt) values (?,?,?,?,?,?,?)";
       
        
         if (matricule.isEmpty() || dur.isEmpty() || txt_Type.getSelectedItem() == null || motif.isEmpty() ||statut.isEmpty()||Dir.isEmpty()){
             JOptionPane.showMessageDialog(null, " Veuillez completer tout les champs vide ");
         }else{//1
             
             /************* SI CONGE *****************/
             if(txt_Type.getSelectedItem().toString().equals("Congé")){
                    Date joui = txt_Jouir.getDate();
                     if (joui == null){
                        JOptionPane.showMessageDialog(null, " Veuillez completer tout les champs vide ");
                     }else{
                          
                        
                        
                           try{
                                    SimpleDateFormat sp = new SimpleDateFormat("yyyy/MM/dd");
                                    SimpleDateFormat month = new SimpleDateFormat("MMMM");
                                    SimpleDateFormat year = new SimpleDateFormat("YYYY");
                                    String date = sp.format(today);
                                    String jouir = year.format(joui);
                                    int jj = Integer.parseInt(jouir);
                                    int jou = jj+1;
                                    String t = "Congé";
                                    String sq = "Select sum(Duree) as nb from autorisation where  Matricule = '"+matricule+"' and Jouir_annee =  '"+jou+"' ";
                                     String bla = "Select * from autorisation where Type='"+t+"' and Jouir_annee = '"+jou+"' and Matricule = '"+matricule+"' ";
                                    Class.forName("org.sqlite.JDBC");
                                    con = DriverManager.getConnection("jdbc:sqlite:"+db);
                                    st = con.createStatement();
                                    rs = st.executeQuery(bla);
                                              
                                               if(rs.next()){ // Ra misy anle année selectionner ny ao
                                                    rs = st.executeQuery(sq);
                                                    rs.next();
                                                   String nombre = rs.getString("nb");
                                                   int nb1 = Integer.parseInt(nombre);
                                                   int dur1 = Integer.parseInt(dur);
                                                   int nb2 = nb1 + dur1 ;
                                                   int nb3 = 30-nb1;
                                                        if(nb2>30){
                                                           JOptionPane.showMessageDialog(null, "Cet personne n'a plus que "+nb3+" jours de congé disponible l'année "+jou+"");
                                                       }else{
                                                           prepare = con.prepareStatement(sql);
                                                           prepare.setString(1, matricule);
                                                           prepare.setString(2, dur);
                                                           prepare.setString(3, txt_Type.getSelectedItem().toString());
                                                           prepare.setString(4, statut);
                                                           prepare.setString(5, motif);
                                                           prepare.setString(6, Dir);
                                                           prepare.setString(7, date);
                                                            prepare.setInt(8, jou);
                                                           prepare.executeUpdate();  
                                                           JOptionPane.showMessageDialog(null, "La demande de '"+txt_Type.getSelectedItem().toString()+"' à été envoyer avec succès");
                                                           util.Actualiserd();
                                                           util.setEnabled(true);
                                                           this.dispose();
                                                       }
                                              
                                                }else{
                                                     int dur1 = Integer.parseInt(dur);
                                                     
                                                     if(dur1>30){
                                                           JOptionPane.showMessageDialog(null, "Un personnel n'a droit qu'à 30 jours de congé par année");
                                                       }else{
                                                           prepare = con.prepareStatement(sql);
                                                           prepare.setString(1, matricule);
                                                           prepare.setString(2, dur);
                                                           prepare.setString(3, txt_Type.getSelectedItem().toString());
                                                           prepare.setString(4, statut);
                                                           prepare.setString(5, motif);
                                                           prepare.setString(6, Dir);
                                                           prepare.setString(7, date);
                                                           prepare.setInt(8, jou);
                                                           prepare.executeUpdate();  
                                                           JOptionPane.showMessageDialog(null, "La demande de '"+txt_Type.getSelectedItem().toString()+"' à été envoyer avec succès");
                                                           util.Actualiserd();
                                                           util.setEnabled(true);
                                                           this.dispose();
                                                   
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
                     
             }else if (type.equals("Congé de maternité") || type.equals("Congé de paternité")){ ////////////////////////
                             try{
                                  SimpleDateFormat sp = new SimpleDateFormat("yyyy/MM/dd");
                                SimpleDateFormat month = new SimpleDateFormat("MMMM");
                                SimpleDateFormat year = new SimpleDateFormat("YYYY");
                                Class.forName("org.sqlite.JDBC");
                                con = DriverManager.getConnection("jdbc:sqlite:"+db);
                                st = con.createStatement();
                                String date = sp.format(today);
                                rs = st.executeQuery("Select Date_dpt from autorisation where Matricule = '"+matricule+"' and Type = '"+type+"'");                
                                boolean bol = true;
                                
                                
                                while(rs.next() & bol){
                                String mo = rs.getString("Date_dpt");
                                Date dd = sp.parse(mo);
                                String annee = year.format(dd);
                                String ye = year.format(today);

                                    if(annee.equals(ye)){    
                                        JOptionPane.showMessageDialog(null,"Cet Personne à déja reçu un "+type+" cet année");
                                        bol = false;
                                        return;
                                    }

                                }

                                    prepare = con.prepareStatement(sq0);
                                    prepare.setString(1, matricule);
                                    prepare.setString(2, dur);
                                    prepare.setString(3, txt_Type.getSelectedItem().toString());
                                    prepare.setString(4, statut);
                                    prepare.setString(5, motif);
                                    prepare.setString(6, Dir);
                                    prepare.setString(7, date);
                                    prepare.executeUpdate();  
                                    JOptionPane.showMessageDialog(null, "La demande de '"+txt_Type.getSelectedItem().toString()+"' à été envoyer avec succès");
                                    util.Actualiserd();
                                    util.setEnabled(true);
                                    this.dispose();


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
             } else if(type.equals("Permission absence")){
                
                 
                 try{
                        SimpleDateFormat sp = new SimpleDateFormat("yyyy/MM/dd");
                        SimpleDateFormat year = new SimpleDateFormat("YYYY");
                        String date = sp.format(today);
                        String dd = year.format(today);
                        String t = "Permission absence";
                        String SQL = "Select * from autorisation where Type='"+t+"' and Matricule = '"+matricule+"' and substr(Date_dpt,1,4) ='"+dd+"'  ";
                        con = DriverManager.getConnection("jdbc:sqlite:"+db);
                        st = con.createStatement();
                        rs = st.executeQuery(SQL);
                        if(rs.next()){
                          String SQL1 =  "Select sum(Duree) as nb from autorisation where  Matricule = '"+matricule+"' and substr(Date_dpt,1,4) ='"+dd+"' and Type='"+t+"' ";
                          rs = st.executeQuery(SQL1);
                          rs.next();
                          String val = rs.getString("nb");
                          int val1 = Integer.parseInt(val);
                          int dur1 = Integer.parseInt(dur);
                          int val2 = val1 + dur1;
                          int val3 = 10-val1;
                                    if(val2>10){
                                        JOptionPane.showMessageDialog(null, "Ce personnel n'a plus que "+val3+" jours de permission d'absence disponible cet année");
                                        return;
                                    }
                                    if(dur1 > 3){
                                         JOptionPane.showMessageDialog(null, "La demande de "+txt_Type.getSelectedItem().toString()+" ne doit pas dépasser 3 jours");
                                        return;
                                    }

                                              prepare = con.prepareStatement(sq0);
                                              prepare.setString(1, matricule);
                                              prepare.setString(2, dur);
                                              prepare.setString(3, txt_Type.getSelectedItem().toString());
                                              prepare.setString(4, statut);
                                              prepare.setString(5, motif);
                                              prepare.setString(6, Dir);
                                              prepare.setString(7, date);
                                              prepare.executeUpdate();  
                                              JOptionPane.showMessageDialog(null, "La demande de '"+txt_Type.getSelectedItem().toString()+"' à été envoyer avec succès");
                                              util.Actualiserd();
                                              util.setEnabled(true);
                                              this.dispose();

                          
                        }else{
                              int dur1 = Integer.parseInt(dur);
                              if(dur1 > 3){
                                         JOptionPane.showMessageDialog(null, "La demande de "+txt_Type.getSelectedItem().toString()+" ne doit pas dépasser 3 jours");
                                        return;
                                    }

                                              prepare = con.prepareStatement(sq0);
                                              prepare.setString(1, matricule);
                                              prepare.setString(2, dur);
                                              prepare.setString(3, txt_Type.getSelectedItem().toString());
                                              prepare.setString(4, statut);
                                              prepare.setString(5, motif);
                                              prepare.setString(6, Dir);
                                              prepare.setString(7, date);
                                              prepare.executeUpdate();  
                                              JOptionPane.showMessageDialog(null, "La demande de '"+txt_Type.getSelectedItem().toString()+"' à été envoyer avec succès");
                                              util.Actualiserd();
                                              util.setEnabled(true);
                                              this.dispose();
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
                 
             
             
             }else {

                    try{
                       SimpleDateFormat sp = new SimpleDateFormat("yyyy/MM/dd");
                       Class.forName("org.sqlite.JDBC");
                       con = DriverManager.getConnection("jdbc:sqlite:"+db);
                       st = con.createStatement();
                       String date = sp.format(today);
                             prepare = con.prepareStatement(sq0);
                               prepare.setString(1, matricule);
                               prepare.setString(2, dur);
                               prepare.setString(3, txt_Type.getSelectedItem().toString());
                               prepare.setString(4, statut);
                               prepare.setString(5, motif);
                               prepare.setString(6, Dir);
                               prepare.setString(7, date);
                               prepare.executeUpdate();  
                               JOptionPane.showMessageDialog(null, "La demande de "+txt_Type.getSelectedItem().toString()+" à été envoyer avec succès");
                               util.Actualiserd();
                               util.setEnabled(true);
                               this.dispose();

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
            }
     }
      
     
     // B O U T O N ///
 
     
     
     
     
     public void modifier(){

            String matricule = txt_Matricule.getSelectedItem().toString();  
            String dur =  txt_Duree.getText(); 
            String motif = txt_Motif.getText();
            String sql1 = "Select Nom_Pers,Prenom_Pers from personnel where Matricule = '"+matricule+"'";
            Date joui = txt_Jouir.getDate();
            Calendar cal = Calendar.getInstance();
            Date today = cal.getTime();
     try{
        
        util.deplaced();
        String d = util.ahonad();
        SimpleDateFormat sp = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat month = new SimpleDateFormat("MMMM");
        SimpleDateFormat year = new SimpleDateFormat("YYYY");

        String sql = "Select * from autorisation where ID_Autorisation = '"+d+"'";
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:"+db);
        st = con.createStatement();
        rs = st.executeQuery(sql);
        rs.next();
        String ty = rs.getString("Type");
        
            if (matricule.isEmpty() || dur.isEmpty() || txt_Type.getSelectedItem() == null || motif.isEmpty()){
                               JOptionPane.showMessageDialog(null, "Veuillez completer tout les champs vide ");

            }else{
                 if( txt_Type.getSelectedItem().toString().equals("Congé")){
                        if(joui == null){
                             JOptionPane.showMessageDialog(null, "Veuillez completer tout les champs vide ");
                        }else{
                        try{
                        String tyy = txt_Type.getSelectedItem().toString();
                        String varr = rs.getString("Duree");//    duree ho atao modifcation
                        int var1 = Integer.parseInt(varr);                                                        
                        int dure1 = Integer.parseInt(dur);//    duree modifier
                        String t = "Congé";
                
                            String jouir = year.format(joui);
                            int jj = Integer.parseInt(jouir);
                            int jou = jj+1;                        
                               String bla = "Select * from autorisation where Type='"+t+"' and Jouir_annee = '"+jou+"' and Matricule = '"+matricule+"' and ID_Autorisation<>'"+d+"'";
                                        rs = st.executeQuery(bla);    
                                       
                                               if(!rs.next()){ // Ra misy anle année selectionner ny ao
                                                     int dur1 = Integer.parseInt(dur);
                                                     
                                                     if(dur1>30){
                                                           JOptionPane.showMessageDialog(null, "Un personnel n'a droit qu'à 30 jours de congé par année");
                                                       }else{
                                                         String update = "update autorisation set Matricule=?,Duree = ?,Type = ?,Motif = ?,Jouir_annee=? where ID_Autorisation = ?";
                                                           prepare = con.prepareStatement(update);
                                                           prepare.setString(1, matricule);
                                                           prepare.setString(2, dur);
                                                           prepare.setString(3, txt_Type.getSelectedItem().toString());
                                                           prepare.setString(4, motif);
                                                           prepare.setInt(5, jou);
                                                           prepare.setString(6, d);
                                                           prepare.executeUpdate();  
                                                           JOptionPane.showMessageDialog(null, "Modification avec succès");
                                                           util.Actualiserd();
                                                           util.setEnabled(true);
                                                           this.dispose();
                                                   
                                                 }
                                              
                                                }else{
                                                   
                                                    String ch = "Select sum(Duree) as nb from autorisation where Type='"+t+"' and Jouir_annee = '"+jou+"' and Matricule = '"+matricule+"' and ID_Autorisation<>'"+d+"'";
                                                    rsu = st.executeQuery(ch);
                                                    rsu.next();
                                                   String count = rsu.getString("nb");
                                                   int nb1 = Integer.parseInt(count);
                                                   int dur1 = Integer.parseInt(dur);
                                                   int nb2 = nb1 + dur1 ;
                                                   int nb3 = 30-nb1;
                                                        if(nb2>30){
                                                           JOptionPane.showMessageDialog(null, "Cet personne n'a plus que "+nb3+" jours de congé disponible l'année "+jou+"");
                                                       }else{
                                                            String update = "update autorisation set Matricule=?,Duree = ?,Type = ?,Motif = ?,Jouir_annee=? where ID_Autorisation = ?";
                                                           prepare = con.prepareStatement(update);
                                                           prepare.setString(1, matricule);
                                                           prepare.setString(2, dur);
                                                           prepare.setString(3, txt_Type.getSelectedItem().toString());
                                                           prepare.setString(4, motif);
                                                           prepare.setInt(5, jou);
                                                           prepare.setString(6, d);
                                                           prepare.executeUpdate();  
                                                           JOptionPane.showMessageDialog(null, "Modification avec succès");
                                                           util.Actualiserd();
                                                           util.setEnabled(true);
                                                           this.dispose();
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
                             
                            
       }else if (txt_Type.getSelectedItem().toString().equals("Congé de maternité") || txt_Type.getSelectedItem().toString().equals("Congé de paternité")){ ////////////////////////
                             try{
                                String date = sp.format(today);
                                st = con.createStatement();
                                rs = st.executeQuery("Select Date_dpt from autorisation where Matricule = '"+matricule+"' and Type = '"+txt_Type.getSelectedItem().toString()+"' and ID_Autorisation <> '"+d+"'");                
                                boolean bol = true;
                                while(rs.next() & bol){
                                String mo = rs.getString("Date_dpt");
                                Date dd = sp.parse(mo);
                                String annee = year.format(dd);
                                String ye = year.format(today);

                                    if(annee.equals(ye)){    
                                        JOptionPane.showMessageDialog(null,"Cet Personne à déja reçu un "+txt_Type.getSelectedItem().toString()+" cet année");
                                        bol = false;
                                        return;
                                    }

                                }
                                
                                String jou = "";  
                                String update = "update autorisation set Matricule=?,Duree = ?,Type = ?,Motif = ?,Jouir_annee=? where ID_Autorisation = ?";
                                prepare = con.prepareStatement(update);
                                prepare.setString(1, matricule);
                                prepare.setString(2, dur);
                                prepare.setString(3, txt_Type.getSelectedItem().toString());
                                prepare.setString(4, motif);
                                prepare.setString(5, jou);
                                prepare.setString(6, d);
                                prepare.executeUpdate();  
                                JOptionPane.showMessageDialog(null, "Modification avec succès");
                                util.Actualiserd();
                                util.setEnabled(true);
                                this.dispose();


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
             }else if(txt_Type.getSelectedItem().toString().equals("Permission absence")){
                 
                   
                 try{
                        String date = sp.format(today);
                        String dd = year.format(today);
                        String t = "Permission absence";
                        String SQL = "Select * from autorisation where Type='"+t+"' and Matricule = '"+matricule+"' and substr(Date_dpt,1,4) ='"+dd+"'and ID_Autorisation <> '"+d+"'   ";
                        rs = st.executeQuery(SQL);
                        if(rs.next()){
                          String SQL1 =  "Select sum(Duree) as nb from autorisation where  Matricule = '"+matricule+"' and substr(Date_dpt,1,4) ='"+dd+"' and Type='"+t+"' ";
                          rs = st.executeQuery(SQL1);
                          rs.next();
                          String val = rs.getString("nb");
                          int val1 = Integer.parseInt(val);
                          int dur1 = Integer.parseInt(dur);
                          int val2 = val1 + dur1;
                          int val3 = 10-val1;
                                    if(val2>10){
                                        JOptionPane.showMessageDialog(null, "Ce personnel n'a plus que "+val3+" jours de permission d'absence disponible cet année");
                                        return;
                                    }
                                    if(dur1 > 3){
                                         JOptionPane.showMessageDialog(null, "La demande de "+txt_Type.getSelectedItem().toString()+" ne doit pas dépasser 3 jours");
                                        return;
                                    }

                                String jou = "";  
                                String update = "update autorisation set Matricule=?,Duree = ?,Type = ?,Motif = ?,Jouir_annee=? where ID_Autorisation = ?";
                                prepare = con.prepareStatement(update);
                                prepare.setString(1, matricule);
                                prepare.setString(2, dur);
                                prepare.setString(3, txt_Type.getSelectedItem().toString());
                                prepare.setString(4, motif);
                                prepare.setString(5, jou);
                                prepare.setString(6, d);
                                prepare.executeUpdate();  
                                JOptionPane.showMessageDialog(null, "Modification avec succès");
                                util.Actualiserd();
                                util.setEnabled(true);
                                this.dispose();


                          
                        }else{
                              int dur1 = Integer.parseInt(dur);
                              if(dur1 > 3){
                                         JOptionPane.showMessageDialog(null, "La demande de "+txt_Type.getSelectedItem().toString()+" ne doit pas dépasser 3 jours");
                                        return;
                                    }

                                String jou = "";  
                                String update = "update autorisation set Matricule=?,Duree = ?,Type = ?,Motif = ?,Jouir_annee=? where ID_Autorisation = ?";
                                prepare = con.prepareStatement(update);
                                prepare.setString(1, matricule);
                                prepare.setString(2, dur);
                                prepare.setString(3, txt_Type.getSelectedItem().toString());
                                prepare.setString(4, motif);
                                prepare.setString(5, jou);
                                prepare.setString(6, d);
                                prepare.executeUpdate();  
                                JOptionPane.showMessageDialog(null, "Modification avec succès");
                                util.Actualiserd();
                                util.setEnabled(true);
                                this.dispose();

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
       
       
       
        }else{
           
                           String jou = "";  
                                String update = "update autorisation set Matricule=?,Duree = ?,Type = ?,Motif = ?,Jouir_annee=? where ID_Autorisation = ?";
                                prepare = con.prepareStatement(update);
                                prepare.setString(1, matricule);
                                prepare.setString(2, dur);
                                prepare.setString(3, txt_Type.getSelectedItem().toString());
                                prepare.setString(4, motif);
                                prepare.setString(5, jou);
                                prepare.setString(6, d);
                                prepare.executeUpdate();  
                                JOptionPane.showMessageDialog(null, "Modification avec succès");
                                util.Actualiserd();
                                util.setEnabled(true);
                                this.dispose();


                         }
                        }
      }catch(Exception e){
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
                     e.printStackTrace();
                }
            }
    }
     
     }
     
   
    
    
    public void changement(){
         if(txt_Type.getSelectedItem().equals("Congé de maternité")){
           txt_Duree.setEnabled(false);
           txt_Duree.setText("90");
       }else if(txt_Type.getSelectedItem().equals("Permission absence")){
           txt_Duree.setEnabled(false);
           txt_Duree.setText("1");
       }else{
           txt_Duree.setEnabled(true);
       }
    }
    
    
    public void Matr(){
         String a = txt_Matricule.getSelectedItem().toString();
        try{
    Class.forName("org.sqlite.JDBC");
    conx = DriverManager.getConnection("jdbc:sqlite:"+db);
    stx = conx.createStatement();
       String sql = "Select Sexe from personnel where Matricule = '"+a+"'";
       rsx = stx.executeQuery(sql);
       rsx.next();
       if(rsx.getString("Sexe").equals("M")){
          demande();

                                           
        }
        if(rsx.getString("Sexe").equals("F")){
             demandef();

            }
        }catch(SQLException | ClassNotFoundException e){
                                          System.err.println(e);
           }finally{
                   if(rsx != null){
                        try{
                            rsx.close();
                        }catch(SQLException e){
                             e.printStackTrace();
                        }
            }  if(stx != null){
                        try{
                            stx.close();
                        }catch(SQLException e){
                             e.printStackTrace();
                        }
            }if(conx != null){
                        try{
                            conx.close();
                        }catch(SQLException e){
                             e.printStackTrace();
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
        jLabel4 = new javax.swing.JLabel();
        lbl_Jouir = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_modifier = new javax.swing.JButton();
        txt_Matricule = new javax.swing.JComboBox<>();
        btn_ajouter = new javax.swing.JButton();
        fermer = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_Motif = new javax.swing.JTextArea();
        txt_Type = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txt_Jouir = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DEMANDE DE CONGE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, 44));

        txt_Duree.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txt_Duree, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 230, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Type :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 90, 30));

        lbl_Jouir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_Jouir.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Jouir.setText("En jouir de l'année :");
        jPanel1.add(lbl_Jouir, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 140, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Motif :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 110, 30));

        btn_modifier.setText("Modifier");
        btn_modifier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modifierActionPerformed(evt);
            }
        });
        jPanel1.add(btn_modifier, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, -1, 30));

        txt_Matricule.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txt_Matricule.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txt_MatriculeItemStateChanged(evt);
            }
        });
        jPanel1.add(txt_Matricule, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 230, 30));

        btn_ajouter.setText("Envoyer");
        btn_ajouter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ajouterActionPerformed(evt);
            }
        });
        jPanel1.add(btn_ajouter, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, -1, 30));

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

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Matricule :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 90, 30));

        txt_Motif.setColumns(20);
        txt_Motif.setLineWrap(true);
        txt_Motif.setRows(5);
        txt_Motif.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txt_Motif);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 230, -1));

        txt_Type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Permission absence", "Congé", "Congé de maternité", "Congé de paternité", "Congé maladie", "Congé spécial", "Congé de formation" }));
        txt_Type.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txt_TypeItemStateChanged(evt);
            }
        });
        jPanel1.add(txt_Type, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 230, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Durée en jours :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 120, 30));

        txt_Jouir.setDateFormatString("yyyy");
        jPanel1.add(txt_Jouir, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 230, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 489, 440));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifierActionPerformed
        modifier();
    }//GEN-LAST:event_btn_modifierActionPerformed

    private void btn_ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ajouterActionPerformed
      ajouter();
        
    }//GEN-LAST:event_btn_ajouterActionPerformed

    private void fermerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fermerMouseClicked
        util.setVisible(true);
        this.dispose();
        util.setEnabled(true);
        util.Actualiserd();
    }//GEN-LAST:event_fermerMouseClicked

    private void fermerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fermerMouseEntered
          fermer.setBackground(Color.red);
    }//GEN-LAST:event_fermerMouseEntered

    private void fermerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fermerMouseExited
                fermer.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_fermerMouseExited

    private void txt_MatriculeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txt_MatriculeItemStateChanged
            String a = txt_Matricule.getSelectedItem().toString();
        try{
    Class.forName("org.sqlite.JDBC");
    con = DriverManager.getConnection("jdbc:sqlite:"+db);
    st = con.createStatement();
       String sql = "Select Sexe from personnel where Matricule = '"+a+"'";
       rs = st.executeQuery(sql);
       rs.next();
       if(rs.getString("Sexe").equals("M")){
          demande();

                                           
        }
        if(rs.getString("Sexe").equals("F")){
             demandef();

            }
        }catch(SQLException | ClassNotFoundException e){
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
    }//GEN-LAST:event_txt_MatriculeItemStateChanged

    private void txt_TypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txt_TypeItemStateChanged
  if(txt_Type.getSelectedItem().equals("Congé")){
        txt_Jouir.setEnabled(true);
        lbl_Jouir.setEnabled(true);
        txt_Duree.setEditable(true);
        
    }else if (txt_Type.getSelectedItem().equals("Congé de maternité")){
                txt_Jouir.setEnabled(false);
                lbl_Jouir.setEnabled(false);
                txt_Duree.setText("90");
                txt_Duree.setEditable(false);
            
    }else if (txt_Type.getSelectedItem().equals("Congé de paternité")){
                txt_Jouir.setEnabled(false);
                lbl_Jouir.setEnabled(false);
                txt_Duree.setText("15");
                txt_Duree.setEditable(false);
    }else{
            txt_Jouir.setEnabled(false);
            lbl_Jouir.setEnabled(false);
            txt_Duree.setEditable(true);
    }
    }//GEN-LAST:event_txt_TypeItemStateChanged
    
    
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
            java.util.logging.Logger.getLogger(Demander.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Demander.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Demander.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Demander.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Jouir;
    private javax.swing.JTextField txt_Duree;
    private com.toedter.calendar.JDateChooser txt_Jouir;
    private javax.swing.JComboBox<String> txt_Matricule;
    private javax.swing.JTextArea txt_Motif;
    private javax.swing.JComboBox<String> txt_Type;
    // End of variables declaration//GEN-END:variables
}
