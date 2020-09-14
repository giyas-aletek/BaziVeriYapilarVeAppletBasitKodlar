
import java.applet.Applet;
import java.awt.Graphics;

public class A7 extends Applet{

    @Override
    public void init(){
        
    }
    @Override
    public void paint(Graphics g) {
    int x1,x2,y1,y2;
        for (double x = 0.0; x < 6.28; x=x+0.01) {
            x1=(int)(400+x);
            x2=(int)(400+(x+0.01));
            y1=(int)(300- ( 10*Math.sin(x)));
            y2=(int)(300- ( 10*Math.sin(x)));
           g.drawLine(x1, y1, x2, y2);
        }
        g.drawLine(0, 300, 500, 300);
        g.drawLine(400, 0, 400, 300);
    }

    
}
