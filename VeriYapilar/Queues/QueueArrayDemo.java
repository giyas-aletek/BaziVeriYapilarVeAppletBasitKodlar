package Queues;

import java.util.Stack;

public class QueueArrayDemo {


public static boolean CheckParentesis(String str)
{
    if (str.isEmpty())
        return true;

    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < str.length(); i++)
    {
        char current = str.charAt(i);
        if (current == '{' || current == '(' || current == '[')
        {
            stack.push(current);
        }
        if (current == '}' || current == ')' || current == ']')
        {
            if (stack.isEmpty())
                return false;
           char last = stack.peek();
            if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[')
                stack.pop();
            else 
                return false;
        }
    }

    return stack.isEmpty();
}




    public static void main(String[] args) {
        QueueArray<String> qa= new QueueArray<String>(2);
        qa.Queue("A");
        qa.Queue("B");
        qa.Queue("C");
        System.out.println(qa.DeQueue());
        System.out.println(qa.DeQueue());
        System.out.println(qa.DeQueue());
        String str = "({})";
   // System.out.println(Weekly12.parenthesisOtherMatching(str));
        }

    
}
