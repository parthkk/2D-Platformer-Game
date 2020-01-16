/* Character.java
 * Authors: Gordon Duan & Parth Kotecha
 * Date: January 22, 2019
 * Description: This is the character class. It will be extended by the player and enemies
 */

//Imports 
import java.awt.*;

//Create a character object that will be added into the map class that will be controlled by the players
abstract class Character{
  
  //Declare Variables
  public static final double GRAVITY = 2;
  private boolean health;
  private double x;
  private double y;
  private int width;
  private int height;
  private int movementSpeed = 8;
  private double jumpSpeed;
  private Rectangle hitBox;
  private boolean falling;
  private int jumping;
  private boolean bounced;
  private boolean jumped;
  private int index;
  private int[] sprites;
  private String direction = "right";
  
  //Parameters for creating a player includes the position, and the size of the player
  Character(int x, int y, int width, int height){
    this.health = true;
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.hitBox = new Rectangle(x+6,y+19,width-17,height-19);
  }
  
  //Method that changes the image of the sprite that will be drawn for the movement animation, and 
  //increases the X value of both the player and the hitbox so that it moves to the right
  public void moveRight(){
    this.direction = "right";
    this.setSprites(48,55);
    if ((this.index < this.sprites[0]) || (this.index > this.sprites[this.sprites.length-1])){
      this.index = this.sprites[0];
    }else{
      this.index++;
    }
    this.setX(this.getX() + movementSpeed);
    this.hitBox.x = (int)this.getX()+3;
  }
  
  //Method that changes the image of the sprite that will be drawn for the movement animation, and 
  //decreases the X value of both the player and the hitbox so that it moves to the left
  public void moveLeft(){
    this.direction = "left";
    this.setSprites(48,55);
    if ((this.index < this.sprites[0]) || (this.index > this.sprites[this.sprites.length-1])){
      this.index = this.sprites[0];
    }else{
      this.index++;
    }
    this.setX(this.getX() - movementSpeed);
    this.hitBox.x = (int)this.getX()+9;    
  }
   
  //Method that decreases the Y value of both the player and the hitbox so that it jumps and also makes it jump slower  
  public void moveUp(int jumpSpeed){
    this.jumpSpeed = jumpSpeed;
    this.jumping++;
    this.setY(this.getY() - jumpSpeed);
    this.hitBox.y = (int)this.getY()+19;
  }
  
  //Method that increases the Y value of both the player and the hitbox so that it falls and also makes it fall faster 
  public void fall(double jumpSpeed){
    if(this.falling == true){
      if (this.jumpSpeed > -14){
        this.jumpSpeed = jumpSpeed - GRAVITY;
      }
      this.setY(this.getY() - jumpSpeed);
      this.hitBox.y = (int)this.getY()+19;
    }
  }
  
  //Method that resets the picture of the player back to the original stance
  public void standStill(){
    this.setSprites(0,15);
    if ((this.index < this.sprites[0]) || (this.index > this.sprites[this.sprites.length-1])){
      this.index = this.sprites[0];
    }else{
      this.index++;
    }
  }
  
  //Method that allows the player to get back up once they have fallen over (Changing the index of the sprite)
  public void rise(){
    this.setSprites(105,112);
    if ((this.index < this.sprites[0]) || (this.index > this.sprites[this.sprites.length-1])){
      this.index = this.sprites[0];
    }else{
      this.index++;
    }
  }
  
  //Drawing method that draws the individual character and will be called later on in the map draw method
  public void draw(Graphics g,Image[]images){
    if (this.direction.equals("right")){
      g.drawImage(images[index],(int)Math.round(this.x)-20,(int)Math.round(this.y)+8,this.width+35,this.height,null);
    }else if (this.direction.equals("left")){
      g.drawImage(images[index],(int)Math.round((this.x)-20+(width*1.5)),(int)Math.round(this.y)+8,0-this.width-35,this.height,null);
    }
    //g.drawRect((int)Math.round(hitBox.getX()),(int)Math.round(hitBox.getY()),(int)Math.round(hitBox.getWidth()),(int)Math.round(hitBox.getHeight()));
  }
  
  //Create getters and setters for the position,size,sprites,direction,speed,health,jumping and falling
  public double getX(){
    return this.x;
  }
  public void setX(double x){
    this.x = x;
  }  
  public double getY(){
    return this.y;
  }  
  public void setY(double y){
    this.y = y;
  }
  public int getWidth(){
    return this.width;
  }  
  public void setWidth(int width){
    this.width = width;
  }
  public int getHeight(){
    return this.height;
  }  
  public void setHeight(int height){
    this.height = height;
  }
  public boolean getHealth(){
    return this.health;
  }
  public void setHealth(boolean health){
    this.health = health;
  }
  public void setDirection(String direction){
    this.direction = direction;
  }
  public String getDirection(){
    return this.direction;
  }
  public int getMovementSpeed(){
    return this.movementSpeed;
  }
  public int getJumping(){
    return this.jumping;
  }
  public void setJumping(int jumping){
    this.jumping = jumping;
  }
  public void setMovementSpeed(int movementSpeed){
    this.movementSpeed = movementSpeed;
  }
  public double getJumpSpeed(){
    return this.jumpSpeed;
  }
  public void setJumpSpeed(double jumpSpeed){
    this.jumpSpeed = jumpSpeed;
  }
  public int getIndex(){
    return this.index;
  }
  public void setIndex(int index){
    this.index = index;
  }
  public Rectangle getHitBox(){
    return this.hitBox;
  }
  public void setHitBox(int x,int y,int width,int height){
    this.hitBox = new Rectangle(x,y,width,height);
  }
  public boolean getFalling(){
    return this.falling;
  }
  public void setFalling(boolean falling){
    this.falling = falling;
  }
  public boolean getBounced(){
    return this.bounced;
  }
  public void setBounced(boolean bounced){
    this.bounced = bounced;
  }
  public boolean getJumped(){
    return this.jumped;
  }
  public void setJumped(boolean jumped){
    this.jumped = jumped;
  }
  public int[] getSprites(){
    return this.sprites;
  }
  public void setSprites(int start, int end){
    this.sprites = new int[end-start+1];
    for (int i = 0; i < end-start+1; i ++){
      this.sprites[i] = start+i;
    }
  }
}

