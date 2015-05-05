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

    /** Cree un nouveau GenericUser.
     * @param id L'id de l'utilisateur.
     * @param login Le nom de l'utilisateur.
     */
    public GenericUser(int id, String login) {
        this.id = id;
        this.login = login;
    }  
    
    /** Cree un nouveau GenericUser
     * @param login Le nom de l'utilisateur.
     */
    public GenericUser(String login){
    	this.login = login;
    }
    
    /** Recupere l'id de l'utilisateur.
     * @return L'id de l'utilisateur.
     */
    public int getId() {
        return this.id;
    }
        
    /** Recupere le login de l'utilisateur.
     * @return Le login de l'utilisateur.
     */
    public String getLogin() {
        return this.login;
    }
    
    /** Assigne un id a l'utilisateur.
     * @param id Le numero d'utilisateur.
     */
    public void setId(int id){
    	this.id = id;
    }
}