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
public class attribution {
    connexion connexion = new connexion();
    
    Connection con = connexion.getConnexion();
    
    public boolean insertAttribution( int idDemande, Date debut, Date fin ){
        boolean inserted = false;
        int col = 0;
            
        try {
            PreparedStatement pstm;
            
            pstm = con.prepareStatement("insert into attribution ( idDemande, dateDebut, dateFin ) values (?,?,?)");
            pstm.setInt(1, idDemande);
            pstm.setDate(2, (java.sql.Date) debut);            
            pstm.setDate(3, (java.sql.Date) fin);
            
            col = pstm.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(centre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if( col > 0 )
            inserted = true;
            
        return inserted;
    }
    
    
    public String[][] selectAttribution(){
        String tableau[][] = null;
        try {
            Statement stm;            
            stm = con.createStatement();
            ResultSet result = stm.executeQuery("SELECT * From attribution");
            int i = 0;
            
            while (result.next()){
                
                tableau[i][0] = String.valueOf(result.getInt("idAttribution"));
                tableau[i][1] = String.valueOf(result.getInt("idDemande"));
                tableau[i][2] = result.getDate("dateDebut").toString();
                tableau[i][3] = result.getDate("dateFin").toString();
                tableau[i][4] = String.valueOf(result.getFloat("ddda"));
                tableau[i][5] = String.valueOf(result.getFloat("note"));
                
                i++;               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(centre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tableau;       
    }
    
    public String[][] selectAttributionById( int id ){
        String tableau[][] = null;
        try {
            PreparedStatement pstm;
            
            pstm = con.prepareStatement("select * from attribution where idAttribution = ?");
            pstm.setInt(1, id);
            ResultSet result = pstm.executeQuery();
            
            int i = 0;
            
            while (result.next()){
                
                tableau[i][0] = String.valueOf(result.getInt("idAttribution"));
                tableau[i][1] = String.valueOf(result.getInt("idDemande"));
                tableau[i][2] = result.getDate("dateDebut").toString();
                tableau[i][3] = result.getDate("dateFin").toString();
                tableau[i][4] = String.valueOf(result.getFloat("ddda"));
                tableau[i][5] =String.valueOf( result.getFloat("note"));
                
                i++;               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(centre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tableau;       
    }
}
