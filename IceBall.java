/* Iceball.java
 * Authors: Gordon Duan & Parth Kotecha
 * Date: January 22, 2019
 * Description: This is the iceball class
 */

import java.awt.*;
class IceBall extends Weapon{
  private Image[] iceImages;
  IceBall(int x, int y, int width, int height, String direction){
    super(x,y,width,height, direction);
    iceImages = new Image[8];
    for (int k = 0; k<8; k++){
      iceImages[k] = Toolkit.getDefaultToolkit().getImage("iceball" + k + ".png");
    }
  }
  public void fire(){
    if (getDirection().equals("right")){
      this.setX(this.getX()+10);
      this.hitBox.x = this.getX()-40;
      this.hitBox.y = this.getY()+30;
    }else{
      this.setX(this.getX()-10);
      this.hitBox.x = this.getX();
      this.hitBox.y = this.getY()+30;
    }
  }
  public Image[] getImages(){
    return this.iceImages;
  }   
}