import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class CalStreetFlooding extends Calamities{

    // Properties of the flooding.
    private boolean streetIsOpen;
    private int streetFloodingRefNr;
    
    // Time properties of the flooding.
    private int duration;
    private long timeEnd;
    private long timeLeft;
    private CalamityTimer calamityTimer;
    
    // Creating a boolean to check for first act.
    private boolean firstAct;

    public CalStreetFlooding(int imgNr){
        setImage("overstroming" + imgNr + ".png");
        streetIsOpen = true;
        
        streetFloodingRefNr = imgNr; // Reference number for this flooding.
        
        firstAct = true;
    }
    
    public void act(){
        if(firstAct == true){
            createTimer(); // Creating new timer.
            firstAct = false;
        }
    }
    
     public void closeStreet(){
        streetIsOpen = false;
        calamityTimer.moveTimerBelow();
        
        getWorld().removeObject(this.calamityTimer);
    }
    
    public void createTimer(){
        long timeCurrent = System.currentTimeMillis() / 1000;
        
        duration = (int) (Math.random() * 10) + 25; // Duration (25 ~ 35s) of the timer.
        timeEnd = timeCurrent + duration;
        timeLeft = timeEnd - timeCurrent;
        
        calamityTimer = new CalamityTimer("Flooded street open: ", timeLeft, timeEnd, streetFloodingRefNr);
        
        getWorld().addObject(calamityTimer, 130, Controlecentrum.getNextTimerPosition());
    }

}