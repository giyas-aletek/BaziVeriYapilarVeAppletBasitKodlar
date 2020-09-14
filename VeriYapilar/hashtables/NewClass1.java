package hashtables;

import java.util.HashSet;

public class NewClass1 {
    public static boolean isSubsetH(int arr1[], int arr2[]) 
    { 
        HashSet<Integer> hset= new HashSet<>(); 
        for(int i = 0; i <arr1.length; i++) 
        { 
            if(!hset.contains(arr1[i])) 
                hset.add(arr1[i]); 
        } 
              
        // loop to check if all elements of arr2 also 
        // lies in arr1 
        for(int i = 0; i < arr2.length; i++) 
        { 
            if(!hset.contains(arr2[i])) 
                return false; 
        } 
        return true; 
    } 
    public static void main(String[] args) {
        HashMap h = new HashMap();
        h.put(10, 5);
        h.put(10, 4);
        h.put(10, 3);
        h.put(10, 2);
        h.put(10, 1);
        
    }
    
}
class LinkedHashEntry{
    private int key;
    private int value;
    private LinkedHashEntry next;

    public LinkedHashEntry(int key, int value) {
        this.key = key;
        this.value = value;
        this.next =null;
    }
    public int getValue(){return value;}
    public void setValue(int value){this.value=value;}
    public int getKey(){return key;}
    public LinkedHashEntry getNext(){return next;}
    public void setNext(LinkedHashEntry next){this.next=next;}
}
class HashMap{
    private static int TABLE_SIZE=128;
    LinkedHashEntry[] table;
    HashMap(){
        table =new LinkedHashEntry[TABLE_SIZE];
        for (int i = 0; i <TABLE_SIZE; i++) 
            table[i]=null;
        }
        public int get(int key){
            int hash=(key%TABLE_SIZE);
            if (table[hash]==null)return -1;
            else{
                LinkedHashEntry entry =table[hash];
                while (entry!=null&&entry.getKey()!=key) {                    
                    entry= entry.getNext();
                }
                if(entry ==null)return -1;
                else return entry.getValue();
            }
            
        }
        public void put(int key,int value){
            int hash = (key%TABLE_SIZE);
            if(table[hash]==null)table[hash]=new LinkedHashEntry(key, value);
            else{LinkedHashEntry entry =table[hash];
                while (entry.getNext()!=null&&entry.getKey()!=key)entry = entry.getNext();
                if(entry.getKey()==key)entry.setValue(value);
                else entry.setNext(new LinkedHashEntry(key, value));
            }
        }
        public void remove(int key){
            int hash = (key%TABLE_SIZE);
            if (table[hash]!=null) {
                LinkedHashEntry prevEntry=null;
                LinkedHashEntry entry= table[hash];
                while(entry.getNext()!=null&&entry.getKey()!=key){
                    prevEntry=entry; entry = entry.getNext();}
                if (entry.getKey()==key) {
                    if(prevEntry==null){table[hash]=entry.getNext();}
                    else prevEntry.setNext(entry.getNext());
                }
            }
        }
        
        
        
    }

