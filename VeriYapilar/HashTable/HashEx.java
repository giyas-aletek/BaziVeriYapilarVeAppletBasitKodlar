package HashTable;

class Node<G>{
    G veri;
    Node next;

    public Node(G veri) {
        this.veri=veri;
    }
    public G getVeri(){
        return veri;
    }
    public void nodunverisiyaz(){
        System.out.print(veri+" ");
    }
}
    class LL<G>{
        Node head;
        Node tail;

        public LL() {
        head = null;tail=null;
        }
        public void sonaEkle(G x){
            Node yeni = new Node(x);
            if (head==null) {
                head=yeni;
                tail=yeni;
                tail.next=null;
            }else{
                tail.next=yeni;
                tail=tail.next;
                tail.next=null;
            }
        }
        public void sil(G x){
            if (head.veri==x) {
                head=head.next;
            }
            else{
                Node temp=head;
                while (temp.next.veri!=x) {                    
                    temp =temp.next;
                }
                temp.next=temp.next.next;
            }
        }
        public void yaz(){
            
            Node temp = head;
            while (temp!=null) {                
                temp.nodunverisiyaz();
                temp= temp.next;
            }
            System.out.println("");
        }
        public boolean find1(G x){
            if (head==null) return false;
            if(head.veri==x)return true;
            Node temp = head;
            while (temp.veri!=x && temp.next!=null) {                
                temp = temp.next;
            }
            if (temp.veri==x)return true;
            
                
         return false;   
        }
        
    }
    
    
class Hash{
        LL<Integer> Liste[];
        int uzunluk;

        public Hash(int uzunluk) {
        this.uzunluk =uzunluk;
        Liste = new LL[uzunluk];
            for (int i = 0; i < uzunluk; i++) {
                Liste[i]= new LL();
            }
        }
        public boolean isSubsetH(int arr1[], int arr2[]) 
    { 
        for(int i = 0; i <arr1.length; i++) 
        { 
            if(!find(arr1[i])) 
                ekle(arr1[i]); 
        } 
              
        
        for(int i = 0; i < arr2.length; i++) 
        { 
            if(!find(arr2[i])) 
                return false; 
        } 
        return true; 
    }
        public void tumHashYaz(){
            for (int i = 0; i < uzunluk; i++) {
                System.out.print(i+".");
                Liste[i].yaz();
            }
        }
        public int HashFunc(int key){
            return key%uzunluk;
        }
        public void ekle(int x){
            int value =HashFunc(x);
            Liste[value].sonaEkle(x);
            System.out.println(x+" Eklendi");
        }
        public void delete(int x){
            int value= HashFunc(x);
            if (Liste[value].find1(x)==true) {
                Liste[value].sil(x);
            }
            else System.out.println(x+" not found");
        }
        public boolean find(int x){
            int value = HashFunc(x);
            if (Liste[value].find1(x)==true) {
                return true;
            }
            else{
                return false;
            }
        }
        
        
    }
    
    


public class HashEx {

    public static void main(String[] args) {
        Hash h = new Hash(5);
                h.ekle(5);
    }
}

