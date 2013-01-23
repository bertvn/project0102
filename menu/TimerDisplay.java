import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
import java.awt.Color;

public class TimerDisplay extends Actor{
    public static int currentValue;
    private int targetValue = 0;
    private GreenfootImage image;
    private Font font;
    private boolean start = false;
    private boolean done = false;
    
    private final float FONT_SIZE = 20.0f;
    
    // Constructor of the class Timer.
    public TimerDisplay(){
        //set time
        currentValue = 10800;        
        // Start updating the image.
        updateImage();
    }
    
    // This method will be called every act.
    public void act(){
        if(endGame() && !done){ // Check if the timer has reached 0.
            Ontwijken.speed = 0;
            createMessage(320, 320, "You ran out of time! Click to continue..");
            MiniGameMemory.gameFinished();
            Score.addScore(-500);
            done = true;
        }else{
            if(start){
                currentValue--;
                if((currentValue % 60) == 0){
                    updateImage();
                }
            }
        }
    }
    
    public void createMessage(int xCoord, int yCoord, String message){
        TextDisplay theMessage = new TextDisplay();
        theMessage.setBackgroundColor(255, 255, 255, 160);
        theMessage.setBorderColor(0, 0, 0, 160);
        theMessage.setField(480, 150);
        theMessage.setFontSize(30.0f);
        theMessage.setBorder(5, 5);
        theMessage.setDrawString(50, 90);
        theMessage.setInput(message);
        theMessage.setHasBackground(true);
        
        theMessage.createTextBox();
        getWorld().addObject(theMessage, xCoord, yCoord);
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
        image = new GreenfootImage("ontwijken/timerDisplay.png"); // place background image
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
    
    public void startTimer(){
        start = true;
    }
    
    public void stopTimer(){
        start = false;
    }
}