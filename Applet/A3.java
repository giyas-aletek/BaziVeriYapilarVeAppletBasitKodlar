
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class A3 extends Applet{
    
@Override
public void init(){
    setSize(1005,1005);
    setBackground(Color.GREEN);
    
}
public void paint(Graphics g){
    
    int x1,x2,y1,y2;
g.setColor(Color.red);
    g.drawLine(10, 20, 10, 500);
g.setColor(Color.red);
g.drawLine(50, 300, 1000, 300);

    for (double x = 0.0; x < 6.28; x=x+0.01) {
        x1= (int) (10 +(x*100));y1= 300+ (int)(Math.sin(x)*100);
        x2= (int) (10 +(x*100)+0.01);y2= 300-(int)(Math.sin(x+0.01)*100);
        g.setColor(Color.pink);
        g.drawLine(x1,y1,x2, y2);
        
        
    }
}
}
