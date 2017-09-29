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
public class enfant {
    
    connexion connexion = new connexion();
    
    Connection con = connexion.getConnexion();
    
    public boolean insertChild( String nom, String prenom, Date birth, String scolarise,  int idEmp ){
        boolean inserted = false;
        int col = 0;
            
        try {
            PreparedStatement pstm;
            
            pstm = con.prepareStatement("insert into enfant ( nom, prenom, dateNaissance, scolarise, idEmployee ) values (?,?,?,?,?)");
            pstm.setString(1, nom);
            pstm.setString(2, prenom);
            pstm.setDate(3, (java.sql.Date) birth);
            pstm.setString(4, scolarise);
            pstm.setInt(5, idEmp);
            
            col = pstm.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(centre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if( col > 0 )
            inserted = true;
            
        return inserted;
    }
    
    
    public String[][] selectChild(){
        String tableau[][] = null;
        try {
            Statement stm;            
            stm = con.createStatement();
            ResultSet result = stm.executeQuery("SELECT * From enfant");
            int i = 0;
            
            while (result.next()){
                
                tableau[i][0] = String.valueOf(result.getInt("idEnfant"));
                tableau[i][1] = result.getString("nom");
                tableau[i][2] = result.getString("prenom");
                tableau[i][3] = result.getDate("dateNaissance").toString();
                tableau[i][4] = result.getString("scolarise");
                tableau[i][5] = String.valueOf(result.getInt("idEmployee"));
                
                i++;               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(centre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tableau;       
    }
    
    public String[][] selectChildById( int id ){
        String tableau[][] = null;
        try {
            PreparedStatement pstm;
            
            pstm = con.prepareStatement("select * from enfant where idEnfant = ?");
            pstm.setInt(1, id);
            ResultSet result = pstm.executeQuery();
            
            int i = 0;
            
            while (result.next()){
                
                tableau[i][0] = String.valueOf(result.getInt("idEnfant"));
                tableau[i][1] = result.getString("nom");
                tableau[i][2] = result.getString("prenom");
                tableau[i][3] = result.getDate("dateNaissance").toString();
                tableau[i][4] = result.getString("scolarise");
                tableau[i][5] = String.valueOf(result.getInt("idEmployee"));
                
                i++;               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(centre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tableau;       
    }
    
}
