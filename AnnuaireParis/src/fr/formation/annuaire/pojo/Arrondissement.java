/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.formation.annuaire.pojo;

/**
 * POJO de la table Arrondissement
 * @author Administrator
 */
public class Arrondissement {
    
    private int idArrondissement;
    
    private String nomArrondissement;

    public int getIdArrondissement() {
        return idArrondissement;
    }

    public String getNomArrondissement() {
        return nomArrondissement;
    }

    public void setIdArrondissement(int idArrondissement) {
        this.idArrondissement = idArrondissement;
    }

    public void setNomArrondissement(String nomArrondissement) {
        this.nomArrondissement = nomArrondissement;
    }
 
    public String toString() {
        return this.nomArrondissement;
    }
    
    
}
