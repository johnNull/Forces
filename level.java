/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dolphin;

import java.awt.Rectangle;
import java.util.ArrayList;

public class level {
    static ArrayList<Rectangle> lev1 = new ArrayList<Rectangle>();
    static ArrayList<Rectangle> lev2 = new ArrayList<Rectangle>();
    static ArrayList<Rectangle> lev3 = new ArrayList<Rectangle>();
    static ArrayList<Rectangle> lev4 = new ArrayList<Rectangle>();
    static ArrayList<Rectangle> lev5 = new ArrayList<Rectangle>();
    static ArrayList<Rectangle> lev6 = new ArrayList<Rectangle>();
    static ArrayList<Rectangle> lev7 = new ArrayList<Rectangle>();
    static ArrayList<Rectangle> lev8 = new ArrayList<Rectangle>();
    static ArrayList<Rectangle> lev9 = new ArrayList<Rectangle>();
    public level(){
        lev1.add(new Rectangle(0,760, 1000, 10));
        lev1.add(new Rectangle(1000,150,200,650));
        lev1.add(new Rectangle(1050, 100, 50, 50));
        
        lev2.add(new Rectangle(0,0,150, 800));
        lev2.add(new Rectangle(1050, 0, 150, 800));
        lev2.add(new Rectangle(500, 400, 10, 10));
        
        lev3.add(new Rectangle(0, 650, 400, 15));
        lev3.add(new Rectangle(850, 650, 500, 15));
        lev3.add(new Rectangle(350, 580, 100, 15));
        lev3.add(new Rectangle(800, 580, 100, 15));
        lev3.add(new Rectangle(500, 510, 50, 15));
        lev3.add(new Rectangle(700,510, 50, 15));
        lev3.add(new Rectangle(600, 440, 50, 15));
        
        lev4.add(new Rectangle(0, 650, 550, 15));
        lev4.add(new Rectangle(0, 570, 100, 15));
        lev4.add(new Rectangle(0, 490, 95, 15));
        lev4.add(new Rectangle(155 , 440, 130, 15));
        lev4.add(new Rectangle(365,380 , 130, 15));
        lev4.add(new Rectangle(595, 300, 100, 15));
        lev4.add(new Rectangle(850, 300, 80, 15));
        lev4.add(new Rectangle(1100,295,60,15));
        lev4.add(new Rectangle(1100, 280, 60, 15));
        
        lev5.add(new Rectangle(950, 650, 20, 20));
        lev5.add(new Rectangle(250, 400, 20, 20));
        lev5.add(new Rectangle(950, 150, 20, 20));
        lev5.add(new Rectangle(250, 70, 20, 20));
        lev5.add(new Rectangle(250, 50, 20, 20));
        
        lev6.add(new Rectangle(0, 600, 1200, 10));
        lev6.add(new Rectangle(0, 700, 200, 10));
        lev6.add(new Rectangle(300, 700, 200, 10));
        lev6.add(new Rectangle(600, 700, 200, 10));
        lev6.add(new Rectangle(900, 700, 300, 10));
        lev6.add(new Rectangle(1000, 675, 25, 25));
        
        lev7.add(new Rectangle(100, 100, 1000, 10));
        lev7.add(new Rectangle(0, 100, 100, 510));
        lev7.add(new Rectangle(1100, 100, 100, 510));
        lev7.add(new Rectangle(100, 600, 1000, 10));
        lev7.add(new Rectangle(100, 110, 3, 3));
        
        lev8.add(new Rectangle(0,600, 100, 10));
        lev8.add(new Rectangle(590,0,10,250));
        lev8.add(new Rectangle(590, 320, 10, 480));
        lev8.add(new Rectangle(620, 250, 10, 70));
        
        lev9.add(new Rectangle(600,50, 10, 750));
        lev9.add(new Rectangle(600,0,10,50));
    }

}
