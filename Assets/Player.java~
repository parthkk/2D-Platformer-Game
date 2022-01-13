///* Player.java
// * Authors: Gordon Duan & Parth Kotecha
// * Date: January 22, 2019
// * Description: This is the player class. It creates a player that gets added on to the map
// */
//
////Imports
//import java.awt.*;
//
//class Player extends Character{
//  
////Declares class variables 
//  private Image[]playerImages;
//  private int team;
//  private boolean left,right,up,down;
//  public int i,j;
//  private Weapon weapons;
//  private boolean gameOver;
//  private int weapon;
//  public boolean fired;
//  
//  //Parameters for creating a player includes position, size, team, and weapon
//  Player(int x, int y, int width, int height, int team,int weapon){
//    super(x, y, width, height );
//    this.team = team;
//    this.weapon = weapon;
//    this.fired = false;
//    playerImages = new Image[256];
//    for (int i = 0; i<256; i++){
//      if (i<10){
//        playerImages[i]=Toolkit.getDefaultToolkit().getImage("Player" + team + "00" + i + ".png");
//      }else if(i<100){
//        playerImages[i]=Toolkit.getDefaultToolkit().getImage("Player" + team + "0" + i + ".png");
//      }else{
//        playerImages[i]=Toolkit.getDefaultToolkit().getImage("Player" + team + i + ".png");
//      }                           
//    }
//  }
//  
//  //Getters and Setters for direction, game over, and weapons and images
//  public boolean getGameOver(){
//    return this.gameOver;
//  }
//  public void setGameOver(boolean gameOver){
//    this.gameOver = gameOver;
//  }
//  public boolean getLeft(){
//    return this.left;
//  }
//  public boolean getRight(){
//    return this.right;
//  }
//  public boolean getDown(){
//    return this.down;
//  }
//  public boolean getUp(){
//    return this.up;
//  }
//  public void setLeft(boolean left){
//    this.left = left;
//  }
//  public void setRight(boolean right){
//    this.right = right;
//  }
//  public void setUp(boolean up){
//    this.up = up;
//  }
//  public void setDown(boolean down){
//    this.down = down;
//  }
//  public int getTeam(){
//    return this.team;
//  }
//  public Weapon getWeapons(){
//    return this.weapons;
//  }
//  public void setWeapon(){
//    this.fired = true;
//    if (weapon == 1){
//      this.weapons = new FireBall((int)this.getX(),(int)this.getY(),this.getWidth(),this.getHeight(), this.getDirection());
//    }else if (weapon == 2){
//      this.weapons = new IceBall((int)this.getX(),(int)this.getY(),this.getWidth(),this.getHeight(), this.getDirection());
//    }
//  }
//  public Image[] getImages(){
//    return this.playerImages;
//  }   
//}
//
//
//
//
