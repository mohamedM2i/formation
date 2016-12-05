/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.formation.recettescuisine.dao;

import fr.formation.recettescuisine.pojo.DessertsPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class DessertsDAO {

    private static final String SQL_FIND_BY_RECETTE = "select * from recettes_cuisine.desserts a where a.fk_id_recettes = ?";
    private static final String SQL_FIND_INGREDIENTS_BY_NO = "select ingredients from recettes_cuisine.desserts a where nom_desserts = ?";
    private static final String SQL_INSERT_BDD = "INSERT INTO desserts (id_desserts, fk_id_recettes, nom_desserts, ingredients) VALUES (?, ?, ?,?)";

    private static final String SQL_GROUPBY_INSERT_BDD = "SELECT max(id_desserts) + 1 FROM recettes_cuisine.desserts";

    private Connection connection;

    public DessertsDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Recuperation de la liste des desserts.
     *
     * @return
     */
    public List<DessertsPOJO> findByDessertsPOJO(int idDesserts) {

        List<DessertsPOJO> listeDesserts = new ArrayList<DessertsPOJO>();

        try {
            PreparedStatement ps = connection.prepareStatement(SQL_FIND_BY_RECETTE);
            ps.setInt(1, idDesserts);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // creation d'une desserts correspondant à la ligne courante
                DessertsPOJO desserts = new DessertsPOJO();
                desserts.setIdDesserts(rs.getInt("id_desserts"));
                desserts.setFkIdRecettes(rs.getInt("fk_id_recettes"));
                desserts.setNomDesserts(rs.getString("nom_desserts"));
                desserts.setIngredients(rs.getString("ingredients"));

                // Ajout d une desserts precedemment cree dans la liste des desserts
                listeDesserts.add(desserts);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listeDesserts;
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
            ps.setInt(2, 4);
            ps.setString(3, nom);
            ps.setString(4, ingredients);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
