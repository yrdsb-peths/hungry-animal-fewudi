import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pikachu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pikachu extends Actor
{
       
    GreenfootImage idle = new GreenfootImage("images/pikachu_idle/pika0.png");
    GreenfootImage[]idleRight = new GreenfootImage[4];
    GreenfootImage[]idleLeft = new GreenfootImage[4];
    
    
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    
    /*
     * Construtor 
     */
    
    public Pikachu(){
        //read images in to idle arraylist
        for(int i = 0; i < idleRight.length; i++){
            idleRight[i] = new GreenfootImage("images/pikachu_idle/pika"+ i + ".png");
            idleRight[i].scale(100, 100);
        }
        
        for(int i = 0; i < idleLeft.length; i++){
            idleLeft[i] = new GreenfootImage("images/pikachu_idle/pika"+ i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100, 100);
        }
        
        
        animationTimer.mark();
    
        
        setImage(idleRight[0]);
        
    }
    
    
    
    int imageIndex = 0;
    public void animatePikachu(){
        if(animationTimer.millisElapsed() < 25){
            return;
        }
        animationTimer.mark();
        if(facing.equals("right")){
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }else{
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
        
    }
    
    
    
     /**
     * Act - do whatever the Pikachu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        
        if(Greenfoot.isKeyDown("A"))
        {
            move(-2);
            
            facing = "left";

            
        }else if(Greenfoot.isKeyDown("D")){
            move(2);
            facing = "right";
        }
        
        // Remove apple if elephant eats it
        eat();
        
        //Animate the elephant
        animatePikachu();
    }
    public void eat(){
        if(isTouching(Apple.class)){
            removeTouching(Apple.class);
            MyWorld world = (MyWorld)getWorld();
            world.createApple();
            world.increaseScore();
        }
    }
}
