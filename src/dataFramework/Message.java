package dataFramework;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import dataFramework.contents.GenericContent;
import dataFramework.contents.TextContent;
import dataFramework.messages.GenericMessage;
import dataFramework.users.GenericUser;

/**
 * @author groupe1
 *
 */
public class Message extends GenericMessage<GenericUser, GenericContent> implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Le contenu du message.
	 */
	protected String msg;
    /**
     * Le nom de l'utilisateur ayant envoye le message.
     */
    protected Utilisateur user;
    /**
     * L'heure a laquelle a ete envoye le message.
     */
    protected String time;

    /** Cree un nouveau message.
     * @param msg Le contenu du message
     * @param user Le nom de l'utilisateur.
     */
    public Message(String msg, Utilisateur user) {
    	super(user,new TextContent(msg));
        this.msg = msg;
        this.user = user;
        SimpleDateFormat formater = null;
        formater = new SimpleDateFormat("H:mm:ss");
        this.time = formater.format(new Date());
    }

    /** Recupere le contenu du message.
     * @return le contenu du message.
     */
    public String getMessage() {
        return msg;
    }

    /** Recupere le nom de l'utilisateur.
     * @return l'utilisateur ayant envoye le message.
     */
    public Utilisateur getUser() {
        return user;
    }
   
    @Override
    public String toString() {
        return "[" + time + "] " + user.getLogin() + " : " + msg;
    }
}