class Slime extends Block{
  Slime(int x, int y,int width,int height,int boxWidth, int boxHeight, int type){
    super(x,y,width,height,boxWidth,boxHeight,type);
  }
  public void useAbility(Player player){
    if(player.getMovementSpeed()!=2){
      player.setMovementSpeed(5);
    }
    if(player.getBounced() == true){
      player.setRight(false);
      player.setLeft(false);
      player.setBounced(false);
    }
  }
}