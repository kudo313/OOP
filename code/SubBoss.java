package code;

import java.util.ArrayList;
import java.util.List;

public class SubBoss extends  Sprite {
    private  int selectImg=1;
    private int dx=1;
    public int i=0;
    private List<Missile3> missiles;
    private int hp=20;
    public SubBoss(int x, int y)
    {
        super(x,y);
        initBoss();
    }
    public int getHP()
    {
        return hp;
    }
    public void setHP(int x)
    {
        this.hp=x;
    }

    public void initBoss()
    {
        visible = false;
        missiles = new ArrayList<>();
        loadImage("src/images/subboss1.png");
        getImageDimensions();
    }
    public int getSelectImg(){
        return selectImg;
    }
    public void setSelectImg(int i){
        selectImg = i;
    }
    public void loadImage(){
        String s = "src/images/subboss" + selectImg +".png";
        loadImage(s);
    }

    public void setDx(int i ){
        dx = i;
    }

    public void move()
    {
        x+=dx;
        if(x > 700)
        {
            x=10;

        }
        if (x<0)
        {
            x=700;
        }

    }
}
