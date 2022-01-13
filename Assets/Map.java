/* Map.java
 * Authors: Gordon Duan & Parth Kotecha
 * Date: January 22, 2019
 * Description: This is the map class. It is where we do all of the updating for the players, enemies, collectables and blocks.
 */

//Imports
import java.awt.*;
import java.awt.Toolkit;
import java.io.*;
import java.util.Scanner;

//It holds a block array, the two player objects and a method for updating and drawing the map
class Map{
  
  //Declare class variables
  private int X_RES = (int)Math.round(Toolkit.getDefaultToolkit().getScreenSize().width*0.959); 
  private int Y_RES =(int)Math.round(Toolkit.getDefaultToolkit().getScreenSize().height*0.88);
  private int width,height;
  public static final int VISIBLE_WIDTH = 16;
  public static final int VISIBLE_HEIGHT = 8;
  private int boxWidth,boxHeight;
  private String mapName;
  private Block[][]blocks;
  private Player player1,player2;
  private Gem gem;
  private Star star;
  private Enemy enemy;
  private int gemI, gemJ;
  private int starI, starJ;
  private int enemyI,enemyJ;
  private int player1SpawnI, player1SpawnJ;
  private int player2SpawnI, player2SpawnJ;
  
  //Constructor for creating a map with two players, one gem
  Map(String name, int i1,int j1,int i2,int j2,int gI, int gJ)throws Exception{
    this.mapName = name;
    this.player1SpawnI = i1;
    this.player1SpawnJ = j1;
    this.player2SpawnI = i2;
    this.player2SpawnJ = j2;
    this.gemI = gI;
    this.gemJ = gJ;
    this.starI = 0;
    this.starJ = 0;
    loadMap();
  }
  
  //Constructor for creating a map with two players, one enemy and one gem
  Map(String name, int i1,int j1,int i2,int j2,int e1,int e2,int gI, int gJ)throws Exception{
    this.mapName = name;
    this.player1SpawnI = i1;
    this.player1SpawnJ = j1;
    this.player2SpawnI = i2;
    this.player2SpawnJ = j2;
    this.enemyI = e1;
    this.enemyJ = e2;
    this.gemI = gI;
    this.gemJ = gJ;
    this.starI = 0;
    this.starJ = 0;
    loadMap();
    enemy = new Enemy(enemyJ*boxWidth,enemyI*boxHeight,boxWidth,boxHeight);
  }
  
  //Constructor for creating a map with two players, one enemy, one gem, and one star
  Map(String name, int i1,int j1,int i2,int j2, int e1,int e2,int gI, int gJ, int sI, int sJ)throws Exception{
    this.mapName = name;
    this.player1SpawnI = i1;
    this.player1SpawnJ = j1;
    this.player2SpawnI = i2;
    this.player2SpawnJ = j2;
    this.enemyI = e1;
    this.enemyJ = e2;
    this.gemI = gI;
    this.gemJ = gJ;
    this.starI = sI;
    this.starJ = sJ;
    loadMap();
    enemy = new Enemy(enemyJ*boxWidth,enemyI*boxHeight,boxWidth,boxHeight);
    star = new Star(starI*boxWidth,starJ*boxHeight,boxWidth,boxHeight);
  }
  
  //Method for loading the blocks from a text file, the players, and the enemies + gems + star(if required)
  public void loadMap()throws Exception{
    String row;
    File info = new File(mapName);
    Scanner textReader = new Scanner(info);
    this.width = textReader.nextInt();
    this.height = textReader.nextInt();
    this.boxWidth = X_RES/VISIBLE_WIDTH;
    this.boxHeight = Y_RES/VISIBLE_HEIGHT;
    blocks = new Block[this.height][this.width];
    for(int i = 0;i < blocks.length;i++){
      row = textReader.next();
      for(int j = 0;j < blocks[0].length;j++){
        if(Integer.parseInt(row.substring(j,j+1))==1){
          blocks[i][j] = new Block(j*boxWidth,i*boxHeight,boxWidth,boxHeight,(int)Math.round(boxWidth*1.53),(int)Math.round(boxHeight*1.26),Integer.parseInt(row.substring(j,j+1)));
        }else if(Integer.parseInt(row.substring(j,j+1))==2){
          blocks[i][j] = new Slime(j*boxWidth,i*boxHeight,boxWidth,boxHeight,(int)Math.round(boxWidth*1.53),(int)Math.round(boxHeight*1.26),Integer.parseInt(row.substring(j,j+1)));
        }else if(Integer.parseInt(row.substring(j,j+1))==3){
          blocks[i][j] = new Spike(j*boxWidth,i*boxHeight,boxWidth,boxHeight,(int)Math.round(boxWidth*1.53),(int)Math.round(boxHeight*1.26),Integer.parseInt(row.substring(j,j+1)));
        }else if(Integer.parseInt(row.substring(j,j+1))==4){
          blocks[i][j] = new Bounce(j*boxWidth,i*boxHeight,boxWidth,boxHeight,(int)Math.round(boxWidth*1.53),(int)Math.round(boxHeight*1.26),Integer.parseInt(row.substring(j,j+1)));
        }else if(Integer.parseInt(row.substring(j,j+1))==5){
          blocks[i][j] = new Border(j*boxWidth,i*boxHeight,boxWidth,boxHeight,(int)Math.round(boxWidth*1.53),(int)Math.round(boxHeight*1.26),Integer.parseInt(row.substring(j,j+1)));
        }else if(Integer.parseInt(row.substring(j,j+1))==6){
          blocks[i][j] = new Cloud(j*boxWidth,i*boxHeight,boxWidth,boxHeight,(int)Math.round(boxWidth*1.53),(int)Math.round(boxHeight*1.26),Integer.parseInt(row.substring(j,j+1)));
        }else if(Integer.parseInt(row.substring(j,j+1))==7){
          blocks[i][j] = new Ice(j*boxWidth,i*boxHeight,boxWidth,boxHeight,(int)Math.round(boxWidth*1.53),(int)Math.round(boxHeight*1.26),Integer.parseInt(row.substring(j,j+1)));
        }else if(Integer.parseInt(row.substring(j,j+1))==8){
          blocks[i][j] = new Water(j*boxWidth,i*boxHeight,boxWidth,boxHeight,(int)Math.round(boxWidth*1.53),(int)Math.round(boxHeight*1.26),Integer.parseInt(row.substring(j,j+1)));
        }else if(Integer.parseInt(row.substring(j,j+1))==9){
          blocks[i][j] = new Exit(j*boxWidth,i*boxHeight,boxWidth,boxHeight,(int)Math.round(boxWidth*1.53),(int)Math.round(boxHeight*1.26),Integer.parseInt(row.substring(j,j+1)));
        }
      }
    }
    player1 = new Player(player1SpawnJ*boxWidth,player1SpawnI*boxHeight+30,boxWidth-40, boxHeight-10,1,1);
    player2 = new Player(player2SpawnJ*boxWidth,player2SpawnI*boxHeight+30,boxWidth-40, boxHeight-10,2,2);
    gem = new Gem(gemI,gemJ,boxWidth,boxHeight);   
    textReader.close();
  }
  
  //Getters and Setters for players, gems, and star
  public Player getPlayer1(){
    return this.player1;
  }
  public Player getPlayer2(){
    return this.player2;
  }
  public Gem getGem(){
    return this.gem;
  }
  public Star getStar(){
    return this.star;
  }
  
  //Method for drawing the map that calls the individual draw method from the player, enemy, gem, star, and blocks class
  public void draw(Graphics g){
    for(int i=this.height-1;i>=0;i--){
      for (int j=0;j<this.width;j++){
        if((i == player1.i)&&(j==player1.j)){
          player1.draw(g,player1.getImages());
        }
        if((i == player2.i)&&(j==player2.j)){ 
          player2.draw(g,player2.getImages());
        }
        if(blocks[i][j]!=null){
          blocks[i][j].draw(g,j,i);
        }
      }
    }
    //These if statements tell the code to only draw the weapons if the button for shooting is pressed
    if (player1.fired == true){
      player1.getWeapons().draw(g,((FireBall)player1.getWeapons()).getImages());
    }
    if (player2.fired == true){
      player2.getWeapons().draw(g,((IceBall)player2.getWeapons()).getImages());
    }
    
    //Draws the gem on the screen until collected
    if(gem!=null){
      if(!gem.getCollected()){
        gem.draw(g,gem.gemImages);
      }
    }
     
    //Draws the star on the screen until collected
    if ((starI != 0) && (starJ != 0)){
      if(!star.getCollected()){
        star.draw(g,star.getImages());
      }
    }
    if(enemy!=null){
      enemy.draw(g,enemy.getImages());
    }
  }
  
  //Updates the screen with positions of enemies, players, and weapons. 
  public void updateMap(){
    
    //Respawns the players if they are killed
    if(player1.getHealth() == false){
      player1 = new Player(player1SpawnJ*boxWidth,player1SpawnI*boxHeight+30,  boxWidth-40, boxHeight-10,1,1);
    }
    if(player2.getHealth() == false){
      player2 = new Player(player2SpawnJ*boxWidth,player2SpawnI*boxHeight+30,  boxWidth-40, boxHeight-10,2,2);
    }
    if(enemy!=null){
      if(enemy.getHealth()==false){
        enemy = null;
      }
    }
    if(gem!=null){
      if(gem.getCollected()==true){
        gem = null;
      }
    }
//-------------Player 1 Updating Index------------------------------------  
    
    //Changes the player 1 i and j if they pass a certain part of the map
    if((player1.getX()+player1.getWidth()/2) > (player1.j+1)*boxWidth+10){
      player1.j++;
    }else if((player1.getX()+player1.getWidth()/2) < ((player1.j*boxWidth)-15)){
      player1.j--;
    }
    if(player1.getY()+(player1.getHeight()-30) < (player1.i)*boxHeight){
      player1.i--;
    }else if(player1.getY()+(player1.getHeight()/2) > (player1.i+1)*boxHeight){
      player1.i++;
    }
//--------------Player 2 Updating Index-----------------------------------
    
    
    //Changes the player 2 i and j if they pass a certain part of the map
    if((player2.getX()+player2.getWidth()/2) > (player2.j+1)*boxWidth+10){
      player2.j++;
    }else if((player2.getX()+player2.getWidth()/2) < ((player2.j*boxWidth)-15)){
      player2.j--;
    }
    if(player2.getY()+(player2.getHeight()-30) < (player2.i)*boxHeight){
      player2.i--;
    }else if(player2.getY()+(player2.getHeight()/2) > (player2.i+1)*boxHeight){
      player2.i++;
    }
//--------------Player 1 Weapons Updating Index----------------------------------- 
    
    //Changes the player 1 weapon i and j if it passes a certain part of the map
    if (player1.fired == true){
      player1.getWeapons().fire();
      
      if((player1.getWeapons().getX()) > (player1.getWeapons().getJ()+1)*boxWidth+10){
        player1.getWeapons().setJ(player1.getWeapons().getJ()+1);
      }else if((player1.getWeapons().getX()+player1.getWeapons().getWidth()) < ((player1.getWeapons().getJ()*boxWidth)-15)){
        player1.getWeapons().setJ(player1.getWeapons().getJ()-1);
      }
      if(player1.getWeapons().getY()+(player1.getWeapons().getHeight()-10) < (player1.getWeapons().getI())*boxHeight){
        player1.getWeapons().setI(player1.getWeapons().getI()-1);
      }else if(player1.getWeapons().getY()+(player1.getWeapons().getHeight()/2) > (player1.getWeapons().getI()+1)*boxHeight){
        player1.getWeapons().setI(player1.getWeapons().getI()+1);
      }
    }
//--------------Player 2 Weapons Updating Index----------------------------------- 
    
    //Changes the player 1 weapon i and j if it passes a certain part of the map
    if (player2.fired == true){
      player2.getWeapons().fire();
      
      if((player2.getWeapons().getX()) > (player2.getWeapons().getJ()+1)*boxWidth+10){
        player2.getWeapons().setJ(player2.getWeapons().getJ()+1);
      }else if((player2.getWeapons().getX()+player2.getWeapons().getWidth()) < ((player2.getWeapons().getJ()*boxWidth)-15)){
        player2.getWeapons().setJ(player2.getWeapons().getJ()-1);
      }
      if(player2.getWeapons().getY()+(player2.getWeapons().getHeight()) < (player2.getWeapons().getI())*boxHeight){
        player2.getWeapons().setI(player2.getWeapons().getI()-1);
      }else if(player2.getWeapons().getY()+(player2.getWeapons().getHeight()/2) > (player2.getWeapons().getI()+1)*boxHeight){
        player2.getWeapons().setI(player2.getWeapons().getI()+1);
      }
    }
//------------------Enemy Updating Index-----------------------------------
    
    //Changes the enemy i and j if it passes a certain part of the map
    if(enemy!=null){
      if((enemy.getX()+enemy.getWidth()/2) > (enemy.j+1)*boxWidth+10){
        enemy.j++;
      }else if((enemy.getX()+enemy.getWidth()/2) < ((enemy.j*boxWidth)-15)){
        enemy.j--;
      }
      if(enemy.getY()+(enemy.getHeight()-30) < (enemy.i)*boxHeight){
        enemy.i--;
      }else if(player2.getY()+(enemy.getHeight()/2) > (enemy.i+1)*boxHeight){
        enemy.i++;
      }
//------------------Enemy Movement and Collision----------------------------------------- 
      
      //Detects for enemy collision with the blocks
      enemy.attackPlayer(player1,player2);
      if((blocks[enemy.i][enemy.j-1] == null) || (!enemy.getHitBox().intersects(blocks[enemy.i][enemy.j-1].getHitBox()))){
        enemy.moveLeft();
      }
      if((blocks[enemy.i][enemy.j+1] == null) || (!enemy.getHitBox().intersects(blocks[enemy.i][enemy.j+1].getHitBox()))){
        enemy.moveRight();
      }
      if(enemy.getHitBox().intersects(player1.getHitBox())){
        player1.setHealth(false);
      }
      if(enemy.getHitBox().intersects(player2.getHitBox())){
        player2.setHealth(false);
      }
      
      //Kills the enemy if the player weapons collide
      if(player1.fired){
        if(player1.getWeapons().getHitBox().intersects(enemy.getHitBox())){
          enemy.setHealth(false);
          player1.fired = false;
        }
      }
      if(player2.fired){
        if(player2.getWeapons().getHitBox().intersects(enemy.getHitBox())){
          enemy.freeze();
          player2.fired = false;
        }
      }
    }
    
    //Detects for collision between player 1 and player 2 with the gems and with the star
    if(gem!=null){
      if((player1.getHitBox().intersects(gem.getHitBox())||(player2.getHitBox().intersects(gem.getHitBox())))&&(!gem.getCollected())){
        gem.setCollected(true);
      }
      if(player2.fired){
        if((player2.getWeapons().getHitBox().intersects(gem.getHitBox()))&&(!gem.getCollected())){
          gem.setCollected(true);
        }
      }
    }
    if ((starI != 0) && (starJ != 0)){
      if((player1.getHitBox().intersects(star.getHitBox())||(player2.getHitBox().intersects(star.getHitBox())))&&(!star.getCollected())){
        star.setCollected(true);
      }
    }
    
    //------------------Player 1 Collision-------------------------------------
    
    //Detects for collision with player 1 and the blocks. It is also where we call the block ability methods
    if ((blocks[player1.i+1][player1.j] != null)&&((player1.getHitBox().intersects(blocks[player1.i+1][player1.j].getHitBox())))){
      blocks[player1.i+1][player1.j].useAbility(player1);
      player1.setFalling(false);
      player1.setJumped(false);
    }else{
      player1.setFalling(true);
    }
    player1.fall(player1.getJumpSpeed());
    if(player1.getLeft() == true){
      if ((blocks[player1.i][player1.j-1] == null) || (!player1.getHitBox().intersects(blocks[player1.i][player1.j-1].getHitBox()))){
        player1.moveLeft();
      }else{
        if(blocks[player1.i][player1.j-1]instanceof Bounce){
          ((Bounce)blocks[player1.i][player1.j-1]).useAbilityRight(player1);
        }
      }
    }
    if(player1.getRight() == true){
      if ((blocks[player1.i][player1.j+1] == null) || (!player1.getHitBox().intersects(blocks[player1.i][player1.j+1].getHitBox()))){
        player1.moveRight();
      }else{
        if(blocks[player1.i][player1.j+1]instanceof Bounce){
          ((Bounce)blocks[player1.i][player1.j+1]).useAbilityLeft(player1);
        }
      }
    }
    if ((player1.getUp() == true) && (player1.getJumping() < 3)){
      if ((blocks[player1.i-1][player1.j]  == null) || (!player1.getHitBox().intersects(blocks[player1.i-1][player1.j].getHitBox()))){
        player1.moveUp(16);
      }else{
        player1.setJumpSpeed(0);
      }
    }
    
//------------------Player 2 Collision-----------------------------------
    
    //Detects for collision with player 2 and the blocks. It is also where we call the block ability methods
    if((blocks[player2.i+1][player2.j] != null)&&((player2.getHitBox().intersects(blocks[player2.i+1][player2.j].getHitBox())))){
      blocks[player2.i+1][player2.j].useAbility(player2);
      player2.setFalling(false);
      player2.setJumped(false);
    }else{
      player2.setFalling(true);
    }
    player2.fall(player2.getJumpSpeed());
    if(player2.getLeft() == true){
      if ((blocks[player2.i][player2.j-1] == null) || (!player2.getHitBox().intersects(blocks[player2.i][player2.j-1].getHitBox()))){
        player2.moveLeft();
      }else{
        if(blocks[player1.i][player1.j-1]instanceof Bounce){
          ((Bounce)blocks[player1.i][player1.j-1]).useAbilityRight(player1);
        }
      }
    }
    if(player2.getRight() == true){
      if ((blocks[player2.i][player2.j+1] == null) || (!player2.getHitBox().intersects(blocks[player2.i][player2.j+1].getHitBox()))){
        player2.moveRight();
      }else{
        if(blocks[player1.i][player1.j+1]instanceof Bounce){
          ((Bounce)blocks[player1.i][player1.j+1]).useAbilityLeft(player1);
        }
      }
    }
    if ((player2.getUp() == true) && (player2.getJumping() < 3)){
      if ((blocks[player2.i-1][player2.j]  == null) || (!player2.getHitBox().intersects(blocks[player2.i-1][player2.j].getHitBox()))){
        player2.moveUp(16);
      }else{
        player2.setJumpSpeed(0);
      }
    }
//------------------Player 1 Weapon Collision-----------------------------------
    
    //This is where we detect collision with player 1 weapon and player 2. It also gets rid of the weapon if they are off the screen
    if (player1.fired == true){
      if(player1.getWeapons().getHitBox().intersects(player2.getHitBox())){
        player1.fired = false;
        player2.setHealth(false);
      }
      if ((player1.getWeapons().getJ() < 1) || (player1.getWeapons().getJ() > 14)){
        player1.fired = false;
      }
      if (blocks[player1.getWeapons().getI()][player1.getWeapons().getJ()+1]!= null){
        if ((player1.getWeapons().getHitBox().intersects(blocks[player1.getWeapons().getI()][player1.getWeapons().getJ()+1].getHitBox()))){
          player1.fired = false;
        }
      }
      if (blocks[player1.getWeapons().getI()][player1.getWeapons().getJ()-1]!= null){
        if ((player1.getWeapons().getHitBox().intersects(blocks[player1.getWeapons().getI()][player1.getWeapons().getJ()-1].getHitBox()))){
          player1.fired = false;
        }
      }
    }
//------------------Player 2 Weapon Collision-----------------------------------
    
    //This is where we detect collision with player 2 weapon and player 1. It also gets rid of the weapon if they are off the screen
    if (player2.fired == true){
      if(player2.getWeapons().getHitBox().intersects(player1.getHitBox())){
        player2.fired = false;
        player1.setMovementSpeed(2);
      }
      if ((player2.getWeapons().getJ() < 1) || (player2.getWeapons().getJ() > 14)){
        player2.fired = false;
      }
      if (blocks[player2.getWeapons().getI()][player2.getWeapons().getJ()+1]!= null){
        if ((player2.getWeapons().getHitBox().intersects(blocks[player2.getWeapons().getI()][player2.getWeapons().getJ()+1].getHitBox()))){
          player2.fired = false;
        }
      }
      if (blocks[player2.getWeapons().getI()][player2.getWeapons().getJ()-1]!= null){
        if ((player2.getWeapons().getHitBox().intersects(blocks[player2.getWeapons().getI()][player2.getWeapons().getJ()-1].getHitBox()))){
          player2.fired = false;
        }
      }
    }
  }
}