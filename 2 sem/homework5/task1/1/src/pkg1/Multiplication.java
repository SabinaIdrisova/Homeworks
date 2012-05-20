package pkg1;

public class Multiplication extends Operation {
    
    public Multiplication(StringBuffer str) {
        super(str);
        this.symbol = '*';
    }
    @Override
    public int calculate() {
        return this.left.calculate() * this.right.calculate();
    }
}
