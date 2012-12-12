import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Policeman extends Helpers{
    public Policeman(){
        super.setSpeed(4);
        super.setPower(2);
        setImage("dijkdoorbraak/policeman.png");
    }
    
    public void act(){
        super.act();
    }    
    
    public void select(){
        setImage("dijkdoorbraak/selectedpoliceman.png");
    }
    
    public void deselect(){
        setImage("dijkdoorbraak/policeman.png");
    }
}
