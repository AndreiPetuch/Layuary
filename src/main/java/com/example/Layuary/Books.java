package com.example.Layuary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    public String namebooks;
    public String genre;

    public Books() {

    }

    public Books(String namebooks, String genre) {
        this.namebooks = namebooks;
        this.genre = genre;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamebooks() {
        return namebooks;
    }

    public void setNamebooks(String namebooks) {
        this.namebooks = namebooks;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
