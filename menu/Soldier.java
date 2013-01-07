import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Soldier extends Helpers{
    public Soldier(){
        super.setSpeed(5);
        super.setPower(4);
        super.setScoreDecrease(200);
        
        setImage("dijkdoorbraak/soldier.png");
    }
    
    public void act(){
        super.act();
    }
    
    public void select(){
        setImage("dijkdoorbraak/selectedsoldier.png");
    }
    
    public void deselect(){
        setImage("dijkdoorbraak/soldier.png");
    }
}

