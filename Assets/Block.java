/* Block.java
 * Authors: Gordon Duan & Parth Kotecha
 * Date: January 22, 2019
 * Description: This is the block objects that will make up our map
 */

//Imports 
import java.awt.*;

//Create a class for the block objects that will make up our map
class Block{
  
  //Declare Class Variables
  private int width,height;
  private int boxWidth,boxHeight;
  private int type;
  private Rectangle hitBox;
  private Image[]images;
  
  //Parameters for blocks include position,size and type
  Block(int x, int y, int width,int height,int boxWidth, int boxHeight, int type){
    this.type = type;
    this.width = width;
    this.height = height;
    this.boxWidth = (int)Math.round(width*1.53);
    this.boxHeight = (int)Math.round(height*1.26);
    this.hitBox = new Rectangle(x+14,y+20,boxWidth-60,boxHeight-45);
    
    //Set the different images for the blocks
    images = new Image[9];
    images[0]=Toolkit.getDefaultToolkit().getImage("Default.png");
    images[1]=Toolkit.getDefaultToolkit().getImage("Slime.png");
    images[2]=Toolkit.getDefaultToolkit().getImage("Spike.png");
    images[3]=Toolkit.getDefaultToolkit().getImage("Bounce.png");
    images[4]=Toolkit.getDefaultToolkit().getImage("Border.png");
    images[5]=Toolkit.getDefaultToolkit().getImage("Cloud2.png");
    images[6]=Toolkit.getDefaultToolkit().getImage("Ice2.png");
    images[7]=Toolkit.getDefaultToolkit().getImage("Water.png");
    images[8]=Toolkit.getDefaultToolkit().getImage("Exit.png");
  }
  
  //Method that gets overwritten by some blocks and inherited by other blocks that is used when the player steps on the block
  public void useAbility(Player player){
    if(player.getMovementSpeed()!=2){
      player.setMovementSpeed(8);
    }
    if(player.getBounced() == true){
      player.setRight(false);
      player.setLeft(false);
      player.setBounced(false);
    }
  }
  
  //Getters and Setters for block hitbox
  public Rectangle getHitBox(){
    return this.hitBox;
  }
  public void setHitBox(int x,int y,int width,int height){
    this.hitBox = new Rectangle(x,y,width,height);
  }
  
  //Create a draw method that draw the individual blocks to the screen
  public void draw(Graphics g,int xScreen,int yScreen){
    g.setColor(Color.BLACK);
    if(this.type != 0){
      g.drawImage(images[type-1],xScreen*width,yScreen*height,boxWidth,boxHeight,null);
      //g.drawRect((int)Math.round(hitBox.getX()),(int)Math.round(hitBox.getY()),(int)Math.round(hitBox.getWidth()),(int)Math.round(hitBox.getHeight()));
    }
  }
}

