package dataFramework.messages;

import dataFramework.contents.GenericContent;
import dataFramework.users.GenericUser;

/**
 * @author groupe1
 *
 */
public class PrivateMessage extends GenericMessage {
    protected GenericUser receiver;

    /** Cree un PrivateMessage
     * @param sender Expediteur du message
     * @param receiver Recepteur du message
     * @param content Contenu du message
     */
    public PrivateMessage(GenericUser sender, GenericUser receiver, GenericContent content) {
        super(sender, content);
        this.receiver = receiver;
    }

    /** Recupere le destinaire du message
     * @return Le destinataire
     */
    public GenericUser getReceiver() {
        return receiver;
    }

    /** Affiche le message avec son heure, son expediteur et son destinataire
     * @return Le message
     */
    @Override
    public String toString() {
        return "[" + time + "] " + sender.getLogin() + " à " + receiver.getLogin() + " : " + content.toString();
    }    
}