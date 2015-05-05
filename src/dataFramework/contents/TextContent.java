package dataFramework.contents;

/**
 * @author groupe1
 *
 */
public class TextContent extends GenericContent {
    /**
     * 
     */
    String content;
    
    /** Cree un nouveau TextContent
     * @param content Le texte du message
     */
    public TextContent(String content) {
        this.content = content;
    }
    
    public String getContent() {
    	return content;
    }

    @Override
    public String toString() {
        return content;
    }
}