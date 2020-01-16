class Spike extends Block{
  Spike(int x, int y,int width,int height,int boxWidth, int boxHeight, int type){
    super(x,y,width,height,boxWidth,boxHeight,type);

  }
  public void useAbility(Player player){
    player.setHealth(false);
  }
}