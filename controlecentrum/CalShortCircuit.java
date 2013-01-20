import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;


public class CalShortCircuit extends Calamities{

    private int belongsToFloodNumber;
    private long endTime;
    private long timeLeft;
    private boolean imageHasChanged;
    private CalamityTimer calamityTimer;

    public CalShortCircuit(int floodNumber){
        belongsToFloodNumber = floodNumber;
        setImage("shortCircuit.png");
        // spawnTime contains current number of seconds since 1-1-1970
        endTime = (System.currentTimeMillis() / 1000) + 34;
        imageHasChanged = false;
    }

    public void act(){
        if(System.currentTimeMillis() / 1000 >= endTime){
            System.out.println("Reduction of points");
            getWorld().removeObject(this.calamityTimer);
            getWorld().removeObject(this);
        }else{
            timeLeft = endTime - (System.currentTimeMillis() / 1000);
            if(imageHasChanged){
                updateTimer();
            }else if(timeLeft == 34){
                setImage("empty.png");
            }else if(timeLeft == 33){
                setImage("shortCircuit.png");
            }else if(timeLeft == 32){
                setImage("empty.png");
            }else if(timeLeft <= 31){
                setImage("burningImage.png");
                imageHasChanged = true;
                long targetTime = endTime - 34;
                createNewTimer(timeLeft, targetTime);
            }
        }
    }
    
    public void createNewTimer(long timeLeft, long targetTime){
        calamityTimer = new CalamityTimer("Short circuit fire: ", timeLeft, targetTime, belongsToFloodNumber);
        getWorld().addObject(calamityTimer, 125, Controlecentrum.getXCoord());
        Controlecentrum.setXCoord(15);
    }
    
    public void updateTimer(){
        calamityTimer.setCurrentValue(timeLeft);
    }

}
