package pkg1;

public class Operation  implements TreeElement {
    
    public Operation(StringBuffer str) {
        this.symbol = str.charAt(1);
        str.delete(0, 2);
        this.left = createTreeElement(str);
        this.right = createTreeElement(str);
        str.deleteCharAt(0);             
    }
   
    /**
     * Create TreeElement (Digit or Operation)
     * @param str expression
     * @return TreeElement
     */
    public TreeElement createTreeElement(StringBuffer str) {
        while (str.charAt(0) == ' ')
            str.deleteCharAt(0);
        TreeElement temp = null;
        if (str.charAt(0) == '(')
            temp = new Operation(str);
        else
        {
            temp = new Digit(str.charAt(0));
            str.deleteCharAt(0);
        }
        return temp;
    }
    
    /**
     * Calculate value of node
     * @return value of Operation node
     */
    @Override
    public int calculate() {
        if (this.symbol == '+')
            return this.left.calculate() + this.right.calculate();
        if (this.symbol == '-')
            return this.left.calculate() - this.right.calculate();
        if (this.symbol == '*')
            return this.left.calculate() * this.right.calculate();
        if (this.symbol == '/')
            return this.left.calculate() / this.right.calculate();
        return 0;
    }
    
    /**
     * Print itself
     */
    @Override
    public void print() {
        System.out.print("(" + this.symbol + " ");
        this.left.print();
        this.right.print();
        System.out.print(")");
    }
    
    private char symbol;
    
    private TreeElement left;
    
    private TreeElement right;
}
