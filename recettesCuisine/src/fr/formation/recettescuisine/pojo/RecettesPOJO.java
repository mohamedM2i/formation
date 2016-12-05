/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.formation.recettescuisine.pojo;

/**
 *
 * @author Administrator
 */
public class RecettesPOJO {

    private int idRecettes;

    private String nomRecettes;

    public int getIdRecettes() {
        return idRecettes;
    }

    public void setIdRecettes(int idRecettes) {
        this.idRecettes = idRecettes;
    }

    public String getNomRecettes() {
        return nomRecettes;
    }

    public void setNomRecettes(String nomRecettes) {
        this.nomRecettes = nomRecettes;
    }

    public String toString() {
        return this.nomRecettes;
    }

}
