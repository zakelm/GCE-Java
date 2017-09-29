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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sa
 */
public class centre {
    
    connexion connexion = new connexion();
    
    Connection con = connexion.getConnexion();
    
    public boolean insertCentre( String ville, int compFam ){
        boolean inserted = false;
        int col = 0;
            
        try {
            PreparedStatement pstm;
            
            pstm = con.prepareStatement("insert into centreestivage ( ville, compositionFam ) values (?,?)");
            pstm.setString(1, ville);
            pstm.setInt(2, compFam);
            
            col = pstm.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(centre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if( col > 0 )
            inserted = true;
            
        return inserted;
    }
    
    
    public String[][] selectCenter(){
        String tableau[][] = null;
        try {
            Statement stm;            
            stm = con.createStatement();
            ResultSet result = stm.executeQuery("SELECT * From centreestivage");
            int i = 0;
            
            while (result.next()){
                
                tableau[i][0] = String.valueOf(result.getInt("idCentre"));
                tableau[i][1] = result.getString("ville");
                tableau[i][2] = String.valueOf(result.getInt("compositionFam"));
                
                i++;               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(centre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tableau;       
    }
    
    public String[][] selectCenterById( int id ){
        String tableau[][] = null;
        try {
            PreparedStatement pstm;
            
            pstm = con.prepareStatement("select * from centreestivage where idCentre = ?");
            pstm.setInt(1, id);
            ResultSet result = pstm.executeQuery();
            
            int i = 0;
            
            while (result.next()){
                
                tableau[i][0] = String.valueOf(result.getInt("idCentre"));
                tableau[i][1] = result.getString("ville");
                tableau[i][2] = String.valueOf(result.getInt("compositionFam"));
                
                i++;               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(centre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tableau;       
    }
    
}
