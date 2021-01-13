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
public class Sells {
    
    
    public int [] books_id;
    
    public DefaultTableModel sersh(Object keysersh , String colmName , String tbName) throws SQLException
    {
            String []colm = {"المعرف الرقمي للكتاب","اسم الكتاب","المؤلف","الفئة","تاريخ النشر","السعر","العدد"};
            DefaultTableModel dm = new DefaultTableModel();
            for (String col : colm){dm.addColumn(col);}
            try {
            Connection con = (new dbconnection()).Funconn();
            String sql ="SELECT b.bookId , b.bookName , a.authorName , c.categoryName , " +
            "b.bookDatePublish , b.bookCost , b.NumOfBooks " +
            "FROM books as b " +
            "INNER JOIN author as a on a.authorId = b.author_authorId " +
            "INNER JOIN category as c on c.categoryId = b.category_categoryId "+
            " WHERE " + tbName +"."+colmName + " LIKE '%" + keysersh + "%';";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {               
                Date dateObj = rs.getDate(5);
                String date = dateObj.toString();
                Object []row ={rs.getInt(1) , rs.getString(2) , rs.getString(3) ,rs.getString(4),date,rs.getInt(6),rs.getInt(7)};
                dm.addRow(row);
                }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
            return dm;
    }

    public  DefaultTableModel showAll() throws SQLException
    {
        String []colm = {"المعرف الرقمي للكتاب","اسم الكتاب","المؤلف","الفئة","تاريخ النشر","السعر","العدد"};
        DefaultTableModel dm = new DefaultTableModel();
        for (String col : colm){dm.addColumn(col);}
        try {
            Connection con = (new dbconnection()).Funconn();
            String sql ="SELECT b.bookId , b.bookName , a.authorName , c.categoryName , " +
            "b.bookDatePublish , b.bookCost , b.NumOfBooks " +
            "FROM books as b " +
            "INNER JOIN author as a on a.authorId = b.author_authorId " +
            "INNER JOIN category as c on c.categoryId = b.category_categoryId";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {               
                Date dateObj = rs.getDate(5);
                String date = dateObj.toString();
                Object []row ={rs.getInt(1) , rs.getString(2) , rs.getString(3) ,rs.getString(4),date,rs.getInt(6),rs.getInt(7)};
                dm.addRow(row);
                }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dm;
    }

    public  void add(Classes.Clients cl) throws SQLException
    {
        String sqlbook = "UPDATE `books` SET NumOfBooks = NumOfBooks - "+cl.getNumOfBooks() +"  WHERE bookId = ?";
        String sqlcli = "INSERT INTO `clients`(`clientEmail`, `clientName`, `clientAddres`, `clientPhone`, `numOfBooks`, `DateOfSale`, `books_bookid`)"
        + " VALUES (?,?,?,?,?,?,?)";
        
        PreparedStatement stm = null;
        Connection con = null;
        try {
            con = (new dbconnection()).Funconn();
            stm = con.prepareStatement(sqlcli);
            
            stm.setString(1, cl.getClientEmail());
            stm.setString(2, cl.getClientName());
            stm.setString(3, cl.getClientAddres());
            stm.setString(4, cl.getClientPhone());
            stm.setInt(5, cl.getNumOfBooks());
            stm.setInt(7, cl.getBooksBookid());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(cl.getDateOfSale());
            stm.setString(6,date );
            
            stm.executeUpdate();
            stm.close();
            con.close();
            
            con = (new dbconnection()).Funconn();
            stm = con.prepareStatement(sqlbook);
            stm.setInt(1, cl.getBooksBookid());
            stm.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public  int Showrow(int id) throws SQLException
    {
        int bookid = -1;
        try {
            Connection con = (new dbconnection()).Funconn();
            String sql ="SELECT bookId FOR books WHERE bookId = ? ;";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                bookid = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bookid;
    }

    public DefaultComboBoxModel show() throws SQLException
    {

        String sql ="";
        String sql2 = "";
        int row = -1;
        DefaultComboBoxModel com = new DefaultComboBoxModel();
        Connection con = null;
        try {
            con = (new dbconnection()).Funconn();
            sql ="SELECT `bookId`, `bookName` FROM `books`";
            sql2 = "SELECT count(`bookId`) FROM `books`";

            PreparedStatement stm2 = con.prepareStatement(sql2);
            ResultSet rs2 = stm2.executeQuery();
            while (rs2.next()) row = rs2.getInt(1);
            stm2.close();
            rs2.close();
            con.close();
            
            con = (new dbconnection()).Funconn();
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
                int i = 0;
                books_id =new int [row];
                while (rs.next()) 
                {
                    books_id[i] = rs.getInt(1);
                    com.addElement(rs.getObject(2));
                    i++;
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return com;
    }

    public int getNumofBooks(int id) throws SQLException
    {
        int num = -1;
        try {
            String sql ="";
            Connection con = (new dbconnection()).Funconn();;
            con = (new dbconnection()).Funconn();
            sql = "SELECT NumOfBooks FROM `books` WHERE books.bookId = ?"; 
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next())
            {
                num= rs.getInt(1);
            }
        }catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return num;
    }
    

}