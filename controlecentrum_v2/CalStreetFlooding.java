import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
public class CalStreetFlooding extends Calamities{

    // Creating a boolean to check for first act.
    private boolean firstAct;
    
    private int waitForShortCircuit;
    private boolean hasShortCircuit;
    private CalShortCircuit shortCircuit;
    
    // Properties of the flooding.
    private boolean streetIsOpen;
    private boolean hasCarCrash;
    private CalCarCrash carCrash;

    public CalStreetFlooding(int imgNr){
        setImage("overstroming" + imgNr + ".png");
        streetIsOpen = true;
        firstAct = true;
        
        waitForShortCircuit = 600;
        hasShortCircuit = false;
        hasCarCrash = false;
    }
    
    public void act(){
        super.act();
        
        if(firstAct == true){
            createTimer("Flooded street open: "); // Creating new timer.
            firstAct = false;
        }
        
        if(waitForShortCircuit == 0 && !hasShortCircuit){
            if((int) (Math.random() * 300) == 0){
                shortCircuit = new CalShortCircuit();
                getWorld().addObject(shortCircuit, getX()-8, getY()-8);
                hasShortCircuit = true;
            }
        }else if(!hasShortCircuit){
            waitForShortCircuit--;
        }else{
            if(!shortCircuit.getFirstAct() && shortCircuit.getCalamityTimer() == null){
                getWorld().removeObject(shortCircuit);
                resetHasShortCircuit();
            }
        }
        
        if(streetIsOpen && !hasCarCrash){
            if((int) (Math.random() * 1200) == 0){
                carCrash = new CalCarCrash();
                getWorld().addObject(carCrash, getX()+8, getY()+8);
                hasCarCrash = true;
            }
        }else if(hasCarCrash){
            if(!carCrash.getFirstAct() && carCrash.getCalamityTimer() == null){
                getWorld().removeObject(carCrash);
                resetHasCarCrash();
            }
        }
    }
    
    public void closeStreet(){
        streetIsOpen = false;
        removeCalamityTimer();
    }
    
    public void resetHasCarCrash(){
        hasCarCrash = false;
    }
    
    public void resetHasShortCircuit(){
        hasShortCircuit = false;
        waitForShortCircuit = 300;
    }
}