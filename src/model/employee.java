/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sa
 */
public class employee {
    connexion connexion = new connexion();
    
    Connection con = connexion.getConnexion();
    
    public boolean insertEmployee( String nom, String prenom, Date dateAffect, Date dateNais, Date dateContrat, Date dateAttrib, String sitFam, int nbrEnf, String service, String emploi ){
        boolean inserted = false;
        int col = 0;
            
        try {
            PreparedStatement pstm;
            
            pstm = con.prepareStatement("insert into employee ( nom, prenom, dateNaissance, dateAffectation, dateContrat, dateAttribution, situationFam, nbEnfant, service, emploi ) values (?,?,?,?,?,?,?,?,?,?)");
            pstm.setString(1, nom);
            pstm.setString(2, prenom);
            pstm.setDate(3, (java.sql.Date) dateNais);
            pstm.setDate(4, (java.sql.Date) dateAffect);
            pstm.setDate(5, (java.sql.Date) dateContrat);
            pstm.setDate(6, (java.sql.Date) dateAttrib);
            pstm.setString(7, sitFam);
            pstm.setInt(8, nbrEnf);
            pstm.setString(9, service);
            pstm.setString(10, emploi);
            
            col = pstm.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(centre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if( col > 0 )
            inserted = true;
            
        return inserted;
    }
    
    
    public String[][] selectEmployee(){
        String tableau[][] = null;
        try {
            Statement stm;            
            stm = con.createStatement();
            ResultSet result = stm.executeQuery("SELECT * From employee");
            int i = 0;
            while (result.next()){
                tableau[i][0] = result.getInt("matricul")+"";
                tableau[i][1] = result.getString("nom");
                tableau[i][2] = result.getString("prenom");
                tableau[i][3] = result.getDate("dateNaissance").toString();
                tableau[i][4] = result.getDate("dateAffectation").toString();
                tableau[i][5] = result.getDate("dateContrat").toString();
                tableau[i][6] = result.getDate("dateAttribution").toString();
                tableau[i][7] = result.getString("situationFam");
                tableau[i][8] = String.valueOf(result.getInt("nbEnfant"));
                tableau[i][9] = result.getString("service");
                tableau[i][10] = result.getString("emploi");
                tableau[i][11] = String.valueOf(result.getFloat("ancienneteEtab"));
                tableau[i][12] = String.valueOf(result.getFloat("ancienneteEntr"));
                tableau[i][13] = String.valueOf(result.getFloat("age"));
                
                i++;               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(centre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tableau;       
    }
    
    public String[][] selectEmployeeById( int id ){
        String tableau[][] = null;
        try {
            PreparedStatement pstm;
            
            pstm = con.prepareStatement("select * from employee where matricul = ?");
            pstm.setInt(1, id);
            ResultSet result = pstm.executeQuery();
            
            int i = 0;
            
            while (result.next()){
                
                tableau[i][0] = String.valueOf(result.getInt("matricul"));
                tableau[i][1] = result.getString("nom");
                tableau[i][2] = result.getString("prenom");
                tableau[i][3] = result.getDate("dateNaissance").toString();
                tableau[i][4] = result.getDate("dateAffectation").toString();
                tableau[i][5] = result.getDate("dateContrat").toString();
                tableau[i][6] = result.getDate("dateAttribution").toString();
                tableau[i][7] = result.getString("situationFam");
                tableau[i][8] = String.valueOf(result.getInt("nbEnfant"));
                tableau[i][9] = result.getString("service");
                tableau[i][10] = result.getString("emploi");
                tableau[i][11] = String.valueOf(result.getFloat("ancienneteEtab"));
                tableau[i][12] = String.valueOf(result.getFloat("ancienneteEntr"));
                tableau[i][13] = String.valueOf(result.getFloat("age"));
                
                i++;               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(centre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tableau;       
    }
    
    public String[][] selectEmployeeByname( String nom, String prenom ){
        String tableau[][] = null;
        try {
            PreparedStatement pstm;
            
            pstm = con.prepareStatement("select * from employee where nom = ? and prenom");
            pstm.setString(1, nom);
            pstm.setString(1, prenom);
            ResultSet result = pstm.executeQuery();
            
            int i = 0;
            
            while (result.next()){
                
                tableau[i][0] = String.valueOf(result.getInt("matricul"));
                tableau[i][1] = result.getString("nom");
                tableau[i][2] = result.getString("prenom");
                tableau[i][3] = result.getDate("dateNaissance").toString();
                tableau[i][4] = result.getDate("dateAffectation").toString();
                tableau[i][5] = result.getDate("dateContrat").toString();
                tableau[i][6] = result.getDate("dateAttribution").toString();
                tableau[i][7] = result.getString("situationFam");
                tableau[i][8] = String.valueOf(result.getInt("nbEnfant"));
                tableau[i][9] = result.getString("service");
                tableau[i][10] = result.getString("emploi");
                tableau[i][11] = String.valueOf(result.getFloat("ancienneteEtab"));
                tableau[i][12] = String.valueOf(result.getFloat("ancienneteEntr"));
                tableau[i][13] = String.valueOf(result.getFloat("age"));
                
                i++;               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(centre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tableau;       
    }
    
}
