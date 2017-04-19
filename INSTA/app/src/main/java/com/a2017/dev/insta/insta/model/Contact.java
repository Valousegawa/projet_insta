package com.a2017.dev.insta.insta.model;

/**
 * Created by s.mines on 18/04/2017.
 */

public class Contact {

    private int id;
    private int idSalon;
    private String nom;
    private String prenom;
    private String adresse;
    private String codePostal;
    private String ville;
    private String numTel;
    private String numMobile;
    private String email;
    private String dateNaissance;
    private String formationActuellle;
    private String[] diplome;
    private String formationSouhaitee;

    public Contact(){

    }

    public Contact(String nom, String prenom, String adresse, String codePostal, String ville,
                   String numTel, String numMobile, String email, String dateNaissance,
                   String formationActuellle, String[] diplome, String formationSouhaitee) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.numTel = numTel;
        this.numMobile = numMobile;
        this.email = email;
        this.dateNaissance = dateNaissance;
        this.formationActuellle = formationActuellle;
        this.diplome = diplome;
        this.formationSouhaitee = formationSouhaitee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(int idSalon) {
        this.idSalon = idSalon;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getNumMobile() {
        return numMobile;
    }

    public void setNumMobile(String numMobile) {
        this.numMobile = numMobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getFormationActuellle() {
        return formationActuellle;
    }

    public void setFormationActuellle(String formationActuellle) {
        this.formationActuellle = formationActuellle;
    }

    public String[] getDiplome() {
        return diplome;
    }

    public void setDiplome(String[] diplome) {
        this.diplome = diplome;
    }

    public String getFormationSouhaitee() {
        return formationSouhaitee;
    }

    public void setFormationSouhaitee(String formationSouhaitee) {
        this.formationSouhaitee = formationSouhaitee;
    }
}
