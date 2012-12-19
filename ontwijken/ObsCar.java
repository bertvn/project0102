import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ObsCar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ObsCar extends Obstacles
{
    /**
     * Act - do whatever the ObsCar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public ObsCar(){
        int random = (int) Math.round(Math.random()*5);
        
        switch(random){
            case 0: setImage("obstacle0.png");
                    break;
            case 1: setImage("obstacle1.png");
                    break;
            case 2: setImage("obstacle2.png");
                    break;
            case 3: setImage("obstacle3.png");
                    break;
            case 4: setImage("obstacle4.png");
                    break;
            case 5: setImage("obstacle5.png");
                    break;
        }
        setRotation((int)(Math.random() * 360));
        setRange(55);
        setScoreIncrease(10);
        setScoreDecrease(-50);
    }
    
    public void act() 
    {
        // Add your action code here.
        super.act();
    }    
}
