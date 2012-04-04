package hw4t2;

import java.util.Scanner;

public class Main {
    
    /**
     * 
     * @param symbol symbol
     * @return true if symbol is sign, else false
     */
    public static boolean isSign(char symbol) {
        return symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/';
    }
    
    /**
     * 
     * @param stack stack
     * @param value firstValue
     * @param symbol sign
     */
    public static void makeOperation(StackInterface stack, int value, char symbol) {
        int secondValue = stack.top();
        stack.pop();
        if (symbol == '+') 
            stack.push(secondValue + value);
        else if (symbol == '-')
            stack.push(secondValue - value);
        else if (symbol == '*')
            stack.push(secondValue * value);
        else if (symbol == '/')
            stack.push(secondValue / value);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите выражение в постфиксной форме");
        String str = in.nextLine();
        char[] expression = new char[str.length()];
        StackInterface stack = new ListStack();//ArrayStack()
        for (int i = 0; i < str.length(); i++) {
            expression[i] = str.charAt(i);
            if (!isSign(expression[i])) {
                int value = expression[i] - '0';
                stack.push(value);
            }
            else {
                int temp = stack.top();
                stack.pop();
                makeOperation(stack, temp, expression[i]);
            }     
        }   
        System.out.println("result = " + stack.top());
    }
}
