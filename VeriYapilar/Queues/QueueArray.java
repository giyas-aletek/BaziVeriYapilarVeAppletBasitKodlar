package Queues;
public class QueueArray<G> {

Object[] ArrayQueue;
int Rear,Front,size;

    public QueueArray(int size) {
        this.size=size;
        ArrayQueue = new Object[size];
        Front =-1;
        Rear=-1;
    }
    public void Queue(Object newItem){
        if (isFull()) {
            System.out.println("The Queue is Full");
            return;}
        Rear++;
        ArrayQueue[Rear]=newItem;
        if(Front ==-1)Front=0;
    }
    public G DeQueue(){
        if (isEmpty()) {
            System.out.println("The Queue is Empty");return null;
        }
        G Del=(G) ArrayQueue[Front];
        Front++;
        return Del;
    }
    public boolean isFull(){
        return(Rear==size-1);
    }
    public boolean isEmpty(){
        return(Front==-1||Front>Rear);//(Rear==Front)
    }

    

}
