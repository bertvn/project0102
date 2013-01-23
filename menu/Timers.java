import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
 
public class Timers extends Actor{
    
    private long timeLeft;
    private long timeEnd;
    
    private String prefix;
    private static String suffix = "s";
    private int stringLength;
    
    private boolean setFontBold;
    
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
    
    public void setCurrentValue(long timeLeftVal){
        timeLeft = timeLeftVal;
        updateImage();
    }
    
    // This method updates the timer to the 
    public void updateImage(){
        GreenfootImage timerImage = getImage();
        timerImage.clear();
        
        if(setFontBold == true){
            boldThisFont();
        }else{
            plainThisFont();
        }
        
        timerImage.drawString(prefix + timeLeft + suffix, 1, 18);
    }
    
    public void setFontBold(boolean newValue){
        setFontBold = newValue;
    }
    
    public void boldThisFont(){
        GreenfootImage timerImage = getImage();
        Font timerFont = timerImage.getFont();
        Font newFont = timerFont.deriveFont(Font.BOLD);
        timerImage.setFont(newFont);
    }
    
    public void plainThisFont(){
        GreenfootImage timerImage = getImage();
        Font timerFont = timerImage.getFont();
        Font newFont = timerFont.deriveFont(Font.PLAIN);
        timerImage.setFont(newFont);
    }
}
