package code;
import java.util.Random;
public class Meteorite extends Sprite {
    private int selectImg;
    private String imgName;
    public Meteorite(int x, int y)
    {
        super(x,y);
        initMeteorite();
    }
    void initMeteorite()
    {
        Random random = new Random();
        selectImg  =  random.nextInt(9)+1;
        visible = false;
        loadImage("src/images/meteorite1.png");
        getImageDimensions();
    }
    public void loadImage(){
        String ImgName = "src/images/meteorite" + selectImg + ".png";
        loadImage(ImgName);
    }
    public void setSelectImg(int i){
        selectImg =  i;
    }
    public int getSelectImg(){
        return selectImg;
    }
    public void move()
    {
        x-=7;
        y+=7;
        if(y>800 || x<0 ) visible = false;

    }
}
