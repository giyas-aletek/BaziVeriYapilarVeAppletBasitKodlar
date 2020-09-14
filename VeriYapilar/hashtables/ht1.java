package hashtables;

import java.util.Scanner;

public class ht1 {
    public static void tasi(int n, char a,char b,char c){
        if (n==1)System.out.println(a+" --> "+b);
        else{tasi(n-1,a,c,b);tasi(1,a,b,c);tasi(n-1,c,b,a);}
        return;}
    
    public static void main(String[] args) {
        System.out.println("n");
        Scanner k = new Scanner(System.in);
        int x=k.nextInt();
        tasi(x, 'a', 'c', 'b');
    }
}
















