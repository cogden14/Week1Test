/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day1;

/**
 *
 * @author coleogden
 */
public class BookAuthor {
    private String title;
    private String content;
    private String fontStyle;
    private String fileName;
    
    public BookAuthor(String title, String content, String fontStyle, String fileName) {
        this.title = title;
        this.content = content;
        this.fontStyle = fontStyle;
        this.fileName = fileName;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFontStyle() {
        return fontStyle;
    }

    public void setFontStyle(String fontStyle) {
        this.fontStyle = fontStyle;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
