package dataFramework.messages;

import java.text.SimpleDateFormat;
import java.util.Date;

import dataFramework.contents.GenericContent;
import dataFramework.users.GenericUser;

/**
 * @author groupe1
 *
 * @param <U>
 * @param <C>
 */
public class GenericMessage<U extends GenericUser, C extends GenericContent> {
    protected U sender = null; //Expediteur
    protected C content; //Contenu du message
    protected String time; //Heure du message

    
    
    /** Créé un GenericMessage
     * @param sender Expéditeur du message
     * @param content Contenu du message
     */
    public GenericMessage(U sender, C content) {
        this.sender = sender;
        this.content = content;
        SimpleDateFormat format = new SimpleDateFormat("H:mm:ss");
        this.time = format.format(new Date());
    }

    /** Créé un GenericMessage
     * @param receiver
     * @param content Contenu du message
     */
    /*public GenericMessage(R receiver, C content) {
        this.receiver = receiver;
        SimpleDateFormat format = new SimpleDateFormat("H:mm:ss");
        this.time = format.format(new Date());
    }*/

    /** Permet de récupérer l'expéditeur
     * @return L'expéditeur du message
     */           
    public U getSender() {
        return sender;
    }

    /** Permet de récupérer le récepteur
     * @return Le récepteur du message
     */
    /*public R getReceiver() {
        return receiver;
    }*/

    /** Permet de récupérer le contenu du message
     * @return Le contenu du message
     */
    public C getContent() {
        return content;
    }

    /** Permet de récupérer l'heure de création du message
     * @return L'heure du message
     */
    public String getTime() {
        return time;
    }

    /** Affiche le message avec son heure et son expéditeur
     * @return Le message
     */
    @Override
    public String toString() {
        return "[" + time + "] " + sender.getLogin() + " : " + content.toString();
    }
}