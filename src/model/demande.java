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
public class demande {
     connexion connexion = new connexion();
    
    Connection con = connexion.getConnexion();
    
    public boolean insertDemande( Date dateDemande, int idCentre1, int idCentre2, int idCentre3, String etat, int idAttribution, int idEmployee ){
        boolean inserted = false;
        int col = 0;
            
        try {
            PreparedStatement pstm;
            
            pstm = con.prepareStatement("insert into demande ( idDemande, dateDemande, idCentre1, idCentre2, idCentre3, etat, idEmployee, idAttribution ) values (?,?,?,?,?,?,?,?)");
            pstm.setDate(1, (java.sql.Date) dateDemande);            
            pstm.setInt(2, idCentre1);
            pstm.setInt(3, idCentre2);
            pstm.setInt(4, idCentre3);
            pstm.setString(5, etat);  
            pstm.setInt(6, idEmployee);
            pstm.setInt(7, idAttribution);
            
            col = pstm.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(centre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if( col > 0 )
            inserted = true;
            
        return inserted;
    }
    
    
    public String[][] selectDemande(){
        String tableau[][] = null;
        try {
            Statement stm;            
            stm = con.createStatement();
            ResultSet result = stm.executeQuery("SELECT * From demande");
            int i = 0;
            
            while (result.next()){
                
                tableau[i][0] = String.valueOf(result.getInt("idDemande"));
                tableau[i][1] = result.getDate("dateDemande").toString();
                tableau[i][2] = String.valueOf(result.getInt("idCentre1"));
                tableau[i][3] = String.valueOf(result.getInt("idCentre2"));
                tableau[i][4] = String.valueOf(result.getInt("idCentre3"));
                tableau[i][5] = result.getString("etat");
                tableau[i][6] = String.valueOf(result.getInt("idEmployee"));
                tableau[i][7] = String.valueOf(result.getInt("idAttribution"));
                i++;               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(centre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tableau;       
    }
    
    public String[][] selectDemandeById( int id ){
        String tableau[][] = null;
        try {
            PreparedStatement pstm;
            
            pstm = con.prepareStatement("select * from demande where idDemande = ?");
            pstm.setInt(1, id);
            ResultSet result = pstm.executeQuery();
            
            int i = 0;
            
            while (result.next()){
                
                tableau[i][0] = String.valueOf(result.getInt("idDemande"));
                tableau[i][1] = result.getDate("dateDemande").toString();
                tableau[i][2] = String.valueOf(result.getInt("idCentre1"));
                tableau[i][3] = String.valueOf(result.getInt("idCentre2"));
                tableau[i][4] = String.valueOf(result.getInt("idCentre3"));
                tableau[i][5] = result.getString("etat");
                tableau[i][6] = String.valueOf(result.getInt("idEmployee"));
                tableau[i][7] = String.valueOf(result.getInt("idAttribution"));
                
                i++;               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(centre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tableau;       
    }
    
    public String[][] selectDemandeByname( String name ){
        String tableau[][] = null;
        try {
            PreparedStatement pstm;
            
            pstm = con.prepareStatement("select * from demande where name = ?");
            pstm.setString(1, name);
            ResultSet result = pstm.executeQuery();
            
            int i = 0;
            
            while (result.next()){
                
                tableau[i][0] = String.valueOf(result.getInt("idDemande"));
                tableau[i][1] = result.getDate("dateDemande").toString();
                tableau[i][2] = String.valueOf(result.getInt("idCentre1"));
                tableau[i][3] = String.valueOf(result.getInt("idCentre2"));
                tableau[i][4] = String.valueOf(result.getInt("idCentre3"));
                tableau[i][5] = result.getString("etat");
                tableau[i][6] = String.valueOf(result.getInt("idEmployee"));
                tableau[i][7] = String.valueOf(result.getInt("idAttribution"));
                
                i++;               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(centre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tableau;       
    }
}
