/*
Round robin iş zamanlaması algoritmasında, işlerin büyüklükleri değişken olabilmektedir. Quantum(q) adı verilen belirli bir boyuttan büyük işlerin q büyüklüğü kadarlık kısmı tamamlanıp kalanı kuyruğun sonuna tekrar eklenmektedir. Büyüklüğü q dan küçük olan işler ise tamamlanıp kuyruktan tamamen silinir. 
İşlemci ’ye gelen işler sırasıyla 12 5 ve 18 olsun. Gelme sırasına göre işler kuyruğa eklenir. q=10 seçilirse her adımda kuyruk aşağıdaki gibi olur. 
Adım 1: 12 5 18 
Adım 2: 5 18 2 (Kuyruğun başındaki işin 10 birimi yapıldı. Kalan 2 birim kuyruğun sonuna eklendi )
Adım 3: 18 2
Adım 4: 2 8
Adım 5: 8 
Adım 6: Boş
Buna göre kuyruk sınıfını, ekleme ve silme metotlarını yazınız? Silme işleminde tamamı bitirilemeyen işlerin kuyruğa yukarıda verilen şekilde eklenmesini de gerçekleştiriniz?
*/
package odevler;

import java.util.Scanner;

public class Kuyruk { }

class Queue <T> {

    private int front;
    private int rear;
    int size;
    T[] queue;

    public Queue(int inSize) {
        size = inSize;
        queue = (T[]) new Object[size];
        front = -1;
        rear = -1;
    }

    public boolean isempty() {
        return (front == -1 && rear == -1);
    }

    public void enQueue(T value) {
        if ((rear+1)%size==front) {
            System.out.println("Full");

        } else if (isempty()) {
            front++;
            rear++;
            queue[rear] = value;

        } else {
            rear=(rear+1)%size;
            queue[rear] = value;

        }
    }
    public T deQueue(){
        
        T item = null;
        if(rear == front && rear == -1){
        System.out.println("Queue is Empty.");
        return null;
    }
    else
    {
         item = queue[front];
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
    
    
}
 class RR
{
    Scanner sc=new Scanner(System.in);
            int[] bur,rem,wai,ta;
            int size,q,b=0,t=0,flag=0;
            RR(int size){
                this.size=size;
                bur=new int[size];
                wai=new int[size];
                ta=new int[size];
                rem=new int[size];
            }
            void get(){
             for(int i=0;i<size;i++){
                System.out.print("Enter burst time of P"+(i+1)+":");
                bur[i]=rem[i]=sc.nextInt();
                }
                System.out.print("Enter quantum time:");
                q=sc.nextInt();
            }
            void round(){
                    do{
                     flag=0;
                      for(int i=0;i<size;i++){
                      if(rem[i]>=q){
                      System.out.print("P"+(i+1)+"\t");
                      for(int j=0;j<size;j++){
                      if(j==i)rem[i]=rem[i]-q;
                      else if(rem[j]>0)
                      wai[j]+=q;
                      }
                      }
                      else if(rem[i]>0){
                        System.out.print("P"+(i+1)+"\t");
                           for(int j=0;j<size;j++){
                               if(j==i)rem[i]=0;
                               else if(rem[j]>0)
                                   wai[j]+=rem[i];
                                                  }
                                      }
                                    }
                    for(int i=0;i<size;i++)
                     if(rem[i]>0)
                     flag=1;
                        }
                    while(flag==1);
                        for(int i=0;i<size;i++)
                         ta[i]=wai[i]+bur[i];
            }
            void display()
            {
                        System.out.println("\nProcess\tBurst\tWaiting\tTurnaround");
                        for(int i=0;i<size;i++)
                        {
                                    System.out.println("P"+(i+1)+"\t"+bur[i]+"\t"+wai[i]+"\t"+ta[i]);
                                    b+=wai[i];
                                    t+=ta[i];
                        }
                        System.out.println("Average waiting time:"+(b/size));
                        System.out.println("Average Turnaround time:"+(t/size));
            }
            
              public static void main(String arg[])
            {
                        Scanner s=new Scanner(System.in);
                        System.out.print("Enter the no of process:");
                        int n=s.nextInt();
                        RR obj = new RR(n);
                        obj.get();
                        obj.round();
                        obj.display();
            }
}