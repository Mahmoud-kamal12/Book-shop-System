/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mahmoud
 */
public class Customer {
    
    
    public DefaultTableModel sersh(Object keysersh , String colmName , String tbName) throws SQLException
    {
            String []colm = {"المعرف الرقمى","اسم العميل","الايمال" , "رقم الهاتف" ,"عنوان العميل" , "اسم الكتاب","عدد الكتب" , "تاريخ الشراء"};
            DefaultTableModel dm = new DefaultTableModel();
            for (String col : colm){dm.addColumn(col);}
            try {
            Connection con = (new dbconnection()).Funconn();
            String sql ="SELECT `clientid`,  `clientName` ,`clientEmail`,  `clientPhone`, `clientAddres`,  books.bookName , clients.numOfBooks ,  clients.DateOfSale " +
            " FROM `clients`  INNER JOIN books on books.bookId = clients.books_bookid "
            +" WHERE " + tbName +"."+colmName + " LIKE '%" + keysersh + "%';";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {               
                Date dateObj = rs.getDate(8);
                String date = dateObj.toString();
                Object []row ={rs.getInt(1) , rs.getString(2) , rs.getString(3) ,rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),date};
                dm.addRow(row);
                }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
            return dm;
    }

    public  DefaultTableModel showAll() throws SQLException
    {
            String []colm = {"المعرف الرقمى","اسم العميل","الايمال" , "رقم الهاتف" ,"عنوان العميل" , "اسم الكتاب","عدد الكتب" , "تاريخ الشراء"};
        DefaultTableModel dm = new DefaultTableModel();
        for (String col : colm){dm.addColumn(col);}
        try {
            Connection con = (new dbconnection()).Funconn();
            String sql ="SELECT `clientid`,  `clientName` ,`clientEmail`,  `clientPhone`, `clientAddres`,  books.bookName , clients.numOfBooks ,  clients.DateOfSale " +
            "FROM `clients`  INNER JOIN books on books.bookId = clients.books_bookid";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {               
                Date dateObj = rs.getDate(8);
                String date = dateObj.toString();
                Object []row ={rs.getInt(1) , rs.getString(2) , rs.getString(3) ,rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),date};
                dm.addRow(row);
                }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dm;
    }


    public void delet(int id) throws SQLException
    {
        String sql = "DELETE FROM `clients` WHERE `clients`.`clientid` = ?";
        try {
            Connection con = (new dbconnection()).Funconn();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }


    
    
}
