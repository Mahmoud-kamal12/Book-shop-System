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


public class Books {
    
    public int []author_id;
    public int []categ_id;
    
    public DefaultComboBoxModel show(String s)
    {

        String sql ="";
        String sql2 = "";
        int row = 0;
        DefaultComboBoxModel com = new DefaultComboBoxModel();
        Connection con = null;
        try {
            con = (new dbconnection()).Funconn();
            if(s.equals("au")){
                sql ="SELECT `authorId`, `authorName` FROM `author`";
                sql2 = "SELECT count(`authorId`) FROM `author`";
            }
            else{
                sql ="SELECT `categoryId`, `categoryName` FROM `category` ";
                sql2 = "SELECT count(`categoryId`) FROM `category`";
            }
            PreparedStatement stm2 = con.prepareStatement(sql2);
            ResultSet rs2 = stm2.executeQuery();
            while (rs2.next()) row = rs2.getInt(1);
            stm2.close();
            rs2.close();
            con.close();
            
            con = (new dbconnection()).Funconn();
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if(s.equals("au"))
            {  
                int i = 0;
                author_id =new int [row];
                while (rs.next()) 
                {
                    author_id[i] = rs.getInt(1);
                    com.addElement(rs.getObject(2));
                    i++;
                }
            }else{
                int i = 0;
                categ_id =new int [row];
                while (rs.next()) 
                {
                    categ_id[i] = rs.getInt(1);
                    com.addElement(rs.getObject(2));
                    i++;
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return com;
    }
    
    public DefaultTableModel sersh(Object keysersh , String colmName , String tbName) throws SQLException
    {
            String []colm = {"المعرف الرقمي للكتاب","اسم الكتاب","تاريخ النشر " , "سعر الكتاب" , "عدد الكتب" , "اسم  الفئة" , "اسم  الكاتب"};
            DefaultTableModel dm = new DefaultTableModel();
            for (String col : colm){dm.addColumn(col);}
            try {
            Connection con = (new dbconnection()).Funconn();
            String sql ="SELECT `bookId`, `bookName`,`bookDatePublish`,`bookCost`,`NumOfBooks`, category.categoryName , author.authorName " +
            "FROM `books` " +
            "INNER JOIN author on books.author_authorId = author.authorId " +
            "INNER JOIN category on category.categoryId = books.category_categoryId "
            +"WHERE " + tbName +"."+colmName + " LIKE '%" + keysersh + "%';";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {               
                Date dateObj = rs.getDate(3);
                String date = dateObj.toString();
                Object []row ={rs.getInt(1) , rs.getString(2) , date ,rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getString(7)};
                dm.addRow(row);
                }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
            return dm;
    }

    public  DefaultTableModel showAll() throws SQLException
    {
        String []colm = {"المعرف الرقمي للكتاب","اسم الكتاب","تاريخ النشر " , "سعر الكتاب" , "عدد الكتب" , "اسم  الفئة" , "اسم  الكاتب"};
        DefaultTableModel dm = new DefaultTableModel();
        for (String col : colm){dm.addColumn(col);}
        try {
            Connection con = (new dbconnection()).Funconn();
            String sql ="SELECT `bookId`, `bookName`,`bookDatePublish`,`bookCost`,`NumOfBooks`, category.categoryName , author.authorName " +
            "FROM `books` " +
            "INNER JOIN author on books.author_authorId = author.authorId " +
            "INNER JOIN category on category.categoryId = books.category_categoryId ";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {               
                Date dateObj = rs.getDate(3);
                String date = dateObj.toString();
                Object []row ={rs.getInt(1) , rs.getString(2) , date ,rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getString(7)};
                dm.addRow(row);
                }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dm;
    }
    
    public  void add(Classes.Books bo) throws SQLException
    {
        String sql = "INSERT INTO `books`"
        + "(`bookName`, `bookCost`,`NumOfBooks`,`bookDatePublish`, `category_categoryId`, `author_authorId`) "
        + " VALUES (?,?,?,?,?,?)";
        try {
            Connection con = (new dbconnection()).Funconn();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, bo.getBookName());
            stm.setInt(2, bo.getBookCost());
            stm.setInt(3, bo.getNumOfBooks());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(bo.getBookDatePublish());
            stm.setString(4,date );
            stm.setInt(5, bo.getCategorycategoryId());
            stm.setInt(6, bo.getAuthorauthorId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public  Classes.Books Showrow(int id) throws SQLException
    {
        Classes.Books bo = new Classes.Books();
        try {
            Connection con = (new dbconnection()).Funconn();
            String sql ="SELECT books.bookId , books.bookName ,books.bookDatePublish , books.bookCost , books.NumOfBooks , category.categoryId  , author.authorId " +
            "FROM `books` " +
            "INNER JOIN author on books.author_authorId = author.authorId " +
            "INNER JOIN category on category.categoryId = books.category_categoryId "
            +"WHERE books.bookId = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                bo.setBookId(rs.getInt(1));
                bo.setBookName(rs.getString(2));
                bo.setBookDatePublish(rs.getDate(3));
                bo.setBookCost(rs.getInt(4));
                bo.setNumOfBooks(rs.getInt(5));
                bo.setCategorycategoryId(rs.getInt(6));
                bo.setAuthorauthorId(rs.getInt(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }      
            return bo;
    }

    public void delet(int id) throws SQLException
    {
        String sql = "DELETE FROM `books` WHERE `books`.`bookId` = ?";
        try {
            Connection con = (new dbconnection()).Funconn();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    public void update(Classes.Books bo) throws SQLException
    {
        String sql = "UPDATE `books` SET `bookName`=?,`bookCost`=?,`NumOfBooks`=?,`bookDatePublish`=?,`category_categoryId`=?,`author_authorId`=? " +
        "WHERE books.bookId = ?";
        try {
            Connection con = (new dbconnection()).Funconn();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, bo.getBookName());
            stm.setInt(2, bo.getBookCost());
            stm.setInt(3, bo.getNumOfBooks());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(bo.getBookDatePublish());
            stm.setString(4,date );
            stm.setInt(5, bo.getCategorycategoryId());
            stm.setInt(6, bo.getAuthorauthorId());
            stm.setInt(7, bo.getBookId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
}
