package dataFramework;

import java.io.Serializable;

import dataFramework.users.GenericUser;

/**
 * @author groupe1
 *
 */
public class Utilisateur extends GenericUser implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

   
    /**
     * @param id
     * @param pseudo
     */
    public Utilisateur(int id,String pseudo) {
    	super(id,pseudo);
    }
   

}