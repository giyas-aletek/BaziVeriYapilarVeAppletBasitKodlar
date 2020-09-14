package Stacks;

public class StackArray<G> {

    int size,top;
    Object[] ArrayStack;

    public StackArray(int size) {
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
