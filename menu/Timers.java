import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;

/**
 * @author      RU Development
 * @version     1.0
 * @since       26-01-2013
 */
public class Timers extends Actor{
    
    private long timeLeft;
    private long timeEnd;
    
    private String prefix;
    private static String suffix = "s";
    private int stringLength;
    
    private boolean setFontBold;
    
    /**
     * Constructor for this class. Creates a timer with required input.
     * @param Requires a prefix, amount of seconds left and the amount
     * of seconds till the end is reached.
     */
    public Timers(String prefixVal, long timeLeftVal, long timeEndVal){
        // Set the prefix for later use.
        prefix = prefixVal;
        timeLeft = timeLeftVal;
        timeEnd = timeEndVal;
        
        setFontBold = false;
        
        // Count the amount of characters in prefix + suffix and multiply by 10.
        stringLength = (prefix.length() + suffix.length() + 2) * 10;

        // Create an image and add a fontsize to it.
        setImage(new GreenfootImage(stringLength, 20));
        GreenfootImage timerImage = getImage();
        Font timerFont = timerImage.getFont();
        timerImage.setFont(timerFont.deriveFont(12.0F));
        
        // Start updating the image.
        updateImage();
    }
    
    /**
     * Setter for the private variable timeLeft. Updates his timer image.
     * @param Requires input with the amount of time left.
     */
    public void setCurrentValue(long timeLeftVal){
        timeLeft = timeLeftVal;
        updateImage();
    }
    
    /**
     * This method updates the image of the timer with his own variables.
     */
    private void updateImage(){
        GreenfootImage timerImage = getImage();
        timerImage.clear();
        
        if(setFontBold == true){
            boldThisFont();
        }else{
            plainThisFont();
        }
        
        timerImage.drawString(prefix + timeLeft + suffix, 1, 18);
    }
    
    /**
     * Method to set boolean FontBold to true or false.
     * @param Requires an true or false input.
     */
    public void setFontBold(boolean newValue){
        setFontBold = newValue;
    }
    
    /**
     * Method to set update the font to a bold status.
     */
    private void boldThisFont(){
        GreenfootImage timerImage = getImage();
        Font timerFont = timerImage.getFont();
        Font newFont = timerFont.deriveFont(Font.BOLD);
        timerImage.setFont(newFont);
    }
    
    /**
     * Method to set update the font to a plain status.
     */
    private void plainThisFont(){
        GreenfootImage timerImage = getImage();
        Font timerFont = timerImage.getFont();
        Font newFont = timerFont.deriveFont(Font.PLAIN);
        timerImage.setFont(newFont);
    }
}
