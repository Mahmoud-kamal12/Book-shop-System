
package Function;

import Classes.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mahmoud
 */
public class Authors {
    
    
    public DefaultTableModel sersh(Object keysersh , String colmName) throws SQLException
    {
            String []colm = {"المعرف الرقمي للكاتب ","اسم الكاتب","الحساب البريدى" , "بلد المنشأ " , "تاريخ الميلاد"};
            DefaultTableModel dm = new DefaultTableModel();
            for (String col : colm){dm.addColumn(col);}
            try {
            Connection con = (new dbconnection()).Funconn();
            String sql ="SELECT `authorId`, `authorName`, `authorEmail`, `authorCity`, `authorDB` FROM `author` WHERE "
            + colmName + " LIKE '%" + keysersh + "%';";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Date dateObj = rs.getDate(5);
                String date = dateObj.toString();
                Object []row ={rs.getInt(1) , rs.getString(2) , rs.getString(3),rs.getString(4),date};                dm.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
            return dm;
    }

    public  DefaultTableModel showAll() throws SQLException
    {
            String []colm = {"المعرف الرقمي للكاتب ","اسم الكاتب","الحساب البريدى" , "بلد المنشأ " , "تاريخ الميلاد"};
        DefaultTableModel dm = new DefaultTableModel();
        for (String col : colm){dm.addColumn(col);}
        try {
            Connection con = (new dbconnection()).Funconn();
            String sql ="SELECT `authorId`, `authorName`, `authorEmail`, `authorCity`, `authorDB` FROM `author`";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {               
                Date dateObj = rs.getDate(5);
                String date = dateObj.toString();
                Object []row ={rs.getInt(1) , rs.getString(2) , rs.getString(3),rs.getString(4),date};
                dm.addRow(row);
        }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dm;
    }

    
    public  void add(Classes.Author au) throws SQLException
    {
        String sql = "INSERT INTO `author`(`authorName`, `authorEmail`, `authorCity`, `authorDB`)"
        + " VALUES (?,?,?,?)";
        try {
            Connection con = (new dbconnection()).Funconn();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, au.getAuthorName());
            stm.setString(2, au.getAuthorEmail());
            stm.setString(3, au.getAuthorCity());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(au.getAuthorDB());
            stm.setString(4,date );
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public  Classes.Author Showrow(int id) throws SQLException
    {
        Classes.Author au = new Classes.Author();
        try {
            Connection con = (new dbconnection()).Funconn();
            String sql ="SELECT `authorId`, `authorName`, `authorEmail`, `authorCity`, `authorDB` FROM `author` "+
            "WHERE authorId = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                au.setAuthorId(rs.getInt(1));
                au.setAuthorName(rs.getString(2));
                au.setAuthorEmail(rs.getString(3));
                au.setAuthorCity(rs.getString(4));
                au.setAuthorDB(rs.getDate(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }      
            return au;
    }

    
    public void delet(int id) throws SQLException
    {
        String sql = "DELETE FROM `author` WHERE `author`.`authorId` = ?";
                try {
            Connection con = (new dbconnection()).Funconn();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    public void update(Classes.Author au) throws SQLException
    {
        String sql = "UPDATE `author` SET `authorName`=?,`authorEmail`=?,`authorCity`=?,`authorDB`=? "
        + "WHERE authorId = ?";
        try {
            Connection con = (new dbconnection()).Funconn();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, au.getAuthorName());
            stm.setString(2, au.getAuthorEmail());
            stm.setString(3, au.getAuthorCity());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(au.getAuthorDB());
            stm.setString(4,date );
            stm.setInt(5, au.getAuthorId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
}
