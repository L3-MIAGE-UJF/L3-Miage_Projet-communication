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

    
    
    /** Cree un GenericMessage
     * @param sender Expediteur du message
     * @param content Contenu du message
     */
    public GenericMessage(U sender, C content) {
        this.sender = sender;
        this.content = content;
        SimpleDateFormat format = new SimpleDateFormat("H:mm:ss");
        this.time = format.format(new Date());
    }

    /** Cree un GenericMessage
     * @param receiver
     * @param content Contenu du message
     */
    /*public GenericMessage(R receiver, C content) {
        this.receiver = receiver;
        SimpleDateFormat format = new SimpleDateFormat("H:mm:ss");
        this.time = format.format(new Date());
    }*/

    /** Permet de recuperer l'expediteur
     * @return L'expediteur du message
     */           
    public U getSender() {
        return sender;
    }

    /** Permet de recuperer le recepteur
     * @return Le recepteur du message
     */
    /*public R getReceiver() {
        return receiver;
    }*/

    /** Permet de recuperer le contenu du message
     * @return Le contenu du message
     */
    public C getContent() {
        return content;
    }

    /** Permet de recuperer l'heure de creation du message
     * @return L'heure du message
     */
    public String getTime() {
        return time;
    }

    /** Affiche le message avec son heure et son expediteur
     * @return Le message
     */
    @Override
    public String toString() {
        return "[" + time + "] " + sender.getLogin() + " : " + content.toString();
    }
}