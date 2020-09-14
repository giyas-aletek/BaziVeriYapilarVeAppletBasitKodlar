import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class A1 extends Applet implements Runnable{
int y=35;
    public void paint(Graphics g){
  super.paint(g);
        g.drawLine(10, 125, 500, y);
        if(y==35){
            g.setColor(Color.yellow);
             g.fillOval(500,10,50,50);
        }
        else{ g.fillOval(500,10,50,50);}
        g.setColor(Color.black);
        
        if(y==95){g.setColor(Color.yellow);
            g.fillOval(500,70,50,50);
        }
        else{
            g.fillOval(500,70,50,50);
        }
        g.setColor(Color.black);
        if(y==155){
            g.setColor(Color.YELLOW);
        g.fillOval(500,130,50,50);
        }
        else{g.fillOval(500,130,50,50);}
        g.setColor(Color.black);
        if(y==215){
            g.setColor(Color.yellow);
        g.fillOval(500,190,50,50);
        }
        else{
         g.fillOval(500,190,50,50);
        }
               
           
    }
    public void init(){
        setSize(600,300);
    
    
  (new Thread (A1.this)).start();
    
    }
    
    @Override
    public void run() {
        while(true){
       try{Thread.sleep(1000);
       } catch (Exception e) {
        }
       y=y+60;System.out.println(y);
       repaint();
       if(y==215)break;
        }
    }
    }
    

