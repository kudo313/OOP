package code;

public class Missile1  extends Sprite
{
    private boolean isBreak=false;
    private int selectImg =  1;
    private  int MISSILE_SPEED = 4;

    public Missile1(int x, int y)
    {
        super(x, y);
        initMissile();
    }
    public boolean getisBreak(){
        return isBreak;
    }
    public void setSelectImg(int i){
        selectImg = i;
    }

    public int getSelectImg(){
        return selectImg;
    }
    private void initMissile() {

        loadImage("src/images/missile1.png");
        getImageDimensions();
    }
    public void loadImage(){
        String s = "src/images/missile1break" + selectImg + ".png";
    }
    public void move()
    {

        y += MISSILE_SPEED;

        if (y>835) {
            visible = false;
            isBreak  = true;
        }
    }
}