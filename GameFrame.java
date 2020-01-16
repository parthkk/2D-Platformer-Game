///* GameFrame.java
// * Authors: Gordon Duan & Parth Kotecha
// * Date: January 22, 2019
// * Description: This is the main program that runs the Game
// */
//
////Graphics &GUI imports
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import java.awt.Toolkit;
//import java.awt.Graphics;
//import java.awt.Color;
//
////Keyboard imports
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//
////Mouse imports
//import java.awt.event.MouseListener;
//import java.awt.event.MouseEvent;
//
////Audio Imports
//import java.io.File;
//import javax.sound.sampled.*;
//
//
//class GameFrame extends JFrame { 
//  private static final long serialVersionUID = 7526472295622776147L;  // unique id
//  
//  //class variable (non-static)
//  static double x,y;
//  static GameAreaPanel gamePanel;
//  private Map world;
//  JFrame thisFrame;
//  //Constructor - this runs first
//  GameFrame(){ 
//    
//    super("Gordon and Parth's Game");  
//    this.thisFrame = this;
//    // Set the frame to full screen 
//    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    int maxX = Toolkit.getDefaultToolkit().getScreenSize().width;
//    int maxY = (int)Math.round(Toolkit.getDefaultToolkit().getScreenSize().height*0.957);
//    this.setSize(maxX,maxY);
//    //this.setUndecorated(true);  //Set to true to remove title bar
//    this.setResizable(true);
//    
//    
//    
//    //Set up the game panel (where we put our graphics)
//    gamePanel = new GameAreaPanel();
//    this.add(new GameAreaPanel());
//    
//    MyKeyListener keyListener = new MyKeyListener();
//    this.addKeyListener(keyListener);
//    
//    MyMouseListener mouseListener = new MyMouseListener();
//    this.addMouseListener(mouseListener);
//    
//    this.requestFocusInWindow(); //make sure the frame has focus   
//    
//    this.setVisible(true);
//    
//    //Start the game loop in a separate thread
//    Thread t = new Thread(new Runnable() { public void run() { animate(); }}); //start the gameLoop 
//    t.start();
//    
//    //Loading the audio and playing it. We have a bug where if the audio works the play again doesn't work and vice versa.
////    try {
////      File audioFile = new File("soundtrack2.wav");
////      AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
////      DataLine.Info info = new DataLine.Info(Clip.class, audioStream.getFormat());
////      Clip clip = (Clip) AudioSystem.getLine(info);
////      
////      clip.open(audioStream);
////      clip.start();
////      
////      //delay 10 seconds
////      try {
////        Thread.sleep(500000);
////      } catch (InterruptedException ex) {
////        ex.printStackTrace();
////      }
////      clip.close();
////    }catch (Exception e) {
////      e.printStackTrace();
////    }
//  } //End of Constructor
//  
//  //the main gameloop - this is where the game state is updated
//  public void animate() {
//    
//    while(true){
//      try{ Thread.sleep(10);} catch (Exception exc){}  //delay
//      this.repaint();
//    }    
//  }
//  
//  /** --------- INNER CLASSES ------------- **/
//  
//  // Inner class for the the game area - This is where all the drawing of the screen occurs
//  private class GameAreaPanel extends JPanel {
//    //Declare variables for the collected gems and stars
//    int count = 0;
//    int collectedGems = 0;
//    boolean collectedStar;
//    private static final long serialVersionUID = 7526472295622776147L;  // unique id
//    private String section;
//    public GameAreaPanel(){
//      try{
//        world = new Map("topLeft.txt", 1, 1, 5, 1, 6, 11, 6, 7);
//        section = "topLeft";       
//      }
//      catch(Exception e){
//        e.printStackTrace();
//      }
//    }
//    public void paintComponent(Graphics g) {
//      //Redraws the screen
//      super.paintComponent(g); //required
//      setDoubleBuffered(true);
//      Color background = new Color(151, 233, 252);
//      g.setColor(background);
//      g.fillRect(0,0,1920,1080);
//      
//      //Chooses which map to load depending on the player i and j.
//      if((((world.getPlayer1().j > 14)||(world.getPlayer2().j > 14))&&(section.equals("topLeft")))){
//        try{
//          world = new Map("topMiddle.txt",4,3,4,2,6,13,1,1);
//          world.getPlayer1().i = 5;
//          section = "topMiddle";
//        }
//        catch(Exception e){
//          e.printStackTrace();
//        }
//      }else if (((world.getPlayer1().j > 14) || (world.getPlayer2().j > 14)) && (section.equals("topMiddle"))){
//        try{
//          world = new Map("topRight.txt", 1, 1, 1, 2,6,2);
//          world.getPlayer1().i = 5;
//          section = "topRight";
//        }
//        catch(Exception e){
//          e.printStackTrace();
//        }
//      }else if (((world.getPlayer1().i > 6) || (world.getPlayer2().i > 6)) && (section.equals("topRight"))){
//        try{
//          world = new Map("bottomRight.txt",1,11,1,12,2,1,1,1,13,1);
//          section = "bottomRight";
//        }
//        catch(Exception e){
//          e.printStackTrace();
//        }
//      }else if (((world.getPlayer1().j < 1) || (world.getPlayer2().j < 1)) && (section.equals("bottomRight"))){
//        try{
//          world = new Map("bottomMiddle.txt", 4, 13, 5, 14,5,2,5,1);
//          section = "bottomMiddle";
//        }
//        catch(Exception e){
//          e.printStackTrace();
//        }
//      }else if (((world.getPlayer1().j < 1) || (world.getPlayer2().j < 1)) && (section.equals("bottomMiddle"))){
//        try{
//          world = new Map("bottomLeft.txt", 1, 13, 1, 14,5,8);
//          section = "bottomLeft";
//        }
//        catch(Exception e){
//          e.printStackTrace();
//        }
//      }
//      //Calls update map and updates the number of gems and stars collected
//      world.updateMap();
//      if(world.getGem()!=null){
//        if(world.getGem().getCollected() == true){
//          collectedGems++;
//        }
//      }
//      if(world.getStar()!=null){
//        if(world.getStar().getCollected()){
//          collectedStar = true;
//        }
//      }
//      if(((world.getPlayer1().getGameOver()==true)||(world.getPlayer2().getGameOver()==true))&&(count==0)){
//        thisFrame.dispose();
//        new EndFrame(collectedGems,collectedStar);
//        count++;
//      }
//      world.draw(g);
//    }
//  }
//// -----------  Inner class for the keyboard listener - this detects key presses and runs the corresponding code
//  private class MyKeyListener implements KeyListener {
//    public void keyTyped(KeyEvent e) {  
//    }
//    public void keyPressed(KeyEvent e) {
//      if (KeyEvent.getKeyText(e.getKeyCode()).equals("D")){  //If 'D' is pressed
//        world.getPlayer1().setRight(true);
//      }else if (KeyEvent.getKeyText(e.getKeyCode()).equals("A")){  //If 'A' is pressed
//        world.getPlayer1().setLeft(true);
//      }else if (KeyEvent.getKeyText(e.getKeyCode()).equals("W")){
//        if (world.getPlayer1().getJumped() == false){
//          world.getPlayer1().setJumped(true);
//          world.getPlayer1().setUp(true);
//        }else if ((world.getPlayer1().getJumped() == true)){
//          world.getPlayer1().setUp(false);
//        }
//      }else if (KeyEvent.getKeyText(e.getKeyCode()).equals("E")){
//        world.getPlayer1().setWeapon();
//      }else if (KeyEvent.getKeyText(e.getKeyCode()).equals("M")){
//        world.getPlayer2().setWeapon();
//      }else if (KeyEvent.getKeyText(e.getKeyCode()).equals("S")){
//        world.getPlayer1().setDown(true);
//      }else if (e.getKeyCode()==37) {  //If left arrow is pressed
//        world.getPlayer2().setLeft(true);
//      }else if (e.getKeyCode()==39) {  //If right arrow is pressed
//        world.getPlayer2().setRight(true);
//      }else if (e.getKeyCode()==38) { //If up arrow is pressed
//        if (world.getPlayer2().getJumped() == false){
//          world.getPlayer2().setJumped(true);
//          world.getPlayer2().setUp(true);
//        }else if ((world.getPlayer2().getJumped() == true)){
//          world.getPlayer2().setUp(false);
//        }
//      }
//    }
//    public void keyReleased(KeyEvent e){
//      if (KeyEvent.getKeyText(e.getKeyCode()).equals("D")) { // If D key is released
//        world.getPlayer1().setRight(false);
//        world.getPlayer1().standStill();
//      }else if (KeyEvent.getKeyText(e.getKeyCode()).equals("A")) { // If A key is released
//        world.getPlayer1().setLeft(false);
//        world.getPlayer1().standStill();
//      }else if (KeyEvent.getKeyText(e.getKeyCode()).equals("W")) {
//        world.getPlayer1().setUp(false);
//        world.getPlayer1().setJumping(0);
//      }else if (KeyEvent.getKeyText(e.getKeyCode()).equals("S")) {
//        world.getPlayer1().setUp(false);
//        world.getPlayer1().rise();
//      }else if (e.getKeyCode()==37) { // If left arrow is released
//        world.getPlayer2().setLeft(false);
//        world.getPlayer2().standStill();
//      }else if (e.getKeyCode()==39) { // If left arrow is released
//        world.getPlayer2().setRight(false);
//        world.getPlayer2().standStill();
//      }else if (e.getKeyCode()==38) {
//        world.getPlayer2().setUp(false);
//        world.getPlayer2().setJumping(0);
//      }
//    }
//  } //end of keyboard listener
//// -----------  Inner class for the keyboard listener - This detects mouse movement & clicks and runs the corresponding methods 
//  private class MyMouseListener implements MouseListener {
//    
//    public void mouseClicked(MouseEvent e){
//      System.out.println("Mouse Clicked");
//      System.out.println("X:"+e.getX() + " y:"+e.getY());
//    }
//    
//    public void mousePressed(MouseEvent e){
//    }
//    
//    public void mouseReleased(MouseEvent e){
//    }
//    
//    public void mouseEntered(MouseEvent e){
//    }
//    
//    public void mouseExited(MouseEvent e){
//    }
//  } //end of mouselistener
//  public static void main(String[] args){ 
//    new GameFrame();
//  }
//}