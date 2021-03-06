/*
 * Created on 17 Nov 2016 ( Time 21:47:06 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package fr.formation.youtube.dao.impl.spring;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.formation.youtube.bean.Video;
import fr.formation.youtube.dao.VideoDAO;
import fr.formation.youtube.dao.impl.spring.commons.GenericDAO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Video DAO implementation 
 * 
 * @author Telosys Tools
 *
 */
@Repository
public class VideoDAOImplSpring extends GenericDAO<Video> implements VideoDAO {

	private final static String SQL_SELECT = 
		"select ID_VIDEO, NOM_VIDEO from video where ID_VIDEO = ?";

	// NB : This entity has an auto-incremented primary key : "ID_VIDEO"
	private final static String AUTO_INCREMENTED_COLUMN = "ID_VIDEO";

	private final static int[] SQL_INSERT_TYPES = new int[] {
			java.sql.Types.VARCHAR   // "NOM_VIDEO" : VARCHAR(45) - java.lang.String
	};

	private final static String SQL_INSERT = 
		"insert into video ( NOM_VIDEO ) values ( ? )";

	private final static String SQL_UPDATE = 
		"update video set NOM_VIDEO = ? where ID_VIDEO = ?";

	private final static String SQL_DELETE = 
		"delete from video where ID_VIDEO = ?";

	private final static String SQL_COUNT_ALL = 
		"select count(*) from video";

	private final static String SQL_COUNT = 
		"select count(*) from video where ID_VIDEO = ?";

    //----------------------------------------------------------------------
	/**
	 * DAO constructor
	 */
	public VideoDAOImplSpring() {
		super(AUTO_INCREMENTED_COLUMN, SQL_INSERT_TYPES);
	}

	//----------------------------------------------------------------------
	/* (non-Javadoc)
	 * DAO interface implementation
	 */
	@Override
	public Video find( Integer idVideo ) {
		Object[] primaryKey = new Object[] { idVideo };
		return super.doSelect(primaryKey);		
	}
	//----------------------------------------------------------------------
	/* (non-Javadoc)
	 * DAO interface implementation
	 */
	@Override
	public boolean load( Video video ) {
		return super.doSelect(video) ;
	}
	
    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * DAO interface implementation
	 */
	@Override
	public Integer insert(Video video) {
		Long key = super.doInsertAutoIncr(video);
		return key.intValue();
	}

    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * DAO interface implementation
	 */
	@Override
	public int update(Video video) {
		return super.doUpdate(video);
	}	

    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * DAO interface implementation
	 */
	@Override
	public int delete( Integer idVideo ) {
		Object[] primaryKey = new Object[] { idVideo };
		return super.doDelete(primaryKey);		
	}

    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * DAO interface implementation
	 */
	@Override
	public int delete( Video video ) {
		return super.doDelete(video);
	}

    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * DAO interface implementation
	 */
	@Override
	public boolean exists( Integer idVideo ) {
		Object[] primaryKey = new Object[] { idVideo };
		return super.doExists(primaryKey);
	}
    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * DAO interface implementation
	 */
	@Override
	public boolean exists( Video video ) {
		return super.doExists(video);
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
	protected Object[] getValuesForInsert(Video video)  {
		return new Object[] {
			//--- Returns PRIMARY KEY and DATA ( for SQL "SET x=?, y=?, ..." )
			// "ID_VIDEO" is auto-incremented => no set in insert		
			video.getNomVideo()  // "NOM_VIDEO" : java.lang.String
		};
	}
    //----------------------------------------------------------------------
	@Override
	protected Object[] getValuesForUpdate(Video video) {
		return new Object[] {		
			//--- Returns DATA first ( for SQL "SET x=?, y=?, ..." )
			video.getNomVideo(), // "NOM_VIDEO" : java.lang.String
			//--- Returns PRIMARY KEY at the end ( for SQL "WHERE key=?, ..." )
			video.getIdVideo()  // "ID_VIDEO" : java.lang.Integer
		};
	}
	//----------------------------------------------------------------------
	@Override
	protected Object[] getValuesForPrimaryKey(Video video)  {
		return new Object[] {
			//--- Returns PRIMARY KEY values ( for SQL "WHERE key=?, ..." )
			video.getIdVideo()  // "ID_VIDEO" : java.lang.Integer
		};
	}
	//----------------------------------------------------------------------
	@Override
	protected RowMapper<Video> getRowMapper(Video o)  {
		//--- RowMapper to populate the given bean instance
		return new VideoRowMapper(o) ;
	}
	//----------------------------------------------------------------------
	@Override
	protected RowMapper<Video> getRowMapper()  {
		//--- RowMapper to populate a new bean instance
		return new VideoRowMapper( new Video() ) ;
	}

    //----------------------------------------------------------------------
	/**
	 * Populates the given bean with the data retrieved from the given ResultSet
	 * @param rs
	 * @param video
	 * @throws SQLException
	 */
	private void populateBean(ResultSet rs, Video video) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
		video.setIdVideo(rs.getInt("ID_VIDEO")); // java.lang.Integer
		if ( rs.wasNull() ) { video.setIdVideo(null); }; // not primitive number => keep null value if any
		video.setNomVideo(rs.getString("NOM_VIDEO")); // java.lang.String
	}

    //----------------------------------------------------------------------
	/**
	 * Specific inner class for 'RowMapper' implementation
	 */
	private class VideoRowMapper implements RowMapper<Video> {

		/**
		 * The bean instance that will be populated from the ResultSet
		 */
		private final Video bean ;
		
		/**
		 * Constructor
		 * @param bean the bean to be populated 
		 */
		VideoRowMapper(Video bean) {
			this.bean = bean ;
		}
		
		@Override
		public Video mapRow(ResultSet rs, int rowNum) throws SQLException {
			populateBean(rs, this.bean);
			return this.bean;
		}
	}
}
