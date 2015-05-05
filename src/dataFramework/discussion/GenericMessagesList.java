package dataFramework.discussion;

import java.util.ArrayList;

import dataFramework.messages.GenericMessage;
import dataFramework.users.GenericUser;

/**
 * @author groupe1
 *
 * @param <M>
 */
public class GenericMessagesList<M extends GenericMessage> {
    private ArrayList<M> messagesList;
    
    /** Construit un nouveau GenericMessagesList
     */
    public GenericMessagesList() {
        messagesList = new ArrayList<>();
    }
    
    /** Ajoute un message à la liste
     * @param message Le message à ajouter
     */
    public void addMessage(M message) {
        messagesList.add(message);
    }
    
    /** Récupère la liste de messages
     * @return La liste des messages
     */
    public ArrayList<M> getAllMessages() {
        return messagesList;
    }
    
    /** Récupère les messages d'un utilisateur spécifique
     * @param user L'utilisateur recherché
     * @return Les messages de l'utilisateur
     */
    public ArrayList<M> getMessages(GenericUser user) {
        ArrayList<M> messages = new ArrayList<>();
        
        for(int i = 0; i < messagesList.size(); i++) {
        	if(messagesList.get(i).getSender().equals(user))
        		messages.add(messagesList.get(i));
        }
        
        return messages;
    }
    
    /** Permet de faire un affichage de la liste de messages
     * @return Une chaîne contenant la liste des messages mise en forme
     */
    @Override
    public String toString() {
        String result = "";
        for (M messagesList1 : messagesList) {
            result += messagesList1.toString() + "\n";
        }
        
        return result;
    }
}