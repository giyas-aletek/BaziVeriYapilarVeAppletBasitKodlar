package odevler;
/*
  BMÜ-221 Veri Yapıları
                                                               ÖDEV-3
1.	String olarak alınan bir infix ifade için yığıt kullanılarak aşağıdaki işlemler yapılacaktır. 
-	Verilen infix ifadeyi postfix’e dönüştüren metodu yazınız.
-	Verilen infix ifadeyi prefix’e dönüştüren metodu yazınız.
-	Hesaplanan postfix ifadenin sonucunu hesaplayan metodu yazınız.
2.	N uzunluktaki bir dizi üzerinde iki tane yığıt yapısı kurulmak istenmektedir. 
Y adlı yığıt dizisinin Y[0] elemanı birinci yığıt için, Y[N-1] elemanı da ikinci Yığıt için G/Ç uçlarıdır.
İki yığıta konulacak toplam eleman sayısı N olup ilgili gözleri iki yığıt tarafından da boş olduğu sürece
kullanılabilir. Yığıtın dolu olması için tüm gözlerin dolu olması gerekir. 
Bir yığıtın boşalttığı bellek gözünü diğer yığıt kullanabilir. Bu 
yapıdaki Yığıt için gerekli veri yapısını tanımlayarak Yığıt işlemlerini gerçekleştiren kodları yazınız. 
*/
class TwoStacks 
{ 
    int size; 
    int top1, top2; 
    int arr[]; 
   
    TwoStacks(int n) 
    { 
        arr = new int[n]; 
        size = n; 
        top1 = -1; 
        top2 = size; 
    }
    public boolean isFull(){
        return(top1==top2-1);
        
    }
    
    public boolean isEmpty(){
        return(top1==-1 && top2==size);
    }
  
    // Method to push an element x to stack1 
    void push1(int x) 
    { 
        if (isFull()) {
            System.out.println("Stack 1 is Full");
            return;
        }
        if (top1 < top2 - 1) 
         { 
            top1++; 
            arr[top1] = x; 
        } 
        else
        { 
            System.out.println("Stack Overflow"); 
            System.exit(1); 
        } 
    } 
  
    // Method to push an element x to stack2 
    void push2(int x) 
    { 
        if (isFull()) {
            System.out.println("Stack 2 is Full");
            return;
        }
        if (top1 < top2 -1) 
        { 
            top2--; 
            arr[top2] = x; 
        } 
        else
        { 
            System.out.println("Stack Overflow"); 
            System.exit(1); 
        } 
    } 
  
    // Method to pop an element from first stack 
    int pop1() 
    { 
        if (top1 >= 0) 
        { 
            int x = arr[top1]; 
            top1--; 
            return x; 
        } 
        else
        { 
            System.out.println("Stack Underflow"); 
            System.exit(1); 
        } 
        return 0; 
    } 
  
    // Method to pop an element from second stack 
    int pop2() 
    { 
        if(top2 < size) 
        { 
            int x =arr[top2]; 
            top2++; 
            return x; 
        } 
        else
        { 
            System.out.println("Stack Underflow"); 
            System.exit(1); 
  
        } 
        return 0; 
    } 
  
    // Driver program to test twoStack class 
     
} 

public class GG {
    public static void main(String args[]) 
    { 
        TwoStacks ts = new TwoStacks(5); 
        ts.push1(5); 
        ts.push2(10); 
        ts.push2(15); 
        ts.push1(11); 
        ts.push2(7); 
        System.out.println("Popped element from" + 
                           " stack1 is " + ts.pop1()); 
        ts.push2(40); 
        System.out.println("Popped element from" + 
                         " stack2 is " + ts.pop2()); 
    }
}
