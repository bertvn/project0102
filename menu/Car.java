import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.List;

/**
 * Car will show an car on the road
 * User will control the car and the car will check for collision
 * 
 * @author  RU development
 * @version 1.2
 */
public class Car extends Actor{

    private GreenfootSound crash;
    
    /**
     * contructor of the class Car
     */
    public Car(){       
        // choice image
        GreenfootImage img = new GreenfootImage("ontwijken/car" + Ontwijken.random + ".png");
        setImage(img); // set image
        setRotation(0);
        //set crash sound
        crash = new GreenfootSound("crash.mp3");
    }
    
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){          
        //checks if car hits something
        hitDetection();
        //checks if a key is pressed and if so the car changes rotation and movement
        if(Greenfoot.isKeyDown("left")) {
            move(0);
            setRotation(355);
        } else if(Greenfoot.isKeyDown("right")) {
            move(1);
            setRotation(5);
        } else{
            setRotation(0);
        }
    }    
    
    /**
     * moves car in direction
     * @param direction decides direction
     * 0 = to the left
     * 1 = to the right
     */
    public void move(int direction) {
        
        switch(direction) {
            case 0 :
                if(getX() > 137){
                    setLocation(getX() - 2, getY());
                }
                break;
            case 1 :
                if(getX() < 503){
                    setLocation(getX() + 2, getY());
                }
                break; 
        }
    }
    
    /**
     * checks if car is hit
     * if it is hit the score will be decreased
     */
    public void hitDetection(){
        //make list of all ObsCars with their centre point within 55 pixels of the cars centre
        List<ObsCar> oc = getObjectsInRange(55, ObsCar.class);
        // if list is not empty
        if(!oc.isEmpty()){
            //slow speed down to 1
            Ontwijken.speed = 1;
            //for every ObsCar
            for(ObsCar ocar : oc){
                //place BAM on ObsCar location
                getWorld().addObject(new BAM(),ocar.getX(),ocar.getY());
                //remove ObsCar
                getWorld().removeObject(ocar);
                //play crash sound
                crash.play();
                //if score is higher than 50
                if(Ontwijken.score > 50){
                    //score decreases with 50 points
                    Ontwijken.score -= 50;
                }else{
                    //else score is 0
                    Ontwijken.score = 0;
                }
            }
                
        }
        //make list of all Cracks with their centre point within 55 pixels of the cars centre
        List<Cracks> ck = getObjectsInRange(57, Cracks.class);
        // if list is not empty
        if(!ck.isEmpty()){
            //slow speed down to 1
            Ontwijken.speed = 1;
            //for every Crack
            for(Cracks cr : ck){
                //checks if the crack is already hit
                if(cr.isHitAlready() == false){
                    //set score increase for evade to 0
                    cr.setScoreIncrease(0);
                    //makes sure this crack doesn't cost points a second time
                    cr.hitAlreadyIndeed();
                    
                    if(Ontwijken.score > 100){
                        //score decreases with 100 points
                        Ontwijken.score -= 100;
                    }else{
                        //else score is 0
                        Ontwijken.score = 0;
                    }
                }
            }
                
        }
    }
}
