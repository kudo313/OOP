package code;

public class BossHP extends Sprite{
    private String hpnow;
    public BossHP(int x, int y,int hp){
        super(x,y);
        initHP(hp);
        getImageDimensions();

    }
    public void initHP(int hp){
         hpnow = "src/images/HP" + hp + ".jpg";
         loadImage(hpnow);
    }
    public String getHpnow(){
        return hpnow;
    }
    public void setHpnow(int hp){
        hpnow = "src/images/HP" + hp + ".jpg";
    }
    protected void loadImage() {
        super.loadImage(hpnow);
    }
}
