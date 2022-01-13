/* Exit.java
 * Authors: Gordon Duan & Parth Kotecha
 * Date: January 22, 2019
 * Description: This is the exit block
 */

class Exit extends Block{
  Exit(int x, int y,int width,int height,int boxWidth, int boxHeight, int type){
    super(x,y,width,height,boxWidth,boxHeight,type);
  }
  public void useAbility(Player player){
    player.setGameOver(true);
  }
}