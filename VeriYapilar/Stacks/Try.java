package Stacks;

public class Try {
    public static void main(String[] args) {
        Object a = "asfa"+3;
        System.out.println(a);
        String q = (String) a;
        
        ss s = new ss(4);
        s.push(55);
        s.push(45);
        int x = (int)s.ArrayStack[0]+(int)s.ArrayStack[1];
        System.out.println(x);
    }
}
class ss{

int size,top;
    Object[] ArrayStack;

    public ss(int size) {
    this.size=size;
    top=-1;
    ArrayStack = new Object[size];
    }
    public void push(Object newItem){
        if(isFull()){
            System.out.println("Stack is Full");
            return;  }
        top++;
        ArrayStack[top]=newItem;
    }
    public Object pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return null;
        }
        Object  item= ArrayStack[top]; 
        top--;
        return(item);
    }
    public boolean isFull(){
        return(top==size-1);
    }
    public boolean isEmpty(){
        return(top==-1);
    }
}