/* Enemy.java
 * Authors: Gordon Duan & Parth Kotecha
 * Date: January 22, 2019
 * Description: This is the enemy class.
 */

//Imports
import java.awt.*;

class Enemy extends Character{
  
  //Declares class variables
  private int closestJ;
  public int i,j; 
  private boolean frozen;
  private Image[]enemyImages;
  
  //Parameters for the enemy position and size
  Enemy(int x, int y, int width, int height){
    super(x,y,width,height);
    this.setY(this.getY()+25);
    this.setMovementSpeed(8);
    enemyImages = new Image[4];
    for(int i = 0;i<4;i++){
      enemyImages[i] = Toolkit.getDefaultToolkit().getImage("enemy"+ (i+1) + ".png");
    }
    this.setHitBox((int)this.getX()-15,(int)this.getY()+5,this.getWidth()-10,this.getHeight()-5);
  }
  
  //Method to find the distance between two points
  public double findClosest(int i,int j){
    double distance = Math.sqrt(Math.pow(this.i-i,2)+Math.pow(this.j-j,2));
    return distance;
  }
  
  //Method for movement and attacking the player
  public void moveLeft(){
    this.setDirection("left");
    this.setX(this.getX() - this.getMovementSpeed());
    this.setHitBox((int)this.getX()-15,(int)this.getY()+5,this.getWidth()-10,this.getHeight()-5);
  }
  public void moveRight(){
    this.setDirection("right");
    this.setX(this.getX() + this.getMovementSpeed());
    this.setHitBox((int)this.getX()-15,(int)this.getY()+5,this.getWidth()-10,this.getHeight()-5);
  }
  
  //Method to determine which direction the enemy will move in. It takes in two players
  public void attackPlayer(Player p1, Player p2){
    
    //Determines which of the two players is closer and decides the movement based on the position of the closer player
    if(this.findClosest(p1.i,p1.j)<=(this.findClosest(p2.i,p2.j))){
      this.closestJ = p1.j;
    }else{
      this.closestJ = p2.j;
    }
    if(this.j > this.closestJ){
      this.moveLeft();
    }else if(this.j < this.closestJ){
      this.moveRight();
    }
  }
  
  //Method that slows the enemy if it has been hit by the iceball
  public void freeze(){
    this.frozen = true;
    this.setMovementSpeed(2);
  }
  
  //Getter for images
  public Image[] getImages(){
    return this.enemyImages;
  }
  
  //Method that overrides the draw method in the character class. It draws the enemy
  public void draw(Graphics g,Image[]images){
    if(this.frozen){
      if((this.getIndex()<3)&&(this.getIndex()>=2)){
        this.setIndex(this.getIndex()+1);
      }else{
        this.setIndex(2);
      }
    }else{
      if(this.getIndex()<1){
        this.setIndex(this.getIndex()+1);
      }else{
        this.setIndex(0);
      }
    }   
    g.drawImage(images[this.getIndex()],(int)Math.round(this.getX()),(int)Math.round(this.getY()),this.getWidth(),this.getHeight(),null);
  }
}



