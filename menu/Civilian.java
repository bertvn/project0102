import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Civilian extends Helpers{
    
    public Civilian(int sx, int sy){
        super(sx,sy);
        super.setSpeed(3);
        super.setPower(1);
        super.setScoreDecrease(50);
        setImage("dijkdoorbraak/civilian.png");
    }
    
    public void act(){
        super.act();
    }
    
    public void select(){
        setImage("dijkdoorbraak/selectedcivilian.png");
    }
    
    public void deselect(){
        setImage("dijkdoorbraak/civilian.png");
    }
}

