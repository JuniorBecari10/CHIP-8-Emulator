package boot.chip8.main;

import java.awt.*;
import java.awt.image.*;

import java.util.Arrays;

import javax.swing.*;

public class Screen extends Canvas {
    
    public static final int WIDTH = 64;
    public static final int HEIGHT= 32;
    public static final int SCALE = 10;
    
    public static final String TITLE = "Boot's CHIP-8 Emulator!";
    
    public static JFrame frame;
    
    public static BufferedImage image;
    
    public static boolean[] screen;
    
    public Screen() {
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        
        createWindow(WIDTH, HEIGHT, SCALE, TITLE);
        
        screen = new boolean[WIDTH * HEIGHT];
        
        Arrays.fill(screen, false);
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
    
    public static void writePixel(int x, int y) {
        screen[x + (y * WIDTH)] ^= true;
    }
    
    public static int colorToInt(Color c) {
        int r = c.getRed();
        int g = c.getGreen();
        int b = c.getBlue();
        
        r = (r << 16) & 0x00FF0000;
        b = (b << 16) & 0x0000FF00;
        b = (b << 16) & 0x000000FF;
        
        return 0x00FF0000 | r | g | b;
    }
}
