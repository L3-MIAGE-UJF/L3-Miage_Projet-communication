package dataFramework.contents;

/**
 * @author douchetm
 *
 */
public class TextContent extends GenericContent {
    /**
     * 
     */
    String content;
    
    /** Créé un nouveau TextContent
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