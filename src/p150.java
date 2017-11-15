import java.util.*;

/**
 * Created by Larry Liu on 11/14/2017.
 * 150. Evaluate Reverse Polish Notation
 */
public class p150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        for (String token: tokens) {
            if (operators.contains(token)) {
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        p150 sol = new p150();
        sol.evalRPN(new String[]{"4", "-2", "/", "2", "-3", "-", "-"});
    }
}
