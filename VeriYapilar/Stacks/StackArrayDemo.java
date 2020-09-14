package Stacks;

public class StackArrayDemo {
    int  kap;
     int []w =new int[kap];

    public StackArrayDemo(int kap) {
        this.kap = kap;
    }
    
    
    public static void main(String[] args) {
        
        
        StackArrayDynamic<Integer> q =new StackArrayDynamic<>(2);
        q.push(5);
        q.push(6);
        System.out.println(q.ArrayStack.length);
        q.push(6);
        System.out.println(q.ArrayStack.length);
        q.push(10);
        System.out.println(q.ArrayStack.length);
        q.push(53);
        System.out.println(q.ArrayStack.length);
        Object a='5';
        char c =(char)a;
         StackArrayDemo x=new StackArrayDemo (2);
       x.w[0] =6;
       x.w[1] =6;
       x.kap=3;
       x.w[2] =6;
        
        
        
    }
}
