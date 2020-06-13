package code;

import java.util.ArrayList;
import java.util.List;

public class Boss extends Sprite
{
    private  int selectImg=1;
     public int i=0;
     private List<Missile2> missiles;
     private int hp=20;
     public Boss(int x, int y)
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
         loadImage("src/images/boss.png");
         getImageDimensions();
     }
     public int getSelectImg(){
         return selectImg;
     }
     public void setSelectImg(int i){
         selectImg = i;
     }
     public void loadImage(){
         String s = "src/images/boss" + selectImg +".png";
         loadImage(s);
         getImageDimensions();
     }
    public List<Missile2> getMissiles2()
    {
        return missiles;
    }
    public void fire()
    {
        missiles.add(new Missile2(x + width/2-5, y + height ));
    }

    public void move()
    {
        if (y < 100) y++;
        x+=0;
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
