package odevler;

import java.util.ArrayList;
import java.util.Arrays;

public class Yigit {

    Object[] array;
    int top;
    int size;

    public Yigit(int cap) {
        size = cap;
        array = new Object[size];
        top = -1;
    }

    public void push(Object data) {
        ensureCapacity(top + 2);
        array[++top] = data;
    }

    public Object pop() {
        return (char) array[top--];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == size - 1);
    }

    public void display() {
        for (int i = 0; i <= top; i++) {
            System.out.print(array[i] + "->");
        }
    }

    public char peek() throws Exception {
        return (char) array[top];
    }

    public void ensureCapacity(int minCapacity) {
        int oldCapacity = array.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity + 1;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    public void balanceSymbol(String str) {
        try {
            char[] arr = str.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '[' || arr[i] == '{' || arr[i] == '(') {
                    push(arr[i]);
                } else if (arr[i] == '}' && peek() == '{') {
                    pop();
                } else if (arr[i] == ']' && peek() == '[') {
                    pop();
                } else if (arr[i] == ')' && peek() == '(') {
                    pop();
                } else {
                    push(arr[i]);
                    break;
                }
            }
            if (isEmpty()) {
                System.out.println("parantezler eşli olup doğru sırada parantezler açılmıştır");
            } else {
                System.out.println("eşli olmayıp doğru sırada açılmamıştır");
            }
        } catch (Exception e) {
            // System.out.println(e.getMessage());
            System.out.println("eşli olmayıp doğru sırada açılmamıştır");
        }

    }

    public void convert(int num) {
        while (num != 0) {
            int d = num % 2;
            push(d);
            num /= 2;
        }
    }

    public String BinaryNum(Yigit s) {
        String sayi = "";
        while (!(s.isEmpty())) {
            sayi += s.pop();
        }
        return sayi;
    }

    public static void main(String[] args) {
        
        

        System.out.println("--Parantez testi--");
        Yigit stack = new Yigit(10);
        stack.balanceSymbol("[{}{{}}{([])}]{[]}");
        
    }

}
