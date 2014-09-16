/* Jocelyn Bayer && Aaron Lemmon
   Testing:
   "ab(c{}de(fghi))jk" -> "Valid"
   "(a(b)c)d{e(f)}g" -> "Valid"
   "ab(c{de(fghi))jk" -> "Missing a closing curly brace at index 13."
   "(a(b))c)d{e(f)}g" -> "There is an extra closing parenthesis at index 7."
   "(a{b)c}" -> "Missing a closing curly brace at index 4."
   "}{" -> "There is an extra closing curly brace at index 0."
   "a(b(c)" -> "The ( was never closed by index 6."
   "a{b{c()" -> "The { was never closed by index 7."
   "((}" -> "Missing a closing parenthesis at index 2."
*/ 
import java.util.Stack;
public class MatchedParentheses {
    public static void main(String[] args) { 
        Stack<Character> symbols = new Stack<Character>();
        String input = args[0];
        
        int index = 0; 
        boolean isValid = true;
        String message = "";
        while (index < input.length() && isValid) {
        	char currentChar = input.charAt(index);
        	if (currentChar == '(' || currentChar == '{') {
        		symbols.push(currentChar);
        	} else if (symbols.empty()) {
        		if (currentChar == ')') {
        			isValid = false;
        			message = "There is an extra closing parenthesis at index " + index + ".";
        		} else if (currentChar == '}') {
        			isValid = false;
        			message = "There is an extra closing curly brace at index " + index + ".";
        		}	
        	} else if (currentChar == ')') {
        		if (symbols.peek() != '(') {
        			isValid = false;
        			message = "Missing a closing curly brace at index " + index + ".";
        		} else {
        			symbols.pop();	
        		}
        	} else if (currentChar == '}') {
        		if (symbols.peek() != '{') {
        			isValid = false;
        			message = "Missing a closing parenthesis at index " + index + ".";
        		} else {
        			symbols.pop();
        		}
        	}
        	index++;
        } 
        if (isValid && !symbols.empty()) {
        		isValid = false;
        		message = "The " + symbols.peek() + " was never closed by index " + index + ".";
        }
        
        System.out.println(isValid ? "valid" : "invalid");
        System.out.println(message);
    }
} 
