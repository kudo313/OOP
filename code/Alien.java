package code;

public class Alien extends Sprite
{
    private int limitMove;
    private final int INITIAL_X = 10;
    private int selectImg=10;
    public Alien(int x, int y)
    {
        super(x, y);
        initAlien();
    }

    private void initAlien()
    {
        loadImage("src/images/alien1.png");
        getImageDimensions();
    }
    public void loadImage(){
        String s = "src/images/alien" + selectImg + ".png";
        loadImage(s);
        getImageDimensions();
    }
    public void setSelectImg(int i){
        selectImg = i;
    }
    public int getSelectImg(){
        return  selectImg;
    }
    public int getLimitMove(){
        return limitMove;
    }
    public void setLimitMove(int i ){
        limitMove = i;
    }
    public void move()
    {
        if (y < limitMove) y++;
        x+=2;
        if(x > 700)
        {
            x=10;
            y++;
        }
        if(y>700)
        {
            y=10;
            x=10;
        }
    }
}