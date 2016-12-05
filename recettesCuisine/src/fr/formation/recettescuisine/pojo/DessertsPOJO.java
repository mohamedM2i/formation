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
public class DessertsPOJO {

    private int idDesserts;

    private int fkIdRecettes;

    private String nomDesserts;

    private String ingredients;

    public int getIdDesserts() {
        return idDesserts;
    }

    public void setIdDesserts(int idDesserts) {
        this.idDesserts = idDesserts;
    }

    public int getFkIdRecettes() {
        return fkIdRecettes;
    }

    public void setFkIdRecettes(int fkIdRecettes) {
        this.fkIdRecettes = fkIdRecettes;
    }

    public String getNomDesserts() {
        return nomDesserts;
    }

    public void setNomDesserts(String nomDesserts) {
        this.nomDesserts = nomDesserts;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

}
