/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.formation.recettescuisine.dao;

import fr.formation.recettescuisine.pojo.PlatsPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class PlatsDAO {

    private static final String SQL_FIND_BY_RECETTES = "select * from recettes_cuisine.plats a where a.fk_id_recettes = ?";

    private static final String SQL_FIND_INGREDIENTS_BY_NOM = "select ingredients from recettes_cuisine.plats a where nom_plats = ?";
    private static final String SQL_INSERT_BDD = "INSERT INTO plats (id_plats, fk_id_recettes, nom_plats, ingredients) VALUES (?, ?, ?,?)";

    private static final String SQL_GROUPBY_INSERT_BDD = "SELECT max(id_plats) + 1 FROM recettes_cuisine.plats";
    private Connection connection;

    public PlatsDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Recuperation de la liste des plats
     *
     * @return
     */
    public List<PlatsPOJO> findByRecette(int idplats) {

        List<PlatsPOJO> listePlats = new ArrayList<PlatsPOJO>();

        try {
            PreparedStatement ps = connection.prepareStatement(SQL_FIND_BY_RECETTES);
            ps.setInt(1, idplats);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // creation d'un contacte correspondant à la ligne courante
                PlatsPOJO plats = new PlatsPOJO();
                plats.setIdPlats(rs.getInt("id_plats"));
                plats.setFkIdRecettes(rs.getInt("fk_id_recettes"));
                plats.setNomPlats(rs.getString("nom_plats"));
                plats.setIngredients(rs.getString("ingredients"));

                // Ajout d un plats precedemment cree dans la liste plats
                listePlats.add(plats);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listePlats;
    }

    public String findIngredientsByNom(String nom) {

        String ingredientsFound = null;

        try {
            PreparedStatement ps = connection.prepareStatement(SQL_FIND_INGREDIENTS_BY_NOM);
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
            ps.setInt(2, 3);
            ps.setString(3, nom);
            ps.setString(4, ingredients);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
