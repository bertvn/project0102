import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Policeman extends Helpers{

    /**
     * sets alle attributes in parent class and sets the image
     */
    public Policeman(){
        super.setSpeed(4);
        super.setPower(2);
        super.setScoreDecrease(100);
        setImage("dijkdoorbraak/policeman.png");
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
        setImage("dijkdoorbraak/selectedpoliceman.png");
    }
    
    /**
     * sets image for when helper is deselected
     */
    public void deselect(){
        setImage("dijkdoorbraak/policeman.png");
    }
}

