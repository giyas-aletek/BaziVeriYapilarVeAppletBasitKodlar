package odevler;
public class RoundRobin {
    
}
class CQueue
{
int maxSize;
int rear;
int front;
int aQueue[];
{
    rear = -1;
    front = -1;
}
CQueue(int maxSize)
{
    this.maxSize = maxSize;
    this.aQueue = new int[maxSize];
}
void enQueue(int item)
{
    if(((rear+1) % maxSize) == front)
    {
        System.out.println("Queue is Full");
    }
    else
    {
        if (rear == front && front == -1)
        {
            front += 1;
        }
        rear = (rear+1) % maxSize;
        aQueue[rear] = item;
    }
}
void deQueue()
{
    if(rear == front && rear == -1)
    {
        System.out.println("Queue is Empty.");
    }
    else
    {
        int item = aQueue[front];
        if(rear == front)
        {
            rear = -1;
            front = -1;
        }
        else
        {
            front = (front + 1) % maxSize;
        }
        System.out.println(item + " is deQueued from the Queue");
    }
}
public static void robin(int a[],CQueue kuyruk,int q){
    for (int i = 0; i < a.length; i++) {
        kuyruk.enQueue(a[i]);
    }
    for (int i = 0; i < a.length; i++) {
        
        if (a[i]>q) {
            
        }
    }
    
}

String elementOrElements()
{
    String send = (rear == front)? (" ") :("s ");
    return send;
}

void display()
{
    int tmpfront = front;
    if(rear == front && rear == -1)
            {
                    System.out.println("Queue is Empty.");
            }
            else
    {
        System.out.println("The element"+ elementOrElements() + "on the Queue are:- ");
        for(int i=0; i<maxSize ; i++)
        {
            if(tmpfront != rear)
            {
                System.out.println(aQueue[tmpfront]);
                tmpfront = (tmpfront + 1) % maxSize;
            }
            else
            {
                System.out.println(aQueue[rear]);
                break;
            }
        }
    }
}
}
