
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class Cos extends Applet{
    public void init(){
        setBackground(Color.BLACK);
        setSize(800, 800);
    }
    public void paint(Graphics g){
    double x1,y1,x2,y2;
    g.setColor(Color.CYAN);
    g.drawLine(50, 0, 50,800 );
    g.setColor(Color.CYAN);
    g.drawLine(50, 400, 750,400 );
        for (double i = 0.0; i < 6.28; i=i+0.01) {
            x1=  (50 +(i*150));y1= 400+ (Math.cos(i)*100);
            x2= (50 +(i*150));y2= 400- (Math.cos(i)*100);
            g.setColor(Color.red);
            g.drawLine((int)x1,(int) y1,(int) x2, (int)y2);
        }
    }
}