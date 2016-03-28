/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dolphin;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.Robot;
import java.util.ArrayList;

public class Sprite {

    private int dx;
    private int dy;
    private int x;
    private int y;
    private int startX;
    private int startY;
    private Image image;
    double time = System.currentTimeMillis();
    public static boolean complete = false;
    public static int retries = 0;
    public static int fretries = 0;
    boolean collided = false;
    boolean released = true;
    ArrayList<Rectangle> lev = new ArrayList<Rectangle>();
    int forces = 3;
    ImageIcon ii;
    Robot robot;
    level l = new level();
    public int lvl = 0;
    Rectangle bounds = getBounds();

    public Sprite() throws Exception {
        
        initCraft();
    }
    
    public void initCraft() throws Exception{
        ii = new ImageIcon("Square.png");
        image = ii.getImage();
        x = 40;
        y = 500; 
    }


    public void move() {
        x += dx;
        y += dy;
        if(((System.currentTimeMillis() - time) > 500) && collided == false){
            dy++;
            time = System.currentTimeMillis();
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x,y, 41,41);
    }
    
    public void collision(){
        Point ori = bounds.getLocation();
        bounds = getBounds();
        collided = false;
        //First Level Intersections. For loops refuse to work
        if(lvl == 0){
            complete = false;
            startX = 40;
            startY = 500;
            checkCol(0);
            checkCol(1);
            checkComplete(2, 600, -100);
        }
        //level 2
        if(lvl == 1){
            checkCol(0);
            checkCol(1);
            checkComplete(2, 10, 500);
        }
        //level 3
        if(lvl == 2){
            checkCol(0);
            checkCol(1);
            checkCol(2);
            checkCol(3);
            checkCol(4);
            checkCol(5);
            checkComplete(6, 180, 590);
        }
        //level 4
        if(lvl == 3){
            checkCol(0);
            checkCol(1);
            checkCol(2);
            checkCol(3);
            checkCol(4);
            checkCol(5);
            checkCol(6);
            checkCol(7);
            checkComplete(8, 600, 550);
        }
        //level 5
        if(lvl == 4){
            checkCol(0);
            checkCol(1);
            checkCol(2);
            checkCol(3);
            checkComplete(4, 50, 630);
        }
        
        //level 6
        if(lvl == 5){
            checkCol(0);
            checkCol(1);
            checkCol(2);
            checkCol(3);
            checkCol(4);
            checkComplete(5,600,400);
        }
        
        //seventh level
        if(lvl == 6){
            if(bounds.getX() < 100){
                x = 100;
            }
            if(bounds.getX() > 1060){
                x = 1060;
            }
            checkCol(0);
            checkCol(1);
            checkCol(2);
            checkCol(3);
            checkComplete(4, 20,500);
        }
        
        if(lvl == 7){
            checkCol(0);
            checkCol(1);
            checkCol(2);
            checkComplete(3,550,500);
        }
        
        if(lvl == 8){
            checkCol(0);
            checkComplete(1, 40, 500);
        }
    }
    
    void checkCol(int i){
        if(lvl == 0){lev = l.lev1;}
        if(lvl == 1){lev = l.lev2;}
        if(lvl == 2){lev = l.lev3;}
        if(lvl == 3){lev = l.lev4;}
        if(lvl == 4){lev = l.lev5;}
        if(lvl == 5){lev = l.lev6;}
        if(lvl == 6){lev = l.lev7;}
        if(lvl == 7){lev = l.lev8;}
        if(lvl == 8){lev = l.lev9;}
        if(bounds.intersects(lev.get(i))){
                if(side(lev.get(i))){
                    dx = -dx;
                }
                else{
                dy = -dy;
                }
                collided = true;
                forces = 3;
        }
    }
    
    void checkComplete(int i, int h, int v){
        if(bounds.intersects(lev.get(i))){
            if(lvl == 8){    
                complete = true;
                fretries = retries;
                retries = 0;
                lvl = 0;
                time = System.currentTimeMillis();
            }
            else{
                lvl++;
            }
                collided = false;
                forces = 3;
                dx = 0;
                dy = 0;
                x = h;
                y = v;
                startX = x;
                startY = y;
        }
    }
    
    boolean side(Rectangle r){
        Rectangle bounds = getBounds();
        //System.out.println("in side " + bounds.getX() + " " + (r.getX()));
        if((bounds.getX() - (r.getX() + r.getWidth() + 3)) <= 0 && (bounds.getX() - (r.getX() + r.getWidth() + 2)) >=-6){
            //System.out.println("Hit side");
            return true;
        }
        if(((bounds.getX() + bounds.getWidth() + 3) - r.getX()) >= 0 && ((bounds.getX() + bounds.getWidth() + 2) - r.getX()) <= 6 ){
            //System.out.println("Hit side");
            return true;
        }
        return false;
    }
    
    int getLevel(){
        return lvl;
    }
    

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_ESCAPE) {
            time = System.currentTimeMillis();
            collided = false;
            forces = 3;
            dx = 0;
            dy = 0;
            x = startX;
            y = startY;
        }

        if (key == KeyEvent.VK_LEFT && released && forces > 0) {
            released = false;
            forces--;
            dx += -1;
            ii = new ImageIcon("L.png");
            image = ii.getImage();
        }

        if (key == KeyEvent.VK_RIGHT && released && forces > 0) {
            released = false;
            forces--;
            dx += 1;
            ii = new ImageIcon("R.png");
            image = ii.getImage();
        }

        if (key == KeyEvent.VK_UP && released && forces > 0) {
            released = false;
            forces--;
            dy += -1;
            ii = new ImageIcon("U.png");
            image = ii.getImage();
        }

        if (key == KeyEvent.VK_DOWN && released && forces > 0) {
            released = false;
            forces--;
            dy += 1;
            ii = new ImageIcon("D.png");
            image = ii.getImage();
        }
        if(key == KeyEvent.VK_A && released && forces > 0){
            released = false;
            forces--;
            dx += -2;
            ii = new ImageIcon("L.png");
            image = ii.getImage();
        }
        if(key == KeyEvent.VK_W && released && forces > 0){
            released = false;
            forces--;
            dy += -2;
            ii = new ImageIcon("U.png");
            image = ii.getImage();
        }
        if(key == KeyEvent.VK_D && released && forces > 0){
            released = false;
            forces--;
            dx += 2;
            ii = new ImageIcon("R.png");
            image = ii.getImage();
        }
        if(key == KeyEvent.VK_S && released && forces > 0){
            released = false;
            forces--;
            dy += 2;
            ii = new ImageIcon("D.png");
            image = ii.getImage();
        }
    }

    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_ESCAPE){
            retries++;
            released = true;
        }
        if (key == KeyEvent.VK_LEFT) {
            released = true;
            ii = new ImageIcon("Square.png");
            image = ii.getImage();
        }

        if (key == KeyEvent.VK_RIGHT) {
            //dx = 0;
            released = true;
            ii = new ImageIcon("Square.png");
            image = ii.getImage();
        }

        if (key == KeyEvent.VK_UP) {
           //dy = 0;
            released = true;
            ii = new ImageIcon("Square.png");
            image = ii.getImage();
        }

        if (key == KeyEvent.VK_DOWN) {
            //dy = 0;
            released = true;
            ii = new ImageIcon("Square.png");
            image = ii.getImage();
        }
        if(key == KeyEvent.VK_A){
            //dx = 0;
            released = true;
            ii = new ImageIcon("Square.png");
            image = ii.getImage();
        }
        if(key == KeyEvent.VK_W){
            //dy = 0;
            released = true;
            ii = new ImageIcon("Square.png");
            image = ii.getImage();
        }
        if(key == KeyEvent.VK_D){
            //dx = 0;
            released = true;
            ii = new ImageIcon("Square.png");
            image = ii.getImage();
        }
        if(key == KeyEvent.VK_S){
            //dy = 0;
            released = true;
            ii = new ImageIcon("Square.png");
            image = ii.getImage();
        }
    }
}
