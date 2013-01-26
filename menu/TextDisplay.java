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
    private String input;
    private float fontSize;
    private int fieldWidth;
    private int fieldHeight;
    private int drawStringX;
    private int drawStringY;
    private int borderHeight;
    private int borderWidth;
    private boolean hasBackground;
    
    public TextDisplay(){
        // Default values for all TextDisplays 
        fontSize = 20.0f;
        fontColor = new Color(0, 0, 0);
        fieldWidth = 100;
        fieldHeight = 30;
        drawStringX = 0;
        drawStringY = 15;
        input = "";
        hasBackground = false;
        
        // TextDisplays' TextArea specifics
        borderWidth = 5;
        borderHeight = 5;
        borderColor = new Color(0, 0, 0, 128);
        backgroundColor = new Color (255, 255, 255, 128);
    }
    
    // All setters start here.
    public void setFontSize(float fontSize){
        this.fontSize = fontSize;
    }
    
    public void setInput(String input){
        this.input = input;
    }
    
    // backgroundColor has to be a pre-defined color here. Ie: Color.BLACK or Color.White
    // Use setBackgroundColor to create a specific border color.
    public void setField(int fieldWidth, int fieldHeight){
        this.fieldWidth = fieldWidth;
        this.fieldHeight = fieldHeight;
    }
    
    // borderColor has to be a pre-defined color here. Ie: Color.BLACK or Color.White
    // Use setBorderColor to create a specific border color.
    public void setBorder(int borderHeight, int borderWidth){
        this.borderHeight = borderHeight;
        this.borderWidth = borderWidth;
    }
    
    public void setDrawString(int drawStringX, int drawStringY){
        this.drawStringX = drawStringX;
        this.drawStringY = drawStringY;
    }
    
    public void setHasBackground(boolean hasBackground){
        this.hasBackground = hasBackground;
    }
    
    public void setFontColor(int red, int green, int blue, int alpha){
        if(isTheColorInputCorrect(red, green, blue, alpha)){
            fontColor = new Color(red, green, blue); 
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
    // End of all setters
    
    // Checking input to create a new color.
    private boolean isTheColorInputCorrect(int red, int green, int blue, int alpha){
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
    
    // First create a rectangle with border color, then a smaller rectangle
    // with the backgroundcolor so it looks like it has some sort of border.
    private void createAreaWithBorder(int borderWidth, int borderHeight){
        image.setColor(borderColor);
        image.fillRect(0, 0, fieldWidth, fieldHeight);
        
        image.setColor(backgroundColor);
        image.fillRect(borderWidth, borderHeight, fieldWidth - (borderWidth * 2), fieldHeight - (borderHeight * 2));
    }
    
    // Create a rectangle with the background color.
    private void createAreaWithoutBorder(){
        image.setColor(backgroundColor);
        image.fillRect(0, 0, fieldWidth, fieldHeight);
    }
    
    // Use the TextBox to create a simple piece of text.
    public void createTextBox(){
        // Check if theGreenFootImage was set, otherwise create a blanco image
        // with the specific heights.
        if(theGreenfootImage != null){
            image = new GreenfootImage(theGreenfootImage);
        }else{
            image = new GreenfootImage(fieldWidth, fieldHeight);
        }
        
        if(hasBackground){
            if(borderWidth == 0 || borderHeight == 0){
                createAreaWithoutBorder();
            } else{
                createAreaWithBorder(borderWidth, borderHeight);
            }
        }
        
        // Create the default dont with given fontsize and color.
        font = image.getFont();
        font = font.deriveFont(fontSize);
        image.setFont(font);
        image.setColor(fontColor);
          
        // Draw the string in the image with the input, on the given coordinates.
        image.drawString(input, drawStringX, drawStringY);

        // This places the image
        setImage(image);
    }
    
    // Folowing prints are for debugging only.
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
        System.out.println("-------------");
    }
}
