/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.formation.recettescuisine.dao;

import fr.formation.recettescuisine.pojo.RecettesPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class RecettesDAO {

    private static final String SELECT_ALL = "SELECT * FROM recettes_cuisine.recettes r";

    private static final String SELECT_ID_BY_NOM = "SELECT id_recettes FROM recettes_cuisine.recettes r where nom_recettes = ?";

    private Connection connection;

    public RecettesDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Recuperation de la liste des recettes
     *
     * @return
     */
    public List<RecettesPOJO> findAllRecettes() {

        List<RecettesPOJO> listeRecettes = new ArrayList<RecettesPOJO>();

        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // creation d'un contacte correspondant à la ligne courante
                RecettesPOJO recettes = new RecettesPOJO();
                recettes.setIdRecettes(rs.getInt("id_recettes"));
                recettes.setNomRecettes(rs.getString("nom_recettes"));

                // Ajout du contacte precedemment cree dans la liste des contacts
                listeRecettes.add(recettes);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listeRecettes;
    }

    /**
     * recupere le id_from nomrecettes associe au nom passe en parametre
     *
     * @param nom
     * @return
     */
    public int getIdFromNomRecettes(String nomRecettes) {

        int idRecettes = 0;

        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ID_BY_NOM);
            ps.setString(1, nomRecettes);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // creation d'un contacte correspondant à la ligne courante
                idRecettes = rs.getInt("id_recettes");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return idRecettes;
    }

}
