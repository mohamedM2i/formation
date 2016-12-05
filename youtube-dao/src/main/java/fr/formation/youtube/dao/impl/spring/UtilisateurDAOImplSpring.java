/*
 * Created on 17 Nov 2016 ( Time 21:47:06 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package fr.formation.youtube.dao.impl.spring;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.formation.youtube.bean.Utilisateur;
import fr.formation.youtube.dao.UtilisateurDAO;
import fr.formation.youtube.dao.impl.spring.commons.GenericDAO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Utilisateur DAO implementation 
 * 
 * @author Telosys Tools
 *
 */
@Repository
public class UtilisateurDAOImplSpring extends GenericDAO<Utilisateur> implements UtilisateurDAO {

	private final static String SQL_SELECT = 
		"select ID_UTILISATEUR, NOM_UTILISATEUR, PRENOM_UTILISATEUR, ADRESSE_UTILISATEUR, CODE_POSTAL_UTILISATEUR, VILLE_UTILISATEUR from utilisateur where ID_UTILISATEUR = ?";

	// NB : This entity has an auto-incremented primary key : "ID_UTILISATEUR"
	private final static String AUTO_INCREMENTED_COLUMN = "ID_UTILISATEUR";

	private final static int[] SQL_INSERT_TYPES = new int[] {
			java.sql.Types.VARCHAR ,  // "NOM_UTILISATEUR" : VARCHAR(45) - java.lang.String
			java.sql.Types.VARCHAR ,  // "PRENOM_UTILISATEUR" : VARCHAR(45) - java.lang.String
			java.sql.Types.VARCHAR ,  // "ADRESSE_UTILISATEUR" : VARCHAR(255) - java.lang.String
			java.sql.Types.VARCHAR ,  // "CODE_POSTAL_UTILISATEUR" : VARCHAR(5) - java.lang.String
			java.sql.Types.VARCHAR   // "VILLE_UTILISATEUR" : VARCHAR(45) - java.lang.String
	};

	private final static String SQL_INSERT = 
		"insert into utilisateur ( NOM_UTILISATEUR, PRENOM_UTILISATEUR, ADRESSE_UTILISATEUR, CODE_POSTAL_UTILISATEUR, VILLE_UTILISATEUR ) values ( ?, ?, ?, ?, ? )";

	private final static String SQL_UPDATE = 
		"update utilisateur set NOM_UTILISATEUR = ?, PRENOM_UTILISATEUR = ?, ADRESSE_UTILISATEUR = ?, CODE_POSTAL_UTILISATEUR = ?, VILLE_UTILISATEUR = ? where ID_UTILISATEUR = ?";

	private final static String SQL_DELETE = 
		"delete from utilisateur where ID_UTILISATEUR = ?";

	private final static String SQL_COUNT_ALL = 
		"select count(*) from utilisateur";

	private final static String SQL_COUNT = 
		"select count(*) from utilisateur where ID_UTILISATEUR = ?";

    //----------------------------------------------------------------------
	/**
	 * DAO constructor
	 */
	public UtilisateurDAOImplSpring() {
		super(AUTO_INCREMENTED_COLUMN, SQL_INSERT_TYPES);
	}

	//----------------------------------------------------------------------
	/* (non-Javadoc)
	 * DAO interface implementation
	 */
	@Override
	public Utilisateur find( Integer idUtilisateur ) {
		Object[] primaryKey = new Object[] { idUtilisateur };
		return super.doSelect(primaryKey);		
	}
	//----------------------------------------------------------------------
	/* (non-Javadoc)
	 * DAO interface implementation
	 */
	@Override
	public boolean load( Utilisateur utilisateur ) {
		return super.doSelect(utilisateur) ;
	}
	
    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * DAO interface implementation
	 */
	@Override
	public Integer insert(Utilisateur utilisateur) {
		Long key = super.doInsertAutoIncr(utilisateur);
		return key.intValue();
	}

    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * DAO interface implementation
	 */
	@Override
	public int update(Utilisateur utilisateur) {
		return super.doUpdate(utilisateur);
	}	

    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * DAO interface implementation
	 */
	@Override
	public int delete( Integer idUtilisateur ) {
		Object[] primaryKey = new Object[] { idUtilisateur };
		return super.doDelete(primaryKey);		
	}

    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * DAO interface implementation
	 */
	@Override
	public int delete( Utilisateur utilisateur ) {
		return super.doDelete(utilisateur);
	}

    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * DAO interface implementation
	 */
	@Override
	public boolean exists( Integer idUtilisateur ) {
		Object[] primaryKey = new Object[] { idUtilisateur };
		return super.doExists(primaryKey);
	}
    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * DAO interface implementation
	 */
	@Override
	public boolean exists( Utilisateur utilisateur ) {
		return super.doExists(utilisateur);
	}

    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * DAO interface implementation
	 */
	@Override
	public long count() {
		return super.doCountAll();
	}

    //----------------------------------------------------------------------
	// Super class abstract methods implementation
    //----------------------------------------------------------------------
	@Override
	protected String getSqlSelect() {
		return SQL_SELECT ;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlInsert() {
		return SQL_INSERT ;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlUpdate() {
		return SQL_UPDATE ;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlDelete() {
		return SQL_DELETE ;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlCount() {
		return SQL_COUNT ;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlCountAll() {
		return SQL_COUNT_ALL ;
	}
	//----------------------------------------------------------------------
	@Override
	protected Object[] getValuesForInsert(Utilisateur utilisateur)  {
		return new Object[] {
			//--- Returns PRIMARY KEY and DATA ( for SQL "SET x=?, y=?, ..." )
			// "ID_UTILISATEUR" is auto-incremented => no set in insert		
			utilisateur.getNomUtilisateur() , // "NOM_UTILISATEUR" : java.lang.String
			utilisateur.getPrenomUtilisateur() , // "PRENOM_UTILISATEUR" : java.lang.String
			utilisateur.getAdresseUtilisateur() , // "ADRESSE_UTILISATEUR" : java.lang.String
			utilisateur.getCodePostalUtilisateur() , // "CODE_POSTAL_UTILISATEUR" : java.lang.String
			utilisateur.getVilleUtilisateur()  // "VILLE_UTILISATEUR" : java.lang.String
		};
	}
    //----------------------------------------------------------------------
	@Override
	protected Object[] getValuesForUpdate(Utilisateur utilisateur) {
		return new Object[] {		
			//--- Returns DATA first ( for SQL "SET x=?, y=?, ..." )
			utilisateur.getNomUtilisateur(), // "NOM_UTILISATEUR" : java.lang.String
			utilisateur.getPrenomUtilisateur(), // "PRENOM_UTILISATEUR" : java.lang.String
			utilisateur.getAdresseUtilisateur(), // "ADRESSE_UTILISATEUR" : java.lang.String
			utilisateur.getCodePostalUtilisateur(), // "CODE_POSTAL_UTILISATEUR" : java.lang.String
			utilisateur.getVilleUtilisateur(), // "VILLE_UTILISATEUR" : java.lang.String
			//--- Returns PRIMARY KEY at the end ( for SQL "WHERE key=?, ..." )
			utilisateur.getIdUtilisateur()  // "ID_UTILISATEUR" : java.lang.Integer
		};
	}
	//----------------------------------------------------------------------
	@Override
	protected Object[] getValuesForPrimaryKey(Utilisateur utilisateur)  {
		return new Object[] {
			//--- Returns PRIMARY KEY values ( for SQL "WHERE key=?, ..." )
			utilisateur.getIdUtilisateur()  // "ID_UTILISATEUR" : java.lang.Integer
		};
	}
	//----------------------------------------------------------------------
	@Override
	protected RowMapper<Utilisateur> getRowMapper(Utilisateur o)  {
		//--- RowMapper to populate the given bean instance
		return new UtilisateurRowMapper(o) ;
	}
	//----------------------------------------------------------------------
	@Override
	protected RowMapper<Utilisateur> getRowMapper()  {
		//--- RowMapper to populate a new bean instance
		return new UtilisateurRowMapper( new Utilisateur() ) ;
	}

    //----------------------------------------------------------------------
	/**
	 * Populates the given bean with the data retrieved from the given ResultSet
	 * @param rs
	 * @param utilisateur
	 * @throws SQLException
	 */
	private void populateBean(ResultSet rs, Utilisateur utilisateur) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
		utilisateur.setIdUtilisateur(rs.getInt("ID_UTILISATEUR")); // java.lang.Integer
		if ( rs.wasNull() ) { utilisateur.setIdUtilisateur(null); }; // not primitive number => keep null value if any
		utilisateur.setNomUtilisateur(rs.getString("NOM_UTILISATEUR")); // java.lang.String
		utilisateur.setPrenomUtilisateur(rs.getString("PRENOM_UTILISATEUR")); // java.lang.String
		utilisateur.setAdresseUtilisateur(rs.getString("ADRESSE_UTILISATEUR")); // java.lang.String
		utilisateur.setCodePostalUtilisateur(rs.getString("CODE_POSTAL_UTILISATEUR")); // java.lang.String
		utilisateur.setVilleUtilisateur(rs.getString("VILLE_UTILISATEUR")); // java.lang.String
	}

    //----------------------------------------------------------------------
	/**
	 * Specific inner class for 'RowMapper' implementation
	 */
	private class UtilisateurRowMapper implements RowMapper<Utilisateur> {

		/**
		 * The bean instance that will be populated from the ResultSet
		 */
		private final Utilisateur bean ;
		
		/**
		 * Constructor
		 * @param bean the bean to be populated 
		 */
		UtilisateurRowMapper(Utilisateur bean) {
			this.bean = bean ;
		}
		
		@Override
		public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
			populateBean(rs, this.bean);
			return this.bean;
		}
	}
}
