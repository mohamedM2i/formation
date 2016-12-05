/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.formation.annuaire.dao;

import fr.formation.annuaire.pojo.Arrondissement;
import fr.formation.annuaire.pojo.Contacte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO de la table des arrondissements
 *
 * @author Administrator
 */
public class ArrondissementDAO {

    // requête de recherche d'une liste de contacts par arrondissement
    private static final String SELECT_ALL = "SELECT * FROM annuaire_paris.arrondissemenents a";

    private static final String SELECT_ID_BY_NOM = "SELECT id_arrondissement FROM annuaire_paris.arrondissemenents a where nom_arrondissement = ?";

    private Connection connection;

    public ArrondissementDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Récupération de la liste des arrodissements
     *
     * @return
     */
    public List<Arrondissement> findAllArrondissement() {

        List<Arrondissement> listeArrondissement = new ArrayList<Arrondissement>();

        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // création d'un contacte correspondant à la ligne courante
                Arrondissement arrondissement = new Arrondissement();
                arrondissement.setIdArrondissement(rs.getInt("id_arrondissement"));
                arrondissement.setNomArrondissement(rs.getString("nom_arrondissement"));

                // Ajout du contacte précédemment créé dans la liste des contacts
                listeArrondissement.add(arrondissement);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listeArrondissement;
    }

    /**
     * récupère le id_arrondissement associé au nom passé en paramètre
     *
     * @param nom
     * @return
     */
    public int getIdFromNomArrondissement(String nomArrondissement) {

        int idArrondissement = 0;

        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ID_BY_NOM);
            ps.setString(1, nomArrondissement);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // création d'un contacte correspondant à la ligne courante
                idArrondissement = rs.getInt("id_arrondissement");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return idArrondissement;
    }
}
