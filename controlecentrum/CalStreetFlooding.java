import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class CalStreetFlooding extends Calamities{

    private int floodNumber;
    private boolean streetIsOpen;
    private boolean hasShortCircuit;
    private long endTime;
    private long timeLeft;
    private long duration;
    private boolean waitWithSpawns;
    private CalamityTimer calamityTimer;
    private boolean createTimer;
    private boolean streetHadCarCrash;
    private boolean streetHadSquatters;

    public CalStreetFlooding(int imgNr){
        streetIsOpen = true;
        hasShortCircuit = false;
        floodNumber = imgNr;
        setImage("overstroming" + imgNr + ".png");
        duration = 30;
        endTime = (System.currentTimeMillis() / 1000) + duration;
        waitWithSpawns = true;
        createTimer = false;
        streetHadCarCrash = false;
        streetHadSquatters = false;
    }
    
    public void act(){
        if(createTimer == false){
            timeLeft = endTime - (System.currentTimeMillis() / 1000);
            long targetTime = endTime - duration;
            createNewTimer(timeLeft, targetTime);
            createTimer = true;
        }
        
        if(hasShortCircuit == false){
            if((int) (Math.random() * 1000) == 1){
                createNewShortCircuit();
            }
        }
        
        if(streetIsOpen == true){
            updateTimer();
            if(timeLeft <= 0){
                closeStreet();
                System.out.println("Extra points: no car crash");
            }else if(waitWithSpawns == false && (int) (Math.random() * 1000) == 1){
                createNewCarCrash();
                closeStreet();
                System.out.println("Losing points: not closing street");
            }
        }else if(streetIsOpen == false && streetHadCarCrash == false && streetHadSquatters == false){
            if((int) (Math.random() * 1500) == 1){
                createNewSquatters();
                System.out.println("Losing points: not closing street");
            }
        }
    }
    
    public void closeStreet(){
        streetIsOpen = false;
        getWorld().removeObject(this.calamityTimer);
    }
    
    public void createNewShortCircuit(){
        hasShortCircuit = true;
        getWorld().addObject(new CalShortCircuit(floodNumber), getX()+8, getY()+8);
    }
    
    public void createNewCarCrash(){
        streetHadCarCrash = true;
        getWorld().addObject(new CalCarCrash(floodNumber), getX()-8, getY()-8);
    }
    
    public void createNewSquatters(){
        streetHadSquatters = true;
        getWorld().addObject(new CalSquatters(floodNumber), getX()-8, getY()-8);
    }
    
    public void createNewTimer(long timeLeft, long targetTime){
        calamityTimer = new CalamityTimer("Flooded street open: ", timeLeft, targetTime, floodNumber);
        getWorld().addObject(calamityTimer, 130, Controlecentrum.getXCoord());
        Controlecentrum.setXCoord(15);
    }
    
    public void updateTimer(){
        timeLeft = endTime - (System.currentTimeMillis() / 1000);
        calamityTimer.setCurrentValue(timeLeft);
        
        if(waitWithSpawns == true){
            if(duration - 10 >= timeLeft){
                System.out.println("Set to false for street: " + floodNumber);
                waitWithSpawns = false;
            }
        }
        

    }
}