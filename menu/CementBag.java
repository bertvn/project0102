import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class CementBag extends Materials{
    public CementBag(){
        super.setDissolveRate(1);
        super.setSpeedReducement(4);
        super.setBaseHealth(20);
        super.setWeight(3);
        super.setScoreDecrease(300);
        
        setImage("dijkdoorbraak/greyBigCementBag.png");
    }

    public void act(){
        
    }
    
    public void select(){
        setImage("dijkdoorbraak/selectedbigCementBag.png");
    }
    
    public void deselect(){
        setImage("dijkdoorbraak/bigCementBag.png");
    }
    
    public void selectable(){
        setImage("dijkdoorbraak/bigCementBag.png");
    }
    
    public void unselectable(){
        setImage("dijkdoorbraak/greyBigCementBag.png");
    }
    
}

