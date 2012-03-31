
package hw3t4;

public class HashFunction1 implements InterfaceOfHashFunction {
    
    @Override
    public int hashFunction(String str, int hashLength) {
        return str.hashCode() % hashLength;
    }
    
}
