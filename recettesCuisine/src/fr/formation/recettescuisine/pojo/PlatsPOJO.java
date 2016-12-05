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
public class PlatsPOJO {

    private int idPlats;

    private int fkIdRecettes;

    private String nomPlats;

    private String ingredients;

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public int getIdPlats() {
        return idPlats;
    }

    public void setIdPlats(int idPlats) {
        this.idPlats = idPlats;
    }

    public int getFkIdRecettes() {
        return fkIdRecettes;
    }

    public void setFkIdRecettes(int fkIdRecettes) {
        this.fkIdRecettes = fkIdRecettes;
    }

    public String getNomPlats() {
        return nomPlats;
    }

    public void setNomPlats(String nomPlats) {
        this.nomPlats = nomPlats;
    }

}
