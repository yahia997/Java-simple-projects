import java.util.*;

public class ValidParentheses {
  public static void main(String[] args) {
    System.out.println(isValid("{[]}"));
  }
  
  public static boolean isValid(String s) {
    String open = "({[";
    String close = ")}]";
    Stack<Character> stack = new Stack<Character>();
    
    for(int i = 0; i < s.length(); i++) {
      if(open.indexOf(s.charAt(i) + "") != -1) {
        stack.push(s.charAt(i));
      }else {
        if(stack.isEmpty())
          return false;
        else if(open.indexOf(stack.peek() + "") != close.indexOf(s.charAt(i) + ""))
          return false;
        
        stack.pop();
      }
    }
    
    return stack.isEmpty() ? true : false;
  }
}