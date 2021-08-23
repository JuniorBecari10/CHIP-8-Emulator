package boot.chip8.main;

import java.awt.*;
import java.awt.image.*;

public class Main implements Runnable {
    
    private boolean running;
    private Thread t;
    
    public static Screen screen;
    
    public Main() {
        screen = new Screen();
        
        Screen.writePixel(1, 1);
    }
    
    public synchronized void start() {
        running = true;
        
        t = new Thread(this);
        t.start();
    }
    
    public synchronized void stop() {
        running = false;
        
        try {
            t.join();
        } catch (Exception e) {}
    }
    
    public void tick() {
        
    }
    
    public void render() {
        BufferStrategy bs = screen.getBufferStrategy();
        
        if (bs == null) {
            screen.createBufferStrategy(3);
            
            return;
        }
        
        Graphics g = screen.image.getGraphics();
        
        g.setColor(Color.black);
        g.fillRect(0, 0, Screen.WIDTH, Screen.HEIGHT);
        
        ///
        
        for (int x = 0; x < Screen.screen.length; x++) {
            for (int y = 0; y < Screen.screen.length; y++) {
                boolean b = Screen.screen[x = (y * Screen.WIDTH)];
            
                Color c = b ? Color.white : Color.black;
                
                g.setColor(c);
                g.fillRect(x, y, 1, 1);

            }
        }
        
        //Screen.setToPixels();
        
        ///
        
        g.dispose();
        g = bs.getDrawGraphics();
        
        g.drawImage(screen.image, 0, 0, Screen.WIDTH * Screen.SCALE, Screen.HEIGHT * Screen.SCALE, null);
        
        bs.show();
    }
    
    @Override 
    public void run() {
        long lastTime = System.nanoTime();
        final double targetFPS = 60.0;
        
        double ns = 1E9 / targetFPS;
        double delta = 0;
        
        int frames = 0;
        double timer = System.currentTimeMillis();
        
        while (running) {
            long now = System.nanoTime();
            
            delta += (now - lastTime) / ns;
            lastTime = now;
            
            while (delta >= 1) {
                tick();
                render();
                
                delta--;
                frames++;
            }
            
            if (System.currentTimeMillis() - timer >= 1000) {
                System.out.println("FPS: " + frames);
                
                frames = 0;
                timer += 1000;
            }
        }
     
     stop();
    }
}
