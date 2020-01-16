/* Ice.java
 * Authors: Gordon Duan & Parth Kotecha
 * Date: January 22, 2019
 * Description: This is the ice block
 */

class Ice extends Block{
  Ice(int x, int y,int width,int height,int boxWidth, int boxHeight, int type){
    super(x,y,width,height,boxWidth,boxHeight,type);
  }
  public void useAbility(Player player){
    if(player.getMovementSpeed()!=2){
      player.setMovementSpeed(13);
    }
    if(player.getBounced() == true){
      player.setRight(false);
      player.setLeft(false);
      player.setBounced(false);
    }
  }
}