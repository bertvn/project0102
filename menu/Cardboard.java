import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cardboard extends Materials{
    
public Cardboard(){
        super.setDissolveRate(4);
        super.setSpeedReducement(1);
        super.setBaseHealth(20);
        super.setWeight(1);
        super.setScoreDecrease(20);
        setImage("dijkdoorbraak/greyCardboard.png");
    }

    public void act(){ 
    }
    
    public void select(){
        setImage("dijkdoorbraak/selectedcardboard.png");
    }
    
    public void deselect(){
        setImage("dijkdoorbraak/cardboard.png");
    }
    
    public void selectable(){
        setImage("dijkdoorbraak/cardboard.png");
    }
    
    public void unselectable(){
        setImage("dijkdoorbraak/greyCardboard.png");
    }
}