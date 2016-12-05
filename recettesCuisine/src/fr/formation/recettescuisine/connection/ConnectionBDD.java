/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.formation.recettescuisine.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class ConnectionBDD {

    public Connection openConnectionBDD() {

        Connection con = null;

        try {
            // chargement de la classe par son nom
            Class c = Class.forName("com.mysql.jdbc.Driver");
            Driver pilote = (Driver) c.newInstance();
            // enregistrement du pilote aupres du DriverManager
            DriverManager.registerDriver(pilote);
            // Protocole de connexion
            String protocole = "jdbc:mysql:";
            // Adresse IP de l’hôte de la base et port
            String ip = "localhost";  // depend du contexte
            String port = "8080";  // port MySQL par defaut
            // Nom de la base ;
            String nomBase = "recettes_cuisine";  // depend du contexte
            // Chaîne de connexion
            String conString = protocole + "//" + ip + ":" + port + "/" + nomBase;
            // Identifiants de connexion et mot de passe
            String nomConnexion = "root";  // depend du contexte
            String motDePasse = "";  // depend du contexte
            // Connexion
            System.out.println("Ouverture connexion BDD");
            con = DriverManager.getConnection(
                    conString, nomConnexion, motDePasse);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

    /**
     * Fermeture de la connexion passee en parametre
     *
     * @param connection
     */
    public void closeConnection(Connection connection) {

        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
