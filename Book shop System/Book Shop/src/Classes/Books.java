/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;


import java.util.Date;

public class Books{


    private Integer bookId;

    private String bookName;

    private int bookCost;

    private int numOfBooks;

    private Date bookDatePublish;

    private int authorauthorId;

    private int categorycategoryId;


    public Books() {
    }

    public Books(Integer bookId) {
        this.bookId = bookId;
    }

    public Books(Integer bookId, String bookName, int bookCost, int numOfBooks) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookCost = bookCost;
        this.numOfBooks = numOfBooks;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookCost() {
        return bookCost;
    }

    public void setBookCost(int bookCost) {
        this.bookCost = bookCost;
    }


    public int getNumOfBooks() {
        return numOfBooks;
    }

    public void setNumOfBooks(int numOfBooks) {
        this.numOfBooks = numOfBooks;
    }

    public Date getBookDatePublish() {
        return bookDatePublish;
    }

    public void setBookDatePublish(Date bookDatePublish) {
        this.bookDatePublish = bookDatePublish;
    }

    public int getAuthorauthorId() {
        return authorauthorId;
    }

    public void setAuthorauthorId(int authorauthorId) {
        this.authorauthorId = authorauthorId;
    }

    public int getCategorycategoryId() {
        return categorycategoryId;
    }

    public void setCategorycategoryId(int categorycategoryId) {
        this.categorycategoryId = categorycategoryId;
    }

    
}
