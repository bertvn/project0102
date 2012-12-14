import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

public class TextDisplay extends Actor{
    private GreenfootImage image;
    private Font font;
    private Color fontColor;
    private Color borderColor;
    private Color backgroundColor;

    private String theGreenfootImage;
    private float fontSize;
    private int fieldWidth;
    private int fieldHeight;
    private int drawStringX;
    private int drawStringY;
    private int borderHeight;
    private int borderWidth;
    
    
    public TextDisplay(){
        // Default values for all TextDisplays
        fontSize = 20.0f;
        fontColor = new Color(0, 0, 0, 0);
        fieldWidth = 100;
        fieldHeight = 100;
        drawStringX = 0;
        drawStringY = 0;
        
        // TextDisplays' TextArea specifics
        borderWidth = 5;
        borderHeight = 5;
        borderColor = new Color(0, 0, 0, 128);
        backgroundColor = new Color (255, 255, 255, 128);
    }
    
    public void setFontSize(float fontSize){
        this.fontSize = fontSize;
    }

    public void setFieldWidth(int fieldWidth){
        this.fieldWidth = fieldWidth;
    }
    
    public void setFieldHeight(int fieldHeight){
        this.fieldHeight = fieldHeight;
    }
    
    public void setBorderHeight(int borderHeight){
        this.borderHeight = borderHeight;
    }
    
    public void setBorderWidth(int borderWidth){
        this.borderWidth = borderWidth;
    }
    
    public void setDrawStringX(int drawStringX){
        this.drawStringX = drawStringX;
    }
    
    public void setDrawStringY(int drawStringY){
        this.drawStringY = drawStringY;
    }
    
    public void setFontColor(int red, int green, int blue, int alpha){
        if(isTheColorInputCorrect(red, green, blue, alpha)){
            fontColor = new Color(red, green, blue, alpha); 
        }
    }
    
    public void setBorderColor(int red, int green, int blue, int alpha){
        if(isTheColorInputCorrect(red, green, blue, alpha)){
            borderColor = new Color(red, green, blue, alpha); 
        }
    }
    
    public void setBackgroundColor(int red, int green, int blue, int alpha){
        if(isTheColorInputCorrect(red, green, blue, alpha)){
            backgroundColor = new Color(red, green, blue, alpha); 
        }
    }
    
    public void setTheGreenfootImage(String value){
        theGreenfootImage = value;
    }
    
    public boolean isTheColorInputCorrect(int red, int green, int blue, int alpha){
        if(red > 255 || green > 255 || blue > 255 || alpha > 255){
            System.out.println("Values should be equal or smaller then 255.");
            return false;
        }else if(red < 0 || green < 0 || blue < 0 || alpha < 0){
            System.out.println("Values should be equal or bigger then 0.");
            return false;
        }else{
            return true;
        }
    }
    
    public void createAreaWithBorder(int borderWidth, int borderHeight){
        image.setColor(borderColor);
        image.fillRect(0, 0, fieldWidth, fieldHeight);
        
        //image.setColor(backgroundColor);
        //image.fillRect(borderWidth, borderHeight, fieldWidth - (borderWidth * 2), fieldHeight - (borderHeight * 2));
    }
    
    public void createAreaWithoutBorder(){
        image.setColor(backgroundColor);
        image.fillRect(0, 0, fieldWidth, fieldHeight);
    }
    
    // Use the TextBox to create a simple piece of text.
    public void createTextBox(String input){
        if(theGreenfootImage != null){
            image = new GreenfootImage(theGreenfootImage);
        }else{
            image = new GreenfootImage(fieldWidth, fieldHeight);
        }
        font = image.getFont();
        font = font.deriveFont(fontSize);
        image.setFont(font);
        image.setColor(fontColor);
        
        image.drawString("test", drawStringX, drawStringY);
        debug();
        System.out.println("input = " + input);
    }
    
    // Use the TextArea to create a piece of text in an area (with background)
    public void createTextArea(String input) {       
        if(borderWidth == 0 || borderHeight == 0){
            createAreaWithoutBorder();
        }else{
            createAreaWithBorder(borderWidth, borderHeight);
        } 
        
        createTextBox(input);
    }
    
    public void placeImage(){
       setImage(image);
    }
    
    public void debug(){
        System.out.println("image = " + image);
        System.out.println("font = " + font);
        System.out.println("fontColor = " + fontColor);
        System.out.println("borderColor = " + borderColor);
        System.out.println("backgroundColor = " + backgroundColor);
        System.out.println("theGreenfootImage = " + theGreenfootImage);
        System.out.println("fontSize = " + fontSize);
        System.out.println("fieldWidth = " + fieldWidth);
        System.out.println("fieldHeight = " + fieldHeight);
        System.out.println("drawStringX = " + drawStringX);
        System.out.println("drawStringY = " + drawStringY);
        System.out.println("borderHeight = " + borderHeight);
        System.out.println("borderWidth = " + borderWidth);
    }
}
