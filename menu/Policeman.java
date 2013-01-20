import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Policeman extends Helpers{
    public Policeman(int sx, int sy){
        super(sx,sy);
        super.setSpeed(4);
        super.setPower(2);
        super.setScoreDecrease(100);
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

