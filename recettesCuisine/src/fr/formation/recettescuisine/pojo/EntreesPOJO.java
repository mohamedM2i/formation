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
public class EntreesPOJO {

    private int idEntrees;

    private int fkIdRecettes;

    private String nomEntrees;

    private String ingredients;

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public int getIdEntrees() {
        return idEntrees;
    }

    public void setIdEntrees(int idEntrees) {
        this.idEntrees = idEntrees;
    }

    public int getFkIdRecettes() {
        return fkIdRecettes;
    }

    public void setFkIdRecettes(int fkIdRecettes) {
        this.fkIdRecettes = fkIdRecettes;
    }

    public String getNomEntrees() {
        return nomEntrees;
    }

    public void setNomEntrees(String nomEntrees) {
        this.nomEntrees = nomEntrees;
    }

}
