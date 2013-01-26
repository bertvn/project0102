import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Civilian extends Helpers{
    
    /**
     * sets alle attributes in parent class and sets the image
     */
    public Civilian(){
        super.setSpeed(3);
        super.setPower(1);
        super.setScoreDecrease(50);
        setImage("dijkdoorbraak/civilian.png");
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
    @Override
    public void select(){
        setImage("dijkdoorbraak/selectedcivilian.png");
    }
    
    /**
     * sets image for when helper is deselected
     */
    @Override
    public void deselect(){
        setImage("dijkdoorbraak/civilian.png");
    }
}

