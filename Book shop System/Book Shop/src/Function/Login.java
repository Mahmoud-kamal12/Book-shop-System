/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import Classes.Admin;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mahmoud
 */
public class Login  {

    public boolean login(Admin admin) {
        boolean log = false;
        try {
            Connection con = (new dbconnection()).Funconn();
            String sql ="SELECT * FROM `admin` WHERE adminEmail = ? and adminPassword = ? ;";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, admin.getAdminEmail());
            stm.setString(2, admin.getAdminPassword());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                log = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return log;
    }
    
}
