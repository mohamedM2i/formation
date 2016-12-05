/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.formation.annuaire.pojo;

/**
 * POJO de la table 
 * @author Administrator
 */
public class Contacte {
    
    private int idContacte;
    
    private int fkIdArrondissement;
    
    private String nomContacte;
    
    private String prenomContacte;
    
    private String adresseContacte;

    public int getIdContacte() {
        return idContacte;
    }

    public int getFkIdArrondissement() {
        return fkIdArrondissement;
    }

    public String getNomContacte() {
        return nomContacte;
    }

    public String getPrenomContacte() {
        return prenomContacte;
    }

    public String getAdresseContacte() {
        return adresseContacte;
    }

    public void setIdContacte(int idContacte) {
        this.idContacte = idContacte;
    }

    public void setFkIdArrondissement(int fkIdArrondissement) {
        this.fkIdArrondissement = fkIdArrondissement;
    }

    public void setNomContacte(String nomContacte) {
        this.nomContacte = nomContacte;
    }

    public void setPrenomContacte(String prenomContacte) {
        this.prenomContacte = prenomContacte;
    }

    public void setAdresseContacte(String adresseContacte) {
        this.adresseContacte = adresseContacte;
    }
    
    public String toString() {
        return this.nomContacte + " - " + this.prenomContacte + "\n";
    }

}
