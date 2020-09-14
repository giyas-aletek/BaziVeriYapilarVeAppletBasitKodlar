import java.util.Scanner;
public class t1 extends Thread{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Test et = new Test();
        int num1;         
        int num2;         
        int userAnswer;   
        int operationsCounter = 0;
        int correctAnswersCounter = 0;
        int wrongAnswersCounter = 0;  
 
        et.start();
        System.out.println("---------- Quiz ---------");
        while(et.isAlive())
        {
            num1 = (int)(Math.random()*10);  
            num2 = (int)(Math.random()*10);  
 
            System.out.print(num1+" + "+num2+" = ");
            userAnswer = input.nextInt();          
 
            if(userAnswer == num1+num2)            
                correctAnswersCounter++;
 
            else                                   
                wrongAnswersCounter++;
 
            operationsCounter++;                   
        }
 
        System.out.println("Time end..\n");
 
        
        System.out.println("--------- Result --------");
        System.out.println("Number of operations:      " +operationsCounter);
        System.out.println("Number of correct answers: " +correctAnswersCounter);
        System.out.println("Number of wrong answers:   " +wrongAnswersCounter);
    }
     }       




class Test extends Thread{
    @Override
    public void run() {
 
        try {
            Thread.sleep(20000);
        }
        catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
    } 
}
