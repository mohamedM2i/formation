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
public class AperitifsPOJO {

    private int idAperitifs;

    private int fkIdRecettes;

    private String nomAperitifs;

    private String ingredients;

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public int getFkIdRecettes() {
        return fkIdRecettes;
    }

    public void setFkIdRecettes(int fkIdRecettes) {
        this.fkIdRecettes = fkIdRecettes;
    }

    public int getIdAperitifs() {
        return idAperitifs;
    }

    public void setIdAperitifs(int idAperitifs) {
        this.idAperitifs = idAperitifs;
    }

    public String getNomAperitifs() {
        return nomAperitifs;
    }

    public void setNomAperitifs(String nomAperitifs) {
        this.nomAperitifs = nomAperitifs;
    }

}
