package hashtables;

class Node{
    int veri;Node next;

    public Node(int veri) {
        this.veri = veri;
    }
    public int getVeri(){
        return veri;
    }
    public void nodunverisiyaz(){
        System.out.print(veri+" ");
    }
}
    class BListe{
        Node head;
        Node tail;

        public BListe() {
        head = null;tail=null;
        }
        public void sonaEkle(int x){
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
        public void sil(int x){
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
        public boolean find1(int x){
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
        BListe Liste[];
        int uzunluk;

        public Hash(int uzunluk) {
        this.uzunluk =uzunluk;
        Liste = new BListe[uzunluk];
            for (int i = 0; i < uzunluk; i++) {
                Liste[i]= new BListe();
            }
        }
        public boolean isSubsetH(int arr1[], int arr2[]){ 
        
            for(int i = 0; i <arr1.length; i++) { 
            if(!find(arr1[i])) 
                ekle(arr1[i]); 
            } 
              
        
        for(int i = 0; i < arr2.length; i++) { 
            if(!find(arr2[i])) 
                return false; 
        } 
        return true; 
        }
        public void tumHashYaz(){
            for (int i = 0; i < uzunluk; i++) {
                Liste[i].yaz();
            }
        }
        public int HashFunc(int key){
            return key%uzunluk;
        }
        public void ekle(int x){
            int value =HashFunc(x);
            Liste[value].sonaEkle(x);
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
    
    



public class NewClass3 {
    public static void main(String[] args) {
        
       Hash h = new Hash(5);
       h.ekle(66);
       h.ekle(33);
       h.ekle(12);
       h.ekle(14);
        int arr1[] = {11, 1, 13, 21, 3, 7}; 
        int arr2[] = {11, 3, 7, 11};
        System.out.println(h.isSubsetH(arr1, arr2));
        
    }
    
}
