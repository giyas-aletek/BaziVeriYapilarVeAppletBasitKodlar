import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class applet2 extends Applet implements Runnable,MouseListener {
    int b=1;
    int x,y;
    int yon=1;
    @Override
    public void init(){
    x=0;
    y=0;
    setSize(400,400);
    addMouseListener(this);
    (new Thread (applet2.this)).start();
}   @Override
    public void run(){
    while(b==1){
        try {
            Thread.sleep(59);
        } catch (Exception e) {
        }
        if(x>getWidth()-65){yon=-1;}
        if(x==0){yon = 1;}
        x =x+yon*20;
        y =y+yon*20;
   repaint();
    }
    }
    @Override
    public void paint(Graphics g){
  g.setColor(Color.black);
  g.fillOval(x, y, 60, 60);}

    @Override
    public void mouseClicked(MouseEvent me) {
       
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if(me.getButton()==MouseEvent.BUTTON1){
            b=0; 
            repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
     
    }

    @Override
    public void mouseEntered(MouseEvent me) {
       
    }

    @Override
    public void mouseExited(MouseEvent me) {
      
    }
   
}
