import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class WorldSpawner extends World{
    private Timer gameTimer;
    private Policeman policeman;
    private Soldier soldier;
    private Civilian civilian;
    private CementBag cementBag;
    private SandBag sandBag;
    private GravelBag gravelBag;
    private Cardboard cardboard;
    private Paper paper;

    private Helpers selectedActor = null;
    private Materials selectedMaterials = null;
                    
    private int waitWithDikeSpawns = 0;
    
    private int[] breakingSpots;
    private int[] usedSpots;
    
    private int spotsLeft = 9;
    private int newSpotName;
    private int newSpotX;
    private int newSpotY;
    
    private static int breakThroughPart = 0;

    // Constructor of the class WorldSpawner.
    public WorldSpawner(){    
        // Create a new world with 640x640 cells with a cell size of 1x1 pixels.
        super(640, 640, 1);
        
        // Fill the world with objects.
        startPopulating();
        createSpots();
    }
    
    // This method will be called every act.
    public void act(){
        if(waitWithDikeSpawns <= 0){
            if(createDikeObject()){
                if(anySpotsLeft()){
                    createNewDike();
                }else{
                    // Set the waitWithDikeSpawns till after the game, there are no spots left.
                    waitWithDikeSpawns = 10800; // Amount of acts in 3 minutes.
                }
            }
        }else{
            waitWithDikeSpawns--;
        }
        
        if(breakThroughPart > 0){
            if(breakThroughPart == 1){
                List<Helpers> allHelpers = getObjects(Helpers.class);
                List<Materials> allMaterials = getObjects(Materials.class);
                removeObjects(allHelpers);
                removeObjects(allMaterials);
            }
            
            if(breakThroughPart == 8){
            System.out.println("Lose State");
            Greenfoot.stop();
            }
            
            setBackground("background" + breakThroughPart + ".png");
        }
        
        //movement Persona's
        if(Greenfoot.mouseClicked(null)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            // if a material is selected
            // chose dike, remove material and move actor to dike
            if(selectedMaterials != null){
                //select all dike objects on current mouse x and y
                List<Dike> dk = getObjectsAt(mouse.getX(),mouse.getY(),Dike.class);
                if(dk != null){
                    //select 1
                    Dike selectedDike = dk.get(0);
                    selectedActor.startMovement(selectedDike.getX(),selectedDike.getY()+40);
                    selectedActor.setHolding(selectedMaterials);
                    removeObject(selectedMaterials);
                }
                
                selectedActor = null;
                selectedMaterials = null;
                return;
            }else{
                //if no material is selected
                //if actor is selected
                //chose material
                if(selectedActor != null){
                    //select all Materials objects on current mouse x and y
                    List<Materials> mat = getObjectsAt(mouse.getX(),mouse.getY(),Materials.class);
                    if(mat != null){
                        //select 1
                        selectedMaterials = mat.get(0);
                    }
                    return;
                }else{
                    //if no actor is selected
                    //select actor
                    //select all Helpers objects on current mouse x and y
                    List<Helpers> hlp = getObjectsAt(mouse.getX(),mouse.getY(),Helpers.class);
                    if(hlp != null){
                        //select 1
                        selectedActor = hlp.get(0);
                    }
                }
            }
        }
    }
    
    // This method will populate our world with objects.
    public void startPopulating(){
        gameTimer = new Timer("Time left: ");
        // Player must prevent the dike from breaking for 1 minute and 30 seconds.
        // Therefor we set the timer to 90 seconds.
        gameTimer.setCurrentValue(90);
        addObject(gameTimer, 320, 25);
        
        civilian = new Civilian();
        addObject(civilian, 80, 530);
       
        policeman = new Policeman();
        addObject(policeman, 170, 530);
        
        soldier = new Soldier();
        addObject(soldier, 260, 530);
        
        sandBag = new SandBag();
        addObject(sandBag, 70, 605);
        
        gravelBag = new GravelBag();
        addObject(gravelBag, 110, 605);
        
        cementBag = new CementBag();
        addObject(cementBag, 150, 605);
        
        cardboard = new Cardboard();
        addObject(cardboard, 205, 609);
                
        paper = new Paper();
        addObject(paper, 265, 609);
    }
    
    public void createSpots(){
        // breakingSpots: # of dike, x-Coordinate, y-Coordinate
        breakingSpots = new int[]{
            1, 40, 366,
            2, 101, 365,
            3, 163, 363,
            4, 225, 362,
            5, 327, 363,
            6, 389, 364,
            7, 453, 368,
            8, 517, 372,
            9, 580, 377
        };
        
        // Spots in breakingSpots Array where to start.
        usedSpots = new int[]{
            0, 3, 6, 9, 12, 15, 18, 21, 24
        };
    }
    
    // This will return wheter we will create a dike or not.
    public boolean createDikeObject(){
        if((int) (Math.random()*500)+1 == 1){
            return true;
        }else{
            return false;
        }
    }

    // Checks if there are spots left to spawn a new breaking dike.
    public boolean anySpotsLeft(){
        if(spotsLeft <= 0){
            return false;
        }else{ // Still spots left.
            findANewSpot();
            spotsLeft--;
            return true;
        }
    }
    
    public void findANewSpot(){
        int randomSpot;
        boolean foundSpot = false;
        do{
            randomSpot = (int) Math.random()*9;
            if(usedSpots[randomSpot] != -1){
                newSpotName = breakingSpots[usedSpots[randomSpot]];
                newSpotX = breakingSpots[usedSpots[randomSpot]+1];
                newSpotY = breakingSpots[usedSpots[randomSpot]+2];
                
                usedSpots[randomSpot] = -1;
                
                foundSpot = true;
            }
        }while(!foundSpot);
    }
    
    // This method will place a new dike 'random' coordinates.
    public void createNewDike(){
        // Set the amount of acts to wait for new spawn.
        waitWithDikeSpawns = 300;
        
        // Add the dike-object on the newSpot.
        addObject(new Dike(), newSpotX, newSpotY);
        
        /*/ Following prints are for debugging purposes only.
        String dikeName = "dike" + newSpotName;
        System.out.println("dikeName = " + dikeName);
        System.out.println("newSpotName = " + newSpotName);
        System.out.println("newSpotX = " + newSpotX);
        System.out.println("newSpotY = " + newSpotY);
        System.out.println("Spawned on time: " + gameTimer.getCurrentValue()/60);
        System.out.println("-----");*/
    }
    
    public static void endGame(){
        breakThroughPart++;
    }
}
