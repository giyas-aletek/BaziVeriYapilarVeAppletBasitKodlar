package odevler;
public class Queue2 {
int array[];
int size;

Queue2(int capacity){
array = new int[capacity];
}

void enqueue(int data){
if( size == array.length)
throw new QueueException("full");
else{
array[size] = data;
size++;
}
}

boolean isEmpty(){
return size == 0;
}

int size(){
return size;
}

int front(){
if( size == 0)
throw new QueueException("bos");
return array[0];
}

int dequeue(){

if( size == 0)
throw new QueueException("bos");

else{
int temp = array[0];
for (int i = 0; i < size-1; i++) {
array[i] = array[i+1];
}
size–-;
return temp;
}
}

void printQueue(){
if( size == 0)
System.out.println("Bos");
for (int i = 0; i < size; i++) {
System.out.print( array[i] +" ");
}
}

class QueueException extends RuntimeException{
QueueException(String message){
super(message);
}
}

public static void main(String[] args) {
Queue2 kuyruk = new Queue2(3);
kuyruk.enqueue(1);
kuyruk.enqueue(2);
kuyruk.enqueue(3);
System.out.println("silinen:" + kuyruk.dequeue());
System.out.println("silinen:" + kuyruk.dequeue());

kuyruk.enqueue(4);
kuyruk.printQueue();
}
}