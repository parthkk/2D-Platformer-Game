/* Cloud.java
 * Authors: Gordon Duan & Parth Kotecha
 * Date: January 22, 2019
 * Description: This is cloud block. 
 */

class Cloud extends Block{
  Cloud(int x, int y,int width,int height,int boxWidth, int boxHeight, int type){
    super(x,y,width,height,boxWidth,boxHeight,type);
    this.setHitBox(x+6,y+19,width,height-100);
  }
}