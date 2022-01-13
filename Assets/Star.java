import java.awt.*;
class Star extends Collectables{
  private Image[] starImages;
  
  Star(int i, int j,int width, int height){
    super(i,j,width,height);
    this.setHitBox(i,j,getWidth(),getHeight());
    starImages = new Image[8];
    for (int k = 0; k<8; k++){
      starImages[k] = Toolkit.getDefaultToolkit().getImage("star" + k + ".png");
    }
  }
  public Image[] getImages(){
    return this.starImages;
  }   
}