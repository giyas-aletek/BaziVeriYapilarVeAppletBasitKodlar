package odevler;
import java.util.Stack;
/*
Example:
Let the given expression be “2 3 1 * + 9 -“. We scan all elements one by one.
1) Scan ‘2’, it’s a number, so push it to stack. Stack contains ‘2’
2) Scan ‘3’, again a number, push it to stack, stack now contains ‘2 3’ (from bottom to top)
3) Scan ‘1’, again a number, push it to stack, stack now contains ‘2 3 1’
4) Scan ‘*’, it’s an operator, pop two operands from stack, apply the * operator on operands, we get 3*1 which results in 3. We push the result ‘3’ to stack. Stack now becomes ‘2 3’.
5) Scan ‘+’, it’s an operator, pop two operands from stack, apply the + operator on operands, we get 3 + 2 which results in 5. We push the result ‘5’ to stack. Stack now becomes ‘5’.
6) Scan ‘9’, it’s a number, we push it to the stack. Stack now becomes ‘5 9’.
7) Scan ‘-‘, it’s an operator, pop two operands from stack, apply the – operator on operands, we get 5 – 9 which results in -4. We push the result ‘-4’ to stack. Stack now becomes ‘-4’.
8) There are no more elements to scan, we return the top element from stack (which is the only element left in stack).
*/

/*
 * 
Algorithm
1. Scan the infix expression from left to right.
2. If the scanned character is an operand, output it.
3. Else,
…..3.1 If the precedence of the scanned operator is greater than the precedence of the operator in the stack(or the stack is empty), push it.
…..3.2 Else, Pop the operator from the stack until the precedence of the scanned operator is less-equal to the precedence of the operator residing on the top of the stack. Push the scanned operator to the stack.
4. If the scanned character is an ‘(‘, push it to the stack.
5. If the scanned character is an ‘)’, pop and output from the stack until an ‘(‘ is encountered.
6. Repeat steps 2-6 until infix expression is scanned.
7. Pop and output from the stack until it is not empty.

 */
public class InfixToPostFixEvalution {

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '(' || c == ')';
    }

    private static int getPrecedence(char ch) {
        switch (ch) {
        case '+':
        case '-':
            return 1;

        case '*':
        case '/':
            return 2;

        case '^':
            return 3;
        }
        return -1;
    }

    // A utility function to check if the given character is operand
    private static boolean isOperand(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')||(ch >= '0' && ch <= '9');
    }

    public static String convertToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        String postfix ="";
        char c;

        for (int i = 0; i < infix.length(); i++) {
            c = infix.charAt(i);

            if (isOperand(c)) {
                postfix+=c;
            } else if (c == '(') {
                stack.push(c);
            }
            // If the scanned character is an ‘)’, pop and output from the stack
            // until an ‘(‘ is encountered.
            else if (c == ')') {

                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix+=(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(')
                    return null;
                else if(!stack.isEmpty())
                    stack.pop();
            }
            else if (isOperator(c)) // operator encountered
            {
                if (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) {
                    postfix+=(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix+=(stack.pop());
        }
        return postfix;
    }
    public static String convertToPrefix(String infix) {
        Stack<Character> stack = new Stack<>();
        String prefix ="";
        char c;

        for (int i = infix.length()-1; i >=0 ; i--) {
            c = infix.charAt(i);

            if (isOperand(c)) {
                prefix+=c;
            } else if (c == ')') {
                stack.push(c);
            }
            // If the scanned character is an ‘)’, pop and output from the stack
            // until an ‘(‘ is encountered.
            else if (c == '(') {

                while (!stack.isEmpty() && stack.peek() != ')') {
                    prefix+=(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != ')')
                    return null;
                else if(!stack.isEmpty())
                    stack.pop();
            }
            else if (isOperator(c)) // operator encountered
            {
                if (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) {
                    prefix+=(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            prefix+=(stack.pop());
        }
        String s ="";
        for (int i = prefix.length()-1; i >= 0; i--) {
           s+=prefix.charAt(i);
        }
        return s;
    }
    public static int hesapla(String exp){
         Stack<Integer> stack=new Stack<>(); 
         char c;
        // Scan all characters one by one 
        for(int i=0;i<exp.length();i++) 
        { 
            c=exp.charAt(i); 
              
            // If the scanned character is an operand (number here), 
            // push it to the stack. 
            if(isOperand(c)) 
            stack.push(c - '0'); 
              
            //  If the scanned character is an operator, pop two 
            // elements from stack apply the operator 
            else
            { 
                int val1 = stack.pop(); 
                int val2 = stack.pop(); 
                  
                switch(c) 
                { 
                    case '+': 
                    stack.push(val2+val1); 
                    break; 
                      
                    case '-': 
                    stack.push(val2- val1); 
                    break; 
                      
                    case '/': 
                    stack.push(val2/val1); 
                    break; 
                      
                    case '*': 
                    stack.push(val2*val1); 
                    break; 
              } 
            } 
        } 
        return stack.pop();     
    }
     static int evaluatePostfix(String exp) 
    { 
        //create a stack 
        Stack<Integer> stack = new Stack<>(); 
          
        // Scan all characters one by one 
        for(int i = 0; i < exp.length(); i++) 
        { 
            char c = exp.charAt(i); 
              
            if(c == ' ') 
            continue; 
              
            // If the scanned character is an operand  
            // (number here),extract the number 
            // Push it to the stack. 
            else if(isOperand(c)) 
            { 
                int n = 0; 
                  
                //extract the characters and store it in num 
                while(isOperator(c)) 
                { 
                    n = n*10 + (int)(c-'0'); 
                    i++; 
                    c = exp.charAt(i); 
                } 
                i--; 
  
                //push the number in stack 
                stack.push(n); 
            } 
              
            // If the scanned character is an operator, pop two 
            // elements from stack apply the operator 
            else
            { 
                int val1 = stack.pop(); 
                int val2 = stack.pop(); 
                  
                switch(c) 
                { 
                    case '+': 
                    stack.push(val2+val1); 
                    break; 
                      
                    case '-': 
                    stack.push(val2- val1); 
                    break; 
                      
                    case '/': 
                    stack.push(val2/val1); 
                    break; 
                      
                    case '*': 
                    stack.push(val2*val1); 
                    break; 
            } 
            } 
        } 
        return stack.pop();  
    } 

    public static void main(String[] args) {
//        System.out.println(convertToPostfix("a+b*(c^d-e)^(f+g*h)-i"));
         // System.out.println(convertToPostfix("10+((3*5)/(16-4))"));
//        System.out.println(convertToPostfix("(a+b)*c-(d-e)*(f+g)"));
//        System.out.println(convertToPrefix("(a+b)*c-(d-e)*(f+g)"));
//        System.out.println(hesapla(convertToPostfix("10+((3*5)/(16-11))")));
//        abcd^e-fgh*+^i-*+
//        62/3-42*+
       // String x =convertToPostfix("9+((3*5)/(6-1))");
     //   System.out.println(x);
        System.out.println(convertToPostfix("9+((3*5)/(6-1))"));   
        System.out.println(convertToPrefix("9+((3*5)/(6-1))"));   
     System.out.println(hesapla(convertToPostfix("9+((3*5)/(6-1))")));
        
        

    }
}