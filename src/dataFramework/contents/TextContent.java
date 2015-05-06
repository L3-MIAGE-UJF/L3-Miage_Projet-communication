package dataFramework.contents;

/**
 * @author groupe1
 *
 */
public class TextContent extends GenericContent {
    /**
     * Contenu du message sous forme de texte
     */
    String content;
    
    /** Cree un nouveau TextContent
     * @param content Le texte du message
     */
    public TextContent(String content) {
        this.content = content;
    }
    

    @Override
    public String toString() {
        return content;
    }
}