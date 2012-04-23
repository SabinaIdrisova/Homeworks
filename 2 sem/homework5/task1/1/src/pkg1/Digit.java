package pkg1;

public class Digit implements TreeElement {
    
    public Digit(char c) {
        int val = c - '0';
        this.value = val;
    }
    
    /**
     * Calculate value of node
     * @return value of Digit node
     */
    @Override
    public int calculate() {
        return value;
    }
    
    /**
     * Print itself
     */
    @Override
    public void print() {
        System.out.print(value + " ");
    }
    
    private int value;
}
