package Stacks;

import java.util.Arrays;

public class StackArrayDynamic<G> {
int size,top;
    Object[] ArrayStack;

    public StackArrayDynamic(int size) {
    this.size=size;
    top=-1;
    ArrayStack = new Object[size];
    }
    public void push(Object newItem){
        ensureCapacity(top+2);
        top++;
        ArrayStack[top]=newItem;
    }
    public void ensureCapacity(int minCapacity){
        int oldCapacity=ArrayStack.length;
        if (minCapacity>oldCapacity) {
           int newCapacity = oldCapacity+1;
            if(newCapacity<minCapacity)
               newCapacity = minCapacity;
            ArrayStack=Arrays.copyOf(ArrayStack,newCapacity);
        }
    }
    public G pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return null;
        }
        G  item= (G)ArrayStack[top]; 
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
