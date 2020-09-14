
import java.util.Date;

public class T2 {
    public static void main(String[] args) {
        test t = new test();
        t.start();
    }
}

class test extends Thread{

    @Override
   
    public void run() {
        while(!Thread.currentThread().isInterrupted())
        {
            System.out.printf("Current time: %tr \n", new Date());
     try {
                Thread.sleep(1000);
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
 
        
        
        
    }
    
