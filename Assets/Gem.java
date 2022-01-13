/* GameFrame.java
 * Authors: Gordon Duan & Parth Kotecha
 * Date: January 22, 2019
 * Description: This is the gem class
 */

import java.awt.*;
class Gem extends Collectables{
  public Image[] gemImages;
  
  Gem(int i, int j,int width, int height){
    super(i,j,width,height);
    this.setWidth(this.getWidth()-40);
    this.setHeight(this.getHeight()-40);
    gemImages = new Image[8];
    for (int k = 0; k<8; k++){
      gemImages[k] = Toolkit.getDefaultToolkit().getImage("gem" + k + ".png");
    }
  }
}