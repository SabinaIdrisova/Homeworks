package hw3t4;

public class HashFunction2 implements InterfaceOfHashFunction {
    
    @Override
    public int hashFunction(String str, int hashLength) {
        char[] word = new char[str.length()];
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            word[i] = str.charAt(i);
            if ((word[i] >= 'A' && word[i] <= 'Z') || (word[i] >= 'a' && word[i] <= 'z'))
                    result = (result + word[i]) % hashLength;
        }
        return result;   
    }  
}
