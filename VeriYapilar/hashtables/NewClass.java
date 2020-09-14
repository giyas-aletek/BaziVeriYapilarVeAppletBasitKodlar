package hashtables;
public class NewClass {
    public static void main(String[] args) {
        HashTableArray<String> hash = new HashTableArray<>(10);
        hash.put(43, "ali");
        System.out.println(hash.get(43));
        hash.put(44, "veli");
        System.out.println(hash.get(3));
        hash.put(45, "Ghiath");
        System.out.println(hash.get(43));
        hash.put(46, "Aletek");
        System.out.println(hash.get(3));
        
    }
    
    
    
}
class Entry<T>{
    int key;
    T value;
    Entry next;

    public Entry(int key, T value) {
        this.key = key;
        this.value = value;
        next = null;
    }

    public Entry() {
    next=null;
    }
    
    public int getKey(){
        return key;
    }
    public T getValue(){
        return value;
    }
    
}
class HashTableArray<T>{
        int size;
        Entry[] arrayHash;
    public HashTableArray(int size) {
        this.size = size;
        arrayHash = new Entry[size];
        for (int i = 0; i < arrayHash.length; i++) 
            arrayHash[i]= new Entry<T>();
        
    }
    int getHash(int key){
        return key%size;
    }
    public void put(int key,T value){
        int index=getHash(key);
        Entry arrayValue = arrayHash[index];
        Entry newItem = new Entry<T>(key,value);
        newItem.next=arrayValue.next;
        arrayValue.next=newItem;
    }
    public T get(int key){
        T value=null;
        int index = getHash(key);
        Entry arrayValue=arrayHash[index];
        while (arrayValue.next!=null) {            
            if (arrayValue.getKey()==key) {
                value = (T)arrayValue.getValue();
                break;
            }
            arrayValue=arrayValue.next;
        }
        
        return value;
    }
    
    
}

