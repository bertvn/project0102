import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SandBag extends Materials{
    
    public SandBag(){
        super.setDissolveRate(3);
        super.setSpeedReducement(2);
        super.setBaseHealth(20);
        super.setWeight(2);
        super.setScoreDecrease(100);
        setImage("dijkdoorbraak/greyBigSandBag.png");
    }

    public void act(){
    } 
    
    public void select(){
        setImage("dijkdoorbraak/selectedbigSandBag.png");
    }
    
    public void deselect(){
        setImage("dijkdoorbraak/bigSandBag.png");
    }
    
   public void selectable(){
        setImage("dijkdoorbraak/bigSandBag.png");
    }
    
    public void unselectable(){
        setImage("dijkdoorbraak/greyBigSandBag.png");
    }
}

