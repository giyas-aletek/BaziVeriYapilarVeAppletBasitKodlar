package hashtables;

import java.util.HashSet;

public class ArraySubSet {

    
    public static boolean isSubsetH(int arr1[], int arr2[]) 
    { 
        HashSet<Integer> hset= new HashSet<>(); 
        for(int i = 0; i <arr1.length; i++) 
        { 
            if(!hset.contains(arr1[i])) 
                hset.add(arr1[i]); 
        } 
              
        
        for(int i = 0; i < arr2.length; i++) 
        { 
            if(!hset.contains(arr2[i])) 
                return false; 
        } 
        return true; 
    }  
    
    public static boolean isSubset(int arr1[],int arr2[]) { 
        
        for (int i = 0; i < arr2.length; i++) 
        { 
            for (int j = 0; j <arr1.length; j++) 
                if(arr2[i] == arr1[j]) 
                    break; 
              
            /* If the above inner loop  
            was not broken at all then 
            arr2[i] is not present in 
            arr1[] */
            if (j == arr1.length) 
                return false; 
        } 
          
        /* If we reach here then all 
        elements of arr2[] are present 
        in arr1[] */
        return true; 
    }
    public static void main(String args[]) 
    { 
        int arr1[] = {11, 1, 13, 21, 3, 7}; 
        int arr2[] = {11, 3, 7, 1}; 
          
        int m = arr1.length; 
        int n = arr2.length; 
      
        if(isSubset(arr1, arr2)) 
            System.out.println("arr2[] is subset of arr1[] "); 
        else
            System.out.println("arr2[] is not a subset of arr1[]");  
    } 
}
