package boot.chip8.main;

import java.awt.*;
import java.awt.image.*;

import javax.swing.*;

public class Screen extends Canvas {
    
    public static final int WIDTH = 64;
    public static final int HEIGHT= 32;
    public static final int SCALE =  10;
    
    public static final String TITLE = "Boot's CHIP-8 Emulator!";
    
    public static JFrame frame;
    
    public static BufferedImage image;
    
    public Screen() {
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        
        createWindow(WIDTH, HEIGHT, SCALE, TITLE);
    }
    
    private synchronized void createWindow(int width, int height, int scale, String title) {
        setPreferredSize(new Dimension(width * scale, height * scale));
        
        frame = new JFrame(title);
        
        frame.add(this);
        frame.setResizable(false);
        
        frame.pack();
        
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
