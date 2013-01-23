import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Soldier extends Helpers{

    /**
     * sets alle attributes in parent class and sets the image
     */
    public Soldier(){
        super.setSpeed(5);
        super.setPower(4);
        super.setScoreDecrease(200);
        
        setImage("dijkdoorbraak/soldier.png");
    }
    
    /**
     * calls the act in the parent class
     */
    public void act(){
        super.act();
    }
    
    /**
     * sets image for when helper is selected
     */
    public void select(){
        setImage("dijkdoorbraak/selectedsoldier.png");
    }
    
    /**
     * sets image for when helper is deselected
     */
    public void deselect(){
        setImage("dijkdoorbraak/soldier.png");
    }
}

