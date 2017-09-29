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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.admin;

/**
 *
 * @author sa
 */
public class admin {
    
    connexion connexion = new connexion();
    
    Connection con = connexion.getConnexion();
    
    public boolean login( String login, String password ){
        boolean logged = false;
        
        PreparedStatement pstm;
        try {
            pstm = con.prepareStatement("SELECT * From admin WHERE login = ? and mdp = ?");
            pstm.setString(1, login);
            pstm.setString(2, password);
            ResultSet result = pstm.executeQuery();
            while (result.next()){
               logged = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }    
               
        return logged;
    }
    
}
