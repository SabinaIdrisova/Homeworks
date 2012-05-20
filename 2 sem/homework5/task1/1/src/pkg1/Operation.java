package pkg1;

public class Operation  implements TreeElement {
    
    public Operation(StringBuffer str) {
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
        if (str.charAt(0) == '(') {
            switch (str.charAt(1)) {
                case '+':
                    temp = new Addition(str);
                    break;
                case '-':
                    temp = new Substraction(str);
                    break;
                case '*':
                    temp = new Multiplication(str);
                    break;
                case '/':
                    temp = new Division(str);
                    break;
            }
        }
        else
        {
            temp = new Digit(str.charAt(0));
            str.deleteCharAt(0);
        }
        return temp;
    }
    
    @Override
    public int calculate() {
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
    
    protected char symbol;
    
    protected TreeElement left;
    
    protected TreeElement right;
}
