/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.formation.recettescuisine.dao;

import fr.formation.recettescuisine.pojo.EntreesPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class EntreesDAO {

    private static final String SQL_FIND_BY_RECETTE = "select * from recettes_cuisine.entrees a where a.fk_id_recettes = ?";
    private static final String SQL_FIND_INGREDIENTS_BY_NO = "select ingredients from recettes_cuisine.entrees a where nom_entrees = ?";
    private static final String SQL_INSERT_BDD = "INSERT INTO entrees (id_entrees, fk_id_recettes, nom_entrees, ingredients) VALUES (?, ?, ?,?)";

    private static final String SQL_GROUPBY_INSERT_BDD = "SELECT max(id_entrees) + 1 FROM recettes_cuisine.entrees";
    private Connection connection;

    public EntreesDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Recuperation de la liste des entrees.
     *
     * @return
     */
    public List<EntreesPOJO> findByEntreesPOJOs(int idEntrees) {

        List<EntreesPOJO> listeEntrees = new ArrayList<EntreesPOJO>();

        try {
            PreparedStatement ps = connection.prepareStatement(SQL_FIND_BY_RECETTE);
            ps.setInt(1, idEntrees);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // creation d'une entrees correspondant à la ligne courante
                EntreesPOJO entrees = new EntreesPOJO();
                entrees.setIdEntrees(rs.getInt("id_entrees"));
                entrees.setFkIdRecettes(rs.getInt("fk_id_recettes"));
                entrees.setNomEntrees(rs.getString("nom_entrees"));
                entrees.setIngredients(rs.getString("ingredients"));

                // Ajout d une entrees precedemment cree dans la liste des entrees
                listeEntrees.add(entrees);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listeEntrees;
    }

    public String findIngredientsByNom(String nom) {

        String ingredientsFound = null;

        try {
            PreparedStatement ps = connection.prepareStatement(SQL_FIND_INGREDIENTS_BY_NO);
            ps.setString(1, nom);

            ResultSet rs = ps.executeQuery();

            // 1 seul résultat
            if (rs.next()) {
                ingredientsFound = rs.getString("ingredients");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ingredientsFound;
    }

    public int nextIdSelect() {

        int idNext = 0;

        try {

            PreparedStatement ps = connection.prepareStatement(SQL_GROUPBY_INSERT_BDD);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                idNext = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return idNext;
    }

    public void ajoutRecette(String nom, String ingredients) {

        try {

            PreparedStatement ps = connection.prepareStatement(SQL_INSERT_BDD);
            ps.setInt(1, nextIdSelect());
            ps.setInt(2, 2);
            ps.setString(3, nom);
            ps.setString(4, ingredients);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
