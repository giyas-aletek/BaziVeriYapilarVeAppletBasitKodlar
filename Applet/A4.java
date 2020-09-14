
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class A4 extends Applet implements Runnable{
    public void init(){
        setSize(800, 600);
    }

    @Override
    public void paint(Graphics g) {
        for (int i = 20; i <= 800; i=i+25) {
            
        
        
            
            try {
                g.setColor(Color.red);
                g.drawString("Ali", i, 300);
                Thread.sleep(500);
                g.setColor(Color.white);
                g.drawString("Ali", i, 300);
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                
            }
            
        
        }
    }

    @Override
    public void run() {
        
    }
    
}
