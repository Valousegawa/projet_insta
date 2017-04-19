package com.a2017.dev.insta.insta.model;

/**
 * Created by s.mines on 19/04/2017.
 */

public class Salon {
    private int id;
    private String name;
    private String adresse;
    private String date;
    private int is_active;

    public Salon() {
    }

    public Salon(int id, String nom, String adresse, String date, int is_active) {
        this.id = id;
        this.name = nom;
        this.adresse = adresse;
        this.date = date;
        this.is_active = is_active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return name;
    }

    public void setNom(String nom) {
        this.name = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int is_active() {
        return is_active;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
    }
}
