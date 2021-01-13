/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;

/**
 *
 * @author Mahmoud
 */
public class Clients {

    private static final long serialVersionUID = 1L;

    private Integer clientid;
 
    private String clientEmail;


    private String clientName;
    
    private String clientAddres;
    
    private String clientPhone;

    private int numOfBooks;

    private Date dateOfSale;

    private int booksBookid;

    public Clients() {
    }

    public Clients(Integer clientid) {
        this.clientid = clientid;
    }

    public Clients(Integer clientid, String clientName, int numOfBooks, Date dateOfSale) {
        this.clientid = clientid;
        this.clientName = clientName;
        this.numOfBooks = numOfBooks;
        this.dateOfSale = dateOfSale;
    }

    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAddres() {
        return clientAddres;
    }

    public void setClientAddres(String clientAddres) {
        this.clientAddres = clientAddres;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public int getNumOfBooks() {
        return numOfBooks;
    }

    public void setNumOfBooks(int numOfBooks) {
        this.numOfBooks = numOfBooks;
    }

    public Date getDateOfSale() {
        return dateOfSale;
    }

    public void setDateOfSale(Date dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    public int getBooksBookid() {
        return booksBookid;
    }

    public void setBooksBookid(int booksBookid) {
        this.booksBookid = booksBookid;
    }


}
