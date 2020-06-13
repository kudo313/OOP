package code;
import java.util.Random;
public class Missile2  extends Sprite
{
    private int direc;
    private int selectImg=1;
    private int mis2break=0;
    private  int MISSILE_SPEED = 7;
    private int speed1  = 6;
    private int speed2  = 4;
    private int speed3  = 2;




    public Missile2(int x, int y)
    {
        super(x, y);
        initMissile();
    }

    private void initMissile() {
        Random random = new Random();
        direc = random.nextInt(7) + 1;
        loadImage("src/images/missile2direc"+direc+".png");
        getImageDimensions();
    }
    public void loadImage(){
        String s = "src/images/missile2break" + selectImg + ".png";
        loadImage(s);
        getImageDimensions();
    }
    public void setSelectImg(int i){
        selectImg = i;
    }
    public int getSelectImg(){
        return selectImg;
    }
    public void move()
    {
        Random random = new Random();
        if (direc == 1) {
            y += MISSILE_SPEED;
            x-=speed1;
        }
        if (direc == 2 ){
            y+= MISSILE_SPEED;
            x-=speed2;
        }
        if (direc== 3){
            y+=MISSILE_SPEED;
            x-= speed3;
        }
        if (direc == 4){
            y+=MISSILE_SPEED;
        }
        if (direc == 5){
            y+= MISSILE_SPEED;
            x+=speed3;
        }
        if (direc == 6){
            y+=MISSILE_SPEED;
            x+=speed2;
        }
        if (direc == 7){
            y+=MISSILE_SPEED;
            x+=speed1;
        }
        int i = random.nextInt(200)+600;
        if (y>i || x<0 || x>690) {
            mis2break = 1;
            MISSILE_SPEED = 0;
            speed1= 0;
            speed2 =0 ;
            speed3 = 0;

        }
    }
    public void setMis2break(int i ){
        mis2break = i;
    }
    public int getMis2break(){
        return mis2break;
    }
}
