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
import javax.swing.table.DefaultTableModel;
import Classes.*;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;
/**
 *
 * @author Mahmoud
 */
public class Category  {

    public DefaultTableModel sersh(Object keysersh , String colmName) throws SQLException
    {
            String []colm = {"المعرف الرقمي للفئه ","اسم الفئه","وصف الفئه"};
            DefaultTableModel dm = new DefaultTableModel();
            for (String col : colm){dm.addColumn(col);}
            try {
            Connection con = (new dbconnection()).Funconn();
            String sql ="SELECT `categoryId`, `categoryName`, `categoryDiscruption` FROM `category` WHERE "
            + colmName + " LIKE '%" + keysersh + "%';";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Object []row ={rs.getInt(1) , rs.getString(2) , rs.getString(3)};
                dm.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
            return dm;
    }

    public  DefaultTableModel showAll() throws SQLException
    {
        String []colm = {"المعرف الرقمي للفئه ","اسم الفئه","وصف الفئه"};
        DefaultTableModel dm = new DefaultTableModel();
        for (String col : colm){dm.addColumn(col);}
        try {
            Connection con = (new dbconnection()).Funconn();
            String sql ="SELECT `categoryId`, `categoryName`, `categoryDiscruption` FROM `category` ";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Object []row ={rs.getInt(1) , rs.getString(2) , rs.getString(3)};
                dm.addRow(row);
        }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dm;
    }

    
    public  void add(Classes.Category cat) throws SQLException
    {
        String sql = "INSERT INTO `category`(`categoryName`, `categoryDiscruption`)"
        + " VALUES (?,?)";
        try {
            Connection con = (new dbconnection()).Funconn();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, cat.getCategoryName());
            stm.setString(2, cat.getCategoryDiscruption());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public  Classes.Category Showrow(int id) throws SQLException
    {
        Classes.Category cat = new Classes.Category();
        try {
            Connection con = (new dbconnection()).Funconn();
            String sql ="SELECT `categoryId`, `categoryName`, `categoryDiscruption` FROM `category` "+
                                "WHERE categoryId = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                cat.setCategoryId(rs.getInt(1));
                cat.setCategoryName(rs.getString(2));
                cat.setCategoryDiscruption(rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }      
            return cat;
    }

    
    public void delet(int id) throws SQLException
    {
        String sql = "DELETE FROM `category` WHERE `category`.`categoryId` = ?";
                try {
            Connection con = (new dbconnection()).Funconn();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    public void update(Classes.Category cat) throws SQLException
    {
        String sql = "UPDATE `category` SET `categoryName` = ?, `categoryDiscruption` = ? WHERE `category`.`categoryId` = ?;";
        try {
            Connection con = (new dbconnection()).Funconn();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, cat.getCategoryName());
            stm.setString(2, cat.getCategoryDiscruption());
            stm.setInt(3, cat.getCategoryId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

}
