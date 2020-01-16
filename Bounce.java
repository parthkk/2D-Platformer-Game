/* Bounce.java
 * Authors: Gordon Duan & Parth Kotecha
 * Date: January 22, 2019
 * Description: The bounce block
 */

class Bounce extends Block{
  Bounce(int x, int y,int width,int height,int boxWidth, int boxHeight, int type){
    super(x,y,width,height,boxWidth,boxHeight,type);
  }
  public void useAbility(Player player){
    player.moveUp(35);
  }
  public void useAbilityRight(Player player){
    player.setLeft(false);
    player.moveUp(20);
    player.setMovementSpeed(15);
    player.setRight(true);
    player.setBounced(true);
  }
  public void useAbilityLeft(Player player){
    player.setRight(false);
    player.moveUp(20);
    player.setMovementSpeed(20);
    player.setLeft(true);
    player.setBounced(true);
  }
}