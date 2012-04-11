package hw4t2;

public class Calculator {
    
    public Calculator(StackInterface stack) {
        this.stack = stack;
    }
    
    /**
     * 
     * @param value firstValue
     * @param symbol sign
     */
    public void makeOperation(int value, char symbol) {
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
    
    /**
     * 
     * @param symbol symbol
     */
    public void addNumber(char symbol) {
        int value = symbol - '0';
        stack.push(value);
    }
    
    /**
     * 
     * @param symbol symbol
     */
    public void getResult(char symbol) {
        int temp = stack.top();
        stack.pop();
        makeOperation(temp, symbol); 
    }
    
    private StackInterface stack;
}
