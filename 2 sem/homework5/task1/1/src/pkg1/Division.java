package pkg1;

public class Division extends Operation {
    
    public Division(StringBuffer str) {
        super(str);
        this.symbol = '/';
    }
    @Override
    public int calculate() {
        return this.left.calculate() / this.right.calculate();
    }
}
