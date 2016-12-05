/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.formation.recettescuisine.dao;

import fr.formation.recettescuisine.pojo.AperitifsPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class AperitifsDAO {

    private static final String SQL_FIND_BY_RECETTES = "select * from recettes_cuisine.aperitifs a where a.fk_id_recettes = ?";

    private static final String SQL_FIND_INGREDIENTS_BY_NOM = "select ingredients from recettes_cuisine.aperitifs a where nom_aperitifs = ?";

    private static final String SQL_INSERT_BDD = "INSERT INTO aperitifs (id_aperitifs, fk_id_recettes, nom_aperitifs, ingredients) VALUES (?, ?, ?,?)";

    private static final String SQL_GROUPBY_INSERT_BDD = "SELECT max(id_aperitifs) + 1 FROM recettes_cuisine.aperitifs";

    private Connection connection;

    public AperitifsDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Recuperation de la liste des aperitifs
     *
     * @return
     */
    public List<AperitifsPOJO> findByRecette(int idAperitifs) {

        List<AperitifsPOJO> listeAperitifs = new ArrayList<AperitifsPOJO>();

        try {
            PreparedStatement ps = connection.prepareStatement(SQL_FIND_BY_RECETTES);
            ps.setInt(1, idAperitifs);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // creation d'un contacte correspondant à la ligne courante
                AperitifsPOJO aperitifs = new AperitifsPOJO();
                aperitifs.setIdAperitifs(rs.getInt("id_aperitifs"));
                aperitifs.setFkIdRecettes(rs.getInt("fk_id_recettes"));
                aperitifs.setNomAperitifs(rs.getString("nom_aperitifs"));
                aperitifs.setIngredients(rs.getString("ingredients"));

                // Ajout d un aperitifs precedemment cree dans la liste aperitifs
                listeAperitifs.add(aperitifs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listeAperitifs;
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

    /**
     * Méthode de récupération du max ID
     *
     * @return
     */
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

    // Methode insert recette sur table aperitifs
    public void ajoutRecette(String nom, String ingredients) {

        try {

            PreparedStatement ps = connection.prepareStatement(SQL_INSERT_BDD);
            ps.setInt(1, nextIdSelect());
            ps.setInt(2, 1);
            ps.setString(3, nom);
            ps.setString(4, ingredients);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
