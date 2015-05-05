package dataFramework.contents;

import java.io.File;

/**
 * @author groupe1
 *
 */
public class FileContent extends TextContent {
    /**
     * 
     */
    protected File file;

    /** Crée un nouveau FileContent
     * @param content Texte du message
     * @param file Fichier joint au message
     */ 
    public FileContent(String content, File file) {
        super(content);
        this.file = file;
    }

    /** Récupère le fichier du TextContent
     * @return Le fichier associé au TextContent
     */
    public File getFile() {
        return file;
    }
}