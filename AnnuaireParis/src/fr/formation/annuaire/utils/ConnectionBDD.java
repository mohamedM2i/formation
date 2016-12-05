/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.formation.annuaire.utils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe de création d'une connexion
 *
 * @author Administrator
 */
public class ConnectionBDD {

    /**
     * Ouverture Connexion
     */
    public Connection openConnectionBDD() {

        Connection con = null;
 
        try {
            // chargement de la classe par son nom
            Class c = Class.forName("com.mysql.jdbc.Driver");
            Driver pilote = (Driver) c.newInstance();
            // enregistrement du pilote auprès du DriverManager
            DriverManager.registerDriver(pilote);
            // Protocole de connexion
            String protocole = "jdbc:mysql:";
            // Adresse IP de l’hôte de la base et port
            String ip = "localhost";  // dépend du contexte
            String port = "8080";  // port MySQL par défaut
            // Nom de la base ;
            String nomBase = "annuaire_paris";  // dépend du contexte
            // Chaîne de connexion
            String conString = protocole + "//" + ip + ":" + port + "/" + nomBase;
            // Identifiants de connexion et mot de passe
            String nomConnexion = "root";  // dépend du contexte
            String motDePasse = "";  // dépend du contexte
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
     * Fermeture de la connexion passée en paramètre
     * @param connection 
     */
    public void closeConnection(Connection connection) {
        
        try {
            connection.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
