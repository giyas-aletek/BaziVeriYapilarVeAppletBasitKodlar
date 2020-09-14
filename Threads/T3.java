public class T3 {
public static void main(String[] args) {
   a w = new a();
   w.start();
}
    }
   



class a extends Thread{

    @Override
    public void run() {
        
        try {
            
            System.out.println("Ghiath");
            Thread.sleep(4000);
            System.out.println("Aletek");
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
                System.out.println(ex);
        }}}
