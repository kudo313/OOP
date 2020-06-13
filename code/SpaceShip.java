package code;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
public class SpaceShip extends Sprite
{
    private int hp=3;
    private int dx;
    private int dy;
    private int levelMiss=1;
    private int selectImg=1;
    private List<Missile> missiles;

    public SpaceShip(int x, int y) {
        super(x, y);

        initCraft();
    }
    public  void setX(int x){
        this.x = x;
    }
    public void setLevelMiss(int i){
        levelMiss = i;
    }
    public int getLevelMiss(){
        return  levelMiss;
    }
    public void setY(int y){
        this.y =  y;
    }
    public void setHp(int hp){
        this.hp = hp;
    }
    public int getHp(){
        return hp;
    }
    private void initCraft() {
        missiles = new ArrayList<>();
        loadImage("src/images/spaceship.png");
        getImageDimensions();
    }
    public void setSelectImg(int i){
        selectImg = i;
    }
    public int getSelectImg(){
        return selectImg;
    }
    public void loadImage(){
        if (dx < 0){
            String s = "src/images/spaceleft" + selectImg + ".png";
            loadImage(s);
        }
        if (dx > 0){
            String s = "src/images/spaceright" + selectImg + ".png";
            loadImage(s);
        }
        if (dx == 0)
            loadImage("src/images/spaceship.png");
        getImageDimensions();
    }
    public void move() {

        x += dx;
        y += dy;

        if (x > 690)
        {
            x = 690;
        }
        if (x < 10 )
        {
            x = 10;
        }
        if (y < 10)
        {
            y = 10;
        }
        if (y > 700)
        {
            y = 700;
        }
    }

    public List<Missile> getMissiles()
    {
        return missiles;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {

            fire();
        }

        if (key == KeyEvent.VK_LEFT) {
            dx = -5;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 5;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -5;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 5;
        }
    }

    public void fire()
    {
        Audio audio = new Audio();
        audio.runAudio("src/audio/shotMiss.wav",false);
        if (levelMiss == 1) {
            missiles.add(new Missile(x + width / 2 -5, y - 10, 1));
        }
        if (levelMiss == 2) {

            missiles.add(new Missile(x+width/2-15,y-10,1));
            missiles.add(new Missile(x+width/2+5,y-10,1));

        }
        if (levelMiss == 3){
//
            missiles.add(new Missile(x+width/2-5,y-10,1));
            missiles.add(new Missile(x+width/2+3,y-10,2));
            missiles.add(new Missile(x+width/2-12,y-10,3));

        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}
