/*
 * Created on 17 Nov 2016 ( Time 21:47:06 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package fr.formation.youtube.bean;

import java.io.Serializable;


/**
 * Java bean for 'Utilisateur' entity
 * 
 * @author Telosys Tools
 *
 */
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    // DB : ID_UTILISATEUR INT UNSIGNED 
    private Integer idUtilisateur;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    // DB : NOM_UTILISATEUR VARCHAR 
    private String nomUtilisateur;

    // DB : PRENOM_UTILISATEUR VARCHAR 
    private String prenomUtilisateur;

    // DB : ADRESSE_UTILISATEUR VARCHAR 
    private String adresseUtilisateur;

    // DB : CODE_POSTAL_UTILISATEUR VARCHAR 
    private String codePostalUtilisateur;

    // DB : VILLE_UTILISATEUR VARCHAR 
    private String villeUtilisateur;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setIdUtilisateur( Integer idUtilisateur ) {
        this.idUtilisateur = idUtilisateur ;
    }

    public Integer getIdUtilisateur() {
        return this.idUtilisateur;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setNomUtilisateur( String nomUtilisateur ) {
        this.nomUtilisateur = nomUtilisateur;
    }
    public String getNomUtilisateur() {
        return this.nomUtilisateur;
    }

    public void setPrenomUtilisateur( String prenomUtilisateur ) {
        this.prenomUtilisateur = prenomUtilisateur;
    }
    public String getPrenomUtilisateur() {
        return this.prenomUtilisateur;
    }

    public void setAdresseUtilisateur( String adresseUtilisateur ) {
        this.adresseUtilisateur = adresseUtilisateur;
    }
    public String getAdresseUtilisateur() {
        return this.adresseUtilisateur;
    }

    public void setCodePostalUtilisateur( String codePostalUtilisateur ) {
        this.codePostalUtilisateur = codePostalUtilisateur;
    }
    public String getCodePostalUtilisateur() {
        return this.codePostalUtilisateur;
    }

    public void setVilleUtilisateur( String villeUtilisateur ) {
        this.villeUtilisateur = villeUtilisateur;
    }
    public String getVilleUtilisateur() {
        return this.villeUtilisateur;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(idUtilisateur);
        sb.append("|");
        sb.append(nomUtilisateur);
        sb.append("|");
        sb.append(prenomUtilisateur);
        sb.append("|");
        sb.append(adresseUtilisateur);
        sb.append("|");
        sb.append(codePostalUtilisateur);
        sb.append("|");
        sb.append(villeUtilisateur);
        return sb.toString(); 
    } 


}
