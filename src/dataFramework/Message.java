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
	 * 
	 */
	protected String msg;
    /**
     * 
     */
    protected Utilisateur user;
    /**
     * 
     */
    protected String time;

    /**
     * @param msg
     * @param user
     */
    public Message(String msg, Utilisateur user) {
    	super(user,new TextContent(msg));
        this.msg = msg;
        this.user = user;
        SimpleDateFormat formater = null;
        formater = new SimpleDateFormat("H:mm:ss");
        this.time = formater.format(new Date());
    }

    /**
     * @return
     */
    public String getMessage() {
        return msg;
    }

    /**
     * @return
     */
    public Utilisateur getUser() {
        return user;
    }
   
    @Override
    public String toString() {
        return "[" + time + "] " + user.getLogin() + " : " + msg;
    }
}