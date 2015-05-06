package dataFramework.contents;

/**
 * @author groupe1
 *
 */
public abstract class FormatedTextContent extends GenericContent {
    /**
     * Contenu du message sous forme de texte potentiellement formate
     */
    String content;
    
    /** Cree un nouveau FormatedTextContent
     * @param content Le texte du message
     */
    public FormatedTextContent(String content) {
    	this.content=formatContent(content);
    }
    
    /**
     * 
     * @return Retourne le texte formate
     */
    public String getFormatedContent() {
    	return content;
    }
    
    protected abstract String formatContent(String content);
}