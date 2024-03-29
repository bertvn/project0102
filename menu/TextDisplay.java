import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

/**
 * TextDisplay class is used to print most text images
 * 
 * @author RU Development 
 * @version 1.0
 */
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
    
    /**
     * Constructor that creates the image with default values.
     */
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

    /**
     * Setter for the font size used in the image.
     * @param fontsize a fontsize (e.g. 20.0f).
     */
    public void setFontSize(float fontSize){
        this.fontSize = fontSize;
    }

    /**
     * Setter for the message that will be shown in the image.
     * @param input the message that will be printed.
     */
    public void setInput(String input){
        this.input = input;
    }
    
    /**
     * Setter for mesurements of the field.
     * @param fieldWidth width of the field
     * @param fieldHeight height of the field.
     */
    public void setField(int fieldWidth, int fieldHeight){
        this.fieldWidth = fieldWidth;
        this.fieldHeight = fieldHeight;
    }
    
    /**
     * Setter to adjust the border thickness. Input 0 will results in having
     * no border at all.
     * @param borderHeight height of the border
     * @param borderWidth width of the border. 
     */
    public void setBorder(int borderHeight, int borderWidth){
        this.borderHeight = borderHeight;
        this.borderWidth = borderWidth;
    }

    /**
     * Setter for the coordinates where the image needs to be drawn.
     * @param drawStringX the x coordinate where the String will be drawn
     * @param drawStringY the Y coordinate where the String will be drawn
     */
    public void setDrawString(int drawStringX, int drawStringY){
        this.drawStringX = drawStringX;
        this.drawStringY = drawStringY;
    }

    /**
     * Setter with a true or false boolean to check wheter the class should
     * draw a background or not.
     * @param hasBackground used to set hasBackground
     */
    public void setHasBackground(boolean hasBackground){
        this.hasBackground = hasBackground;
    }

    /**
     * Setter to adjust the font color.
     * @param red the amount of red in the color
     * @param green the amount of green in the color
     * @param blue the amount of blue in the color
     * @param alpha the alpha value of the color
     */
    public void setFontColor(int red, int green, int blue, int alpha){
        if(isTheColorInputCorrect(red, green, blue, alpha)){
            fontColor = new Color(red, green, blue); 
        }
    }
    
    /**
     * Setter to adjust border color.
     * @param red the amount of red in the color
     * @param green the amount of green in the color
     * @param blue the amount of blue in the color
     * @param alpha the alpha value of the color
     */
    public void setBorderColor(int red, int green, int blue, int alpha){
        if(isTheColorInputCorrect(red, green, blue, alpha)){
            borderColor = new Color(red, green, blue, alpha); 
        }
    }
    
    /**
     * Setter to adjust the background color.
     * @param red the amount of red in the color
     * @param green the amount of green in the color
     * @param blue the amount of blue in the color
     * @param alpha the alpha value of the color
     */
    public void setBackgroundColor(int red, int green, int blue, int alpha){
        if(isTheColorInputCorrect(red, green, blue, alpha)){
            backgroundColor = new Color(red, green, blue, alpha); 
        }
    } 
    
    /**
     * Setter for the image that will be used
     * @param String referring to an image file
     */
    public void setTheGreenfootImage(String value){
        theGreenfootImage = value;
    }
    
    /**
     * A method that oversees if there is valid input for a color.
     * @param red the amount of red in the color
     * @param green the amount of green in the color
     * @param blue the amount of blue in the color
     * @param alpha the alpha value of the color
     */
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
    
    /**
     * A method that creates two rectangles that represent the background of 
     * the new image.
     * @param borderWidth width of the border
     * @param borderHeight height of the border
     */
    private void createAreaWithBorder(int borderWidth, int borderHeight){
        image.setColor(borderColor);
        image.fillRect(0, 0, fieldWidth, fieldHeight);
        
        image.setColor(backgroundColor);
        image.fillRect(borderWidth, borderHeight, fieldWidth - (borderWidth * 2), fieldHeight - (borderHeight * 2));
    }
    
    /**
     * A method that creates one rectangle that represent the background of 
     * the new image.
     */
    private void createAreaWithoutBorder(){
        image.setColor(backgroundColor);
        image.fillRect(0, 0, fieldWidth, fieldHeight);
    }
    
    /**
     * A method that collects all data from this object and actually creates
     * the image.
     */
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
        
        setImage(image); // Place the image
    }
}
