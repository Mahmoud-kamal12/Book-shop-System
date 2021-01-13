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

public class Author {



    private Integer authorId;

    private String authorName;

    private String authorEmail;

    private String authorCity;

    private Date authorDB;

    public Author() {
    }

    public Author(Integer authorId) {
        this.authorId = authorId;
    }

    public Author(Integer authorId, String authorName, String authorEmail, String authorCity, Date authorDB) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorEmail = authorEmail;
        this.authorCity = authorCity;
        this.authorDB = authorDB;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String getAuthorCity() {
        return authorCity;
    }

    public void setAuthorCity(String authorCity) {
        this.authorCity = authorCity;
    }

    public Date getAuthorDB() {
        return authorDB;
    }

    public void setAuthorDB(Date authorDB) {
        this.authorDB = authorDB;
    }

}
