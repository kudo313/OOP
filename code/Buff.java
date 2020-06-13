package code;

public class Buff extends Sprite {
    private int selectImg=1;

    public  Buff(int x, int y){
        super(x,y);
        initBuff();
    }
    public void initBuff(){
        loadImage("src/images/buff1.png");
        getImageDimensions();
    }
    public void loadImage(){
        String ImgName = "src/images/buff" + selectImg + ".png";
        loadImage(ImgName);
        getImageDimensions();
    }
    public void setSelectImg(int i){
        selectImg =  i;
    }
    public int getSelectImg(){
        return selectImg;
    }
    public void move(){
        y+=3;
        if (y>835){
            setVisible(false);
        }
    }

}
