class Water extends Block{
  Water(int x, int y,int width,int height,int boxWidth, int boxHeight, int type){
    super(x,y,width,height,boxWidth,boxHeight,type);
    this.setHitBox(x,y+40,width,height-30);
  }
  public void useAbility(Player player){
    player.setHealth(false);
  }
}