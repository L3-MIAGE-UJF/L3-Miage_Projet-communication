package dataFramework.users;

import java.io.Serializable;

/**
 * @author groupe1
 *
 */
public class GenericUser implements Serializable{
    /**
     * 
     */
    int id; // Identifiant unique de l'utilisateur
    /**
     * 
     */
    String login; // Identifiant dans la conversation, peut ne pas être unique

    /**
     * @param id
     * @param login
     */
    public GenericUser(int id, String login) {
        this.id = id;
        this.login = login;
    }  
    
    /**
     * @param login
     */
    public GenericUser(String login){
    	this.login = login;
    }
    
    /**
     * @return
     */
    public int getId() {
        return this.id;
    }
        
    /**
     * @return
     */
    public String getLogin() {
        return this.login;
    }
    
    /**
     * @param id
     */
    public void setId(int id){
    	this.id = id;
    }
}