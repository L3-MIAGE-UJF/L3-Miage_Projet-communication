package dataFramework.discussion;

import dataFramework.messages.GenericMessage;
import dataFramework.users.GenericUser;

/**
 * @author groupe1
 *
 * @param <UL>
 * @param <ML>
 * @param <M>
 */
public class GenericDiscussion<UL extends GenericUsersList, ML extends GenericMessagesList, M extends GenericMessage> {
    /**
     * 
     */
    protected UL usersList;
    /**
     * 
     */
    protected ML messagesList;
        
    /**
     * 
     */
    public GenericDiscussion(){
    	usersList = (UL) new GenericUsersList();
    	messagesList = (ML) new GenericMessagesList();
    }
    
    
    /** Créer une nouvelle discussion
     * @param users Liste d'utilisateurs
     * @param messages Liste de messages
     */
    public GenericDiscussion(UL users, ML messages) {
        this.usersList = users;
        this.messagesList = messages;
    }
    
    /** Permet de récupérer la liste des messages
     * @return Liste des messages de la discussion
     */
    public ML getMessages() {
        return messagesList;
    }
    
    /** Ajoute un message à la discussion
     * @param message Message à ajouter
     */
    public void add(M message) {
        this.messagesList.addMessage(message);
    }
    
    /** Permet de récupérer la liste des messages
     * @return Liste des utilisateurs de la discussion
     */
    public UL getUsers() {
        return usersList;
    }
    
    /** Ajoute un utilisateur a la discussion
     * @param str Le login du nouvel utilisateur
     */
    public void addUser(String str) {
    	int id = this.usersList.size()+1;
    	this.usersList.addUser(new GenericUser(id, str));
    }
    
    public String toString(){
    	return this.messagesList.toString();
    }
}