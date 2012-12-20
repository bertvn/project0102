import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.List;

/**
 * Write a description of class Car here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car extends Actor
{
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootSound crash;
    
    public Car() {       
        // prepare image
        GreenfootImage img = new GreenfootImage("car.png");
        setImage(img); // set image
        setRotation(0);
        crash = new GreenfootSound("crash.mp3");
    }
    
    public void act() 
    {          
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
    //moves firecar left or right if button pressed
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
    
    //checks if car is hit
    public void hitDetection(){
        //make list of all ObsCars with their centre point within 55 pixels of the cars centre
        List<ObsCar> oc = getObjectsInRange(55, ObsCar.class);
        // if list is not empty
        if(!oc.isEmpty()){
            //slow speed down to 1
            WorldWorker.speed = 1;
            //for every ObsCar
            for(ObsCar ocar : oc){
                //place BAM on ObsCar location
                getWorld().addObject(new BAM(),ocar.getX(),ocar.getY());
                //remove ObsCar
                getWorld().removeObject(ocar);
                //play crash sound
                crash.play();
                System.out.println(crash.toString());
                //if score is higher than 50
                if(WorldWorker.score > 50){
                    //score decreases with 50 points
                    WorldWorker.score -= 50;
                }else{
                    //else score is 0
                    WorldWorker.score = 0;
                }
            }
                
        }
        //make list of all Cracks with their centre point within 55 pixels of the cars centre
        List<Cracks> ck = getObjectsInRange(57, Cracks.class);
        // if list is not empty
        if(!ck.isEmpty()){
            //slow speed down to 1
            WorldWorker.speed = 1;
            //for every Crack
            for(Cracks cr : ck){
                //getWorld().removeObject(cr);
                //if score is higher than 100
                if(WorldWorker.score > 100){
                    //score decreases with 100 points
                    WorldWorker.score -= 100;
                }else{
                    //else score is 0
                    WorldWorker.score = 0;
                }
            }
                
        }
    }
    
    public void endGame(){
        Greenfoot.stop();
    }
}
