/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.formation.annuaire.dao;

import fr.formation.annuaire.pojo.Contacte;
import fr.formation.annuaire.utils.ConnectionBDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO de la table Contacte
 *
 * @author Administrator
 */
public class ContacteDAO {

    // requête de recherche d'une liste de contacts par arrondissement
    private static final String SQL_FIND_BY_ARRONDISSEMENT = "select * from annuaire_paris.contacte c where c.fk_id_arrondissemenents = ?";

    private Connection connection;

    public ContacteDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Récupération de la liste des contactes par arrondissement
     *
     * @return
     */
    public List<Contacte> findByArrondissement(int idArrondissement) {

        List<Contacte> listeContacte = new ArrayList<Contacte>();

        try {
            PreparedStatement ps = connection.prepareStatement(SQL_FIND_BY_ARRONDISSEMENT);
            ps.setInt(1, idArrondissement);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // création d'un contacte correspondant à la ligne courante
                Contacte contacte = new Contacte();
                contacte.setIdContacte(rs.getInt("ID_CONTACTE"));
                contacte.setFkIdArrondissement(rs.getInt("fk_id_arrondissemenents"));
                contacte.setNomContacte(rs.getString("nom_contacte"));
                contacte.setPrenomContacte(rs.getString("prenom_contacte"));
                contacte.setAdresseContacte(rs.getString("adresse_contacte"));

                // Ajout du contacte précédemment créé dans la liste des contacts
                listeContacte.add(contacte);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listeContacte;
    }


}
