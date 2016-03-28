/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dolphin;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Game extends JFrame {

    public Game() throws Exception {
        
        initUI();
    }
    
    private void initUI() throws Exception {
        JFrame myJFrame = new JFrame("Image pane");
        add(new Board());
        ImageIcon icon = new ImageIcon("URDL.png");
        setSize(1200, 800);
        setResizable(false);
        setTitle("Forces");
        setIconImage(icon.getImage());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                Game ex = null;
                try {
                    ex = new Game();
                } catch (Exception ex1) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex1);
                }
                ex.setVisible(true);
            }
        });
    }
}
