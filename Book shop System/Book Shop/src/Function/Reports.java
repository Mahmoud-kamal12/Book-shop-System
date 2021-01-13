/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mahmoud
 */
public class Reports {
    
    
    public int Count(String tname , String sdate ,String edate) throws SQLException
    {
        String colname = "DBADD";
        if(tname.equals("clients"))
            colname = "DateOfSale";
        int log = 0;
        try {
            Connection con = (new dbconnection()).Funconn();
            String sql ="SELECT COUNT(*)  FROM "+ tname +
            " WHERE `"+colname+"` BETWEEN \'" + sdate + "\' AND \'" +edate +"\'";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                log = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return log;
    }
    
    public int numbooks(String colName , String sdate ,String edate) throws SQLException
    {
        int log = 0;
        try {
            Connection con = (new dbconnection()).Funconn();
            String sql ="SELECT SUM("+ colName + ") FROM clients "+
            "WHERE clients.DateOfSale BETWEEN \'" + sdate + "\' AND \'" +edate +"\'";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                log = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return log;
    }
 
    public int Profits(String sdate ,String edate) throws SQLException
    {
        String sql = "SELECT  sum(clients.numOfBooks * books.bookCost) FROM clients " +
        "INNER JOIN books on books.bookId = clients.books_bookid "+
        "WHERE clients.DateOfSale BETWEEN \'" + sdate + "\' AND \'" +edate +"\'";
        int log = 0;
        try {
            Connection con = (new dbconnection()).Funconn();
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                log = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return log;
    }
    
}
