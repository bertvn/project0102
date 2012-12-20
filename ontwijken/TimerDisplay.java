import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
import java.awt.Color;

public class TimerDisplay extends Actor{
    private int currentValue = 10800;
    private int targetValue = 0;
    private GreenfootImage image;
    private Font font;
    
    private final float FONT_SIZE = 20.0f;
    
    // Constructor of the class Timer.
    public TimerDisplay(){
        // Start updating the image.
        updateImage();
    }
    
    // This method will be called every act.
    public void act(){
        if(endGame()){ // Check if the timer has reached 0.
            //TextArea win = new TextArea("win");
            //getWorld().addObject(win, 320, 320);
            WorldWorker.music.stop();
            Greenfoot.stop();
        }else{
            currentValue--;
            if((currentValue % 60) == 0){
                updateImage();
            }
        }
    }
    
    public boolean endGame(){
        if(currentValue <= targetValue){
            return true;
        }else{
            return false;
        }
    }
    
    // This method updates the timer to the 
    public void updateImage(){
        // Create an image and add a fontsize to it.
        image = new GreenfootImage("timerDisplay.png"); // place background image
        font = image.getFont();  // get current font
        font = font.deriveFont(FONT_SIZE);  // set font size
        image.setFont(font);  // set font
        image.setColor(Color.BLACK);  // set font color
        image.drawString("" + (currentValue/60) + " s", 10, 30);   // place score
        setImage(image);
    }
    
    public void setCurrentValue(int currentValue){
        if(currentValue < 0){
            System.out.println("currentValue must be equal or greater than 0");
        }else{
            // currentValue is in seconds, multiply with 60 because 60 acts is 1 second.
            this.currentValue = currentValue * 60;
            updateImage();
        }
    }
    
    // This method updates the timer to the 
    public int getCurrentValue(){
        return currentValue;
    }
}
