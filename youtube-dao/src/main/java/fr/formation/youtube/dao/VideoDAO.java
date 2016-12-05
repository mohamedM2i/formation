/*
 * Created on 17 Nov 2016 ( Time 21:47:06 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package fr.formation.youtube.dao;

import fr.formation.youtube.bean.Video;

/**
 * Video DAO interface
 * 
 * @author Telosys Tools
 */
public interface VideoDAO {

	//----------------------------------------------------------------------
	/**
	 * Finds a bean by its primary key 
	 * @param idVideo
	 * @return the bean found or null if not found 
	 */
	public Video find( Integer idVideo ) ;

	//----------------------------------------------------------------------
	/**
	 * Loads the given bean, it is supposed to contains the primary key value(s) in its attribute(s)<br>
	 * If found, the given instance is populated with the values retrieved from the database<br>
	 * If not found, the given instance remains unchanged
	 * @param video
	 * @return true if found, false if not found
	 */
	public boolean load( Video video ) ;
	
    //----------------------------------------------------------------------
	/**
	 * Inserts the given bean in the database 
	 * @param video
	 * @return the generated value for the auto-incremented column
	 */
	public Integer insert(Video video) ;

    //----------------------------------------------------------------------
	/**
	 * Updates the given bean in the database 
	 * @param video
	 * @return
	 */
	public int update(Video video) ;

    //----------------------------------------------------------------------
	/**
	 * Deletes the record in the database using the given primary key value(s) 
	 * @param idVideo
	 * @return
	 */
	public int delete( Integer idVideo ) ;

    //----------------------------------------------------------------------
	/**
	 * Deletes the given bean in the database 
	 * @param video
	 * @return
	 */
	public int delete( Video video ) ;

    //----------------------------------------------------------------------
	/**
	 * Checks the existence of a record in the database using the given primary key value(s)
	 * @param idVideo
	 * @return
	 */
	public boolean exists( Integer idVideo ) ;

	//----------------------------------------------------------------------
	/**
	 * Checks the existence of the given bean in the database 
	 * @param video
	 * @return
	 */
	public boolean exists( Video video ) ;

    //----------------------------------------------------------------------
	/**
	 * Counts all the records present in the database table
	 * @return
	 */
	public long count() ;

}
