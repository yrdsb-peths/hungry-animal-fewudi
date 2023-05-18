import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * 
 * @author Felix 
 * @version 05/15/2023
 */
public class Elephant extends Actor
{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    //import sound 
    GreenfootSound soundEffect = new GreenfootSound("elephantcub.mp3");
    
    //image 
    GreenfootImage[]idleRight = new GreenfootImage[8];
    GreenfootImage[]idleLeft = new GreenfootImage[8];
    
    //initial direction of elephant is facing 
    String facing = "right";
    
    
    /*
     * image constructor - The code that gets run one time when object is created 
     */
    public Elephant(){
        //read images in to idle arraylist
        for(int i = 0; i < idleRight.length; i++){
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle"+ i + ".png");
            idleRight[i].scale(100, 100);
        }
        
        for(int i = 0; i < idleLeft.length; i++){
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle"+ i + ".png");
            idleLeft[i] = idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100, 100);
        }
        
        setImage(idleRight[0]);
    }
    
    /*
     * Animated the Elephant 
     */
    int imageIndex = 0;
    public void animateElephant(){
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1) % idle.length;
    }
    
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("A"))
        {
            move(-2);
        }else if(Greenfoot.isKeyDown("D")){
            move(2);
        }
        
        // Remove apple if elephant eats it
        eat();
        
        //Animate the elephant
        animateElephant();
    }
    
    // eat the apple and spwan new appple updating the label 
    public void eat(){
        if(isTouching(Apple.class)){
            removeTouching(Apple.class);
            MyWorld world = (MyWorld)getWorld();
            world.createApple();
            world.increaseScore();
            soundEffect.play();
        }
    }
}
