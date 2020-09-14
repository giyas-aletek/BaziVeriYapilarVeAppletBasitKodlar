package odevler;

public class RoundR {
    
}

class queue {

   int front;
   int rear;
   int size;
   int[] qu;

    public queue(int inSize) {
        size = inSize;
        qu =  new int[size];
        front = -1;
        rear = -1;
    }
//    void round(){
//        if(qu[front]>=10){
//            qu[front]=(qu[front])-10;
//        int temp = qu[front++];
//         if(front==size) front=0;
//         rear--;
//         enQueue(temp);
//        }
//         else{
//            deQueue();
//                 }
//        }

    public boolean isempty() {
        return (front == -1 && rear == -1);
    }

    public void enQueue(int value) {
        if ((rear+1)%size==front) {
            System.out.println("Full");

        } else if (isempty()) {
            front++;
            rear++;
            qu[rear] = value;

        } else {
            rear=(rear+1)%size;
            qu[rear] = value;

        }
    }

    public int deQueue(){
        
        int item;
        if(front ==-1 && rear == -1){
        System.out.println("Queue is Empty.");
        return -1;
    }
    else
    {
         item = qu[front];
        if(rear == front)
        {
            rear = -1;
            front = -1;
        }
        else
        {
            front = (front + 1) % size;
        }
        
    }
        
        return item;
}
    
    public  void rr(int q){
        int x =0;

        while (!isempty()) {            
            if (qu[front]>q) {
                
                x = qu[front]-q;
//                qu[front] =qu[front]-q;
            deQueue();
                enQueue(x);
                
                
            }
            else{
                deQueue();
                
            }
        goster();
        }
        
    }
    public void goster(){
        int i=front;
        while (i !=rear) {            
            if (i==size) {
                System.out.print(qu[i]+" ");
                i=0;
                System.out.print(qu[i]+" ");
                
            }
            System.out.print(qu[i]+" ");
            i++;
        }
        System.out.println("");
    }
//    public void goster(){
//        for (int i = 0; i < qu.length; i++) {
//            System.out.print(qu[i]+" ");
//        }
//        System.out.println("");
//    }
    
    public static void main(String[] args) {
        queue a = new queue(3);
        a.enQueue(12);
        a.enQueue(5);
        a.enQueue(18);
        //System.out.println(a.deQueue());
        //System.out.println(a.deQueue());
        //System.out.println(a.deQueue());
        a.rr(10);
    }
    
    
    
}