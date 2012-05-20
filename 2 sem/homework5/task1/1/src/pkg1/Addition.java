package pkg1;

public class Addition extends Operation {
    
    public Addition(StringBuffer str) {
        super(str);
        this.symbol = '+';
    }
    @Override
    public int calculate() {
        return this.left.calculate() + this.right.calculate();
    }
}
