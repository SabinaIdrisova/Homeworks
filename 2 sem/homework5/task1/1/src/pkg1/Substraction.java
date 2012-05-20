package pkg1;

public class Substraction extends Operation {
    
    public Substraction(StringBuffer str) {
        super(str);
        this.symbol = '-';
    }
    @Override
    public int calculate() {
        return this.left.calculate() - this.right.calculate();
    }
}
