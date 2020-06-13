package code;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.stream.MemoryCacheImageOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.Random;
public class Board extends JPanel implements ActionListener {
    private SpaceShip spaceship;
    private Boss boss;
    private List<Buff> buffList;
    private List<Alien> aliens;
    private List<Missile1> ms_ls1;
    private List<Missile3> ms_ls3;
    private List<buffMissile> buffMissileList;
    private List<SubBoss> subBosses;
    private List<Meteorite> meteoriteList;
    private List<SpaceHP> spaceHPS;
    private int x_box = 10;
    private int y_box = 10;
    private final int x[] = new int[10];
    private final int y[] = new int[10];
    private Timer timer;
    private boolean ingame;
    private  int delay = 100;
    private int delay_boss = 100;
    private int Fdelay =  100;
    private   int Fdelay_boss  = 100;
    private  int delaySubBossFire = 10;
    private  int FdelaySubBossFire = 10;
    private int checkmeteo = 0;
    private int checkboss = 0;
    private int checksubboss = 0;
    private int delayDrawBuffMiss =4;
    private int delayDrawBuff = 4;
    private int delayDrawSpace = 4;
    private int delayDrawAlien = 4;
    private int delayDrawBoss = 4 ;
    private int delayDrawSubBoss = 4;
    private int delayDrawMeteo  = 4;
    private int []delayDrawMissile2Break1 ;
    private int extraVarAlien = 1;
    private int exteraVarBoss = -1;
    private int subBossCount = 2;
    private int orderFire = 3;
    private int subBossMoveDirec = 1;
    private int []delayDrawMissile1s ;
    private boolean win = false;
    protected Image image1;
    protected Image image2;
    public Board( )
    {

        locateAlien();
        initBoard();
    }
    public void initEasy(){
        FdelaySubBossFire = 50;
        Fdelay_boss = 15;
        Fdelay = 60;
    }
    public void initNormal(){
        FdelaySubBossFire = 40;
        Fdelay_boss = 10;
        Fdelay = 50;
    }
    public void initHard(){
        FdelaySubBossFire = 30;
        Fdelay_boss = 5;
        Fdelay  = 40;
    }
    private void locateAlien()
    {
        for(int i=0;i<10;i++)
        {
            x[i]=(int) (Math.random()*400)+10;
            y[i]=(int) (Math.random()*60)-100;
        }
    }
    public void initBoard()
    {
        Audio audio = new Audio();
        audio.runAudio("src/audio/start.wav",false);
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        ingame =true;
        setPreferredSize(new Dimension(700, 835));
        spaceship = new SpaceShip(350,500);
        initSubBoss();
        initAliens();
        initMissile1();
        initMissile3();
        initBuff();
        initend();
        initBuffMissile();
        initMeteo();
        spaceHPS = new ArrayList<>();
        for (int i= 0; i < spaceship.getHp()+1; i++){
            spaceHPS.add(new SpaceHP(-50+50*i,790));
        }
        boss = new Boss(300, 100);
        ms_ls3  = new ArrayList<>();

        delayDrawMissile2Break1 = new int[10000];
        for (int i = 0 ; i< 10000; i++){
            delayDrawMissile2Break1[i]  = 2;
        }
        timer = new Timer (40, this);
        timer.stop();
    }
    public void initMeteo(){
        meteoriteList = new ArrayList<>();
        meteoriteList.add(new Meteorite(350,-120));
        meteoriteList.add(new Meteorite(510,-180));
        meteoriteList.add(new Meteorite(640,-210));
        meteoriteList.add(new Meteorite(780, -250));
        meteoriteList.add(new Meteorite(880, -250));
        meteoriteList.add(new Meteorite(380,-240));
        meteoriteList.add(new Meteorite(590,-350));
        meteoriteList.add(new Meteorite(670,-330));
        meteoriteList.add(new Meteorite(830,-390));
        meteoriteList.add(new Meteorite(920,-380));
        meteoriteList.add(new Meteorite(1000,-60));
        meteoriteList.add(new Meteorite(1100,-110));
        meteoriteList.add(new Meteorite(1150,-350));
        meteoriteList.add(new Meteorite(1200,-110));
        meteoriteList.add(new Meteorite(1250,-250));
        meteoriteList.add(new Meteorite(1250,-500));
        meteoriteList.add(new Meteorite(1300,-480));
        meteoriteList.add(new Meteorite(1300,-60));
        meteoriteList.add(new Meteorite(1400,-250));


    }
    public void initSubBoss(){
        subBosses = new ArrayList<>();
        subBosses.add(new SubBoss(70 ,50));
        subBosses.add(new SubBoss(30,50));
    }
    public void initend()
    {
        ImageIcon winner = new ImageIcon("src/images/chickendinner.png");
        image1 = winner.getImage();
        ImageIcon over = new ImageIcon("src/images/gameover.png");
        image2 = over.getImage();

    }
    public void initBuffMissile(){
        buffMissileList = new ArrayList<>();
        Random random = new Random();
        int buffappear1  = -(random.nextInt(1000)+400);
        int buffappear2  = -(random.nextInt(1000)+600);

        buffMissileList.add(new buffMissile(160,buffappear1));
        buffMissileList.add(new buffMissile(350,buffappear2));

    }
    public  void initBuff(){
        buffList = new ArrayList<>();
        int BuffAppear1 = -((int)(Math.random()*1000+1000));
        int BuffAppear2 = -((int)(Math.random()*1000+1000));
        buffList.add(new Buff(200,BuffAppear1));
        buffList.add(new Buff( 490,BuffAppear2));
    }
    public void initAliens()
    {
        aliens = new ArrayList<>();
        Random random  = new Random();
        Alien a;
        a= new Alien(-125, random.nextInt(60) - 300);
        a.setLimitMove(200);
        aliens.add(a);
        a = new Alien(-75,random.nextInt(60)-240);
        a.setLimitMove(200);
        aliens.add(a);
        a = new Alien(-25,random.nextInt(60)-350);
        a.setLimitMove(200);
        aliens.add(a);
        a = new Alien(25,random.nextInt(60)-120);
        a.setLimitMove(200);
        aliens.add(a);
        a = new Alien(75,random.nextInt(60)-280);
        a.setLimitMove(200);
        aliens.add(a);
        a = new Alien(125,random.nextInt(60)-160);
        a.setLimitMove(200);
        aliens.add(a);
        a = new Alien(175,random.nextInt(60)-300);
        a.setLimitMove(200);
        aliens.add(a);
        a= new Alien(-125, random.nextInt(60) - 700);
        a.setLimitMove(100);
        aliens.add(a);
        a = new Alien(-75,random.nextInt(60)-640);
        a.setLimitMove(100);
        aliens.add(a);
        a = new Alien(-25,random.nextInt(60)-520);
        a.setLimitMove(100);
        aliens.add(a);
        a = new Alien(25,random.nextInt(60)-590);
        a.setLimitMove(100);
        aliens.add(a);
        a = new Alien(75,random.nextInt(60)-670);
        a.setLimitMove(100);
        aliens.add(a);
        a = new Alien(125,random.nextInt(60)-710);
        a.setLimitMove(100);
        aliens.add(a);
        a = new Alien(175,random.nextInt(60)-800);
        a.setLimitMove(100);
        aliens.add(a);

    }
    public void initMissile1(){
        ms_ls1 = new ArrayList<>();
    }
    public void initMissile3(){
        ms_ls1  = new ArrayList<>();
    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        if (ingame&&!win)
        {
            drawObjects(g2d);
        }
        if(!ingame&&win==true)
        {
            ImageIcon ii = new ImageIcon("src/images/background1.png");
            g.drawImage(ii.getImage(),0,0,null);
            drawWinner(g2d);
        }
        if(!ingame&&!win) {
            ImageIcon ii = new ImageIcon("src/images/background1.png");
            g.drawImage(ii.getImage(),0,0,null);
            drawGameOver(g2d);
        }

        Toolkit.getDefaultToolkit().sync();
    }
    public void drawObjects(Graphics2D g)
    {
        ImageIcon ii = new ImageIcon("src/images/background1.png");
        g.drawImage(ii.getImage(),0,0,null);
        doDrawing(g);
        for (SpaceHP spaceHP : spaceHPS){
            g.drawImage(spaceHP.getImage(),spaceHP.getX(),spaceHP.getY(),46,46,this);
        }
        for (buffMissile buff : buffMissileList){
            if(buff.isVisible())
                g.drawImage(buff.getImage(),buff.getX(),buff.getY(),this);
        }
        for (Buff buff : buffList){
            if(buff.isVisible())
                g.drawImage(buff.getImage(),buff.getX(),buff.getY(),this);
        }
        if(spaceship.isVisible())
        {
            g.drawImage(spaceship.getImage(),spaceship.getX(),spaceship.getY(),this);
        }
        List<Missile> ms = spaceship.getMissiles();
        for (Missile missile : ms)
        {
            if (missile.isVisible())
            {
                g.drawImage(missile.getImage(), missile.getX(),
                        missile.getY(), this);
            }
        }
        for (Alien alien : aliens)
        {
            if (alien.isVisible())
            {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
                for (Missile1 missile1 : ms_ls1)
                {
                    if (missile1.isVisible())
                    {
                        g.drawImage(missile1.getImage(), missile1.getX(),
                                missile1.getY(), this);
                    }
                }
            }
        }
        if (checkboss == 19) {
            boss.setVisible(true);
            g.drawImage(boss.getImage(), boss.getX(), boss.getY(), this);
            List<Missile2> ms2 = boss.getMissiles2();
            for (Missile2 missile2 : ms2) {
                if (missile2.isVisible()) {
                    g.drawImage(missile2.getImage(), missile2.getX(),
                            missile2.getY(), this);
                }
            }
        }
        else {
            boss.setVisible(false);
        }

        for (Meteorite mete : meteoriteList){
            if (mete.isVisible())
                g.drawImage(mete.getImage(),mete.getX(),mete.getY(),this);
        }

        if (checksubboss  == 1 ){
            for (SubBoss subBoss : subBosses){
                if (subBoss.isVisible()) {
                    g.drawImage(subBoss.getImage(), subBoss.getX(), subBoss.getY(), this);
                    for (Missile3 ms3 : ms_ls3) {
                        if (ms3.isVisible()) {
                            g.drawImage(ms3.getImage(), ms3.getX(), ms3.getY(), this);
                        }
                    }
                }
            }
        }
        g.setColor(Color.WHITE);
    }
    public void drawGameOver(Graphics g)
    {
        String gameover = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 40);
        FontMetrics fm = getFontMetrics(small);
        g.setColor(Color.yellow);
        g.setFont(small);
        g.drawString(gameover, (480 - fm.stringWidth(gameover)) ,
                145);
        g.drawImage(image2,150,150,this);
        Audio audio = new Audio();
        audio.runAudio("src/audio/end.wav",false);
    }
    public void doDrawing(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);

    }
    public void drawWinner(Graphics g)
    {
        g.drawImage(image1,100,100,this);

    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            spaceship.keyReleased(e);

        }
        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();
            if (key == KeyEvent.VK_P){
                timer.stop();
            }
            if (key == KeyEvent.VK_O){
                timer.start();
            }
            spaceship.keyPressed(e);
        }
    }
    private void updateBuffMissile(){
        for (buffMissile buff : buffMissileList)
            if(buff.isVisible()){
                buff.move();
            }
        delayDrawBuffMiss--;
        if (delayDrawBuffMiss == 0) {
            for (buffMissile buff : buffMissileList) {
                buff.loadImage();
                int i = buff.getSelectImg();
                i++;
                if (i == 33) i = 1;
                buff.setSelectImg(i);
                delayDrawBuffMiss = 4;
            }
        }
    }
    private void updateBuff(){
        for (Buff buff : buffList)
            if (buff.isVisible()) {
                buff.move();
            }
        delayDrawBuff--;
        if (delayDrawBuff == 0) {
            for (Buff buff : buffList) {
                buff.loadImage();
                int i = buff.getSelectImg();
                i++;
                if (i == 17) i = 1;
                buff.setSelectImg(i);
                delayDrawBuff = 4;
            }
        }
    }
    private void updateShip() {
        delayDrawSpace--;
        if (delayDrawSpace == 0){
            spaceship.loadImage();
            int i = spaceship.getSelectImg();
            i--;
            if (i==0) i=1;
            spaceship.setSelectImg(i);
            delayDrawSpace = 4;
        }
        if (spaceship.isVisible()) {
            spaceship.move();
        }
    }
    private  void  updateMeteo(){
        if (checkmeteo == 14){
            for (Meteorite m : meteoriteList) {
                m.setVisible(true);
            }
            checkmeteo++;
        }
        delayDrawMeteo--;
        if (delayDrawMeteo == 0){
            for (Meteorite meteorite : meteoriteList){
                meteorite.loadImage();
                int i = meteorite.getSelectImg();
                i++;
                if(i==11) i=1;
                meteorite.setSelectImg(i);

            }
            delayDrawMeteo = 4;
        }
        for (int i=0; i < meteoriteList.size();i++){
            if (meteoriteList.get(i).isVisible()) {
                meteoriteList.get(i).move();
                if (meteoriteList.get(i).getX()<5 || meteoriteList.get(i).getY()>790){
                    checkboss++;
                    meteoriteList.get(i).setVisible(false);
                }
            }
        }
    }
    private void updateBoss()
    {
        delayDrawBoss--;
        if (delayDrawBoss == 0){
            boss.loadImage();
            int i = boss.getSelectImg();
            if (i==1) exteraVarBoss *= -1;
            if (i==10) exteraVarBoss *= -1;
            i+= exteraVarBoss;
            boss.setSelectImg(i);
            delayDrawBoss =4;
        }
        if(boss.isVisible())
        {
            if (delay_boss % Fdelay_boss == 0){
                boss.fire();

            }
            boss.move();
        }
        delay_boss--;
        if (delay_boss == 0) delay_boss=Fdelay_boss;
    }
    private void updateAliens()
    {
        Random random = new Random();
        for(int i = 0; i< aliens.size();i++)
        {
            Alien alien = aliens.get(i);
            if(alien.isVisible())
            {
                if (delay % Fdelay == 0 && alien.getY()>0){

                    orderFire--;
                    if (orderFire==0){
                        ms_ls1.add(new Missile1(alien.getX()+alien.getWidth()/2,alien.getY()+alien.getHeight()));
                        orderFire = random.nextInt(3)+2;
                    }
                }
                alien.move();
            }

        }
        delay--;
        if (delay == 0) delay = Fdelay;
        delayDrawAlien--;
        if (delayDrawAlien == 0) {
            aliens.get(0).loadImage();
            int i = aliens.get(0).getSelectImg();
            if (i==11) extraVarAlien*=-1;
            if (i==1)  extraVarAlien*=-1;
            i+=extraVarAlien;
            for (Alien alien :aliens){
                alien.setSelectImg(i);
                alien.loadImage();
            }
            delayDrawAlien = 4;
        }
    }
    private  void updateSubBoss(){
        for (SubBoss subBoss : subBosses){
            if (subBoss.isVisible()){
                if (delaySubBossFire%FdelaySubBossFire == 0 && subBoss.getY() > 0){
                    Missile3 a  = new Missile3(subBoss.getX()+subBoss.getWidth()/2 -36,subBoss.getY()+subBoss.getHeight(),2);
                    a.setLevelMiss(2);
                    a.setVisible(true);
                    ms_ls3.add(a);
                    Missile3 b = new Missile3(subBoss.getX()+subBoss.getWidth()/2 -12,subBoss.getY()+subBoss.getHeight(),1);
                    b.setLevelMiss(1);
                    b.setVisible(true);
                    ms_ls3.add(b);
                    Missile3 c = new Missile3(subBoss.getX()+subBoss.getWidth()/2 +12,subBoss.getY()+subBoss.getHeight(),3);
                    c.setLevelMiss(3);
                    c.setVisible(true);
                    ms_ls3.add(c);
                }
                subBoss.move();
            }
        }
        delaySubBossFire--;
        if (delaySubBossFire == 0) delaySubBossFire = FdelaySubBossFire;
        delayDrawSubBoss--;
        if (delayDrawSubBoss == 0){
            int i = subBosses.get(0).getSelectImg();
            i++;
            if (i == 17) i=1;
            for (SubBoss subBoss : subBosses){
                subBoss.loadImage();
                subBoss.setSelectImg(i);
            }
            delayDrawSubBoss = 4;
        }
    }
    private void updateMissiles3(){
        for (Missile3 ms3 : ms_ls3){
            if (ms3.isVisible()){
                ms3.move();
            }
        }
    }
    private void updateMissiles2() {

        List<Missile2> ms2 = boss.getMissiles2();
        for (int i = 0; i < ms2.size(); i++) {
            Missile2 m = ms2.get(i);

            if (m.isVisible()) {
                if (m.getMis2break() == 1){
                    delayDrawMissile2Break1[i]--;

                    if (delayDrawMissile2Break1[i]==0){
                        m.loadImage();

                        int j = m.getSelectImg();
                        j++;
                        if (j>2) {
                            int u = m.getX();
                            int v = m.getY();
                            u -= 4;
                            v -= 4;
                            m.setX(u);
                            m.setY(v);
                        }
                        m.setSelectImg(j);
                        if (j==10) {
                            m.setMis2break(0);
                            m.setVisible(false);
                        }

                        delayDrawMissile2Break1[i] = 2;
                    }

                }
                m.move();
            } else {
                ms2.remove(i);
            }
        }
    }
    private void updateMissiles() {
        List<Missile> ms = spaceship.getMissiles();
        for (int i = 0; i < ms.size(); i++) {
            Missile m = ms.get(i);
            if (m.isVisible()) {
                m.move();
            } else {
                ms.remove(i);
            }
        }
    }
    private  void updateMissile1()
    {
        if (boss.isVisible()){
            for (Missile1 ms : ms_ls1){
                ms.setVisible(false);
            }
        }
        for (Missile1 m : ms_ls1) {
            if (m.isVisible()) {
                m.move();
            }
        }
    }

    public void checkCollisions() {
        Rectangle r3 = spaceship.getBounds();
        for (Meteorite mete : meteoriteList){
            Rectangle r10 = mete.getBounds();
            if (r10.intersects(r3) && mete.isVisible()){
                mete.setVisible(false);
                checkboss++;
                int i = spaceship.getHp();
                i--;
                spaceship.setHp(i);
                spaceHPS.remove(spaceHPS.size()-1);
                spaceship.setX(350);
                spaceship.setY(500);
                Audio audio = new Audio();
                audio.runAudio("src/audio/broken.wav",false);
            }
        }
        for (buffMissile buffMissile : buffMissileList){
            Rectangle r6 = buffMissile.getBounds();
            if (r3.intersects(r6) && buffMissile.isVisible()){
                int i = spaceship.getLevelMiss();
                i++;
                spaceship.setLevelMiss(i);
                buffMissile.setVisible(false);
                Audio audio = new Audio();
                audio.runAudio("src/audio/buff.wav",false);
            }
        }
        for (Missile3 ms3 : ms_ls3){
            Rectangle r7 = ms3.getBounds();
            if (r7.intersects(r3) && ms3.isVisible()){
                ms3.setVisible(false);
                int i = spaceship.getHp();
                i--;
                spaceship.setHp(i);
                spaceHPS.remove(spaceHPS.size()-1);
                spaceship.setX(350);
                spaceship.setY(500);
                Audio audio = new Audio();
                audio.runAudio("src/audio/broken.wav",false);
            }
        }
        for (Buff buff : buffList){
            Rectangle r5 = buff.getBounds();
            if (r3.intersects(r5) && buff.isVisible()){
                int h = spaceship.getHp();
                h++;
                spaceship.setHp(h);
                SpaceHP a = spaceHPS.get(spaceHPS.size()-1);
                spaceHPS.add(new SpaceHP(a.getX()+50,790));
                buff.setVisible(false);
                Audio audio = new Audio();
                audio.runAudio("src/audio/buff.wav",false);
            }
        }
        for (Alien alien : aliens) {
            Rectangle r2 = alien.getBounds();
            if (r3.intersects(r2) && alien.isVisible()) {
                alien.setVisible(false);
                int h1 = spaceship.getHp();
                h1--;
                spaceship.setHp(h1);
                spaceHPS.remove(spaceHPS.size()-1);
                spaceship.setX(350);
                spaceship.setY(500);
                checkboss += 1 ;
                Audio audio = new Audio();
                audio.runAudio("src/audio/broken.wav",false);
            }
        }
        List<Missile> ms = spaceship.getMissiles();
        for (Missile m : ms)
        {
            Rectangle r1 = m.getBounds();
            {
                for (Alien alien : aliens) {
                    Rectangle r2 = alien.getBounds();
                    if (r1.intersects(r2)  && alien.isVisible() ) {
                        m.setVisible(false);
                        alien.setVisible(false);
                        checkmeteo +=1 ;
                        Audio audio = new Audio();
                        audio.runAudio("src/audio/killChicken1.wav",false);
                    }
                }
                for (SubBoss subBoss : subBosses){
                    Rectangle r8 = subBoss.getBounds();
                    if (r1.intersects(r8) && subBoss.isVisible() && m.isVisible()){
                        m.setVisible(false);
                        int i = subBoss.getHP();
                        i--;
                        subBoss.setHP(i);
                        if (i<=0){
                            subBossCount --;
                            subBoss.setVisible(false);
                        }
                        if (subBossCount == 0){
                            ingame  = false;
                            win =true;
                            Audio audio = new Audio();
                            audio.runAudio("src/audio/win.wav",false);
                        }
                        Audio audio = new Audio();
                        audio.runAudio("src/audio/killAnother.wav",false);
                    }
                }
            }
            for (Meteorite meteorite : meteoriteList){
                Rectangle r9= meteorite.getBounds();
                if (r9.intersects(r1) && meteorite.isVisible() && m.isVisible()){
                    m.setVisible(false);
                    meteorite.setVisible(false);
                    checkboss++;
                    Audio audio = new Audio();
                    audio.runAudio("src/audio/killAnother.wav",false);
                }
            }
            Rectangle r2 = boss.getBounds();
            if(r1.intersects(r2) && boss.isVisible())
            {
                m.setVisible(false);
                int h= boss.getHP();
                h--;
                boss.setHP(h);
                if(h<=1)
                {
                    checkboss ++;
                    boss.setVisible(false);
                    checksubboss = 1;
                    Random random = new Random();
                    subBosses.get(0).setVisible(true);
                    subBosses.get(1).setVisible(true);

                    subBosses.get(0).setDx(-(random.nextInt(3)+1));
                    subBosses.get(1).setDx(1);
                    subBosses.get(0).setX(boss.getX()-30);
                    subBosses.get(1).setX(boss.getX()+30);
                }
                Audio audio = new Audio();
                audio.runAudio("src/audio/killChicken1.wav",false);
            }
        }
        for(Missile1 m1: ms_ls1)
        {
            Rectangle  r2 = m1.getBounds();
            if(r2.intersects(r3) && m1.isVisible())
            {
                int h3 = spaceship.getHp();
                h3--;
                m1.setVisible(false);
                spaceship.setHp(h3);
                spaceHPS.remove(spaceHPS.size()-1);
                spaceship.setX(350);
                spaceship.setY(500);
                Audio audio = new Audio();
                audio.runAudio("src/audio/broken.wav",false);
            }
        }
        List<Missile2> ms2 = boss.getMissiles2();
        for(Missile2 m2:ms2)
        {
            Rectangle r2 = m2.getBounds();
            if(r2.intersects(r3) && m2.isVisible())
            {
                m2.setVisible(false);
                int h4 = spaceship.getHp();
                h4--;
                spaceship.setHp(h4);
                spaceHPS.remove(spaceHPS.size()-1);
                spaceship.setX(350);
                spaceship.setY(500);
                Audio audio = new Audio();
                audio.runAudio("src/audio/broken.wav",false);
            }
        }
        Rectangle r4 = boss.getBounds();
        if(r4.intersects(r3) && boss.isVisible())
        {
            int h5 = spaceship.getHp();
            h5--;
            spaceship.setHp(h5);
            spaceHPS.remove(spaceHPS.size()-1);
            spaceship.setX(350);
            spaceship.setY(500);
            Audio audio = new Audio();
            audio.runAudio("src/audio/broken.wav",false);
        }
    }
    private void endGame(){
        if (spaceship.getHp() < 1)
            ingame = false;
    }
    private void inGame() {
        if (!ingame) {
            timer.stop();
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        inGame();
        updateShip();
        updateMissiles();
        updateAliens();
        updateMissile1();
        updateBoss();
        updateMeteo();
        updateSubBoss();
        updateMissiles2();
        updateMissiles3();
        updateBuff();
        updateBuffMissile();
        checkCollisions();
        endGame();
        repaint();
    }
    public void timeStop(){
        timer.stop();
    }
    public void timeStart(){
        timer.start();
    }
}