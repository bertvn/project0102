import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class CalStreetFlooding extends Calamities{
    private Boolean streetIsOpen;
    private Boolean hasShortCircuit;
    private long endTime;
    private long timeLeft;
    private CalamityTimer calamityTimer;
    private Boolean createTimer;

    public CalStreetFlooding(int imgNr){
        streetIsOpen = true;
        hasShortCircuit = false;
        setImage("overstroming" + imgNr + ".png");
        endTime = (System.currentTimeMillis() / 1000) + 30;
        createTimer = false;
    }
    
    public void act(){
        if(createTimer == false){
            timeLeft = endTime - (System.currentTimeMillis() / 1000);
            long targetTime = endTime - 30;
            createNewTimer(timeLeft, targetTime);
            createTimer = true;
        }
        
        if(hasShortCircuit == false){
            if((int) (Math.random() * 1000) == 1){
                createNewShortCircuit();
            }
        }
        
        if(streetIsOpen == true){
            timeLeft = endTime - (System.currentTimeMillis() / 1000);
            updateTimer();
            if(timeLeft <= 0){
                getWorld().removeObject(this.calamityTimer);
                closeStreet();
                System.out.println("Small amount of extra points for no car crash");
            }else if((int) (Math.random() * 1000) == 1){
                createNewCarCrash();
                closeStreet();
                getWorld().removeObject(this.calamityTimer);
                System.out.println("Small amount of deduction in points for not closing the street");
            }
        }
    }
    
    public void closeStreet(){
        streetIsOpen = false;
    }
    
    public void createNewShortCircuit(){
        getWorld().addObject(new CalShortCircuit(), getX()+8, getY()+8);
        hasShortCircuit = true;
    }
    
    public void createNewCarCrash(){
        getWorld().addObject(new CalCarCrash(), getX()-8, getY()-8);
    }
    
    public void createNewTimer(long timeLeft, long targetTime){
        calamityTimer = new CalamityTimer("Flooded street open: ", timeLeft, targetTime);
        getWorld().addObject(calamityTimer, 130, Controlecentrum.getXCoord());
        Controlecentrum.setXCoord(15);
    }
    
    public void updateTimer(){
        calamityTimer.setCurrentValue(timeLeft);
    }
}